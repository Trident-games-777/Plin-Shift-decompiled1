package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "invoke", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$3 extends Lambda implements Function3<SaveableStateHolder, Composer, Integer, Unit> {
    final /* synthetic */ State<Function0<LazyLayoutItemProvider>> $currentItemProvider;
    final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$3(LazyLayoutPrefetchState lazyLayoutPrefetchState, Modifier modifier, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, State<? extends Function0<? extends LazyLayoutItemProvider>> state) {
        super(3);
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$modifier = modifier;
        this.$measurePolicy = function2;
        this.$currentItemProvider = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SaveableStateHolder) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.saveable.SaveableStateHolder r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = "C82@3396L114,85@3547L101,110@4439L392,107@4312L529:LazyLayout.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:82)"
            r2 = -1488997347(0xffffffffa73fb41d, float:-2.6604214E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x0014:
            r11 = 6611731(0x64e313, float:9.265008E-39)
            java.lang.String r0 = "CC(remember):LazyLayout.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r11, r0)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>> r11 = r8.$currentItemProvider
            java.lang.Object r1 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0039
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r1 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1 r2 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1
            r2.<init>(r11)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r1.<init>(r9, r2)
            r10.updateRememberedValue(r1)
        L_0x0039:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r9 = 6616550(0x64f5e6, float:9.271761E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r0)
            java.lang.Object r9 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r9 != r11) goto L_0x005f
            androidx.compose.ui.layout.SubcomposeLayoutState r9 = new androidx.compose.ui.layout.SubcomposeLayoutState
            androidx.compose.foundation.lazy.layout.LazyLayoutItemReusePolicy r11 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemReusePolicy
            r11.<init>(r1)
            androidx.compose.ui.layout.SubcomposeSlotReusePolicy r11 = (androidx.compose.ui.layout.SubcomposeSlotReusePolicy) r11
            r9.<init>((androidx.compose.ui.layout.SubcomposeSlotReusePolicy) r11)
            r10.updateRememberedValue(r9)
        L_0x005f:
            r2 = r9
            androidx.compose.ui.layout.SubcomposeLayoutState r2 = (androidx.compose.ui.layout.SubcomposeLayoutState) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r9 = r8.$prefetchState
            if (r9 == 0) goto L_0x00de
            r9 = 205264983(0xc3c1857, float:1.4490318E-31)
            r10.startReplaceGroup(r9)
            java.lang.String r9 = "95@3958L334,90@3795L497"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r9 = r8.$prefetchState
            androidx.compose.foundation.lazy.layout.PrefetchScheduler r9 = r9.getPrefetchScheduler$foundation_release()
            r11 = 0
            if (r9 != 0) goto L_0x008d
            r9 = 6622915(0x650ec3, float:9.28068E-39)
            r10.startReplaceGroup(r9)
            java.lang.String r9 = "89@3748L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            androidx.compose.foundation.lazy.layout.PrefetchScheduler r9 = androidx.compose.foundation.lazy.layout.PrefetchScheduler_androidKt.rememberDefaultPrefetchScheduler(r10, r11)
            goto L_0x0093
        L_0x008d:
            r3 = 6621830(0x650a86, float:9.27916E-39)
            r10.startReplaceGroup(r3)
        L_0x0093:
            r10.endReplaceGroup()
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r8.$prefetchState
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r1, r2, r9}
            r4 = 6629935(0x652a2f, float:9.290518E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r0)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r4 = r8.$prefetchState
            boolean r4 = r10.changed((java.lang.Object) r4)
            boolean r5 = r10.changedInstance(r1)
            r4 = r4 | r5
            boolean r5 = r10.changedInstance(r2)
            r4 = r4 | r5
            boolean r5 = r10.changedInstance(r9)
            r4 = r4 | r5
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r5 = r8.$prefetchState
            java.lang.Object r6 = r10.rememberedValue()
            if (r4 != 0) goto L_0x00c7
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x00d2
        L_0x00c7:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$1$1 r4 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$1$1
            r4.<init>(r5, r1, r2, r9)
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r10.updateRememberedValue(r6)
        L_0x00d2:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object[]) r3, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r6, (androidx.compose.runtime.Composer) r10, (int) r11)
            r10.endReplaceGroup()
            goto L_0x00e7
        L_0x00de:
            r9 = 205858881(0xc452841, float:1.5188441E-31)
            r10.startReplaceGroup(r9)
            r10.endReplaceGroup()
        L_0x00e7:
            androidx.compose.ui.Modifier r9 = r8.$modifier
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r11 = r8.$prefetchState
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchStateKt.traversablePrefetchState(r9, r11)
            r9 = 6645385(0x656689, float:9.312168E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r0)
            boolean r9 = r10.changed((java.lang.Object) r1)
            kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> r11 = r8.$measurePolicy
            boolean r11 = r10.changed((java.lang.Object) r11)
            r9 = r9 | r11
            kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> r11 = r8.$measurePolicy
            java.lang.Object r0 = r10.rememberedValue()
            if (r9 != 0) goto L_0x0110
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x011b
        L_0x0110:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1 r9 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1
            r9.<init>(r1, r11)
            r0 = r9
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateRememberedValue(r0)
        L_0x011b:
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            int r6 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            r7 = 0
            r5 = r10
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r2, r3, r4, r5, r6, r7)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0131
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3.invoke(androidx.compose.runtime.saveable.SaveableStateHolder, androidx.compose.runtime.Composer, int):void");
    }
}
