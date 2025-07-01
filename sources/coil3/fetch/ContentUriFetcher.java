package coil3.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.Uri_androidKt;
import coil3.decode.ContentMetadata;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.size.Dimension;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH@¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil3/fetch/ContentUriFetcher;", "Lcoil3/fetch/Fetcher;", "data", "Lcoil3/Uri;", "options", "Lcoil3/request/Options;", "<init>", "(Lcoil3/Uri;Lcoil3/request/Options;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isContactPhotoUri", "", "isContactPhotoUri$coil_core_release", "isMusicThumbnailUri", "isMusicThumbnailUri$coil_core_release", "newMusicThumbnailSizeOptions", "Landroid/os/Bundle;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ContentUriFetcher.kt */
public final class ContentUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public ContentUriFetcher(Uri uri, Options options2) {
        this.data = uri;
        this.options = options2;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        AssetFileDescriptor assetFileDescriptor;
        android.net.Uri androidUri = Uri_androidKt.toAndroidUri(this.data);
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        if (isContactPhotoUri$coil_core_release(this.data)) {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(androidUri, "r");
            if (assetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + androidUri + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !isMusicThumbnailUri$coil_core_release(this.data)) {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(androidUri, "r");
            if (assetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to open '" + androidUri + "'.").toString());
            }
        } else {
            assetFileDescriptor = contentResolver.openTypedAssetFile(androidUri, "image/*", newMusicThumbnailSizeOptions(), (CancellationSignal) null);
            if (assetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + androidUri + "'.").toString());
            }
        }
        return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.buffer(Okio.source((InputStream) assetFileDescriptor.createInputStream())), this.options.getFileSystem(), new ContentMetadata(this.data, assetFileDescriptor)), contentResolver.getType(androidUri), DataSource.DISK);
    }

    public final boolean isContactPhotoUri$coil_core_release(Uri uri) {
        return Intrinsics.areEqual((Object) uri.getAuthority(), (Object) "com.android.contacts") && Intrinsics.areEqual(CollectionsKt.lastOrNull(UriKt.getPathSegments(uri)), (Object) "display_photo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r5 = coil3.UriKt.getPathSegments(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMusicThumbnailUri$coil_core_release(coil3.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getAuthority()
            java.lang.String r1 = "media"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.List r5 = coil3.UriKt.getPathSegments(r5)
            int r0 = r5.size()
            r2 = 3
            if (r0 < r2) goto L_0x0037
            int r2 = r0 + -3
            java.lang.Object r2 = r5.get(r2)
            java.lang.String r3 = "audio"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0037
            int r0 = r0 + -2
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r0 = "albums"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x0037
            r5 = 1
            return r5
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.fetch.ContentUriFetcher.isMusicThumbnailUri$coil_core_release(coil3.Uri):boolean");
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension width = this.options.getSize().getWidth();
        Dimension.Pixels pixels = width instanceof Dimension.Pixels ? (Dimension.Pixels) width : null;
        if (pixels == null) {
            return null;
        }
        int r0 = pixels.m7548unboximpl();
        Dimension height = this.options.getSize().getHeight();
        Dimension.Pixels pixels2 = height instanceof Dimension.Pixels ? (Dimension.Pixels) height : null;
        if (pixels2 == null) {
            return null;
        }
        int r1 = pixels2.m7548unboximpl();
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(r0, r1));
        return bundle;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcoil3/fetch/ContentUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "<init>", "()V", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ContentUriFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!isApplicable(uri)) {
                return null;
            }
            return new ContentUriFetcher(uri, options);
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual((Object) uri.getScheme(), (Object) FirebaseAnalytics.Param.CONTENT);
        }
    }
}
