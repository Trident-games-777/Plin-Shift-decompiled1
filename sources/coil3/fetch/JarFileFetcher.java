package coil3.fetch;

import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.FileSystemsKt;
import coil3.util.MimeTypeMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Okio;
import okio.Path;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcoil3/fetch/JarFileFetcher;", "Lcoil3/fetch/Fetcher;", "uri", "Lcoil3/Uri;", "options", "Lcoil3/request/Options;", "<init>", "(Lcoil3/Uri;Lcoil3/request/Options;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: JarFileFetcher.kt */
public final class JarFileFetcher implements Fetcher {
    private final Options options;
    private final Uri uri;

    public JarFileFetcher(Uri uri2, Options options2) {
        this.uri = uri2;
        this.options = options2;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        String path = this.uri.getPath();
        if (path == null) {
            path = "";
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) path, '!', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            Path.Companion companion = Path.Companion;
            String substring = path.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Path path2 = Path.Companion.get$default(companion, substring, false, 1, (Object) null);
            Path.Companion companion2 = Path.Companion;
            String substring2 = path.substring(indexOf$default + 1, path.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            Path path3 = Path.Companion.get$default(companion2, substring2, false, 1, (Object) null);
            return new SourceFetchResult(ImageSourceKt.ImageSource$default(path3, Okio.openZip(this.options.getFileSystem(), path2), (String) null, (AutoCloseable) null, (ImageSource.Metadata) null, 28, (Object) null), MimeTypeMap.INSTANCE.getMimeTypeFromExtension(FileSystemsKt.getExtension(path3)), DataSource.DISK);
        }
        throw new IllegalStateException(("Invalid jar:file URI: " + this.uri).toString());
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcoil3/fetch/JarFileFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "<init>", "()V", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: JarFileFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!isApplicable(uri)) {
                return null;
            }
            return new JarFileFetcher(uri, options);
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "jar:file");
        }
    }
}
