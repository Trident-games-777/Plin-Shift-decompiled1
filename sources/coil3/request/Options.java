package coil3.request;

import android.content.Context;
import coil3.Extras;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bo\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016Ju\u0010*\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010+R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcoil3/request/Options;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "size", "Lcoil3/size/Size;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "diskCacheKey", "", "fileSystem", "Lokio/FileSystem;", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "extras", "Lcoil3/Extras;", "<init>", "(Landroid/content/Context;Lcoil3/size/Size;Lcoil3/size/Scale;Lcoil3/size/Precision;Ljava/lang/String;Lokio/FileSystem;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/Extras;)V", "getContext", "()Landroid/content/Context;", "Landroid/content/Context;", "getSize", "()Lcoil3/size/Size;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getDiskCacheKey", "()Ljava/lang/String;", "getFileSystem", "()Lokio/FileSystem;", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getExtras", "()Lcoil3/Extras;", "copy", "(Landroid/content/Context;Lcoil3/size/Size;Lcoil3/size/Scale;Lcoil3/size/Precision;Ljava/lang/String;Lokio/FileSystem;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/Extras;)Lcoil3/request/Options;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Options.kt */
public final class Options {
    private final Context context;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Extras extras;
    private final FileSystem fileSystem;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Precision precision;
    private final Scale scale;
    private final Size size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Options)) {
            return false;
        }
        Options options = (Options) obj;
        return Intrinsics.areEqual((Object) this.context, (Object) options.context) && Intrinsics.areEqual((Object) this.size, (Object) options.size) && this.scale == options.scale && this.precision == options.precision && Intrinsics.areEqual((Object) this.diskCacheKey, (Object) options.diskCacheKey) && Intrinsics.areEqual((Object) this.fileSystem, (Object) options.fileSystem) && this.memoryCachePolicy == options.memoryCachePolicy && this.diskCachePolicy == options.diskCachePolicy && this.networkCachePolicy == options.networkCachePolicy && Intrinsics.areEqual((Object) this.extras, (Object) options.extras);
    }

    public int hashCode() {
        int hashCode = ((((((this.context.hashCode() * 31) + this.size.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31;
        String str = this.diskCacheKey;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fileSystem.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "Options(context=" + this.context + ", size=" + this.size + ", scale=" + this.scale + ", precision=" + this.precision + ", diskCacheKey=" + this.diskCacheKey + ", fileSystem=" + this.fileSystem + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", extras=" + this.extras + ')';
    }

    public Options(Context context2, Size size2, Scale scale2, Precision precision2, String str, FileSystem fileSystem2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Extras extras2) {
        this.context = context2;
        this.size = size2;
        this.scale = scale2;
        this.precision = precision2;
        this.diskCacheKey = str;
        this.fileSystem = fileSystem2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.extras = extras2;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Options(android.content.Context r10, coil3.size.Size r11, coil3.size.Scale r12, coil3.size.Precision r13, java.lang.String r14, okio.FileSystem r15, coil3.request.CachePolicy r16, coil3.request.CachePolicy r17, coil3.request.CachePolicy r18, coil3.Extras r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r9 = this;
            r0 = r20
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            coil3.size.Size r1 = coil3.size.Size.ORIGINAL
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0011
            coil3.size.Scale r2 = coil3.size.Scale.FIT
            goto L_0x0012
        L_0x0011:
            r2 = r12
        L_0x0012:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0019
            coil3.size.Precision r3 = coil3.size.Precision.EXACT
            goto L_0x001a
        L_0x0019:
            r3 = r13
        L_0x001a:
            r4 = r0 & 16
            if (r4 == 0) goto L_0x0020
            r4 = 0
            goto L_0x0021
        L_0x0020:
            r4 = r14
        L_0x0021:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x002a
            okio.FileSystem r5 = coil3.util.FileSystems_nonJsCommonKt.defaultFileSystem()
            goto L_0x002b
        L_0x002a:
            r5 = r15
        L_0x002b:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x0032
            coil3.request.CachePolicy r6 = coil3.request.CachePolicy.ENABLED
            goto L_0x0034
        L_0x0032:
            r6 = r16
        L_0x0034:
            r7 = r0 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x003b
            coil3.request.CachePolicy r7 = coil3.request.CachePolicy.ENABLED
            goto L_0x003d
        L_0x003b:
            r7 = r17
        L_0x003d:
            r8 = r0 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x0044
            coil3.request.CachePolicy r8 = coil3.request.CachePolicy.ENABLED
            goto L_0x0046
        L_0x0044:
            r8 = r18
        L_0x0046:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004f
            coil3.Extras r0 = coil3.Extras.EMPTY
            r21 = r0
            goto L_0x0051
        L_0x004f:
            r21 = r19
        L_0x0051:
            r11 = r9
            r12 = r10
            r13 = r1
            r14 = r2
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.request.Options.<init>(android.content.Context, coil3.size.Size, coil3.size.Scale, coil3.size.Precision, java.lang.String, okio.FileSystem, coil3.request.CachePolicy, coil3.request.CachePolicy, coil3.request.CachePolicy, coil3.Extras, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Size getSize() {
        return this.size;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public static /* synthetic */ Options copy$default(Options options, Context context2, Size size2, Scale scale2, Precision precision2, String str, FileSystem fileSystem2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Extras extras2, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = options.context;
        }
        if ((i & 2) != 0) {
            size2 = options.size;
        }
        if ((i & 4) != 0) {
            scale2 = options.scale;
        }
        if ((i & 8) != 0) {
            precision2 = options.precision;
        }
        if ((i & 16) != 0) {
            str = options.diskCacheKey;
        }
        if ((i & 32) != 0) {
            fileSystem2 = options.fileSystem;
        }
        if ((i & 64) != 0) {
            cachePolicy = options.memoryCachePolicy;
        }
        if ((i & 128) != 0) {
            cachePolicy2 = options.diskCachePolicy;
        }
        if ((i & 256) != 0) {
            cachePolicy3 = options.networkCachePolicy;
        }
        if ((i & 512) != 0) {
            extras2 = options.extras;
        }
        CachePolicy cachePolicy4 = cachePolicy3;
        Extras extras3 = extras2;
        CachePolicy cachePolicy5 = cachePolicy;
        CachePolicy cachePolicy6 = cachePolicy2;
        String str2 = str;
        FileSystem fileSystem3 = fileSystem2;
        Precision precision3 = precision2;
        Size size3 = size2;
        return options.copy(context2, size3, scale2, precision3, str2, fileSystem3, cachePolicy5, cachePolicy6, cachePolicy4, extras3);
    }

    public final Options copy(Context context2, Size size2, Scale scale2, Precision precision2, String str, FileSystem fileSystem2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Extras extras2) {
        return new Options(context2, size2, scale2, precision2, str, fileSystem2, cachePolicy, cachePolicy2, cachePolicy3, extras2);
    }
}
