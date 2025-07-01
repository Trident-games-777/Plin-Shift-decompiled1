package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001:\u0001SB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\bJ\"\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002ø\u0001\u0000¢\u0006\u0002\b/J\"\u00100\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002ø\u0001\u0000¢\u0006\u0002\b1J\b\u00102\u001a\u00020)H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0016\u00104\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u00105\u001a\u00020\bJ\u0018\u00106\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u00105\u001a\u00020\bH\u0002J\u0018\u00107\u001a\u00020\b2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020)\u0018\u000109J \u00107\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0006\u0010<\u001a\u00020)J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0003J\u0018\u0010?\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00032\u0006\u00105\u001a\u00020\bH\u0002J\u001f\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\b2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020)09H\bJ\u000e\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u0016J$\u0010E\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u0010F\u001a\u00020\bH\u0002J\u0010\u0010G\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0018\u0010H\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u00105\u001a\u00020\bH\u0002J\u0018\u0010I\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\bJ\u0018\u0010K\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\bJ\u000e\u0010L\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0003J\u0018\u0010M\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\bJ\u0018\u0010N\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\bJ\u0018\u0010O\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0014\u0010R\u001a\u00020\b*\u00020\u00032\u0006\u00105\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0018\u0010$\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0018\u0010&\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringFullMeasureLayoutPass", "", "duringMeasureLayout", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hasPendingOnPositionedCallbacks", "getHasPendingOnPositionedCallbacks", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "canAffectParentInLookahead", "getCanAffectParentInLookahead", "measureAffectsParent", "getMeasureAffectsParent", "measureAffectsParentLookahead", "getMeasureAffectsParentLookahead", "callOnLayoutCompletedListeners", "", "dispatchOnPositionedCallbacks", "forceDispatch", "doLookaheadRemeasure", "layoutNode", "constraints", "doLookaheadRemeasure-sdFAvZA", "doRemeasure", "doRemeasure-sdFAvZA", "drainPostponedMeasureRequests", "ensureSubtreeLookaheadReplaced", "forceMeasureTheSubtree", "affectsLookahead", "forceMeasureTheSubtreeInternal", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "measureOnly", "onNodeDetached", "node", "onlyRemeasureIfScheduled", "performMeasureAndLayout", "fullPass", "block", "registerOnLayoutCompletedListener", "listener", "remeasureAndRelayoutIfNeeded", "relayoutNeeded", "remeasureLookaheadRootsInSubtree", "remeasureOnly", "requestLookaheadRelayout", "forced", "requestLookaheadRemeasure", "requestOnPositionedCallback", "requestRelayout", "requestRemeasure", "updateRootConstraints", "updateRootConstraints-BRTryo0", "(J)V", "measurePending", "PostponedRequest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasureAndLayoutDelegate.kt */
public final class MeasureAndLayoutDelegate {
    public static final int $stable = 8;
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringFullMeasureLayoutPass;
    private boolean duringMeasureLayout;
    private long measureIteration = 1;
    private final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16], 0);
    private final OnPositionedDispatcher onPositionedDispatcher = new OnPositionedDispatcher();
    private final MutableVector<PostponedRequest> postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    /* access modifiers changed from: private */
    public final LayoutNode root;
    private Constraints rootConstraints;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MeasureAndLayoutDelegate.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.ui.node.LayoutNode$LayoutState[] r0 = androidx.compose.ui.node.LayoutNode.LayoutState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.Idle     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MeasureAndLayoutDelegate.WhenMappings.<clinit>():void");
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode layoutNode) {
        this.root = layoutNode;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = new DepthSortedSetsForDifferentPasses(Owner.Companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSetsForDifferentPasses;
        MutableVector<PostponedRequest> mutableVector = new MutableVector<>(new PostponedRequest[16], 0);
        this.postponedMeasureRequests = mutableVector;
        this.consistencyChecker = Owner.Companion.getEnableExtraAssertions() ? new LayoutTreeConsistencyChecker(layoutNode, depthSortedSetsForDifferentPasses, mutableVector.asMutableList()) : null;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return this.relayoutNodes.isNotEmpty();
    }

    public final boolean getHasPendingOnPositionedCallbacks() {
        return this.onPositionedDispatcher.isNotEmpty();
    }

    public final long getMeasureIteration() {
        if (!this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        }
        return this.measureIteration;
    }

    /* renamed from: updateRootConstraints-BRTryo0  reason: not valid java name */
    public final void m6076updateRootConstraintsBRTryo0(long j) {
        Constraints constraints = this.rootConstraints;
        boolean z = false;
        if (!(constraints == null ? false : Constraints.m7045equalsimpl0(constraints.m7058unboximpl(), j))) {
            if (this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
            }
            this.rootConstraints = Constraints.m7040boximpl(j);
            if (this.root.getLookaheadRoot$ui_release() != null) {
                this.root.markLookaheadMeasurePending$ui_release();
            }
            this.root.markMeasurePending$ui_release();
            DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
            LayoutNode layoutNode = this.root;
            if (layoutNode.getLookaheadRoot$ui_release() != null) {
                z = true;
            }
            depthSortedSetsForDifferentPasses.add(layoutNode, z);
        }
    }

    public static /* synthetic */ boolean requestLookaheadRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z);
    }

    public final boolean requestLookaheadRemeasure(LayoutNode layoutNode, boolean z) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        if (!(layoutNode.getLookaheadRoot$ui_release() != null)) {
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3 || i == 4) {
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, z));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else if (i != 5) {
                throw new NoWhenBranchMatchedException();
            } else if (layoutNode.getLookaheadMeasurePending$ui_release() && !z) {
                return false;
            } else {
                layoutNode.markLookaheadMeasurePending$ui_release();
                layoutNode.markMeasurePending$ui_release();
                if (layoutNode.isDeactivated()) {
                    return false;
                }
                if ((Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) || getCanAffectParentInLookahead(layoutNode)) && ((parent$ui_release2 = layoutNode.getParent$ui_release()) == null || !parent$ui_release2.getLookaheadMeasurePending$ui_release())) {
                    this.relayoutNodes.add(layoutNode, true);
                } else if ((layoutNode.isPlaced() || getCanAffectParent(layoutNode)) && ((parent$ui_release = layoutNode.getParent$ui_release()) == null || !parent$ui_release.getMeasurePending$ui_release())) {
                    this.relayoutNodes.add(layoutNode, false);
                }
                return !this.duringFullMeasureLayoutPass;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z);
    }

    public final boolean requestRemeasure(LayoutNode layoutNode, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (!(i == 1 || i == 2)) {
            if (i == 3 || i == 4) {
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, z));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else if (i != 5) {
                throw new NoWhenBranchMatchedException();
            } else if (layoutNode.getMeasurePending$ui_release() && !z) {
                return false;
            } else {
                layoutNode.markMeasurePending$ui_release();
                if (layoutNode.isDeactivated()) {
                    return false;
                }
                if (!layoutNode.isPlaced() && !getCanAffectParent(layoutNode)) {
                    return false;
                }
                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                if (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()) {
                    this.relayoutNodes.add(layoutNode, false);
                }
                return !this.duringFullMeasureLayoutPass;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean requestLookaheadRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z);
    }

    public final boolean requestLookaheadRelayout(LayoutNode layoutNode, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (!(i == 4 || i == 5)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getLookaheadLayoutPending$ui_release()) && !z) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                return false;
            }
            layoutNode.markLookaheadLayoutPending$ui_release();
            layoutNode.markLayoutPending$ui_release();
            if (layoutNode.isDeactivated()) {
                return false;
            }
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) && ((parent$ui_release == null || !parent$ui_release.getLookaheadMeasurePending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getLookaheadLayoutPending$ui_release()))) {
                this.relayoutNodes.add(layoutNode, true);
            } else if (layoutNode.isPlaced() && ((parent$ui_release == null || !parent$ui_release.getLayoutPending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()))) {
                this.relayoutNodes.add(layoutNode, false);
            }
            return !this.duringFullMeasureLayoutPass;
        }
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
        if (layoutTreeConsistencyChecker2 != null) {
            layoutTreeConsistencyChecker2.assertConsistent();
        }
        return false;
    }

    public static /* synthetic */ boolean requestRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode, z);
    }

    public final boolean requestRelayout(LayoutNode layoutNode, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
            return false;
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else if (z || layoutNode.isPlaced() != layoutNode.isPlacedByParent() || (!layoutNode.getMeasurePending$ui_release() && !layoutNode.getLayoutPending$ui_release())) {
            layoutNode.markLayoutPending$ui_release();
            if (!layoutNode.isDeactivated() && layoutNode.isPlacedByParent()) {
                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                if ((parent$ui_release == null || !parent$ui_release.getLayoutPending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release())) {
                    this.relayoutNodes.add(layoutNode, false);
                }
                if (!this.duringFullMeasureLayoutPass) {
                    return true;
                }
            }
            return false;
        } else {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
            if (layoutTreeConsistencyChecker2 != null) {
                layoutTreeConsistencyChecker2.assertConsistent();
            }
            return false;
        }
    }

    public final void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    /* renamed from: doLookaheadRemeasure-sdFAvZA  reason: not valid java name */
    private final boolean m6073doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean z;
        if (layoutNode.getLookaheadRoot$ui_release() == null) {
            return false;
        }
        if (constraints != null) {
            z = layoutNode.m5999lookaheadRemeasure_Sx5XlM$ui_release(constraints);
        } else {
            z = LayoutNode.m5995lookaheadRemeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (z && parent$ui_release != null) {
            if (parent$ui_release.getLookaheadRoot$ui_release() == null) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, (Object) null);
                return z;
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, (Object) null);
                return z;
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, (Object) null);
            }
        }
        return z;
    }

    /* renamed from: doRemeasure-sdFAvZA  reason: not valid java name */
    private final boolean m6074doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean z;
        if (constraints != null) {
            z = layoutNode.m6000remeasure_Sx5XlM$ui_release(constraints);
        } else {
            z = LayoutNode.m5996remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (z && parent$ui_release != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, (Object) null);
                return z;
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, (Object) null);
            }
        }
        return z;
    }

    public static /* synthetic */ boolean measureAndLayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return measureAndLayoutDelegate.measureAndLayout(function0);
    }

    /* JADX INFO: finally extract failed */
    public final void measureOnly() {
        if (this.relayoutNodes.isNotEmpty()) {
            if (!this.root.isAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            if (!this.root.isPlaced()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            if (this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                this.duringFullMeasureLayoutPass = false;
                try {
                    if (!this.relayoutNodes.isEmpty(true)) {
                        if (this.root.getLookaheadRoot$ui_release() != null) {
                            remeasureOnly(this.root, true);
                        } else {
                            remeasureLookaheadRootsInSubtree(this.root);
                        }
                    }
                    remeasureOnly(this.root, false);
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } catch (Throwable th) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public final void m6075measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        if (!layoutNode.isDeactivated()) {
            if (Intrinsics.areEqual((Object) layoutNode, (Object) this.root)) {
                InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
            }
            if (!this.root.isAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            if (!this.root.isPlaced()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            if (this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                this.duringFullMeasureLayoutPass = false;
                try {
                    this.relayoutNodes.remove(layoutNode);
                    if ((m6073doLookaheadRemeasuresdFAvZA(layoutNode, Constraints.m7040boximpl(j)) || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true)) {
                        layoutNode.lookaheadReplace$ui_release();
                    }
                    ensureSubtreeLookaheadReplaced(layoutNode);
                    m6074doRemeasuresdFAvZA(layoutNode, Constraints.m7040boximpl(j));
                    if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                        layoutNode.replace$ui_release();
                        this.onPositionedDispatcher.onNodePositioned(layoutNode);
                    }
                    drainPostponedMeasureRequests();
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } catch (Throwable th) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw th;
                }
            }
            callOnLayoutCompletedListeners();
        }
    }

    /* JADX INFO: finally extract failed */
    private final void performMeasureAndLayout(boolean z, Function0<Unit> function0) {
        if (!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = z;
            try {
                function0.invoke();
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                throw th;
            }
        }
    }

    public final void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        this.onLayoutCompletedListeners.add(onLayoutCompletedListener);
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((Owner.OnLayoutCompletedListener) content[i]).onLayoutComplete();
                i++;
            } while (i < size);
        }
        this.onLayoutCompletedListeners.clear();
    }

    static /* synthetic */ boolean remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return measureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(layoutNode, z, z2);
    }

    private final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode, boolean z, boolean z2) {
        Constraints constraints;
        LayoutNode parent$ui_release;
        boolean z3 = false;
        if (layoutNode.isDeactivated()) {
            return false;
        }
        if (!layoutNode.isPlaced() && !layoutNode.isPlacedByParent() && !getCanAffectParent(layoutNode) && !Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) && !getCanAffectParentInLookahead(layoutNode) && !layoutNode.getAlignmentLinesRequired$ui_release()) {
            return false;
        }
        if (layoutNode == this.root) {
            constraints = this.rootConstraints;
            Intrinsics.checkNotNull(constraints);
        } else {
            constraints = null;
        }
        if (z) {
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                z3 = m6073doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
            }
            if (z2 && ((z3 || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true))) {
                layoutNode.lookaheadReplace$ui_release();
            }
        } else {
            boolean r6 = layoutNode.getMeasurePending$ui_release() ? m6074doRemeasuresdFAvZA(layoutNode, constraints) : false;
            if (z2 && layoutNode.getLayoutPending$ui_release() && (layoutNode == this.root || ((parent$ui_release = layoutNode.getParent$ui_release()) != null && parent$ui_release.isPlaced() && layoutNode.isPlacedByParent()))) {
                if (layoutNode == this.root) {
                    layoutNode.place$ui_release(0, 0);
                } else {
                    layoutNode.replace$ui_release();
                }
                this.onPositionedDispatcher.onNodePositioned(layoutNode);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            }
            z3 = r6;
        }
        drainPostponedMeasureRequests();
        return z3;
    }

    private final void drainPostponedMeasureRequests() {
        if (this.postponedMeasureRequests.isNotEmpty()) {
            MutableVector<PostponedRequest> mutableVector = this.postponedMeasureRequests;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    PostponedRequest postponedRequest = (PostponedRequest) content[i];
                    if (postponedRequest.getNode().isAttached()) {
                        if (!postponedRequest.isLookahead()) {
                            LayoutNode.requestRemeasure$ui_release$default(postponedRequest.getNode(), postponedRequest.isForced(), false, false, 2, (Object) null);
                        } else {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(postponedRequest.getNode(), postponedRequest.isForced(), false, false, 2, (Object) null);
                        }
                    }
                    i++;
                } while (i < size);
            }
            this.postponedMeasureRequests.clear();
        }
    }

    private final void remeasureOnly(LayoutNode layoutNode, boolean z) {
        Constraints constraints;
        if (!layoutNode.isDeactivated()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (z) {
                m6073doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
            } else {
                m6074doRemeasuresdFAvZA(layoutNode, constraints);
            }
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        if (!this.relayoutNodes.isEmpty(z)) {
            if (!this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
            }
            if (measurePending(layoutNode, z)) {
                InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
            }
            forceMeasureTheSubtreeInternal(layoutNode, z);
        }
    }

    private final void onlyRemeasureIfScheduled(LayoutNode layoutNode, boolean z) {
        if (measurePending(layoutNode, z) && this.relayoutNodes.contains(layoutNode, z)) {
            remeasureAndRelayoutIfNeeded(layoutNode, z, false);
        }
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void dispatchOnPositionedCallbacks(boolean z) {
        if (z) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void onNodeDetached(LayoutNode layoutNode) {
        this.relayoutNodes.remove(layoutNode);
        this.onPositionedDispatcher.remove(layoutNode);
    }

    private final boolean getMeasureAffectsParent(LayoutNode layoutNode) {
        return layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release();
    }

    private final boolean getCanAffectParent(LayoutNode layoutNode) {
        return layoutNode.getMeasurePending$ui_release() && getMeasureAffectsParent(layoutNode);
    }

    private final boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        return layoutNode.getLookaheadMeasurePending$ui_release() && getMeasureAffectsParentLookahead(layoutNode);
    }

    private final boolean getMeasureAffectsParentLookahead(LayoutNode layoutNode) {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release;
        AlignmentLines alignmentLines;
        if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || ((lookaheadAlignmentLinesOwner$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release()) != null && (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) != null && alignmentLines.getRequired$ui_release())) {
            return true;
        }
        return false;
    }

    private final boolean measurePending(LayoutNode layoutNode, boolean z) {
        return z ? layoutNode.getLookaheadMeasurePending$ui_release() : layoutNode.getMeasurePending$ui_release();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "()Z", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MeasureAndLayoutDelegate.kt */
    public static final class PostponedRequest {
        public static final int $stable = 8;
        private final boolean isForced;
        private final boolean isLookahead;
        private final LayoutNode node;

        public PostponedRequest(LayoutNode layoutNode, boolean z, boolean z2) {
            this.node = layoutNode;
            this.isLookahead = z;
            this.isForced = z2;
        }

        public final LayoutNode getNode() {
            return this.node;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isLookahead() {
            return this.isLookahead;
        }
    }

    public final boolean measureAndLayout(Function0<Unit> function0) {
        Throwable th;
        MeasureAndLayoutDelegate measureAndLayoutDelegate;
        MeasureAndLayoutDelegate measureAndLayoutDelegate2;
        boolean z;
        LayoutNode layoutNode;
        if (!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        boolean z2 = false;
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = true;
            try {
                if (this.relayoutNodes.isNotEmpty()) {
                    DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
                    z = false;
                    while (depthSortedSetsForDifferentPasses.isNotEmpty()) {
                        boolean isEmpty = depthSortedSetsForDifferentPasses.lookaheadSet.isEmpty();
                        boolean z3 = !isEmpty;
                        if (!isEmpty) {
                            try {
                                layoutNode = depthSortedSetsForDifferentPasses.lookaheadSet.pop();
                            } catch (Throwable th2) {
                                th = th2;
                                measureAndLayoutDelegate = this;
                                measureAndLayoutDelegate.duringMeasureLayout = false;
                                measureAndLayoutDelegate.duringFullMeasureLayoutPass = false;
                                throw th;
                            }
                        } else {
                            layoutNode = depthSortedSetsForDifferentPasses.set.pop();
                        }
                        LayoutNode layoutNode2 = layoutNode;
                        measureAndLayoutDelegate = this;
                        try {
                            boolean remeasureAndRelayoutIfNeeded$default = remeasureAndRelayoutIfNeeded$default(measureAndLayoutDelegate, layoutNode2, z3, false, 4, (Object) null);
                            if (layoutNode2 == this.root && remeasureAndRelayoutIfNeeded$default) {
                                z = true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            measureAndLayoutDelegate.duringMeasureLayout = false;
                            measureAndLayoutDelegate.duringFullMeasureLayoutPass = false;
                            throw th;
                        }
                    }
                    measureAndLayoutDelegate2 = this;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    measureAndLayoutDelegate2 = this;
                    z = false;
                }
                measureAndLayoutDelegate2.duringMeasureLayout = false;
                measureAndLayoutDelegate2.duringFullMeasureLayoutPass = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = measureAndLayoutDelegate2.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                z2 = z;
            } catch (Throwable th4) {
                th = th4;
                measureAndLayoutDelegate = this;
                th = th;
                measureAndLayoutDelegate.duringMeasureLayout = false;
                measureAndLayoutDelegate.duringFullMeasureLayoutPass = false;
                throw th;
            }
        }
        callOnLayoutCompletedListeners();
        return z2;
    }

    private final void remeasureLookaheadRootsInSubtree(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i];
                if (getMeasureAffectsParent(layoutNode2)) {
                    if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(layoutNode2)) {
                        remeasureOnly(layoutNode2, true);
                    } else {
                        remeasureLookaheadRootsInSubtree(layoutNode2);
                    }
                }
                i++;
            } while (i < size);
        }
    }

    private final void ensureSubtreeLookaheadReplaced(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i];
                if (Intrinsics.areEqual((Object) layoutNode2.isPlacedInLookahead(), (Object) true) && !layoutNode2.isDeactivated()) {
                    if (this.relayoutNodes.contains(layoutNode2, true)) {
                        layoutNode2.lookaheadReplace$ui_release();
                    }
                    ensureSubtreeLookaheadReplaced(layoutNode2);
                }
                i++;
            } while (i < size);
        }
    }

    private final void forceMeasureTheSubtreeInternal(LayoutNode layoutNode, boolean z) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i];
                if ((!z && getMeasureAffectsParent(layoutNode2)) || (z && getMeasureAffectsParentLookahead(layoutNode2))) {
                    if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(layoutNode2) && !z) {
                        if (!layoutNode2.getLookaheadMeasurePending$ui_release() || !this.relayoutNodes.contains(layoutNode2, true)) {
                            forceMeasureTheSubtree(layoutNode2, true);
                        } else {
                            remeasureAndRelayoutIfNeeded(layoutNode2, true, false);
                        }
                    }
                    onlyRemeasureIfScheduled(layoutNode2, z);
                    if (!measurePending(layoutNode2, z)) {
                        forceMeasureTheSubtreeInternal(layoutNode2, z);
                    }
                }
                i++;
            } while (i < size);
        }
        onlyRemeasureIfScheduled(layoutNode, z);
    }
}
