package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
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
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001ab\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aq\u0010$\u001a\u00020\u00142\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0&H\u0003¢\u0006\u0002\u0010.\u001a\u0001\u0010/\u001a\u00020\u0014*\u00020\u001f2\u0006\u00100\u001a\u00020+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020+2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007¢\u0006\u0002\u00107\u001a8\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001aP\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\n\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u0002²\u0006\n\u0010I\u001a\u00020\u0018X\u0002²\u0006\n\u0010J\u001a\u00020\fX\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "()F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", "indicatorRipple", "Lkotlin/Function0;", "indicator", "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m7111constructorimpl((float) 12);
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m3343getContainerHeightD9Ej5fM();
    private static final float NavigationBarIndicatorToLabelPadding = Dp.m7111constructorimpl((float) 4);
    private static final float NavigationBarItemHorizontalPadding = Dp.m7111constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* renamed from: NavigationBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2249NavigationBarHsRjFd4(androidx.compose.ui.Modifier r23, long r24, long r26, float r28, androidx.compose.foundation.layout.WindowInsets r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r30
            r9 = r32
            r0 = 1596802123(0x5f2d444b, float:1.2485187E19)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)111@5198L14,112@5254L11,114@5412L12,122@5632L441,117@5479L594:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r33 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r9 | 6
            r4 = r3
            r3 = r23
            goto L_0x0030
        L_0x001c:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r23
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r9
            goto L_0x0030
        L_0x002d:
            r3 = r23
            r4 = r9
        L_0x0030:
            r5 = r9 & 48
            if (r5 != 0) goto L_0x0049
            r5 = r33 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r24
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0045
            r7 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r24
        L_0x0045:
            r7 = 16
        L_0x0047:
            r4 = r4 | r7
            goto L_0x004b
        L_0x0049:
            r5 = r24
        L_0x004b:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            r7 = r33 & 4
            r10 = r26
            if (r7 != 0) goto L_0x005e
            boolean r7 = r1.changed((long) r10)
            if (r7 == 0) goto L_0x005e
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r7
            goto L_0x0064
        L_0x0062:
            r10 = r26
        L_0x0064:
            r7 = r33 & 8
            if (r7 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r9 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r28
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r28
        L_0x0080:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r33 & 16
            if (r13 != 0) goto L_0x0093
            r13 = r29
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r13 = r29
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r29
        L_0x009b:
            r14 = r33 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r4 = r4 | r15
            goto L_0x00b3
        L_0x00a3:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00b3
            boolean r14 = r1.changedInstance(r8)
            if (r14 == 0) goto L_0x00b0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r14
        L_0x00b3:
            r14 = 74899(0x12493, float:1.04956E-40)
            r14 = r14 & r4
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00cf
            boolean r14 = r1.getSkipping()
            if (r14 != 0) goto L_0x00c3
            goto L_0x00cf
        L_0x00c3:
            r1.skipToGroupEnd()
            r20 = r1
            r1 = r3
            r2 = r5
            r4 = r10
            r6 = r12
            r7 = r13
            goto L_0x018f
        L_0x00cf:
            r1.startDefaults()
            r14 = r9 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r14 == 0) goto L_0x00fb
            boolean r14 = r1.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00e0
            goto L_0x00fb
        L_0x00e0:
            r1.skipToGroupEnd()
            r2 = r33 & 2
            if (r2 == 0) goto L_0x00e9
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00e9:
            r2 = r33 & 4
            if (r2 == 0) goto L_0x00ef
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ef:
            r2 = r33 & 16
            if (r2 == 0) goto L_0x00f4
            r4 = r4 & r15
        L_0x00f4:
            r14 = r10
            r16 = r12
            r10 = r3
            r3 = r13
        L_0x00f9:
            r12 = r5
            goto L_0x013f
        L_0x00fb:
            if (r2 == 0) goto L_0x0102
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0103
        L_0x0102:
            r2 = r3
        L_0x0103:
            r3 = r33 & 2
            r14 = 6
            if (r3 == 0) goto L_0x0110
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            long r5 = r3.getContainerColor(r1, r14)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0110:
            r3 = r33 & 4
            if (r3 == 0) goto L_0x0121
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r3 = r3.getColorScheme(r1, r14)
            long r10 = androidx.compose.material3.ColorSchemeKt.m1885contentColorFor4WTKRHQ(r3, r5)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x0121:
            if (r7 == 0) goto L_0x012a
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            float r3 = r3.m2234getElevationD9Ej5fM()
            r12 = r3
        L_0x012a:
            r3 = r33 & 16
            if (r3 == 0) goto L_0x0139
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r14)
            r4 = r4 & r15
            r14 = r10
            r16 = r12
            goto L_0x013d
        L_0x0139:
            r14 = r10
            r16 = r12
            r3 = r13
        L_0x013d:
            r10 = r2
            goto L_0x00f9
        L_0x013f:
            r1.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x014e
            r2 = -1
            java.lang.String r5 = "androidx.compose.material3.NavigationBar (NavigationBar.kt:116)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r2, r5)
        L_0x014e:
            androidx.compose.material3.NavigationBarKt$NavigationBar$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBar$1
            r0.<init>(r3, r8)
            r2 = 54
            r5 = 105663120(0x64c4a90, float:3.8422915E-35)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r6, r0, r1, r2)
            r19 = r0
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r0 = r4 & 14
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r2
            int r2 = r4 << 3
            r4 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r4
            r21 = r0 | r2
            r22 = 98
            r11 = 0
            r17 = 0
            r18 = 0
            r20 = r1
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0189
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0189:
            r7 = r3
            r1 = r10
            r2 = r12
            r4 = r14
            r6 = r16
        L_0x018f:
            androidx.compose.runtime.ScopeUpdateScope r11 = r20.endRestartGroup()
            if (r11 == 0) goto L_0x01a1
            androidx.compose.material3.NavigationBarKt$NavigationBar$2 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBar$2
            r10 = r33
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m2249NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0480  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationBarItem(androidx.compose.foundation.layout.RowScope r24, boolean r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, boolean r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.material3.NavigationBarItemColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r2 = r25
            r11 = r35
            r12 = r36
            r0 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            r1 = r34
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationBarItem)P(8,7,3,6,2,5)179@8344L8,185@8576L633,215@9873L33,229@10315L24,217@9912L2687:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x001f
            r1 = r11 | 6
            r3 = r1
            r1 = r24
            goto L_0x0033
        L_0x001f:
            r1 = r11 & 6
            if (r1 != 0) goto L_0x0030
            r1 = r24
            boolean r3 = r6.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002d
            r3 = 4
            goto L_0x002e
        L_0x002d:
            r3 = 2
        L_0x002e:
            r3 = r3 | r11
            goto L_0x0033
        L_0x0030:
            r1 = r24
            r3 = r11
        L_0x0033:
            r4 = r12 & 1
            if (r4 == 0) goto L_0x003a
            r3 = r3 | 48
            goto L_0x004a
        L_0x003a:
            r4 = r11 & 48
            if (r4 != 0) goto L_0x004a
            boolean r4 = r6.changed((boolean) r2)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r3 = r3 | r4
        L_0x004a:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0064
            r4 = r26
            boolean r5 = r6.changedInstance(r4)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r5
            goto L_0x0066
        L_0x0064:
            r4 = r26
        L_0x0066:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0080
            r5 = r27
            boolean r7 = r6.changedInstance(r5)
            if (r7 == 0) goto L_0x007c
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r7
            goto L_0x0082
        L_0x0080:
            r5 = r27
        L_0x0082:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0089
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0089:
            r8 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x009c
            r8 = r28
            boolean r10 = r6.changed((java.lang.Object) r8)
            if (r10 == 0) goto L_0x0098
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r10
            goto L_0x009e
        L_0x009c:
            r8 = r28
        L_0x009e:
            r10 = r12 & 16
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a6
            r3 = r3 | r13
            goto L_0x00b8
        L_0x00a6:
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b8
            r13 = r29
            boolean r14 = r6.changed((boolean) r13)
            if (r14 == 0) goto L_0x00b4
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r3 = r3 | r14
            goto L_0x00ba
        L_0x00b8:
            r13 = r29
        L_0x00ba:
            r14 = r12 & 32
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c2
            r3 = r3 | r15
            goto L_0x00d5
        L_0x00c2:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00d5
            r15 = r30
            boolean r16 = r6.changedInstance(r15)
            if (r16 == 0) goto L_0x00d0
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r3 = r3 | r16
            goto L_0x00d7
        L_0x00d5:
            r15 = r30
        L_0x00d7:
            r16 = r12 & 64
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r16 == 0) goto L_0x00e2
            r3 = r3 | r17
            r9 = r31
            goto L_0x00f5
        L_0x00e2:
            r17 = r11 & r17
            r9 = r31
            if (r17 != 0) goto L_0x00f5
            boolean r18 = r6.changed((boolean) r9)
            if (r18 == 0) goto L_0x00f1
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r3 = r3 | r18
        L_0x00f5:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0111
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x010a
            r0 = r32
            boolean r19 = r6.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x010c
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010a:
            r0 = r32
        L_0x010c:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r3 = r3 | r19
            goto L_0x0113
        L_0x0111:
            r0 = r32
        L_0x0113:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r19 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011c
            r3 = r3 | r19
            goto L_0x0132
        L_0x011c:
            r19 = r11 & r19
            if (r19 != 0) goto L_0x0132
            r19 = r0
            r0 = r33
            boolean r20 = r6.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x012d
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012f
        L_0x012d:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012f:
            r3 = r3 | r20
            goto L_0x0136
        L_0x0132:
            r19 = r0
            r0 = r33
        L_0x0136:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r20
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0155
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x0147
            goto L_0x0155
        L_0x0147:
            r6.skipToGroupEnd()
            r10 = r33
            r0 = r6
            r5 = r8
            r8 = r9
            r6 = r13
            r9 = r32
        L_0x0152:
            r7 = r15
            goto L_0x047a
        L_0x0155:
            r6.startDefaults()
            r0 = r11 & 1
            r34 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = 6
            r20 = r3
            r4 = 1
            if (r0 == 0) goto L_0x0180
            boolean r0 = r6.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016a
            goto L_0x0180
        L_0x016a:
            r6.skipToGroupEnd()
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0179
            r0 = r20 & r34
            r10 = r33
            r14 = r0
            r0 = r32
            goto L_0x01a6
        L_0x0179:
            r0 = r32
        L_0x017b:
            r10 = r33
            r14 = r20
            goto L_0x01a6
        L_0x0180:
            if (r7 == 0) goto L_0x0187
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = r0
        L_0x0187:
            if (r10 == 0) goto L_0x018a
            r13 = r4
        L_0x018a:
            if (r14 == 0) goto L_0x018d
            r15 = 0
        L_0x018d:
            if (r16 == 0) goto L_0x0190
            r9 = r4
        L_0x0190:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x019f
            androidx.compose.material3.NavigationBarItemDefaults r0 = androidx.compose.material3.NavigationBarItemDefaults.INSTANCE
            androidx.compose.material3.NavigationBarItemColors r0 = r0.colors(r6, r1)
            r7 = r20 & r34
            r20 = r7
            goto L_0x01a1
        L_0x019f:
            r0 = r32
        L_0x01a1:
            if (r19 == 0) goto L_0x017b
            r14 = r20
            r10 = 0
        L_0x01a6:
            r6.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x01b8
            r7 = -1
            java.lang.String r1 = "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:181)"
            r3 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r7, r1)
        L_0x01b8:
            r1 = -103235253(0xfffffffff9d8c14b, float:-1.4068207E35)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "183@8495L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            java.lang.String r1 = "CC(remember):NavigationBar.kt#9igjgp"
            if (r10 != 0) goto L_0x01e6
            r3 = -103234602(0xfffffffff9d8c3d6, float:-1.4068852E35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r1)
            java.lang.Object r3 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r3 != r7) goto L_0x01e0
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r3)
        L_0x01e0:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            goto L_0x01e7
        L_0x01e6:
            r3 = r10
        L_0x01e7:
            r6.endReplaceGroup()
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1 r7 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
            r29 = r0
            r30 = r2
            r34 = r5
            r28 = r7
            r33 = r9
            r31 = r13
            r32 = r15
            r28.<init>(r29, r30, r31, r32, r33, r34)
            r0 = r28
            r5 = r29
            r7 = -1419576100(0xffffffffab62fcdc, float:-8.064224E-13)
            r30 = r3
            r3 = 54
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r4, r0, r6, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7 = -103209106(0xfffffffff9d9276e, float:-1.4094102E35)
            r6.startReplaceGroup(r7)
            java.lang.String r7 = "*200@9305L535"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            if (r15 != 0) goto L_0x021f
            r18 = r0
            r0 = 0
            goto L_0x022f
        L_0x021f:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1 r7 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
            r7.<init>(r5, r2, r13, r15)
            r18 = r0
            r0 = 1644987592(0x620c84c8, float:6.48028E20)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r4, r7, r6, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x022f:
            r6.endReplaceGroup()
            r7 = -103190512(0xfffffffff9d97010, float:-1.4112516E35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r1)
            java.lang.Object r7 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r20.getEmpty()
            r4 = 0
            if (r7 != r3) goto L_0x024c
            androidx.compose.runtime.MutableIntState r7 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r4)
            r6.updateRememberedValue(r7)
        L_0x024c:
            r3 = r7
            androidx.compose.runtime.MutableIntState r3 = (androidx.compose.runtime.MutableIntState) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.semantics.Role$Companion r7 = androidx.compose.ui.semantics.Role.Companion
            int r7 = r7.m6373getTabo7Vup1c()
            r21 = 0
            androidx.compose.ui.semantics.Role r7 = androidx.compose.ui.semantics.Role.m6360boximpl(r7)
            r34 = r26
            r29 = r2
            r33 = r7
            r28 = r8
            r32 = r13
            r31 = r21
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableKt.m1108selectableO2vRcR0(r28, r29, r30, r31, r32, r33, r34)
            r22 = r28
            r13 = r30
            r21 = r32
            r7 = 0
            float r8 = NavigationBarHeight
            r23 = r0
            r0 = 1
            r4 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m830defaultMinSizeVpY3zN4$default(r2, r7, r8, r0, r4)
            r0 = 2
            r4 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            r28 = r24
            r32 = r0
            r29 = r2
            r33 = r4
            r30 = r7
            r31 = r8
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.weight$default(r28, r29, r30, r31, r32, r33)
            r2 = -103176377(0xfffffffff9d9a747, float:-1.4126515E35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r1)
            java.lang.Object r2 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x02b0
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$1$1 r2 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$1$1
            r2.<init>(r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r6.updateRememberedValue(r2)
        L_0x02b0:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r0, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getCenter()
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r7 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r7)
            r4 = 1
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r2, r4)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r8 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r8)
            r7 = 0
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r7)
            androidx.compose.runtime.CompositionLocalMap r7 = r6.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r20.getConstructor()
            r29 = r1
            r1 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r30 = r3
            java.lang.String r3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r3)
            androidx.compose.runtime.Applier r1 = r6.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x02fe
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02fe:
            r6.startReusableNode()
            boolean r1 = r6.getInserting()
            if (r1 == 0) goto L_0x030b
            r6.createNode(r4)
            goto L_0x030e
        L_0x030b:
            r6.useNode()
        L_0x030e:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3675constructorimpl(r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r2, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r3 = r1.getInserting()
            if (r3 != 0) goto L_0x033e
            java.lang.Object r3 = r1.rememberedValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x034c
        L_0x033e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.apply(r3, r2)
        L_0x034c:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r0, r2)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1652122706(0xffffffff9d869bae, float:-3.5630474E-21)
            java.lang.String r1 = "C234@10492L157,*243@10933L7,249@11215L128,256@11558L293,264@11900L395,281@12555L27,275@12305L288:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            if (r25 == 0) goto L_0x036e
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x036f
        L_0x036e:
            r0 = 0
        L_0x036f:
            r1 = r0
            r0 = 100
            r2 = 6
            r4 = 0
            r7 = 0
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r7, r4, r2, r4)
            r2 = r0
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r7 = 48
            r8 = 28
            r3 = 0
            r19 = r4
            r4 = 0
            r0 = r5
            r5 = 0
            r16 = r30
            r33 = r9
            r28 = r10
            r10 = r19
            r9 = r29
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            java.lang.Object r2 = r6.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.material3.tokens.NavigationBarTokens r3 = androidx.compose.material3.tokens.NavigationBarTokens.INSTANCE
            float r3 = r3.m3341getActiveIndicatorWidthD9Ej5fM()
            int r3 = r2.m7086roundToPx0680j_4(r3)
            int r4 = NavigationBarItem$lambda$3(r16)
            int r4 = r4 - r3
            float r3 = (float) r4
            r4 = 2
            float r4 = (float) r4
            float r3 = r3 / r4
            float r4 = IndicatorVerticalOffset
            float r2 = r2.m7091toPx0680j_4(r4)
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r2)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r4 = 2024938414(0x78b21bae, float:2.8899695E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r9)
            boolean r4 = r6.changed((java.lang.Object) r13)
            boolean r5 = r6.changed((long) r2)
            r4 = r4 | r5
            java.lang.Object r5 = r6.rememberedValue()
            if (r4 != 0) goto L_0x03e7
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x03f2
        L_0x03e7:
            androidx.compose.material3.internal.MappedInteractionSource r5 = new androidx.compose.material3.internal.MappedInteractionSource
            r4 = r13
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            r5.<init>(r4, r2, r10)
            r6.updateRememberedValue(r5)
        L_0x03f2:
            androidx.compose.material3.internal.MappedInteractionSource r5 = (androidx.compose.material3.internal.MappedInteractionSource) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1 r2 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
            r2.<init>(r5)
            r3 = 691730997(0x293afa35, float:4.1517317E-14)
            r4 = 54
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r5, r2, r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1 r3 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1
            r3.<init>(r1, r0)
            r7 = -474426875(0xffffffffe3b8d205, float:-6.818669E21)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r5, r3, r6, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2024981193(0x78b2c2c9, float:2.900561E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r9)
            boolean r4 = r6.changed((java.lang.Object) r1)
            java.lang.Object r5 = r6.rememberedValue()
            if (r4 != 0) goto L_0x042e
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x0439
        L_0x042e:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1 r4 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1
            r4.<init>(r1)
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6.updateRememberedValue(r5)
        L_0x0439:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            int r1 = r14 >> 9
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r8 = r1 | 438(0x1b6, float:6.14E-43)
            r1 = r2
            r2 = r3
            r7 = r6
            r3 = r18
            r4 = r23
            r6 = r5
            r5 = r33
            NavigationBarItemLayout(r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x046f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x046f:
            r10 = r28
            r9 = r0
            r8 = r5
            r0 = r6
            r6 = r21
            r5 = r22
            goto L_0x0152
        L_0x047a:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 == 0) goto L_0x0492
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0492:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int NavigationBarItem$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItemLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, Function0<Float> function0, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z2 = z;
        Function0<Float> function02 = function0;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1427075886);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItemLayout)P(4,3,2,5)532@23467L1717,517@23004L2180:NavigationBar.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function25) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function28) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1427075886, i2, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:516)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -96239762, "CC(remember):NavigationBar.kt#9igjgp");
            int i4 = 458752 & i2;
            int i5 = 57344 & i2;
            boolean z3 = (i4 == 131072) | ((i2 & 7168) == 2048) | (i5 == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationBarKt$NavigationBarItemLayout$2$1(function02, function28, z2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i6 = i2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r7, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r7, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -656695659, "C518@23021L17,519@23047L11,521@23068L50:NavigationBar.kt#uh7d8r");
            function25.invoke(startRestartGroup, Integer.valueOf(i6 & 14));
            function26.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, IconLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r1 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r1, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r1.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r1, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2034219770, "C521@23110L6:NavigationBar.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(1087198243);
            ComposerKt.sourceInformation(startRestartGroup, "526@23253L60,524@23161L288");
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1087201972, "CC(remember):NavigationBar.kt#9igjgp");
                boolean z4 = (i4 == 131072) | (i5 == 16384);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new NavigationBarKt$NavigationBarItemLayout$1$2$1(z2, function02);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier r0 = PaddingKt.m777paddingVpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) rememberedValue2), Dp.m7111constructorimpl(NavigationBarItemHorizontalPadding / ((float) 2)), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r4 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3682setimpl(r4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033904283, "C529@23428L7:NavigationBar.kt#uh7d8r");
                function28 = function24;
                function28.invoke(startRestartGroup, Integer.valueOf((i6 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                function28 = function24;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationBarKt$NavigationBarItemLayout$3(function2, function22, function27, function28, z2, function02, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m2252placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        int r1 = Constraints.m7052getMaxWidthimpl(j);
        int r2 = ConstraintsKt.m7068constrainHeightK40F9xA(j, measureScope.m7086roundToPx0680j_4(NavigationBarHeight));
        int i = r1;
        int i2 = r2;
        Placeable placeable4 = placeable;
        Placeable placeable5 = placeable3;
        return MeasureScope.layout$default(measureScope, i, i2, (Map) null, new NavigationBarKt$placeIcon$1(placeable5, placeable4, (r1 - placeable.getWidth()) / 2, (r2 - placeable.getHeight()) / 2, placeable2, (r1 - placeable2.getWidth()) / 2, (r2 - placeable2.getHeight()) / 2, i, i2), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m2253placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        float f2;
        MeasureScope measureScope2 = measureScope;
        float f3 = IndicatorVerticalPadding;
        float height = ((float) placeable2.getHeight()) + measureScope2.m7091toPx0680j_4(f3);
        float f4 = NavigationBarIndicatorToLabelPadding;
        float r0 = height + measureScope2.m7091toPx0680j_4(f4) + ((float) placeable.getHeight());
        float f5 = (float) 2;
        float coerceAtLeast = RangesKt.coerceAtLeast((((float) Constraints.m7053getMinHeightimpl(j)) - r0) / f5, measureScope2.m7091toPx0680j_4(f3));
        float f6 = r0 + (coerceAtLeast * f5);
        if (z) {
            f2 = coerceAtLeast;
        } else {
            f2 = (f6 - ((float) placeable2.getHeight())) / f5;
        }
        float f7 = (f2 - coerceAtLeast) * (((float) 1) - f);
        float height2 = ((float) placeable2.getHeight()) + coerceAtLeast + measureScope2.m7091toPx0680j_4(f3) + measureScope2.m7091toPx0680j_4(f4);
        int r14 = Constraints.m7052getMaxWidthimpl(j);
        int width = (r14 - placeable.getWidth()) / 2;
        int width2 = (r14 - placeable2.getWidth()) / 2;
        int width3 = (r14 - placeable3.getWidth()) / 2;
        float r13 = coerceAtLeast - measureScope2.m7091toPx0680j_4(f3);
        Placeable placeable5 = placeable4;
        boolean z2 = z;
        float f8 = f;
        return MeasureScope.layout$default(measureScope, r14, MathKt.roundToInt(f6), (Map) null, new NavigationBarKt$placeLabelAndIcon$1(placeable5, z2, f8, placeable, width, height2, f7, placeable2, width2, coerceAtLeast, placeable3, width3, r13, r14, measureScope2), 4, (Object) null);
    }

    static {
        float f = (float) 2;
        IndicatorHorizontalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(NavigationBarTokens.INSTANCE.m3341getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m3344getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(NavigationBarTokens.INSTANCE.m3340getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m3344getIconSizeD9Ej5fM()) / f);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItem$lambda$4(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }
}
