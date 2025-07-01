package coil3.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil3/network/NetworkRequest;", "", "url", "", "method", "headers", "Lcoil3/network/NetworkHeaders;", "body", "Lcoil3/network/NetworkRequestBody;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcoil3/network/NetworkHeaders;Lcoil3/network/NetworkRequestBody;)V", "getUrl", "()Ljava/lang/String;", "getMethod", "getHeaders", "()Lcoil3/network/NetworkHeaders;", "getBody", "()Lcoil3/network/NetworkRequestBody;", "copy", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: NetworkClient.kt */
public final class NetworkRequest {
    private final NetworkRequestBody body;
    private final NetworkHeaders headers;
    private final String method;
    private final String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) networkRequest.url) && Intrinsics.areEqual((Object) this.method, (Object) networkRequest.method) && Intrinsics.areEqual((Object) this.headers, (Object) networkRequest.headers) && Intrinsics.areEqual((Object) this.body, (Object) networkRequest.body);
    }

    public int hashCode() {
        int hashCode = ((((this.url.hashCode() * 31) + this.method.hashCode()) * 31) + this.headers.hashCode()) * 31;
        NetworkRequestBody networkRequestBody = this.body;
        return hashCode + (networkRequestBody == null ? 0 : networkRequestBody.hashCode());
    }

    public String toString() {
        return "NetworkRequest(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ')';
    }

    public NetworkRequest(String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody) {
        this.url = str;
        this.method = str2;
        this.headers = networkHeaders;
        this.body = networkRequestBody;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkRequest(String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "GET" : str2, (i & 4) != 0 ? NetworkHeaders.EMPTY : networkHeaders, (i & 8) != 0 ? null : networkRequestBody);
    }

    public final String getMethod() {
        return this.method;
    }

    public final NetworkHeaders getHeaders() {
        return this.headers;
    }

    public final NetworkRequestBody getBody() {
        return this.body;
    }

    public static /* synthetic */ NetworkRequest copy$default(NetworkRequest networkRequest, String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkRequest.url;
        }
        if ((i & 2) != 0) {
            str2 = networkRequest.method;
        }
        if ((i & 4) != 0) {
            networkHeaders = networkRequest.headers;
        }
        if ((i & 8) != 0) {
            networkRequestBody = networkRequest.body;
        }
        return networkRequest.copy(str, str2, networkHeaders, networkRequestBody);
    }

    public final NetworkRequest copy(String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody) {
        return new NetworkRequest(str, str2, networkHeaders, networkRequestBody);
    }
}
