package okhttp3.internal.http;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpMethod.kt */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public final boolean invalidatesCache(String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return Intrinsics.areEqual((Object) str, (Object) ShareTarget.METHOD_POST) || Intrinsics.areEqual((Object) str, (Object) "PATCH") || Intrinsics.areEqual((Object) str, (Object) "PUT") || Intrinsics.areEqual((Object) str, (Object) "DELETE") || Intrinsics.areEqual((Object) str, (Object) "MOVE");
    }

    @JvmStatic
    public static final boolean requiresRequestBody(String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return Intrinsics.areEqual((Object) str, (Object) ShareTarget.METHOD_POST) || Intrinsics.areEqual((Object) str, (Object) "PUT") || Intrinsics.areEqual((Object) str, (Object) "PATCH") || Intrinsics.areEqual((Object) str, (Object) "PROPPATCH") || Intrinsics.areEqual((Object) str, (Object) "REPORT");
    }

    @JvmStatic
    public static final boolean permitsRequestBody(String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return !Intrinsics.areEqual((Object) str, (Object) "GET") && !Intrinsics.areEqual((Object) str, (Object) "HEAD");
    }

    public final boolean redirectsWithBody(String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return Intrinsics.areEqual((Object) str, (Object) "PROPFIND");
    }

    public final boolean redirectsToGet(String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return !Intrinsics.areEqual((Object) str, (Object) "PROPFIND");
    }
}
