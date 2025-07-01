package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "distance", "", "getDistance", "()F", "setDistance", "(F)V", "leftBound", "getLeftBound", "()Ljava/lang/Object;", "setLeftBound", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "rightBound", "getRightBound", "setRightBound", "dragTo", "", "newOffset", "lastKnownVelocity", "updateBounds", "isMovingForward", "", "updateIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableState$anchoredDragScope$1 implements AnchoredDragScope {
    private float distance = Float.NaN;
    private T leftBound;
    private T rightBound;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    AnchoredDraggableState$anchoredDragScope$1(AnchoredDraggableState<T> anchoredDraggableState) {
        this.this$0 = anchoredDraggableState;
    }

    public final T getLeftBound() {
        return this.leftBound;
    }

    public final void setLeftBound(T t) {
        this.leftBound = t;
    }

    public final T getRightBound() {
        return this.rightBound;
    }

    public final void setRightBound(T t) {
        this.rightBound = t;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final void setDistance(float f) {
        this.distance = f;
    }

    public void dragTo(float f, float f2) {
        float offset = this.this$0.getOffset();
        this.this$0.setOffset(f);
        this.this$0.setLastVelocity(f2);
        if (!Float.isNaN(offset)) {
            updateIfNeeded(f >= offset);
        }
    }

    public final void updateIfNeeded(boolean z) {
        updateBounds(z);
        if (Math.abs(this.this$0.getOffset() - this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue())) >= this.distance / 2.0f) {
            T t = z ? this.rightBound : this.leftBound;
            if (t == null) {
                t = this.this$0.getCurrentValue();
            }
            if (this.this$0.getConfirmValueChange$foundation_release().invoke(t).booleanValue()) {
                this.this$0.setCurrentValue(t);
            }
        }
    }

    public final void updateBounds(boolean z) {
        if (this.this$0.getOffset() == this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue())) {
            T closestAnchor = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset() + (z ? 1.0f : -1.0f), z);
            if (closestAnchor == null) {
                closestAnchor = this.this$0.getCurrentValue();
            }
            if (z) {
                this.leftBound = this.this$0.getCurrentValue();
                this.rightBound = closestAnchor;
            } else {
                this.leftBound = closestAnchor;
                this.rightBound = this.this$0.getCurrentValue();
            }
        } else {
            T closestAnchor2 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), false);
            if (closestAnchor2 == null) {
                closestAnchor2 = this.this$0.getCurrentValue();
            }
            T closestAnchor3 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), true);
            if (closestAnchor3 == null) {
                closestAnchor3 = this.this$0.getCurrentValue();
            }
            this.leftBound = closestAnchor2;
            this.rightBound = closestAnchor3;
        }
        DraggableAnchors<T> anchors = this.this$0.getAnchors();
        T t = this.leftBound;
        Intrinsics.checkNotNull(t);
        float positionOf = anchors.positionOf(t);
        DraggableAnchors<T> anchors2 = this.this$0.getAnchors();
        T t2 = this.rightBound;
        Intrinsics.checkNotNull(t2);
        this.distance = Math.abs(positionOf - anchors2.positionOf(t2));
    }
}
