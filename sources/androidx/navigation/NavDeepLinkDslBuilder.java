package androidx.navigation;

import androidx.navigation.NavDeepLink;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B8\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u001b\u0010\u0007\u001a\u0017\u0012\u0004\u0012\u00020\t\u0012\r\u0012\u000b\u0012\u0002\b\u00030\n¢\u0006\u0002\b\u000b0\b¢\u0006\u0002\u0010\fJ\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR(\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavDeepLinkDslBuilder;", "", "()V", "basePath", "", "route", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/util/Map;)V", "p", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "builder", "Landroidx/navigation/NavDeepLink$Builder;", "mimeType", "getMimeType", "setMimeType", "uriPattern", "getUriPattern", "setUriPattern", "build", "Landroidx/navigation/NavDeepLink;", "build$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@NavDeepLinkDsl
/* compiled from: NavDeepLinkDslBuilder.kt */
public final class NavDeepLinkDslBuilder {
    private String action;
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
    private String mimeType;
    private KClass<?> route;
    private Map<KType, ? extends NavType<?>> typeMap = MapsKt.emptyMap();
    private String uriPattern;

    public NavDeepLinkDslBuilder() {
    }

    public NavDeepLinkDslBuilder(String str, KClass<?> kClass, Map<KType, NavType<?>> map) {
        Intrinsics.checkNotNullParameter(str, "basePath");
        Intrinsics.checkNotNullParameter(kClass, "route");
        Intrinsics.checkNotNullParameter(map, "typeMap");
        if (str.length() > 0) {
            this.uriPattern = RouteSerializerKt.generateRoutePattern(SerializersKt.serializer(kClass), map, str);
            this.route = kClass;
            this.typeMap = map;
            return;
        }
        throw new IllegalArgumentException("The basePath for NavDeepLink from KClass cannot be empty".toString());
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setUriPattern(String str) {
        this.uriPattern = str;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        if (str == null || str.length() != 0) {
            this.action = str;
            return;
        }
        throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder builder2 = this.builder;
        String str = this.uriPattern;
        if (str == null && this.action == null && this.mimeType == null) {
            throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
        }
        if (str != null) {
            builder2.setUriPattern(str);
        }
        String str2 = this.action;
        if (str2 != null) {
            builder2.setAction(str2);
        }
        String str3 = this.mimeType;
        if (str3 != null) {
            builder2.setMimeType(str3);
        }
        return builder2.build();
    }
}
