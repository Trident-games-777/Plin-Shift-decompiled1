package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeImpl$sharedBounds$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ AnimatedVisibilityScope $animatedVisibilityScope;
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;
    final /* synthetic */ SharedTransitionScope.ResizeMode $resizeMode;
    final /* synthetic */ SharedTransitionScope.SharedContentState $sharedContentState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeImpl$sharedBounds$2(AnimatedVisibilityScope animatedVisibilityScope, EnterTransition enterTransition, ExitTransition exitTransition, SharedTransitionScope.SharedContentState sharedContentState, SharedTransitionScope.ResizeMode resizeMode) {
        super(3);
        this.$animatedVisibilityScope = animatedVisibilityScope;
        this.$enter = enterTransition;
        this.$exit = exitTransition;
        this.$sharedContentState = sharedContentState;
        this.$resizeMode = resizeMode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            r8 = this;
            r9 = -419341573(0xffffffffe7015afb, float:-6.108636E23)
            r10.startReplaceGroup(r9)
            java.lang.String r0 = "C779@41927L35,771@41404L656:SharedTransitionScope.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0017
            r0 = -1
            java.lang.String r1 = "androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.<anonymous> (SharedTransitionScope.kt:770)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r11, r0, r1)
        L_0x0017:
            androidx.compose.animation.AnimatedVisibilityScope r9 = r8.$animatedVisibilityScope
            androidx.compose.animation.core.Transition r0 = r9.getTransition()
            androidx.compose.animation.EnterTransition r1 = r8.$enter
            androidx.compose.animation.ExitTransition r2 = r8.$exit
            r9 = -1411456741(0xffffffffabdee11b, float:-1.5836528E-12)
            java.lang.String r11 = "CC(remember):SharedTransitionScope.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r11)
            androidx.compose.animation.SharedTransitionScope$SharedContentState r9 = r8.$sharedContentState
            boolean r9 = r10.changedInstance(r9)
            androidx.compose.animation.SharedTransitionScope$SharedContentState r3 = r8.$sharedContentState
            java.lang.Object r4 = r10.rememberedValue()
            if (r9 != 0) goto L_0x003f
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x004a
        L_0x003f:
            androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1 r9 = new androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1
            r9.<init>(r3)
            r4 = r9
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r10.updateRememberedValue(r4)
        L_0x004a:
            r3 = r4
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = "enter/exit for "
            r9.<init>(r4)
            androidx.compose.animation.SharedTransitionScope$SharedContentState r4 = r8.$sharedContentState
            java.lang.Object r4 = r4.getKey()
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r4 = r9.toString()
            r6 = 0
            r7 = 0
            r5 = r10
            androidx.compose.ui.Modifier r9 = androidx.compose.animation.EnterExitTransitionKt.createModifier(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.SharedTransitionScope$ResizeMode r10 = r8.$resizeMode
            boolean r10 = r10 instanceof androidx.compose.animation.ScaleToBoundsImpl
            if (r10 == 0) goto L_0x00b9
            r10 = -805247216(0xffffffffd000e710, float:-8.6505062E9)
            r5.startReplaceGroup(r10)
            java.lang.String r10 = "784@42227L530"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r10)
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            androidx.compose.animation.SharedTransitionScope$ResizeMode r0 = r8.$resizeMode
            androidx.compose.animation.ScaleToBoundsImpl r0 = (androidx.compose.animation.ScaleToBoundsImpl) r0
            r1 = -1411446646(0xffffffffabdf088a, float:-1.5847473E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r1, r11)
            androidx.compose.animation.SharedTransitionScope$SharedContentState r11 = r8.$sharedContentState
            boolean r11 = r5.changedInstance(r11)
            androidx.compose.animation.SharedTransitionScope$SharedContentState r1 = r8.$sharedContentState
            java.lang.Object r2 = r5.rememberedValue()
            if (r11 != 0) goto L_0x00a1
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r2 != r11) goto L_0x00ac
        L_0x00a1:
            androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1 r11 = new androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1
            r11.<init>(r1)
            r2 = r11
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r5.updateRememberedValue(r2)
        L_0x00ac:
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.Modifier r10 = androidx.compose.animation.SharedTransitionScopeKt.createContentScaleModifier(r10, r0, r2)
            r5.endReplaceGroup()
            goto L_0x00c6
        L_0x00b9:
            r10 = -804630006(0xffffffffd00a520a, float:-9.2825293E9)
            r5.startReplaceGroup(r10)
            r5.endReplaceGroup()
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
        L_0x00c6:
            androidx.compose.ui.Modifier r9 = r9.then(r10)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00d3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d3:
            r5.endReplaceGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
