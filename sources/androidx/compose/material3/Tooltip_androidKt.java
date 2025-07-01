package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"PlainTooltip", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-7QI4Sbk", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-yDvdmqw", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "caretType", "Landroidx/compose/material3/CaretType;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-JKu-mZY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/material3/CaretType;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JJLandroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.android.kt */
public final class Tooltip_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* renamed from: PlainTooltip-7QI4Sbk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2853PlainTooltip7QI4Sbk(androidx.compose.material3.TooltipScope r28, androidx.compose.ui.Modifier r29, long r30, androidx.compose.ui.graphics.Shape r32, long r33, long r35, float r37, float r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r1 = r28
            r12 = r39
            r13 = r41
            r14 = r42
            r0 = 1407069716(0x53de2e14, float:1.9085116E12)
            r2 = r40
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(PlainTooltip)P(4,0:c#ui.unit.DpSize,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)208@8412L26,209@8482L24,211@8552L26,96@3876L606,90@3685L797:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r14
            if (r3 == 0) goto L_0x001e
            r3 = r13 | 6
            goto L_0x0037
        L_0x001e:
            r3 = r13 & 6
            if (r3 != 0) goto L_0x0036
            r3 = r13 & 8
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changed((java.lang.Object) r1)
            goto L_0x002f
        L_0x002b:
            boolean r3 = r2.changedInstance(r1)
        L_0x002f:
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r3 = r3 | r13
            goto L_0x0037
        L_0x0036:
            r3 = r13
        L_0x0037:
            r4 = r14 & 1
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x0051
            r5 = r29
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r29
        L_0x0053:
            r6 = r13 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x006a
            r6 = r14 & 2
            r8 = r30
            if (r6 != 0) goto L_0x0066
            boolean r6 = r2.changed((long) r8)
            if (r6 == 0) goto L_0x0066
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r3 = r3 | r6
            goto L_0x006c
        L_0x006a:
            r8 = r30
        L_0x006c:
            r6 = r13 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0085
            r6 = r14 & 4
            if (r6 != 0) goto L_0x007f
            r6 = r32
            boolean r10 = r2.changed((java.lang.Object) r6)
            if (r10 == 0) goto L_0x0081
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x007f:
            r6 = r32
        L_0x0081:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r3 = r3 | r10
            goto L_0x0087
        L_0x0085:
            r6 = r32
        L_0x0087:
            r10 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00a0
            r10 = r14 & 8
            if (r10 != 0) goto L_0x009a
            r10 = r33
            boolean r15 = r2.changed((long) r10)
            if (r15 == 0) goto L_0x009c
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009a:
            r10 = r33
        L_0x009c:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r3 = r3 | r15
            goto L_0x00a2
        L_0x00a0:
            r10 = r33
        L_0x00a2:
            r15 = 196608(0x30000, float:2.75506E-40)
            r16 = r13 & r15
            r40 = r15
            if (r16 != 0) goto L_0x00bd
            r16 = r14 & 16
            r7 = r35
            if (r16 != 0) goto L_0x00b9
            boolean r9 = r2.changed((long) r7)
            if (r9 == 0) goto L_0x00b9
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r3 = r3 | r9
            goto L_0x00bf
        L_0x00bd:
            r7 = r35
        L_0x00bf:
            r9 = r14 & 32
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r9 == 0) goto L_0x00ca
            r3 = r3 | r17
            r15 = r37
            goto L_0x00dd
        L_0x00ca:
            r17 = r13 & r17
            r15 = r37
            if (r17 != 0) goto L_0x00dd
            boolean r18 = r2.changed((float) r15)
            if (r18 == 0) goto L_0x00d9
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r3 = r3 | r18
        L_0x00dd:
            r18 = r14 & 64
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r18 == 0) goto L_0x00e8
            r3 = r3 | r19
            r0 = r38
            goto L_0x00fb
        L_0x00e8:
            r20 = r13 & r19
            r0 = r38
            if (r20 != 0) goto L_0x00fb
            boolean r21 = r2.changed((float) r0)
            if (r21 == 0) goto L_0x00f7
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r3 = r3 | r21
        L_0x00fb:
            r0 = r14 & 128(0x80, float:1.794E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r3 = r3 | r21
            goto L_0x0114
        L_0x0104:
            r0 = r13 & r21
            if (r0 != 0) goto L_0x0114
            boolean r0 = r2.changedInstance(r12)
            if (r0 == 0) goto L_0x0111
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r0
        L_0x0114:
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r3
            r21 = r4
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r4) goto L_0x0136
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0126
            goto L_0x0136
        L_0x0126:
            r2.skipToGroupEnd()
            r3 = r30
            r25 = r2
            r2 = r5
            r5 = r6
            r8 = r7
            r6 = r10
            r10 = r15
            r11 = r38
            goto L_0x02f2
        L_0x0136:
            r2.startDefaults()
            r0 = r13 & 1
            r22 = -57345(0xffffffffffff1fff, float:NaN)
            r23 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0173
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014a
            goto L_0x0173
        L_0x014a:
            r2.skipToGroupEnd()
            r0 = r14 & 2
            if (r0 == 0) goto L_0x0153
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0153:
            r0 = r14 & 4
            if (r0 == 0) goto L_0x0159
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0159:
            r0 = r14 & 8
            if (r0 == 0) goto L_0x015f
            r3 = r3 & r22
        L_0x015f:
            r0 = r14 & 16
            if (r0 == 0) goto L_0x0165
            r3 = r3 & r23
        L_0x0165:
            r22 = r38
            r16 = r6
            r21 = r15
            r0 = 0
            r9 = 256(0x100, float:3.59E-43)
            r6 = r3
            r3 = r30
            goto L_0x01d3
        L_0x0173:
            if (r21 == 0) goto L_0x017a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x017a:
            r0 = r14 & 2
            if (r0 == 0) goto L_0x0187
            androidx.compose.ui.unit.DpSize$Companion r0 = androidx.compose.ui.unit.DpSize.Companion
            long r24 = r0.m7218getUnspecifiedMYxV2XQ()
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0189
        L_0x0187:
            r24 = r30
        L_0x0189:
            r0 = r14 & 4
            r4 = 6
            if (r0 == 0) goto L_0x0197
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getPlainTooltipContainerShape(r2, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r0
        L_0x0197:
            r0 = r14 & 8
            if (r0 == 0) goto L_0x01a3
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            long r10 = r0.getPlainTooltipContentColor(r2, r4)
            r3 = r3 & r22
        L_0x01a3:
            r0 = r14 & 16
            if (r0 == 0) goto L_0x01b0
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            long r7 = r0.getPlainTooltipContainerColor(r2, r4)
            r0 = r3 & r23
            r3 = r0
        L_0x01b0:
            r0 = 0
            if (r9 == 0) goto L_0x01b9
            float r4 = (float) r0
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            goto L_0x01ba
        L_0x01b9:
            r4 = r15
        L_0x01ba:
            if (r18 == 0) goto L_0x01c8
            float r9 = (float) r0
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r9)
            r21 = r4
            r16 = r6
            r22 = r9
            goto L_0x01ce
        L_0x01c8:
            r22 = r38
            r21 = r4
            r16 = r6
        L_0x01ce:
            r9 = 256(0x100, float:3.59E-43)
            r6 = r3
            r3 = r24
        L_0x01d3:
            r2.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x01e5
            r15 = -1
            java.lang.String r0 = "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:73)"
            r9 = 1407069716(0x53de2e14, float:1.9085116E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r6, r15, r0)
        L_0x01e5:
            r0 = -333850415(0xffffffffec19d8d1, float:-7.4395815E26)
            r2.startReplaceGroup(r0)
            java.lang.String r0 = "76@3183L7,77@3242L7,78@3281L343"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r23 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r0 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x01fb
            r0 = 1
            goto L_0x01fc
        L_0x01fb:
            r0 = 0
        L_0x01fc:
            if (r0 == 0) goto L_0x02a6
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r9)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r13)
            java.lang.Object r9 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            android.content.res.Configuration r9 = (android.content.res.Configuration) r9
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            r15 = -333845325(0xffffffffec19ecb3, float:-7.443337E26)
            java.lang.String r14 = "CC(remember):Tooltip.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r14)
            boolean r14 = r2.changed((java.lang.Object) r0)
            boolean r15 = r2.changedInstance(r9)
            r14 = r14 | r15
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r6
            r15 = r15 ^ r40
            r30 = r0
            r0 = 131072(0x20000, float:1.83671E-40)
            if (r15 <= r0) goto L_0x024f
            boolean r15 = r2.changed((long) r7)
            if (r15 != 0) goto L_0x0253
        L_0x024f:
            r15 = r6 & r40
            if (r15 != r0) goto L_0x0255
        L_0x0253:
            r0 = 1
            goto L_0x0256
        L_0x0255:
            r0 = 0
        L_0x0256:
            r0 = r0 | r14
            r14 = r6 & 896(0x380, float:1.256E-42)
            r14 = r14 ^ 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r14 <= r15) goto L_0x0265
            boolean r14 = r2.changed((long) r3)
            if (r14 != 0) goto L_0x0269
        L_0x0265:
            r14 = r6 & 384(0x180, float:5.38E-43)
            if (r14 != r15) goto L_0x026c
        L_0x0269:
            r18 = 1
            goto L_0x026e
        L_0x026c:
            r18 = 0
        L_0x026e:
            r0 = r0 | r18
            java.lang.Object r14 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0282
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r14 != r0) goto L_0x027f
            goto L_0x0282
        L_0x027f:
            r17 = r7
            goto L_0x0297
        L_0x0282:
            androidx.compose.material3.Tooltip_androidKt$PlainTooltip$drawCaretModifier$1$1 r0 = new androidx.compose.material3.Tooltip_androidKt$PlainTooltip$drawCaretModifier$1$1
            r29 = r0
            r34 = r3
            r32 = r7
            r31 = r9
            r29.<init>(r30, r31, r32, r34)
            r17 = r32
            r14 = r0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r2.updateRememberedValue(r14)
        L_0x0297:
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.Modifier r0 = r1.drawCaret(r13, r14)
            androidx.compose.ui.Modifier r0 = r0.then(r5)
            r15 = r0
            goto L_0x02a9
        L_0x02a6:
            r17 = r7
            r15 = r5
        L_0x02a9:
            r2.endReplaceGroup()
            androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1 r0 = new androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
            r0.<init>(r10, r12)
            r7 = 54
            r8 = 1430116975(0x553dda6f, float:1.30466164E13)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r0, r2, r7)
            r24 = r0
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r0 = r6 >> 6
            r7 = r0 & 112(0x70, float:1.57E-43)
            r7 = r7 | r19
            int r6 = r6 >> 9
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r0
            r6 = r6 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r7
            r26 = r6 | r0
            r27 = 72
            r19 = 0
            r23 = 0
            r25 = r2
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e8:
            r2 = r5
            r6 = r10
            r5 = r16
            r8 = r17
            r10 = r21
            r11 = r22
        L_0x02f2:
            androidx.compose.runtime.ScopeUpdateScope r15 = r25.endRestartGroup()
            if (r15 == 0) goto L_0x0306
            androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2 r0 = new androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2
            r13 = r41
            r14 = r42
            r0.<init>(r1, r2, r3, r5, r6, r8, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0306:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt.m2853PlainTooltip7QI4Sbk(androidx.compose.material3.TooltipScope, androidx.compose.ui.Modifier, long, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0104  */
    /* renamed from: RichTooltip-yDvdmqw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2854RichTooltipyDvdmqw(androidx.compose.material3.TooltipScope r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, long r34, androidx.compose.ui.graphics.Shape r36, androidx.compose.material3.RichTooltipColors r37, float r38, float r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r30
            r11 = r40
            r12 = r42
            r13 = r43
            r0 = 1867454921(0x6f4f19c9, float:6.409457E28)
            r2 = r41
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(RichTooltip)P(3,7!1,1:c#ui.unit.DpSize,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)255@9959L25,257@10034L19,*148@5873L7,150@5944L11,150@5956L61,178@6991L1595,167@6622L1964:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r13
            if (r3 == 0) goto L_0x001e
            r3 = r12 | 6
            goto L_0x0037
        L_0x001e:
            r3 = r12 & 6
            if (r3 != 0) goto L_0x0036
            r3 = r12 & 8
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changed((java.lang.Object) r1)
            goto L_0x002f
        L_0x002b:
            boolean r3 = r2.changedInstance(r1)
        L_0x002f:
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r3 = r3 | r12
            goto L_0x0037
        L_0x0036:
            r3 = r12
        L_0x0037:
            r4 = r13 & 1
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0051
            r5 = r31
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r31
        L_0x0053:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r7 = r12 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x006d
            r7 = r32
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x0069
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r8
            goto L_0x006f
        L_0x006d:
            r7 = r32
        L_0x006f:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0076
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r9 = r12 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0089
            r9 = r33
            boolean r10 = r2.changedInstance(r9)
            if (r10 == 0) goto L_0x0085
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r3 = r3 | r10
            goto L_0x008b
        L_0x0089:
            r9 = r33
        L_0x008b:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00a2
            r10 = r13 & 8
            r14 = r34
            if (r10 != 0) goto L_0x009e
            boolean r10 = r2.changed((long) r14)
            if (r10 == 0) goto L_0x009e
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r3 = r3 | r10
            goto L_0x00a4
        L_0x00a2:
            r14 = r34
        L_0x00a4:
            r10 = 196608(0x30000, float:2.75506E-40)
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00bf
            r10 = r13 & 16
            if (r10 != 0) goto L_0x00b8
            r10 = r36
            boolean r16 = r2.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00b8:
            r10 = r36
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00c1
        L_0x00bf:
            r10 = r36
        L_0x00c1:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00db
            r16 = r13 & 32
            r0 = r37
            if (r16 != 0) goto L_0x00d6
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r3 = r3 | r17
            goto L_0x00dd
        L_0x00db:
            r0 = r37
        L_0x00dd:
            r17 = r13 & 64
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r17 == 0) goto L_0x00e8
            r3 = r3 | r18
            r0 = r38
            goto L_0x00fb
        L_0x00e8:
            r19 = r12 & r18
            r0 = r38
            if (r19 != 0) goto L_0x00fb
            boolean r19 = r2.changed((float) r0)
            if (r19 == 0) goto L_0x00f7
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r3 = r3 | r19
        L_0x00fb:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r3 = r3 | r19
            goto L_0x011a
        L_0x0104:
            r19 = r12 & r19
            if (r19 != 0) goto L_0x011a
            r19 = r0
            r0 = r39
            boolean r20 = r2.changed((float) r0)
            if (r20 == 0) goto L_0x0115
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r3 = r3 | r20
            goto L_0x011e
        L_0x011a:
            r19 = r0
            r0 = r39
        L_0x011e:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0127
            r3 = r3 | r20
            goto L_0x0137
        L_0x0127:
            r0 = r12 & r20
            if (r0 != 0) goto L_0x0137
            boolean r0 = r2.changedInstance(r11)
            if (r0 == 0) goto L_0x0134
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0136
        L_0x0134:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0136:
            r3 = r3 | r0
        L_0x0137:
            r0 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r0 & r3
            r20 = r3
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x015b
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0149
            goto L_0x015b
        L_0x0149:
            r2.skipToGroupEnd()
            r8 = r37
            r24 = r2
            r2 = r5
            r3 = r7
            r4 = r9
            r7 = r10
            r5 = r14
            r9 = r38
            r10 = r39
            goto L_0x0376
        L_0x015b:
            r2.startDefaults()
            r0 = r12 & 1
            r21 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = 6
            if (r0 == 0) goto L_0x0194
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016d
            goto L_0x0194
        L_0x016d:
            r2.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0178
            r0 = r20 & r21
            r20 = r0
        L_0x0178:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0181
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = r20 & r0
        L_0x0181:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x018a
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = r20 & r0
        L_0x018a:
            r0 = r37
            r21 = r39
            r4 = r20
            r20 = r38
            goto L_0x01f8
        L_0x0194:
            if (r4 == 0) goto L_0x019b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x019b:
            r0 = 0
            if (r6 == 0) goto L_0x019f
            r7 = r0
        L_0x019f:
            if (r8 == 0) goto L_0x01a2
            r9 = r0
        L_0x01a2:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x01b0
            androidx.compose.ui.unit.DpSize$Companion r0 = androidx.compose.ui.unit.DpSize.Companion
            long r14 = r0.m7218getUnspecifiedMYxV2XQ()
            r0 = r20 & r21
            r20 = r0
        L_0x01b0:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x01c0
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getRichTooltipContainerShape(r2, r3)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = r20 & r4
            r10 = r0
        L_0x01c0:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x01d2
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.material3.RichTooltipColors r0 = r0.richTooltipColors(r2, r3)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r20 & r4
            r20 = r4
            goto L_0x01d4
        L_0x01d2:
            r0 = r37
        L_0x01d4:
            if (r17 == 0) goto L_0x01dd
            androidx.compose.material3.tokens.ElevationTokens r4 = androidx.compose.material3.tokens.ElevationTokens.INSTANCE
            float r4 = r4.m3195getLevel0D9Ej5fM()
            goto L_0x01df
        L_0x01dd:
            r4 = r38
        L_0x01df:
            if (r19 == 0) goto L_0x01f0
            androidx.compose.material3.tokens.RichTooltipTokens r6 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            float r6 = r6.m3493getContainerElevationD9Ej5fM()
            r21 = r20
            r20 = r4
            r4 = r21
            r21 = r6
            goto L_0x01f8
        L_0x01f0:
            r21 = r20
            r20 = r4
            r4 = r21
            r21 = r39
        L_0x01f8:
            r2.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x020a
            r6 = -1
            java.lang.String r8 = "androidx.compose.material3.RichTooltip (Tooltip.android.kt:147)"
            r3 = 1867454921(0x6f4f19c9, float:6.409457E28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r6, r8)
        L_0x020a:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.SurfaceKt.getLocalAbsoluteTonalElevation()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r6, r8)
            java.lang.Object r3 = r2.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Dp r3 = (androidx.compose.ui.unit.Dp) r3
            float r3 = r3.m7125unboximpl()
            float r3 = r3 + r20
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            androidx.compose.material3.MaterialTheme r6 = androidx.compose.material3.MaterialTheme.INSTANCE
            r34 = r3
            r3 = 6
            androidx.compose.material3.ColorScheme r3 = r6.getColorScheme(r2, r3)
            long r16 = r0.m2381getContainerColor0d7_KjU()
            r6 = 0
            r35 = r2
            r31 = r3
            r36 = r6
            r32 = r16
            long r2 = androidx.compose.material3.ColorSchemeKt.m1884applyTonalElevationRFCenO8(r31, r32, r34, r35, r36)
            r6 = r35
            r38 = r10
            r10 = 1472746423(0x57c853b7, float:4.40523756E14)
            r6.startReplaceGroup(r10)
            java.lang.String r10 = "153@6122L7,154@6181L7,155@6220L341"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            r16 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r10 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            r31 = r10
            if (r31 == 0) goto L_0x0262
            r16 = 1
            goto L_0x0264
        L_0x0262:
            r16 = 0
        L_0x0264:
            if (r16 == 0) goto L_0x02fe
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r10 = r16
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r12, r8)
            java.lang.Object r10 = r6.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            r13 = r16
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r12, r8)
            java.lang.Object r8 = r6.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            android.content.res.Configuration r8 = (android.content.res.Configuration) r8
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r13 = 1472751513(0x57c86799, float:4.40694548E14)
            r27 = r0
            java.lang.String r0 = "CC(remember):Tooltip.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r13, r0)
            boolean r0 = r6.changed((java.lang.Object) r10)
            boolean r13 = r6.changedInstance(r8)
            r0 = r0 | r13
            boolean r13 = r6.changed((long) r2)
            r0 = r0 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r4
            r13 = r13 ^ 24576(0x6000, float:3.4438E-41)
            r31 = r0
            r0 = 16384(0x4000, float:2.2959E-41)
            if (r13 <= r0) goto L_0x02bf
            boolean r13 = r6.changed((long) r14)
            if (r13 != 0) goto L_0x02c3
        L_0x02bf:
            r13 = r4 & 24576(0x6000, float:3.4438E-41)
            if (r13 != r0) goto L_0x02c5
        L_0x02c3:
            r0 = 1
            goto L_0x02c6
        L_0x02c5:
            r0 = 0
        L_0x02c6:
            r0 = r31 | r0
            java.lang.Object r13 = r6.rememberedValue()
            if (r0 != 0) goto L_0x02d9
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r13 != r0) goto L_0x02d7
            goto L_0x02d9
        L_0x02d7:
            r2 = r14
            goto L_0x02f0
        L_0x02d9:
            androidx.compose.material3.Tooltip_androidKt$RichTooltip$drawCaretModifier$1$1 r0 = new androidx.compose.material3.Tooltip_androidKt$RichTooltip$drawCaretModifier$1$1
            r31 = r0
            r34 = r2
            r33 = r8
            r32 = r10
            r36 = r14
            r31.<init>(r32, r33, r34, r36)
            r2 = r36
            r13 = r0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r6.updateRememberedValue(r13)
        L_0x02f0:
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.Modifier r0 = r1.drawCaret(r12, r13)
            androidx.compose.ui.Modifier r0 = r0.then(r5)
            goto L_0x0302
        L_0x02fe:
            r27 = r0
            r2 = r14
            r0 = r5
        L_0x0302:
            r6.endReplaceGroup()
            float r8 = androidx.compose.material3.TooltipKt.getTooltipMinWidth()
            float r10 = androidx.compose.material3.TooltipKt.getRichTooltipMaxWidth()
            float r12 = androidx.compose.material3.TooltipKt.getTooltipMinHeight()
            r13 = 8
            r14 = 0
            r15 = 0
            r31 = r0
            r32 = r8
            r34 = r10
            r33 = r12
            r36 = r13
            r37 = r14
            r35 = r15
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m849sizeInqDBjuR0$default(r31, r32, r33, r34, r35, r36, r37)
            long r16 = r27.m2381getContainerColor0d7_KjU()
            androidx.compose.material3.Tooltip_androidKt$RichTooltip$1 r0 = new androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
            r8 = r27
            r0.<init>(r7, r9, r8, r11)
            r10 = 54
            r12 = 317290958(0x12e979ce, float:1.4734394E-27)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r13, r0, r6, r10)
            r23 = r0
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            int r0 = r4 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r18
            int r4 = r4 >> 9
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r4
            r0 = r0 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r10
            r25 = r0 | r4
            r26 = 72
            r18 = 0
            r22 = 0
            r15 = r38
            r24 = r6
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0368
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0368:
            r24 = r6
            r4 = r9
            r9 = r20
            r10 = r21
            r28 = r2
            r2 = r5
            r5 = r28
            r3 = r7
            r7 = r15
        L_0x0376:
            androidx.compose.runtime.ScopeUpdateScope r14 = r24.endRestartGroup()
            if (r14 == 0) goto L_0x038a
            androidx.compose.material3.Tooltip_androidKt$RichTooltip$2 r0 = new androidx.compose.material3.Tooltip_androidKt$RichTooltip$2
            r12 = r42
            r13 = r43
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x038a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt.m2854RichTooltipyDvdmqw(androidx.compose.material3.TooltipScope, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, long, androidx.compose.ui.graphics.Shape, androidx.compose.material3.RichTooltipColors, float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCaretWithPath-JKu-mZY  reason: not valid java name */
    public static final DrawResult m2856drawCaretWithPathJKumZY(CacheDrawScope cacheDrawScope, CaretType caretType, Density density, Configuration configuration, long j, long j2, LayoutCoordinates layoutCoordinates) {
        long j3;
        Density density2 = density;
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        Path Path = AndroidPath_androidKt.Path();
        if (layoutCoordinates2 != null) {
            int r3 = density2.m7086roundToPx0680j_4(DpSize.m7207getHeightD9Ej5fM(j2));
            int r4 = density2.m7086roundToPx0680j_4(DpSize.m7209getWidthD9Ej5fM(j2));
            int r5 = density2.m7086roundToPx0680j_4(Dp.m7111constructorimpl((float) configuration.screenWidthDp));
            int r0 = density2.m7086roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates2);
            float left = boundsInWindow.getLeft();
            float right = boundsInWindow.getRight();
            float top = boundsInWindow.getTop();
            float f = (float) 2;
            float f2 = (right + left) / f;
            float f3 = right - left;
            float r13 = Size.m4056getWidthimpl(cacheDrawScope.m3868getSizeNHjbRc());
            float r14 = Size.m4053getHeightimpl(cacheDrawScope.m3868getSizeNHjbRc());
            boolean z = (top - r14) - ((float) r0) < 0.0f;
            if (z) {
                r14 = 0.0f;
            }
            if (caretType == CaretType.Plain) {
                float f4 = (float) r5;
                j3 = (r13 / f) + f2 > f4 ? OffsetKt.Offset(r13 - (f4 - f2), r14) : OffsetKt.Offset(f2 - Math.max(left - ((Size.m4056getWidthimpl(cacheDrawScope.m3868getSizeNHjbRc()) / f) - (f3 / f)), 0.0f), r14);
            } else {
                long Offset = OffsetKt.Offset(f2 - left, r14);
                float f5 = (float) r5;
                if (left + r13 > f5) {
                    float f6 = right - r13;
                    Offset = OffsetKt.Offset(f2 - f6, r14);
                    if (f6 < 0.0f) {
                        float f7 = r13 / f;
                        float f8 = f3 / f;
                        if ((left - f7) + f8 <= 0.0f) {
                            j3 = OffsetKt.Offset(f2, r14);
                        } else {
                            j3 = (right + f7) - f8 >= f5 ? OffsetKt.Offset(r13 - (f5 - f2), r14) : OffsetKt.Offset(f7, r14);
                        }
                    }
                }
                j3 = Offset;
            }
            if (z) {
                Path.moveTo(Offset.m3987getXimpl(j3), Offset.m3988getYimpl(j3));
                float f9 = (float) (r4 / 2);
                Path.lineTo(Offset.m3987getXimpl(j3) + f9, Offset.m3988getYimpl(j3));
                Path.lineTo(Offset.m3987getXimpl(j3), Offset.m3988getYimpl(j3) - ((float) r3));
                Path.lineTo(Offset.m3987getXimpl(j3) - f9, Offset.m3988getYimpl(j3));
                Path.close();
            } else {
                Path.moveTo(Offset.m3987getXimpl(j3), Offset.m3988getYimpl(j3));
                float f10 = (float) (r4 / 2);
                Path.lineTo(Offset.m3987getXimpl(j3) + f10, Offset.m3988getYimpl(j3));
                Path.lineTo(Offset.m3987getXimpl(j3), Offset.m3988getYimpl(j3) + ((float) r3));
                Path.lineTo(Offset.m3987getXimpl(j3) - f10, Offset.m3988getYimpl(j3));
                Path.close();
            }
        }
        return cacheDrawScope.onDrawWithContent(new Tooltip_androidKt$drawCaretWithPath$4(layoutCoordinates2, Path, j));
    }
}
