package coil3.request;

import coil3.memory.MemoryCache;
import coil3.size.Size;
import coil3.size.SizeResolver;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcoil3/request/RequestService;", "", "requestDelegate", "Lcoil3/request/RequestDelegate;", "request", "Lcoil3/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "findLifecycle", "", "sizeResolver", "Lcoil3/size/SizeResolver;", "options", "Lcoil3/request/Options;", "size", "Lcoil3/size/Size;", "updateOptionsOnWorkerThread", "isCacheValueValidForHardware", "cacheValue", "Lcoil3/memory/MemoryCache$Value;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RequestService.kt */
public interface RequestService {
    boolean isCacheValueValidForHardware(ImageRequest imageRequest, MemoryCache.Value value);

    Options options(ImageRequest imageRequest, SizeResolver sizeResolver, Size size);

    RequestDelegate requestDelegate(ImageRequest imageRequest, Job job, boolean z);

    SizeResolver sizeResolver(ImageRequest imageRequest);

    Options updateOptionsOnWorkerThread(Options options);
}
