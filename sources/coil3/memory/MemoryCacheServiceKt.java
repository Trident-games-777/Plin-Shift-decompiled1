package coil3.memory;

import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.transform.Transformation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"createComplexMemoryCacheKeyExtras", "", "", "request", "Lcoil3/request/ImageRequest;", "options", "Lcoil3/request/Options;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: MemoryCacheService.kt */
public final class MemoryCacheServiceKt {
    public static final Map<String, String> createComplexMemoryCacheKeyExtras(ImageRequest imageRequest, Options options) {
        Map<String, String> memoryCacheKeyExtras = imageRequest.getMemoryCacheKeyExtras();
        if (!ImageRequests_androidKt.getTransformations(imageRequest).isEmpty()) {
            memoryCacheKeyExtras = MapsKt.toMutableMap(memoryCacheKeyExtras);
            List<Transformation> transformations = ImageRequests_androidKt.getTransformations(imageRequest);
            int size = transformations.size();
            for (int i = 0; i < size; i++) {
                memoryCacheKeyExtras.put(MemoryCacheService.EXTRA_TRANSFORMATION_INDEX + i, transformations.get(i).getCacheKey());
            }
            memoryCacheKeyExtras.put(MemoryCacheService.EXTRA_TRANSFORMATION_SIZE, options.getSize().toString());
        }
        return memoryCacheKeyExtras;
    }
}
