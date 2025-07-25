package okhttp3.internal.publicsuffix;

import androidx.webkit.ProxyConfig;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PublicSuffixDatabase.kt */
public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf(ProxyConfig.MATCH_ALL_SCHEMES);
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {42};
    /* access modifiers changed from: private */
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public final String getEffectiveTldPlusOne(String str) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "domain");
        String unicode = IDN.toUnicode(str);
        Intrinsics.checkNotNullExpressionValue(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            i2 = splitDomain.size();
            i = findMatchingRule.size();
        } else {
            i2 = splitDomain.size();
            i = findMatchingRule.size() + 1;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(str)), i2 - i), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final List<String> splitDomain(String str) {
        List<String> split$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics.areEqual(CollectionsKt.last(split$default), (Object) "") ? CollectionsKt.dropLast(split$default, 1) : split$default;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r12) {
        /*
            r11 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.listRead
            boolean r0 = r0.get()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.listRead
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0016
            r11.readTheListUninterruptibly()
            goto L_0x0023
        L_0x0016:
            java.util.concurrent.CountDownLatch r0 = r11.readCompleteLatch     // Catch:{ InterruptedException -> 0x001c }
            r0.await()     // Catch:{ InterruptedException -> 0x001c }
            goto L_0x0023
        L_0x001c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0023:
            byte[] r0 = r11.publicSuffixListBytes
            if (r0 == 0) goto L_0x0117
            int r0 = r12.size()
            byte[][] r3 = new byte[r0][]
            r4 = r1
        L_0x002e:
            if (r4 >= r0) goto L_0x004b
            java.lang.Object r5 = r12.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r7 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            byte[] r5 = r5.getBytes(r6)
            java.lang.String r6 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x002e
        L_0x004b:
            r12 = r3
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            int r0 = r12.length
            r4 = r1
        L_0x0050:
            java.lang.String r5 = "publicSuffixListBytes"
            r6 = 0
            if (r4 >= r0) goto L_0x0069
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r7 = Companion
            byte[] r8 = r11.publicSuffixListBytes
            if (r8 != 0) goto L_0x005f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r8 = r6
        L_0x005f:
            java.lang.String r7 = r7.binarySearch(r8, r3, r4)
            if (r7 == 0) goto L_0x0066
            goto L_0x006a
        L_0x0066:
            int r4 = r4 + 1
            goto L_0x0050
        L_0x0069:
            r7 = r6
        L_0x006a:
            int r0 = r12.length
            if (r0 <= r2) goto L_0x0093
            java.lang.Object r0 = r12.clone()
            byte[][] r0 = (byte[][]) r0
            r4 = r0
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            int r4 = r4.length
            int r4 = r4 - r2
            r8 = r1
        L_0x0079:
            if (r8 >= r4) goto L_0x0093
            byte[] r9 = WILDCARD_LABEL
            r0[r8] = r9
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r9 = Companion
            byte[] r10 = r11.publicSuffixListBytes
            if (r10 != 0) goto L_0x0089
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r10 = r6
        L_0x0089:
            java.lang.String r9 = r9.binarySearch(r10, r0, r8)
            if (r9 == 0) goto L_0x0090
            goto L_0x0094
        L_0x0090:
            int r8 = r8 + 1
            goto L_0x0079
        L_0x0093:
            r9 = r6
        L_0x0094:
            if (r9 == 0) goto L_0x00b2
            int r12 = r12.length
            int r12 = r12 - r2
            r0 = r1
        L_0x0099:
            if (r0 >= r12) goto L_0x00b2
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r4 = Companion
            byte[] r5 = r11.publicSuffixExceptionListBytes
            if (r5 != 0) goto L_0x00a7
            java.lang.String r5 = "publicSuffixExceptionListBytes"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = r6
        L_0x00a7:
            java.lang.String r4 = r4.binarySearch(r5, r3, r0)
            if (r4 == 0) goto L_0x00af
            r6 = r4
            goto L_0x00b2
        L_0x00af:
            int r0 = r0 + 1
            goto L_0x0099
        L_0x00b2:
            r12 = 46
            if (r6 == 0) goto L_0x00d5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "!"
            r0.<init>(r3)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            char[] r4 = new char[r2]
            r4[r1] = r12
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.List r12 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r3, (char[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            return r12
        L_0x00d5:
            if (r7 != 0) goto L_0x00dc
            if (r9 != 0) goto L_0x00dc
            java.util.List<java.lang.String> r12 = PREVAILING_RULE
            return r12
        L_0x00dc:
            if (r7 == 0) goto L_0x00ef
            r3 = r7
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            char[] r4 = new char[r2]
            r4[r1] = r12
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r3, (char[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            if (r0 != 0) goto L_0x00f3
        L_0x00ef:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00f3:
            if (r9 == 0) goto L_0x0106
            r3 = r9
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            char[] r4 = new char[r2]
            r4[r1] = r12
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.List r12 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r3, (char[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            if (r12 != 0) goto L_0x010a
        L_0x0106:
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L_0x010a:
            int r1 = r0.size()
            int r2 = r12.size()
            if (r1 <= r2) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r0 = r12
        L_0x0116:
            return r0
        L_0x0117:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0023, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x0022
        L_0x0006:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x0022
        L_0x000e:
            r1 = move-exception
            goto L_0x0028
        L_0x0010:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x000e }
            r4 = 5
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0022
            goto L_0x0006
        L_0x0022:
            return
        L_0x0023:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x0028:
            if (r0 == 0) goto L_0x0031
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0031:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006c, code lost:
        r6.readCompleteLatch.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r6 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x006b }
            r1.<init>()     // Catch:{ all -> 0x006b }
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r2 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r3 = "publicsuffixes.gz"
            java.io.InputStream r2 = r2.getResourceAsStream(r3)     // Catch:{ all -> 0x006b }
            if (r2 != 0) goto L_0x001a
        L_0x0014:
            java.util.concurrent.CountDownLatch r0 = r6.readCompleteLatch
            r0.countDown()
            return
        L_0x001a:
            okio.GzipSource r3 = new okio.GzipSource     // Catch:{ all -> 0x006b }
            okio.Source r2 = okio.Okio.source((java.io.InputStream) r2)     // Catch:{ all -> 0x006b }
            r3.<init>(r2)     // Catch:{ all -> 0x006b }
            okio.Source r3 = (okio.Source) r3     // Catch:{ all -> 0x006b }
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x006b }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x006b }
            r3 = r2
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x0064 }
            int r4 = r3.readInt()     // Catch:{ all -> 0x0064 }
            long r4 = (long) r4     // Catch:{ all -> 0x0064 }
            byte[] r4 = r3.readByteArray(r4)     // Catch:{ all -> 0x0064 }
            r0.element = r4     // Catch:{ all -> 0x0064 }
            int r4 = r3.readInt()     // Catch:{ all -> 0x0064 }
            long r4 = (long) r4     // Catch:{ all -> 0x0064 }
            byte[] r3 = r3.readByteArray(r4)     // Catch:{ all -> 0x0064 }
            r1.element = r3     // Catch:{ all -> 0x0064 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0064 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x006b }
            monitor-enter(r6)     // Catch:{ all -> 0x006b }
            T r0 = r0.element     // Catch:{ all -> 0x0061 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0061 }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x0061 }
            r6.publicSuffixListBytes = r0     // Catch:{ all -> 0x0061 }
            T r0 = r1.element     // Catch:{ all -> 0x0061 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0061 }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x0061 }
            r6.publicSuffixExceptionListBytes = r0     // Catch:{ all -> 0x0061 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0061 }
            monitor-exit(r6)     // Catch:{ all -> 0x006b }
            goto L_0x0014
        L_0x0061:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006b }
            throw r0     // Catch:{ all -> 0x006b }
        L_0x0064:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x006b }
            throw r1     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            java.util.concurrent.CountDownLatch r1 = r6.readCompleteLatch
            r1.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PublicSuffixDatabase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int and;
            byte[] bArr3 = bArr;
            int length = bArr3.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = (i4 + length) / 2;
                while (i5 > -1 && bArr3[i5] != 10) {
                    i5--;
                }
                int i6 = i5 + 1;
                int i7 = 1;
                while (true) {
                    i2 = i6 + i7;
                    if (bArr3[i2] == 10) {
                        break;
                    }
                    i7++;
                }
                int i8 = i2 - i6;
                int i9 = i;
                boolean z2 = false;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        z = z2;
                        i3 = Util.and(bArr2[i9][i10], 255);
                    }
                    and = i3 - Util.and(bArr3[i6 + i11], 255);
                    if (and != 0) {
                        break;
                    }
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr2[i9].length != i10) {
                        z2 = z;
                    } else if (i9 == ((Object[]) bArr2).length - 1) {
                        break;
                    } else {
                        i9++;
                        i10 = -1;
                        z2 = true;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i12 = i8 - i11;
                        int length2 = bArr2[i9].length - i10;
                        int length3 = ((Object[]) bArr2).length;
                        for (int i13 = i9 + 1; i13 < length3; i13++) {
                            length2 += bArr2[i13].length;
                        }
                        if (length2 >= i12) {
                            if (length2 <= i12) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                                return new String(bArr3, i6, i8, charset);
                            }
                        }
                    }
                    i4 = i2 + 1;
                }
                length = i5;
            }
            return null;
        }
    }
}
