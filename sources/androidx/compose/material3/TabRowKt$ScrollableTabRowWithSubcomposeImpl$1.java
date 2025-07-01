package androidx.compose.material3;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$ScrollableTabRowWithSubcomposeImpl$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(ScrollState scrollState, float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$scrollState = scrollState;
        this.$edgePadding = f;
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$selectedTabIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: androidx.compose.material3.ScrollableTabData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "C1016@44196L24,1018@44265L147,1027@44663L3376,1021@44421L3618:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 3
            r4 = 2
            if (r3 != r4) goto L_0x001b
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            r1.skipToGroupEnd()
            return
        L_0x001b:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002a
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1016)"
            r6 = -1572959552(0xffffffffa23e8ac0, float:-2.5823255E-18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x002a:
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r3 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r3)
            r2 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r3 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r3)
            java.lang.Object r2 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0057
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r1.updateRememberedValue(r3)
            r2 = r3
        L_0x0057:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r3 = -702892231(0xffffffffd61ab739, float:-4.2527931E13)
            java.lang.String r5 = "CC(remember):TabRow.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r5)
            androidx.compose.foundation.ScrollState r3 = r0.$scrollState
            boolean r3 = r1.changed((java.lang.Object) r3)
            boolean r6 = r1.changed((java.lang.Object) r2)
            r3 = r3 | r6
            androidx.compose.foundation.ScrollState r6 = r0.$scrollState
            java.lang.Object r7 = r1.rememberedValue()
            if (r3 != 0) goto L_0x0086
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r7 != r3) goto L_0x008e
        L_0x0086:
            androidx.compose.material3.ScrollableTabData r7 = new androidx.compose.material3.ScrollableTabData
            r7.<init>(r6, r2)
            r1.updateRememberedValue(r7)
        L_0x008e:
            r12 = r7
            androidx.compose.material3.ScrollableTabData r12 = (androidx.compose.material3.ScrollableTabData) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 0
            r6 = 1
            r7 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r3, r6, r7)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenterStart()
            r6 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r2, r3, r6, r4, r7)
            androidx.compose.foundation.ScrollState r14 = r0.$scrollState
            r18 = 14
            r19 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ScrollKt.horizontalScroll$default(r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r2)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ClipKt.clipToBounds(r2)
            r3 = -702876266(0xffffffffd61af596, float:-4.2594894E13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r5)
            float r3 = r0.$edgePadding
            boolean r3 = r1.changed((float) r3)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$tabs
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$divider
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material3.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$indicator
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            boolean r4 = r1.changedInstance(r12)
            r3 = r3 | r4
            int r4 = r0.$selectedTabIndex
            boolean r4 = r1.changed((int) r4)
            r3 = r3 | r4
            float r9 = r0.$edgePadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.$tabs
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$divider
            int r13 = r0.$selectedTabIndex
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material3.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$indicator
            java.lang.Object r4 = r1.rememberedValue()
            if (r3 != 0) goto L_0x0106
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0111
        L_0x0106:
            androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1 r8 = new androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r4 = r8
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r1.updateRememberedValue(r4)
        L_0x0111:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r2, r4, r1, r6, r6)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0122
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
