package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\n\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorColor", "getIndicatorColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "Indicator", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "threshold", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    private static final float Elevation = ElevationTokens.INSTANCE.m3197getLevel2D9Ej5fM();
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final float PositionalThreshold = Dp.m7111constructorimpl((float) 80);
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();

    private PullToRefreshDefaults() {
    }

    public final Shape getShape() {
        return shape;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1066257972, "C419@15907L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:419)");
        }
        long r0 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1875getSurfaceContainerHigh0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r0;
    }

    public final long getIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1441334156, "C423@16068L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1441334156, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:423)");
        }
        long r0 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1862getOnSurfaceVariant0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r0;
    }

    /* renamed from: getPositionalThreshold-D9Ej5fM  reason: not valid java name */
    public final float m3005getPositionalThresholdD9Ej5fM() {
        return PositionalThreshold;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m3004getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00eb  */
    /* renamed from: Indicator-2poqoh4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3003Indicator2poqoh4(androidx.compose.material3.pulltorefresh.PullToRefreshState r20, boolean r21, androidx.compose.ui.Modifier r22, long r23, long r25, float r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r19 = this;
            r1 = r20
            r10 = r29
            r0 = -1076870256(0xffffffffbfd04390, float:-1.6270618)
            r2 = r28
            androidx.compose.runtime.Composer r11 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Indicator)P(4,2,3,1:c#ui.graphics.Color,0:c#ui.graphics.Color,5:c#ui.unit.Dp)437@16566L14,438@16627L14,441@16704L1007:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r30 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x0028
            boolean r2 = r11.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r10
            goto L_0x0029
        L_0x0028:
            r2 = r10
        L_0x0029:
            r3 = r30 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r10 & 48
            if (r3 != 0) goto L_0x0043
            r3 = r21
            boolean r4 = r11.changed((boolean) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r2 = r2 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r21
        L_0x0045:
            r4 = r30 & 4
            if (r4 == 0) goto L_0x004c
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r10 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x005f
            r5 = r22
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r2 = r2 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r22
        L_0x0061:
            r6 = r10 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007a
            r6 = r30 & 8
            if (r6 != 0) goto L_0x0074
            r6 = r23
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x0076
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0074:
            r6 = r23
        L_0x0076:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r2 = r2 | r8
            goto L_0x007c
        L_0x007a:
            r6 = r23
        L_0x007c:
            r8 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0095
            r8 = r30 & 16
            if (r8 != 0) goto L_0x008f
            r8 = r25
            boolean r12 = r11.changed((long) r8)
            if (r12 == 0) goto L_0x0091
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x008f:
            r8 = r25
        L_0x0091:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r2 = r2 | r12
            goto L_0x0097
        L_0x0095:
            r8 = r25
        L_0x0097:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00b1
            r12 = r30 & 32
            if (r12 != 0) goto L_0x00ab
            r12 = r27
            boolean r13 = r11.changed((float) r12)
            if (r13 == 0) goto L_0x00ad
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ab:
            r12 = r27
        L_0x00ad:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r2 = r2 | r13
            goto L_0x00b3
        L_0x00b1:
            r12 = r27
        L_0x00b3:
            r13 = r30 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00bb
            r2 = r2 | r14
            goto L_0x00ce
        L_0x00bb:
            r13 = r10 & r14
            if (r13 != 0) goto L_0x00ce
            r13 = r19
            boolean r14 = r11.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ca
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r2 = r2 | r14
            goto L_0x00d0
        L_0x00ce:
            r13 = r19
        L_0x00d0:
            r14 = 599187(0x92493, float:8.3964E-40)
            r14 = r14 & r2
            r15 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r15) goto L_0x00eb
            boolean r14 = r11.getSkipping()
            if (r14 != 0) goto L_0x00e0
            goto L_0x00eb
        L_0x00e0:
            r11.skipToGroupEnd()
            r0 = r1
            r4 = r5
            r5 = r6
            r7 = r8
            r1 = r11
            r9 = r12
            goto L_0x026b
        L_0x00eb:
            r11.startDefaults()
            r14 = r10 & 1
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r28 = -458753(0xfffffffffff8ffff, float:NaN)
            r15 = 6
            if (r14 == 0) goto L_0x0119
            boolean r14 = r11.getDefaultsInvalid()
            if (r14 == 0) goto L_0x0100
            goto L_0x0119
        L_0x0100:
            r11.skipToGroupEnd()
            r4 = r30 & 8
            if (r4 == 0) goto L_0x0109
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0109:
            r4 = r30 & 16
            if (r4 == 0) goto L_0x010f
            r2 = r2 & r16
        L_0x010f:
            r4 = r30 & 32
            if (r4 == 0) goto L_0x0115
            r2 = r2 & r28
        L_0x0115:
            r4 = r5
            r5 = r6
            r7 = r8
            goto L_0x0148
        L_0x0119:
            if (r4 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0121
        L_0x0120:
            r4 = r5
        L_0x0121:
            r5 = r30 & 8
            if (r5 == 0) goto L_0x012e
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults r5 = INSTANCE
            long r5 = r5.getContainerColor(r11, r15)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x012f
        L_0x012e:
            r5 = r6
        L_0x012f:
            r7 = r30 & 16
            if (r7 == 0) goto L_0x013c
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults r7 = INSTANCE
            long r7 = r7.getIndicatorColor(r11, r15)
            r2 = r2 & r16
            goto L_0x013d
        L_0x013c:
            r7 = r8
        L_0x013d:
            r9 = r30 & 32
            if (r9 == 0) goto L_0x0148
            float r9 = PositionalThreshold
            r2 = r2 & r28
            r12 = r2
            r3 = r9
            goto L_0x014a
        L_0x0148:
            r3 = r12
            r12 = r2
        L_0x014a:
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0159
            r2 = -1
            java.lang.String r9 = "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:440)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r2, r9)
        L_0x0159:
            r16 = r7
            r8 = 40
            r9 = 0
            r0 = r4
            r4 = 0
            r7 = 0
            r2 = r21
            r14 = r12
            r12 = r16
            androidx.compose.ui.Modifier r4 = androidx.compose.material3.pulltorefresh.PullToRefreshKt.m3019pullToRefreshIndicatorwUdLESc$default(r0, r1, r2, r3, r4, r5, r7, r8, r9)
            r9 = r0
            r0 = r1
            r18 = r3
            r16 = r5
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r3)
            r2 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r2)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r5)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r2)
            androidx.compose.runtime.CompositionLocalMap r5 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            r7 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r8 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r8)
            androidx.compose.runtime.Applier r7 = r11.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x01b0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b0:
            r11.startReusableNode()
            boolean r7 = r11.getInserting()
            if (r7 == 0) goto L_0x01bd
            r11.createNode(r6)
            goto L_0x01c0
        L_0x01bd:
            r11.useNode()
        L_0x01c0:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x01f0
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x01fe
        L_0x01f0:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r6.updateRememberedValue(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6.apply(r3, r1)
        L_0x01fe:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r3 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = 396611011(0x17a3cdc3, float:1.058557E-24)
            java.lang.String r3 = "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r21)
            r3 = 100
            r4 = 0
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r2, r4, r15, r4)
            r3 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1 r2 = new androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1
            r2.<init>(r12, r0)
            r4 = 54
            r5 = 167807595(0xa008a6b, float:6.189009E-33)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r6, r2, r11, r4)
            r5 = r2
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            int r2 = r14 >> 3
            r2 = r2 & 14
            r7 = r2 | 24960(0x6180, float:3.4976E-41)
            r8 = 10
            r2 = 0
            r4 = 0
            r6 = r11
            androidx.compose.animation.CrossfadeKt.Crossfade(r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float>) r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0264
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0264:
            r1 = r6
            r4 = r9
            r7 = r12
            r5 = r16
            r9 = r18
        L_0x026b:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x0283
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$2 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$2
            r1 = r19
            r2 = r20
            r3 = r21
            r11 = r30
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0283:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.m3003Indicator2poqoh4(androidx.compose.material3.pulltorefresh.PullToRefreshState, boolean, androidx.compose.ui.Modifier, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
