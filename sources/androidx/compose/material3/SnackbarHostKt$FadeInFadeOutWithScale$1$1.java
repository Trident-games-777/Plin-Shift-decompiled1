package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "children", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "invoke", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$1$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ SnackbarData $current;
    final /* synthetic */ SnackbarData $key;
    final /* synthetic */ List<SnackbarData> $keys;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData snackbarData, SnackbarData snackbarData2, List<SnackbarData> list, FadeInFadeOutState<SnackbarData> fadeInFadeOutState) {
        super(3);
        this.$key = snackbarData;
        this.$current = snackbarData2;
        this.$keys = list;
        this.$state = fadeInFadeOutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40) {
        /*
            r37 = this;
            r0 = r37
            r1 = r38
            r5 = r39
            java.lang.String r2 = "C356@14017L313,348@13634L718,365@14401L364,380@15042L241,374@14782L570:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = r40 & 6
            if (r2 != 0) goto L_0x001c
            boolean r2 = r5.changedInstance(r1)
            if (r2 == 0) goto L_0x0017
            r2 = 4
            goto L_0x0018
        L_0x0017:
            r2 = 2
        L_0x0018:
            r2 = r40 | r2
            r8 = r2
            goto L_0x001e
        L_0x001c:
            r8 = r40
        L_0x001e:
            r2 = r8 & 19
            r3 = 18
            if (r2 != r3) goto L_0x002f
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            r5.skipToGroupEnd()
            return
        L_0x002f:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x003e
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)"
            r4 = -1654683077(0xffffffff9d5f8a3b, float:-2.9585268E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r8, r2, r3)
        L_0x003e:
            androidx.compose.material3.SnackbarData r2 = r0.$key
            androidx.compose.material3.SnackbarData r3 = r0.$current
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r2 = 75
            if (r3 == 0) goto L_0x004e
            r4 = 150(0x96, float:2.1E-43)
            r9 = r4
            goto L_0x004f
        L_0x004e:
            r9 = r2
        L_0x004f:
            r10 = 1
            r11 = 0
            if (r3 == 0) goto L_0x0061
            java.util.List<androidx.compose.material3.SnackbarData> r4 = r0.$keys
            java.util.List r4 = androidx.compose.ui.util.ListUtilsKt.fastFilterNotNull(r4)
            int r4 = r4.size()
            if (r4 == r10) goto L_0x0061
            r12 = r2
            goto L_0x0062
        L_0x0061:
            r12 = r11
        L_0x0062:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween(r9, r12, r2)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = 1201029357(0x479640ed, float:76929.85)
            java.lang.String r13 = "CC(remember):SnackbarHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r13)
            androidx.compose.material3.SnackbarData r4 = r0.$key
            boolean r4 = r5.changed((java.lang.Object) r4)
            androidx.compose.material3.FadeInFadeOutState<androidx.compose.material3.SnackbarData> r6 = r0.$state
            boolean r6 = r5.changedInstance(r6)
            r4 = r4 | r6
            androidx.compose.material3.SnackbarData r6 = r0.$key
            androidx.compose.material3.FadeInFadeOutState<androidx.compose.material3.SnackbarData> r7 = r0.$state
            java.lang.Object r14 = r5.rememberedValue()
            if (r4 != 0) goto L_0x0093
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r14 != r4) goto L_0x009e
        L_0x0093:
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1 r4 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
            r4.<init>(r6, r7)
            r14 = r4
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r5.updateRememberedValue(r14)
        L_0x009e:
            r4 = r14
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r6 = 0
            r7 = 0
            androidx.compose.runtime.State r2 = androidx.compose.material3.SnackbarHostKt.animatedOpacity(r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.core.Easing r4 = androidx.compose.animation.core.EasingKt.getFastOutSlowInEasing()
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween(r9, r12, r4)
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            androidx.compose.runtime.State r3 = androidx.compose.material3.SnackbarHostKt.animatedScale(r4, r3, r5, r11)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r14 = r4
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            java.lang.Object r4 = r3.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r15 = r4.floatValue()
            java.lang.Object r3 = r3.getValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r16 = r3.floatValue()
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r17 = r2.floatValue()
            r35 = 131064(0x1fff8, float:1.8366E-40)
            r36 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r32, r34, r35, r36)
            r3 = 1201062085(0x4796c0c5, float:77185.54)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r13)
            androidx.compose.material3.SnackbarData r3 = r0.$key
            boolean r3 = r5.changed((java.lang.Object) r3)
            androidx.compose.material3.SnackbarData r4 = r0.$key
            java.lang.Object r6 = r5.rememberedValue()
            if (r3 != 0) goto L_0x011c
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x0127
        L_0x011c:
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1 r3 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
            r3.<init>(r4)
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5.updateRememberedValue(r6)
        L_0x0127:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r3 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r11, r6, r10, r3)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r3, r11)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r6)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r11)
            androidx.compose.runtime.CompositionLocalMap r6 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r9 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r10 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r10)
            androidx.compose.runtime.Applier r9 = r5.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0170
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0170:
            r5.startReusableNode()
            boolean r9 = r5.getInserting()
            if (r9 == 0) goto L_0x017d
            r5.createNode(r7)
            goto L_0x0180
        L_0x017d:
            r5.useNode()
        L_0x0180:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r6, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r6 = r7.getInserting()
            if (r6 != 0) goto L_0x01b0
            java.lang.Object r6 = r7.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)
            if (r6 != 0) goto L_0x01be
        L_0x01b0:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r7.updateRememberedValue(r6)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.apply(r4, r3)
        L_0x01be:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r2, r3)
            r2 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r3 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = -514884474(0xffffffffe14f7c86, float:-2.3921556E20)
            java.lang.String r3 = "C388@15324L10:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            r2 = r8 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.invoke(r5, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r5.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke(kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
