package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.serialization.RouteDeserializerKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toRoute", "T", "Landroidx/navigation/NavBackStackEntry;", "(Landroidx/navigation/NavBackStackEntry;)Ljava/lang/Object;", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavBackStackEntry.kt */
public final class NavBackStackEntryKt {
    public static final /* synthetic */ <T> T toRoute(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "<this>");
        Bundle arguments = navBackStackEntry.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Map<String, NavArgument> arguments2 = navBackStackEntry.getDestination().getArguments();
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments2.size()));
        for (Map.Entry entry : arguments2.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall((Object) "kotlinx.serialization.serializer.simple");
        return RouteDeserializerKt.decodeArguments(SerializersKt.serializer((KType) null), arguments, (Map<String, ? extends NavType<?>>) linkedHashMap);
    }
}
