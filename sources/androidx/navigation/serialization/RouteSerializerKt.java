package androidx.navigation.serialization;

import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a&\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002\u001a.\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007*\u00020\u00132\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0002\u001a\u0001\u0010\u0015\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00070\u00062S\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e0\u0017H\u0003¢\u0006\u0002\b\u001e\u001a\u0001\u0010\u0015\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062S\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e0\u0017H\u0003¢\u0006\u0002\b\u001f\u001a\u0018\u0010 \u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007\u001a8\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007\u001a>\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0013H\u0000¨\u0006("}, d2 = {"generateRouteWithArgs", "", "T", "", "route", "typeMap", "", "Landroidx/navigation/NavType;", "(Ljava/lang/Object;Ljava/util/Map;)Ljava/lang/String;", "unknownNavTypeErrorMessage", "fieldName", "fieldType", "className", "assertNotAbstractClass", "", "Lkotlinx/serialization/KSerializer;", "handler", "Lkotlin/Function0;", "computeNavType", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/reflect/KType;", "forEachIndexed", "operation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "index", "argName", "navType", "forEachIndexedName", "forEachIndexedKType", "generateHashCode", "generateNavArguments", "", "Landroidx/navigation/NamedNavArgument;", "generateRoutePattern", "path", "isValueClass", "", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RouteSerializer.kt */
public final class RouteSerializerKt {
    public static /* synthetic */ String generateRoutePattern$default(KSerializer kSerializer, Map map, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return generateRoutePattern(kSerializer, map, str);
    }

    public static final <T> String generateRoutePattern(KSerializer<T> kSerializer, Map<KType, ? extends NavType<?>> map, String str) {
        RouteBuilder routeBuilder;
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        Intrinsics.checkNotNullParameter(map, "typeMap");
        assertNotAbstractClass(kSerializer, new RouteSerializerKt$generateRoutePattern$1(kSerializer));
        if (str != null) {
            routeBuilder = new RouteBuilder(str, kSerializer);
        } else {
            routeBuilder = new RouteBuilder(kSerializer);
        }
        forEachIndexedKType(kSerializer, map, new RouteSerializerKt$generateRoutePattern$2(routeBuilder));
        return routeBuilder.build();
    }

    public static /* synthetic */ List generateNavArguments$default(KSerializer kSerializer, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return generateNavArguments(kSerializer, map);
    }

    public static final <T> List<NamedNavArgument> generateNavArguments(KSerializer<T> kSerializer, Map<KType, ? extends NavType<?>> map) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        Intrinsics.checkNotNullParameter(map, "typeMap");
        assertNotAbstractClass(kSerializer, new RouteSerializerKt$generateNavArguments$1(kSerializer));
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        ArrayList arrayList = new ArrayList(elementsCount);
        for (int i = 0; i < elementsCount; i++) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            arrayList.add(NamedNavArgumentKt.navArgument(elementName, new RouteSerializerKt$generateNavArguments$2$1(kSerializer, i, map, elementName)));
        }
        return arrayList;
    }

    public static final <T> String generateRouteWithArgs(T t, Map<String, ? extends NavType<Object>> map) {
        Intrinsics.checkNotNullParameter(t, "route");
        Intrinsics.checkNotNullParameter(map, "typeMap");
        KSerializer serializer = SerializersKt.serializer(Reflection.getOrCreateKotlinClass(t.getClass()));
        Map<String, List<String>> encodeToArgMap = new RouteEncoder(serializer, map).encodeToArgMap(t);
        RouteBuilder routeBuilder = new RouteBuilder(serializer);
        forEachIndexedName(serializer, map, new RouteSerializerKt$generateRouteWithArgs$1(encodeToArgMap, routeBuilder));
        return routeBuilder.build();
    }

    private static final <T> void assertNotAbstractClass(KSerializer<T> kSerializer, Function0<Unit> function0) {
        if (kSerializer instanceof PolymorphicSerializer) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final NavType<Object> computeNavType(SerialDescriptor serialDescriptor, Map<KType, ? extends NavType<?>> map) {
        Object obj;
        Iterator it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (NavTypeConverterKt.matchKType(serialDescriptor, (KType) obj)) {
                break;
            }
        }
        KType kType = (KType) obj;
        NavType<?> navType = kType != null ? (NavType) map.get(kType) : null;
        if (!(navType instanceof NavType)) {
            navType = null;
        }
        if (navType == null) {
            navType = NavTypeConverterKt.getNavType(serialDescriptor);
        }
        if (Intrinsics.areEqual((Object) navType, (Object) UNKNOWN.INSTANCE)) {
            return null;
        }
        Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
        return navType;
    }

    public static final <T> int generateHashCode(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        int hashCode = kSerializer.getDescriptor().getSerialName().hashCode();
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            hashCode = (hashCode * 31) + kSerializer.getDescriptor().getElementName(i).hashCode();
        }
        return hashCode;
    }

    static /* synthetic */ void forEachIndexedKType$default(KSerializer kSerializer, Map map, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        forEachIndexedKType(kSerializer, map, function3);
    }

    private static final <T> void forEachIndexedKType(KSerializer<T> kSerializer, Map<KType, ? extends NavType<?>> map, Function3<? super Integer, ? super String, ? super NavType<Object>, Unit> function3) {
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        int i = 0;
        while (i < elementsCount) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            NavType<Object> computeNavType = computeNavType(kSerializer.getDescriptor().getElementDescriptor(i), map);
            if (computeNavType != null) {
                function3.invoke(Integer.valueOf(i), elementName, computeNavType);
                i++;
            } else {
                throw new IllegalArgumentException(unknownNavTypeErrorMessage(elementName, kSerializer.getDescriptor().getElementDescriptor(i).getSerialName(), kSerializer.getDescriptor().getSerialName(), map.toString()));
            }
        }
    }

    private static final <T> void forEachIndexedName(KSerializer<T> kSerializer, Map<String, ? extends NavType<Object>> map, Function3<? super Integer, ? super String, ? super NavType<Object>, Unit> function3) {
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        int i = 0;
        while (i < elementsCount) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            NavType navType = (NavType) map.get(elementName);
            if (navType != null) {
                function3.invoke(Integer.valueOf(i), elementName, navType);
                i++;
            } else {
                throw new IllegalStateException(("Cannot locate NavType for argument [" + elementName + ']').toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final String unknownNavTypeErrorMessage(String str, String str2, String str3, String str4) {
        return "Route " + str3 + " could not find any NavType for argument " + str + " of type " + str2 + " - typeMap received was " + str4;
    }

    public static final boolean isValueClass(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) StructureKind.CLASS.INSTANCE) && serialDescriptor.isInline() && serialDescriptor.getElementsCount() == 1;
    }
}
