package coil3.util;

import coil3.fetch.Fetcher;
import kotlin.Metadata;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H&J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil3/util/FetcherServiceLoaderTarget;", "T", "", "factory", "Lcoil3/fetch/Fetcher$Factory;", "type", "Lkotlin/reflect/KClass;", "priority", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServiceLoaderComponentRegistry.kt */
public interface FetcherServiceLoaderTarget<T> {
    Fetcher.Factory<T> factory();

    int priority() {
        return 0;
    }

    KClass<T> type();
}
