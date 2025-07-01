package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001LB\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u001f\u0010\"\u001a\u00020\u001e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010#\"\u00020\u0001¢\u0006\u0002\u0010$J\u0016\u0010\"\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\u001eJ\u0013\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010)H\u0002J\u0013\u0010*\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010+\u0018\u0001H\bJ\u001d\u0010*\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010+2\b\u0010,\u001a\u0004\u0018\u0001H+¢\u0006\u0002\u0010-J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010.\u001a\u00020\u0011J\u001a\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u00072\u0006\u0010/\u001a\u00020(H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u0007J2\u00100\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010.\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020(2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u00104\u001a\u00020\u0011H\u0007J\b\u00105\u001a\u00020\u0011H\u0016J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000107H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0017J*\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\u0006\u00102\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u00101\u001a\u00020\u0001H\u0007J*\u0010>\u001a\u0004\u0018\u0001092\u0006\u0010,\u001a\u00020\u00072\u0006\u00102\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u00101\u001a\u00020\u0001H\u0007J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u000e\u0010D\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u0015\u0010E\u001a\u00020\u001e\"\n\b\u0000\u0010+\u0018\u0001*\u00020)H\bJ\u001d\u0010E\u001a\u00020\u001e\"\b\b\u0000\u0010+*\u00020)2\u0006\u0010\u0018\u001a\u0002H+¢\u0006\u0002\u0010FJ\u000e\u0010E\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010E\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J0\u0010E\u001a\u00020\u001e\"\u0004\b\u0000\u0010+2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H+0H2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070JH\u0007J\b\u0010K\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078WX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118G@BX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001c¨\u0006M"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "navGraphNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "nodes", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "startDestDisplayName", "getStartDestDisplayName", "startDestId", "", "startDestIdName", "startDestinationId", "getStartDestinationId", "()I", "setStartDestinationId", "(I)V", "startDestRoute", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "(Ljava/lang/String;)V", "addAll", "", "other", "addDestination", "node", "addDestinations", "", "([Landroidx/navigation/NavDestination;)V", "", "clear", "equals", "", "", "findNode", "T", "route", "(Ljava/lang/Object;)Landroidx/navigation/NavDestination;", "resId", "searchParents", "findNodeComprehensive", "lastVisited", "searchChildren", "matchingDest", "getStartDestination", "hashCode", "iterator", "", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "matchDeepLinkComprehensive", "searchParent", "matchRouteComprehensive", "onInflate", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "remove", "setStartDestination", "(Ljava/lang/Object;)V", "serializer", "Lkotlinx/serialization/KSerializer;", "parseRoute", "Lkotlin/Function1;", "toString", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavGraph.kt */
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SparseArrayCompat<NavDestination> nodes = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    @JvmStatic
    public static final NavDestination findStartDestination(NavGraph navGraph) {
        return Companion.findStartDestination(navGraph);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navigator) {
        super((Navigator<? extends NavDestination>) navigator);
        Intrinsics.checkNotNullParameter(navigator, "navGraphNavigator");
    }

    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…leable.NavGraphNavigator)");
        setStartDestinationId(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.Companion.getDisplayName(context, this.startDestId);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive(String str, boolean z, boolean z2, NavDestination navDestination) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch deepLinkMatch2;
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(navDestination, "lastVisited");
        NavDestination.DeepLinkMatch matchRoute = matchRoute(str);
        NavDestination.DeepLinkMatch deepLinkMatch3 = null;
        if (z) {
            Collection arrayList = new ArrayList();
            Iterator it = iterator();
            while (it.hasNext()) {
                NavDestination navDestination2 = (NavDestination) it.next();
                if (Intrinsics.areEqual((Object) navDestination2, (Object) navDestination)) {
                    deepLinkMatch2 = null;
                } else if (navDestination2 instanceof NavGraph) {
                    deepLinkMatch2 = ((NavGraph) navDestination2).matchRouteComprehensive(str, true, false, this);
                } else {
                    deepLinkMatch2 = navDestination2.matchRoute(str);
                }
                if (deepLinkMatch2 != null) {
                    arrayList.add(deepLinkMatch2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((List) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && z2 && !Intrinsics.areEqual((Object) parent, (Object) navDestination)) {
            deepLinkMatch3 = parent.matchRouteComprehensive(str, z, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(CollectionsKt.listOfNotNull((T[]) new NavDestination.DeepLinkMatch[]{matchRoute, deepLinkMatch, deepLinkMatch3}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(NavDeepLinkRequest navDeepLinkRequest, boolean z, boolean z2, NavDestination navDestination) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(navDestination, "lastVisited");
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (z) {
            Collection arrayList = new ArrayList();
            Iterator it = iterator();
            while (it.hasNext()) {
                NavDestination navDestination2 = (NavDestination) it.next();
                NavDestination.DeepLinkMatch matchDeepLink2 = !Intrinsics.areEqual((Object) navDestination2, (Object) navDestination) ? navDestination2.matchDeepLink(navDeepLinkRequest) : null;
                if (matchDeepLink2 != null) {
                    arrayList.add(matchDeepLink2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((List) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && z2 && !Intrinsics.areEqual((Object) parent, (Object) navDestination)) {
            deepLinkMatch2 = parent.matchDeepLinkComprehensive(navDeepLinkRequest, z, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(CollectionsKt.listOfNotNull((T[]) new NavDestination.DeepLinkMatch[]{matchDeepLink, deepLinkMatch, deepLinkMatch2}));
    }

    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive(navDeepLinkRequest, true, false, this);
    }

    public final void addDestination(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "node");
        int id = navDestination.getId();
        String route = navDestination.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        } else if (getRoute() != null && Intrinsics.areEqual((Object) route, (Object) getRoute())) {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same route as graph " + this).toString());
        } else if (id != getId()) {
            NavDestination navDestination2 = this.nodes.get(id);
            if (navDestination2 != navDestination) {
                if (navDestination.getParent() == null) {
                    if (navDestination2 != null) {
                        navDestination2.setParent((NavGraph) null);
                    }
                    navDestination.setParent(this);
                    this.nodes.put(navDestination.getId(), navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
            }
        } else {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same id as graph " + this).toString());
        }
    }

    public final void addDestinations(Collection<? extends NavDestination> collection) {
        Intrinsics.checkNotNullParameter(collection, "nodes");
        for (NavDestination navDestination : collection) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void addDestinations(NavDestination... navDestinationArr) {
        Intrinsics.checkNotNullParameter(navDestinationArr, "nodes");
        for (NavDestination addDestination : navDestinationArr) {
            addDestination(addDestination);
        }
    }

    public final NavDestination findNode(int i) {
        return findNodeComprehensive$default(this, i, this, false, (NavDestination) null, 8, (Object) null);
    }

    public static /* synthetic */ NavDestination findNodeComprehensive$default(NavGraph navGraph, int i, NavDestination navDestination, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 8) != 0) {
                navDestination2 = null;
            }
            return navGraph.findNodeComprehensive(i, navDestination, z, navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNodeComprehensive");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavDestination findNodeComprehensive(int r6, androidx.navigation.NavDestination r7, boolean r8, androidx.navigation.NavDestination r9) {
        /*
            r5 = this;
            androidx.collection.SparseArrayCompat<androidx.navigation.NavDestination> r0 = r5.nodes
            java.lang.Object r0 = r0.get(r6)
            androidx.navigation.NavDestination r0 = (androidx.navigation.NavDestination) r0
            r1 = 0
            if (r9 == 0) goto L_0x0022
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)
            if (r2 == 0) goto L_0x0020
            androidx.navigation.NavGraph r2 = r0.getParent()
            androidx.navigation.NavGraph r3 = r9.getParent()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0020
            goto L_0x0024
        L_0x0020:
            r0 = r1
            goto L_0x0025
        L_0x0022:
            if (r0 == 0) goto L_0x0025
        L_0x0024:
            return r0
        L_0x0025:
            if (r8 == 0) goto L_0x005c
            androidx.collection.SparseArrayCompat<androidx.navigation.NavDestination> r0 = r5.nodes
            java.util.Iterator r0 = androidx.collection.SparseArrayKt.valueIterator(r0)
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt.asSequence(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0035:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005b
            java.lang.Object r2 = r0.next()
            androidx.navigation.NavDestination r2 = (androidx.navigation.NavDestination) r2
            boolean r3 = r2 instanceof androidx.navigation.NavGraph
            if (r3 == 0) goto L_0x0056
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r3 != 0) goto L_0x0056
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2
            r3 = r5
            androidx.navigation.NavDestination r3 = (androidx.navigation.NavDestination) r3
            r4 = 1
            androidx.navigation.NavDestination r2 = r2.findNodeComprehensive(r6, r3, r4, r9)
            goto L_0x0057
        L_0x0056:
            r2 = r1
        L_0x0057:
            if (r2 == 0) goto L_0x0035
            r0 = r2
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            if (r0 != 0) goto L_0x007e
            androidx.navigation.NavGraph r0 = r5.getParent()
            if (r0 == 0) goto L_0x007d
            androidx.navigation.NavGraph r0 = r5.getParent()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x007d
            androidx.navigation.NavGraph r7 = r5.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r0 = r5
            androidx.navigation.NavDestination r0 = (androidx.navigation.NavDestination) r0
            androidx.navigation.NavDestination r6 = r7.findNodeComprehensive(r6, r0, r8, r9)
            return r6
        L_0x007d:
            return r1
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavGraph.findNodeComprehensive(int, androidx.navigation.NavDestination, boolean, androidx.navigation.NavDestination):androidx.navigation.NavDestination");
    }

    public final NavDestination findNode(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return findNode(str, true);
    }

    public final /* synthetic */ <T> NavDestination findNode() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall((Object) "kotlinx.serialization.serializer.simple");
        return findNode(RouteSerializerKt.generateHashCode(SerializersKt.serializer((KType) null)));
    }

    public final <T> NavDestination findNode(T t) {
        if (t != null) {
            return findNode(RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(t.getClass()))));
        }
        return null;
    }

    public final NavDestination findNode(String str, boolean z) {
        T t;
        Intrinsics.checkNotNullParameter(str, "route");
        Iterator<T> it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            NavDestination navDestination = (NavDestination) t;
            if (!StringsKt.equals$default(navDestination.getRoute(), str, false, 2, (Object) null)) {
                if (navDestination.matchRoute(str) != null) {
                    break;
                }
            } else {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) t;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!z || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(str);
    }

    public final Iterator<NavDestination> iterator() {
        return new NavGraph$iterator$1(this);
    }

    public final void addAll(NavGraph navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "other");
        Iterator<NavDestination> it = navGraph.iterator();
        while (it.hasNext()) {
            it.remove();
            addDestination(it.next());
        }
    }

    public final void remove(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "node");
        int indexOfKey = this.nodes.indexOfKey(navDestination.getId());
        if (indexOfKey >= 0) {
            this.nodes.valueAt(indexOfKey).setParent((NavGraph) null);
            this.nodes.removeAt(indexOfKey);
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    @Deprecated(message = "Use getStartDestinationId instead.", replaceWith = @ReplaceWith(expression = "startDestinationId", imports = {}))
    public final int getStartDestination() {
        return getStartDestinationId();
    }

    public final int getStartDestinationId() {
        return this.startDestId;
    }

    private final void setStartDestinationId(int i) {
        if (i != getId()) {
            if (this.startDestinationRoute != null) {
                setStartDestinationRoute((String) null);
            }
            this.startDestId = i;
            this.startDestIdName = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
    }

    public final void setStartDestination(int i) {
        setStartDestinationId(i);
    }

    public final void setStartDestination(String str) {
        Intrinsics.checkNotNullParameter(str, "startDestRoute");
        setStartDestinationRoute(str);
    }

    public final /* synthetic */ <T> void setStartDestination() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall((Object) "kotlinx.serialization.serializer.simple");
        setStartDestination(SerializersKt.serializer((KType) null), NavGraph$setStartDestination$1.INSTANCE);
    }

    public final <T> void setStartDestination(T t) {
        Intrinsics.checkNotNullParameter(t, "startDestRoute");
        setStartDestination(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(t.getClass())), new NavGraph$setStartDestination$2(t));
    }

    public final <T> void setStartDestination(KSerializer<T> kSerializer, Function1<? super NavDestination, String> function1) {
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.checkNotNullParameter(function1, "parseRoute");
        int generateHashCode = RouteSerializerKt.generateHashCode(kSerializer);
        NavDestination findNode = findNode(generateHashCode);
        if (findNode != null) {
            setStartDestinationRoute(function1.invoke(findNode));
            this.startDestId = generateHashCode;
            return;
        }
        throw new IllegalStateException(("Cannot find startDestination " + kSerializer.getDescriptor().getSerialName() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    private final void setStartDestinationRoute(String str) {
        int i;
        if (str == null) {
            i = 0;
        } else if (Intrinsics.areEqual((Object) str, (Object) getRoute())) {
            throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
        } else if (!StringsKt.isBlank(str)) {
            i = NavDestination.Companion.createRoute(str).hashCode();
        } else {
            throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
        }
        this.startDestId = i;
        this.startDestinationRoute = str;
    }

    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String str = this.startDestinationRoute;
            if (str == null) {
                str = String.valueOf(this.startDestId);
            }
            this.startDestIdName = str;
        }
        String str2 = this.startDestIdName;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination findNode = findNode(this.startDestinationRoute);
        if (findNode == null) {
            findNode = findNode(getStartDestinationId());
        }
        sb.append(" startDestination=");
        if (findNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NavGraph) && super.equals(obj)) {
            NavGraph navGraph = (NavGraph) obj;
            if (this.nodes.size() == navGraph.nodes.size() && getStartDestinationId() == navGraph.getStartDestinationId()) {
                for (T t : SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes))) {
                    if (!Intrinsics.areEqual((Object) t, (Object) navGraph.nodes.get(t.getId()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int startDestinationId = getStartDestinationId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            startDestinationId = (((startDestinationId * 31) + sparseArrayCompat.keyAt(i)) * 31) + sparseArrayCompat.valueAt(i).hashCode();
        }
        return startDestinationId;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0007J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "childHierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "findStartDestination", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavGraph.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NavDestination findStartDestination(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt.last(childHierarchy(navGraph));
        }

        public final Sequence<NavDestination> childHierarchy(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return SequencesKt.generateSequence(navGraph, NavGraph$Companion$childHierarchy$1.INSTANCE);
        }
    }
}
