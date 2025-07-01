package coil3.request;

import coil3.Image;
import coil3.decode.DataSource;
import coil3.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcoil3/request/SuccessResult;", "Lcoil3/request/ImageResult;", "image", "Lcoil3/Image;", "request", "Lcoil3/request/ImageRequest;", "dataSource", "Lcoil3/decode/DataSource;", "memoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "diskCacheKey", "", "isSampled", "", "isPlaceholderCached", "<init>", "(Lcoil3/Image;Lcoil3/request/ImageRequest;Lcoil3/decode/DataSource;Lcoil3/memory/MemoryCache$Key;Ljava/lang/String;ZZ)V", "getImage", "()Lcoil3/Image;", "getRequest", "()Lcoil3/request/ImageRequest;", "getDataSource", "()Lcoil3/decode/DataSource;", "getMemoryCacheKey", "()Lcoil3/memory/MemoryCache$Key;", "getDiskCacheKey", "()Ljava/lang/String;", "()Z", "copy", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageResult.kt */
public final class SuccessResult implements ImageResult {
    private final DataSource dataSource;
    private final String diskCacheKey;
    private final Image image;
    private final boolean isPlaceholderCached;
    private final boolean isSampled;
    private final MemoryCache.Key memoryCacheKey;
    private final ImageRequest request;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual((Object) this.image, (Object) successResult.image) && Intrinsics.areEqual((Object) this.request, (Object) successResult.request) && this.dataSource == successResult.dataSource && Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) successResult.memoryCacheKey) && Intrinsics.areEqual((Object) this.diskCacheKey, (Object) successResult.diskCacheKey) && this.isSampled == successResult.isSampled && this.isPlaceholderCached == successResult.isPlaceholderCached;
    }

    public int hashCode() {
        int hashCode = ((((this.image.hashCode() * 31) + this.request.hashCode()) * 31) + this.dataSource.hashCode()) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int i = 0;
        int hashCode2 = (hashCode + (key == null ? 0 : key.hashCode())) * 31;
        String str = this.diskCacheKey;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((hashCode2 + i) * 31) + Boolean.hashCode(this.isSampled)) * 31) + Boolean.hashCode(this.isPlaceholderCached);
    }

    public String toString() {
        return "SuccessResult(image=" + this.image + ", request=" + this.request + ", dataSource=" + this.dataSource + ", memoryCacheKey=" + this.memoryCacheKey + ", diskCacheKey=" + this.diskCacheKey + ", isSampled=" + this.isSampled + ", isPlaceholderCached=" + this.isPlaceholderCached + ')';
    }

    public SuccessResult(Image image2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2) {
        this.image = image2;
        this.request = imageRequest;
        this.dataSource = dataSource2;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    public Image getImage() {
        return this.image;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuccessResult(Image image2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(image2, imageRequest, (i & 4) != 0 ? DataSource.MEMORY : dataSource2, (i & 8) != 0 ? null : key, (i & 16) != 0 ? null : str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2);
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public static /* synthetic */ SuccessResult copy$default(SuccessResult successResult, Image image2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            image2 = successResult.getImage();
        }
        if ((i & 2) != 0) {
            imageRequest = successResult.getRequest();
        }
        if ((i & 4) != 0) {
            dataSource2 = successResult.dataSource;
        }
        if ((i & 8) != 0) {
            key = successResult.memoryCacheKey;
        }
        if ((i & 16) != 0) {
            str = successResult.diskCacheKey;
        }
        if ((i & 32) != 0) {
            z = successResult.isSampled;
        }
        if ((i & 64) != 0) {
            z2 = successResult.isPlaceholderCached;
        }
        boolean z3 = z;
        boolean z4 = z2;
        MemoryCache.Key key2 = key;
        String str2 = str;
        return successResult.copy(image2, imageRequest, dataSource2, key2, str2, z3, z4);
    }

    public final SuccessResult copy(Image image2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2) {
        return new SuccessResult(image2, imageRequest, dataSource2, key, str, z, z2);
    }
}
