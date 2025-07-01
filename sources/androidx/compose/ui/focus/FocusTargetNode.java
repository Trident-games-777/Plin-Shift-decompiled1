package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00015B\u0005¢\u0006\u0002\u0010\u0006J\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J/\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0'H\bø\u0001\u0000¢\u0006\u0004\b)\u0010*J/\u0010+\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0'H\bø\u0001\u0000¢\u0006\u0004\b,\u0010*J\r\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\b\u00100\u001a\u00020!H\u0002J\r\u00101\u001a\u00020!H\u0000¢\u0006\u0002\b2J\b\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8V@VX\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0015XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "focusState", "getFocusState$annotations", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "isProcessingCustomEnter", "", "isProcessingCustomExit", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "()I", "setPreviouslyFocusedChildHash", "(I)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "commitFocusState", "", "commitFocusState$ui_release", "fetchCustomEnter", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "initializeFocusState", "invalidateFocus", "invalidateFocus$ui_release", "onDetach", "onObservedReadsChanged", "FocusTargetElement", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTargetNode.kt */
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private FocusStateImpl committedFocusState;
    /* access modifiers changed from: private */
    public boolean isProcessingCustomEnter;
    /* access modifiers changed from: private */
    public boolean isProcessingCustomExit;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.focus.FocusStateImpl[] r0 = androidx.compose.ui.focus.FocusStateImpl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Captured     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getFocusState$annotations() {
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public FocusStateImpl getFocusState() {
        FocusStateImpl uncommittedFocusState;
        FocusTransactionManager access$getFocusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(this);
        if (access$getFocusTransactionManager != null && (uncommittedFocusState = access$getFocusTransactionManager.getUncommittedFocusState(this)) != null) {
            return uncommittedFocusState;
        }
        FocusStateImpl focusStateImpl = this.committedFocusState;
        return focusStateImpl == null ? FocusStateImpl.Inactive : focusStateImpl;
    }

    public void setFocusState(FocusStateImpl focusStateImpl) {
        FocusTargetNodeKt.requireTransactionManager(this).setUncommittedFocusState(this, focusStateImpl);
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    public final void setPreviouslyFocusedChildHash(int i) {
        this.previouslyFocusedChildHash = i;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    public void onObservedReadsChanged() {
        FocusStateImpl focusState = getFocusState();
        invalidateFocus$ui_release();
        if (focusState != getFocusState()) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    public void onDetach() {
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            DelegatableNodeKt.requireOwner(this).getFocusOwner().m3909clearFocusI7lrPNg(true, true, false, FocusDirection.Companion.m3900getExitdhqQ8s());
            FocusTargetNodeKt.invalidateFocusTarget(this);
        } else if (i == 3) {
            FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
            try {
                if (requireTransactionManager.ongoingTransaction) {
                    requireTransactionManager.cancelTransaction();
                }
                requireTransactionManager.beginTransaction();
                setFocusState(FocusStateImpl.Inactive);
                Unit unit = Unit.INSTANCE;
            } finally {
                requireTransactionManager.commitTransaction();
            }
        }
        this.committedFocusState = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00be, code lost:
        r6 = r1.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.focus.FocusProperties fetchFocusProperties$ui_release() {
        /*
            r15 = this;
            androidx.compose.ui.focus.FocusPropertiesImpl r0 = new androidx.compose.ui.focus.FocusPropertiesImpl
            r0.<init>()
            r1 = r15
            androidx.compose.ui.node.DelegatableNode r1 = (androidx.compose.ui.node.DelegatableNode) r1
            r2 = 2048(0x800, float:2.87E-42)
            int r2 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r2)
            r3 = 1024(0x400, float:1.435E-42)
            int r3 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r3)
            androidx.compose.ui.Modifier$Node r4 = r1.getNode()
            r5 = r2 | r3
            androidx.compose.ui.Modifier$Node r6 = r1.getNode()
            boolean r6 = r6.isAttached()
            if (r6 == 0) goto L_0x00d0
            androidx.compose.ui.Modifier$Node r6 = r1.getNode()
            androidx.compose.ui.node.LayoutNode r1 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r1)
        L_0x002c:
            if (r1 == 0) goto L_0x00cd
            androidx.compose.ui.node.NodeChain r7 = r1.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r7 = r7.getHead$ui_release()
            int r7 = r7.getAggregateChildKindSet$ui_release()
            r7 = r7 & r5
            r8 = 0
            if (r7 == 0) goto L_0x00b8
        L_0x003e:
            if (r6 == 0) goto L_0x00b8
            int r7 = r6.getKindSet$ui_release()
            r7 = r7 & r5
            if (r7 == 0) goto L_0x00b3
            if (r6 == r4) goto L_0x0052
            int r7 = r6.getKindSet$ui_release()
            r7 = r7 & r3
            if (r7 == 0) goto L_0x0052
            goto L_0x00cd
        L_0x0052:
            int r7 = r6.getKindSet$ui_release()
            r7 = r7 & r2
            if (r7 == 0) goto L_0x00b3
            r7 = r6
            r9 = r8
        L_0x005b:
            if (r7 == 0) goto L_0x00b3
            boolean r10 = r7 instanceof androidx.compose.ui.focus.FocusPropertiesModifierNode
            if (r10 == 0) goto L_0x006a
            androidx.compose.ui.focus.FocusPropertiesModifierNode r7 = (androidx.compose.ui.focus.FocusPropertiesModifierNode) r7
            r10 = r0
            androidx.compose.ui.focus.FocusProperties r10 = (androidx.compose.ui.focus.FocusProperties) r10
            r7.applyFocusProperties(r10)
            goto L_0x00ae
        L_0x006a:
            int r10 = r7.getKindSet$ui_release()
            r10 = r10 & r2
            if (r10 == 0) goto L_0x00ae
            boolean r10 = r7 instanceof androidx.compose.ui.node.DelegatingNode
            if (r10 == 0) goto L_0x00ae
            r10 = r7
            androidx.compose.ui.node.DelegatingNode r10 = (androidx.compose.ui.node.DelegatingNode) r10
            androidx.compose.ui.Modifier$Node r10 = r10.getDelegate$ui_release()
            r11 = 0
            r12 = r11
        L_0x007e:
            r13 = 1
            if (r10 == 0) goto L_0x00ab
            int r14 = r10.getKindSet$ui_release()
            r14 = r14 & r2
            if (r14 == 0) goto L_0x00a6
            int r12 = r12 + 1
            if (r12 != r13) goto L_0x008e
            r7 = r10
            goto L_0x00a6
        L_0x008e:
            if (r9 != 0) goto L_0x0099
            androidx.compose.runtime.collection.MutableVector r9 = new androidx.compose.runtime.collection.MutableVector
            r13 = 16
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r13]
            r9.<init>(r13, r11)
        L_0x0099:
            if (r7 == 0) goto L_0x00a1
            if (r9 == 0) goto L_0x00a0
            r9.add(r7)
        L_0x00a0:
            r7 = r8
        L_0x00a1:
            if (r9 == 0) goto L_0x00a6
            r9.add(r10)
        L_0x00a6:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild$ui_release()
            goto L_0x007e
        L_0x00ab:
            if (r12 != r13) goto L_0x00ae
            goto L_0x005b
        L_0x00ae:
            androidx.compose.ui.Modifier$Node r7 = androidx.compose.ui.node.DelegatableNodeKt.pop(r9)
            goto L_0x005b
        L_0x00b3:
            androidx.compose.ui.Modifier$Node r6 = r6.getParent$ui_release()
            goto L_0x003e
        L_0x00b8:
            androidx.compose.ui.node.LayoutNode r1 = r1.getParent$ui_release()
            if (r1 == 0) goto L_0x00ca
            androidx.compose.ui.node.NodeChain r6 = r1.getNodes$ui_release()
            if (r6 == 0) goto L_0x00ca
            androidx.compose.ui.Modifier$Node r6 = r6.getTail$ui_release()
            goto L_0x002c
        L_0x00ca:
            r6 = r8
            goto L_0x002c
        L_0x00cd:
            androidx.compose.ui.focus.FocusProperties r0 = (androidx.compose.ui.focus.FocusProperties) r0
            return r0
        L_0x00d0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitAncestors called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.fetchFocusProperties$ui_release():androidx.compose.ui.focus.FocusProperties");
    }

    /* renamed from: fetchCustomEnter-aToIllA$ui_release  reason: not valid java name */
    public final void m3932fetchCustomEnteraToIllA$ui_release(int i, Function1<? super FocusRequester, Unit> function1) {
        if (!this.isProcessingCustomEnter) {
            this.isProcessingCustomEnter = true;
            try {
                FocusRequester invoke = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m3889boximpl(i));
                if (invoke != FocusRequester.Companion.getDefault()) {
                    function1.invoke(invoke);
                }
            } finally {
                this.isProcessingCustomEnter = false;
            }
        }
    }

    /* renamed from: fetchCustomExit-aToIllA$ui_release  reason: not valid java name */
    public final void m3933fetchCustomExitaToIllA$ui_release(int i, Function1<? super FocusRequester, Unit> function1) {
        if (!this.isProcessingCustomExit) {
            this.isProcessingCustomExit = true;
            try {
                FocusRequester invoke = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m3889boximpl(i));
                if (invoke != FocusRequester.Companion.getDefault()) {
                    function1.invoke(invoke);
                }
            } finally {
                this.isProcessingCustomExit = false;
            }
        }
    }

    public final void commitFocusState$ui_release() {
        FocusStateImpl uncommittedFocusState = FocusTargetNodeKt.requireTransactionManager(this).getUncommittedFocusState(this);
        if (uncommittedFocusState != null) {
            this.committedFocusState = uncommittedFocusState;
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("committing a node that was not updated in the current transaction");
            throw new KotlinNothingValueException();
        }
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        if (this.committedFocusState == null) {
            initializeFocusState();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ObserverModifierNodeKt.observeReads(this, new FocusTargetNode$invalidateFocus$1(objectRef, this));
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                focusProperties = null;
            } else {
                focusProperties = (FocusProperties) objectRef.element;
            }
            if (!focusProperties.getCanFocus()) {
                DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetNode.kt */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final int $stable = 0;
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        public boolean equals(Object obj) {
            return obj == this;
        }

        public void update(FocusTargetNode focusTargetNode) {
        }

        private FocusTargetElement() {
        }

        public FocusTargetNode create() {
            return new FocusTargetNode();
        }

        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("focusTarget");
        }

        public int hashCode() {
            return "focusTarget".hashCode();
        }
    }

    private static final boolean initializeFocusState$isInitialized(FocusTargetNode focusTargetNode) {
        return focusTargetNode.committedFocusState != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00be, code lost:
        r1 = r10.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean initializeFocusState$isInActiveSubTree(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.node.DelegatableNode r10 = (androidx.compose.ui.node.DelegatableNode) r10
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x00ce
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r10 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r10)
        L_0x001e:
            r2 = 0
            if (r10 == 0) goto L_0x00cd
            androidx.compose.ui.node.NodeChain r3 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r0
            r4 = 0
            if (r3 == 0) goto L_0x00b8
        L_0x0031:
            if (r1 == 0) goto L_0x00b8
            int r3 = r1.getKindSet$ui_release()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00b2
            r3 = r1
            r5 = r4
        L_0x003c:
            if (r3 == 0) goto L_0x00b2
            boolean r6 = r3 instanceof androidx.compose.ui.focus.FocusTargetNode
            r7 = 1
            if (r6 == 0) goto L_0x006b
            androidx.compose.ui.focus.FocusTargetNode r3 = (androidx.compose.ui.focus.FocusTargetNode) r3
            boolean r6 = initializeFocusState$isInitialized(r3)
            if (r6 == 0) goto L_0x00ad
            androidx.compose.ui.focus.FocusStateImpl r10 = r3.getFocusState()
            int[] r0 = androidx.compose.ui.focus.FocusTargetNode.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 == r7) goto L_0x006a
            r0 = 2
            if (r10 == r0) goto L_0x006a
            r0 = 3
            if (r10 == r0) goto L_0x0069
            r0 = 4
            if (r10 != r0) goto L_0x0063
            goto L_0x006a
        L_0x0063:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x0069:
            return r7
        L_0x006a:
            return r2
        L_0x006b:
            int r6 = r3.getKindSet$ui_release()
            r6 = r6 & r0
            if (r6 == 0) goto L_0x00ad
            boolean r6 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L_0x00ad
            r6 = r3
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r8 = r2
        L_0x007e:
            if (r6 == 0) goto L_0x00aa
            int r9 = r6.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x00a5
            int r8 = r8 + 1
            if (r8 != r7) goto L_0x008d
            r3 = r6
            goto L_0x00a5
        L_0x008d:
            if (r5 != 0) goto L_0x0098
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r2)
        L_0x0098:
            if (r3 == 0) goto L_0x00a0
            if (r5 == 0) goto L_0x009f
            r5.add(r3)
        L_0x009f:
            r3 = r4
        L_0x00a0:
            if (r5 == 0) goto L_0x00a5
            r5.add(r6)
        L_0x00a5:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L_0x007e
        L_0x00aa:
            if (r8 != r7) goto L_0x00ad
            goto L_0x003c
        L_0x00ad:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x003c
        L_0x00b2:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0031
        L_0x00b8:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x00ca
            androidx.compose.ui.node.NodeChain r1 = r10.getNodes$ui_release()
            if (r1 == 0) goto L_0x00ca
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x001e
        L_0x00ca:
            r1 = r4
            goto L_0x001e
        L_0x00cd:
            return r2
        L_0x00ce:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.initializeFocusState$isInActiveSubTree(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    private static final boolean initializeFocusState$hasActiveChild(FocusTargetNode focusTargetNode) {
        DelegatableNode delegatableNode = focusTargetNode;
        int r0 = NodeKind.m6139constructorimpl(1024);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & r0) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild$ui_release()) {
                    if ((node2.getKindSet$ui_release() & r0) != 0) {
                        Modifier.Node node3 = node2;
                        MutableVector mutableVector2 = null;
                        while (node3 != null) {
                            if (node3 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                if (initializeFocusState$isInitialized(focusTargetNode2)) {
                                    int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode2.getFocusState().ordinal()];
                                    if (i == 1 || i == 2 || i == 3) {
                                        return true;
                                    }
                                    if (i == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if ((node3.getKindSet$ui_release() & r0) != 0 && (node3 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node3 = delegate$ui_release;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node3);
                                                }
                                                node3 = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector2);
                        }
                        continue;
                    }
                }
                continue;
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
        }
        return false;
    }

    private final void initializeFocusState() {
        if (!initializeFocusState$isInitialized(this)) {
            FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
            try {
                if (requireTransactionManager.ongoingTransaction) {
                    requireTransactionManager.cancelTransaction();
                }
                requireTransactionManager.beginTransaction();
                setFocusState((!initializeFocusState$isInActiveSubTree(this) || !initializeFocusState$hasActiveChild(this)) ? FocusStateImpl.Inactive : FocusStateImpl.ActiveParent);
                Unit unit = Unit.INSTANCE;
            } finally {
                requireTransactionManager.commitTransaction();
            }
        } else {
            throw new IllegalStateException("Re-initializing focus target node.".toString());
        }
    }
}
