package androidx.compose.ui.platform;

import android.graphics.Region;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f*\b\u0012\u0004\u0012\u00020\f0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u0013H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0000\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001cH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getDefaultFakeNodeBounds", "()Landroidx/compose/ui/geometry/Rect;", "getScrollViewportLength", "", "configuration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Ljava/lang/Float;", "getTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "getAllUncoveredSemanticsNodesToIntObjectMap", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "isImportantForAccessibility", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsUtils.android.kt */
public final class SemanticsUtils_androidKt {
    private static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        List arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    public static final Float getScrollViewportLength(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        List arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetScrollViewportLength());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int i) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).getSemanticsNodeId() == i) {
                return list.get(i2);
            }
        }
        return null;
    }

    /* renamed from: toLegacyClassName-V4PA4sw  reason: not valid java name */
    public static final String m6332toLegacyClassNameV4PA4sw(int i) {
        if (Role.m6363equalsimpl0(i, Role.Companion.m6367getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m6363equalsimpl0(i, Role.Companion.m6368getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m6363equalsimpl0(i, Role.Companion.m6371getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m6363equalsimpl0(i, Role.Companion.m6370getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m6363equalsimpl0(i, Role.Companion.m6369getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final boolean isImportantForAccessibility(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getUnmergedConfig$ui_release().containsImportantForAccessibility$ui_release();
    }

    public static final Rect getDefaultFakeNodeBounds() {
        return DefaultFakeNodeBounds;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.ui.viewinterop.AndroidViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler r3, int r4) {
        /*
            java.util.HashMap r3 = r3.getLayoutNodeToHolder()
            java.util.Set r3 = r3.entrySet()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x000e:
            boolean r0 = r3.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r3.next()
            r2 = r0
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
            int r2 = r2.getSemanticsId()
            if (r2 != r4) goto L_0x000e
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            if (r0 == 0) goto L_0x0035
            java.lang.Object r3 = r0.getValue()
            r1 = r3
            androidx.compose.ui.viewinterop.AndroidViewHolder r1 = (androidx.compose.ui.viewinterop.AndroidViewHolder) r1
        L_0x0035:
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler, int):android.view.View");
    }

    public static final IntObjectMap<SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner semanticsOwner) {
        SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
        MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        if (!unmergedRootSemanticsNode.getLayoutNode$ui_release().isPlaced() || !unmergedRootSemanticsNode.getLayoutNode$ui_release().isAttached()) {
            return mutableIntObjectMapOf;
        }
        Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
        getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(new Region(Math.round(boundsInRoot.getLeft()), Math.round(boundsInRoot.getTop()), Math.round(boundsInRoot.getRight()), Math.round(boundsInRoot.getBottom())), unmergedRootSemanticsNode, mutableIntObjectMapOf, unmergedRootSemanticsNode, new Region());
        return mutableIntObjectMapOf;
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(Region region, SemanticsNode semanticsNode, MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, SemanticsNode semanticsNode2, Region region2) {
        int i;
        Rect rect;
        LayoutInfo layoutInfo;
        boolean z = !semanticsNode2.getLayoutNode$ui_release().isPlaced() || !semanticsNode2.getLayoutNode$ui_release().isAttached();
        if (region.isEmpty() && semanticsNode2.getId() != semanticsNode.getId()) {
            return;
        }
        if (!z || semanticsNode2.isFake$ui_release()) {
            Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
            int round = Math.round(touchBoundsInRoot.getLeft());
            int round2 = Math.round(touchBoundsInRoot.getTop());
            int round3 = Math.round(touchBoundsInRoot.getRight());
            int round4 = Math.round(touchBoundsInRoot.getBottom());
            region2.set(round, round2, round3, round4);
            if (semanticsNode2.getId() == semanticsNode.getId()) {
                i = -1;
            } else {
                i = semanticsNode2.getId();
            }
            if (region2.op(region, Region.Op.INTERSECT)) {
                mutableIntObjectMap.set(i, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                    getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(region, semanticsNode, mutableIntObjectMap, replacedChildren$ui_release.get(size), region2);
                }
                if (isImportantForAccessibility(semanticsNode2)) {
                    region.op(round, round2, round3, round4, Region.Op.DIFFERENCE);
                }
            } else if (semanticsNode2.isFake$ui_release()) {
                SemanticsNode parent = semanticsNode2.getParent();
                if (parent == null || (layoutInfo = parent.getLayoutInfo()) == null || !layoutInfo.isPlaced()) {
                    rect = DefaultFakeNodeBounds;
                } else {
                    rect = parent.getBoundsInRoot();
                }
                mutableIntObjectMap.set(i, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()))));
            } else if (i == -1) {
                mutableIntObjectMap.set(i, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
            }
        }
    }
}
