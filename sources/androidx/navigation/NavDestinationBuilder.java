package androidx.navigation;

import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B!\b\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bBB\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f\u0012\u001b\u0010\r\u001a\u0017\u0012\u0004\u0012\u00020\u000f\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0010¢\u0006\u0002\b\u00110\u000e¢\u0006\u0002\u0010\u0012B+\b\u0000\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0013J)\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020)0,¢\u0006\u0002\b.H\u0007J\u0016\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0018J'\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\n2\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020)0,¢\u0006\u0002\b.J\r\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u001bJ\u001f\u00105\u001a\u00020)2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020)0,¢\u0006\u0002\b.J\u000e\u00105\u001a\u00020)2\u0006\u00108\u001a\u00020\nJ\"\u00105\u001a\u00020)\"\n\b\u0001\u00109\u0018\u0001*\u00020\u00032\u0006\u0010:\u001a\u00020\nH\b¢\u0006\u0002\b;J;\u00105\u001a\u00020)\"\n\b\u0001\u00109\u0018\u0001*\u00020\u00032\u0006\u0010:\u001a\u00020\n2\u0019\b\b\u00106\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020)0,¢\u0006\u0002\b.H\bø\u0001\u0000JA\u00105\u001a\u00020)\"\b\b\u0001\u00109*\u00020\u00032\u0006\u0010:\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H90\f2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020)0,¢\u0006\u0002\b.H\u0007J\r\u0010<\u001a\u00028\u0000H\u0014¢\u0006\u0002\u00104R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eX.¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006="}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "D", "Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "id", "", "(Landroidx/navigation/Navigator;I)V", "route", "", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/navigation/Navigator;Lkotlin/reflect/KClass;Ljava/util/Map;)V", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", "actions", "", "Landroidx/navigation/NavAction;", "arguments", "Landroidx/navigation/NavArgument;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "getId", "()I", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "getRoute", "()Ljava/lang/String;", "action", "", "actionId", "actionBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavActionBuilder;", "Lkotlin/ExtensionFunctionType;", "argument", "name", "argumentBuilder", "Landroidx/navigation/NavArgumentBuilder;", "build", "()Landroidx/navigation/NavDestination;", "deepLink", "navDeepLink", "Landroidx/navigation/NavDeepLinkDslBuilder;", "uriPattern", "T", "basePath", "deepLinkSafeArgs", "instantiateDestination", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@NavDestinationDsl
/* compiled from: NavDestinationBuilder.kt */
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;
    private final int id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;
    private final String route;
    private Map<KType, ? extends NavType<?>> typeMap;

    public NavDestinationBuilder(Navigator<? extends D> navigator2, int i, String str) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
        this.id = i;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    /* access modifiers changed from: protected */
    public final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    public final int getId() {
        return this.id;
    }

    public final String getRoute() {
        return this.route;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your NavDestination instead", replaceWith = @ReplaceWith(expression = "NavDestinationBuilder(navigator, route = id.toString())", imports = {}))
    public NavDestinationBuilder(Navigator<? extends D> navigator2, int i) {
        this(navigator2, i, (String) null);
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(Navigator<? extends D> navigator2, String str) {
        this(navigator2, -1, str);
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = kotlinx.serialization.SerializersKt.serializer(r6);
     */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavDestinationBuilder(androidx.navigation.Navigator<? extends D> r5, kotlin.reflect.KClass<?> r6, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "navigator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "typeMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            if (r6 == 0) goto L_0x0017
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.SerializersKt.serializer(r6)
            if (r0 == 0) goto L_0x0017
            int r0 = androidx.navigation.serialization.RouteSerializerKt.generateHashCode(r0)
            goto L_0x0018
        L_0x0017:
            r0 = -1
        L_0x0018:
            r1 = 0
            if (r6 == 0) goto L_0x0026
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.SerializersKt.serializer(r6)
            if (r2 == 0) goto L_0x0026
            r3 = 2
            java.lang.String r1 = androidx.navigation.serialization.RouteSerializerKt.generateRoutePattern$default(r2, r7, r1, r3, r1)
        L_0x0026:
            r4.<init>(r5, (int) r0, (java.lang.String) r1)
            if (r6 == 0) goto L_0x0053
            kotlinx.serialization.KSerializer r5 = kotlinx.serialization.SerializersKt.serializer(r6)
            java.util.List r5 = androidx.navigation.serialization.RouteSerializerKt.generateNavArguments(r5, r7)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0039:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0053
            java.lang.Object r6 = r5.next()
            androidx.navigation.NamedNavArgument r6 = (androidx.navigation.NamedNavArgument) r6
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r0 = r4.arguments
            java.lang.String r1 = r6.getName()
            androidx.navigation.NavArgument r6 = r6.getArgument()
            r0.put(r1, r6)
            goto L_0x0039
        L_0x0053:
            r4.typeMap = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestinationBuilder.<init>(androidx.navigation.Navigator, kotlin.reflect.KClass, java.util.Map):void");
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void argument(String str, Function1<? super NavArgumentBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "argumentBuilder");
        Map<String, NavArgument> map = this.arguments;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        function1.invoke(navArgumentBuilder);
        map.put(str, navArgumentBuilder.build());
    }

    public final void argument(String str, NavArgument navArgument) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(navArgument, "argument");
        this.arguments.put(str, navArgument);
    }

    public final void deepLink(String str) {
        Intrinsics.checkNotNullParameter(str, "uriPattern");
        this.deepLinks.add(new NavDeepLink(str));
    }

    public final /* synthetic */ <T> void deepLinkSafeArgs(String str) {
        Intrinsics.checkNotNullParameter(str, "basePath");
        Intrinsics.reifiedOperationMarker(4, "T");
        deepLink(str, Reflection.getOrCreateKotlinClass(Object.class), NavDestinationBuilder$deepLink$1.INSTANCE);
    }

    public final void deepLink(Function1<? super NavDeepLinkDslBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "navDeepLink");
        List<NavDeepLink> list = this.deepLinks;
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        function1.invoke(navDeepLinkDslBuilder);
        list.add(navDeepLinkDslBuilder.build$navigation_common_release());
    }

    public final /* synthetic */ <T> void deepLink(String str, Function1<? super NavDeepLinkDslBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "basePath");
        Intrinsics.checkNotNullParameter(function1, "navDeepLink");
        Intrinsics.reifiedOperationMarker(4, "T");
        deepLink(str, Reflection.getOrCreateKotlinClass(Object.class), function1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> void deepLink(java.lang.String r8, kotlin.reflect.KClass<T> r9, kotlin.jvm.functions.Function1<? super androidx.navigation.NavDeepLinkDslBuilder, kotlin.Unit> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "basePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "route"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "navDeepLink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.Map<kotlin.reflect.KType, ? extends androidx.navigation.NavType<?>> r0 = r7.typeMap
            java.lang.String r1 = "Cannot add deeplink from KClass ["
            if (r0 == 0) goto L_0x0097
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.SerializersKt.serializer(r9)
            java.util.Map<kotlin.reflect.KType, ? extends androidx.navigation.NavType<?>> r2 = r7.typeMap
            r3 = 0
            java.lang.String r4 = "typeMap"
            if (r2 != 0) goto L_0x0024
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
        L_0x0024:
            java.util.List r0 = androidx.navigation.serialization.RouteSerializerKt.generateNavArguments(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x002e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0086
            java.lang.Object r2 = r0.next()
            androidx.navigation.NamedNavArgument r2 = (androidx.navigation.NamedNavArgument) r2
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r5 = r7.arguments
            java.lang.String r6 = r2.getName()
            java.lang.Object r5 = r5.get(r6)
            androidx.navigation.NavArgument r5 = (androidx.navigation.NavArgument) r5
            if (r5 == 0) goto L_0x005b
            androidx.navigation.NavType r5 = r5.getType()
            androidx.navigation.NavArgument r6 = r2.getArgument()
            androidx.navigation.NavType r6 = r6.getType()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x005b
            goto L_0x002e
        L_0x005b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r1)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = "]. DeepLink contains unknown argument ["
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = r2.getName()
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = "]. Ensure deeplink arguments matches the destination's route from KClass"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L_0x0086:
            java.util.Map<kotlin.reflect.KType, ? extends androidx.navigation.NavType<?>> r0 = r7.typeMap
            if (r0 != 0) goto L_0x008e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x008f
        L_0x008e:
            r3 = r0
        L_0x008f:
            androidx.navigation.NavDeepLink r8 = androidx.navigation.NavDeepLinkDslBuilderKt.navDeepLink(r8, r9, r3, r10)
            r7.deepLink((androidx.navigation.NavDeepLink) r8)
            return
        L_0x0097:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r1)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = "]. Use the NavDestinationBuilder constructor that takes a KClass with the same arguments."
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestinationBuilder.deepLink(java.lang.String, kotlin.reflect.KClass, kotlin.jvm.functions.Function1):void");
    }

    public final void deepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.deepLinks.add(navDeepLink);
    }

    @Deprecated(message = "Building NavDestinations using IDs with the Kotlin DSL has been deprecated in favor of using routes. When using routes there is no need for actions.")
    public final void action(int i, Function1<? super NavActionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "actionBuilder");
        Map<Integer, NavAction> map = this.actions;
        Integer valueOf = Integer.valueOf(i);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        function1.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_release());
    }

    /* access modifiers changed from: protected */
    public D instantiateDestination() {
        return this.navigator.createDestination();
    }

    public D build() {
        D instantiateDestination = instantiateDestination();
        instantiateDestination.setLabel(this.label);
        for (Map.Entry next : this.arguments.entrySet()) {
            instantiateDestination.addArgument((String) next.getKey(), (NavArgument) next.getValue());
        }
        for (NavDeepLink addDeepLink : this.deepLinks) {
            instantiateDestination.addDeepLink(addDeepLink);
        }
        for (Map.Entry next2 : this.actions.entrySet()) {
            instantiateDestination.putAction(((Number) next2.getKey()).intValue(), (NavAction) next2.getValue());
        }
        String str = this.route;
        if (str != null) {
            instantiateDestination.setRoute(str);
        }
        int i = this.id;
        if (i != -1) {
            instantiateDestination.setId(i);
        }
        return instantiateDestination;
    }
}
