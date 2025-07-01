package androidx.compose.animation;

import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/TransformOrigin;", "it", "Landroidx/compose/animation/EnterExitState;", "invoke-LIALnN8", "(Landroidx/compose/animation/EnterExitState;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2 extends Lambda implements Function1<EnterExitState, TransformOrigin> {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;
    final /* synthetic */ TransformOrigin $transformOriginWhenVisible;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: EnterExitTransition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.animation.EnterExitState[] r0 = androidx.compose.animation.EnterExitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.Visible     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PostExit     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2(TransformOrigin transformOrigin, EnterTransition enterTransition, ExitTransition exitTransition) {
        super(1);
        this.$transformOriginWhenVisible = transformOrigin;
        this.$enter = enterTransition;
        this.$exit = exitTransition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TransformOrigin.m4660boximpl(m85invokeLIALnN8((EnterExitState) obj));
    }

    /* renamed from: invoke-LIALnN8  reason: not valid java name */
    public final long m85invokeLIALnN8(EnterExitState enterExitState) {
        TransformOrigin transformOrigin;
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i != 1) {
            transformOrigin = null;
            if (i == 2) {
                Scale scale = this.$enter.getData$animation_release().getScale();
                if (!(scale == null && (scale = this.$exit.getData$animation_release().getScale()) == null)) {
                    transformOrigin = TransformOrigin.m4660boximpl(scale.m108getTransformOriginSzJe1aQ());
                }
            } else if (i == 3) {
                Scale scale2 = this.$exit.getData$animation_release().getScale();
                if (!(scale2 == null && (scale2 = this.$enter.getData$animation_release().getScale()) == null)) {
                    transformOrigin = TransformOrigin.m4660boximpl(scale2.m108getTransformOriginSzJe1aQ());
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            transformOrigin = this.$transformOriginWhenVisible;
        }
        if (transformOrigin != null) {
            return transformOrigin.m4672unboximpl();
        }
        return TransformOrigin.Companion.m4673getCenterSzJe1aQ();
    }
}
