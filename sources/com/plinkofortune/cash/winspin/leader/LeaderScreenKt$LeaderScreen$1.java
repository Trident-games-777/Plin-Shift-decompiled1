package com.plinkofortune.cash.winspin.leader;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: LeaderScreen.kt */
final class LeaderScreenKt$LeaderScreen$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ State<List<LeaderModel>> $leaders$delegate;

    LeaderScreenKt$LeaderScreen$1(State<? extends List<LeaderModel>> state) {
        this.$leaders$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.ColumnScope r26, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r25 = this;
            r0 = r26
            r9 = r27
            r1 = 19
            byte[] r1 = new byte[r1]
            r1 = {58, 11, -69, 97, 92, -76, 81, 62, 113, 19, -79, 105, 93, -45, 106, 61, 107, 18, -67} // fill-array
            r12 = 8
            byte[] r2 = new byte[r12]
            r2 = {30, 127, -45, 8, 47, -112, 5, 81} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r28 & 6
            r13 = 2
            if (r1 != 0) goto L_0x002a
            boolean r1 = r9.changed((java.lang.Object) r0)
            if (r1 == 0) goto L_0x0026
            r1 = 4
            goto L_0x0027
        L_0x0026:
            r1 = r13
        L_0x0027:
            r1 = r28 | r1
            goto L_0x002c
        L_0x002a:
            r1 = r28
        L_0x002c:
            r2 = r1 & 19
            r3 = 18
            if (r2 != r3) goto L_0x003d
            boolean r2 = r9.getSkipping()
            if (r2 != 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            r9.skipToGroupEnd()
            return
        L_0x003d:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x005a
            r2 = 83
            byte[] r2 = new byte[r2]
            r2 = {-52, 5, -43, -82, 105, 34, 47, -55, -60, 5, -34, -17, 107, 58, 51, -55, -54, 68, -37, -31, 106, 38, 104, -48, -58, 4, -53, -16, 112, 32, 104, -53, -54, 11, -36, -27, 107, 96, 10, -62, -50, 14, -35, -14, 74, 45, 52, -62, -54, 4, -106, -68, 120, 32, 41, -55, -42, 7, -41, -11, 106, 112, 102, -113, -29, 15, -39, -28, 124, 60, 21, -60, -35, 15, -35, -18, 55, 37, 50, -99, -101, 94, -111} // fill-array
            byte[] r3 = new byte[r12]
            r3 = {-81, 106, -72, -128, 25, 78, 70, -89} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r3)
            r3 = -929161396(0xffffffffc89e1f4c, float:-323834.38)
            r4 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r4, r2)
        L_0x005a:
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r1.getCenter()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 1063675494(0x3f666666, float:0.9)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r1, r2)
            r4 = 2
            r5 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.ColumnScope.weight$default(r0, r1, r2, r3, r4, r5)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            androidx.compose.ui.Modifier r14 = r0.align(r1, r2)
            int r0 = com.plinkofortune.cash.winspin.R.drawable.form
            r1 = 0
            androidx.compose.ui.graphics.painter.Painter r15 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r0, r9, r1)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r18 = r0.getFillBounds()
            r21 = 54
            r22 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r14 = r25
            androidx.compose.runtime.State<java.util.List<com.plinkofortune.cash.winspin.leader.LeaderModel>> r2 = r14.$leaders$delegate
            r3 = 40
            byte[] r3 = new byte[r3]
            r3 = {-108, -61, 38, -62, -124, 19, 116, 77, -1, -78, 34, -79, -57, 88, 116, 42, -27, -64, 61, -77, -45, 95, 17, 44, -28, -80, 52, -62, -124, 19, 115, 118, -93, -93, 60, -9, -40, 25, 59, 114} // fill-array
            byte[] r4 = new byte[r12]
            r4 = {-41, -128, 14, -128, -21, 107, 93, 29} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r4)
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r3)
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r6, r1)
            r4 = 56
            byte[] r4 = new byte[r4]
            r4 = {-36, 65, 118, 115, -8, 100, 120, -32, -21, 43, 14, 23, -72, 44, 59, -89, -74, 53, 103, 127, -86, 47, 39, -83, -45, 48, 109, 19, -95, 47, 87, -90, -84, 55, 103, 115, -83, 44, 38, -81, -45, 99, 39, 80, -20, 105, 57, -2, -21, 33, 102, 15, -12, 111, 113, -3} // fill-array
            byte[] r5 = new byte[r12]
            r5 = {-97, 2, 94, 63, -103, 29, 23, -107} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r5)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r1)
            androidx.compose.runtime.CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            r15 = 62
            byte[] r7 = new byte[r15]
            r7 = {-117, -114, -25, -109, 91, 69, 100, 61, -86, -95, -86, -126, 81, 93, 103, 51, -69, -88, -127, -82, 90, 85, 62, 12, -32, -4, -29, -13, 23, 3, 32, 106, -120, -4, -5, -15, 8, 2, 91, 101, -14, -114, -96, -84, 78, 95, 100, 61, -86, -95, -86, -78, 16, 91, 99, 127, -15, -92, -88, -85, 89, 64} // fill-array
            byte[] r8 = new byte[r12]
            r8 = {-56, -51, -49, -63, 62, 48, 23, 92} // fill-array
            java.lang.String r7 = com.plinkofortune.cash.winspin.StringFog.decrypt(r7, r8)
            r8 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r7)
            androidx.compose.runtime.Applier r7 = r9.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0102
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0102:
            r9.startReusableNode()
            boolean r7 = r9.getInserting()
            if (r7 == 0) goto L_0x010f
            r9.createNode(r6)
            goto L_0x0112
        L_0x010f:
            r9.useNode()
        L_0x0112:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r3, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x0142
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x0150
        L_0x0142:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.apply(r4, r3)
        L_0x0150:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r0, r3)
            r0 = 24
            byte[] r0 = new byte[r0]
            r0 = {58, 99, 7, -127, -68, -50, 91, -86, 53, 109, 14, -125, -32, -126, 71, -8, 13, 119, 6, -74, -68, -120, 15, -4} // fill-array
            byte[] r3 = new byte[r12]
            r3 = {121, 84, 52, -63, -113, -6, 105, -109} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r3)
            r3 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r4 = 10
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r3 = r3.m623spacedBy0680j_4(r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r5 = r4.getCenterHorizontally()
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r6 = 1061997773(0x3f4ccccd, float:0.8)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight(r4, r6)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r4, r6)
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = (androidx.compose.foundation.layout.Arrangement.Vertical) r3
            r6 = 1626309209(0x60ef8259, float:1.3806764E20)
            r9.startReplaceGroup(r6)
            boolean r6 = r9.changed((java.lang.Object) r2)
            java.lang.Object r7 = r9.rememberedValue()
            if (r6 != 0) goto L_0x01af
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x01b7
        L_0x01af:
            com.plinkofortune.cash.winspin.leader.LeaderScreenKt$LeaderScreen$1$$ExternalSyntheticLambda0 r7 = new com.plinkofortune.cash.winspin.leader.LeaderScreenKt$LeaderScreen$1$$ExternalSyntheticLambda0
            r7.<init>(r2)
            r9.updateRememberedValue(r7)
        L_0x01b7:
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r9.endReplaceGroup()
            r10 = 221190(0x36006, float:3.09953E-40)
            r11 = 206(0xce, float:2.89E-43)
            r2 = r1
            r1 = 0
            r6 = r2
            r2 = 0
            r7 = r0
            r0 = r4
            r4 = r3
            r3 = 0
            r16 = r6
            r6 = 0
            r17 = r7
            r7 = 0
            r12 = r16
            r15 = r17
            androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getCenter()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 1063675494(0x3f666666, float:0.9)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r1, r2)
            r2 = 1036831949(0x3dcccccd, float:0.1)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight(r1, r2)
            androidx.compose.ui.graphics.Brush$Companion r17 = androidx.compose.ui.graphics.Brush.Companion
            r1 = 3
            androidx.compose.ui.graphics.Color[] r1 = new androidx.compose.ui.graphics.Color[r1]
            int r2 = com.plinkofortune.cash.winspin.R.color.seq_bg_1
            long r4 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r2, r9, r12)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4229boximpl(r4)
            r1[r12] = r2
            int r2 = com.plinkofortune.cash.winspin.R.color.seq_bg_2
            long r4 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r2, r9, r12)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4229boximpl(r4)
            r4 = 1
            r1[r4] = r2
            int r2 = com.plinkofortune.cash.winspin.R.color.seq_bg_3
            long r4 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r2, r9, r12)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4229boximpl(r4)
            r1[r13] = r2
            java.util.List r18 = kotlin.collections.CollectionsKt.listOf(r1)
            r22 = 14
            r23 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            androidx.compose.ui.graphics.Brush r4 = androidx.compose.ui.graphics.Brush.Companion.m4186verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r17, (java.util.List) r18, (float) r19, (float) r20, (int) r21, (int) r22, (java.lang.Object) r23)
            r1 = 16
            float r1 = (float) r1
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r1)
            androidx.compose.foundation.shape.RoundedCornerShape r2 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r2)
            r5 = r2
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            r7 = 4
            r8 = 0
            r6 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.background$default(r3, r4, r5, r6, r7, r8)
            float r3 = (float) r13
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            int r4 = com.plinkofortune.cash.winspin.R.color.seq_border
            long r4 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r4, r9, r12)
            float r1 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r1)
            androidx.compose.foundation.shape.RoundedCornerShape r1 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r1)
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BorderKt.m259borderxT4_qwU(r2, r3, r4, r1)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopCenter()
            androidx.compose.ui.Modifier r1 = r15.align(r1, r2)
            r2 = 40
            byte[] r2 = new byte[r2]
            r2 = {62, 75, -90, 52, -56, 106, 26, 85, 85, 58, -94, 71, -117, 33, 26, 50, 79, 72, -67, 69, -97, 38, 127, 52, 78, 56, -76, 52, -56, 106, 29, 110, 9, 43, -68, 1, -108, 96, 85, 106} // fill-array
            r3 = 8
            byte[] r4 = new byte[r3]
            r4 = {125, 8, -114, 118, -89, 18, 51, 5} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r4)
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r2)
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r0, r12)
            r2 = 56
            byte[] r2 = new byte[r2]
            r2 = {-113, -114, -62, 28, 42, -61, 11, 123, -72, -28, -70, 120, 106, -117, 72, 60, -27, -6, -45, 16, 120, -120, 84, 54, -128, -1, -39, 124, 115, -120, 36, 61, -1, -8, -45, 28, 127, -117, 85, 52, -128, -84, -109, 63, 62, -50, 74, 101, -72, -18, -46, 96, 38, -56, 2, 102} // fill-array
            byte[] r4 = new byte[r3]
            r4 = {-52, -51, -22, 80, 75, -70, 100, 14} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r4)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r2)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r12)
            androidx.compose.runtime.CompositionLocalMap r3 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            r5 = 62
            byte[] r5 = new byte[r5]
            r5 = {85, -35, 9, -49, 65, 2, -109, 117, 116, -14, 68, -34, 75, 26, -112, 123, 101, -5, 111, -14, 64, 18, -55, 68, 62, -81, 13, -81, 13, 68, -41, 34, 86, -81, 21, -83, 18, 69, -84, 45, 44, -35, 78, -16, 84, 24, -109, 117, 116, -14, 68, -18, 10, 28, -108, 55, 47, -9, 70, -9, 67, 7} // fill-array
            r6 = 8
            byte[] r7 = new byte[r6]
            r7 = {22, -98, 33, -99, 36, 119, -32, 20} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r5, r7)
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r6, r5)
            androidx.compose.runtime.Applier r5 = r9.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x02ca
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02ca:
            r9.startReusableNode()
            boolean r5 = r9.getInserting()
            if (r5 == 0) goto L_0x02d7
            r9.createNode(r4)
            goto L_0x02da
        L_0x02d7:
            r9.useNode()
        L_0x02da:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3675constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r3, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r3 = r4.getInserting()
            if (r3 != 0) goto L_0x030a
            java.lang.Object r3 = r4.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x0318
        L_0x030a:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4.updateRememberedValue(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.apply(r2, r0)
        L_0x0318:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r1, r0)
            r0 = 24
            byte[] r0 = new byte[r0]
            r0 = {-54, 49, -83, -36, 9, -5, -26, -33, -59, 63, -92, -34, 85, -73, -6, -115, -3, 37, -84, -21, 9, -67, -78, -119} // fill-array
            r3 = 8
            byte[] r1 = new byte[r3]
            r1 = {-119, 6, -98, -100, 58, -49, -44, -26} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1
            androidx.compose.ui.text.font.Font[] r0 = new androidx.compose.ui.text.font.Font[r0]
            int r1 = com.plinkofortune.cash.winspin.R.font.playtone
            r5 = 14
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.text.font.Font r1 = androidx.compose.ui.text.font.FontKt.m6661FontYpTlLL0$default(r1, r2, r3, r4, r5, r6)
            r0[r12] = r1
            androidx.compose.ui.text.font.FontFamily r8 = androidx.compose.ui.text.font.FontFamilyKt.FontFamily((androidx.compose.ui.text.font.Font[]) r0)
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r0.m4276getWhite0d7_KjU()
            r0 = 32
            long r4 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r0)
            r0 = 7
            byte[] r0 = new byte[r0]
            r0 = {-31, 9, -26, 117, 41, 2, -15} // fill-array
            r6 = 8
            byte[] r1 = new byte[r6]
            r1 = {-83, 108, -121, 17, 76, 112, -126, 62} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r23 = 0
            r24 = 130994(0x1ffb2, float:1.83562E-40)
            r1 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 3462(0xd86, float:4.851E-42)
            r21 = r27
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r0, (androidx.compose.ui.Modifier) r1, (long) r2, (long) r4, (androidx.compose.ui.text.font.FontStyle) r6, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontFamily) r8, (long) r9, (androidx.compose.ui.text.style.TextDecoration) r11, (androidx.compose.ui.text.style.TextAlign) r12, (long) r13, (int) r15, (boolean) r16, (int) r17, (int) r18, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r19, (androidx.compose.ui.text.TextStyle) r20, (androidx.compose.runtime.Composer) r21, (int) r22, (int) r23, (int) r24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            r27.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            r27.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03b6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.leader.LeaderScreenKt$LeaderScreen$1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$3$lambda$2(State state, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, StringFog.decrypt(new byte[]{Ascii.DLE, -82, -15, 35, 77, -17, -77, 96, 78, -93, -38, 37, 82, -66, -110, 111}, new byte[]{52, -38, -103, 74, 62, -53, -1, 1}));
        List access$LeaderScreen$lambda$0 = LeaderScreenKt.LeaderScreen$lambda$0(state);
        lazyListScope.items(access$LeaderScreen$lambda$0.size(), (Function1<? super Integer, ? extends Object>) null, new LeaderScreenKt$LeaderScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$3(LeaderScreenKt$LeaderScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$1.INSTANCE, access$LeaderScreen$lambda$0), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LeaderScreenKt$LeaderScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$4(access$LeaderScreen$lambda$0)));
        return Unit.INSTANCE;
    }
}
