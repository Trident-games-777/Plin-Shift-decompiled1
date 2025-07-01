package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J#\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u000e*\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u000e*\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "Landroidx/compose/ui/geometry/Offset;", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "", "addPointerInputChange-GcwITfU", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "reset", "", "crossAxis", "crossAxis-k-4lQ0M", "(J)F", "mainAxis", "mainAxis-k-4lQ0M", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
final class TouchSlopDetector {
    private final Orientation orientation;
    private long totalPositionChange;

    public TouchSlopDetector() {
        this((Orientation) null, 1, (DefaultConstructorMarker) null);
    }

    public TouchSlopDetector(Orientation orientation2) {
        this.orientation = orientation2;
        this.totalPositionChange = Offset.Companion.m4003getZeroF1C5BW0();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TouchSlopDetector(Orientation orientation2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation2);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: mainAxis-k-4lQ0M  reason: not valid java name */
    public final float m565mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3987getXimpl(j) : Offset.m3988getYimpl(j);
    }

    /* renamed from: crossAxis-k-4lQ0M  reason: not valid java name */
    public final float m564crossAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3988getYimpl(j) : Offset.m3987getXimpl(j);
    }

    /* renamed from: addPointerInputChange-GcwITfU  reason: not valid java name */
    public final Offset m563addPointerInputChangeGcwITfU(PointerInputChange pointerInputChange, float f) {
        float f2;
        long r0 = Offset.m3992plusMKHz9U(this.totalPositionChange, Offset.m3991minusMKHz9U(pointerInputChange.m5587getPositionF1C5BW0(), pointerInputChange.m5588getPreviousPositionF1C5BW0()));
        this.totalPositionChange = r0;
        if (this.orientation == null) {
            f2 = Offset.m3985getDistanceimpl(r0);
        } else {
            f2 = Math.abs(m565mainAxisk4lQ0M(r0));
        }
        if (f2 >= f) {
            return Offset.m3976boximpl(m562calculatePostSlopOffsettuRUvjQ(f));
        }
        return null;
    }

    public final void reset() {
        this.totalPositionChange = Offset.Companion.m4003getZeroF1C5BW0();
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ  reason: not valid java name */
    private final long m562calculatePostSlopOffsettuRUvjQ(float f) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m3991minusMKHz9U(this.totalPositionChange, Offset.m3994timestuRUvjQ(Offset.m3982divtuRUvjQ(j, Offset.m3985getDistanceimpl(j)), f));
        }
        float r0 = m565mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m565mainAxisk4lQ0M(this.totalPositionChange)) * f);
        float r5 = m564crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(r0, r5);
        }
        return OffsetKt.Offset(r5, r0);
    }
}
