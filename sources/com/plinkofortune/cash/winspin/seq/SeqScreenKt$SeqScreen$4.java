package com.plinkofortune.cash.winspin.seq;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.seq.models.BallInScreen;
import com.plinkofortune.cash.winspin.seq.models.Multi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqScreen.kt */
final class SeqScreenKt$SeqScreen$4 implements Function4<AnimatedContentScope, Boolean, Composer, Integer, Unit> {
    final /* synthetic */ SeqState $currentState;
    final /* synthetic */ Density $density;
    final /* synthetic */ Function0<Unit> $mortal;
    final /* synthetic */ float $screenHeightDp;
    final /* synthetic */ float $screenWidthDp;
    final /* synthetic */ SeqViewModel $viewmodel;

    SeqScreenKt$SeqScreen$4(SeqState seqState, Function0<Unit> function0, Density density, SeqViewModel seqViewModel, float f, float f2) {
        this.$currentState = seqState;
        this.$mortal = function0;
        this.$density = density;
        this.$viewmodel = seqViewModel;
        this.$screenWidthDp = f;
        this.$screenHeightDp = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v133, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.animation.AnimatedContentScope r87, boolean r88, androidx.compose.runtime.Composer r89, int r90) {
        /*
            r86 = this;
            r0 = r86
            r8 = r89
            r1 = 21
            byte[] r1 = new byte[r1]
            r1 = {-7, -40, 55, -90, 60, 33, 33, -46, -76, -63, 62, -69, 42, 97, 35, -45, -77, -40, 58, -95, 59} // fill-array
            r9 = 8
            byte[] r2 = new byte[r9]
            r2 = {-35, -84, 95, -49, 79, 5, 96, -68} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r2)
            r2 = r87
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x003a
            r1 = 74
            byte[] r1 = new byte[r1]
            r1 = {49, 80, 69, 10, -98, -30, 86, 1, 57, 80, 78, 75, -100, -6, 74, 1, 55, 17, 75, 69, -99, -26, 17, 24, 59, 81, 91, 84, -121, -32, 17, 28, 55, 78, 6, 119, -117, -1, 108, 12, 32, 90, 77, 74, -64, -78, 94, 1, 61, 81, 81, 73, -127, -5, 76, 81, 114, 23, 123, 65, -97, -35, 92, 29, 55, 90, 70, 10, -123, -6, 5, 88, 107, 22} // fill-array
            byte[] r2 = new byte[r9]
            r2 = {82, 63, 40, 36, -18, -114, 63, 111} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r2)
            r2 = 1336964056(0x4fb073d8, float:5.9207639E9)
            r3 = -1
            r4 = r90
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r3, r1)
        L_0x003a:
            if (r88 == 0) goto L_0x008e
            r1 = 860825321(0x334f26e9, float:4.8231332E-8)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            int r1 = r1.getRound()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            int r2 = r2.getStars()
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            int r3 = r3.getTime()
            com.plinkofortune.cash.winspin.seq.SeqState r4 = r0.$currentState
            int r4 = r4.getScore()
            r5 = -1773343429(0xffffffff964ced3b, float:-1.6553846E-25)
            r8.startReplaceGroup(r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r0.$mortal
            boolean r5 = r8.changed((java.lang.Object) r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r0.$mortal
            java.lang.Object r7 = r8.rememberedValue()
            if (r5 != 0) goto L_0x0076
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x007e
        L_0x0076:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda0 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda0
            r7.<init>(r6)
            r8.updateRememberedValue(r7)
        L_0x007e:
            r5 = r7
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r8.endReplaceGroup()
            r7 = 0
            r6 = r8
            com.plinkofortune.cash.winspin.seq.SeqFinKt.SeqFin(r1, r2, r3, r4, r5, r6, r7)
            r8.endReplaceGroup()
            goto L_0x1e4b
        L_0x008e:
            r1 = 862254297(0x3364f4d9, float:5.3308074E-8)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            int r1 = r1.getScore()
            r2 = 800(0x320, float:1.121E-42)
            r10 = 0
            r11 = 0
            r12 = 6
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r10, r11, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r6 = 48
            r7 = 12
            r3 = 0
            r4 = 0
            r5 = r8
            androidx.compose.runtime.State r26 = androidx.compose.animation.core.AnimateAsStateKt.animateIntAsState(r1, r2, r3, r4, r5, r6, r7)
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773334512(0xffffffff964d1010, float:-1.6564837E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r3 = r8.rememberedValue()
            if (r1 != 0) goto L_0x00d0
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x00dc
        L_0x00d0:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda2 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda2
            r1.<init>(r2)
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r3)
        L_0x00dc:
            r13 = r3
            androidx.compose.runtime.State r13 = (androidx.compose.runtime.State) r13
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773324944(0xffffffff964d3570, float:-1.657663E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r3 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0102
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x010e
        L_0x0102:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda14 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda14
            r1.<init>(r2)
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r3)
        L_0x010e:
            r14 = r3
            androidx.compose.runtime.State r14 = (androidx.compose.runtime.State) r14
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773315376(0xffffffff964d5ad0, float:-1.6588423E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r3 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0134
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0140
        L_0x0134:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda21 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda21
            r1.<init>(r2)
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r3)
        L_0x0140:
            r15 = r3
            androidx.compose.runtime.State r15 = (androidx.compose.runtime.State) r15
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773305808(0xffffffff964d8030, float:-1.6600217E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r3 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0166
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0172
        L_0x0166:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda23 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda23
            r1.<init>(r2)
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r3)
        L_0x0172:
            androidx.compose.runtime.State r3 = (androidx.compose.runtime.State) r3
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773296240(0xffffffff964da590, float:-1.661201E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0197
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x01a3
        L_0x0197:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda24 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda24
            r1.<init>(r2)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r4)
        L_0x01a3:
            androidx.compose.runtime.State r4 = (androidx.compose.runtime.State) r4
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773286672(0xffffffff964dcaf0, float:-1.6623804E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r5 = r8.rememberedValue()
            if (r1 != 0) goto L_0x01c8
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r5 != r1) goto L_0x01d4
        L_0x01c8:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda25 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda25
            r1.<init>(r2)
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r5)
        L_0x01d4:
            androidx.compose.runtime.State r5 = (androidx.compose.runtime.State) r5
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = r0.$currentState
            java.util.List r1 = r1.getBallsInScreen()
            r2 = -1773277104(0xffffffff964df050, float:-1.6635597E-25)
            r8.startReplaceGroup(r2)
            boolean r1 = r8.changed((java.lang.Object) r1)
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.lang.Object r6 = r8.rememberedValue()
            if (r1 != 0) goto L_0x01f9
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r6 != r1) goto L_0x0205
        L_0x01f9:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda26 r1 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda26
            r1.<init>(r2)
            androidx.compose.runtime.State r6 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r1)
            r8.updateRememberedValue(r6)
        L_0x0205:
            androidx.compose.runtime.State r6 = (androidx.compose.runtime.State) r6
            r8.endReplaceGroup()
            androidx.compose.ui.unit.Density r1 = r0.$density
            float r2 = r0.$screenWidthDp
            float r1 = r1.m7091toPx0680j_4(r2)
            r2 = 1041194025(0x3e0f5c29, float:0.14)
            float r1 = r1 * r2
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$5(r13)
            r7 = 1
            if (r2 == 0) goto L_0x0223
            int r2 = r2.getRow()
            int r2 = r2 - r7
            goto L_0x0224
        L_0x0223:
            r2 = r10
        L_0x0224:
            float r2 = (float) r2
            float r1 = r1 * r2
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r9 = 1000(0x3e8, float:1.401E-42)
            r12 = 2
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r17 = r7
            r7 = 0
            r8 = 28
            r18 = r3
            r3 = 0
            r19 = r4
            r4 = 0
            r20 = r5
            r5 = 0
            r28 = r6
            r9 = r17
            r88 = r18
            r90 = r19
            r27 = r20
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenWidthDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1041194025(0x3e0f5c29, float:0.14)
            float r2 = r2 * r3
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r3 = invoke$lambda$8(r14)
            if (r3 == 0) goto L_0x0269
            int r3 = r3.getRow()
            int r3 = r3 - r9
            goto L_0x026a
        L_0x0269:
            r3 = r10
        L_0x026a:
            float r3 = (float) r3
            float r2 = r2 * r3
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r3, r12, r11)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = 0
            r8 = 28
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r29 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenWidthDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1041194025(0x3e0f5c29, float:0.14)
            float r2 = r2 * r3
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r3 = invoke$lambda$11(r15)
            if (r3 == 0) goto L_0x02a3
            int r3 = r3.getRow()
            int r3 = r3 - r9
            goto L_0x02a4
        L_0x02a3:
            r3 = r10
        L_0x02a4:
            float r3 = (float) r3
            float r2 = r2 * r3
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r3, r12, r11)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = 0
            r8 = 28
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r30 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenWidthDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1041194025(0x3e0f5c29, float:0.14)
            float r2 = r2 * r3
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r3 = invoke$lambda$14(r88)
            if (r3 == 0) goto L_0x02dd
            int r3 = r3.getRow()
            int r3 = r3 - r9
            goto L_0x02de
        L_0x02dd:
            r3 = r10
        L_0x02de:
            float r3 = (float) r3
            float r2 = r2 * r3
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r3, r12, r11)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = 0
            r8 = 28
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r31 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenWidthDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1041194025(0x3e0f5c29, float:0.14)
            float r2 = r2 * r3
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r3 = invoke$lambda$17(r90)
            if (r3 == 0) goto L_0x0317
            int r3 = r3.getRow()
            int r3 = r3 - r9
            goto L_0x0318
        L_0x0317:
            r3 = r10
        L_0x0318:
            float r3 = (float) r3
            float r2 = r2 * r3
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r3, r12, r11)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = 0
            r8 = 28
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r32 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenWidthDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1041194025(0x3e0f5c29, float:0.14)
            float r2 = r2 * r3
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r3 = invoke$lambda$20(r27)
            if (r3 == 0) goto L_0x0351
            int r3 = r3.getRow()
            int r3 = r3 - r9
            goto L_0x0352
        L_0x0351:
            r3 = r10
        L_0x0352:
            float r3 = (float) r3
            float r2 = r2 * r3
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r3, r12, r11)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = 0
            r8 = 28
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r33 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenWidthDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1041194025(0x3e0f5c29, float:0.14)
            float r2 = r2 * r3
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r3 = invoke$lambda$23(r28)
            if (r3 == 0) goto L_0x038b
            int r3 = r3.getRow()
            int r3 = r3 - r9
            goto L_0x038c
        L_0x038b:
            r3 = r10
        L_0x038c:
            float r3 = (float) r3
            float r2 = r2 * r3
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r3, r12, r11)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = 0
            r8 = 28
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r34 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$5(r13)
            if (r2 == 0) goto L_0x03c6
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x03c6
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r4 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r4)
            r4 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 * r4
            goto L_0x03c7
        L_0x03c6:
            r2 = r3
        L_0x03c7:
            androidx.compose.animation.core.Easing r4 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r5 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r10, r4, r12, r11)
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r5 = -1773179648(0xffffffff964f6d00, float:-1.6755721E-25)
            r8.startReplaceGroup(r5)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r5 = r0.$viewmodel
            boolean r5 = r8.changedInstance(r5)
            boolean r6 = r8.changed((java.lang.Object) r13)
            r5 = r5 | r6
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = r0.$viewmodel
            java.lang.Object r7 = r8.rememberedValue()
            if (r5 != 0) goto L_0x03f4
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x03fc
        L_0x03f4:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda27 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda27
            r7.<init>(r6, r13)
            r8.updateRememberedValue(r7)
        L_0x03fc:
            r5 = r7
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r8.endReplaceGroup()
            r7 = 0
            r8 = 12
            r6 = r3
            r3 = 0
            r18 = r1
            r1 = r2
            r2 = r4
            r4 = 0
            r19 = r13
            r35 = r18
            r13 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$8(r14)
            if (r2 == 0) goto L_0x0430
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x0430
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r2
            goto L_0x0431
        L_0x0430:
            r3 = r13
        L_0x0431:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = -1773165248(0xffffffff964fa540, float:-1.677347E-25)
            r8.startReplaceGroup(r4)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r4 = r0.$viewmodel
            boolean r4 = r8.changedInstance(r4)
            boolean r5 = r8.changed((java.lang.Object) r14)
            r4 = r4 | r5
            com.plinkofortune.cash.winspin.seq.SeqViewModel r5 = r0.$viewmodel
            java.lang.Object r6 = r8.rememberedValue()
            if (r4 != 0) goto L_0x045e
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x0466
        L_0x045e:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda28 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda28
            r6.<init>(r5, r14)
            r8.updateRememberedValue(r6)
        L_0x0466:
            r5 = r6
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r8.endReplaceGroup()
            r7 = 0
            r8 = 12
            r4 = r1
            r1 = r3
            r3 = 0
            r6 = r4
            r4 = 0
            r36 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$11(r15)
            if (r2 == 0) goto L_0x0495
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x0495
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r2
            goto L_0x0496
        L_0x0495:
            r3 = r13
        L_0x0496:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = -1773150848(0xffffffff964fdd80, float:-1.679122E-25)
            r8.startReplaceGroup(r4)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r4 = r0.$viewmodel
            boolean r4 = r8.changedInstance(r4)
            boolean r5 = r8.changed((java.lang.Object) r15)
            r4 = r4 | r5
            com.plinkofortune.cash.winspin.seq.SeqViewModel r5 = r0.$viewmodel
            java.lang.Object r6 = r8.rememberedValue()
            if (r4 != 0) goto L_0x04c3
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x04cb
        L_0x04c3:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda11 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda11
            r6.<init>(r5, r15)
            r8.updateRememberedValue(r6)
        L_0x04cb:
            r5 = r6
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r8.endReplaceGroup()
            r7 = 0
            r8 = 12
            r4 = r1
            r1 = r3
            r3 = 0
            r6 = r4
            r4 = 0
            r37 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$14(r88)
            if (r2 == 0) goto L_0x04fa
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x04fa
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r2
            goto L_0x04fb
        L_0x04fa:
            r3 = r13
        L_0x04fb:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = -1773136448(0xffffffff965015c0, float:-1.6808969E-25)
            r8.startReplaceGroup(r4)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r4 = r0.$viewmodel
            boolean r4 = r8.changedInstance(r4)
            r5 = r88
            boolean r6 = r8.changed((java.lang.Object) r5)
            r4 = r4 | r6
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = r0.$viewmodel
            java.lang.Object r7 = r8.rememberedValue()
            if (r4 != 0) goto L_0x052a
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x0532
        L_0x052a:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda22 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda22
            r7.<init>(r6, r5)
            r8.updateRememberedValue(r7)
        L_0x0532:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8.endReplaceGroup()
            r18 = r5
            r5 = r7
            r7 = 0
            r8 = 12
            r4 = r1
            r1 = r3
            r3 = 0
            r6 = r4
            r4 = 0
            r39 = r6
            r38 = r18
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$17(r90)
            if (r2 == 0) goto L_0x0565
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x0565
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r2
            goto L_0x0566
        L_0x0565:
            r3 = r13
        L_0x0566:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = -1773122048(0xffffffff96504e00, float:-1.6826719E-25)
            r8.startReplaceGroup(r4)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r4 = r0.$viewmodel
            boolean r4 = r8.changedInstance(r4)
            r5 = r90
            boolean r6 = r8.changed((java.lang.Object) r5)
            r4 = r4 | r6
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = r0.$viewmodel
            java.lang.Object r7 = r8.rememberedValue()
            if (r4 != 0) goto L_0x0595
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x059d
        L_0x0595:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda29 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda29
            r7.<init>(r6, r5)
            r8.updateRememberedValue(r7)
        L_0x059d:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8.endReplaceGroup()
            r4 = r5
            r5 = r7
            r7 = 0
            r8 = 12
            r6 = r1
            r1 = r3
            r3 = 0
            r18 = r4
            r4 = 0
            r41 = r6
            r40 = r18
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$20(r27)
            if (r2 == 0) goto L_0x05d0
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x05d0
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r2
            goto L_0x05d1
        L_0x05d0:
            r3 = r13
        L_0x05d1:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = -1773107648(0xffffffff96508640, float:-1.6844468E-25)
            r8.startReplaceGroup(r4)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r4 = r0.$viewmodel
            boolean r4 = r8.changedInstance(r4)
            r5 = r27
            boolean r6 = r8.changed((java.lang.Object) r5)
            r4 = r4 | r6
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = r0.$viewmodel
            java.lang.Object r7 = r8.rememberedValue()
            if (r4 != 0) goto L_0x0600
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x0608
        L_0x0600:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda30 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda30
            r7.<init>(r6, r5)
            r8.updateRememberedValue(r7)
        L_0x0608:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8.endReplaceGroup()
            r27 = r5
            r5 = r7
            r7 = 0
            r8 = 12
            r4 = r1
            r1 = r3
            r3 = 0
            r6 = r4
            r4 = 0
            r42 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = invoke$lambda$23(r28)
            if (r2 == 0) goto L_0x0639
            boolean r2 = r2.getFallingDown()
            if (r2 != r9) goto L_0x0639
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r2
            goto L_0x063a
        L_0x0639:
            r3 = r13
        L_0x063a:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r4 = -1773093248(0xffffffff9650be80, float:-1.6862217E-25)
            r8.startReplaceGroup(r4)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r4 = r0.$viewmodel
            boolean r4 = r8.changedInstance(r4)
            r5 = r28
            boolean r6 = r8.changed((java.lang.Object) r5)
            r4 = r4 | r6
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = r0.$viewmodel
            java.lang.Object r7 = r8.rememberedValue()
            if (r4 != 0) goto L_0x0669
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x0671
        L_0x0669:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda31 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda31
            r7.<init>(r6, r5)
            r8.updateRememberedValue(r7)
        L_0x0671:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8.endReplaceGroup()
            r28 = r5
            r5 = r7
            r7 = 0
            r8 = 12
            r4 = r1
            r1 = r3
            r3 = 0
            r6 = r4
            r4 = 0
            r43 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773089798(0xffffffff9650cbfa, float:-1.686647E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x06aa
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x06b6
        L_0x06aa:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda32 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda32
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x06b6:
            r44 = r4
            androidx.compose.runtime.State r44 = (androidx.compose.runtime.State) r44
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773086278(0xffffffff9650d9ba, float:-1.6870809E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x06dd
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x06e9
        L_0x06dd:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda33 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda33
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x06e9:
            r45 = r4
            androidx.compose.runtime.State r45 = (androidx.compose.runtime.State) r45
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773082758(0xffffffff9650e77a, float:-1.6875147E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x0710
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x071c
        L_0x0710:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda34 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda34
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x071c:
            r46 = r4
            androidx.compose.runtime.State r46 = (androidx.compose.runtime.State) r46
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773079238(0xffffffff9650f53a, float:-1.6879486E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x0743
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x074f
        L_0x0743:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda35 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda35
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x074f:
            r47 = r4
            androidx.compose.runtime.State r47 = (androidx.compose.runtime.State) r47
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773075718(0xffffffff965102fa, float:-1.6883825E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x0776
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x0782
        L_0x0776:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda1 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda1
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x0782:
            r48 = r4
            androidx.compose.runtime.State r48 = (androidx.compose.runtime.State) r48
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773072198(0xffffffff965110ba, float:-1.6888164E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x07a9
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x07b5
        L_0x07a9:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda3 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda3
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x07b5:
            r49 = r4
            androidx.compose.runtime.State r49 = (androidx.compose.runtime.State) r49
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.SeqState r2 = r0.$currentState
            java.util.List r2 = r2.getMultis()
            r3 = -1773068678(0xffffffff96511e7a, float:-1.6892502E-25)
            r8.startReplaceGroup(r3)
            boolean r2 = r8.changed((java.lang.Object) r2)
            com.plinkofortune.cash.winspin.seq.SeqState r3 = r0.$currentState
            java.lang.Object r4 = r8.rememberedValue()
            if (r2 != 0) goto L_0x07dc
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x07e8
        L_0x07dc:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda4 r2 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda4
            r2.<init>(r3)
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r8.updateRememberedValue(r4)
        L_0x07e8:
            r50 = r4
            androidx.compose.runtime.State r50 = (androidx.compose.runtime.State) r50
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$68(r44)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x0806
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x0807
        L_0x0806:
            r3 = r13
        L_0x0807:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            r2 = r5
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r4 = r1
            r1 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r51 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$71(r45)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x083b
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x083c
        L_0x083b:
            r3 = r13
        L_0x083c:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            r2 = r5
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r4 = r1
            r1 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r52 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$74(r46)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x0870
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x0871
        L_0x0870:
            r3 = r13
        L_0x0871:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            r2 = r5
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r4 = r1
            r1 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r53 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$77(r47)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x08a5
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x08a6
        L_0x08a5:
            r3 = r13
        L_0x08a6:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            r2 = r5
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r4 = r1
            r1 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r54 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$80(r48)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x08da
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x08db
        L_0x08da:
            r3 = r13
        L_0x08db:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            r2 = r5
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r4 = r1
            r1 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r55 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$83(r49)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x090f
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x0910
        L_0x090f:
            r3 = r13
        L_0x0910:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            r2 = r5
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r4 = r1
            r1 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r56 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            com.plinkofortune.cash.winspin.seq.models.Multi r2 = invoke$lambda$86(r50)
            boolean r2 = r2.getFallingDown()
            if (r2 == 0) goto L_0x0944
            androidx.compose.ui.unit.Density r2 = r0.$density
            float r3 = r0.$screenHeightDp
            float r2 = r2.m7091toPx0680j_4(r3)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r2
            goto L_0x0945
        L_0x0944:
            r3 = r13
        L_0x0945:
            r2 = 6
            r4 = 1000(0x3e8, float:1.401E-42)
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r10, r11, r2, r11)
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r7 = 48
            r8 = 28
            r5 = r1
            r1 = r3
            r3 = 0
            r6 = r2
            r2 = r4
            r4 = 0
            r17 = r5
            r5 = 0
            r57 = r17
            r17 = r6
            r6 = r89
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r8 = r6
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r13, r9, r11)
            float r3 = r0.$screenHeightDp
            float r4 = r0.$screenWidthDp
            com.plinkofortune.cash.winspin.seq.SeqState r5 = r0.$currentState
            r6 = 40
            byte[] r7 = new byte[r6]
            r7 = {116, -71, 50, 63, -47, 18, 116, -48, 31, -56, 54, 76, -110, 89, 116, -73, 5, -70, 41, 78, -122, 94, 17, -79, 4, -54, 32, 63, -47, 18, 115, -21, 67, -39, 40, 10, -115, 24, 59, -17} // fill-array
            r13 = 8
            byte[] r9 = new byte[r13]
            r9 = {55, -6, 26, 125, -66, 106, 93, -128} // fill-array
            java.lang.String r7 = com.plinkofortune.cash.winspin.StringFog.decrypt(r7, r9)
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r9, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r7, r10)
            r9 = 56
            byte[] r6 = new byte[r9]
            r6 = {81, 20, -5, 118, -29, -93, 25, 26, 102, 126, -125, 18, -93, -21, 90, 93, 59, 96, -22, 122, -79, -24, 70, 87, 94, 101, -32, 22, -70, -24, 54, 92, 33, 98, -22, 118, -74, -21, 71, 85, 94, 54, -86, 85, -9, -82, 88, 4, 102, 116, -21, 10, -17, -88, 16, 7} // fill-array
            byte[] r9 = new byte[r13]
            r9 = {18, 87, -45, 58, -126, -38, 118, 111} // fill-array
            java.lang.String r6 = com.plinkofortune.cash.winspin.StringFog.decrypt(r6, r9)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r9, r6)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r10)
            androidx.compose.runtime.CompositionLocalMap r9 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r20 = r14
            r14 = 62
            byte[] r10 = new byte[r14]
            r10 = {9, -128, -29, 77, 47, -79, -9, -118, 40, -81, -82, 92, 37, -87, -12, -124, 57, -90, -123, 112, 46, -95, -83, -69, 98, -14, -25, 45, 99, -9, -77, -35, 10, -14, -1, 47, 124, -10, -56, -46, 112, -128, -92, 114, 58, -85, -9, -118, 40, -81, -82, 108, 100, -81, -16, -56, 115, -86, -84, 117, 45, -76} // fill-array
            r14 = 8
            byte[] r11 = new byte[r14]
            r11 = {74, -61, -53, 31, 74, -60, -124, -21} // fill-array
            java.lang.String r10 = com.plinkofortune.cash.winspin.StringFog.decrypt(r10, r11)
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r11, r10)
            androidx.compose.runtime.Applier r10 = r8.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x09e3
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x09e3:
            r8.startReusableNode()
            boolean r10 = r8.getInserting()
            if (r10 == 0) goto L_0x09f0
            r8.createNode(r13)
            goto L_0x09f3
        L_0x09f0:
            r8.useNode()
        L_0x09f3:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r7, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            boolean r9 = r10.getInserting()
            if (r9 != 0) goto L_0x0a23
            java.lang.Object r9 = r10.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 != 0) goto L_0x0a31
        L_0x0a23:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r10.updateRememberedValue(r9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r10.apply(r6, r7)
        L_0x0a31:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r2, r6)
            r2 = 24
            byte[] r6 = new byte[r2]
            r6 = {-20, 109, 28, -7, -29, -76, -8, -17, -29, 99, 21, -5, -65, -8, -28, -67, -37, 121, 29, -50, -29, -14, -84, -71} // fill-array
            r13 = 8
            byte[] r7 = new byte[r13]
            r7 = {-81, 90, 47, -71, -48, -128, -54, -42} // fill-array
            java.lang.String r6 = com.plinkofortune.cash.winspin.StringFog.decrypt(r6, r7)
            r7 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r6 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r6 = (androidx.compose.foundation.layout.BoxScope) r6
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getCenter()
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r9 = 1039516303(0x3df5c28f, float:0.12)
            float r9 = r9 * r3
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r9)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r7, r9)
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r11 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.AspectRatioKt.aspectRatio$default(r7, r9, r11, r12, r10)
            r9 = 1028443341(0x3d4ccccd, float:0.05)
            float r58 = r4 * r9
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r58)
            r13 = 1017370378(0x3ca3d70a, float:0.02)
            float r13 = r13 * r3
            float r13 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            androidx.compose.ui.Modifier r59 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r7, r9, r13)
            int r7 = com.plinkofortune.cash.winspin.R.drawable.level_bg
            androidx.compose.ui.graphics.painter.Painter r60 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r7, r8, r11)
            androidx.compose.ui.layout.ContentScale$Companion r7 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r63 = r7.getFillBounds()
            r66 = 54
            r67 = 0
            r61 = 0
            r62 = 0
            r64 = 0
            r65 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r59, r60, r61, r62, r63, r64, r65, r66, r67)
            r9 = 40
            byte[] r11 = new byte[r9]
            r11 = {74, 3, -80, -16, -8, 70, 109, 15, 33, 114, -76, -125, -69, 13, 109, 104, 59, 0, -85, -127, -81, 10, 8, 110, 58, 112, -94, -16, -8, 70, 106, 52, 125, 99, -86, -59, -92, 76, 34, 48} // fill-array
            r13 = 8
            byte[] r14 = new byte[r13]
            r14 = {9, 64, -104, -78, -105, 62, 68, 95} // fill-array
            java.lang.String r11 = com.plinkofortune.cash.winspin.StringFog.decrypt(r11, r14)
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r14, r11)
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r6, r11)
            r14 = 56
            byte[] r9 = new byte[r14]
            r9 = {-37, 6, -44, -3, 72, 34, -75, 124, -20, 108, -84, -103, 8, 106, -10, 59, -79, 114, -59, -15, 26, 105, -22, 49, -44, 119, -49, -99, 17, 105, -102, 58, -85, 112, -59, -3, 29, 106, -21, 51, -44, 36, -123, -34, 92, 47, -12, 98, -20, 102, -60, -127, 68, 41, -68, 97} // fill-array
            byte[] r10 = new byte[r13]
            r10 = {-104, 69, -4, -79, 41, 91, -38, 9} // fill-array
            java.lang.String r9 = com.plinkofortune.cash.winspin.StringFog.decrypt(r9, r10)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r10, r9)
            int r9 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r11)
            androidx.compose.runtime.CompositionLocalMap r10 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            r13 = 62
            byte[] r12 = new byte[r13]
            r12 = {80, -78, -20, -79, 47, -6, -121, 83, 113, -99, -95, -96, 37, -30, -124, 93, 96, -108, -118, -116, 46, -22, -35, 98, 59, -64, -24, -47, 99, -68, -61, 4, 83, -64, -16, -45, 124, -67, -72, 11, 41, -78, -85, -114, 58, -32, -121, 83, 113, -99, -95, -112, 100, -28, -128, 17, 42, -104, -93, -119, 45, -1} // fill-array
            r13 = 8
            byte[] r14 = new byte[r13]
            r14 = {19, -15, -60, -29, 74, -113, -12, 50} // fill-array
            java.lang.String r12 = com.plinkofortune.cash.winspin.StringFog.decrypt(r12, r14)
            r13 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r12)
            androidx.compose.runtime.Applier r12 = r8.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0b0d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0b0d:
            r8.startReusableNode()
            boolean r12 = r8.getInserting()
            if (r12 == 0) goto L_0x0b1a
            r8.createNode(r11)
            goto L_0x0b1d
        L_0x0b1a:
            r8.useNode()
        L_0x0b1d:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r11, r6, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r11, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r10 = r11.getInserting()
            if (r10 != 0) goto L_0x0b4d
            java.lang.Object r10 = r11.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 != 0) goto L_0x0b5b
        L_0x0b4d:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r11.updateRememberedValue(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r11.apply(r9, r6)
        L_0x0b5b:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r11, r7, r6)
            byte[] r6 = new byte[r2]
            r6 = {21, -126, -2, 123, 114, 43, 38, 24, 26, -116, -9, 121, 46, 103, 58, 74, 34, -106, -1, 76, 114, 109, 114, 78} // fill-array
            r13 = 8
            byte[] r7 = new byte[r13]
            r7 = {86, -75, -51, 59, 65, 31, 20, 33} // fill-array
            java.lang.String r6 = com.plinkofortune.cash.winspin.StringFog.decrypt(r6, r7)
            r7 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r6 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r6 = (androidx.compose.foundation.layout.BoxScope) r6
            int r6 = r5.getRound()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r9 = 1
            androidx.compose.ui.text.font.Font[] r7 = new androidx.compose.ui.text.font.Font[r9]
            int r59 = com.plinkofortune.cash.winspin.R.font.playtone
            r63 = 14
            r64 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            androidx.compose.ui.text.font.Font r10 = androidx.compose.ui.text.font.FontKt.m6661FontYpTlLL0$default(r59, r60, r61, r62, r63, r64)
            r21 = 0
            r7[r21] = r10
            androidx.compose.ui.text.font.FontFamily r7 = androidx.compose.ui.text.font.FontFamilyKt.FontFamily((androidx.compose.ui.text.font.Font[]) r7)
            r10 = 32
            long r10 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r10)
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            long r59 = r12.m4276getWhite0d7_KjU()
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r14 = 5
            float r14 = (float) r14
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r14)
            float r14 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r14)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r12, r2, r14)
            r14 = 56
            r24 = 0
            r25 = 130992(0x1ffb0, float:1.83559E-40)
            r12 = r9
            r9 = r7
            r7 = 0
            r8 = 0
            r61 = r1
            r16 = r5
            r1 = r6
            r5 = r10
            r10 = 0
            r62 = r12
            r12 = 0
            r63 = r13
            r13 = 0
            r65 = r14
            r64 = r15
            r14 = 0
            r66 = r16
            r16 = 0
            r67 = r17
            r17 = 0
            r68 = 0
            r18 = 0
            r69 = r19
            r19 = 0
            r70 = r20
            r20 = 0
            r71 = r21
            r21 = 0
            r72 = 0
            r23 = 3504(0xdb0, float:4.91E-42)
            r22 = r89
            r0 = r71
            r84 = r59
            r59 = r3
            r60 = r4
            r3 = r84
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r1, (androidx.compose.ui.Modifier) r2, (long) r3, (long) r5, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontWeight) r8, (androidx.compose.ui.text.font.FontFamily) r9, (long) r10, (androidx.compose.ui.text.style.TextDecoration) r12, (androidx.compose.ui.text.style.TextAlign) r13, (long) r14, (int) r16, (boolean) r17, (int) r18, (int) r19, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r20, (androidx.compose.ui.text.TextStyle) r21, (androidx.compose.runtime.Composer) r22, (int) r23, (int) r24, (int) r25)
            r8 = r22
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            int r1 = r66.getStars()
            r2 = 3
            if (r1 < r2) goto L_0x0c24
            int r1 = com.plinkofortune.cash.winspin.R.drawable.star_filled
            goto L_0x0c26
        L_0x0c24:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.star_empty
        L_0x0c26:
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r0)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1028443341(0x3d4ccccd, float:0.05)
            float r63 = r59 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 2
            r11 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.AspectRatioKt.aspectRatio$default(r2, r3, r0, r4, r11)
            r3 = 1060320051(0x3f333333, float:0.7)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            int r1 = r66.getStars()
            r4 = 2
            if (r1 < r4) goto L_0x0c6f
            int r1 = com.plinkofortune.cash.winspin.R.drawable.star_filled
            goto L_0x0c71
        L_0x0c6f:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.star_empty
        L_0x0c71:
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r0)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1032805417(0x3d8f5c29, float:0.07)
            float r65 = r59 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.AspectRatioKt.aspectRatio$default(r2, r3, r0, r4, r11)
            r3 = 1061494456(0x3f451eb8, float:0.77)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            r4 = 1008981770(0x3c23d70a, float:0.01)
            float r4 = r4 * r59
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            int r1 = r66.getStars()
            r12 = 1
            if (r1 < r12) goto L_0x0cbe
            int r1 = com.plinkofortune.cash.winspin.R.drawable.star_filled
            goto L_0x0cc0
        L_0x0cbe:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.star_empty
        L_0x0cc0:
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r0)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.AspectRatioKt.aspectRatio$default(r2, r3, r0, r4, r11)
            r3 = 1063339950(0x3f6147ae, float:0.88)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1053609165(0x3ecccccd, float:0.4)
            float r67 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r67)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            r3 = 1034147594(0x3da3d70a, float:0.08)
            float r68 = r59 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r68)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1057803469(0x3f0ccccd, float:0.55)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            r4 = 1043207291(0x3e2e147b, float:0.17)
            float r71 = r59 * r4
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r71)
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            androidx.compose.ui.graphics.Brush$Companion r14 = androidx.compose.ui.graphics.Brush.Companion
            r2 = 3
            androidx.compose.ui.graphics.Color[] r2 = new androidx.compose.ui.graphics.Color[r2]
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_1
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r0)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r2[r0] = r3
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_2
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r0)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r2[r12] = r3
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_3
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r0)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r62 = 2
            r2[r62] = r3
            java.util.List r15 = kotlin.collections.CollectionsKt.listOf(r2)
            r19 = 14
            r20 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.ui.graphics.Brush r14 = androidx.compose.ui.graphics.Brush.Companion.m4186verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r14, (java.util.List) r15, (float) r16, (float) r17, (int) r18, (int) r19, (java.lang.Object) r20)
            r2 = 16
            float r2 = (float) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            androidx.compose.foundation.shape.RoundedCornerShape r3 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r3)
            r15 = r3
            androidx.compose.ui.graphics.Shape r15 = (androidx.compose.ui.graphics.Shape) r15
            r17 = 4
            r18 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.background$default(r13, r14, r15, r16, r17, r18)
            r4 = 3
            float r4 = (float) r4
            float r5 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            int r6 = com.plinkofortune.cash.winspin.R.color.seq_border
            long r6 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r6, r8, r0)
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            androidx.compose.foundation.shape.RoundedCornerShape r9 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r9)
            androidx.compose.ui.graphics.Shape r9 = (androidx.compose.ui.graphics.Shape) r9
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BorderKt.m259borderxT4_qwU(r3, r5, r6, r9)
            r9 = 40
            byte[] r5 = new byte[r9]
            r5 = {-82, -18, -57, -101, -77, -120, 127, 63, -59, -97, -61, -24, -16, -61, 127, 88, -33, -19, -36, -22, -28, -60, 26, 94, -34, -99, -43, -101, -77, -120, 120, 4, -103, -114, -35, -82, -17, -126, 48, 0} // fill-array
            r6 = 8
            byte[] r7 = new byte[r6]
            r7 = {-19, -83, -17, -39, -36, -16, 86, 111} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r5, r7)
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r5)
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r0)
            r14 = 56
            byte[] r5 = new byte[r14]
            r5 = {79, 127, 94, -46, -78, 96, -118, 60, 120, 21, 38, -74, -14, 40, -55, 123, 37, 11, 79, -34, -32, 43, -43, 113, 64, 14, 69, -78, -21, 43, -91, 122, 63, 9, 79, -46, -25, 40, -44, 115, 64, 93, 15, -15, -90, 109, -53, 34, 120, 31, 78, -82, -66, 107, -125, 33} // fill-array
            byte[] r7 = new byte[r6]
            r7 = {12, 60, 118, -98, -45, 25, -27, 73} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r5, r7)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r5)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r0)
            androidx.compose.runtime.CompositionLocalMap r7 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            r10 = 62
            byte[] r13 = new byte[r10]
            r13 = {-93, -120, -32, 105, -37, -34, -63, 126, -126, -89, -83, 120, -47, -58, -62, 112, -109, -82, -122, 84, -38, -50, -101, 79, -56, -6, -28, 9, -105, -104, -123, 41, -96, -6, -4, 11, -120, -103, -2, 38, -38, -120, -89, 86, -50, -60, -63, 126, -126, -89, -83, 72, -112, -64, -58, 60, -39, -94, -81, 81, -39, -37} // fill-array
            byte[] r14 = new byte[r6]
            r14 = {-32, -53, -56, 59, -66, -85, -78, 31} // fill-array
            java.lang.String r13 = com.plinkofortune.cash.winspin.StringFog.decrypt(r13, r14)
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r14, r13)
            androidx.compose.runtime.Applier r13 = r8.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0e05
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0e05:
            r8.startReusableNode()
            boolean r13 = r8.getInserting()
            if (r13 == 0) goto L_0x0e12
            r8.createNode(r9)
            goto L_0x0e15
        L_0x0e12:
            r8.useNode()
        L_0x0e15:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r1, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r7, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r7 = r9.getInserting()
            if (r7 != 0) goto L_0x0e45
            java.lang.Object r7 = r9.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r7 != 0) goto L_0x0e53
        L_0x0e45:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r9.updateRememberedValue(r7)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r9.apply(r5, r1)
        L_0x0e53:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r3, r1)
            r1 = 24
            byte[] r3 = new byte[r1]
            r3 = {-72, 97, 19, 6, -39, -53, 58, -6, -73, 111, 26, 4, -123, -121, 38, -88, -113, 117, 18, 49, -39, -115, 110, -84} // fill-array
            byte[] r1 = new byte[r6]
            r1 = {-5, 86, 32, 70, -22, -1, 8, -61} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r1)
            r3 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            int r1 = r66.getRound()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Round: "
            r3.<init>(r5)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            androidx.compose.ui.text.font.Font[] r3 = new androidx.compose.ui.text.font.Font[r12]
            int r13 = com.plinkofortune.cash.winspin.R.font.playtone
            r17 = 14
            r18 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            androidx.compose.ui.text.font.Font r5 = androidx.compose.ui.text.font.FontKt.m6661FontYpTlLL0$default(r13, r14, r15, r16, r17, r18)
            r3[r0] = r5
            androidx.compose.ui.text.font.FontFamily r9 = androidx.compose.ui.text.font.FontFamilyKt.FontFamily((androidx.compose.ui.text.font.Font[]) r3)
            r16 = r6
            r3 = 24
            long r5 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r3)
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r3.m4276getWhite0d7_KjU()
            r24 = 0
            r25 = 130994(0x1ffb2, float:1.83562E-40)
            r3 = r2
            r2 = 0
            r7 = 0
            r8 = 0
            r22 = r10
            r23 = r11
            r10 = 0
            r73 = r12
            r12 = 0
            r15 = r4
            r84 = r13
            r14 = r3
            r3 = r84
            r13 = 0
            r17 = r14
            r18 = r15
            r14 = 0
            r76 = r16
            r16 = 0
            r19 = r17
            r17 = 0
            r20 = r18
            r18 = 0
            r21 = r19
            r19 = 0
            r72 = r20
            r20 = 0
            r74 = r21
            r21 = 0
            r75 = r23
            r23 = 3456(0xd80, float:4.843E-42)
            r22 = r89
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r1, (androidx.compose.ui.Modifier) r2, (long) r3, (long) r5, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontWeight) r8, (androidx.compose.ui.text.font.FontFamily) r9, (long) r10, (androidx.compose.ui.text.style.TextDecoration) r12, (androidx.compose.ui.text.style.TextAlign) r13, (long) r14, (int) r16, (boolean) r17, (int) r18, (int) r19, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r20, (androidx.compose.ui.text.TextStyle) r21, (androidx.compose.runtime.Composer) r22, (int) r23, (int) r24, (int) r25)
            r8 = r22
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r67)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r68)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r58)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r71)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            androidx.compose.ui.graphics.Brush$Companion r10 = androidx.compose.ui.graphics.Brush.Companion
            r2 = 3
            androidx.compose.ui.graphics.Color[] r2 = new androidx.compose.ui.graphics.Color[r2]
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_1
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r0)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r2[r0] = r3
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_2
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r0)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r4 = 1
            r2[r4] = r3
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_3
            long r5 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r0)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r5)
            r62 = 2
            r2[r62] = r3
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r2)
            r15 = 14
            r16 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            androidx.compose.ui.graphics.Brush r10 = androidx.compose.ui.graphics.Brush.Companion.m4186verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r10, (java.util.List) r11, (float) r12, (float) r13, (int) r14, (int) r15, (java.lang.Object) r16)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r74)
            androidx.compose.foundation.shape.RoundedCornerShape r2 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r2)
            r11 = r2
            androidx.compose.ui.graphics.Shape r11 = (androidx.compose.ui.graphics.Shape) r11
            r13 = 4
            r14 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.background$default(r9, r10, r11, r12, r13, r14)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r72)
            int r5 = com.plinkofortune.cash.winspin.R.color.seq_border
            long r5 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r5, r8, r0)
            float r7 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r74)
            androidx.compose.foundation.shape.RoundedCornerShape r7 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r7)
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BorderKt.m259borderxT4_qwU(r2, r3, r5, r7)
            r9 = 40
            byte[] r3 = new byte[r9]
            r3 = {75, -1, 29, -123, 88, -12, 89, -93, 32, -114, 25, -10, 27, -65, 89, -60, 58, -4, 6, -12, 15, -72, 60, -62, 59, -116, 15, -123, 88, -12, 94, -104, 124, -97, 7, -80, 4, -2, 22, -100} // fill-array
            r5 = 8
            byte[] r6 = new byte[r5]
            r6 = {8, -68, 53, -57, 55, -116, 112, -13} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r6)
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r3)
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r0)
            r14 = 56
            byte[] r3 = new byte[r14]
            r3 = {15, -124, 35, 110, 25, 15, 123, -44, 56, -18, 91, 10, 89, 71, 56, -109, 101, -16, 50, 98, 75, 68, 36, -103, 0, -11, 56, 14, 64, 68, 84, -110, 127, -14, 50, 110, 76, 71, 37, -101, 0, -90, 114, 77, 13, 2, 58, -54, 56, -28, 51, 18, 21, 4, 114, -55} // fill-array
            byte[] r6 = new byte[r5]
            r6 = {76, -57, 11, 34, 120, 118, 20, -95} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r6)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r3)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r0)
            androidx.compose.runtime.CompositionLocalMap r6 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r9 = 62
            byte[] r10 = new byte[r9]
            r10 = {40, 107, 82, -91, 55, 52, -112, 83, 9, 68, 31, -76, 61, 44, -109, 93, 24, 77, 52, -104, 54, 36, -54, 98, 67, 25, 86, -59, 123, 114, -44, 4, 43, 25, 78, -57, 100, 115, -81, 11, 81, 107, 21, -102, 34, 46, -112, 83, 9, 68, 31, -124, 124, 42, -105, 17, 82, 65, 29, -99, 53, 49} // fill-array
            byte[] r11 = new byte[r5]
            r11 = {107, 40, 122, -9, 82, 65, -29, 50} // fill-array
            java.lang.String r10 = com.plinkofortune.cash.winspin.StringFog.decrypt(r10, r11)
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r11, r10)
            androidx.compose.runtime.Applier r10 = r8.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0fed
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0fed:
            r8.startReusableNode()
            boolean r10 = r8.getInserting()
            if (r10 == 0) goto L_0x0ffa
            r8.createNode(r7)
            goto L_0x0ffd
        L_0x0ffa:
            r8.useNode()
        L_0x0ffd:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r1, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r6, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r6 = r7.getInserting()
            if (r6 != 0) goto L_0x102d
            java.lang.Object r6 = r7.rememberedValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r10)
            if (r6 != 0) goto L_0x103b
        L_0x102d:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            r7.updateRememberedValue(r6)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.apply(r3, r1)
        L_0x103b:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r2, r1)
            r1 = 24
            byte[] r2 = new byte[r1]
            r2 = {60, 81, -29, 106, -71, -16, 7, -110, 51, 95, -22, 104, -27, -68, 27, -64, 11, 69, -30, 93, -71, -74, 83, -60} // fill-array
            byte[] r1 = new byte[r5]
            r1 = {127, 102, -48, 42, -118, -60, 53, -85} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r1)
            r2 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            int r1 = r66.getTime()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Time: "
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            androidx.compose.ui.text.font.Font[] r2 = new androidx.compose.ui.text.font.Font[r4]
            int r10 = com.plinkofortune.cash.winspin.R.font.playtone
            r14 = 14
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            androidx.compose.ui.text.font.Font r3 = androidx.compose.ui.text.font.FontKt.m6661FontYpTlLL0$default(r10, r11, r12, r13, r14, r15)
            r2[r0] = r3
            androidx.compose.ui.text.font.FontFamily r2 = androidx.compose.ui.text.font.FontFamilyKt.FontFamily((androidx.compose.ui.text.font.Font[]) r2)
            r16 = r5
            r3 = 24
            long r5 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r3)
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r10 = r3.m4276getWhite0d7_KjU()
            r24 = 0
            r25 = 130994(0x1ffb2, float:1.83562E-40)
            r22 = r9
            r9 = r2
            r2 = 0
            r7 = 0
            r8 = 0
            r73 = r4
            r3 = r10
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r76 = r16
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 3456(0xd80, float:4.843E-42)
            r22 = r89
            r0 = r73
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r1, (androidx.compose.ui.Modifier) r2, (long) r3, (long) r5, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontWeight) r8, (androidx.compose.ui.text.font.FontFamily) r9, (long) r10, (androidx.compose.ui.text.style.TextDecoration) r12, (androidx.compose.ui.text.style.TextAlign) r13, (long) r14, (int) r16, (boolean) r17, (int) r18, (int) r19, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r20, (androidx.compose.ui.text.TextStyle) r21, (androidx.compose.runtime.Composer) r22, (int) r23, (int) r24, (int) r25)
            r8 = r22
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r2 = 4
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r3 = r3.getCenterHorizontally()
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = r1.m624spacedByD5KLDUw((float) r2, (androidx.compose.ui.Alignment.Horizontal) r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r11 = 0
            r13 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r13, r0, r11)
            r3 = 1048911544(0x3e851eb8, float:0.26)
            float r3 = r3 * r59
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.m734offsetVpY3zN4$default(r2, r13, r3, r0, r11)
            r3 = 52
            byte[] r3 = new byte[r3]
            r3 = {73, -99, 115, -85, 75, -89, 71, -20, 34, -20, 119, -56, 8, -29, 71, -123, 51, -98, 110, -55, 21, -24, 34, -119, 50, -14, 106, -55, 20, -112, 91, -116, 50, -17, 23, -56, 23, -32, 84, -18, 101, -87, 117, -110, 80, -13, 92, -53, 57, -84, 61, -106} // fill-array
            r14 = 8
            byte[] r4 = new byte[r14]
            r4 = {10, -34, 91, -7, 36, -48, 110, -68} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r4)
            r4 = 693286680(0x2952b718, float:4.6788176E-14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getTop()
            r12 = 6
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r3, r8, r12)
            r3 = 56
            byte[] r4 = new byte[r3]
            r4 = {-91, 96, -27, 23, 74, -58, -81, -47, -110, 10, -99, 115, 10, -114, -20, -106, -49, 20, -12, 27, 24, -115, -16, -100, -86, 17, -2, 119, 19, -115, -128, -105, -43, 22, -12, 23, 31, -114, -15, -98, -86, 66, -76, 52, 94, -53, -18, -49, -110, 0, -11, 107, 70, -51, -90, -52} // fill-array
            byte[] r3 = new byte[r14]
            r3 = {-26, 35, -51, 91, 43, -65, -64, -92} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            r3 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r15 = 62
            byte[] r6 = new byte[r15]
            r6 = {100, 45, -94, -82, 113, 97, 119, 111, 69, 2, -17, -65, 123, 121, 116, 97, 84, 11, -60, -109, 112, 113, 45, 94, 15, 95, -90, -50, 61, 39, 51, 56, 103, 95, -66, -52, 34, 38, 72, 55, 29, 45, -27, -111, 100, 123, 119, 111, 69, 2, -17, -113, 58, 127, 112, 45, 30, 7, -19, -106, 115, 100} // fill-array
            byte[] r7 = new byte[r14]
            r7 = {39, 110, -118, -4, 20, 20, 4, 14} // fill-array
            java.lang.String r6 = com.plinkofortune.cash.winspin.StringFog.decrypt(r6, r7)
            r7 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r6)
            androidx.compose.runtime.Applier r6 = r8.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x1165
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x1165:
            r8.startReusableNode()
            boolean r6 = r8.getInserting()
            if (r6 == 0) goto L_0x1172
            r8.createNode(r5)
            goto L_0x1175
        L_0x1172:
            r8.useNode()
        L_0x1175:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r5.getInserting()
            if (r3 != 0) goto L_0x11a5
            java.lang.Object r3 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 != 0) goto L_0x11b3
        L_0x11a5:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.apply(r3, r1)
        L_0x11b3:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            r1 = 25
            byte[] r1 = new byte[r1]
            r1 = {58, -32, -79, 89, 116, 56, 122, 63, 79, -99, -72, 82, 102, 98, 60, 35, 18, -91, -94, 90, 67, 62, 57, 107, 22} // fill-array
            byte[] r2 = new byte[r14]
            r2 = {121, -47, -127, 104, 52, 13, 75, 13} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r2)
            r2 = -407840262(0xffffffffe7b0d9fa, float:-1.6703149E24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r1 = -937773101(0xffffffffc81ab7d3, float:-158431.3)
            r8.startReplaceGroup(r1)
            java.util.List r1 = r66.getSeqBalls()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r16 = r1.iterator()
        L_0x11e6:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x121e
            java.lang.Object r1 = r16.next()
            com.plinkofortune.cash.winspin.seq.models.SeqBall r1 = (com.plinkofortune.cash.winspin.seq.models.SeqBall) r1
            int r1 = r1.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1022739087(0x3cf5c28f, float:0.03)
            float r3 = r3 * r59
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r2, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            goto L_0x11e6
        L_0x121e:
            r8.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            int r1 = com.plinkofortune.cash.winspin.R.drawable.triangle_bg
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1064514355(0x3f733333, float:0.95)
            float r16 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r16)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            r3 = 1055286886(0x3ee66666, float:0.45)
            float r17 = r59 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1020054733(0x3ccccccd, float:0.025)
            float r18 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r18)
            r4 = 1053609165(0x3ecccccd, float:0.4)
            float r4 = r4 * r59
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            int r1 = com.plinkofortune.cash.winspin.R.drawable.triangle_fg
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1062836634(0x3f59999a, float:0.85)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            r3 = 1051931443(0x3eb33333, float:0.35)
            float r3 = r3 * r59
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1033476506(0x3d99999a, float:0.075)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r3, r4)
            r2 = 0
            r4 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r1 = r1.getSpaceAround()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r13, r0, r11)
            r3 = 1062501089(0x3f547ae1, float:0.83)
            float r3 = r3 * r59
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.m734offsetVpY3zN4$default(r2, r13, r3, r0, r11)
            r3 = 52
            byte[] r3 = new byte[r3]
            r3 = {125, 6, -92, 93, 117, 35, -42, -80, 22, 119, -96, 62, 54, 103, -42, -39, 7, 5, -71, 63, 43, 108, -77, -43, 6, 105, -67, 63, 42, 20, -54, -48, 6, 116, -64, 62, 41, 100, -59, -78, 81, 50, -94, 100, 110, 119, -51, -105, 13, 55, -22, 96} // fill-array
            byte[] r4 = new byte[r14]
            r4 = {62, 69, -116, 15, 26, 84, -1, -32} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r4)
            r4 = 693286680(0x2952b718, float:4.6788176E-14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getTop()
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r1
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r3, r8, r12)
            r3 = 56
            byte[] r4 = new byte[r3]
            r4 = {0, 98, 40, -54, -109, -97, -115, -119, 55, 8, 80, -82, -45, -41, -50, -50, 106, 22, 57, -58, -63, -44, -46, -60, 15, 19, 51, -86, -54, -44, -94, -49, 112, 20, 57, -54, -58, -41, -45, -58, 15, 64, 121, -23, -121, -110, -52, -105, 55, 2, 56, -74, -97, -108, -124, -108} // fill-array
            byte[] r3 = new byte[r14]
            r3 = {67, 33, 0, -122, -14, -26, -30, -4} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            r3 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            byte[] r6 = new byte[r15]
            r6 = {-71, 9, -94, -12, 32, -82, -43, -126, -104, 38, -17, -27, 42, -74, -42, -116, -119, 47, -60, -55, 33, -66, -113, -77, -46, 123, -90, -108, 108, -24, -111, -43, -70, 123, -66, -106, 115, -23, -22, -38, -64, 9, -27, -53, 53, -76, -43, -126, -104, 38, -17, -43, 107, -80, -46, -64, -61, 35, -19, -52, 34, -85} // fill-array
            byte[] r7 = new byte[r14]
            r7 = {-6, 74, -118, -90, 69, -37, -90, -29} // fill-array
            java.lang.String r6 = com.plinkofortune.cash.winspin.StringFog.decrypt(r6, r7)
            r7 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r6)
            androidx.compose.runtime.Applier r6 = r8.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x1342
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x1342:
            r8.startReusableNode()
            boolean r6 = r8.getInserting()
            if (r6 == 0) goto L_0x134f
            r8.createNode(r5)
            goto L_0x1352
        L_0x134f:
            r8.useNode()
        L_0x1352:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r5.getInserting()
            if (r3 != 0) goto L_0x1382
            java.lang.Object r3 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 != 0) goto L_0x1390
        L_0x1382:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.apply(r3, r1)
        L_0x1390:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            r1 = 25
            byte[] r1 = new byte[r1]
            r1 = {4, -69, -23, -12, -122, 83, 68, -39, 113, -58, -32, -1, -108, 9, 2, -59, 44, -2, -6, -9, -79, 85, 7, -115, 40} // fill-array
            byte[] r2 = new byte[r14]
            r2 = {71, -118, -39, -59, -58, 102, 117, -21} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r2)
            r2 = -407840262(0xffffffffe7b0d9fa, float:-1.6703149E24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r1 = -937704317(0xffffffffc81bc483, float:-159506.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$68(r44)
            int r1 = r1.getScore()
            r11 = 20
            r12 = 100
            r13 = 10
            r2 = 60
            if (r1 == r13) goto L_0x13e0
            if (r1 == r11) goto L_0x13dd
            if (r1 == r2) goto L_0x13da
            if (r1 != r12) goto L_0x13d4
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x13e2
        L_0x13d4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x13da:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x13e2
        L_0x13dd:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x13e2
        L_0x13e0:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x13e2:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r3 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r3.getFillBounds()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 1041194025(0x3e0f5c29, float:0.14)
            float r17 = r60 * r4
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r3, r4)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r3, r4)
            r4 = -1041626148(0xffffffffc1ea0bdc, float:-29.25579)
            r8.startReplaceGroup(r4)
            r4 = r52
            boolean r6 = r8.changed((java.lang.Object) r4)
            java.lang.Object r7 = r8.rememberedValue()
            if (r6 != 0) goto L_0x1420
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x1428
        L_0x1420:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda5 r7 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda5
            r7.<init>(r4)
            r8.updateRememberedValue(r7)
        L_0x1428:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r3, r7)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r4 = r2
            r2 = 0
            r6 = r4
            r4 = 0
            r7 = r6
            r6 = 0
            r19 = r7
            r7 = 0
            r73 = r0
            r0 = r19
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            r1 = -937662525(0xffffffffc81c67c3, float:-160159.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$71(r45)
            int r1 = r1.getScore()
            if (r1 == r13) goto L_0x146f
            if (r1 == r11) goto L_0x146c
            if (r1 == r0) goto L_0x1469
            if (r1 != r12) goto L_0x1463
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x1471
        L_0x1463:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x1469:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x1471
        L_0x146c:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x1471
        L_0x146f:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x1471:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = -1041584356(0xffffffffc1eaaf1c, float:-29.335503)
            r8.startReplaceGroup(r3)
            r4 = r53
            boolean r3 = r8.changed((java.lang.Object) r4)
            java.lang.Object r6 = r8.rememberedValue()
            if (r3 != 0) goto L_0x14aa
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x14b2
        L_0x14aa:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda6 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda6
            r6.<init>(r4)
            r8.updateRememberedValue(r6)
        L_0x14b2:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r6)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            r1 = -937620733(0xffffffffc81d0b03, float:-160812.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$74(r46)
            int r1 = r1.getScore()
            if (r1 == r13) goto L_0x14f0
            if (r1 == r11) goto L_0x14ed
            if (r1 == r0) goto L_0x14ea
            if (r1 != r12) goto L_0x14e4
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x14f2
        L_0x14e4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x14ea:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x14f2
        L_0x14ed:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x14f2
        L_0x14f0:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x14f2:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = -1041542564(0xffffffffc1eb525c, float:-29.415215)
            r8.startReplaceGroup(r3)
            r4 = r54
            boolean r3 = r8.changed((java.lang.Object) r4)
            java.lang.Object r6 = r8.rememberedValue()
            if (r3 != 0) goto L_0x152b
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x1533
        L_0x152b:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda7 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda7
            r6.<init>(r4)
            r8.updateRememberedValue(r6)
        L_0x1533:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r6)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            r1 = -937578941(0xffffffffc81dae43, float:-161465.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$77(r47)
            int r1 = r1.getScore()
            if (r1 == r13) goto L_0x1571
            if (r1 == r11) goto L_0x156e
            if (r1 == r0) goto L_0x156b
            if (r1 != r12) goto L_0x1565
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x1573
        L_0x1565:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x156b:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x1573
        L_0x156e:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x1573
        L_0x1571:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x1573:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = -1041500772(0xffffffffc1ebf59c, float:-29.494926)
            r8.startReplaceGroup(r3)
            r4 = r55
            boolean r3 = r8.changed((java.lang.Object) r4)
            java.lang.Object r6 = r8.rememberedValue()
            if (r3 != 0) goto L_0x15ac
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x15b4
        L_0x15ac:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda8 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda8
            r6.<init>(r4)
            r8.updateRememberedValue(r6)
        L_0x15b4:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r6)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            r1 = -937537149(0xffffffffc81e5183, float:-162118.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$80(r48)
            int r1 = r1.getScore()
            if (r1 == r13) goto L_0x15f2
            if (r1 == r11) goto L_0x15ef
            if (r1 == r0) goto L_0x15ec
            if (r1 != r12) goto L_0x15e6
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x15f4
        L_0x15e6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x15ec:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x15f4
        L_0x15ef:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x15f4
        L_0x15f2:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x15f4:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = -1041458980(0xffffffffc1ec98dc, float:-29.574638)
            r8.startReplaceGroup(r3)
            r4 = r56
            boolean r3 = r8.changed((java.lang.Object) r4)
            java.lang.Object r6 = r8.rememberedValue()
            if (r3 != 0) goto L_0x162d
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x1635
        L_0x162d:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda9 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda9
            r6.<init>(r4)
            r8.updateRememberedValue(r6)
        L_0x1635:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r6)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            r1 = -937495357(0xffffffffc81ef4c3, float:-162771.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$83(r49)
            int r1 = r1.getScore()
            if (r1 == r13) goto L_0x1673
            if (r1 == r11) goto L_0x1670
            if (r1 == r0) goto L_0x166d
            if (r1 != r12) goto L_0x1667
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x1675
        L_0x1667:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x166d:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x1675
        L_0x1670:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x1675
        L_0x1673:
            int r1 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x1675:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r2.getFillBounds()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = -1041417188(0xffffffffc1ed3c1c, float:-29.65435)
            r8.startReplaceGroup(r3)
            r3 = r57
            boolean r4 = r8.changed((java.lang.Object) r3)
            java.lang.Object r6 = r8.rememberedValue()
            if (r4 != 0) goto L_0x16ae
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x16b6
        L_0x16ae:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda10 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda10
            r6.<init>(r3)
            r8.updateRememberedValue(r6)
        L_0x16b6:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r6)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            r1 = -937453565(0xffffffffc81f9803, float:-163424.05)
            r8.startReplaceGroup(r1)
            com.plinkofortune.cash.winspin.seq.models.Multi r1 = invoke$lambda$86(r50)
            int r1 = r1.getScore()
            if (r1 == r13) goto L_0x16f4
            if (r1 == r11) goto L_0x16f1
            if (r1 == r0) goto L_0x16ee
            if (r1 != r12) goto L_0x16e8
            int r0 = com.plinkofortune.cash.winspin.R.drawable.multi100
            goto L_0x16f6
        L_0x16e8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x16ee:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.multi60
            goto L_0x16f6
        L_0x16f1:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.multi20
            goto L_0x16f6
        L_0x16f4:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.multi10
        L_0x16f6:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r0, r2)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r63)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r2)
            r2 = -1041375396(0xffffffffc1eddf5c, float:-29.734062)
            r8.startReplaceGroup(r2)
            r2 = r61
            boolean r3 = r8.changed((java.lang.Object) r2)
            java.lang.Object r4 = r8.rememberedValue()
            if (r3 != 0) goto L_0x172f
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x1737
        L_0x172f:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda12 r4 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda12
            r4.<init>(r2)
            r8.updateRememberedValue(r4)
        L_0x1737:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r4)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r0 = r0.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r1 = r1.getCenter()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1048576000(0x3e800000, float:0.25)
            float r4 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r68)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r3 = 1063843267(0x3f68f5c3, float:0.91)
            float r3 = r3 * r59
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r67)
            androidx.compose.ui.Modifier r75 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r2, r4, r3)
            int r2 = com.plinkofortune.cash.winspin.R.drawable.multi_score_bg
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r76 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r2, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r2 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r79 = r2.getFillBounds()
            r82 = 54
            r83 = 0
            r77 = 0
            r78 = 0
            r80 = 0
            r81 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r75, r76, r77, r78, r79, r80, r81, r82, r83)
            r3 = 52
            byte[] r3 = new byte[r3]
            r3 = {-99, -116, 100, 59, -60, 96, -98, -6, -10, -3, 96, 88, -121, 36, -98, -109, -25, -113, 121, 89, -102, 47, -5, -97, -26, -29, 125, 89, -101, 87, -126, -102, -26, -2, 0, 88, -104, 39, -115, -8, -79, -72, 98, 2, -33, 52, -123, -35, -19, -67, 42, 6} // fill-array
            byte[] r4 = new byte[r14]
            r4 = {-34, -49, 76, 105, -85, 23, -73, -86} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r4)
            r4 = 693286680(0x2952b718, float:4.6788176E-14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r1
            r3 = 54
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r0, r8, r3)
            r3 = 56
            byte[] r1 = new byte[r3]
            r1 = {71, 81, 127, 11, 127, -64, 123, 69, 112, 59, 7, 111, 63, -120, 56, 2, 45, 37, 110, 7, 45, -117, 36, 8, 72, 32, 100, 107, 38, -117, 84, 3, 55, 39, 110, 11, 42, -120, 37, 10, 72, 115, 46, 40, 107, -51, 58, 91, 112, 49, 111, 119, 115, -53, 114, 88} // fill-array
            byte[] r3 = new byte[r14]
            r3 = {4, 18, 87, 71, 30, -71, 20, 48} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r3)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r1)
            r3 = 0
            int r1 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            byte[] r5 = new byte[r15]
            r5 = {32, 27, -90, 39, -67, -22, 43, -48, 1, 52, -21, 54, -73, -14, 40, -34, 16, 61, -64, 26, -68, -6, 113, -31, 75, 105, -94, 71, -15, -84, 111, -121, 35, 105, -70, 69, -18, -83, 20, -120, 89, 27, -31, 24, -88, -16, 43, -48, 1, 52, -21, 6, -10, -12, 44, -110, 90, 49, -23, 31, -65, -17} // fill-array
            byte[] r6 = new byte[r14]
            r6 = {99, 88, -114, 117, -40, -97, 88, -79} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r5, r6)
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r5)
            androidx.compose.runtime.Applier r5 = r8.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x1817
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x1817:
            r8.startReusableNode()
            boolean r5 = r8.getInserting()
            if (r5 == 0) goto L_0x1824
            r8.createNode(r4)
            goto L_0x1827
        L_0x1824:
            r8.useNode()
        L_0x1827:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r3, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r3 = r4.getInserting()
            if (r3 != 0) goto L_0x1857
            java.lang.Object r3 = r4.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x1865
        L_0x1857:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r4.updateRememberedValue(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.apply(r1, r0)
        L_0x1865:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r2, r0)
            r0 = 25
            byte[] r0 = new byte[r0]
            r0 = {-90, 9, 70, 121, -115, -23, 68, 63, -45, 116, 79, 114, -97, -77, 2, 35, -114, 76, 85, 122, -70, -17, 7, 107, -118} // fill-array
            byte[] r1 = new byte[r14]
            r1 = {-27, 56, 118, 72, -51, -36, 117, 13} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r1 = -407840262(0xffffffffe7b0d9fa, float:-1.6703149E24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r0)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            int r0 = invoke$lambda$2(r26)
            int r0 = r0 / r12
            int r1 = invoke$lambda$2(r26)
            int r2 = r0 * 100
            int r1 = r1 - r2
            int r11 = r1 / 10
            int r1 = invoke$lambda$2(r26)
            int r1 = r1 - r2
            int r2 = r11 * 10
            int r12 = r1 - r2
            int r1 = com.plinkofortune.cash.winspin.R.drawable.golden_x
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r8, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1027101164(0x3d3851ec, float:0.045)
            float r13 = r60 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r2, r3)
            r3 = 1031127695(0x3d75c28f, float:0.06)
            float r17 = r59 * r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r2, r3)
            r9 = 48
            r10 = 120(0x78, float:1.68E-43)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            r1 = -937365847(0xffffffffc820eea9, float:-164794.64)
            r8.startReplaceGroup(r1)
            if (r0 == 0) goto L_0x1920
            switch(r0) {
                case 1: goto L_0x18f9;
                case 2: goto L_0x18f6;
                case 3: goto L_0x18f3;
                case 4: goto L_0x18f0;
                case 5: goto L_0x18ed;
                case 6: goto L_0x18ea;
                case 7: goto L_0x18e7;
                case 8: goto L_0x18e4;
                case 9: goto L_0x18e1;
                default: goto L_0x18db;
            }
        L_0x18db:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x18e1:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_9
            goto L_0x18fb
        L_0x18e4:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_8
            goto L_0x18fb
        L_0x18e7:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_7
            goto L_0x18fb
        L_0x18ea:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_6
            goto L_0x18fb
        L_0x18ed:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_5
            goto L_0x18fb
        L_0x18f0:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_4
            goto L_0x18fb
        L_0x18f3:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_3
            goto L_0x18fb
        L_0x18f6:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_2
            goto L_0x18fb
        L_0x18f9:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_1
        L_0x18fb:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r0, r2)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r2)
            r9 = 48
            r10 = 120(0x78, float:1.68E-43)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
        L_0x1920:
            r8.endReplaceGroup()
            r0 = -937327159(0xffffffffc82185c9, float:-165399.14)
            r8.startReplaceGroup(r0)
            if (r11 == 0) goto L_0x1973
            switch(r11) {
                case 1: goto L_0x194c;
                case 2: goto L_0x1949;
                case 3: goto L_0x1946;
                case 4: goto L_0x1943;
                case 5: goto L_0x1940;
                case 6: goto L_0x193d;
                case 7: goto L_0x193a;
                case 8: goto L_0x1937;
                case 9: goto L_0x1934;
                default: goto L_0x192e;
            }
        L_0x192e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x1934:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_9
            goto L_0x194e
        L_0x1937:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_8
            goto L_0x194e
        L_0x193a:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_7
            goto L_0x194e
        L_0x193d:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_6
            goto L_0x194e
        L_0x1940:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_5
            goto L_0x194e
        L_0x1943:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_4
            goto L_0x194e
        L_0x1946:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_3
            goto L_0x194e
        L_0x1949:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_2
            goto L_0x194e
        L_0x194c:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_1
        L_0x194e:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r0, r2)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r2)
            r9 = 48
            r10 = 120(0x78, float:1.68E-43)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
        L_0x1973:
            r8.endReplaceGroup()
            switch(r12) {
                case 0: goto L_0x199a;
                case 1: goto L_0x1997;
                case 2: goto L_0x1994;
                case 3: goto L_0x1991;
                case 4: goto L_0x198e;
                case 5: goto L_0x198b;
                case 6: goto L_0x1988;
                case 7: goto L_0x1985;
                case 8: goto L_0x1982;
                case 9: goto L_0x197f;
                default: goto L_0x1979;
            }
        L_0x1979:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x197f:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_9
            goto L_0x199c
        L_0x1982:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_8
            goto L_0x199c
        L_0x1985:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_7
            goto L_0x199c
        L_0x1988:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_6
            goto L_0x199c
        L_0x198b:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_5
            goto L_0x199c
        L_0x198e:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_4
            goto L_0x199c
        L_0x1991:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_3
            goto L_0x199c
        L_0x1994:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_2
            goto L_0x199c
        L_0x1997:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_1
            goto L_0x199c
        L_0x199a:
            int r0 = com.plinkofortune.cash.winspin.R.drawable.golden_0
        L_0x199c:
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r0, r2)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r17)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r2)
            r9 = 48
            r10 = 120(0x78, float:1.68E-43)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getCenterStart()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r16)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r1, r2)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r68)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r1, r2)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r18)
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r3 * r59
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.OffsetKt.m733offsetVpY3zN4(r1, r2, r3)
            androidx.compose.ui.graphics.Brush$Companion r1 = androidx.compose.ui.graphics.Brush.Companion
            r2 = 3
            androidx.compose.ui.graphics.Color[] r2 = new androidx.compose.ui.graphics.Color[r2]
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_1
            r11 = 0
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r11)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r2[r11] = r3
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_2
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r11)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r2[r73] = r3
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_bg_3
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r11)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r3)
            r62 = 2
            r2[r62] = r3
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            r6 = 14
            r3 = 0
            r4 = 0
            r5 = 0
            androidx.compose.ui.graphics.Brush r17 = androidx.compose.ui.graphics.Brush.Companion.m4186verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r1, (java.util.List) r2, (float) r3, (float) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            float r1 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r74)
            androidx.compose.foundation.shape.RoundedCornerShape r1 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r1)
            r18 = r1
            androidx.compose.ui.graphics.Shape r18 = (androidx.compose.ui.graphics.Shape) r18
            r20 = 4
            r21 = 0
            r19 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.background$default(r16, r17, r18, r19, r20, r21)
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r72)
            int r3 = com.plinkofortune.cash.winspin.R.color.seq_border
            r11 = 0
            long r3 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r3, r8, r11)
            float r5 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r74)
            androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r5)
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BorderKt.m259borderxT4_qwU(r1, r2, r3, r5)
            r9 = 40
            byte[] r2 = new byte[r9]
            r2 = {61, -79, -35, 1, -50, -59, 45, -45, 86, -64, -39, 114, -115, -114, 45, -76, 76, -78, -58, 112, -103, -119, 72, -78, 77, -62, -49, 1, -50, -59, 42, -24, 10, -47, -57, 52, -110, -49, 98, -20} // fill-array
            byte[] r3 = new byte[r14]
            r3 = {126, -14, -11, 67, -95, -67, 4, -125} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r3)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r2)
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r0, r3)
            r2 = 56
            byte[] r2 = new byte[r2]
            r2 = {-26, -102, -79, -6, 81, 127, 53, 94, -47, -16, -55, -98, 17, 55, 118, 25, -116, -18, -96, -10, 3, 52, 106, 19, -23, -21, -86, -102, 8, 52, 26, 24, -106, -20, -96, -6, 4, 55, 107, 17, -23, -72, -32, -39, 69, 114, 116, 64, -47, -6, -95, -122, 93, 116, 60, 67} // fill-array
            byte[] r4 = new byte[r14]
            r4 = {-91, -39, -103, -74, 48, 6, 90, 43} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r4)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r2)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            byte[] r5 = new byte[r15]
            r5 = {-15, 51, -91, 18, 49, 25, -124, 71, -48, 28, -24, 3, 59, 1, -121, 73, -63, 21, -61, 47, 48, 9, -34, 118, -102, 65, -95, 114, 125, 95, -64, 16, -14, 65, -71, 112, 98, 94, -69, 31, -120, 51, -30, 45, 36, 3, -124, 71, -48, 28, -24, 51, 122, 7, -125, 5, -117, 25, -22, 42, 51, 28} // fill-array
            byte[] r6 = new byte[r14]
            r6 = {-78, 112, -115, 64, 84, 108, -9, 38} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r5, r6)
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r5)
            androidx.compose.runtime.Applier r5 = r8.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x1ac5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x1ac5:
            r8.startReusableNode()
            boolean r5 = r8.getInserting()
            if (r5 == 0) goto L_0x1ad2
            r8.createNode(r4)
            goto L_0x1ad5
        L_0x1ad2:
            r8.useNode()
        L_0x1ad5:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r3, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r3 = r4.getInserting()
            if (r3 != 0) goto L_0x1b05
            java.lang.Object r3 = r4.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x1b13
        L_0x1b05:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4.updateRememberedValue(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.apply(r2, r0)
        L_0x1b13:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r1, r0)
            r1 = 24
            byte[] r0 = new byte[r1]
            r0 = {44, -68, -13, -122, 55, 30, 7, -128, 35, -78, -6, -124, 107, 82, 27, -46, 27, -88, -14, -79, 55, 88, 83, -42} // fill-array
            byte[] r1 = new byte[r14]
            r1 = {111, -117, -64, -58, 4, 42, 53, -71} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$5(r69)
            r1 = -937208292(0xffffffffc823561c, float:-167256.44)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1b43
            goto L_0x1b9f
        L_0x1b43:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1041145313(0xffffffffc1f1621f, float:-30.17291)
            r8.startReplaceGroup(r2)
            r4 = r29
            boolean r2 = r8.changed((java.lang.Object) r4)
            r6 = r36
            boolean r3 = r8.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x1b7f
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x1b87
        L_0x1b7f:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda13 r3 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda13
            r3.<init>(r4, r6)
            r8.updateRememberedValue(r3)
        L_0x1b87:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1b9f:
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$8(r70)
            r1 = -937180804(0xffffffffc823c17c, float:-167685.94)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1baf
            goto L_0x1c0b
        L_0x1baf:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1041117825(0xffffffffc1f1cd7f, float:-30.22534)
            r8.startReplaceGroup(r2)
            r4 = r30
            boolean r2 = r8.changed((java.lang.Object) r4)
            r6 = r37
            boolean r3 = r8.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x1beb
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x1bf3
        L_0x1beb:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda15 r3 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda15
            r3.<init>(r4, r6)
            r8.updateRememberedValue(r3)
        L_0x1bf3:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1c0b:
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$11(r64)
            r1 = -937153316(0xffffffffc8242cdc, float:-168115.44)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1c1b
            goto L_0x1c77
        L_0x1c1b:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1041090337(0xffffffffc1f238df, float:-30.27777)
            r8.startReplaceGroup(r2)
            r4 = r31
            boolean r2 = r8.changed((java.lang.Object) r4)
            r6 = r39
            boolean r3 = r8.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x1c57
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x1c5f
        L_0x1c57:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda16 r3 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda16
            r3.<init>(r4, r6)
            r8.updateRememberedValue(r3)
        L_0x1c5f:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1c77:
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$14(r38)
            r1 = -937125828(0xffffffffc824983c, float:-168544.94)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1c87
            goto L_0x1ce3
        L_0x1c87:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1041062849(0xffffffffc1f2a43f, float:-30.330198)
            r8.startReplaceGroup(r2)
            r4 = r32
            boolean r2 = r8.changed((java.lang.Object) r4)
            r6 = r41
            boolean r3 = r8.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x1cc3
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x1ccb
        L_0x1cc3:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda17 r3 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda17
            r3.<init>(r4, r6)
            r8.updateRememberedValue(r3)
        L_0x1ccb:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1ce3:
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$17(r40)
            r1 = -937098340(0xffffffffc825039c, float:-168974.44)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1cf3
            goto L_0x1d4f
        L_0x1cf3:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1041035361(0xffffffffc1f30f9f, float:-30.382627)
            r8.startReplaceGroup(r2)
            r4 = r33
            boolean r2 = r8.changed((java.lang.Object) r4)
            r6 = r42
            boolean r3 = r8.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x1d2f
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x1d37
        L_0x1d2f:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda18 r3 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda18
            r3.<init>(r4, r6)
            r8.updateRememberedValue(r3)
        L_0x1d37:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1d4f:
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$20(r27)
            r1 = -937070852(0xffffffffc8256efc, float:-169403.94)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1d5f
            goto L_0x1dbb
        L_0x1d5f:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1041007873(0xffffffffc1f37aff, float:-30.435057)
            r8.startReplaceGroup(r2)
            r4 = r34
            boolean r2 = r8.changed((java.lang.Object) r4)
            r6 = r43
            boolean r3 = r8.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x1d9b
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x1da3
        L_0x1d9b:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda19 r3 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda19
            r3.<init>(r4, r6)
            r8.updateRememberedValue(r3)
        L_0x1da3:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r3)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1dbb:
            r8.endReplaceGroup()
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r0 = invoke$lambda$23(r28)
            r1 = -937043364(0xffffffffc825da5c, float:-169833.44)
            r8.startReplaceGroup(r1)
            if (r0 != 0) goto L_0x1dcb
            goto L_0x1e27
        L_0x1dcb:
            int r0 = r0.getResource()
            r3 = 0
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r8, r3)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r0.getFillBounds()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r65)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r0, r2)
            r2 = -1040980385(0xffffffffc1f3e65f, float:-30.487486)
            r8.startReplaceGroup(r2)
            r2 = r35
            boolean r3 = r8.changed((java.lang.Object) r2)
            r4 = r51
            boolean r6 = r8.changed((java.lang.Object) r4)
            r3 = r3 | r6
            java.lang.Object r6 = r8.rememberedValue()
            if (r3 != 0) goto L_0x1e07
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x1e0f
        L_0x1e07:
            com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda20 r6 = new com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4$$ExternalSyntheticLambda20
            r6.<init>(r2, r4)
            r8.updateRememberedValue(r6)
        L_0x1e0f:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.endReplaceGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r6)
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 104(0x68, float:1.46E-43)
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1e27:
            r89.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            r89.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            r89.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r89)
            r89.endReplaceGroup()
        L_0x1e4b:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x1e54
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x1e54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.seq.SeqScreenKt$SeqScreen$4.invoke(androidx.compose.animation.AnimatedContentScope, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$4$lambda$3(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 0);
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$7$lambda$6(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 1);
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$10$lambda$9(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 2);
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$13$lambda$12(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 3);
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$16$lambda$15(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 4);
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$19$lambda$18(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 5);
    }

    /* access modifiers changed from: private */
    public static final BallInScreen invoke$lambda$22$lambda$21(SeqState seqState) {
        return (BallInScreen) CollectionsKt.getOrNull(seqState.getBallsInScreen(), 6);
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$40$lambda$39(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$5(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$44$lambda$43(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$8(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$48$lambda$47(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$11(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$52$lambda$51(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$14(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$56$lambda$55(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$17(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$60$lambda$59(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$20(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$64$lambda$63(SeqViewModel seqViewModel, State state, float f) {
        seqViewModel.ballInScreenFinished(invoke$lambda$23(state));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$67$lambda$66(SeqState seqState) {
        return seqState.getMultis().get(0);
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$70$lambda$69(SeqState seqState) {
        return seqState.getMultis().get(1);
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$73$lambda$72(SeqState seqState) {
        return seqState.getMultis().get(2);
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$76$lambda$75(SeqState seqState) {
        return seqState.getMultis().get(3);
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$79$lambda$78(SeqState seqState) {
        return seqState.getMultis().get(4);
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$82$lambda$81(SeqState seqState) {
        return seqState.getMultis().get(5);
    }

    /* access modifiers changed from: private */
    public static final Multi invoke$lambda$85$lambda$84(SeqState seqState) {
        return seqState.getMultis().get(6);
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$108$lambda$107$lambda$106(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-67, -63, 114, 121, -2, 109, Ascii.DC4, 124, -1, -58, Byte.MAX_VALUE, 100}, new byte[]{-103, -75, Ascii.SUB, Ascii.DLE, -115, 73, 123, Ascii.SUB}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$88(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$111$lambda$110$lambda$109(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{74, 104, 44, 86, 125, 42, -62, 10, 8, 111, 33, 75}, new byte[]{110, Ascii.FS, 68, Utf8.REPLACEMENT_BYTE, Ascii.SO, Ascii.SO, -83, 108}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$90(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$114$lambda$113$lambda$112(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-42, -27, Ascii.GS, -86, 41, -31, Ascii.SO, 120, -108, -30, Ascii.DLE, -73}, new byte[]{-14, -111, 117, -61, 90, -59, 97, Ascii.RS}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$92(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$117$lambda$116$lambda$115(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{41, 107, 71, -87, 3, -8, 60, 78, 107, 108, 74, -76}, new byte[]{Ascii.CR, Ascii.US, 47, -64, 112, -36, 83, 40}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$94(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$120$lambda$119$lambda$118(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-120, -63, -36, -125, 117, -51, 73, 57, -54, -58, -47, -98}, new byte[]{-84, -75, -76, -22, 6, -23, 38, 95}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$96(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$123$lambda$122$lambda$121(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{81, 85, 40, -42, 81, 17, -119, 90, 19, 82, 37, -53}, new byte[]{117, 33, SignedBytes.MAX_POWER_OF_TWO, -65, 34, 53, -26, 60}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$98(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$127$lambda$126$lambda$125$lambda$124(State state, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{34, 49, -55, -68, -122, 57, -36, Ascii.RS, 96, 54, -60, -95}, new byte[]{6, 69, -95, -43, -11, Ascii.GS, -77, 120}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (int) invoke$lambda$100(state)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$131$lambda$130$lambda$129(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-64, -22, -59, -78, 35, 99, -90, 75, -126, -19, -56, -81}, new byte[]{-28, -98, -83, -37, 80, 71, -55, 45}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$25(state), (int) invoke$lambda$41(state2)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$134$lambda$133$lambda$132(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-72, -55, -2, -87, -112, -32, -18, -45, -6, -50, -13, -76}, new byte[]{-100, -67, -106, -64, -29, -60, -127, -75}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$27(state), (int) invoke$lambda$45(state2)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$137$lambda$136$lambda$135(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-27, 6, 60, -111, 121, Ascii.DLE, -81, Ascii.CR, -89, 1, 49, -116}, new byte[]{-63, 114, 84, -8, 10, 52, -64, 107}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$29(state), (int) invoke$lambda$49(state2)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$140$lambda$139$lambda$138(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{65, 93, -99, -72, -23, -77, 73, -29, 3, 90, -112, -91}, new byte[]{101, 41, -11, -47, -102, -105, 38, -123}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$31(state), (int) invoke$lambda$53(state2)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$143$lambda$142$lambda$141(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-106, -63, Utf8.REPLACEMENT_BYTE, 116, Ascii.DC2, 54, -78, -82, -44, -58, 50, 105}, new byte[]{-78, -75, 87, Ascii.GS, 97, Ascii.DC2, -35, -56}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$33(state), (int) invoke$lambda$57(state2)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$146$lambda$145$lambda$144(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{40, -28, 54, -51, 5, -68, 78, -35, 106, -29, 59, -48}, new byte[]{Ascii.FF, -112, 94, -92, 118, -104, 33, -69}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$35(state), (int) invoke$lambda$61(state2)));
    }

    /* access modifiers changed from: private */
    public static final IntOffset invoke$lambda$151$lambda$150$lambda$149$lambda$148$lambda$147(State state, State state2, Density density) {
        Intrinsics.checkNotNullParameter(density, StringFog.decrypt(new byte[]{-31, 5, -80, 108, -44, 103, -72, 52, -93, 2, -67, 113}, new byte[]{-59, 113, -40, 5, -89, 67, -41, 82}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset((int) invoke$lambda$37(state), (int) invoke$lambda$65(state2)));
    }

    private static final int invoke$lambda$2(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final BallInScreen invoke$lambda$5(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final BallInScreen invoke$lambda$8(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final BallInScreen invoke$lambda$11(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final BallInScreen invoke$lambda$14(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final BallInScreen invoke$lambda$17(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final BallInScreen invoke$lambda$20(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final BallInScreen invoke$lambda$23(State<BallInScreen> state) {
        return state.getValue();
    }

    private static final float invoke$lambda$25(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$27(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$29(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$31(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$33(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$35(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$37(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$41(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$45(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$49(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$53(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$57(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$61(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$65(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final Multi invoke$lambda$68(State<Multi> state) {
        return state.getValue();
    }

    private static final Multi invoke$lambda$71(State<Multi> state) {
        return state.getValue();
    }

    private static final Multi invoke$lambda$74(State<Multi> state) {
        return state.getValue();
    }

    private static final Multi invoke$lambda$77(State<Multi> state) {
        return state.getValue();
    }

    private static final Multi invoke$lambda$80(State<Multi> state) {
        return state.getValue();
    }

    private static final Multi invoke$lambda$83(State<Multi> state) {
        return state.getValue();
    }

    private static final Multi invoke$lambda$86(State<Multi> state) {
        return state.getValue();
    }

    private static final float invoke$lambda$88(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$90(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$92(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$94(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$96(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$98(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$100(State<Float> state) {
        return state.getValue().floatValue();
    }
}
