package androidx.compose.foundation.gestures;

import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001EB'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\"H@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010\u0011J\u001a\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J\"\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108J\b\u00109\u001a\u00020\fH\u0002J \u0010:\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001f\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001f\u0010;\u001a\u00020<*\u00020\u001a2\u0006\u0010>\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010@J \u0010B\u001a\u00020\n*\u00020\u00132\b\b\u0002\u00102\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "trackingFocusedChild", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation_release", "()J", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onFocusBoundsChanged", "newBounds", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "requireBringIntoViewSpec", "update", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentInViewNode.kt */
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private BringIntoViewSpec bringIntoViewSpec;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    /* access modifiers changed from: private */
    public boolean isAnimationRunning;
    private Orientation orientation;
    /* access modifiers changed from: private */
    public boolean reverseDirection;
    /* access modifiers changed from: private */
    public final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    /* access modifiers changed from: private */
    public boolean trackingFocusedChild;
    private long viewportSize = IntSize.Companion.m7288getZeroYbymL2g();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentInViewNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.foundation.gestures.Orientation[] r0 = androidx.compose.foundation.gestures.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewNode.WhenMappings.<clinit>():void");
        }
    }

    public ContentInViewNode(Orientation orientation2, ScrollingLogic scrollingLogic2, boolean z, BringIntoViewSpec bringIntoViewSpec2) {
        this.orientation = orientation2;
        this.scrollingLogic = scrollingLogic2;
        this.reverseDirection = z;
        this.bringIntoViewSpec = bringIntoViewSpec2;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* renamed from: getViewportSize-YbymL2g$foundation_release  reason: not valid java name */
    public final long m430getViewportSizeYbymL2g$foundation_release() {
        return this.viewportSize;
    }

    public Rect calculateRectForParent(Rect rect) {
        if (!IntSize.m7281equalsimpl0(this.viewportSize, IntSize.Companion.m7288getZeroYbymL2g())) {
            return m426computeDestinationO0kMr_c(rect, this.viewportSize);
        }
        throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
    }

    private final BringIntoViewSpec requireBringIntoViewSpec() {
        BringIntoViewSpec bringIntoViewSpec2 = this.bringIntoViewSpec;
        return bringIntoViewSpec2 == null ? (BringIntoViewSpec) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec()) : bringIntoViewSpec2;
    }

    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Rect invoke = function0.invoke();
        if (invoke == null || m428isMaxVisibleO0kMr_c$default(this, invoke, 0, 1, (Object) null)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.bringIntoViewRequests.enqueue(new Request(function0, cancellableContinuationImpl)) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates layoutCoordinates) {
        this.focusedChild = layoutCoordinates;
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m431onRemeasuredozmzZPI(long j) {
        Rect focusedChildBounds;
        long j2 = this.viewportSize;
        this.viewportSize = j;
        if (m424compareToTemP2vQ(j, j2) < 0 && (focusedChildBounds = getFocusedChildBounds()) != null) {
            Rect rect = this.focusedChildBoundsFromPreviousRemeasure;
            if (rect == null) {
                rect = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m427isMaxVisibleO0kMr_c(rect, j2) && !m427isMaxVisibleO0kMr_c(focusedChildBounds, j)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    /* access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        if (!isAttached()) {
            return null;
        }
        LayoutCoordinates requireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(this);
        LayoutCoordinates layoutCoordinates = this.focusedChild;
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates != null) {
                return requireLayoutCoordinates.localBoundingBoxOf(layoutCoordinates, false);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void launchAnimation() {
        BringIntoViewSpec requireBringIntoViewSpec = requireBringIntoViewSpec();
        if (!this.isAnimationRunning) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(requireBringIntoViewSpec.getScrollAnimationSpec()), requireBringIntoViewSpec, (Continuation<? super ContentInViewNode$launchAnimation$2>) null), 1, (Object) null);
            return;
        }
        throw new IllegalStateException("launchAnimation called when previous animation was running".toString());
    }

    /* access modifiers changed from: private */
    public final float calculateScrollDelta(BringIntoViewSpec bringIntoViewSpec2) {
        if (IntSize.m7281equalsimpl0(this.viewportSize, IntSize.Companion.m7288getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect findBringIntoViewRequest = findBringIntoViewRequest();
        if (findBringIntoViewRequest == null) {
            findBringIntoViewRequest = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (findBringIntoViewRequest == null) {
                return 0.0f;
            }
        }
        long r1 = IntSizeKt.m7295toSizeozmzZPI(this.viewportSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return bringIntoViewSpec2.calculateScrollDistance(findBringIntoViewRequest.getTop(), findBringIntoViewRequest.getBottom() - findBringIntoViewRequest.getTop(), Size.m4053getHeightimpl(r1));
        }
        if (i == 2) {
            return bringIntoViewSpec2.calculateScrollDistance(findBringIntoViewRequest.getLeft(), findBringIntoViewRequest.getRight() - findBringIntoViewRequest.getLeft(), Size.m4056getWidthimpl(r1));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector access$getRequests$p = this.bringIntoViewRequests.requests;
        int size = access$getRequests$p.getSize();
        Rect rect = null;
        if (size > 0) {
            int i = size - 1;
            Object[] content = access$getRequests$p.getContent();
            do {
                Rect invoke = ((Request) content[i]).getCurrentBounds().invoke();
                if (invoke != null) {
                    if (m425compareToiLBOSCw(invoke.m4020getSizeNHjbRc(), IntSizeKt.m7295toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect == null ? invoke : rect;
                    }
                    rect = invoke;
                }
                i--;
            } while (i >= 0);
        }
        return rect;
    }

    /* renamed from: computeDestination-O0kMr_c  reason: not valid java name */
    private final Rect m426computeDestinationO0kMr_c(Rect rect, long j) {
        return rect.m4024translatek4lQ0M(Offset.m3996unaryMinusF1C5BW0(m429relocationOffsetBMxPBkI(rect, j)));
    }

    /* renamed from: isMaxVisible-O0kMr_c$default  reason: not valid java name */
    static /* synthetic */ boolean m428isMaxVisibleO0kMr_c$default(ContentInViewNode contentInViewNode, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewNode.viewportSize;
        }
        return contentInViewNode.m427isMaxVisibleO0kMr_c(rect, j);
    }

    /* renamed from: isMaxVisible-O0kMr_c  reason: not valid java name */
    private final boolean m427isMaxVisibleO0kMr_c(Rect rect, long j) {
        long r2 = m429relocationOffsetBMxPBkI(rect, j);
        return Math.abs(Offset.m3987getXimpl(r2)) <= 0.5f && Math.abs(Offset.m3988getYimpl(r2)) <= 0.5f;
    }

    /* renamed from: relocationOffset-BMxPBkI  reason: not valid java name */
    private final long m429relocationOffsetBMxPBkI(Rect rect, long j) {
        long r6 = IntSizeKt.m7295toSizeozmzZPI(j);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return OffsetKt.Offset(0.0f, requireBringIntoViewSpec().calculateScrollDistance(rect.getTop(), rect.getBottom() - rect.getTop(), Size.m4053getHeightimpl(r6)));
        }
        if (i == 2) {
            return OffsetKt.Offset(requireBringIntoViewSpec().calculateScrollDistance(rect.getLeft(), rect.getRight() - rect.getLeft(), Size.m4056getWidthimpl(r6)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: compareTo-TemP2vQ  reason: not valid java name */
    private final int m424compareToTemP2vQ(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Intrinsics.compare(IntSize.m7282getHeightimpl(j), IntSize.m7282getHeightimpl(j2));
        }
        if (i == 2) {
            return Intrinsics.compare(IntSize.m7283getWidthimpl(j), IntSize.m7283getWidthimpl(j2));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: compareTo-iLBOSCw  reason: not valid java name */
    private final int m425compareToiLBOSCw(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Float.compare(Size.m4053getHeightimpl(j), Size.m4053getHeightimpl(j2));
        }
        if (i == 2) {
            return Float.compare(Size.m4056getWidthimpl(j), Size.m4056getWidthimpl(j2));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void update(Orientation orientation2, boolean z, BringIntoViewSpec bringIntoViewSpec2) {
        this.orientation = orientation2;
        this.reverseDirection = z;
        this.bringIntoViewSpec = bringIntoViewSpec2;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentInViewNode.kt */
    public static final class Request {
        public static final int $stable = 8;
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        public Request(Function0<Rect> function0, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.currentBounds = function0;
            this.continuation = cancellableContinuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        public String toString() {
            String str;
            CoroutineName coroutineName = (CoroutineName) this.continuation.getContext().get(CoroutineName.Key);
            String name = coroutineName != null ? coroutineName.getName() : null;
            StringBuilder sb = new StringBuilder("Request@");
            String num = Integer.toString(hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            StringBuilder append = sb.append(num);
            if (name == null || (str = "[" + name + "](") == null) {
                str = "(";
            }
            return append.append(str).append("currentBounds()=").append(this.currentBounds.invoke()).append(", continuation=").append(this.continuation).append(')').toString();
        }
    }
}
