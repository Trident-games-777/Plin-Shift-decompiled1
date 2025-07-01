package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0018\b\u0007\u0018\u0000 p*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001pB\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0015B\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0016Jy\u0010P\u001a\u00020Q2\u0006\u0010K\u001a\u00028\u00002\b\b\u0002\u0010R\u001a\u00020S2W\u0010T\u001aS\b\u0001\u0012\u0004\u0012\u00020V\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(W\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0X\u0012\u0006\u0012\u0004\u0018\u00010\u00020U¢\u0006\u0002\bYH@¢\u0006\u0002\u0010ZJ\\\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020S2B\u0010T\u001a>\b\u0001\u0012\u0004\u0012\u00020V\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0X\u0012\u0006\u0012\u0004\u0018\u00010\u00020[¢\u0006\u0002\bYH@¢\u0006\u0002\u0010\\J%\u0010]\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\b2\u0006\u0010#\u001a\u00028\u00002\u0006\u0010^\u001a\u00020\bH\u0002¢\u0006\u0002\u0010_J\u000e\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bJ\u0015\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bH\u0000¢\u0006\u0002\bcJ\u001d\u0010?\u001a\u00020\b2\u0006\u0010d\u001a\u00028\u00002\u0006\u0010e\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020\bJ\u0016\u0010h\u001a\u00020\b2\u0006\u0010^\u001a\u00020\bH@¢\u0006\u0002\u0010iJ\u0015\u0010j\u001a\u00020\u00142\u0006\u0010K\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010kJ#\u0010l\u001a\u00020Q2\f\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010n\u001a\u00028\u0000¢\u0006\u0002\u0010oR\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R7\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR/\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R+\u0010#\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R/\u0010-\u001a\u0004\u0018\u00018\u00002\b\u0010\u001a\u001a\u0004\u0018\u00018\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b0\u0010 \u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u0011\u00101\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b1\u00102R+\u00103\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b8F@BX\u0002¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b4\u00105\"\u0004\b6\u00107R+\u0010:\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b8F@BX\u0002¢\u0006\u0012\n\u0004\b=\u00109\u001a\u0004\b;\u00105\"\u0004\b<\u00107R/\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R!\u0010?\u001a\u00020\b8GX\u0002¢\u0006\u0012\n\u0004\bC\u0010D\u0012\u0004\b@\u0010A\u001a\u0004\bB\u00105R+\u0010E\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\bH\u0010 \u001a\u0004\bF\u0010%\"\u0004\bG\u0010'R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001b\u0010K\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\bM\u0010D\u001a\u0004\bL\u0010%R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010O¨\u0006q"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "", "initialValue", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "<set-?>", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "offset", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$foundation_release", "progress", "getProgress$annotations", "()V", "getProgress", "progress$delegate", "Landroidx/compose/runtime/State;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function4;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchor", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "newOffsetForDelta", "newOffsetForDelta$foundation_release", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "updateAnchors", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final AnchoredDraggableState$anchoredDragScope$1<T> anchoredDragScope;
    private final MutableState anchors$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    private final Function1<Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final MutableState settledValue$delegate;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final State targetValue$delegate;
    private final Function0<Float> velocityThreshold;

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public AnchoredDraggableState(T t, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec2, Function1<? super T, Boolean> function12) {
        this.positionalThreshold = function1;
        this.velocityThreshold = function0;
        this.snapAnimationSpec = animationSpec;
        this.decayAnimationSpec = decayAnimationSpec2;
        this.confirmValueChange = function12;
        this.dragMutex = new MutatorMutex();
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.settledValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$targetValue$2(this));
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new AnchoredDraggableState$progress$2(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.emptyDraggableAnchors(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        return this.velocityThreshold;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        return this.decayAnimationSpec;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnchoredDraggableState(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec2, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function1, function0, animationSpec, decayAnimationSpec2, (i & 32) != 0 ? AnonymousClass1.INSTANCE : function12);
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AnchoredDraggableState(java.lang.Object r10, androidx.compose.foundation.gestures.DraggableAnchors r11, kotlin.jvm.functions.Function1 r12, kotlin.jvm.functions.Function0 r13, androidx.compose.animation.core.AnimationSpec r14, androidx.compose.animation.core.DecayAnimationSpec r15, kotlin.jvm.functions.Function1 r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 64
            if (r0 == 0) goto L_0x000a
            androidx.compose.foundation.gestures.AnchoredDraggableState$2 r0 = androidx.compose.foundation.gestures.AnchoredDraggableState.AnonymousClass2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r8 = r0
            goto L_0x000c
        L_0x000a:
            r8 = r16
        L_0x000c:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.<init>(java.lang.Object, androidx.compose.foundation.gestures.DraggableAnchors, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.animation.core.AnimationSpec, androidx.compose.animation.core.DecayAnimationSpec, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AnchoredDraggableState(T r8, androidx.compose.foundation.gestures.DraggableAnchors<T> r9, kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float> r10, kotlin.jvm.functions.Function0<java.lang.Float> r11, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r12, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r13, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r14) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.setAnchors(r9)
            r7.trySnapTo(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.<init>(java.lang.Object, androidx.compose.foundation.gestures.DraggableAnchors, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.animation.core.AnimationSpec, androidx.compose.animation.core.DecayAnimationSpec, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setSettledValue(T t) {
        this.settledValue$delegate.setValue(t);
    }

    public final T getSettledValue() {
        return this.settledValue$delegate.getValue();
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setOffset(float f) {
        this.offset$delegate.setFloatValue(f);
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final float requireOffset() {
        if (!Float.isNaN(getOffset())) {
            return getOffset();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float progress(T t, T t2) {
        float positionOf = getAnchors().positionOf(t);
        float positionOf2 = getAnchors().positionOf(t2);
        float coerceIn = (RangesKt.coerceIn(getOffset(), Math.min(positionOf, positionOf2), Math.max(positionOf, positionOf2)) - positionOf) / (positionOf2 - positionOf);
        if (Float.isNaN(coerceIn)) {
            return 1.0f;
        }
        if (coerceIn < 1.0E-6f) {
            return 0.0f;
        }
        if (coerceIn > 0.999999f) {
            return 1.0f;
        }
        return Math.abs(coerceIn);
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    /* access modifiers changed from: private */
    public final T getDragTarget() {
        return this.dragTarget$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setDragTarget(T t) {
        this.dragTarget$delegate.setValue(t);
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors$delegate.setValue(draggableAnchors);
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors$delegate.getValue();
    }

    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset());
                if (obj == null) {
                    obj = anchoredDraggableState.getTargetValue();
                }
            } else {
                obj = anchoredDraggableState.getTargetValue();
            }
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final void updateAnchors(DraggableAnchors<T> draggableAnchors, T t) {
        if (!Intrinsics.areEqual((Object) getAnchors(), (Object) draggableAnchors)) {
            setAnchors(draggableAnchors);
            if (!trySnapTo(t)) {
                setDragTarget(t);
            }
        }
    }

    public final Object settle(float f, Continuation<? super Float> continuation) {
        Object currentValue = getCurrentValue();
        Object computeTarget = computeTarget(requireOffset(), currentValue, f);
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            return AnchoredDraggableKt.animateToWithDecay(this, computeTarget, f, continuation);
        }
        return AnchoredDraggableKt.animateToWithDecay(this, currentValue, f, continuation);
    }

    private final T computeTarget(float f, T t, float f2) {
        DraggableAnchors anchors = getAnchors();
        float positionOf = anchors.positionOf(t);
        float floatValue = this.velocityThreshold.invoke().floatValue();
        if (positionOf != f && !Float.isNaN(positionOf)) {
            boolean z = true;
            if (Math.abs(f2) >= Math.abs(floatValue)) {
                if (Math.signum(f2) <= 0.0f) {
                    z = false;
                }
                T closestAnchor = anchors.closestAnchor(f, z);
                Intrinsics.checkNotNull(closestAnchor);
                return closestAnchor;
            }
            if (f - positionOf <= 0.0f) {
                z = false;
            }
            T closestAnchor2 = anchors.closestAnchor(f, z);
            Intrinsics.checkNotNull(closestAnchor2);
            return Math.abs(positionOf - f) <= Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(positionOf - anchors.positionOf(closestAnchor2)))).floatValue()) ? t : closestAnchor2;
        }
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object mutate = this.dragMutex.mutate(mutatePriority, new AnchoredDraggableState$anchoredDrag$2(this, function3, (Continuation<? super AnchoredDraggableState$anchoredDrag$2>) null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object anchoredDrag(T r6, androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.gestures.AnchoredDragScope, ? super androidx.compose.foundation.gestures.DraggableAnchors<T>, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.AnchoredDraggableState r6 = (androidx.compose.foundation.gestures.AnchoredDraggableState) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x002f }
            goto L_0x005b
        L_0x002f:
            r7 = move-exception
            goto L_0x0061
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.foundation.gestures.DraggableAnchors r9 = r5.getAnchors()
            boolean r9 = r9.hasAnchorFor(r6)
            if (r9 == 0) goto L_0x0065
            androidx.compose.foundation.MutatorMutex r9 = r5.dragMutex     // Catch:{ all -> 0x005f }
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4 r2 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4     // Catch:{ all -> 0x005f }
            r2.<init>(r5, r6, r8, r4)     // Catch:{ all -> 0x005f }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x005f }
            r0.L$0 = r5     // Catch:{ all -> 0x005f }
            r0.label = r3     // Catch:{ all -> 0x005f }
            java.lang.Object r6 = r9.mutate(r7, r2, r0)     // Catch:{ all -> 0x005f }
            if (r6 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r6 = r5
        L_0x005b:
            r6.setDragTarget(r4)
            goto L_0x0079
        L_0x005f:
            r7 = move-exception
            r6 = r5
        L_0x0061:
            r6.setDragTarget(r4)
            throw r7
        L_0x0065:
            kotlin.jvm.functions.Function1<T, java.lang.Boolean> r7 = r5.confirmValueChange
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0079
            r5.setSettledValue(r6)
            r5.setCurrentValue(r6)
        L_0x0079:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag(java.lang.Object, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    public final float newOffsetForDelta$foundation_release(float f) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + f, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float dispatchRawDelta(float f) {
        float newOffsetForDelta$foundation_release = newOffsetForDelta$foundation_release(f);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(newOffsetForDelta$foundation_release);
        return newOffsetForDelta$foundation_release - offset;
    }

    private final boolean trySnapTo(T t) {
        MutatorMutex mutatorMutex = this.dragMutex;
        boolean tryLock = mutatorMutex.tryLock();
        if (!tryLock) {
            return tryLock;
        }
        try {
            AnchoredDraggableState$anchoredDragScope$1<T> anchoredDraggableState$anchoredDragScope$1 = this.anchoredDragScope;
            float positionOf = getAnchors().positionOf(t);
            if (!Float.isNaN(positionOf)) {
                AnchoredDragScope.dragTo$default(anchoredDraggableState$anchoredDragScope$1, positionOf, 0.0f, 2, (Object) null);
                setDragTarget((Object) null);
            }
            setCurrentValue(t);
            setSettledValue(t);
            return tryLock;
        } finally {
            mutatorMutex.unlock();
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00140\rH\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "confirmValueChange", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnchoredDraggable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Saver Saver$default(Companion companion, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
            if ((i & 16) != 0) {
                function12 = AnchoredDraggableState$Companion$Saver$1.INSTANCE;
            }
            return companion.Saver(animationSpec, decayAnimationSpec, function1, function0, function12);
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super Float, Float> function1, Function0<Float> function0, Function1<? super T, Boolean> function12) {
            return SaverKt.Saver(AnchoredDraggableState$Companion$Saver$2.INSTANCE, new AnchoredDraggableState$Companion$Saver$3(function1, function0, animationSpec, decayAnimationSpec, function12));
        }
    }
}
