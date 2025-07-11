package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j) {
            this.mTotalMs = j;
        }

        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (uptimeMillis > this.mTotalMs) {
                return -1;
            }
            return Math.min(Math.max(uptimeMillis, 1000), this.mTotalMs - uptimeMillis);
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor executor) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }

    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock = new Object();
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        public void setExecutor(Executor executor) {
            synchronized (this.mLock) {
                this.mExecutor = executor;
            }
        }

        public void setRetryPolicy(RetryPolicy retryPolicy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = retryPolicy;
            }
        }

        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            loadInternal();
        }

        /* access modifiers changed from: package-private */
        public void loadInternal() {
            synchronized (this.mLock) {
                if (this.mCallback != null) {
                    if (this.mExecutor == null) {
                        ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                        this.mMyThreadPoolExecutor = createBackgroundPriorityExecutor;
                        this.mExecutor = createBackgroundPriorityExecutor;
                    }
                    this.mExecutor.execute(new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(this));
                }
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fetchFonts.getStatusCode() == 0) {
                    FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts != null && fonts.length != 0) {
                        return fonts[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void scheduleRetry(Uri uri, long j) {
            synchronized (this.mLock) {
                Handler handler = this.mMainHandler;
                if (handler == null) {
                    handler = ConcurrencyHelpers.mainHandlerAsync();
                    this.mMainHandler = handler;
                }
                if (this.mObserver == null) {
                    AnonymousClass1 r2 = new ContentObserver(handler) {
                        public void onChange(boolean z, Uri uri) {
                            FontRequestMetadataLoader.this.loadInternal();
                        }
                    };
                    this.mObserver = r2;
                    this.mFontProviderHelper.registerObserver(this.mContext, uri, r2);
                }
                if (this.mMainHandlerLoadCallback == null) {
                    this.mMainHandlerLoadCallback = new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda1(this);
                }
                handler.postDelayed(this.mMainHandlerLoadCallback, j);
            }
        }

        private void cleanUp() {
            synchronized (this.mLock) {
                this.mCallback = null;
                ContentObserver contentObserver = this.mObserver;
                if (contentObserver != null) {
                    this.mFontProviderHelper.unregisterObserver(this.mContext, contentObserver);
                    this.mObserver = null;
                }
                Handler handler = this.mMainHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.mMainHandlerLoadCallback);
                }
                this.mMainHandler = null;
                ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.mExecutor = null;
                this.mMyThreadPoolExecutor = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r2 != 2) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            r3 = r8.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r4 = r8.mRetryPolicy;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
            if (r4 == null) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            r4 = r4.getRetryDelay();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            if (r4 < 0) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            scheduleRetry(r1.getUri(), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
            if (r2 != 0) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            androidx.core.os.TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);
            r0 = r8.mFontProviderHelper.buildTypeface(r8.mContext, r1);
            r1 = androidx.core.graphics.TypefaceCompatUtil.mmap(r8.mContext, (android.os.CancellationSignal) null, r1.getUri());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
            if (r1 == null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
            if (r0 == null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.create(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            androidx.core.os.TraceCompat.endSection();
            r1 = r8.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r2 = r8.mCallback;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0060, code lost:
            if (r2 == null) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
            r2.onLoaded(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0065, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0069, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0074, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0075, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            androidx.core.os.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0079, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0092, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r2 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0093, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0096, code lost:
            monitor-enter(r8.mLock);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            r1 = r8.mCallback;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0099, code lost:
            if (r1 != null) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x009b, code lost:
            r1.onFailed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x009f, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r1 = retrieveFontInfo();
            r2 = r1.getResultCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createMetadata() {
            /*
                r8 = this;
                java.lang.String r0 = "fetchFonts result is not OK. ("
                java.lang.Object r1 = r8.mLock
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x00a6 }
                if (r2 != 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                return
            L_0x000b:
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                androidx.core.provider.FontsContractCompat$FontInfo r1 = r8.retrieveFontInfo()     // Catch:{ all -> 0x0093 }
                int r2 = r1.getResultCode()     // Catch:{ all -> 0x0093 }
                r3 = 2
                if (r2 != r3) goto L_0x0036
                java.lang.Object r3 = r8.mLock     // Catch:{ all -> 0x0093 }
                monitor-enter(r3)     // Catch:{ all -> 0x0093 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r4 = r8.mRetryPolicy     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x0031
                long r4 = r4.getRetryDelay()     // Catch:{ all -> 0x0033 }
                r6 = 0
                int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r6 < 0) goto L_0x0031
                android.net.Uri r0 = r1.getUri()     // Catch:{ all -> 0x0033 }
                r8.scheduleRetry(r0, r4)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x0031:
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                goto L_0x0036
            L_0x0033:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r0     // Catch:{ all -> 0x0093 }
            L_0x0036:
                if (r2 != 0) goto L_0x007a
                java.lang.String r0 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.beginSection(r0)     // Catch:{ all -> 0x0075 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r0 = r8.mFontProviderHelper     // Catch:{ all -> 0x0075 }
                android.content.Context r2 = r8.mContext     // Catch:{ all -> 0x0075 }
                android.graphics.Typeface r0 = r0.buildTypeface(r2, r1)     // Catch:{ all -> 0x0075 }
                android.content.Context r2 = r8.mContext     // Catch:{ all -> 0x0075 }
                android.net.Uri r1 = r1.getUri()     // Catch:{ all -> 0x0075 }
                r3 = 0
                java.nio.ByteBuffer r1 = androidx.core.graphics.TypefaceCompatUtil.mmap(r2, r3, r1)     // Catch:{ all -> 0x0075 }
                if (r1 == 0) goto L_0x006d
                if (r0 == 0) goto L_0x006d
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.create((android.graphics.Typeface) r0, (java.nio.ByteBuffer) r1)     // Catch:{ all -> 0x0075 }
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x0093 }
                java.lang.Object r1 = r8.mLock     // Catch:{ all -> 0x0093 }
                monitor-enter(r1)     // Catch:{ all -> 0x0093 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x0065
                r2.onLoaded(r0)     // Catch:{ all -> 0x006a }
            L_0x0065:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                r8.cleanUp()     // Catch:{ all -> 0x0093 }
                return
            L_0x006a:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                throw r0     // Catch:{ all -> 0x0093 }
            L_0x006d:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0075 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0075 }
                throw r0     // Catch:{ all -> 0x0075 }
            L_0x0075:
                r0 = move-exception
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x0093 }
                throw r0     // Catch:{ all -> 0x0093 }
            L_0x007a:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0093 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
                r3.<init>(r0)     // Catch:{ all -> 0x0093 }
                java.lang.StringBuilder r0 = r3.append(r2)     // Catch:{ all -> 0x0093 }
                java.lang.String r2 = ")"
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0093 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
                r1.<init>(r0)     // Catch:{ all -> 0x0093 }
                throw r1     // Catch:{ all -> 0x0093 }
            L_0x0093:
                r0 = move-exception
                java.lang.Object r2 = r8.mLock
                monitor-enter(r2)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r8.mCallback     // Catch:{ all -> 0x00a3 }
                if (r1 == 0) goto L_0x009e
                r1.onFailed(r0)     // Catch:{ all -> 0x00a3 }
            L_0x009e:
                monitor-exit(r2)     // Catch:{ all -> 0x00a3 }
                r8.cleanUp()
                return
            L_0x00a3:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00a3 }
                throw r0
            L_0x00a6:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.createMetadata():void");
        }
    }

    public static class FontProviderHelper {
        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, (CancellationSignal) null, fontRequest);
        }

        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public void registerObserver(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
}
