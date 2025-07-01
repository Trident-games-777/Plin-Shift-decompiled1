package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002J\u0016\u0010\u001b\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H&R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/RectListNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "rect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function1;)V", "androidRect", "Landroid/graphics/Rect;", "getRect", "()Lkotlin/jvm/functions/Function1;", "setRect", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "calcBounds", "layoutCoordinates", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "onDetach", "", "onGloballyPositioned", "coordinates", "replaceRect", "newRect", "updateRects", "rects", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RectListNode.android.kt */
public abstract class RectListNode extends Modifier.Node implements GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Rect androidRect;
    private Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> rect;

    public abstract MutableVector<Rect> currentRects();

    public abstract void updateRects(MutableVector<Rect> mutableVector);

    public Function1<LayoutCoordinates, androidx.compose.ui.geometry.Rect> getRect() {
        return this.rect;
    }

    public void setRect(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> function1) {
        this.rect = function1;
    }

    public RectListNode(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> function1) {
        this.rect = function1;
    }

    /* access modifiers changed from: protected */
    public final View getView() {
        return DelegatableNode_androidKt.requireView(this);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        Rect rect2;
        if (getRect() == null) {
            androidx.compose.ui.geometry.Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(layoutCoordinates);
            rect2 = new Rect(MathKt.roundToInt(boundsInRoot.getLeft()), MathKt.roundToInt(boundsInRoot.getTop()), MathKt.roundToInt(boundsInRoot.getRight()), MathKt.roundToInt(boundsInRoot.getBottom()));
        } else {
            Function1<LayoutCoordinates, androidx.compose.ui.geometry.Rect> rect3 = getRect();
            Intrinsics.checkNotNull(rect3);
            rect2 = calcBounds(layoutCoordinates, rect3.invoke(layoutCoordinates));
        }
        replaceRect(rect2);
    }

    public void onDetach() {
        super.onDetach();
        replaceRect((Rect) null);
    }

    private final void replaceRect(Rect rect2) {
        MutableVector<Rect> currentRects = currentRects();
        Rect rect3 = this.androidRect;
        if (rect3 != null) {
            currentRects.remove(rect3);
        }
        if (rect2 != null && !rect2.isEmpty()) {
            currentRects.add(rect2);
        }
        updateRects(currentRects);
        this.androidRect = rect2;
    }

    private final Rect calcBounds(LayoutCoordinates layoutCoordinates, androidx.compose.ui.geometry.Rect rect2) {
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates2);
        long r2 = findRootCoordinates.m5801localPositionOfR5De75A(layoutCoordinates2, rect2.m4022getTopLeftF1C5BW0());
        long r4 = findRootCoordinates.m5801localPositionOfR5De75A(layoutCoordinates2, rect2.m4023getTopRightF1C5BW0());
        long r6 = findRootCoordinates.m5801localPositionOfR5De75A(layoutCoordinates2, rect2.m4015getBottomLeftF1C5BW0());
        long r0 = findRootCoordinates.m5801localPositionOfR5De75A(layoutCoordinates2, rect2.m4016getBottomRightF1C5BW0());
        return new Rect(MathKt.roundToInt(ComparisonsKt.minOf(Offset.m3987getXimpl(r2), Offset.m3987getXimpl(r4), Offset.m3987getXimpl(r6), Offset.m3987getXimpl(r0))), MathKt.roundToInt(ComparisonsKt.minOf(Offset.m3988getYimpl(r2), Offset.m3988getYimpl(r4), Offset.m3988getYimpl(r6), Offset.m3988getYimpl(r0))), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m3987getXimpl(r2), Offset.m3987getXimpl(r4), Offset.m3987getXimpl(r6), Offset.m3987getXimpl(r0))), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m3988getYimpl(r2), Offset.m3988getYimpl(r4), Offset.m3988getYimpl(r6), Offset.m3988getYimpl(r0))));
    }
}
