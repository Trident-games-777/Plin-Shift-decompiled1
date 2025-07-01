package coil3.network;

import coil3.network.internal.DefaultCacheStrategy;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00112\u00020\u0001:\u0003\u000f\u0010\u0011J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ0\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000eø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcoil3/network/CacheStrategy;", "", "read", "Lcoil3/network/CacheStrategy$ReadResult;", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "options", "Lcoil3/request/Options;", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/request/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "Lcoil3/network/CacheStrategy$WriteResult;", "networkResponse", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lcoil3/request/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ReadResult", "WriteResult", "Companion", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CacheStrategy.kt */
public interface CacheStrategy {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final CacheStrategy DEFAULT = new DefaultCacheStrategy();

    Object read(NetworkResponse networkResponse, NetworkRequest networkRequest, Options options, Continuation<? super ReadResult> continuation);

    Object write(NetworkResponse networkResponse, NetworkRequest networkRequest, NetworkResponse networkResponse2, Options options, Continuation<? super WriteResult> continuation);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcoil3/network/CacheStrategy$ReadResult;", "", "request", "Lcoil3/network/NetworkRequest;", "<init>", "(Lcoil3/network/NetworkRequest;)V", "response", "Lcoil3/network/NetworkResponse;", "(Lcoil3/network/NetworkResponse;)V", "getRequest", "()Lcoil3/network/NetworkRequest;", "getResponse", "()Lcoil3/network/NetworkResponse;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: CacheStrategy.kt */
    public static final class ReadResult {
        private final NetworkRequest request;
        private final NetworkResponse response;

        public final NetworkRequest getRequest() {
            return this.request;
        }

        public final NetworkResponse getResponse() {
            return this.response;
        }

        public ReadResult(NetworkRequest networkRequest) {
            this.request = networkRequest;
            this.response = null;
        }

        public ReadResult(NetworkResponse networkResponse) {
            this.request = null;
            this.response = networkResponse;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0010¢\u0006\u0004\b\u0004\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcoil3/network/CacheStrategy$WriteResult;", "", "response", "Lcoil3/network/NetworkResponse;", "<init>", "(Lcoil3/network/NetworkResponse;)V", "()V", "getResponse", "()Lcoil3/network/NetworkResponse;", "Companion", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: CacheStrategy.kt */
    public static final class WriteResult {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final WriteResult DISABLED = new WriteResult();
        private final NetworkResponse response;

        public final NetworkResponse getResponse() {
            return this.response;
        }

        public WriteResult(NetworkResponse networkResponse) {
            this.response = networkResponse;
        }

        public WriteResult() {
            this.response = null;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/network/CacheStrategy$WriteResult$Companion;", "", "<init>", "()V", "DISABLED", "Lcoil3/network/CacheStrategy$WriteResult;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: CacheStrategy.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcoil3/network/CacheStrategy$Companion;", "", "<init>", "()V", "DEFAULT", "Lcoil3/network/CacheStrategy;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: CacheStrategy.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
