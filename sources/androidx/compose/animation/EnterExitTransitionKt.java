package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001aQ\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001aQ\u0010\u0019\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0007\u001aQ\u0010\u001d\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u001e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a\"\u0010!\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u0002H\u0007\u001a\"\u0010#\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u0002H\u0007\u001a6\u0010&\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a6\u0010+\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aQ\u0010/\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u00100\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001aQ\u00102\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u00100\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0007\u001aQ\u00104\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u00100\u001a\u00020\u001e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a;\u00106\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a=\u00108\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u00109\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a=\u0010:\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a;\u0010<\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a=\u0010>\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a=\u0010@\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a/\u0010B\u001a\u00020C*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0003¢\u0006\u0002\u0010J\u001a?\u0010K\u001a\u00020L*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020$2\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120N2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\u0010O\u001a,\u0010P\u001a\u0004\u0018\u0001HQ\"\b\b\u0000\u0010Q*\u00020R*\u00020\f2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HQ0TH\u0002¢\u0006\u0002\u0010U\u001a,\u0010P\u001a\u0004\u0018\u0001HQ\"\b\b\u0000\u0010Q*\u00020R*\u00020$2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HQ0TH\u0002¢\u0006\u0002\u0010V\u001a\f\u0010W\u001a\u00020\u001a*\u00020\u0010H\u0002\u001a\f\u0010W\u001a\u00020\u001a*\u00020\u001eH\u0002\u001a\u001f\u0010X\u001a\u00020\f*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\fH\u0001¢\u0006\u0002\u0010Y\u001a\u001f\u0010Z\u001a\u00020$*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010G\u001a\u00020$H\u0001¢\u0006\u0002\u0010[\u001a\u0015\u0010\\\u001a\u00020\f*\u00020\f2\u0006\u0010]\u001a\u00020RH\u0004\u001a\u0015\u0010\\\u001a\u00020$*\u00020$2\u0006\u0010]\u001a\u00020RH\u0004\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006^²\u0006\n\u0010_\u001a\u00020\fX\u0002²\u0006\n\u0010`\u001a\u00020$X\u0002"}, d2 = {"DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createModifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "get", "T", "Landroidx/compose/animation/TransitionEffect;", "key", "Landroidx/compose/animation/TransitionEffectKey;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "toAlignment", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "withEffect", "effect", "animation_release", "activeEnter", "activeExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public final class EnterExitTransitionKt {
    /* access modifiers changed from: private */
    public static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);

    public static final EnterTransition withEffect(EnterTransition enterTransition, TransitionEffect transitionEffect) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, MapsKt.mapOf(TuplesKt.to(transitionEffect.getKey$animation_release(), transitionEffect)), 31, (DefaultConstructorMarker) null));
    }

    public static final ExitTransition withEffect(ExitTransition exitTransition, TransitionEffect transitionEffect) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, MapsKt.mapOf(TuplesKt.to(transitionEffect.getKey$animation_release(), transitionEffect)), 31, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 62, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 62, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, false, (Map) null, 61, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, false, (Map) null, 61, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m80scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m4673getCenterSzJe1aQ();
        }
        return m79scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E  reason: not valid java name */
    public static final EnterTransition m79scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), false, (Map) null, 55, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m82scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m4673getCenterSzJe1aQ();
        }
        return m81scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleOut-L8ZKh-E  reason: not valid java name */
    public static final ExitTransition m81scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), false, (Map) null, 55, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandIn$1.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), (Scale) null, false, (Map) null, 59, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkOut$1.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), (Scale) null, false, (Map) null, 59, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandHorizontally$1.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z, new EnterExitTransitionKt$expandHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandVertically$1.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z, new EnterExitTransitionKt$expandVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkHorizontally$1.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z, new EnterExitTransitionKt$shrinkHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7275boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkVertically$1.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z, new EnterExitTransitionKt$shrinkVertically$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInHorizontally$1.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInVertically$1.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutHorizontally$1.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutVertically$1.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutVertically$2(function1));
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getStart())) {
            return Alignment.Companion.getCenterStart();
        }
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getEnd())) {
            return Alignment.Companion.getCenterEnd();
        }
        return Alignment.Companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop())) {
            return Alignment.Companion.getTopCenter();
        }
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getBottom())) {
            return Alignment.Companion.getBottomCenter();
        }
        return Alignment.Companion.getCenter();
    }

    public static final <T extends TransitionEffect> T get(EnterTransition enterTransition, TransitionEffectKey<T> transitionEffectKey) {
        T t = enterTransition.getData$animation_release().getEffectsMap().get(transitionEffectKey);
        if (t instanceof TransitionEffect) {
            return (TransitionEffect) t;
        }
        return null;
    }

    public static final <T extends TransitionEffect> T get(ExitTransition exitTransition, TransitionEffectKey<T> transitionEffectKey) {
        T t = exitTransition.getData$animation_release().getEffectsMap().get(transitionEffectKey);
        if (t instanceof TransitionEffect) {
            return (TransitionEffect) t;
        }
        return null;
    }

    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, String str, Composer composer, int i, int i2) {
        Transition.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation;
        String str2;
        Transition.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation2;
        ChangeSize changeSize;
        Transition<EnterExitState> transition2 = transition;
        String str3 = str;
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 28261782, "C(createModifier)870@38224L31,871@38277L28,896@39249L56,898@39349L58:EnterExitTransition.kt#xbi5r1");
        Function0<Boolean> function02 = (i2 & 4) != 0 ? EnterExitTransitionKt$createModifier$1.INSTANCE : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(28261782, i3, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:869)");
        }
        int i4 = i3 & 14;
        EnterTransition trackActiveEnter = trackActiveEnter(transition2, enterTransition, composer2, i3 & WebSocketProtocol.PAYLOAD_SHORT);
        int i5 = i3 >> 3;
        ExitTransition trackActiveExit = trackActiveExit(transition2, exitTransition, composer2, (i5 & 112) | i4);
        boolean z = (trackActiveEnter.getData$animation_release().getSlide() == null && trackActiveExit.getData$animation_release().getSlide() == null) ? false : true;
        boolean z2 = (trackActiveEnter.getData$animation_release().getChangeSize() == null && trackActiveExit.getData$animation_release().getChangeSize() == null) ? false : true;
        Transition.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = null;
        if (z) {
            composer2.startReplaceGroup(-821375963);
            ComposerKt.sourceInformation(composer2, "878@38627L27,878@38576L79");
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(composer2, -165041447, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = str3 + " slide";
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            str2 = "CC(remember):EnterExitTransition.kt#9igjgp";
            Transition.DeferredAnimation<IntOffset, AnimationVector2D> createDeferredAnimation = TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) rememberedValue, composer2, i4 | 384, 0);
            composer2.endReplaceGroup();
            deferredAnimation = createDeferredAnimation;
        } else {
            str2 = "CC(remember):EnterExitTransition.kt#9igjgp";
            composer2.startReplaceGroup(-821278096);
            composer2.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z2) {
            composer2.startReplaceGroup(-821202177);
            ComposerKt.sourceInformation(composer2, "883@38800L35,883@38751L85");
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
            ComposerKt.sourceInformationMarkerStart(composer2, -165035903, str2);
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = str3 + " shrink/expand";
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Transition.DeferredAnimation<IntSize, AnimationVector2D> createDeferredAnimation2 = TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue2, composer2, i4 | 384, 0);
            composer2.endReplaceGroup();
            deferredAnimation2 = createDeferredAnimation2;
        } else {
            composer2.startReplaceGroup(-821099041);
            composer2.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z2) {
            composer2.startReplaceGroup(-821034002);
            ComposerKt.sourceInformation(composer2, "889@38995L48,887@38919L134");
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(composer2, -165029650, str2);
            Object rememberedValue3 = composer2.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = str3 + " InterruptionHandlingOffset";
                composer2.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            deferredAnimation3 = TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) rememberedValue3, composer2, i4 | 384, 0);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-820883777);
            composer2.endReplaceGroup();
        }
        ChangeSize changeSize2 = trackActiveEnter.getData$animation_release().getChangeSize();
        boolean z3 = (changeSize2 != null && !changeSize2.getClip()) || ((changeSize = trackActiveExit.getData$animation_release().getChangeSize()) != null && !changeSize.getClip()) || !z2;
        Composer composer3 = composer2;
        EnterTransition enterTransition2 = trackActiveEnter;
        ExitTransition exitTransition2 = trackActiveExit;
        GraphicsLayerBlockForEnterExit createGraphicsLayerBlock = createGraphicsLayerBlock(transition, enterTransition2, exitTransition2, str3, composer3, i4 | (i5 & 7168));
        Composer composer4 = composer3;
        Modifier modifier = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer4, -165018312, str2);
        boolean changed = composer4.changed(z3) | ((((i3 & 7168) ^ 3072) > 2048 && composer4.changed((Object) function02)) || (i3 & 3072) == 2048);
        Object rememberedValue4 = composer4.rememberedValue();
        if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new EnterExitTransitionKt$createModifier$2$1(z3, function02);
            composer4.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        Modifier then = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) rememberedValue4).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransition2, exitTransition2, function02, createGraphicsLayerBlock));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        return then;
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 21614502, "C(trackActiveEnter)915@40149L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:910)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1583278438, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed((Object) transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                trackActiveEnter$lambda$6(mutableState, enterTransition);
            } else {
                trackActiveEnter$lambda$6(mutableState, EnterTransition.Companion.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            trackActiveEnter$lambda$6(mutableState, trackActiveEnter$lambda$5(mutableState).plus(enterTransition));
        }
        EnterTransition trackActiveEnter$lambda$5 = trackActiveEnter$lambda$5(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return trackActiveEnter$lambda$5;
    }

    private static final EnterTransition trackActiveEnter$lambda$5(MutableState<EnterTransition> mutableState) {
        return (EnterTransition) mutableState.getValue();
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1363864804, "C(trackActiveExit)935@41130L39:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:930)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1483140299, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed((Object) transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                trackActiveExit$lambda$9(mutableState, exitTransition);
            } else {
                trackActiveExit$lambda$9(mutableState, ExitTransition.Companion.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            trackActiveExit$lambda$9(mutableState, trackActiveExit$lambda$8(mutableState).plus(exitTransition));
        }
        ExitTransition trackActiveExit$lambda$8 = trackActiveExit$lambda$8(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return trackActiveExit$lambda$8;
    }

    private static final ExitTransition trackActiveExit$lambda$8(MutableState<ExitTransition> mutableState) {
        return (ExitTransition) mutableState.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0147, code lost:
        if (r3.changed((java.lang.Object) r1) == false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0162, code lost:
        if (r3.changed((java.lang.Object) r2) == false) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0181, code lost:
        if (r3.changed((java.lang.Object) r4) == false) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0188, code lost:
        if ((r7 & 6) == 4) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x018a, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x018b, code lost:
        r0 = (r0 | r8) | r3.changedInstance(r12);
        r5 = r3.rememberedValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0195, code lost:
        if (r0 != false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x019d, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x019f, code lost:
        r13 = new androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0(r14, r15, r4, r1, r2, r12);
        r3.updateRememberedValue(r13);
        r5 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01b0, code lost:
        r5 = (androidx.compose.animation.GraphicsLayerBlockForEnterExit) r5;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01b9, code lost:
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01bb, code lost:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01be, code lost:
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01c1, code lost:
        return r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.animation.GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r20, androidx.compose.animation.EnterTransition r21, androidx.compose.animation.ExitTransition r22, java.lang.String r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r0 = r23
            r3 = r24
            r7 = r25
            java.lang.String r1 = "C(createGraphicsLayerBlock)985@42946L2853:EnterExitTransition.kt#xbi5r1"
            r2 = 642253525(0x264802d5, float:6.9392777E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r2, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x001a
            r1 = -1
            java.lang.String r4 = "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:958)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r1, r4)
        L_0x001a:
            androidx.compose.animation.TransitionData r1 = r21.getData$animation_release()
            androidx.compose.animation.Fade r1 = r1.getFade()
            r8 = 0
            r9 = 1
            if (r1 != 0) goto L_0x0033
            androidx.compose.animation.TransitionData r1 = r22.getData$animation_release()
            androidx.compose.animation.Fade r1 = r1.getFade()
            if (r1 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r1 = r8
            goto L_0x0034
        L_0x0033:
            r1 = r9
        L_0x0034:
            androidx.compose.animation.TransitionData r2 = r21.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x004b
            androidx.compose.animation.TransitionData r2 = r22.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r10 = r8
            goto L_0x004c
        L_0x004b:
            r10 = r9
        L_0x004c:
            java.lang.String r11 = "CC(remember):EnterExitTransition.kt#9igjgp"
            r12 = 0
            if (r1 == 0) goto L_0x00a2
            r1 = -675389204(0xffffffffd7be60ec, float:-4.18646971E14)
            r3.startReplaceGroup(r1)
            java.lang.String r1 = "968@42460L27,967@42377L120"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r2 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = -1545804535(0xffffffffa3dce509, float:-2.3949448E-17)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r11)
            java.lang.Object r1 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r1 != r4) goto L_0x008a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r4 = " alpha"
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            r3.updateRememberedValue(r1)
        L_0x008a:
            java.lang.String r1 = (java.lang.String) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r4 = r7 & 14
            r5 = r4 | 384(0x180, float:5.38E-43)
            r6 = 0
            r4 = r3
            r3 = r1
            r1 = r20
            androidx.compose.animation.core.Transition$DeferredAnimation r2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r1, r2, r3, r4, r5, r6)
            r3 = r4
            r3.endReplaceGroup()
            r14 = r2
            goto L_0x00ac
        L_0x00a2:
            r1 = -675252433(0xffffffffd7c0772f, float:-4.23236244E14)
            r3.startReplaceGroup(r1)
            r3.endReplaceGroup()
            r14 = r12
        L_0x00ac:
            if (r10 == 0) goto L_0x00fc
            r1 = -675193780(0xffffffffd7c15c4c, float:-4.25204312E14)
            r3.startReplaceGroup(r1)
            java.lang.String r1 = "974@42657L27,973@42574L120"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r1 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r2 = -1545798231(0xffffffffa3dcfda9, float:-2.3959877E-17)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r2, r11)
            java.lang.Object r2 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x00e7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = " scale"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r0.toString()
            r3.updateRememberedValue(r2)
        L_0x00e7:
            java.lang.String r2 = (java.lang.String) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r0 = r7 & 14
            r4 = r0 | 384(0x180, float:5.38E-43)
            r5 = 0
            r0 = r20
            androidx.compose.animation.core.Transition$DeferredAnimation r1 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r0, r1, r2, r3, r4, r5)
            r3.endReplaceGroup()
            r15 = r1
            goto L_0x0106
        L_0x00fc:
            r0 = -675057009(0xffffffffd7c3728f, float:-4.29793586E14)
            r3.startReplaceGroup(r0)
            r3.endReplaceGroup()
            r15 = r12
        L_0x0106:
            if (r10 == 0) goto L_0x0126
            r0 = -674987940(0xffffffffd7c4805c, float:-4.32111157E14)
            r3.startReplaceGroup(r0)
            java.lang.String r0 = "979@42781L136"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.animation.core.TwoWayConverter<androidx.compose.ui.graphics.TransformOrigin, androidx.compose.animation.core.AnimationVector2D> r1 = TransformOriginVectorConverter
            r0 = r7 & 14
            r4 = r0 | 384(0x180, float:5.38E-43)
            r5 = 0
            java.lang.String r2 = "TransformOriginInterruptionHandling"
            r0 = r20
            androidx.compose.animation.core.Transition$DeferredAnimation r12 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r0, r1, r2, r3, r4, r5)
            r3.endReplaceGroup()
            goto L_0x012f
        L_0x0126:
            r0 = -674835793(0xffffffffd7c6d2af, float:-4.37216363E14)
            r3.startReplaceGroup(r0)
            r3.endReplaceGroup()
        L_0x012f:
            r0 = -1545786157(0xffffffffa3dd2cd3, float:-2.3979852E-17)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r11)
            boolean r0 = r3.changedInstance(r14)
            r1 = r7 & 112(0x70, float:1.57E-43)
            r1 = r1 ^ 48
            r2 = 32
            if (r1 <= r2) goto L_0x014a
            r1 = r21
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 != 0) goto L_0x0150
            goto L_0x014c
        L_0x014a:
            r1 = r21
        L_0x014c:
            r4 = r7 & 48
            if (r4 != r2) goto L_0x0152
        L_0x0150:
            r2 = r9
            goto L_0x0153
        L_0x0152:
            r2 = r8
        L_0x0153:
            r0 = r0 | r2
            r2 = r7 & 896(0x380, float:1.256E-42)
            r2 = r2 ^ 384(0x180, float:5.38E-43)
            r4 = 256(0x100, float:3.59E-43)
            if (r2 <= r4) goto L_0x0165
            r2 = r22
            boolean r5 = r3.changed((java.lang.Object) r2)
            if (r5 != 0) goto L_0x016b
            goto L_0x0167
        L_0x0165:
            r2 = r22
        L_0x0167:
            r5 = r7 & 384(0x180, float:5.38E-43)
            if (r5 != r4) goto L_0x016d
        L_0x016b:
            r4 = r9
            goto L_0x016e
        L_0x016d:
            r4 = r8
        L_0x016e:
            r0 = r0 | r4
            boolean r4 = r3.changedInstance(r15)
            r0 = r0 | r4
            r4 = r7 & 14
            r4 = r4 ^ 6
            r5 = 4
            if (r4 <= r5) goto L_0x0184
            r4 = r20
            boolean r6 = r3.changed((java.lang.Object) r4)
            if (r6 != 0) goto L_0x018a
            goto L_0x0186
        L_0x0184:
            r4 = r20
        L_0x0186:
            r6 = r7 & 6
            if (r6 != r5) goto L_0x018b
        L_0x018a:
            r8 = r9
        L_0x018b:
            r0 = r0 | r8
            boolean r5 = r3.changedInstance(r12)
            r0 = r0 | r5
            java.lang.Object r5 = r3.rememberedValue()
            if (r0 != 0) goto L_0x019f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x01b0
        L_0x019f:
            androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0 r13 = new androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0
            r17 = r1
            r18 = r2
            r16 = r4
            r19 = r12
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r3.updateRememberedValue(r13)
            r5 = r13
        L_0x01b0:
            androidx.compose.animation.GraphicsLayerBlockForEnterExit r5 = (androidx.compose.animation.GraphicsLayerBlockForEnterExit) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01be
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01be:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.animation.GraphicsLayerBlockForEnterExit");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.jvm.functions.Function1 createGraphicsLayerBlock$lambda$13$lambda$12(androidx.compose.animation.core.Transition.DeferredAnimation r3, androidx.compose.animation.core.Transition.DeferredAnimation r4, androidx.compose.animation.core.Transition r5, androidx.compose.animation.EnterTransition r6, androidx.compose.animation.ExitTransition r7, androidx.compose.animation.core.Transition.DeferredAnimation r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0016
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            r1.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2
            r2.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.State r3 = r3.animate(r1, r2)
            goto L_0x0017
        L_0x0016:
            r3 = r0
        L_0x0017:
            if (r4 == 0) goto L_0x002c
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            r1.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2
            r2.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.State r4 = r4.animate(r1, r2)
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            java.lang.Object r5 = r5.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r5 != r1) goto L_0x0053
            androidx.compose.animation.TransitionData r5 = r6.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0048
        L_0x003f:
            long r1 = r5.m108getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4660boximpl(r1)
            goto L_0x0072
        L_0x0048:
            androidx.compose.animation.TransitionData r5 = r7.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0071
            goto L_0x003f
        L_0x0053:
            androidx.compose.animation.TransitionData r5 = r7.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0066
        L_0x005d:
            long r1 = r5.m108getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4660boximpl(r1)
            goto L_0x0072
        L_0x0066:
            androidx.compose.animation.TransitionData r5 = r6.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0071
            goto L_0x005d
        L_0x0071:
            r5 = r0
        L_0x0072:
            if (r8 == 0) goto L_0x0083
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2
            r1.<init>(r5, r6, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.runtime.State r0 = r8.animate(r0, r1)
        L_0x0083:
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1 r5 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
            r5.<init>(r3, r4, r0)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, androidx.compose.animation.core.Transition$DeferredAnimation):kotlin.jvm.functions.Function1");
    }

    private static final void trackActiveEnter$lambda$6(MutableState<EnterTransition> mutableState, EnterTransition enterTransition) {
        mutableState.setValue(enterTransition);
    }

    private static final void trackActiveExit$lambda$9(MutableState<ExitTransition> mutableState, ExitTransition exitTransition) {
        mutableState.setValue(exitTransition);
    }
}
