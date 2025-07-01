package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u001b\u001a\u0002H\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001d2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!0\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u0010/\u001a\b\u0012\u0004\u0012\u0002000 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002000%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002000\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u00101\u001a\b\u0012\u0004\u0012\u0002020 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002020%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002020\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u00103\u001a\b\u0012\u0004\u0012\u0002040 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002040%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002040\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u00105\u001a\b\u0012\u0004\u0012\u0002060 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002060%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002060\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a\u0001\u00107\u001a\b\u0012\u0004\u0012\u0002080 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002080%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002080\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010,\u001a¦\u0001\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00140 \"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010:*\u00020;*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00140\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010>\u001a\\\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\"0\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010@\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H\u00140\u000f¢\u0006\u0002\b&H\b¢\u0006\u0002\u0010B\u001aA\u0010C\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0006\u0010D\u001a\u0002H\u00142\u0006\u0010\u001b\u001a\u0002H\u00142\u0006\u0010E\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010F\u001aa\u0010G\u001a\u0018\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0HR\b\u0012\u0004\u0012\u0002H\"0\u0013\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010:*\u00020;*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010I\u001am\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00140 \"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010:*\u00020;*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0006\u0010K\u001a\u0002H\u00142\u0006\u0010L\u001a\u0002H\u00142\f\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00140%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u001b\u0010\b\u001a\u00020\t8@X\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"AnimationDebugDurationScale", "", "NoReset", "", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "ResetNoSnap", "SeekableStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "rememberTransition", "Landroidx/compose/animation/core/Transition;", "T", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "updateTransition", "targetState", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1.0f;
    private static final float ResetAnimationSnap = -3.0f;
    private static final float ResetAnimationSnapCurrent = -4.0f;
    private static final float ResetAnimationSnapTarget = -5.0f;
    private static final float ResetNoSnap = -2.0f;
    private static final Lazy SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, TransitionKt$SeekableStateObserver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Function1<SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged = TransitionKt$SeekableTransitionStateTotalDurationChanged$1.INSTANCE;

    public static final <T> Transition<T> updateTransition(T t, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2029166765, "C(updateTransition)P(1)92@3848L51,93@3915L22,94@3971L190,94@3942L219:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:91)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -659287595, "CC(remember):Transition.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(t, str);
            composer.updateRememberedValue(rememberedValue);
        }
        Transition<T> transition = (Transition) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        transition.animateTo$animation_core_release(t, composer, (i & 8) | 48 | (i & 14));
        ComposerKt.sourceInformationMarkerStart(composer, -659283520, "CC(remember):Transition.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$updateTransition$1$1(transition);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transition;
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver) SeekableStateObserver$delegate.getValue();
    }

    public static final <T> Transition<T> rememberTransition(TransitionState<T> transitionState, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1643203617, "C(rememberTransition)P(1)821@34295L94,836@35019L190,836@34990L219:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, i, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:820)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 587423396, "CC(remember):Transition.kt#9igjgp");
        int i3 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && composer.changed((Object) transitionState)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(transitionState, str);
            composer.updateRememberedValue(rememberedValue);
        }
        Transition<T> transition = (Transition) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transitionState instanceof SeekableTransitionState) {
            composer.startReplaceGroup(1030413636);
            ComposerKt.sourceInformation(composer, "825@34526L382,825@34452L456");
            T currentState = transitionState.getCurrentState();
            T targetState = transitionState.getTargetState();
            ComposerKt.sourceInformationMarkerStart(composer, 587431076, "CC(remember):Transition.kt#9igjgp");
            if ((i3 <= 4 || !composer.changed((Object) transitionState)) && (i & 6) != 4) {
                z = false;
            }
            Object rememberedValue2 = composer.rememberedValue();
            if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new TransitionKt$rememberTransition$1$1(transitionState, (Continuation<? super TransitionKt$rememberTransition$1$1>) null);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(currentState, targetState, (Function2) rememberedValue2, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1030875195);
            ComposerKt.sourceInformation(composer, "834@34941L38");
            transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart(composer, 587446660, "CC(remember):Transition.kt#9igjgp");
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new TransitionKt$rememberTransition$2$1(transition);
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transition;
    }

    @Deprecated(message = "Use rememberTransition() instead", replaceWith = @ReplaceWith(expression = "rememberTransition(transitionState, label)", imports = {}))
    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> mutableTransitionState, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 882913843, "C(updateTransition)P(1)875@36666L32:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:873)");
        }
        Transition<T> rememberTransition = rememberTransition(mutableTransitionState, str, composer, i & WebSocketProtocol.PAYLOAD_SHORT, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rememberTransition;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1714122528, "C(createDeferredAnimation)P(1)1780@72634L58,1781@72724L75,1781@72697L102:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1779)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1378234273, "CC(remember):Transition.kt#9igjgp");
        int i3 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && composer.changed((Object) transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition.DeferredAnimation(twoWayConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1378231376, "CC(remember):Transition.kt#9igjgp");
        if ((i3 <= 4 || !composer.changed((Object) transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean changedInstance = composer.changedInstance(deferredAnimation) | z;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$createDeferredAnimation$1$1(transition, deferredAnimation);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return deferredAnimation;
    }

    public static final <S, T> Transition<T> createChildTransition(Transition<S> transition, String str, Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1215497572, "CC(createChildTransition)1813@74138L36,1814@74198L74,1815@74295L39,1816@74346L63:Transition.kt#pdpnli");
        boolean z = true;
        if ((i2 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        ComposerKt.sourceInformationMarkerStart(composer, 272027253, "CC(remember):Transition.kt#9igjgp");
        int i3 = i & 14;
        if (((i3 ^ 6) <= 4 || !composer.changed((Object) transition)) && (i & 6) != 4) {
            z = false;
        }
        S rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.isSeeking()) {
            rememberedValue = transition.getCurrentState();
        }
        int i4 = (i >> 3) & 112;
        Composer composer2 = composer;
        Transition<T> createChildTransitionInternal = createChildTransitionInternal(transition, function3.invoke(rememberedValue, composer, Integer.valueOf(i4)), function3.invoke(transition.getTargetState(), composer, Integer.valueOf(i4)), str2, composer2, i3 | ((i << 6) & 7168));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createChildTransitionInternal;
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(Transition<S> transition, T t, T t2, String str, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -198307638, "C(createChildTransitionInternal)P(1,2)1826@74609L116,1830@74760L112,1830@74731L141:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1825)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1039290434, "CC(remember):Transition.kt#9igjgp");
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && composer.changed((Object) transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(new MutableTransitionState(t), transition, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(rememberedValue);
        }
        Transition<T> transition2 = (Transition) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1039295262, "CC(remember):Transition.kt#9igjgp");
        if ((i2 <= 4 || !composer.changed((Object) transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean changed = composer.changed((Object) transition2) | z;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$createChildTransitionInternal$1$1(transition, transition2);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t2);
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transition2;
    }

    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, ? extends T> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            function3 = TransitionKt$animateValue$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i3 = (i >> 9) & 112;
        Transition<S> transition2 = transition;
        TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
        Composer composer2 = composer;
        State<T> createTransitionAnimation = createTransitionAnimation(transition2, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i3)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i3)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i >> 3) & 112)), twoWayConverter2, str, composer2, (i & 14) | (57344 & (i << 9)) | ((i << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(Transition<S> transition, T t, T t2, FiniteAnimationSpec<T> finiteAnimationSpec, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i) {
        T t3 = t2;
        FiniteAnimationSpec<T> finiteAnimationSpec2 = finiteAnimationSpec;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -304821198, "C(createTransitionAnimation)P(1,3!1,4)1901@77675L499,1924@78558L128,1924@78520L166:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i2, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1900)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1397689602, "CC(remember):Transition.kt#9igjgp");
        int i3 = (i2 & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && composer2.changed((Object) transition)) || (i2 & 6) == 4;
        Object rememberedValue = composer2.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
            Transition.TransitionAnimationState transitionAnimationState = new Transition.TransitionAnimationState(t, AnimationStateKt.createZeroVectorFrom(twoWayConverter2, t3), twoWayConverter2, str);
            composer2.updateRememberedValue(transitionAnimationState);
            rememberedValue = transitionAnimationState;
        }
        Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (transition.isSeeking()) {
            transitionAnimationState2.updateInitialAndTargetValue$animation_core_release(t, t3, finiteAnimationSpec2);
        } else {
            transitionAnimationState2.updateTargetValue$animation_core_release(t3, finiteAnimationSpec2);
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1397717487, "CC(remember):Transition.kt#9igjgp");
        if ((i3 <= 4 || !composer2.changed((Object) transition)) && (i2 & 6) != 4) {
            z = false;
        }
        boolean changed = composer2.changed((Object) transitionAnimationState2) | z;
        Object rememberedValue2 = composer2.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$createTransitionAnimation$1$1(transition, transitionAnimationState2);
            composer2.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.DisposableEffect((Object) transitionAnimationState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return transitionAnimationState2;
    }

    public static final <S> State<Float> animateFloat(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Float> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1968@80576L78:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateFloat$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<Float> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<Dp> animateDp(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Dp> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 184732935, "CC(animateDp)P(2)1999@82290L75:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateDp$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<Dp> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<Offset> animateOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Offset> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2078477582, "CC(animateOffset)P(2)2030@84030L79:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateOffset$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<Offset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<Size> animateSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Size> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -802210820, "CC(animateSize)P(2)2061@85759L77:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateSize$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<Size> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<IntOffset> animateIntOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, IntOffset> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 776131825, "CC(animateIntOffset)P(2)2092@87507L82:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateIntOffset$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<IntOffset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<Integer> animateInt(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Integer> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1318902782, "CC(animateInt)P(2)2123@89210L76:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateInt$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<Integer> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<IntSize> animateIntSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, IntSize> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2104123233, "CC(animateIntSize)P(2)2153@90939L80:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateIntSize$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<IntSize> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }

    public static final <S> State<Rect> animateRect(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Rect> function32, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1496278239, "CC(animateRect)P(2)2183@92665L77:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateRect$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1885@77139L32,1886@77194L31,1887@77250L23,1889@77286L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        Composer composer2 = composer;
        State<Rect> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer2, (i5 & 14) | ((i5 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return createTransitionAnimation;
    }
}
