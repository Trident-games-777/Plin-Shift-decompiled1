package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001aÍ\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00122\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0001\u0010.\u001a\u00020\u00102\u0006\u0010*\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0019\u001a\u00020\u001a2\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0006\u0010(\u001a\u00020)2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a6\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001aF\u0010A\u001a\u000207*\u0002082\u0006\u0010B\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aV\u0010E\u001a\u000207*\u0002082\u0006\u0010B\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010G\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020\bX\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "Landroidx/compose/ui/unit/Dp;", "F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationItemMinHeight", "getNavigationItemMinHeight", "()F", "NavigationItemMinWidth", "getNavigationItemMinWidth", "NavigationItem", "", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorWidth", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "colors", "Landroidx/compose/material3/NavigationItemColors;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "label", "badge", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NavigationItem-SHbi2eg", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationItemLayout", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "animationProgress", "", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;FFFFFLandroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "labelPlaceable", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationItem.kt */
public final class NavigationItemKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m7111constructorimpl((float) 12);
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationItemMinHeight = NavigationRailKt.getNavigationRailItemHeight();
    private static final float NavigationItemMinWidth = NavigationRailKt.getNavigationRailItemWidth();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: androidx.compose.material3.internal.MappedInteractionSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: NavigationItem-SHbi2eg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2290NavigationItemSHbi2eg(boolean r31, kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.text.TextStyle r34, androidx.compose.ui.graphics.Shape r35, float r36, float r37, float r38, float r39, float r40, float r41, androidx.compose.material3.NavigationItemColors r42, androidx.compose.ui.Modifier r43, boolean r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, int r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.runtime.Composer r49, int r50, int r51) {
        /*
            r1 = r31
            r7 = r36
            r15 = r45
            r8 = r46
            r14 = r47
            r6 = r48
            r9 = r50
            r10 = r51
            r0 = 547979956(0x20a982b4, float:2.8716206E-19)
            r2 = r49
            androidx.compose.runtime.Composer r11 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationItem)P(15,14,3,12,6,9:c#ui.unit.Dp,5:c#ui.unit.Dp,8:c#ui.unit.Dp,7:c#ui.unit.Dp,16:c#ui.unit.Dp,17:c#ui.unit.Dp,1,13,2,11!1,4:c#material3.NavigationItemIconPosition)254@10949L438,281@11981L33,294@12438L24,283@12020L2390:NavigationItem.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r9 & 6
            if (r2 != 0) goto L_0x002d
            boolean r2 = r11.changed((boolean) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r9
            goto L_0x002e
        L_0x002d:
            r2 = r9
        L_0x002e:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0042
            r4 = r32
            boolean r16 = r11.changedInstance(r4)
            if (r16 == 0) goto L_0x003d
            r16 = 32
            goto L_0x003f
        L_0x003d:
            r16 = 16
        L_0x003f:
            r2 = r2 | r16
            goto L_0x0044
        L_0x0042:
            r4 = r32
        L_0x0044:
            r3 = r9 & 384(0x180, float:5.38E-43)
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x005c
            r3 = r33
            boolean r18 = r11.changedInstance(r3)
            if (r18 == 0) goto L_0x0057
            r18 = r16
            goto L_0x0059
        L_0x0057:
            r18 = r17
        L_0x0059:
            r2 = r2 | r18
            goto L_0x005e
        L_0x005c:
            r3 = r33
        L_0x005e:
            r5 = r9 & 3072(0xc00, float:4.305E-42)
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r5 != 0) goto L_0x0076
            r5 = r34
            boolean r21 = r11.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x0071
            r21 = r19
            goto L_0x0073
        L_0x0071:
            r21 = r20
        L_0x0073:
            r2 = r2 | r21
            goto L_0x0078
        L_0x0076:
            r5 = r34
        L_0x0078:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x008c
            r13 = r35
            boolean r22 = r11.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x0087
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0089
        L_0x0087:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x0089:
            r2 = r2 | r22
            goto L_0x008e
        L_0x008c:
            r13 = r35
        L_0x008e:
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = r9 & r22
            if (r23 != 0) goto L_0x00a1
            boolean r23 = r11.changed((float) r7)
            if (r23 == 0) goto L_0x009d
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x009f
        L_0x009d:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x009f:
            r2 = r2 | r23
        L_0x00a1:
            r23 = 1572864(0x180000, float:2.204052E-39)
            r24 = r9 & r23
            r12 = r37
            if (r24 != 0) goto L_0x00b6
            boolean r25 = r11.changed((float) r12)
            if (r25 == 0) goto L_0x00b2
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b4
        L_0x00b2:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00b4:
            r2 = r2 | r25
        L_0x00b6:
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            r25 = r9 & r25
            r9 = r38
            if (r25 != 0) goto L_0x00cb
            boolean r25 = r11.changed((float) r9)
            if (r25 == 0) goto L_0x00c7
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00c9
        L_0x00c7:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x00c9:
            r2 = r2 | r25
        L_0x00cb:
            r25 = 100663296(0x6000000, float:2.4074124E-35)
            r25 = r50 & r25
            r9 = r39
            if (r25 != 0) goto L_0x00e0
            boolean r25 = r11.changed((float) r9)
            if (r25 == 0) goto L_0x00dc
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00de
        L_0x00dc:
            r25 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00de:
            r2 = r2 | r25
        L_0x00e0:
            r25 = 805306368(0x30000000, float:4.656613E-10)
            r25 = r50 & r25
            r9 = r40
            if (r25 != 0) goto L_0x00f5
            boolean r25 = r11.changed((float) r9)
            if (r25 == 0) goto L_0x00f1
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00f3
        L_0x00f1:
            r25 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00f3:
            r2 = r2 | r25
        L_0x00f5:
            r25 = r10 & 6
            r9 = r41
            if (r25 != 0) goto L_0x0109
            boolean r25 = r11.changed((float) r9)
            if (r25 == 0) goto L_0x0104
            r25 = 4
            goto L_0x0106
        L_0x0104:
            r25 = 2
        L_0x0106:
            r25 = r10 | r25
            goto L_0x010b
        L_0x0109:
            r25 = r10
        L_0x010b:
            r27 = r10 & 48
            r0 = r42
            if (r27 != 0) goto L_0x011e
            boolean r27 = r11.changed((java.lang.Object) r0)
            if (r27 == 0) goto L_0x011a
            r18 = 32
            goto L_0x011c
        L_0x011a:
            r18 = 16
        L_0x011c:
            r25 = r25 | r18
        L_0x011e:
            r0 = r10 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x0130
            r0 = r43
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x012b
            goto L_0x012d
        L_0x012b:
            r16 = r17
        L_0x012d:
            r25 = r25 | r16
            goto L_0x0132
        L_0x0130:
            r0 = r43
        L_0x0132:
            r0 = r10 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x0144
            r0 = r44
            boolean r16 = r11.changed((boolean) r0)
            if (r16 == 0) goto L_0x013f
            goto L_0x0141
        L_0x013f:
            r19 = r20
        L_0x0141:
            r25 = r25 | r19
            goto L_0x0146
        L_0x0144:
            r0 = r44
        L_0x0146:
            r0 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x0157
            boolean r0 = r11.changedInstance(r15)
            if (r0 == 0) goto L_0x0153
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0155
        L_0x0153:
            r0 = 8192(0x2000, float:1.14794E-41)
        L_0x0155:
            r25 = r25 | r0
        L_0x0157:
            r0 = r10 & r22
            if (r0 != 0) goto L_0x0168
            boolean r0 = r11.changedInstance(r8)
            if (r0 == 0) goto L_0x0164
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0166
        L_0x0164:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x0166:
            r25 = r25 | r0
        L_0x0168:
            r0 = r10 & r23
            if (r0 != 0) goto L_0x0179
            boolean r0 = r11.changed((int) r14)
            if (r0 == 0) goto L_0x0175
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0177
        L_0x0175:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x0177:
            r25 = r25 | r0
        L_0x0179:
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 & r10
            if (r0 != 0) goto L_0x018b
            boolean r0 = r11.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x0187
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0189
        L_0x0187:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x0189:
            r25 = r25 | r0
        L_0x018b:
            r0 = r25
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r2 & r16
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r3) goto L_0x01ad
            r1 = 4793491(0x492493, float:6.717112E-39)
            r1 = r1 & r0
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r3) goto L_0x01ad
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x01a7
            goto L_0x01ad
        L_0x01a7:
            r11.skipToGroupEnd()
            r3 = r11
            goto L_0x0477
        L_0x01ad:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01bb
            java.lang.String r1 = "androidx.compose.material3.NavigationItem (NavigationItem.kt:252)"
            r3 = 547979956(0x20a982b4, float:2.8716206E-19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r0, r1)
        L_0x01bb:
            r25 = r0
            androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1 r0 = new androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1
            r5 = r33
            r1 = r42
            r3 = r44
            r23 = r2
            r4 = r15
            r15 = 8388608(0x800000, float:1.17549435E-38)
            r2 = r31
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = -44329638(0xfffffffffd5b955a, float:-1.8242276E37)
            r2 = 1
            r3 = 54
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r2, r0, r11, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = -1735402128(0xffffffff988fdd70, float:-3.718823E-24)
            r11.startReplaceGroup(r1)
            java.lang.String r1 = "264@11453L51"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            if (r8 == 0) goto L_0x01f6
            androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1 r1 = new androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1
            r1.<init>(r8, r0)
            r0 = 1836184859(0x6d71f51b, float:4.6801376E27)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r2, r1, r11, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x01f6:
            r26 = r0
            r11.endReplaceGroup()
            r0 = -1735395524(0xffffffff988ff73c, float:-3.7214277E-24)
            r11.startReplaceGroup(r0)
            java.lang.String r0 = "*271@11650L298"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = 0
            if (r45 != 0) goto L_0x020b
            r8 = r2
            goto L_0x0226
        L_0x020b:
            r1 = r0
            androidx.compose.material3.NavigationItemKt$NavigationItem$styledLabel$1$1 r0 = new androidx.compose.material3.NavigationItemKt$NavigationItem$styledLabel$1$1
            r4 = r34
            r1 = r42
            r5 = r45
            r8 = r2
            r15 = r3
            r2 = r31
            r3 = r44
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = -254668050(0xfffffffff0d212ee, float:-5.201179E29)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r8, r0, r11, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x0226:
            r28 = r0
            r11.endReplaceGroup()
            r0 = -1735384277(0xffffffff9890232b, float:-3.725864E-24)
            java.lang.String r15 = "CC(remember):NavigationItem.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r15)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            r2 = 0
            if (r0 != r1) goto L_0x0247
            androidx.compose.runtime.MutableIntState r0 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r2)
            r11.updateRememberedValue(r0)
        L_0x0247:
            androidx.compose.runtime.MutableIntState r0 = (androidx.compose.runtime.MutableIntState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m6373getTabo7Vup1c()
            r3 = 0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m6360boximpl(r1)
            r1 = r31
            r4 = r44
            r8 = r0
            r9 = r2
            r2 = r6
            r6 = r32
            r0 = r43
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableKt.m1108selectableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            float r0 = NavigationItemMinWidth
            float r1 = NavigationItemMinHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m829defaultMinSizeVpY3zN4(r3, r0, r1)
            r1 = -1735369662(0xffffffff98905c42, float:-3.7316284E-24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r15)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x028a
            androidx.compose.material3.NavigationItemKt$NavigationItem$1$1 r1 = new androidx.compose.material3.NavigationItemKt$NavigationItem$1$1
            r1.<init>(r8)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r11.updateRememberedValue(r1)
        L_0x028a:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r0, r1)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r3)
            r2 = 1
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r2)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r9)
            androidx.compose.runtime.CompositionLocalMap r4 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r2)
            androidx.compose.runtime.Applier r2 = r11.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x02d3
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02d3:
            r11.startReusableNode()
            boolean r2 = r11.getInserting()
            if (r2 == 0) goto L_0x02e0
            r11.createNode(r5)
            goto L_0x02e3
        L_0x02e0:
            r11.useNode()
        L_0x02e3:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r2.getInserting()
            if (r4 != 0) goto L_0x0313
            java.lang.Object r4 = r2.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0321
        L_0x0313:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.updateRememberedValue(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.apply(r3, r1)
        L_0x0321:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r0, r1)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 872931531(0x3407e0cb, float:1.2654634E-7)
            java.lang.String r1 = "C299@12615L157,330@14002L27,323@13657L747:NavigationItem.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
            if (r31 == 0) goto L_0x0343
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0344
        L_0x0343:
            r0 = 0
        L_0x0344:
            r1 = 100
            r2 = 6
            r3 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r1, r9, r3, r2, r3)
            r16 = r1
            androidx.compose.animation.core.AnimationSpec r16 = (androidx.compose.animation.core.AnimationSpec) r16
            r21 = 48
            r22 = 28
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = r11
            r1 = r15
            r15 = r0
            r0 = 8388608(0x800000, float:1.17549435E-38)
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r15, r16, r17, r18, r19, r20, r21, r22)
            r3 = r20
            r4 = -1634400795(0xffffffff9e9505e5, float:-1.5778427E-20)
            r3.startReplaceGroup(r4)
            java.lang.String r4 = "*310@13207L7,318@13501L136"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            androidx.compose.material3.NavigationItemIconPosition$Companion r4 = androidx.compose.material3.NavigationItemIconPosition.Companion
            int r4 = r4.m2289getTopxw1Ddg()
            boolean r4 = androidx.compose.material3.NavigationItemIconPosition.m2284equalsimpl0(r14, r4)
            if (r4 == 0) goto L_0x03e6
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r5, r6)
            java.lang.Object r4 = r3.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            int r5 = NavigationItem_SHbi2eg$lambda$2(r8)
            int r6 = r4.m7086roundToPx0680j_4(r7)
            int r5 = r5 - r6
            float r5 = (float) r5
            r6 = 2
            float r6 = (float) r6
            float r5 = r5 / r6
            float r6 = IndicatorVerticalOffset
            float r4 = r4.m7091toPx0680j_4(r6)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r5, r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r6 = -1634380655(0xffffffff9e955491, float:-1.5810964E-20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r1)
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r25 & r6
            if (r6 != r0) goto L_0x03bc
            r29 = 1
            goto L_0x03be
        L_0x03bc:
            r29 = r9
        L_0x03be:
            boolean r0 = r3.changed((long) r4)
            r0 = r29 | r0
            java.lang.Object r6 = r3.rememberedValue()
            if (r0 != 0) goto L_0x03d2
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x03df
        L_0x03d2:
            androidx.compose.material3.internal.MappedInteractionSource r6 = new androidx.compose.material3.internal.MappedInteractionSource
            r0 = r48
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            r8 = 0
            r6.<init>(r0, r4, r8)
            r3.updateRememberedValue(r6)
        L_0x03df:
            r0 = r6
            androidx.compose.material3.internal.MappedInteractionSource r0 = (androidx.compose.material3.internal.MappedInteractionSource) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            goto L_0x03e8
        L_0x03e6:
            r8 = 0
            r0 = r8
        L_0x03e8:
            r3.endReplaceGroup()
            if (r0 == 0) goto L_0x03f0
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            goto L_0x03f4
        L_0x03f0:
            r0 = r48
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
        L_0x03f4:
            r9 = r0
            long r10 = r42.m2275getSelectedIndicatorColor0d7_KjU()
            r0 = -1634364732(0xffffffff9e9592c4, float:-1.583669E-20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            boolean r0 = r3.changed((java.lang.Object) r2)
            java.lang.Object r1 = r3.rememberedValue()
            if (r0 != 0) goto L_0x0411
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x041c
        L_0x0411:
            androidx.compose.material3.NavigationItemKt$NavigationItem$2$3$1 r0 = new androidx.compose.material3.NavigationItemKt$NavigationItem$2$3$1
            r0.<init>(r2)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r3.updateRememberedValue(r1)
        L_0x041c:
            r16 = r1
            kotlin.jvm.functions.Function0 r16 = (kotlin.jvm.functions.Function0) r16
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            int r0 = r23 >> 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            int r1 = r25 >> 6
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r23 << 3
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r23 >> 27
            r1 = r1 & 14
            int r2 = r25 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r24 = r1 | r2
            r18 = r38
            r19 = r39
            r20 = r40
            r21 = r41
            r23 = r0
            r22 = r3
            r17 = r12
            r12 = r13
            r13 = r26
            r15 = r28
            m2291NavigationItemLayoutKmRXDg(r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0477
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0477:
            androidx.compose.runtime.ScopeUpdateScope r0 = r3.endRestartGroup()
            if (r0 == 0) goto L_0x04b3
            r1 = r0
            androidx.compose.material3.NavigationItemKt$NavigationItem$3 r0 = new androidx.compose.material3.NavigationItemKt$NavigationItem$3
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r8 = r38
            r9 = r39
            r10 = r40
            r11 = r41
            r12 = r42
            r13 = r43
            r14 = r44
            r15 = r45
            r16 = r46
            r17 = r47
            r18 = r48
            r19 = r50
            r20 = r51
            r30 = r1
            r6 = r7
            r1 = r31
            r7 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r30
            r1.updateScope(r0)
        L_0x04b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationItemKt.m2290NavigationItemSHbi2eg(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, androidx.compose.ui.graphics.Shape, float, float, float, float, float, float, androidx.compose.material3.NavigationItemColors, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int NavigationItem_SHbi2eg$lambda$2(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationItemLayout-KmRX-Dg  reason: not valid java name */
    public static final void m2291NavigationItemLayoutKmRXDg(InteractionSource interactionSource, long j, Shape shape, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function0<Float> function0, float f, float f2, float f3, float f4, float f5, Composer composer, int i2, int i3) {
        int i4;
        int i5;
        Function0<Float> function02;
        int i6;
        MeasurePolicy measurePolicy;
        Composer composer2;
        InteractionSource interactionSource2 = interactionSource;
        long j2 = j;
        Shape shape2 = shape;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        int i7 = i;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        Function0<Float> function03 = function0;
        int i8 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1757687417);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationItemLayout)P(8,3:c#ui.graphics.Color,5,1,2:c#material3.NavigationItemIconPosition,9!1,4:c#ui.unit.Dp,7:c#ui.unit.Dp,6:c#ui.unit.Dp,10:c#ui.unit.Dp,11:c#ui.unit.Dp)356@14947L1719:NavigationItem.kt#uh7d8r");
        if ((i8 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) interactionSource2) ? 4 : 2) | i8;
        } else {
            i4 = i8;
        }
        int i9 = 16;
        if ((i8 & 48) == 0) {
            i4 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i8 & 384) == 0) {
            i4 |= startRestartGroup.changed((Object) shape2) ? 256 : 128;
        }
        if ((i8 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
        }
        if ((i8 & 24576) == 0) {
            i4 |= startRestartGroup.changed(i7) ? 16384 : 8192;
        }
        if ((196608 & i8) == 0) {
            i4 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i8) == 0) {
            i4 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((12582912 & i8) == 0) {
            i4 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        } else {
            float f6 = f;
        }
        float f7 = f2;
        if ((i8 & 100663296) == 0) {
            i4 |= startRestartGroup.changed(f7) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        float f8 = f3;
        if ((i8 & 805306368) == 0) {
            i4 |= startRestartGroup.changed(f8) ? 536870912 : 268435456;
        }
        float f9 = f4;
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(f9) ? 4 : 2);
        } else {
            i5 = i3;
        }
        float f10 = f5;
        if ((i3 & 48) == 0) {
            if (startRestartGroup.changed(f10)) {
                i9 = 32;
            }
            i5 |= i9;
        }
        int i10 = i5;
        if ((i4 & 306783379) == 306783378 && (i10 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function02 = function0;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757687417, i4, i10, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:355)");
            }
            if (function24 == null || NavigationItemIconPosition.m2284equalsimpl0(i7, NavigationItemIconPosition.Companion.m2289getTopxw1Ddg())) {
                i6 = i4;
                Function0<Float> function04 = function0;
                composer2 = startRestartGroup;
                function02 = function04;
                measurePolicy = new TopIconOrIconOnlyMeasurePolicy(function24 != null, function04, f, f2, f3, f5, (DefaultConstructorMarker) null);
            } else {
                i6 = i4;
                measurePolicy = new StartIconMeasurePolicy(function0, f, f7, f9, (DefaultConstructorMarker) null);
                composer2 = startRestartGroup;
                function02 = function0;
            }
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r6 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r6, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r6, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1690051920, "C362@15191L32,359@15031L207,369@15552L31,367@15456L292,375@15761L50:NavigationItem.kt#uh7d8r");
            startRestartGroup = composer2;
            String str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            String str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.Companion, IndicatorRippleLayoutIdTag), shape2), interactionSource2, RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0, startRestartGroup, 0, 7)), startRestartGroup, 0);
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, IndicatorLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -776750382, "CC(remember):NavigationItem.kt#9igjgp");
            boolean z = (i6 & 3670016) == 1048576;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationItemKt$NavigationItemLayout$1$1$1(function02);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BoxKt.Box(BackgroundKt.m247backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue), j2, shape2), startRestartGroup, 0);
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, IconLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str2);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r7, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r7.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r7, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 14502763, "C375@15803L6:NavigationItem.kt#uh7d8r");
            function23.invoke(startRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-776741606);
            ComposerKt.sourceInformation(startRestartGroup, "377@15861L52");
            if (function22 != null) {
                Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str2);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r0 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r0, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r0, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r0.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3682setimpl(r0, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 14602986, "C377@15904L7:NavigationItem.kt#uh7d8r");
                function24 = function22;
                function24.invoke(startRestartGroup, Integer.valueOf((i6 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                function24 = function22;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationItemKt$NavigationItemLayout$2(interactionSource2, j2, shape2, function23, i, function24, function02, f, f2, f3, f4, f5, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m2296placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        long j2 = j;
        int r4 = ConstraintsKt.m7069constrainWidthK40F9xA(j2, placeable2.getWidth());
        int r5 = ConstraintsKt.m7068constrainHeightK40F9xA(j2, placeable2.getHeight());
        return MeasureScope.layout$default(measureScope, r4, r5, (Map) null, new NavigationItemKt$placeIcon$1(placeable3, (r4 - placeable3.getWidth()) / 2, (r5 - placeable3.getHeight()) / 2, placeable, (r4 - placeable.getWidth()) / 2, (r5 - placeable.getHeight()) / 2, placeable2, (r4 - placeable2.getWidth()) / 2, (r5 - placeable2.getHeight()) / 2), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndTopIcon-qoqLrGI  reason: not valid java name */
    public static final MeasureResult m2298placeLabelAndTopIconqoqLrGI(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, float f, float f2, float f3) {
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        int r6 = ConstraintsKt.m7069constrainWidthK40F9xA(j2, Math.max(placeable.getWidth(), placeable3.getWidth()));
        int r1 = ConstraintsKt.m7068constrainHeightK40F9xA(j2, MathKt.roundToInt(((float) placeable3.getHeight()) + measureScope2.m7091toPx0680j_4(f4) + ((float) placeable.getHeight()) + (measureScope2.m7091toPx0680j_4(f6) * ((float) 2))));
        int r19 = measureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(f6 + f5));
        int width = (r6 - placeable2.getWidth()) / 2;
        int width2 = (r6 - placeable4.getWidth()) / 2;
        int r13 = r19 - measureScope2.m7086roundToPx0680j_4(f5);
        Placeable placeable5 = placeable2;
        return MeasureScope.layout$default(measureScope2, r6, r1, (Map) null, new NavigationItemKt$placeLabelAndTopIcon$1(placeable4, width2, r13, placeable, (r6 - placeable.getWidth()) / 2, r19 + placeable2.getHeight() + measureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(f4 + f5)), placeable5, width, r19, placeable3, (r6 - placeable3.getWidth()) / 2, r13), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndStartIcon-nru01g4  reason: not valid java name */
    public static final MeasureResult m2297placeLabelAndStartIconnru01g4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, float f) {
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        float f2 = f;
        int r4 = ConstraintsKt.m7069constrainWidthK40F9xA(j2, placeable3.getWidth());
        int r1 = ConstraintsKt.m7068constrainHeightK40F9xA(j2, placeable3.getHeight());
        int width = (r4 - placeable4.getWidth()) / 2;
        int height = (r1 - placeable4.getHeight()) / 2;
        int height2 = (r1 - placeable2.getHeight()) / 2;
        int height3 = (r1 - placeable.getHeight()) / 2;
        int width2 = (r4 - ((placeable2.getWidth() + measureScope2.m7086roundToPx0680j_4(f2)) + placeable.getWidth())) / 2;
        Placeable placeable5 = placeable2;
        return MeasureScope.layout$default(measureScope2, r4, r1, (Map) null, new NavigationItemKt$placeLabelAndStartIcon$1(placeable4, width, height, placeable, placeable2.getWidth() + width2 + measureScope2.m7086roundToPx0680j_4(f2), height3, placeable5, width2, height2, placeable3, (r4 - placeable3.getWidth()) / 2, (r1 - placeable3.getHeight()) / 2), 4, (Object) null);
    }

    public static final float getNavigationItemMinWidth() {
        return NavigationItemMinWidth;
    }

    public static final float getNavigationItemMinHeight() {
        return NavigationItemMinHeight;
    }

    /* access modifiers changed from: private */
    public static final void NavigationItem_SHbi2eg$lambda$3(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }
}
