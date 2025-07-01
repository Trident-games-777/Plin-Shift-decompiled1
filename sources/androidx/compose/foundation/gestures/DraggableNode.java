package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012<\u0010\u000e\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018\u0012<\u0010\u0019\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJM\u0010\u001f\u001a\u00020\u00162=\u0010 \u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00160\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170!H@¢\u0006\u0002\u0010$J\u001a\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010&J\b\u0010\r\u001a\u00020\u0007H\u0016JÍ\u0001\u0010)\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072<\u0010\u000e\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u00182<\u0010\u0019\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u0011*\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0016\u0010*\u001a\u00020'*\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010,RF\u0010\u000e\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018X\u000e¢\u0006\u0004\n\u0002\u0010\u001eRF\u0010\u0019\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018X\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted-k-4lQ0M", "(J)V", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "update", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
public final class DraggableNode extends DragGestureNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    /* access modifiers changed from: private */
    public Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    /* access modifiers changed from: private */
    public Orientation orientation;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private DraggableState state;

    public DraggableNode(DraggableState draggableState, Function1<? super PointerInputChange, Boolean> function1, Orientation orientation2, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        super(function1, z, mutableInteractionSource, orientation2);
        this.state = draggableState;
        this.orientation = orientation2;
        this.startDragImmediately = z2;
        this.onDragStarted = function3;
        this.onDragStopped = function32;
        this.reverseDirection = z3;
    }

    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object drag = this.state.drag(MutatePriority.UserInput, new DraggableNode$drag$2(function2, this, (Continuation<? super DraggableNode$drag$2>) null), continuation);
        return drag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag : Unit.INSTANCE;
    }

    /* renamed from: onDragStarted-k-4lQ0M  reason: not valid java name */
    public void m491onDragStartedk4lQ0M(long j) {
        if (isAttached() && !Intrinsics.areEqual((Object) this.onDragStarted, (Object) DraggableKt.NoOpOnDragStarted)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new DraggableNode$onDragStarted$1(this, j, (Continuation<? super DraggableNode$onDragStarted$1>) null), 3, (Object) null);
        }
    }

    /* renamed from: onDragStopped-TH1AsA0  reason: not valid java name */
    public void m492onDragStoppedTH1AsA0(long j) {
        if (isAttached() && !Intrinsics.areEqual((Object) this.onDragStopped, (Object) DraggableKt.NoOpOnDragStopped)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new DraggableNode$onDragStopped$1(this, j, (Continuation<? super DraggableNode$onDragStopped$1>) null), 3, (Object) null);
        }
    }

    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(DraggableState draggableState, Function1<? super PointerInputChange, Boolean> function1, Orientation orientation2, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        boolean z4;
        boolean z5 = true;
        if (!Intrinsics.areEqual((Object) this.state, (Object) draggableState)) {
            this.state = draggableState;
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.orientation != orientation2) {
            this.orientation = orientation2;
            z4 = true;
        }
        if (this.reverseDirection != z3) {
            this.reverseDirection = z3;
        } else {
            z5 = z4;
        }
        this.onDragStarted = function3;
        this.onDragStopped = function32;
        this.startDragImmediately = z2;
        update(function1, z, mutableInteractionSource, orientation2, z5);
    }

    /* access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-AH228Gc  reason: not valid java name */
    public final long m489reverseIfNeededAH228Gc(long j) {
        return Velocity.m7356timesadjELrA(j, this.reverseDirection ? -1.0f : 1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m490reverseIfNeededMKHz9U(long j) {
        return Offset.m3994timestuRUvjQ(j, this.reverseDirection ? -1.0f : 1.0f);
    }
}
