package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#J\b\u0010/\u001a\u00020\u0013H\u0002J\u0006\u00100\u001a\u00020\u0013J(\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#J\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010;\u001a\u00020\u001eR/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR/\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138F@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\nR\"\u0010(\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010#@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0,X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "<set-?>", "Landroidx/compose/ui/geometry/Rect;", "_targetBounds", "get_targetBounds", "()Landroidx/compose/ui/geometry/Rect;", "set_targetBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "_targetBounds$delegate", "Landroidx/compose/runtime/MutableState;", "currentBounds", "getCurrentBounds", "setCurrentBounds", "currentBounds$delegate", "", "foundMatch", "getFoundMatch", "()Z", "setFoundMatch", "(Z)V", "foundMatch$delegate", "getKey", "()Ljava/lang/Object;", "observingVisibilityChange", "Lkotlin/Function0;", "", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/SharedElementInternalState;", "getStates", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "targetBounds", "getTargetBounds", "targetBoundsProvider", "getTargetBoundsProvider$animation_release", "()Landroidx/compose/animation/SharedElementInternalState;", "updateMatch", "Lkotlin/Function1;", "addState", "sharedElementState", "hasVisibleContent", "isAnimating", "onLookaheadResult", "state", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "onLookaheadResult-v_w8tDc", "(Landroidx/compose/animation/SharedElementInternalState;JJ)V", "onSharedTransitionFinished", "removeState", "updateTargetBoundsProvider", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedElement.kt */
public final class SharedElement {
    public static final int $stable = 8;
    private final MutableState _targetBounds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState currentBounds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState foundMatch$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Object key;
    private final Function0<Unit> observingVisibilityChange = new SharedElement$observingVisibilityChange$1(this);
    private final SharedTransitionScopeImpl scope;
    private final SnapshotStateList<SharedElementInternalState> states = SnapshotStateKt.mutableStateListOf();
    private SharedElementInternalState targetBoundsProvider;
    private final Function1<SharedElement, Unit> updateMatch = new SharedElement$updateMatch$1(this);

    public SharedElement(Object obj, SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.key = obj;
        this.scope = sharedTransitionScopeImpl;
    }

    public final Object getKey() {
        return this.key;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final boolean isAnimating() {
        List list = this.states;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (!((SharedElementInternalState) list.get(i)).getBoundsAnimation().isRunning()) {
                i++;
            } else if (getFoundMatch()) {
                return true;
            }
        }
        return false;
    }

    private final Rect get_targetBounds() {
        return (Rect) this._targetBounds$delegate.getValue();
    }

    private final void set_targetBounds(Rect rect) {
        this._targetBounds$delegate.setValue(rect);
    }

    public final Rect getTargetBounds() {
        SharedElementInternalState sharedElementInternalState = this.targetBoundsProvider;
        set_targetBounds(sharedElementInternalState != null ? RectKt.m4027Recttz77jQw(sharedElementInternalState.m113calculateLookaheadOffsetF1C5BW0(), sharedElementInternalState.m114getNonNullLookaheadSizeNHjbRc()) : null);
        return get_targetBounds();
    }

    public final void updateMatch() {
        boolean hasVisibleContent = hasVisibleContent();
        if (this.states.size() > 1 && hasVisibleContent) {
            setFoundMatch(true);
        } else if (!this.scope.isTransitionActive()) {
            setFoundMatch(false);
        } else if (!hasVisibleContent) {
            setFoundMatch(false);
        }
        if (!this.states.isEmpty()) {
            SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
        }
    }

    private final void setFoundMatch(boolean z) {
        this.foundMatch$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getFoundMatch() {
        return ((Boolean) this.foundMatch$delegate.getValue()).booleanValue();
    }

    public final Rect getCurrentBounds() {
        return (Rect) this.currentBounds$delegate.getValue();
    }

    public final void setCurrentBounds(Rect rect) {
        this.currentBounds$delegate.setValue(rect);
    }

    public final SharedElementInternalState getTargetBoundsProvider$animation_release() {
        return this.targetBoundsProvider;
    }

    /* renamed from: onLookaheadResult-v_w8tDc  reason: not valid java name */
    public final void m112onLookaheadResultv_w8tDc(SharedElementInternalState sharedElementInternalState, long j, long j2) {
        if (sharedElementInternalState.getBoundsAnimation().getTarget()) {
            this.targetBoundsProvider = sharedElementInternalState;
            Rect rect = get_targetBounds();
            Size size = null;
            Offset r5 = rect != null ? Offset.m3976boximpl(rect.m4022getTopLeftF1C5BW0()) : null;
            if (r5 == null ? false : Offset.m3984equalsimpl0(r5.m3997unboximpl(), j2)) {
                Rect rect2 = get_targetBounds();
                if (rect2 != null) {
                    size = Size.m4044boximpl(rect2.m4020getSizeNHjbRc());
                }
                if (size == null ? false : Size.m4052equalsimpl0(size.m4061unboximpl(), j)) {
                    return;
                }
            }
            Rect r52 = RectKt.m4027Recttz77jQw(j2, j);
            set_targetBounds(r52);
            List list = this.states;
            int size2 = list.size();
            for (int i = 0; i < size2; i++) {
                BoundsAnimation boundsAnimation = ((SharedElementInternalState) list.get(i)).getBoundsAnimation();
                Rect currentBounds = getCurrentBounds();
                Intrinsics.checkNotNull(currentBounds);
                boundsAnimation.animate(currentBounds, r52);
            }
        }
    }

    public final SnapshotStateList<SharedElementInternalState> getStates() {
        return this.states;
    }

    /* access modifiers changed from: private */
    public final boolean hasVisibleContent() {
        List list = this.states;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((SharedElementInternalState) list.get(i)).getBoundsAnimation().getTarget()) {
                return true;
            }
        }
        return false;
    }

    public final void updateTargetBoundsProvider() {
        List list = this.states;
        int size = list.size() - 1;
        SharedElementInternalState sharedElementInternalState = null;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                SharedElementInternalState sharedElementInternalState2 = (SharedElementInternalState) list.get(size);
                if (sharedElementInternalState2.getBoundsAnimation().getTarget()) {
                    sharedElementInternalState = sharedElementInternalState2;
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        if (!Intrinsics.areEqual((Object) sharedElementInternalState, (Object) this.targetBoundsProvider)) {
            this.targetBoundsProvider = sharedElementInternalState;
            set_targetBounds((Rect) null);
        }
    }

    public final void onSharedTransitionFinished() {
        boolean z = true;
        if (this.states.size() <= 1 || !hasVisibleContent()) {
            z = false;
        }
        setFoundMatch(z);
        set_targetBounds((Rect) null);
    }

    public final void addState(SharedElementInternalState sharedElementInternalState) {
        this.states.add(sharedElementInternalState);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final void removeState(SharedElementInternalState sharedElementInternalState) {
        this.states.remove((Object) sharedElementInternalState);
        if (this.states.isEmpty()) {
            updateMatch();
            SharedTransitionScopeKt.getSharedTransitionObserver().clear(this);
            return;
        }
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }
}
