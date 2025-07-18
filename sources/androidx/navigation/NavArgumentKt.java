package androidx.navigation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0000¨\u0006\u000b"}, d2 = {"missingRequiredArguments", "", "", "", "Landroidx/navigation/NavArgument;", "isArgumentMissing", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavArgument.kt */
public final class NavArgumentKt {
    public static final List<String> missingRequiredArguments(Map<String, NavArgument> map, Function1<? super String, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "isArgumentMissing");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            NavArgument navArgument = (NavArgument) next.getValue();
            Boolean valueOf = navArgument != null ? Boolean.valueOf(navArgument.isNullable()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (!valueOf.booleanValue() && !navArgument.isDefaultValuePresent()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Collection arrayList = new ArrayList();
        for (Object next2 : linkedHashMap.keySet()) {
            if (function1.invoke((String) next2).booleanValue()) {
                arrayList.add(next2);
            }
        }
        return (List) arrayList;
    }
}
