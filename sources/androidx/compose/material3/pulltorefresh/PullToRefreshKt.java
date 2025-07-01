package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002\u001a(\u0010\u0017\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\b+¢\u0006\u0002\b,2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\b+¢\u0006\u0002\b,H\u0007¢\u0006\u0002\u0010.\u001a\b\u0010/\u001a\u00020%H\u0007\u001a\r\u00100\u001a\u00020%H\u0007¢\u0006\u0002\u00101\u001aF\u00102\u001a\u00020\u0018*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a>\u0010=\u001a\u00020\u0018*\u0002032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001aH\u0010A\u001a\u00020#*\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020 2\b\b\u0002\u0010C\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aN\u0010F\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u001b2\b\b\u0002\u0010J\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020\u0002X\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "progress", "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshBox", "isRefreshing", "", "onRefresh", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "pullToRefresh", "enabled", "threshold", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "pullToRefreshIndicator", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "elevation", "pullToRefreshIndicator-wUdLESc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLandroidx/compose/ui/graphics/Shape;JF)Landroidx/compose/ui/Modifier;", "material3_release", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshKt {
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final float ArcRadius = Dp.m7111constructorimpl((float) 5.5d);
    private static final float ArrowHeight = Dp.m7111constructorimpl((float) 5);
    private static final float ArrowWidth = Dp.m7111constructorimpl((float) 10);
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float SpinnerContainerSize = Dp.m7111constructorimpl((float) 40);
    private static final float SpinnerSize = Dp.m7111constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final float StrokeWidth = Dp.m7111constructorimpl((float) 2.5d);

    /* JADX WARNING: Removed duplicated region for block: B:122:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PullToRefreshBox(boolean r16, kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, androidx.compose.material3.pulltorefresh.PullToRefreshState r19, androidx.compose.ui.Alignment r20, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r16
            r8 = r22
            r9 = r24
            r0 = 1902956467(0x716ccfb3, float:1.1726329E30)
            r2 = r23
            androidx.compose.runtime.Composer r10 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(PullToRefreshBox)P(3,5,4,6,1,2)124@5580L28,126@5713L163,135@5931L199:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r9 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r10.changed((boolean) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r9
            goto L_0x002b
        L_0x002a:
            r2 = r9
        L_0x002b:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            r5 = r17
            goto L_0x0046
        L_0x0034:
            r3 = r9 & 48
            r5 = r17
            if (r3 != 0) goto L_0x0046
            boolean r3 = r10.changedInstance(r5)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r25 & 4
            if (r3 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r4 = r9 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r18
            boolean r6 = r10.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r6
            goto L_0x0062
        L_0x0060:
            r4 = r18
        L_0x0062:
            r6 = r9 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007b
            r6 = r25 & 8
            if (r6 != 0) goto L_0x0075
            r6 = r19
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0077
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r6 = r19
        L_0x0077:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r7
            goto L_0x007d
        L_0x007b:
            r6 = r19
        L_0x007d:
            r7 = r25 & 16
            if (r7 == 0) goto L_0x0084
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0097
            r11 = r20
            boolean r12 = r10.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0093
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r12
            goto L_0x0099
        L_0x0097:
            r11 = r20
        L_0x0099:
            r12 = r25 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a1
            r2 = r2 | r13
            goto L_0x00b3
        L_0x00a1:
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00b3
            r13 = r21
            boolean r14 = r10.changedInstance(r13)
            if (r14 == 0) goto L_0x00af
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r14
            goto L_0x00b5
        L_0x00b3:
            r13 = r21
        L_0x00b5:
            r14 = r25 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bd
            r2 = r2 | r15
            goto L_0x00cd
        L_0x00bd:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00cd
            boolean r14 = r10.changedInstance(r8)
            if (r14 == 0) goto L_0x00ca
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r2 = r2 | r14
        L_0x00cd:
            r14 = 599187(0x92493, float:8.3964E-40)
            r14 = r14 & r2
            r15 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r15) goto L_0x00e6
            boolean r14 = r10.getSkipping()
            if (r14 != 0) goto L_0x00dd
            goto L_0x00e6
        L_0x00dd:
            r10.skipToGroupEnd()
            r3 = r4
            r4 = r6
        L_0x00e2:
            r5 = r11
            r6 = r13
            goto L_0x022b
        L_0x00e6:
            r10.startDefaults()
            r14 = r9 & 1
            r15 = 0
            if (r14 == 0) goto L_0x0102
            boolean r14 = r10.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00f5
            goto L_0x0102
        L_0x00f5:
            r10.skipToGroupEnd()
            r3 = r25 & 8
            if (r3 == 0) goto L_0x00fe
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00fe:
            r12 = r2
            r3 = r4
        L_0x0100:
            r2 = r6
            goto L_0x0136
        L_0x0102:
            if (r3 == 0) goto L_0x0109
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x010a
        L_0x0109:
            r3 = r4
        L_0x010a:
            r4 = r25 & 8
            if (r4 == 0) goto L_0x0115
            androidx.compose.material3.pulltorefresh.PullToRefreshState r4 = rememberPullToRefreshState(r10, r15)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r4
        L_0x0115:
            if (r7 == 0) goto L_0x011e
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r11 = r4
        L_0x011e:
            if (r12 == 0) goto L_0x0134
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshBox$1 r4 = new androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshBox$1
            r4.<init>(r6, r1)
            r7 = 54
            r12 = 1989171225(0x76905819, float:1.4638234E33)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r13, r4, r10, r7)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            r12 = r2
            r13 = r4
            goto L_0x0100
        L_0x0134:
            r12 = r2
            goto L_0x0100
        L_0x0136:
            r10.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0145
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:134)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r4, r6)
        L_0x0145:
            r6 = 12
            r7 = 0
            r0 = r3
            r3 = 0
            r4 = 0
            androidx.compose.ui.Modifier r3 = m3017pullToRefreshZ4HSEVQ$default(r0, r1, r2, r3, r4, r5, r6, r7)
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r4)
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r11, r15)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r5)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r15)
            androidx.compose.runtime.CompositionLocalMap r5 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r10, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            r7 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r14 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r7, r14)
            androidx.compose.runtime.Applier r7 = r10.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0188
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0188:
            r10.startReusableNode()
            boolean r7 = r10.getInserting()
            if (r7 == 0) goto L_0x0195
            r10.createNode(r6)
            goto L_0x0198
        L_0x0195:
            r10.useNode()
        L_0x0198:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x01c8
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x01d6
        L_0x01c8:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.apply(r4, r1)
        L_0x01d6:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r3, r1)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r3 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r3 = 1101976897(0x41aed541, float:21.854128)
            java.lang.String r4 = "C139@6095L9,140@6113L11:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            int r3 = r12 >> 15
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 6
            r3 = r3 | r4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r8.invoke(r1, r10, r3)
            int r3 = r12 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r13.invoke(r1, r10, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r10.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0227
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0227:
            r3 = r0
            r4 = r2
            goto L_0x00e2
        L_0x022b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 == 0) goto L_0x0243
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshBox$3 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshBox$3
            r1 = r16
            r2 = r17
            r7 = r8
            r8 = r9
            r9 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0243:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshBox(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: pullToRefreshIndicator-wUdLESc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3019pullToRefreshIndicatorwUdLESc$default(Modifier modifier, PullToRefreshState pullToRefreshState, boolean z, float f, Shape shape, long j, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m3005getPositionalThresholdD9Ej5fM();
        }
        float f3 = f;
        if ((i & 8) != 0) {
            shape = PullToRefreshDefaults.INSTANCE.getShape();
        }
        Shape shape2 = shape;
        if ((i & 16) != 0) {
            j = Color.Companion.m4275getUnspecified0d7_KjU();
        }
        return m3018pullToRefreshIndicatorwUdLESc(modifier, pullToRefreshState, z, f3, shape2, j, (i & 32) != 0 ? PullToRefreshDefaults.INSTANCE.m3004getElevationD9Ej5fM() : f2);
    }

    /* renamed from: pullToRefreshIndicator-wUdLESc  reason: not valid java name */
    public static final Modifier m3018pullToRefreshIndicatorwUdLESc(Modifier modifier, PullToRefreshState pullToRefreshState, boolean z, float f, Shape shape, long j, float f2) {
        Shape shape2 = shape;
        return BackgroundKt.m247backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(SizeKt.m845size3ABfNKs(modifier, SpinnerContainerSize), PullToRefreshKt$pullToRefreshIndicator$1.INSTANCE), new PullToRefreshKt$pullToRefreshIndicator$2(pullToRefreshState, z, f, f2, shape2)), j, shape2);
    }

    /* renamed from: pullToRefresh-Z4HSEVQ$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3017pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m3005getPositionalThresholdD9Ej5fM();
        }
        return m3016pullToRefreshZ4HSEVQ(modifier, z, pullToRefreshState, z3, f, function0);
    }

    /* renamed from: pullToRefresh-Z4HSEVQ  reason: not valid java name */
    public static final Modifier m3016pullToRefreshZ4HSEVQ(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0<Unit> function0) {
        return modifier.then(new PullToRefreshElement(z, function0, z2, pullToRefreshState, f, (DefaultConstructorMarker) null));
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 318623070, "C(rememberPullToRefreshState)513@19156L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:512)");
        }
        Composer composer2 = composer;
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.rememberSaveable(new Object[0], PullToRefreshStateImpl.Companion.getSaver(), (String) null, PullToRefreshKt$rememberPullToRefreshState$1.INSTANCE, composer2, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return pullToRefreshStateImpl;
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularArrowProgressIndicator-RPmYEkk  reason: not valid java name */
    public static final void m3010CircularArrowProgressIndicatorRPmYEkk(Function0<Float> function0, long j, Composer composer, int i) {
        int i2;
        Function0<Float> function02 = function0;
        long j2 = j;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)562@20583L61,564@20745L76,565@20843L74,567@20982L98,571@21118L443,566@20922L639:PullToRefresh.kt#djiw08");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:561)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136642763, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            Path path = rememberedValue;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.m4529setFillTypeoQ8Xj4U(PathFillType.Companion.m4543getEvenOddRgk1Os());
                startRestartGroup.updateRememberedValue(Path);
                path = Path;
            }
            Path path2 = (Path) path;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136647962, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1(function02));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String str = "CC(remember):PullToRefresh.kt#9igjgp";
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$4((State) rememberedValue2), AlphaTween, 0.0f, (String) null, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 28);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136655568, str);
            int i4 = i2 & 14;
            boolean z = true;
            boolean z2 = i4 == 4;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new PullToRefreshKt$CircularArrowProgressIndicator$1$1(function02);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier r8 = SizeKt.m845size3ABfNKs(SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue3), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136660265, str);
            boolean changed = (i4 == 4) | startRestartGroup.changed((Object) animateFloatAsState);
            if ((i2 & 112) != 32) {
                z = false;
            }
            boolean changedInstance = changed | z | startRestartGroup.changedInstance(path2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new PullToRefreshKt$CircularArrowProgressIndicator$2$1(function02, animateFloatAsState, j2, path2);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CanvasKt.Canvas(r8, (Function1) rememberedValue4, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PullToRefreshKt$CircularArrowProgressIndicator$3(function02, j2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-KzyDr3Q  reason: not valid java name */
    public static final void m3015drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f, ArrowValues arrowValues, Rect rect, float f2) {
        DrawScope drawScope2 = drawScope;
        DrawScope.m4825drawArcyD3GUKo$default(drawScope2, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m4022getTopLeftF1C5BW0(), rect.m4020getSizeNHjbRc(), f, new Stroke(drawScope2.m7091toPx0680j_4(f2), 0.0f, StrokeCap.Companion.m4634getButtKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float max = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * ((float) 5)) / ((float) 3);
        float coerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float pow = (((0.4f * max) - 16.0f) + (coerceIn - (((float) Math.pow((double) coerceIn, (double) 2)) / ((float) 4)))) * 0.5f;
        float f2 = (float) 360;
        return new ArrowValues(pow, pow * f2, ((0.8f * max) + pow) * f2, Math.min(1.0f, max));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawArrow-uDrxG_w  reason: not valid java name */
    public static final void m3014drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues, float f2) {
        DrawScope drawScope2 = drawScope;
        Path path2 = path;
        float f3 = f2;
        path2.reset();
        path2.moveTo(0.0f, 0.0f);
        float f4 = ArrowWidth;
        path2.lineTo((drawScope2.m7091toPx0680j_4(f4) * arrowValues.getScale()) / ((float) 2), drawScope2.m7091toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path2.lineTo(drawScope2.m7091toPx0680j_4(f4) * arrowValues.getScale(), 0.0f);
        path2.m4531translatek4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m3987getXimpl(rect.m4017getCenterF1C5BW0())) - ((drawScope2.m7091toPx0680j_4(f4) * arrowValues.getScale()) / 2.0f), Offset.m3988getYimpl(rect.m4017getCenterF1C5BW0()) - drawScope2.m7091toPx0680j_4(f3)));
        float endAngle = arrowValues.getEndAngle() - drawScope2.m7091toPx0680j_4(f3);
        long r4 = drawScope2.m4864getCenterF1C5BW0();
        DrawContext drawContext = drawScope2.getDrawContext();
        long r11 = drawContext.m4806getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().m4929rotateUv8p0NA(endAngle, r4);
            DrawScope.m4836drawPathLG529CI$default(drawScope2, path2, j, f, new Stroke(drawScope2.m7091toPx0680j_4(f3), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 48, (Object) null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.m4807setSizeuvyYCjk(r11);
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }
}
