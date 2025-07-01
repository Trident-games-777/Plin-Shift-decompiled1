package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJM\u0010\u0013\u001a\u00020\u00142=\u0010\u0015\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0016H@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010#J\b\u0010\u000e\u001a\u00020\bH\u0016JO\u0010(\u001a\u00020\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u0016\u0010)\u001a\u00020!*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0016\u0010)\u001a\u00020&*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010+J\u0016\u0010-\u001a\u00020.*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0016\u0010-\u001a\u00020.*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00100J\u0019\u00102\u001a\u00020!*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020&*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00104R\u0014\u0010\u0010\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "T", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)V", "isReverseDirection", "()Z", "Ljava/lang/Boolean;", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "update", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "toFloat", "", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableNode<T> extends DragGestureNode {
    private Orientation orientation;
    /* access modifiers changed from: private */
    public OverscrollEffect overscrollEffect;
    private Boolean reverseDirection;
    private boolean startDragImmediately;
    /* access modifiers changed from: private */
    public AnchoredDraggableState<T> state;

    /* renamed from: onDragStarted-k-4lQ0M  reason: not valid java name */
    public void m419onDragStartedk4lQ0M(long j) {
    }

    public AnchoredDraggableNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation2, boolean z, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect2, boolean z2) {
        super(AnchoredDraggableKt.AlwaysDrag, z, mutableInteractionSource, orientation2);
        this.state = anchoredDraggableState;
        this.orientation = orientation2;
        this.reverseDirection = bool;
        this.overscrollEffect = overscrollEffect2;
        this.startDragImmediately = z2;
    }

    private final boolean isReverseDirection() {
        Boolean bool = this.reverseDirection;
        if (bool == null) {
            return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.state, (MutatePriority) null, new AnchoredDraggableNode$drag$2(function2, this, (Continuation<? super AnchoredDraggableNode$drag$2>) null), continuation, 1, (Object) null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    /* renamed from: onDragStopped-TH1AsA0  reason: not valid java name */
    public void m420onDragStoppedTH1AsA0(long j) {
        if (isAttached()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AnchoredDraggableNode$onDragStopped$1(this, j, (Continuation<? super AnchoredDraggableNode$onDragStopped$1>) null), 3, (Object) null);
        }
    }

    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation2, boolean z, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect2, boolean z2) {
        boolean z3;
        boolean z4;
        if (!Intrinsics.areEqual((Object) this.state, (Object) anchoredDraggableState)) {
            this.state = anchoredDraggableState;
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.orientation != orientation2) {
            this.orientation = orientation2;
            z3 = true;
        }
        if (!Intrinsics.areEqual((Object) this.reverseDirection, (Object) bool)) {
            this.reverseDirection = bool;
            z4 = true;
        } else {
            z4 = z3;
        }
        this.startDragImmediately = z2;
        this.overscrollEffect = overscrollEffect2;
        DragGestureNode.update$default(this, (Function1) null, z, mutableInteractionSource, orientation2, z4, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m417toOffsettuRUvjQ(float f) {
        float f2 = this.orientation == Orientation.Horizontal ? f : 0.0f;
        if (this.orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return OffsetKt.Offset(f2, f);
    }

    /* access modifiers changed from: private */
    /* renamed from: toVelocity-adjELrA  reason: not valid java name */
    public final long m418toVelocityadjELrA(float f) {
        float f2 = this.orientation == Orientation.Horizontal ? f : 0.0f;
        if (this.orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return VelocityKt.Velocity(f2, f);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m415toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Vertical ? Velocity.m7351getYimpl(j) : Velocity.m7350getXimpl(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m416toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Vertical ? Offset.m3988getYimpl(j) : Offset.m3987getXimpl(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-AH228Gc  reason: not valid java name */
    public final long m413reverseIfNeededAH228Gc(long j) {
        return Velocity.m7356timesadjELrA(j, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m414reverseIfNeededMKHz9U(long j) {
        return Offset.m3994timestuRUvjQ(j, isReverseDirection() ? -1.0f : 1.0f);
    }
}
