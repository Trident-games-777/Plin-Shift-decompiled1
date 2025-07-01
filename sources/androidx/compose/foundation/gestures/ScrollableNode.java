package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000205H\u0002JM\u00109\u001a\u0002052=\u0010:\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002050;\u0012\n\u0012\b\u0012\u0004\u0012\u0002050(\u0012\u0006\u0012\u0004\u0018\u00010)0 H@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000205H\u0016J\u001a\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020FH\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010CJ\u001a\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u000205H\u0016J*\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bX\u0010LJ\"\u0010Y\u001a\u0002052\u0006\u0010I\u001a\u00020P2\u0006\u0010Z\u001a\u00020TH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u000205H\u0002J\b\u0010^\u001a\u00020\u0010H\u0016JN\u0010_\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010`\u001a\u000205H\u0002J\f\u0010a\u001a\u000205*\u00020bH\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R@\u0010\u001f\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0010\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R.\u0010&\u001a \b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0(\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010 X\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "clearScrollSemanticsActions", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "processMouseWheelEvent", "size", "processMouseWheelEvent-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "setScrollSemanticsActions", "startDragImmediately", "update", "updateDefaultFlingBehavior", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableNode extends DragGestureNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, KeyInputModifierNode, SemanticsModifierNode {
    /* access modifiers changed from: private */
    public final ContentInViewNode contentInViewNode;
    /* access modifiers changed from: private */
    public final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private ScrollConfig scrollConfig;
    private final ScrollableContainerNode scrollableContainerNode;
    /* access modifiers changed from: private */
    public final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;

    /* renamed from: onDragStarted-k-4lQ0M  reason: not valid java name */
    public void m537onDragStartedk4lQ0M(long j) {
    }

    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m541onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableNode(ScrollableState scrollableState, OverscrollEffect overscrollEffect2, FlingBehavior flingBehavior2, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        super(ScrollableKt.CanDragCalculation, z, mutableInteractionSource, orientation);
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        this.overscrollEffect = overscrollEffect2;
        this.flingBehavior = flingBehavior2;
        NestedScrollDispatcher nestedScrollDispatcher2 = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
        this.scrollableContainerNode = (ScrollableContainerNode) delegate(new ScrollableContainerNode(z));
        DefaultFlingBehavior defaultFlingBehavior2 = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.UnityDensity), (MotionDurationScale) null, 2, (DefaultConstructorMarker) null);
        this.defaultFlingBehavior = defaultFlingBehavior2;
        OverscrollEffect overscrollEffect3 = this.overscrollEffect;
        FlingBehavior flingBehavior3 = this.flingBehavior;
        ScrollingLogic scrollingLogic2 = new ScrollingLogic(scrollableState, overscrollEffect3, flingBehavior3 == null ? defaultFlingBehavior2 : flingBehavior3, orientation, z2, nestedScrollDispatcher2);
        this.scrollingLogic = scrollingLogic2;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic2, z);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        BringIntoViewSpec bringIntoViewSpec2 = bringIntoViewSpec;
        ContentInViewNode contentInViewNode2 = (ContentInViewNode) delegate(new ContentInViewNode(orientation, scrollingLogic2, z2, bringIntoViewSpec));
        this.contentInViewNode = contentInViewNode2;
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(scrollableNestedScrollConnection, nestedScrollDispatcher2));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode());
        delegate(new BringIntoViewResponderNode(contentInViewNode2));
        delegate(new FocusedBoundsObserverNode(new Function1<LayoutCoordinates, Unit>(this) {
            final /* synthetic */ ScrollableNode this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                this.this$0.contentInViewNode.onFocusBoundsChanged(layoutCoordinates);
            }
        }));
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ScrollingLogic scrollingLogic2 = this.scrollingLogic;
        Object scroll = scrollingLogic2.scroll(MutatePriority.UserInput, new ScrollableNode$drag$2$1(function2, scrollingLogic2, (Continuation<? super ScrollableNode$drag$2$1>) null), continuation);
        if (scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: onDragStopped-TH1AsA0  reason: not valid java name */
    public void m538onDragStoppedTH1AsA0(long j) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ScrollableNode$onDragStopped$1(this, j, (Continuation<? super ScrollableNode$onDragStopped$1>) null), 3, (Object) null);
    }

    public boolean startDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect2, boolean z, boolean z2, FlingBehavior flingBehavior2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        boolean z3;
        boolean z4 = z;
        FlingBehavior flingBehavior3 = flingBehavior2;
        if (getEnabled() != z4) {
            this.nestedScrollConnection.setEnabled(z4);
            this.scrollableContainerNode.update(z4);
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z5 = z3;
        Orientation orientation2 = orientation;
        OverscrollEffect overscrollEffect3 = overscrollEffect2;
        boolean z6 = z2;
        boolean update = this.scrollingLogic.update(scrollableState, orientation2, overscrollEffect3, z6, flingBehavior3 == null ? this.defaultFlingBehavior : flingBehavior3, this.nestedScrollDispatcher);
        this.contentInViewNode.update(orientation2, z6, bringIntoViewSpec);
        this.overscrollEffect = overscrollEffect3;
        this.flingBehavior = flingBehavior3;
        update(ScrollableKt.CanDragCalculation, z4, mutableInteractionSource, this.scrollingLogic.isVertical() ? Orientation.Vertical : Orientation.Horizontal, update);
        if (z5) {
            clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    public void onAttach() {
        updateDefaultFlingBehavior();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    public void onObservedReadsChanged() {
        updateDefaultFlingBehavior();
    }

    private final void updateDefaultFlingBehavior() {
        ObserverModifierNodeKt.observeReads(this, new ScrollableNode$updateDefaultFlingBehavior$1(this));
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
    }

    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m539onKeyEventZmokQxo(KeyEvent keyEvent) {
        long j;
        if (!getEnabled()) {
            return false;
        }
        if ((!Key.m5122equalsimpl0(KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent), Key.Companion.m5310getPageDownEK5gGoQ()) && !Key.m5122equalsimpl0(KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent), Key.Companion.m5311getPageUpEK5gGoQ())) || !KeyEventType.m5423equalsimpl0(KeyEvent_androidKt.m5431getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5427getKeyDownCS__XNY()) || KeyEvent_androidKt.m5434isCtrlPressedZmokQxo(keyEvent)) {
            return false;
        }
        if (this.scrollingLogic.isVertical()) {
            int r0 = IntSize.m7282getHeightimpl(this.contentInViewNode.m430getViewportSizeYbymL2g$foundation_release());
            j = OffsetKt.Offset(0.0f, Key.m5122equalsimpl0(KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent), Key.Companion.m5311getPageUpEK5gGoQ()) ? (float) r0 : -((float) r0));
        } else {
            int r02 = IntSize.m7283getWidthimpl(this.contentInViewNode.m430getViewportSizeYbymL2g$foundation_release());
            j = OffsetKt.Offset(Key.m5122equalsimpl0(KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent), Key.Companion.m5311getPageUpEK5gGoQ()) ? (float) r02 : -((float) r02), 0.0f);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ScrollableNode$onKeyEvent$1(this, j, (Continuation<? super ScrollableNode$onKeyEvent$1>) null), 3, (Object) null);
        return true;
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m540onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (getCanDrag().invoke(changes.get(i)).booleanValue()) {
                super.m465onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
                break;
            }
            i++;
        }
        if (pointerEventPass == PointerEventPass.Main && PointerEventType.m5535equalsimpl0(pointerEvent.m5528getType7fucELk(), PointerEventType.Companion.m5544getScroll7fucELk())) {
            m536processMouseWheelEventO0kMr_c(pointerEvent, j);
        }
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (getEnabled() && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            setScrollSemanticsActions();
        }
        Function2<? super Float, ? super Float, Boolean> function2 = this.scrollByAction;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, (String) null, function2, 1, (Object) null);
        }
        Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function22 = this.scrollByOffsetAction;
        if (function22 != null) {
            SemanticsPropertiesKt.scrollByOffset(semanticsPropertyReceiver, function22);
        }
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new ScrollableNode$setScrollSemanticsActions$1(this);
        this.scrollByOffsetAction = new ScrollableNode$setScrollSemanticsActions$2(this, (Continuation<? super ScrollableNode$setScrollSemanticsActions$2>) null);
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }

    /* renamed from: processMouseWheelEvent-O0kMr_c  reason: not valid java name */
    private final void m536processMouseWheelEventO0kMr_c(PointerEvent pointerEvent, long j) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (i < size) {
            if (!changes.get(i).isConsumed()) {
                i++;
            } else {
                return;
            }
        }
        ScrollConfig scrollConfig2 = this.scrollConfig;
        Intrinsics.checkNotNull(scrollConfig2);
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ScrollableNode$processMouseWheelEvent$2$1(this, scrollConfig2.m531calculateMouseWheelScroll8xgXZGE(DelegatableNodeKt.requireDensity(this), pointerEvent, j), (Continuation<? super ScrollableNode$processMouseWheelEvent$2$1>) null), 3, (Object) null);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes2.get(i2).consume();
        }
    }
}
