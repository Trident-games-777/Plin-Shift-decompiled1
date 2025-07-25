package coil3.network.okhttp;

import coil3.PlatformContext;
import coil3.network.ConnectivityChecker;
import coil3.network.ConnectivityCheckerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: OkHttpNetworkFetcher.kt */
/* synthetic */ class OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6 extends FunctionReferenceImpl implements Function1<PlatformContext, ConnectivityChecker> {
    public static final OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6 INSTANCE = new OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6();

    OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6() {
        super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Lcoil3/PlatformContext;)Lcoil3/network/ConnectivityChecker;", 1);
    }

    public final ConnectivityChecker invoke(PlatformContext platformContext) {
        return ConnectivityCheckerKt.ConnectivityChecker(platformContext);
    }
}
