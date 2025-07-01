package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012:\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000eH\u0016J2\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0016J:\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\f2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010C\u001a\u00020\u0005H\u0002J\u001a\u0010D\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\b\u0010G\u001a\u00020\u0005H\u0016J$\u0010H\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0002\bIJ\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020MH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\"H\u0016J$\u0010N\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001a\u0010Q\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u00105J\u000e\u0010S\u001a\u0004\u0018\u00010T*\u00020UH\u0002J3\u0010V\u001a\u0004\u0018\u0001HW\"\n\b\u0000\u0010W\u0018\u0001*\u00020X*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0ZH\bø\u0001\u0000¢\u0006\u0004\b[\u0010\\Jg\u0010]\u001a\u00020\u0005\"\n\b\u0000\u0010W\u0018\u0001*\u00020U*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u0003H\bø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onRequestFocusForOwner", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Lkotlin/ParameterName;", "name", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "onLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "invalidateOwnerFocusState", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "requestFocusForOwner", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "nearestAncestorIncludingSelf", "T", "", "type", "Landroidx/compose/ui/node/NodeKind;", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "traverseAncestorsIncludingSelf", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private final FocusInvalidationManager focusInvalidationManager;
    private final FocusTransactionManager focusTransactionManager;
    private MutableLongSet keysCurrentlyDown;
    private final Modifier modifier;
    private final Function0<Unit> onClearFocusForOwner;
    private final Function0<Rect> onFocusRectInterop;
    private final Function0<LayoutDirection> onLayoutDirection;
    private final Function1<FocusDirection, Boolean> onMoveFocusInterop;
    private final Function2<FocusDirection, Rect, Boolean> onRequestFocusForOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusOwnerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.focus.CustomDestinationResult[] r0 = androidx.compose.ui.focus.CustomDestinationResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.Redirected     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.Cancelled     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.RedirectCancelled     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.None     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.WhenMappings.<clinit>():void");
        }
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1, Function2<? super FocusDirection, ? super Rect, Boolean> function2, Function1<? super FocusDirection, Boolean> function12, Function0<Unit> function0, Function0<Rect> function02, Function0<? extends LayoutDirection> function03) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function12;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function02;
        this.onLayoutDirection = function03;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
        this.focusTransactionManager = new FocusTransactionManager();
        this.modifier = FocusPropertiesKt.focusProperties(Modifier.Companion, FocusOwnerImpl$modifier$1.INSTANCE).then(new FocusOwnerImpl$modifier$2(this));
    }

    public final FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    /* renamed from: requestFocusForOwner-7o62pno  reason: not valid java name */
    public boolean m3923requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect rect) {
        return this.onRequestFocusForOwner.invoke(focusDirection, rect).booleanValue();
    }

    /* renamed from: takeFocus-aToIllA  reason: not valid java name */
    public boolean m3924takeFocusaToIllA(int i, Rect rect) {
        Boolean r2 = m3921focusSearchULY8qGw(i, rect, new FocusOwnerImpl$takeFocus$1(i));
        if (r2 != null) {
            return r2.booleanValue();
        }
        return false;
    }

    public void releaseFocus() {
        FocusTransactionManager focusTransactionManager2 = getFocusTransactionManager();
        if (focusTransactionManager2.ongoingTransaction) {
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
            return;
        }
        try {
            focusTransactionManager2.beginTransaction();
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        } finally {
            focusTransactionManager2.commitTransaction();
        }
    }

    public void clearFocus(boolean z) {
        m3918clearFocusI7lrPNg(z, true, true, FocusDirection.Companion.m3900getExitdhqQ8s());
    }

    /* renamed from: clearFocus-I7lrPNg  reason: not valid java name */
    public boolean m3918clearFocusI7lrPNg(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        FocusTransactionManager focusTransactionManager2 = getFocusTransactionManager();
        Function0 function0 = FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.INSTANCE;
        try {
            if (focusTransactionManager2.ongoingTransaction) {
                focusTransactionManager2.cancelTransaction();
            }
            focusTransactionManager2.beginTransaction();
            if (function0 != null) {
                focusTransactionManager2.cancellationListener.add(function0);
            }
            if (!z) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m3934performCustomClearFocusMxy_nc0(this.rootFocusNode, i).ordinal()];
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    z4 = false;
                    if (z4 && z3) {
                        this.onClearFocusForOwner.invoke();
                    }
                    return z4;
                }
            }
            z4 = FocusTransactionsKt.clearFocus(this.rootFocusNode, z, z2);
            this.onClearFocusForOwner.invoke();
            return z4;
        } finally {
            focusTransactionManager2.commitTransaction();
        }
    }

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    public boolean m3922moveFocus3ESFkO8(int i) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        Boolean r2 = m3921focusSearchULY8qGw(i, this.onFocusRectInterop.invoke(), new FocusOwnerImpl$moveFocus$focusSearchSuccess$1(objectRef, i));
        if (r2 == null || objectRef.element == null) {
            return false;
        }
        if (Intrinsics.areEqual((Object) r2, (Object) true) && Intrinsics.areEqual((Object) objectRef.element, (Object) true)) {
            return true;
        }
        if (!FocusOwnerImplKt.m3925is1dFocusSearch3ESFkO8(i)) {
            return this.onMoveFocusInterop.invoke(FocusDirection.m3889boximpl(i)).booleanValue();
        }
        if (!m3918clearFocusI7lrPNg(false, true, false, i) || !m3924takeFocusaToIllA(i, (Rect) null)) {
            return false;
        }
        return true;
    }

    /* renamed from: focusSearch-ULY8qGw  reason: not valid java name */
    public Boolean m3921focusSearchULY8qGw(int i, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            FocusRequester r2 = FocusTraversalKt.m3939customFocusSearchOMvw8(findActiveFocusNode, i, this.onLayoutDirection.invoke());
            if (Intrinsics.areEqual((Object) r2, (Object) FocusRequester.Companion.getCancel())) {
                return null;
            }
            if (!Intrinsics.areEqual((Object) r2, (Object) FocusRequester.Companion.getDefault())) {
                return Boolean.valueOf(r2.findFocusTargetNode$ui_release(function1));
            }
        } else {
            findActiveFocusNode = null;
        }
        return FocusTraversalKt.m3940focusSearch0X8WOeE(this.rootFocusNode, i, this.onLayoutDirection.invoke(), rect, new FocusOwnerImpl$focusSearch$1(findActiveFocusNode, this, function1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c4, code lost:
        r10 = r2.getNodes$ui_release();
     */
    /* renamed from: dispatchKeyEvent-YhN2O0w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3920dispatchKeyEventYhN2O0w(android.view.KeyEvent r17, kotlin.jvm.functions.Function0<java.lang.Boolean> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            androidx.compose.ui.focus.FocusInvalidationManager r2 = r0.focusInvalidationManager
            boolean r2 = r2.hasPendingInvalidation()
            if (r2 != 0) goto L_0x0373
            boolean r2 = r16.m3917validateKeyEventZmokQxo(r17)
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            androidx.compose.ui.focus.FocusTargetNode r2 = r0.rootFocusNode
            androidx.compose.ui.focus.FocusTargetNode r2 = androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(r2)
            java.lang.String r4 = "visitAncestors called on an unattached node"
            r5 = 8192(0x2000, float:1.14794E-41)
            r6 = 16
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x002e
            r9 = r2
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
            androidx.compose.ui.Modifier$Node r9 = r0.lastLocalKeyInputNode(r9)
            if (r9 != 0) goto L_0x019c
        L_0x002e:
            if (r2 == 0) goto L_0x00e8
            androidx.compose.ui.node.DelegatableNode r2 = (androidx.compose.ui.node.DelegatableNode) r2
            int r9 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r5)
            androidx.compose.ui.Modifier$Node r10 = r2.getNode()
            boolean r10 = r10.isAttached()
            if (r10 == 0) goto L_0x00de
            androidx.compose.ui.Modifier$Node r10 = r2.getNode()
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r2)
        L_0x0048:
            if (r2 == 0) goto L_0x00d3
            androidx.compose.ui.node.NodeChain r11 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r11 = r11.getHead$ui_release()
            int r11 = r11.getAggregateChildKindSet$ui_release()
            r11 = r11 & r9
            if (r11 == 0) goto L_0x00be
        L_0x0059:
            if (r10 == 0) goto L_0x00be
            int r11 = r10.getKindSet$ui_release()
            r11 = r11 & r9
            if (r11 == 0) goto L_0x00b9
            r12 = r7
            r11 = r10
        L_0x0064:
            if (r11 == 0) goto L_0x00b9
            boolean r13 = r11 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r13 == 0) goto L_0x006c
            goto L_0x00d4
        L_0x006c:
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r9
            if (r13 == 0) goto L_0x00b4
            boolean r13 = r11 instanceof androidx.compose.ui.node.DelegatingNode
            if (r13 == 0) goto L_0x00b4
            r13 = r11
            androidx.compose.ui.node.DelegatingNode r13 = (androidx.compose.ui.node.DelegatingNode) r13
            androidx.compose.ui.Modifier$Node r13 = r13.getDelegate$ui_release()
            r14 = r3
        L_0x007f:
            if (r13 == 0) goto L_0x00b1
            int r15 = r13.getKindSet$ui_release()
            r15 = r15 & r9
            if (r15 == 0) goto L_0x00ac
            int r14 = r14 + 1
            if (r14 != r8) goto L_0x008e
            r11 = r13
            goto L_0x00ac
        L_0x008e:
            if (r12 != 0) goto L_0x0097
            androidx.compose.runtime.collection.MutableVector r12 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r15 = new androidx.compose.ui.Modifier.Node[r6]
            r12.<init>(r15, r3)
        L_0x0097:
            if (r11 == 0) goto L_0x00a3
            if (r12 == 0) goto L_0x00a2
            boolean r11 = r12.add(r11)
            java.lang.Boolean.valueOf(r11)
        L_0x00a2:
            r11 = r7
        L_0x00a3:
            if (r12 == 0) goto L_0x00ac
            boolean r15 = r12.add(r13)
            java.lang.Boolean.valueOf(r15)
        L_0x00ac:
            androidx.compose.ui.Modifier$Node r13 = r13.getChild$ui_release()
            goto L_0x007f
        L_0x00b1:
            if (r14 != r8) goto L_0x00b4
            goto L_0x0064
        L_0x00b4:
            androidx.compose.ui.Modifier$Node r11 = androidx.compose.ui.node.DelegatableNodeKt.pop(r12)
            goto L_0x0064
        L_0x00b9:
            androidx.compose.ui.Modifier$Node r10 = r10.getParent$ui_release()
            goto L_0x0059
        L_0x00be:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x00d0
            androidx.compose.ui.node.NodeChain r10 = r2.getNodes$ui_release()
            if (r10 == 0) goto L_0x00d0
            androidx.compose.ui.Modifier$Node r10 = r10.getTail$ui_release()
            goto L_0x0048
        L_0x00d0:
            r10 = r7
            goto L_0x0048
        L_0x00d3:
            r11 = r7
        L_0x00d4:
            androidx.compose.ui.input.key.KeyInputModifierNode r11 = (androidx.compose.ui.input.key.KeyInputModifierNode) r11
            if (r11 == 0) goto L_0x00e8
            androidx.compose.ui.Modifier$Node r9 = r11.getNode()
            goto L_0x019c
        L_0x00de:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r4.toString()
            r1.<init>(r2)
            throw r1
        L_0x00e8:
            androidx.compose.ui.focus.FocusTargetNode r2 = r0.rootFocusNode
            androidx.compose.ui.node.DelegatableNode r2 = (androidx.compose.ui.node.DelegatableNode) r2
            int r9 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r5)
            androidx.compose.ui.Modifier$Node r10 = r2.getNode()
            boolean r10 = r10.isAttached()
            if (r10 == 0) goto L_0x0369
            androidx.compose.ui.Modifier$Node r10 = r2.getNode()
            androidx.compose.ui.Modifier$Node r10 = r10.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r2)
        L_0x0106:
            if (r2 == 0) goto L_0x0191
            androidx.compose.ui.node.NodeChain r11 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r11 = r11.getHead$ui_release()
            int r11 = r11.getAggregateChildKindSet$ui_release()
            r11 = r11 & r9
            if (r11 == 0) goto L_0x017c
        L_0x0117:
            if (r10 == 0) goto L_0x017c
            int r11 = r10.getKindSet$ui_release()
            r11 = r11 & r9
            if (r11 == 0) goto L_0x0177
            r12 = r7
            r11 = r10
        L_0x0122:
            if (r11 == 0) goto L_0x0177
            boolean r13 = r11 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r13 == 0) goto L_0x012a
            goto L_0x0192
        L_0x012a:
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r9
            if (r13 == 0) goto L_0x0172
            boolean r13 = r11 instanceof androidx.compose.ui.node.DelegatingNode
            if (r13 == 0) goto L_0x0172
            r13 = r11
            androidx.compose.ui.node.DelegatingNode r13 = (androidx.compose.ui.node.DelegatingNode) r13
            androidx.compose.ui.Modifier$Node r13 = r13.getDelegate$ui_release()
            r14 = r3
        L_0x013d:
            if (r13 == 0) goto L_0x016f
            int r15 = r13.getKindSet$ui_release()
            r15 = r15 & r9
            if (r15 == 0) goto L_0x016a
            int r14 = r14 + 1
            if (r14 != r8) goto L_0x014c
            r11 = r13
            goto L_0x016a
        L_0x014c:
            if (r12 != 0) goto L_0x0155
            androidx.compose.runtime.collection.MutableVector r12 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r15 = new androidx.compose.ui.Modifier.Node[r6]
            r12.<init>(r15, r3)
        L_0x0155:
            if (r11 == 0) goto L_0x0161
            if (r12 == 0) goto L_0x0160
            boolean r11 = r12.add(r11)
            java.lang.Boolean.valueOf(r11)
        L_0x0160:
            r11 = r7
        L_0x0161:
            if (r12 == 0) goto L_0x016a
            boolean r15 = r12.add(r13)
            java.lang.Boolean.valueOf(r15)
        L_0x016a:
            androidx.compose.ui.Modifier$Node r13 = r13.getChild$ui_release()
            goto L_0x013d
        L_0x016f:
            if (r14 != r8) goto L_0x0172
            goto L_0x0122
        L_0x0172:
            androidx.compose.ui.Modifier$Node r11 = androidx.compose.ui.node.DelegatableNodeKt.pop(r12)
            goto L_0x0122
        L_0x0177:
            androidx.compose.ui.Modifier$Node r10 = r10.getParent$ui_release()
            goto L_0x0117
        L_0x017c:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x018e
            androidx.compose.ui.node.NodeChain r10 = r2.getNodes$ui_release()
            if (r10 == 0) goto L_0x018e
            androidx.compose.ui.Modifier$Node r10 = r10.getTail$ui_release()
            goto L_0x0106
        L_0x018e:
            r10 = r7
            goto L_0x0106
        L_0x0191:
            r11 = r7
        L_0x0192:
            androidx.compose.ui.input.key.KeyInputModifierNode r11 = (androidx.compose.ui.input.key.KeyInputModifierNode) r11
            if (r11 == 0) goto L_0x019b
            androidx.compose.ui.Modifier$Node r9 = r11.getNode()
            goto L_0x019c
        L_0x019b:
            r9 = r7
        L_0x019c:
            if (r9 == 0) goto L_0x0368
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
            int r2 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r5)
            androidx.compose.ui.Modifier$Node r5 = r9.getNode()
            boolean r5 = r5.isAttached()
            if (r5 == 0) goto L_0x035e
            androidx.compose.ui.Modifier$Node r4 = r9.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r5 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r9)
            r10 = r7
        L_0x01bb:
            if (r5 == 0) goto L_0x0251
            androidx.compose.ui.node.NodeChain r11 = r5.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r11 = r11.getHead$ui_release()
            int r11 = r11.getAggregateChildKindSet$ui_release()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x023c
        L_0x01cc:
            if (r4 == 0) goto L_0x023c
            int r11 = r4.getKindSet$ui_release()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x0237
            r11 = r4
            r12 = r7
        L_0x01d7:
            if (r11 == 0) goto L_0x0237
            boolean r13 = r11 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r13 == 0) goto L_0x01ea
            if (r10 != 0) goto L_0x01e6
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
        L_0x01e6:
            r10.add(r11)
            goto L_0x0232
        L_0x01ea:
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r2
            if (r13 == 0) goto L_0x0232
            boolean r13 = r11 instanceof androidx.compose.ui.node.DelegatingNode
            if (r13 == 0) goto L_0x0232
            r13 = r11
            androidx.compose.ui.node.DelegatingNode r13 = (androidx.compose.ui.node.DelegatingNode) r13
            androidx.compose.ui.Modifier$Node r13 = r13.getDelegate$ui_release()
            r14 = r3
        L_0x01fd:
            if (r13 == 0) goto L_0x022f
            int r15 = r13.getKindSet$ui_release()
            r15 = r15 & r2
            if (r15 == 0) goto L_0x022a
            int r14 = r14 + 1
            if (r14 != r8) goto L_0x020c
            r11 = r13
            goto L_0x022a
        L_0x020c:
            if (r12 != 0) goto L_0x0215
            androidx.compose.runtime.collection.MutableVector r12 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r15 = new androidx.compose.ui.Modifier.Node[r6]
            r12.<init>(r15, r3)
        L_0x0215:
            if (r11 == 0) goto L_0x0221
            if (r12 == 0) goto L_0x0220
            boolean r11 = r12.add(r11)
            java.lang.Boolean.valueOf(r11)
        L_0x0220:
            r11 = r7
        L_0x0221:
            if (r12 == 0) goto L_0x022a
            boolean r15 = r12.add(r13)
            java.lang.Boolean.valueOf(r15)
        L_0x022a:
            androidx.compose.ui.Modifier$Node r13 = r13.getChild$ui_release()
            goto L_0x01fd
        L_0x022f:
            if (r14 != r8) goto L_0x0232
            goto L_0x01d7
        L_0x0232:
            androidx.compose.ui.Modifier$Node r11 = androidx.compose.ui.node.DelegatableNodeKt.pop(r12)
            goto L_0x01d7
        L_0x0237:
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            goto L_0x01cc
        L_0x023c:
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            if (r5 == 0) goto L_0x024e
            androidx.compose.ui.node.NodeChain r4 = r5.getNodes$ui_release()
            if (r4 == 0) goto L_0x024e
            androidx.compose.ui.Modifier$Node r4 = r4.getTail$ui_release()
            goto L_0x01bb
        L_0x024e:
            r4 = r7
            goto L_0x01bb
        L_0x0251:
            if (r10 == 0) goto L_0x0271
            int r4 = r10.size()
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x026f
        L_0x025b:
            int r5 = r4 + -1
            java.lang.Object r4 = r10.get(r4)
            androidx.compose.ui.input.key.KeyInputModifierNode r4 = (androidx.compose.ui.input.key.KeyInputModifierNode) r4
            boolean r4 = r4.m5438onPreKeyEventZmokQxo(r1)
            if (r4 == 0) goto L_0x026a
            return r8
        L_0x026a:
            if (r5 >= 0) goto L_0x026d
            goto L_0x026f
        L_0x026d:
            r4 = r5
            goto L_0x025b
        L_0x026f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0271:
            androidx.compose.ui.Modifier$Node r4 = r9.getNode()
            r5 = r7
        L_0x0276:
            if (r4 == 0) goto L_0x02d2
            boolean r11 = r4 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r11 == 0) goto L_0x0285
            androidx.compose.ui.input.key.KeyInputModifierNode r4 = (androidx.compose.ui.input.key.KeyInputModifierNode) r4
            boolean r4 = r4.m5438onPreKeyEventZmokQxo(r1)
            if (r4 == 0) goto L_0x02cd
            return r8
        L_0x0285:
            int r11 = r4.getKindSet$ui_release()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x02cd
            boolean r11 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x02cd
            r11 = r4
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r3
        L_0x0298:
            if (r11 == 0) goto L_0x02ca
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r2
            if (r13 == 0) goto L_0x02c5
            int r12 = r12 + 1
            if (r12 != r8) goto L_0x02a7
            r4 = r11
            goto L_0x02c5
        L_0x02a7:
            if (r5 != 0) goto L_0x02b0
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r6]
            r5.<init>(r13, r3)
        L_0x02b0:
            if (r4 == 0) goto L_0x02bc
            if (r5 == 0) goto L_0x02bb
            boolean r4 = r5.add(r4)
            java.lang.Boolean.valueOf(r4)
        L_0x02bb:
            r4 = r7
        L_0x02bc:
            if (r5 == 0) goto L_0x02c5
            boolean r13 = r5.add(r11)
            java.lang.Boolean.valueOf(r13)
        L_0x02c5:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0298
        L_0x02ca:
            if (r12 != r8) goto L_0x02cd
            goto L_0x0276
        L_0x02cd:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x0276
        L_0x02d2:
            java.lang.Object r4 = r18.invoke()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x02df
            return r8
        L_0x02df:
            androidx.compose.ui.Modifier$Node r4 = r9.getNode()
            r5 = r7
        L_0x02e4:
            if (r4 == 0) goto L_0x0340
            boolean r9 = r4 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r9 == 0) goto L_0x02f3
            androidx.compose.ui.input.key.KeyInputModifierNode r4 = (androidx.compose.ui.input.key.KeyInputModifierNode) r4
            boolean r4 = r4.m5437onKeyEventZmokQxo(r1)
            if (r4 == 0) goto L_0x033b
            return r8
        L_0x02f3:
            int r9 = r4.getKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x033b
            boolean r9 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r9 == 0) goto L_0x033b
            r9 = r4
            androidx.compose.ui.node.DelegatingNode r9 = (androidx.compose.ui.node.DelegatingNode) r9
            androidx.compose.ui.Modifier$Node r9 = r9.getDelegate$ui_release()
            r11 = r3
        L_0x0306:
            if (r9 == 0) goto L_0x0338
            int r12 = r9.getKindSet$ui_release()
            r12 = r12 & r2
            if (r12 == 0) goto L_0x0333
            int r11 = r11 + 1
            if (r11 != r8) goto L_0x0315
            r4 = r9
            goto L_0x0333
        L_0x0315:
            if (r5 != 0) goto L_0x031e
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r6]
            r5.<init>(r12, r3)
        L_0x031e:
            if (r4 == 0) goto L_0x032a
            if (r5 == 0) goto L_0x0329
            boolean r4 = r5.add(r4)
            java.lang.Boolean.valueOf(r4)
        L_0x0329:
            r4 = r7
        L_0x032a:
            if (r5 == 0) goto L_0x0333
            boolean r12 = r5.add(r9)
            java.lang.Boolean.valueOf(r12)
        L_0x0333:
            androidx.compose.ui.Modifier$Node r9 = r9.getChild$ui_release()
            goto L_0x0306
        L_0x0338:
            if (r11 != r8) goto L_0x033b
            goto L_0x02e4
        L_0x033b:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x02e4
        L_0x0340:
            if (r10 == 0) goto L_0x035b
            int r2 = r10.size()
            r4 = r3
        L_0x0347:
            if (r4 >= r2) goto L_0x0359
            java.lang.Object r5 = r10.get(r4)
            androidx.compose.ui.input.key.KeyInputModifierNode r5 = (androidx.compose.ui.input.key.KeyInputModifierNode) r5
            boolean r5 = r5.m5437onKeyEventZmokQxo(r1)
            if (r5 == 0) goto L_0x0356
            return r8
        L_0x0356:
            int r4 = r4 + 1
            goto L_0x0347
        L_0x0359:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x035b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0368
        L_0x035e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r4.toString()
            r1.<init>(r2)
            throw r1
        L_0x0368:
            return r3
        L_0x0369:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r4.toString()
            r1.<init>(r2)
            throw r1
        L_0x0373:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Dispatching key event while focus system is invalidated."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3920dispatchKeyEventYhN2O0w(android.view.KeyEvent, kotlin.jvm.functions.Function0):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a6, code lost:
        r8 = r0.getNodes$ui_release();
     */
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3919dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent r15) {
        /*
            r14 = this;
            androidx.compose.ui.focus.FocusInvalidationManager r0 = r14.focusInvalidationManager
            boolean r0 = r0.hasPendingInvalidation()
            if (r0 != 0) goto L_0x0264
            androidx.compose.ui.focus.FocusTargetNode r0 = r14.rootFocusNode
            androidx.compose.ui.focus.FocusTargetNode r0 = androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(r0)
            java.lang.String r1 = "visitAncestors called on an unattached node"
            r2 = 131072(0x20000, float:1.83671E-40)
            r3 = 16
            r4 = 0
            r5 = 0
            r6 = 1
            if (r0 == 0) goto L_0x00c2
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            int r7 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x00b8
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0032:
            if (r0 == 0) goto L_0x00b4
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x00a0
        L_0x0043:
            if (r8 == 0) goto L_0x00a0
            int r9 = r8.getKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x009b
            r10 = r5
            r9 = r8
        L_0x004e:
            if (r9 == 0) goto L_0x009b
            boolean r11 = r9 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r11 == 0) goto L_0x0056
            goto L_0x00b5
        L_0x0056:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r7
            if (r11 == 0) goto L_0x0096
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0096
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0069:
            if (r11 == 0) goto L_0x0093
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r7
            if (r13 == 0) goto L_0x008e
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x0078
            r9 = r11
            goto L_0x008e
        L_0x0078:
            if (r10 != 0) goto L_0x0081
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x0081:
            if (r9 == 0) goto L_0x0089
            if (r10 == 0) goto L_0x0088
            r10.add(r9)
        L_0x0088:
            r9 = r5
        L_0x0089:
            if (r10 == 0) goto L_0x008e
            r10.add(r11)
        L_0x008e:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0069
        L_0x0093:
            if (r12 != r6) goto L_0x0096
            goto L_0x004e
        L_0x0096:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x004e
        L_0x009b:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x0043
        L_0x00a0:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00b1
            androidx.compose.ui.node.NodeChain r8 = r0.getNodes$ui_release()
            if (r8 == 0) goto L_0x00b1
            androidx.compose.ui.Modifier$Node r8 = r8.getTail$ui_release()
            goto L_0x0032
        L_0x00b1:
            r8 = r5
            goto L_0x0032
        L_0x00b4:
            r9 = r5
        L_0x00b5:
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r9 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r9
            goto L_0x00c3
        L_0x00b8:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x00c2:
            r9 = r5
        L_0x00c3:
            if (r9 == 0) goto L_0x0263
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
            int r0 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x0259
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r9)
            r7 = r5
        L_0x00e2:
            if (r2 == 0) goto L_0x0170
            androidx.compose.ui.node.NodeChain r8 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r8 = r8.getHead$ui_release()
            int r8 = r8.getAggregateChildKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x015b
        L_0x00f3:
            if (r1 == 0) goto L_0x015b
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0156
            r8 = r1
            r10 = r5
        L_0x00fe:
            if (r8 == 0) goto L_0x0156
            boolean r11 = r8 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r11 == 0) goto L_0x0111
            if (r7 != 0) goto L_0x010d
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
        L_0x010d:
            r7.add(r8)
            goto L_0x0151
        L_0x0111:
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x0151
            boolean r11 = r8 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0151
            r11 = r8
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0124:
            if (r11 == 0) goto L_0x014e
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r0
            if (r13 == 0) goto L_0x0149
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x0133
            r8 = r11
            goto L_0x0149
        L_0x0133:
            if (r10 != 0) goto L_0x013c
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x013c:
            if (r8 == 0) goto L_0x0144
            if (r10 == 0) goto L_0x0143
            r10.add(r8)
        L_0x0143:
            r8 = r5
        L_0x0144:
            if (r10 == 0) goto L_0x0149
            r10.add(r11)
        L_0x0149:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0124
        L_0x014e:
            if (r12 != r6) goto L_0x0151
            goto L_0x00fe
        L_0x0151:
            androidx.compose.ui.Modifier$Node r8 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x00fe
        L_0x0156:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x00f3
        L_0x015b:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x016d
            androidx.compose.ui.node.NodeChain r1 = r2.getNodes$ui_release()
            if (r1 == 0) goto L_0x016d
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x00e2
        L_0x016d:
            r1 = r5
            goto L_0x00e2
        L_0x0170:
            if (r7 == 0) goto L_0x018e
            int r1 = r7.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x018e
        L_0x017a:
            int r2 = r1 + -1
            java.lang.Object r1 = r7.get(r1)
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r1 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1
            boolean r1 = r1.m5443onPreInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r1 == 0) goto L_0x0189
            return r6
        L_0x0189:
            if (r2 >= 0) goto L_0x018c
            goto L_0x018e
        L_0x018c:
            r1 = r2
            goto L_0x017a
        L_0x018e:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x0193:
            if (r1 == 0) goto L_0x01e7
            boolean r8 = r1 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r8 == 0) goto L_0x01a2
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r1 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1
            boolean r1 = r1.m5443onPreInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r1 == 0) goto L_0x01e2
            return r6
        L_0x01a2:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x01e2
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x01e2
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r10 = r4
        L_0x01b5:
            if (r8 == 0) goto L_0x01df
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x01da
            int r10 = r10 + 1
            if (r10 != r6) goto L_0x01c4
            r1 = r8
            goto L_0x01da
        L_0x01c4:
            if (r2 != 0) goto L_0x01cd
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r11, r4)
        L_0x01cd:
            if (r1 == 0) goto L_0x01d5
            if (r2 == 0) goto L_0x01d4
            r2.add(r1)
        L_0x01d4:
            r1 = r5
        L_0x01d5:
            if (r2 == 0) goto L_0x01da
            r2.add(r8)
        L_0x01da:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x01b5
        L_0x01df:
            if (r10 != r6) goto L_0x01e2
            goto L_0x0193
        L_0x01e2:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x0193
        L_0x01e7:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x01ec:
            if (r1 == 0) goto L_0x0240
            boolean r8 = r1 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r8 == 0) goto L_0x01fb
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r1 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1
            boolean r1 = r1.m5442onInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r1 == 0) goto L_0x023b
            return r6
        L_0x01fb:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x023b
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x023b
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r4
        L_0x020e:
            if (r8 == 0) goto L_0x0238
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r0
            if (r10 == 0) goto L_0x0233
            int r9 = r9 + 1
            if (r9 != r6) goto L_0x021d
            r1 = r8
            goto L_0x0233
        L_0x021d:
            if (r2 != 0) goto L_0x0226
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r10, r4)
        L_0x0226:
            if (r1 == 0) goto L_0x022e
            if (r2 == 0) goto L_0x022d
            r2.add(r1)
        L_0x022d:
            r1 = r5
        L_0x022e:
            if (r2 == 0) goto L_0x0233
            r2.add(r8)
        L_0x0233:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x020e
        L_0x0238:
            if (r9 != r6) goto L_0x023b
            goto L_0x01ec
        L_0x023b:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x01ec
        L_0x0240:
            if (r7 == 0) goto L_0x0263
            int r0 = r7.size()
            r1 = r4
        L_0x0247:
            if (r1 >= r0) goto L_0x0263
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r2 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r2
            boolean r2 = r2.m5442onInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r2 == 0) goto L_0x0256
            return r6
        L_0x0256:
            int r1 = r1 + 1
            goto L_0x0247
        L_0x0259:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x0263:
            return r4
        L_0x0264:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "Dispatching intercepted soft keyboard event while focus system is invalidated."
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3919dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a6, code lost:
        r8 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent r15) {
        /*
            r14 = this;
            androidx.compose.ui.focus.FocusInvalidationManager r0 = r14.focusInvalidationManager
            boolean r0 = r0.hasPendingInvalidation()
            if (r0 != 0) goto L_0x0264
            androidx.compose.ui.focus.FocusTargetNode r0 = r14.rootFocusNode
            androidx.compose.ui.focus.FocusTargetNode r0 = androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(r0)
            java.lang.String r1 = "visitAncestors called on an unattached node"
            r2 = 16384(0x4000, float:2.2959E-41)
            r3 = 16
            r4 = 0
            r5 = 0
            r6 = 1
            if (r0 == 0) goto L_0x00c2
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            int r7 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x00b8
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0032:
            if (r0 == 0) goto L_0x00b4
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x00a0
        L_0x0043:
            if (r8 == 0) goto L_0x00a0
            int r9 = r8.getKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x009b
            r10 = r5
            r9 = r8
        L_0x004e:
            if (r9 == 0) goto L_0x009b
            boolean r11 = r9 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r11 == 0) goto L_0x0056
            goto L_0x00b5
        L_0x0056:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r7
            if (r11 == 0) goto L_0x0096
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0096
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0069:
            if (r11 == 0) goto L_0x0093
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r7
            if (r13 == 0) goto L_0x008e
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x0078
            r9 = r11
            goto L_0x008e
        L_0x0078:
            if (r10 != 0) goto L_0x0081
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x0081:
            if (r9 == 0) goto L_0x0089
            if (r10 == 0) goto L_0x0088
            r10.add(r9)
        L_0x0088:
            r9 = r5
        L_0x0089:
            if (r10 == 0) goto L_0x008e
            r10.add(r11)
        L_0x008e:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0069
        L_0x0093:
            if (r12 != r6) goto L_0x0096
            goto L_0x004e
        L_0x0096:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x004e
        L_0x009b:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x0043
        L_0x00a0:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00b1
            androidx.compose.ui.node.NodeChain r8 = r0.getNodes$ui_release()
            if (r8 == 0) goto L_0x00b1
            androidx.compose.ui.Modifier$Node r8 = r8.getTail$ui_release()
            goto L_0x0032
        L_0x00b1:
            r8 = r5
            goto L_0x0032
        L_0x00b4:
            r9 = r5
        L_0x00b5:
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r9 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r9
            goto L_0x00c3
        L_0x00b8:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x00c2:
            r9 = r5
        L_0x00c3:
            if (r9 == 0) goto L_0x0263
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
            int r0 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x0259
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r9)
            r7 = r5
        L_0x00e2:
            if (r2 == 0) goto L_0x0170
            androidx.compose.ui.node.NodeChain r8 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r8 = r8.getHead$ui_release()
            int r8 = r8.getAggregateChildKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x015b
        L_0x00f3:
            if (r1 == 0) goto L_0x015b
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0156
            r8 = r1
            r10 = r5
        L_0x00fe:
            if (r8 == 0) goto L_0x0156
            boolean r11 = r8 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r11 == 0) goto L_0x0111
            if (r7 != 0) goto L_0x010d
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
        L_0x010d:
            r7.add(r8)
            goto L_0x0151
        L_0x0111:
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x0151
            boolean r11 = r8 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0151
            r11 = r8
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0124:
            if (r11 == 0) goto L_0x014e
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r0
            if (r13 == 0) goto L_0x0149
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x0133
            r8 = r11
            goto L_0x0149
        L_0x0133:
            if (r10 != 0) goto L_0x013c
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x013c:
            if (r8 == 0) goto L_0x0144
            if (r10 == 0) goto L_0x0143
            r10.add(r8)
        L_0x0143:
            r8 = r5
        L_0x0144:
            if (r10 == 0) goto L_0x0149
            r10.add(r11)
        L_0x0149:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0124
        L_0x014e:
            if (r12 != r6) goto L_0x0151
            goto L_0x00fe
        L_0x0151:
            androidx.compose.ui.Modifier$Node r8 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x00fe
        L_0x0156:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x00f3
        L_0x015b:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x016d
            androidx.compose.ui.node.NodeChain r1 = r2.getNodes$ui_release()
            if (r1 == 0) goto L_0x016d
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x00e2
        L_0x016d:
            r1 = r5
            goto L_0x00e2
        L_0x0170:
            if (r7 == 0) goto L_0x018e
            int r1 = r7.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x018e
        L_0x017a:
            int r2 = r1 + -1
            java.lang.Object r1 = r7.get(r1)
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r1 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1
            boolean r1 = r1.onPreRotaryScrollEvent(r15)
            if (r1 == 0) goto L_0x0189
            return r6
        L_0x0189:
            if (r2 >= 0) goto L_0x018c
            goto L_0x018e
        L_0x018c:
            r1 = r2
            goto L_0x017a
        L_0x018e:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x0193:
            if (r1 == 0) goto L_0x01e7
            boolean r8 = r1 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r8 == 0) goto L_0x01a2
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r1 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1
            boolean r1 = r1.onPreRotaryScrollEvent(r15)
            if (r1 == 0) goto L_0x01e2
            return r6
        L_0x01a2:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x01e2
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x01e2
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r10 = r4
        L_0x01b5:
            if (r8 == 0) goto L_0x01df
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x01da
            int r10 = r10 + 1
            if (r10 != r6) goto L_0x01c4
            r1 = r8
            goto L_0x01da
        L_0x01c4:
            if (r2 != 0) goto L_0x01cd
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r11, r4)
        L_0x01cd:
            if (r1 == 0) goto L_0x01d5
            if (r2 == 0) goto L_0x01d4
            r2.add(r1)
        L_0x01d4:
            r1 = r5
        L_0x01d5:
            if (r2 == 0) goto L_0x01da
            r2.add(r8)
        L_0x01da:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x01b5
        L_0x01df:
            if (r10 != r6) goto L_0x01e2
            goto L_0x0193
        L_0x01e2:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x0193
        L_0x01e7:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x01ec:
            if (r1 == 0) goto L_0x0240
            boolean r8 = r1 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r8 == 0) goto L_0x01fb
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r1 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1
            boolean r1 = r1.onRotaryScrollEvent(r15)
            if (r1 == 0) goto L_0x023b
            return r6
        L_0x01fb:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x023b
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x023b
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r4
        L_0x020e:
            if (r8 == 0) goto L_0x0238
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r0
            if (r10 == 0) goto L_0x0233
            int r9 = r9 + 1
            if (r9 != r6) goto L_0x021d
            r1 = r8
            goto L_0x0233
        L_0x021d:
            if (r2 != 0) goto L_0x0226
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r10, r4)
        L_0x0226:
            if (r1 == 0) goto L_0x022e
            if (r2 == 0) goto L_0x022d
            r2.add(r1)
        L_0x022d:
            r1 = r5
        L_0x022e:
            if (r2 == 0) goto L_0x0233
            r2.add(r8)
        L_0x0233:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x020e
        L_0x0238:
            if (r9 != r6) goto L_0x023b
            goto L_0x01ec
        L_0x023b:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x01ec
        L_0x0240:
            if (r7 == 0) goto L_0x0263
            int r0 = r7.size()
            r1 = r4
        L_0x0247:
            if (r1 >= r0) goto L_0x0263
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r2 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r2
            boolean r2 = r2.onRotaryScrollEvent(r15)
            if (r2 == 0) goto L_0x0256
            return r6
        L_0x0256:
            int r1 = r1 + 1
            goto L_0x0247
        L_0x0259:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x0263:
            return r4
        L_0x0264:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "Dispatching rotary event while focus system is invalidated."
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent):boolean");
    }

    public void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusTargetNode);
    }

    public void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusEventModifierNode);
    }

    public void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusPropertiesModifierNode);
    }

    /* access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    public Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    /* renamed from: validateKeyEvent-ZmokQxo  reason: not valid java name */
    private final boolean m3917validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long r0 = KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent);
        int r5 = KeyEvent_androidKt.m5431getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5423equalsimpl0(r5, KeyEventType.Companion.m5427getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(r0);
        } else if (KeyEventType.m5423equalsimpl0(r5, KeyEventType.Companion.m5428getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(r0)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(r0);
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        r2 = r3.getNodes$ui_release();
     */
    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final /* synthetic */ <T extends androidx.compose.ui.node.DelegatableNode> void m3916traverseAncestorsIncludingSelfQFhIj7k(androidx.compose.ui.node.DelegatableNode r17, int r18, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r19, kotlin.jvm.functions.Function0<kotlin.Unit> r20, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r21) {
        /*
            r16 = this;
            r0 = r19
            r1 = r21
            androidx.compose.ui.Modifier$Node r2 = r17.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x01ea
            androidx.compose.ui.Modifier$Node r2 = r17.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r3 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r17)
            r4 = 0
            r5 = r4
        L_0x001c:
            r6 = 16
            java.lang.String r7 = "T"
            r8 = 3
            r9 = 0
            r10 = 1
            if (r3 == 0) goto L_0x00d7
            androidx.compose.ui.node.NodeChain r11 = r3.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r11 = r11.getHead$ui_release()
            int r11 = r11.getAggregateChildKindSet$ui_release()
            r11 = r11 & r18
            if (r11 == 0) goto L_0x00c2
        L_0x0035:
            if (r2 == 0) goto L_0x00c2
            int r11 = r2.getKindSet$ui_release()
            r11 = r11 & r18
            if (r11 == 0) goto L_0x00bc
            r11 = r2
            androidx.compose.ui.Modifier$Node r11 = (androidx.compose.ui.Modifier.Node) r11
            r11 = r2
            r12 = r4
        L_0x0044:
            if (r11 == 0) goto L_0x00bc
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r8, r7)
            boolean r13 = r11 instanceof java.lang.Object
            if (r13 == 0) goto L_0x005d
            if (r5 != 0) goto L_0x0056
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
        L_0x0056:
            r13 = r5
            java.util.List r13 = (java.util.List) r13
            r5.add(r11)
            goto L_0x00b4
        L_0x005d:
            r13 = r11
            androidx.compose.ui.Modifier$Node r13 = (androidx.compose.ui.Modifier.Node) r13
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r18
            if (r13 == 0) goto L_0x00b4
            boolean r13 = r11 instanceof androidx.compose.ui.node.DelegatingNode
            if (r13 == 0) goto L_0x00b4
            r13 = r11
            androidx.compose.ui.node.DelegatingNode r13 = (androidx.compose.ui.node.DelegatingNode) r13
            androidx.compose.ui.Modifier$Node r13 = r13.getDelegate$ui_release()
            r14 = r9
        L_0x0074:
            if (r13 == 0) goto L_0x00b1
            r15 = r13
            androidx.compose.ui.Modifier$Node r15 = (androidx.compose.ui.Modifier.Node) r15
            int r15 = r13.getKindSet$ui_release()
            r15 = r15 & r18
            if (r15 == 0) goto L_0x00ac
            int r14 = r14 + 1
            if (r14 != r10) goto L_0x0087
            r11 = r13
            goto L_0x00ac
        L_0x0087:
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
            if (r12 != 0) goto L_0x0096
            androidx.compose.runtime.collection.MutableVector r12 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r15 = new androidx.compose.ui.Modifier.Node[r6]
            r12.<init>(r15, r9)
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
        L_0x0096:
            r15 = r11
            androidx.compose.ui.Modifier$Node r15 = (androidx.compose.ui.Modifier.Node) r15
            if (r11 == 0) goto L_0x00a4
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
            if (r12 == 0) goto L_0x00a3
            r12.add(r11)
        L_0x00a3:
            r11 = r4
        L_0x00a4:
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
            if (r12 == 0) goto L_0x00ac
            r12.add(r13)
        L_0x00ac:
            androidx.compose.ui.Modifier$Node r13 = r13.getChild$ui_release()
            goto L_0x0074
        L_0x00b1:
            if (r14 != r10) goto L_0x00b4
            goto L_0x0044
        L_0x00b4:
            r11 = r12
            androidx.compose.runtime.collection.MutableVector r11 = (androidx.compose.runtime.collection.MutableVector) r11
            androidx.compose.ui.Modifier$Node r11 = androidx.compose.ui.node.DelegatableNodeKt.pop(r12)
            goto L_0x0044
        L_0x00bc:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0035
        L_0x00c2:
            androidx.compose.ui.node.LayoutNode r3 = r3.getParent$ui_release()
            if (r3 == 0) goto L_0x00d4
            androidx.compose.ui.node.NodeChain r2 = r3.getNodes$ui_release()
            if (r2 == 0) goto L_0x00d4
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x001c
        L_0x00d4:
            r2 = r4
            goto L_0x001c
        L_0x00d7:
            r2 = r5
            java.util.List r2 = (java.util.List) r2
            if (r5 == 0) goto L_0x00f2
            int r2 = r5.size()
            int r2 = r2 + -1
            if (r2 < 0) goto L_0x00f2
        L_0x00e4:
            int r3 = r2 + -1
            java.lang.Object r2 = r5.get(r2)
            r0.invoke(r2)
            if (r3 >= 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r2 = r3
            goto L_0x00e4
        L_0x00f2:
            androidx.compose.ui.Modifier$Node r2 = r17.getNode()
            r3 = r4
        L_0x00f7:
            if (r2 == 0) goto L_0x0163
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r8, r7)
            boolean r11 = r2 instanceof java.lang.Object
            if (r11 == 0) goto L_0x0104
            r0.invoke(r2)
            goto L_0x015b
        L_0x0104:
            r11 = r2
            androidx.compose.ui.Modifier$Node r11 = (androidx.compose.ui.Modifier.Node) r11
            int r11 = r2.getKindSet$ui_release()
            r11 = r11 & r18
            if (r11 == 0) goto L_0x015b
            boolean r11 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x015b
            r11 = r2
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r9
        L_0x011b:
            if (r11 == 0) goto L_0x0158
            r13 = r11
            androidx.compose.ui.Modifier$Node r13 = (androidx.compose.ui.Modifier.Node) r13
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r18
            if (r13 == 0) goto L_0x0153
            int r12 = r12 + 1
            if (r12 != r10) goto L_0x012e
            r2 = r11
            goto L_0x0153
        L_0x012e:
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
            if (r3 != 0) goto L_0x013d
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r6]
            r3.<init>(r13, r9)
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
        L_0x013d:
            r13 = r2
            androidx.compose.ui.Modifier$Node r13 = (androidx.compose.ui.Modifier.Node) r13
            if (r2 == 0) goto L_0x014b
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
            if (r3 == 0) goto L_0x014a
            r3.add(r2)
        L_0x014a:
            r2 = r4
        L_0x014b:
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
            if (r3 == 0) goto L_0x0153
            r3.add(r11)
        L_0x0153:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x011b
        L_0x0158:
            if (r12 != r10) goto L_0x015b
            goto L_0x00f7
        L_0x015b:
            r2 = r3
            androidx.compose.runtime.collection.MutableVector r2 = (androidx.compose.runtime.collection.MutableVector) r2
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.pop(r3)
            goto L_0x00f7
        L_0x0163:
            r20.invoke()
            androidx.compose.ui.Modifier$Node r0 = r17.getNode()
            r2 = r4
        L_0x016b:
            if (r0 == 0) goto L_0x01d7
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r8, r7)
            boolean r3 = r0 instanceof java.lang.Object
            if (r3 == 0) goto L_0x0178
            r1.invoke(r0)
            goto L_0x01cf
        L_0x0178:
            r3 = r0
            androidx.compose.ui.Modifier$Node r3 = (androidx.compose.ui.Modifier.Node) r3
            int r3 = r0.getKindSet$ui_release()
            r3 = r3 & r18
            if (r3 == 0) goto L_0x01cf
            boolean r3 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r3 == 0) goto L_0x01cf
            r3 = r0
            androidx.compose.ui.node.DelegatingNode r3 = (androidx.compose.ui.node.DelegatingNode) r3
            androidx.compose.ui.Modifier$Node r3 = r3.getDelegate$ui_release()
            r11 = r9
        L_0x018f:
            if (r3 == 0) goto L_0x01cc
            r12 = r3
            androidx.compose.ui.Modifier$Node r12 = (androidx.compose.ui.Modifier.Node) r12
            int r12 = r3.getKindSet$ui_release()
            r12 = r12 & r18
            if (r12 == 0) goto L_0x01c7
            int r11 = r11 + 1
            if (r11 != r10) goto L_0x01a2
            r0 = r3
            goto L_0x01c7
        L_0x01a2:
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
            if (r2 != 0) goto L_0x01b1
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r6]
            r2.<init>(r12, r9)
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
        L_0x01b1:
            r12 = r0
            androidx.compose.ui.Modifier$Node r12 = (androidx.compose.ui.Modifier.Node) r12
            if (r0 == 0) goto L_0x01bf
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
            if (r2 == 0) goto L_0x01be
            r2.add(r0)
        L_0x01be:
            r0 = r4
        L_0x01bf:
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
            if (r2 == 0) goto L_0x01c7
            r2.add(r3)
        L_0x01c7:
            androidx.compose.ui.Modifier$Node r3 = r3.getChild$ui_release()
            goto L_0x018f
        L_0x01cc:
            if (r11 != r10) goto L_0x01cf
            goto L_0x016b
        L_0x01cf:
            r0 = r2
            androidx.compose.runtime.collection.MutableVector r0 = (androidx.compose.runtime.collection.MutableVector) r0
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x016b
        L_0x01d7:
            if (r5 == 0) goto L_0x01e9
            int r0 = r5.size()
        L_0x01dd:
            if (r9 >= r0) goto L_0x01e9
            java.lang.Object r2 = r5.get(r9)
            r1.invoke(r2)
            int r9 = r9 + 1
            goto L_0x01dd
        L_0x01e9:
            return
        L_0x01ea:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitAncestors called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3916traverseAncestorsIncludingSelfQFhIj7k(androidx.compose.ui.node.DelegatableNode, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ac, code lost:
        r0 = r10.getNodes$ui_release();
     */
    /* renamed from: nearestAncestorIncludingSelf-64DMado  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final /* synthetic */ <T> T m3915nearestAncestorIncludingSelf64DMado(androidx.compose.ui.node.DelegatableNode r10, int r11) {
        /*
            r9 = this;
            androidx.compose.ui.Modifier$Node r0 = r10.getNode()
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Node r0 = r10.getNode()
            androidx.compose.ui.node.LayoutNode r10 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r10)
        L_0x0012:
            r1 = 0
            if (r10 == 0) goto L_0x00bb
            androidx.compose.ui.node.NodeChain r2 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r2 = r2.getHead$ui_release()
            int r2 = r2.getAggregateChildKindSet$ui_release()
            r2 = r2 & r11
            if (r2 == 0) goto L_0x00a6
        L_0x0024:
            if (r0 == 0) goto L_0x00a6
            int r2 = r0.getKindSet$ui_release()
            r2 = r2 & r11
            if (r2 == 0) goto L_0x00a0
            r2 = r0
            androidx.compose.ui.Modifier$Node r2 = (androidx.compose.ui.Modifier.Node) r2
            r2 = r0
            r3 = r1
        L_0x0032:
            if (r2 == 0) goto L_0x00a0
            r4 = 3
            java.lang.String r5 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r4, r5)
            boolean r4 = r2 instanceof java.lang.Object
            if (r4 == 0) goto L_0x003f
            return r2
        L_0x003f:
            r4 = r2
            androidx.compose.ui.Modifier$Node r4 = (androidx.compose.ui.Modifier.Node) r4
            int r4 = r2.getKindSet$ui_release()
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0098
            boolean r4 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L_0x0098
            r4 = r2
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.getDelegate$ui_release()
            r5 = 0
            r6 = r5
        L_0x0056:
            r7 = 1
            if (r4 == 0) goto L_0x0095
            r8 = r4
            androidx.compose.ui.Modifier$Node r8 = (androidx.compose.ui.Modifier.Node) r8
            int r8 = r4.getKindSet$ui_release()
            r8 = r8 & r11
            if (r8 == 0) goto L_0x0090
            int r6 = r6 + 1
            if (r6 != r7) goto L_0x0069
            r2 = r4
            goto L_0x0090
        L_0x0069:
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            if (r3 != 0) goto L_0x007a
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            r7 = 16
            androidx.compose.ui.Modifier$Node[] r7 = new androidx.compose.ui.Modifier.Node[r7]
            r3.<init>(r7, r5)
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
        L_0x007a:
            r7 = r2
            androidx.compose.ui.Modifier$Node r7 = (androidx.compose.ui.Modifier.Node) r7
            if (r2 == 0) goto L_0x0088
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            if (r3 == 0) goto L_0x0087
            r3.add(r2)
        L_0x0087:
            r2 = r1
        L_0x0088:
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            if (r3 == 0) goto L_0x0090
            r3.add(r4)
        L_0x0090:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L_0x0056
        L_0x0095:
            if (r6 != r7) goto L_0x0098
            goto L_0x0032
        L_0x0098:
            r2 = r3
            androidx.compose.runtime.collection.MutableVector r2 = (androidx.compose.runtime.collection.MutableVector) r2
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.pop(r3)
            goto L_0x0032
        L_0x00a0:
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            goto L_0x0024
        L_0x00a6:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x00b8
            androidx.compose.ui.node.NodeChain r0 = r10.getNodes$ui_release()
            if (r0 == 0) goto L_0x00b8
            androidx.compose.ui.Modifier$Node r0 = r0.getTail$ui_release()
            goto L_0x0012
        L_0x00b8:
            r0 = r1
            goto L_0x0012
        L_0x00bb:
            return r1
        L_0x00bc:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "visitAncestors called on an unattached node"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3915nearestAncestorIncludingSelf64DMado(androidx.compose.ui.node.DelegatableNode, int):java.lang.Object");
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int r1 = NodeKind.m6139constructorimpl(1024) | NodeKind.m6139constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet$ui_release() & r1) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & r1) != 0) {
                    if ((NodeKind.m6139constructorimpl(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return node2;
                    }
                    node2 = child$ui_release;
                }
            }
        }
        return node2;
    }
}
