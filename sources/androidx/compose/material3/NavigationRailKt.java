package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001az\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0001\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", "indicatorRipple", "indicator", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPaddingNoLabel;
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationRailHeaderPadding = Dp.m7111constructorimpl((float) 8);
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m3357getNoLabelActiveIndicatorHeightD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m3354getContainerWidthD9Ej5fM();
    private static final float NavigationRailVerticalPadding;

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* renamed from: NavigationRail-qi6gXK8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2314NavigationRailqi6gXK8(androidx.compose.ui.Modifier r23, long r24, long r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.foundation.layout.WindowInsets r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r30
            r9 = r32
            r0 = 118552648(0x710f848, float:1.0906319E-34)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)113@5242L14,114@5284L31,116@5431L12,123@5614L618,119@5501L731:NavigationRail.kt#uh7d8r"
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
            boolean r13 = r1.changedInstance(r12)
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
            goto L_0x0180
        L_0x00cf:
            r1.startDefaults()
            r14 = r9 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r14 == 0) goto L_0x00fa
            boolean r14 = r1.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00e0
            goto L_0x00fa
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
            r2 = r12
            r10 = r3
            r3 = r13
        L_0x00f8:
            r12 = r5
            goto L_0x0134
        L_0x00fa:
            if (r2 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0102
        L_0x0101:
            r2 = r3
        L_0x0102:
            r3 = r33 & 2
            r14 = 6
            if (r3 == 0) goto L_0x010f
            androidx.compose.material3.NavigationRailDefaults r3 = androidx.compose.material3.NavigationRailDefaults.INSTANCE
            long r5 = r3.getContainerColor(r1, r14)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x010f:
            r3 = r33 & 4
            if (r3 == 0) goto L_0x011e
            int r3 = r4 >> 3
            r3 = r3 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r5, r1, r3)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x011e:
            if (r7 == 0) goto L_0x0122
            r3 = 0
            r12 = r3
        L_0x0122:
            r3 = r33 & 16
            if (r3 == 0) goto L_0x012f
            androidx.compose.material3.NavigationRailDefaults r3 = androidx.compose.material3.NavigationRailDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r14)
            r4 = r4 & r15
            r14 = r10
            goto L_0x0131
        L_0x012f:
            r14 = r10
            r3 = r13
        L_0x0131:
            r10 = r2
            r2 = r12
            goto L_0x00f8
        L_0x0134:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0143
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.NavigationRail (NavigationRail.kt:118)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r5, r6)
        L_0x0143:
            androidx.compose.material3.NavigationRailKt$NavigationRail$1 r0 = new androidx.compose.material3.NavigationRailKt$NavigationRail$1
            r0.<init>(r3, r2, r8)
            r5 = 54
            r6 = -2092683357(0xffffffff83442fa3, float:-5.7653907E-37)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r0, r1, r5)
            r19 = r0
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r0 = r4 & 14
            r5 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r5
            int r4 = r4 << 3
            r5 = r4 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r21 = r0 | r4
            r22 = 114(0x72, float:1.6E-43)
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = r1
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017b:
            r6 = r2
            r7 = r3
            r1 = r10
            r2 = r12
            r4 = r14
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r11 = r20.endRestartGroup()
            if (r11 == 0) goto L_0x0192
            androidx.compose.material3.NavigationRailKt$NavigationRail$2 r0 = new androidx.compose.material3.NavigationRailKt$NavigationRail$2
            r10 = r33
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.m2314NavigationRailqi6gXK8(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationRailItem(boolean r24, kotlin.jvm.functions.Function0<kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, boolean r30, androidx.compose.material3.NavigationRailItemColors r31, androidx.compose.foundation.interaction.MutableInteractionSource r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r1 = r24
            r10 = r34
            r11 = r35
            r0 = -1533971045(0xffffffffa491759b, float:-6.308296E-17)
            r2 = r33
            androidx.compose.runtime.Composer r6 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationRailItem)P(8,7,3,6,2,5)179@8055L8,185@8288L633,215@9569L2776:NavigationRail.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r6.changed((boolean) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r10
            goto L_0x002b
        L_0x002a:
            r2 = r10
        L_0x002b:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r10 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r25
            boolean r4 = r6.changedInstance(r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r2 = r2 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r25
        L_0x0047:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r4 = r10 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0061
            r4 = r26
            boolean r5 = r6.changedInstance(r4)
            if (r5 == 0) goto L_0x005d
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r5
            goto L_0x0063
        L_0x0061:
            r4 = r26
        L_0x0063:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r7 = r10 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007d
            r7 = r27
            boolean r8 = r6.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0079
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r8
            goto L_0x007f
        L_0x007d:
            r7 = r27
        L_0x007f:
            r8 = r11 & 16
            if (r8 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0099
            r12 = r28
            boolean r13 = r6.changed((boolean) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r28
        L_0x009b:
            r13 = r11 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a3
            r2 = r2 | r14
            goto L_0x00b5
        L_0x00a3:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b5
            r14 = r29
            boolean r15 = r6.changedInstance(r14)
            if (r15 == 0) goto L_0x00b1
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r15
            goto L_0x00b7
        L_0x00b5:
            r14 = r29
        L_0x00b7:
            r15 = r11 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c2
            r2 = r2 | r16
            r9 = r30
            goto L_0x00d5
        L_0x00c2:
            r16 = r10 & r16
            r9 = r30
            if (r16 != 0) goto L_0x00d5
            boolean r17 = r6.changed((boolean) r9)
            if (r17 == 0) goto L_0x00d1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r2 = r2 | r17
        L_0x00d5:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00f1
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ea
            r0 = r31
            boolean r18 = r6.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ea:
            r0 = r31
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r2 = r2 | r18
            goto L_0x00f3
        L_0x00f1:
            r0 = r31
        L_0x00f3:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fc
            r2 = r2 | r18
            goto L_0x0112
        L_0x00fc:
            r18 = r10 & r18
            if (r18 != 0) goto L_0x0112
            r18 = r0
            r0 = r32
            boolean r19 = r6.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x010d
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010d:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r2 = r2 | r19
            goto L_0x0116
        L_0x0112:
            r18 = r0
            r0 = r32
        L_0x0116:
            r19 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r19
            r1 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r1) goto L_0x0135
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x0127
            goto L_0x0135
        L_0x0127:
            r6.skipToGroupEnd()
            r8 = r31
            r4 = r7
            r7 = r9
            r5 = r12
            r9 = r32
        L_0x0131:
            r0 = r6
            r6 = r14
            goto L_0x0425
        L_0x0135:
            r6.startDefaults()
            r0 = r10 & 1
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = 6
            r33 = r5
            r5 = 1
            if (r0 == 0) goto L_0x0158
            boolean r0 = r6.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014a
            goto L_0x0158
        L_0x014a:
            r6.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0152
            r2 = r2 & r1
        L_0x0152:
            r0 = r31
        L_0x0154:
            r13 = r32
            r15 = r2
            goto L_0x017a
        L_0x0158:
            if (r33 == 0) goto L_0x015f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r7 = r0
        L_0x015f:
            if (r8 == 0) goto L_0x0162
            r12 = r5
        L_0x0162:
            if (r13 == 0) goto L_0x0165
            r14 = 0
        L_0x0165:
            if (r15 == 0) goto L_0x0168
            r9 = r5
        L_0x0168:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0174
            androidx.compose.material3.NavigationRailItemDefaults r0 = androidx.compose.material3.NavigationRailItemDefaults.INSTANCE
            androidx.compose.material3.NavigationRailItemColors r0 = r0.colors(r6, r3)
            r2 = r2 & r1
            goto L_0x0176
        L_0x0174:
            r0 = r31
        L_0x0176:
            if (r18 == 0) goto L_0x0154
            r15 = r2
            r13 = 0
        L_0x017a:
            r6.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x018c
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:181)"
            r8 = -1533971045(0xffffffffa491759b, float:-6.308296E-17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r15, r1, r2)
        L_0x018c:
            r1 = -782588008(0xffffffffd15aa798, float:-5.8694664E10)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "183@8207L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            java.lang.String r1 = "CC(remember):NavigationRail.kt#9igjgp"
            if (r13 != 0) goto L_0x01ba
            r2 = -782587357(0xffffffffd15aaa23, float:-5.8697331E10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r1)
            java.lang.Object r2 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r2 != r8) goto L_0x01b4
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r2)
        L_0x01b4:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            goto L_0x01bb
        L_0x01ba:
            r2 = r13
        L_0x01bb:
            r6.endReplaceGroup()
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1 r8 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
            r29 = r24
            r33 = r26
            r28 = r0
            r27 = r8
            r32 = r9
            r30 = r12
            r31 = r14
            r27.<init>(r28, r29, r30, r31, r32, r33)
            r0 = r29
            r27 = r7
            r7 = r28
            r3 = -1023357515(0xffffffffc300cdb5, float:-128.80354)
            r4 = 54
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r5, r8, r6, r4)
            r19 = r3
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r3 = -782561860(0xffffffffd15b0dbc, float:-5.8801766E10)
            r6.startReplaceGroup(r3)
            java.lang.String r3 = "*200@9017L536"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            if (r14 != 0) goto L_0x01f4
            r20 = 0
            goto L_0x0204
        L_0x01f4:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1 r3 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
            r3.<init>(r7, r0, r12, r14)
            r8 = -105269599(0xfffffffff9b9b6a1, float:-1.2053488E35)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r5, r3, r6, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r20 = r3
        L_0x0204:
            r6.endReplaceGroup()
            androidx.compose.ui.semantics.Role$Companion r3 = androidx.compose.ui.semantics.Role.Companion
            int r3 = r3.m6373getTabo7Vup1c()
            r8 = 0
            androidx.compose.ui.semantics.Role r3 = androidx.compose.ui.semantics.Role.m6360boximpl(r3)
            r33 = r25
            r28 = r0
            r29 = r2
            r32 = r3
            r30 = r8
            r31 = r12
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m1108selectableO2vRcR0(r27, r28, r29, r30, r31, r32, r33)
            r21 = r27
            r12 = r29
            r22 = r31
            float r2 = NavigationRailItemHeight
            r3 = 0
            r8 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m830defaultMinSizeVpY3zN4$default(r0, r3, r2, r5, r8)
            float r2 = NavigationRailItemWidth
            r4 = 2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m852widthInVpY3zN4$default(r0, r2, r3, r4, r8)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getCenter()
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r8, r3)
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r4, r5)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r8 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r8)
            r4 = 0
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r4)
            androidx.compose.runtime.CompositionLocalMap r5 = r6.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r23.getConstructor()
            r30 = r1
            r1 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r31 = r2
            java.lang.String r2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r2)
            androidx.compose.runtime.Applier r1 = r6.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x027b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x027b:
            r6.startReusableNode()
            boolean r1 = r6.getInserting()
            if (r1 == 0) goto L_0x0288
            r6.createNode(r4)
            goto L_0x028b
        L_0x0288:
            r6.useNode()
        L_0x028b:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3675constructorimpl(r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r3 = r1.getInserting()
            if (r3 != 0) goto L_0x02bb
            java.lang.Object r3 = r1.rememberedValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x02c9
        L_0x02bb:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.apply(r3, r2)
        L_0x02c9:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r0, r2)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 584386773(0x22d508d5, float:5.7743117E-18)
            java.lang.String r1 = "C231@10130L157,*240@10571L7,246@10874L128,260@11450L261,268@11760L280,282@12301L27,276@12050L289:NavigationRail.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            if (r24 == 0) goto L_0x02ec
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = r0
            goto L_0x02ed
        L_0x02ec:
            r1 = 0
        L_0x02ed:
            r0 = 150(0x96, float:2.1E-43)
            r2 = 0
            r3 = 6
            r8 = 0
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r2, r8, r3, r8)
            r2 = r0
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r0 = r7
            r7 = 48
            r18 = r8
            r8 = 28
            r17 = r3
            r3 = 0
            r4 = 0
            r5 = 0
            r10 = r30
            r32 = r9
            r11 = 0
            r9 = r0
            r0 = r31
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            java.lang.Object r2 = r6.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            int r0 = r2.m7086roundToPx0680j_4(r0)
            androidx.compose.material3.tokens.NavigationRailTokens r3 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            float r3 = r3.m3352getActiveIndicatorWidthD9Ej5fM()
            int r2 = r2.m7086roundToPx0680j_4(r3)
            int r0 = r0 - r2
            float r0 = (float) r0
            r4 = 2
            float r2 = (float) r4
            float r0 = r0 / r2
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r0, r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = -119672869(0xfffffffff8ddefdb, float:-3.6011327E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r10)
            boolean r0 = r6.changed((java.lang.Object) r12)
            boolean r4 = r6.changed((long) r2)
            r0 = r0 | r4
            java.lang.Object r4 = r6.rememberedValue()
            if (r0 != 0) goto L_0x035e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x036a
        L_0x035e:
            androidx.compose.material3.internal.MappedInteractionSource r4 = new androidx.compose.material3.internal.MappedInteractionSource
            r0 = r12
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            r8 = 0
            r4.<init>(r0, r2, r8)
            r6.updateRememberedValue(r4)
        L_0x036a:
            androidx.compose.material3.internal.MappedInteractionSource r4 = (androidx.compose.material3.internal.MappedInteractionSource) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            if (r14 == 0) goto L_0x038b
            r0 = 585295320(0x22e2e5d8, float:6.150078E-18)
            r6.startReplaceGroup(r0)
            java.lang.String r0 = "252@11124L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            androidx.compose.material3.tokens.NavigationRailTokens r0 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r0 = r0.getActiveIndicatorShape()
            r3 = 6
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.material3.ShapesKt.getValue(r0, r6, r3)
            r6.endReplaceGroup()
            goto L_0x03a4
        L_0x038b:
            r3 = 6
            r0 = 585379857(0x22e43011, float:6.1850416E-18)
            r6.startReplaceGroup(r0)
            java.lang.String r0 = "254@11216L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            androidx.compose.material3.tokens.NavigationRailTokens r0 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r0 = r0.getNoLabelActiveIndicatorShape()
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.material3.ShapesKt.getValue(r0, r6, r3)
            r6.endReplaceGroup()
        L_0x03a4:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicatorRipple$1 r2 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicatorRipple$1
            r2.<init>(r0, r4)
            r4 = 211026382(0xc9401ce, float:2.2804097E-31)
            r5 = 54
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r7, r2, r6, r5)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicator$1 r4 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicator$1
            r4.<init>(r1, r9, r0)
            r0 = -1862011490(0xffffffff9103f59e, float:-1.0409764E-28)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r7, r4, r6, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4 = -119627306(0xfffffffff8dea1d6, float:-3.6124135E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r10)
            boolean r4 = r6.changed((java.lang.Object) r1)
            java.lang.Object r5 = r6.rememberedValue()
            if (r4 != 0) goto L_0x03db
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x03e6
        L_0x03db:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$2$1 r4 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$2$1
            r4.<init>(r1)
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6.updateRememberedValue(r5)
        L_0x03e6:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r1 = 57344(0xe000, float:8.0356E-41)
            int r3 = r15 >> 6
            r1 = r1 & r3
            r8 = r1 | 438(0x1b6, float:6.14E-43)
            r1 = r2
            r7 = r6
            r3 = r19
            r4 = r20
            r2 = r0
            r6 = r5
            r5 = r32
            NavigationRailItemLayout(r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x041c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x041c:
            r7 = r5
            r8 = r9
            r9 = r13
            r4 = r21
            r5 = r22
            goto L_0x0131
        L_0x0425:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x043f
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$2 r0 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$2
            r1 = r24
            r2 = r25
            r3 = r26
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x043f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void NavigationRailItemLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, Function0<Float> function0, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z2 = z;
        Function0<Float> function02 = function0;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1498399348);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItemLayout)P(4,3,2,5)530@23300L1924,515@22904L2320:NavigationRail.kt#uh7d8r");
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
                ComposerKt.traceEventStart(1498399348, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:514)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1881815062, "CC(remember):NavigationRail.kt#9igjgp");
            int i4 = 458752 & i2;
            int i5 = 57344 & i2;
            boolean z3 = (i4 == 131072) | ((i2 & 7168) == 2048) | (i5 == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationRailKt$NavigationRailItemLayout$2$1(function02, function28, z2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2082816907, "C516@22921L17,517@22947L11,519@22968L50:NavigationRail.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 402566553, "C519@23010L6:NavigationRail.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(2145400941);
            ComposerKt.sourceInformation(startRestartGroup, "523@23132L96,522@23061L221");
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2145404101, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z4 = (i5 == 16384) | (i4 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new NavigationRailKt$NavigationRailItemLayout$1$2$1(z2, function02);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) rememberedValue2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, graphicsLayer);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 402815576, "C527@23261L7:NavigationRail.kt#uh7d8r");
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
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItemLayout$3(function2, function22, function27, function28, z2, function02, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m2317placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        long j2 = j;
        int r11 = ConstraintsKt.m7069constrainWidthK40F9xA(j2, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        int r12 = ConstraintsKt.m7068constrainHeightK40F9xA(j2, measureScope.m7086roundToPx0680j_4(NavigationRailItemHeight));
        return MeasureScope.layout$default(measureScope, r11, r12, (Map) null, new NavigationRailKt$placeIcon$1(placeable3, placeable, (r11 - placeable.getWidth()) / 2, (r12 - placeable.getHeight()) / 2, placeable2, (r11 - placeable2.getWidth()) / 2, (r12 - placeable2.getHeight()) / 2, r11, r12), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m2318placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        float f2;
        MeasureScope measureScope2 = measureScope;
        float f3 = IndicatorVerticalPaddingWithLabel;
        float height = ((float) placeable2.getHeight()) + measureScope2.m7091toPx0680j_4(f3);
        float f4 = NavigationRailItemVerticalPadding;
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
        int r14 = ConstraintsKt.m7069constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        int width = (r14 - placeable.getWidth()) / 2;
        int width2 = (r14 - placeable2.getWidth()) / 2;
        int width3 = (r14 - placeable3.getWidth()) / 2;
        float r13 = coerceAtLeast - measureScope2.m7091toPx0680j_4(f3);
        return MeasureScope.layout$default(measureScope, r14, MathKt.roundToInt(f6), (Map) null, new NavigationRailKt$placeLabelAndIcon$1(placeable4, z, f, placeable, width, height2, f7, placeable2, width2, coerceAtLeast, placeable3, width3, r13, r14, measureScope2), 4, (Object) null);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    static {
        float f = (float) 4;
        NavigationRailVerticalPadding = Dp.m7111constructorimpl(f);
        NavigationRailItemVerticalPadding = Dp.m7111constructorimpl(f);
        float f2 = (float) 2;
        IndicatorHorizontalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(NavigationRailTokens.INSTANCE.m3352getActiveIndicatorWidthD9Ej5fM() - NavigationRailTokens.INSTANCE.m3355getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingWithLabel = Dp.m7111constructorimpl(Dp.m7111constructorimpl(NavigationRailTokens.INSTANCE.m3351getActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m3355getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingNoLabel = Dp.m7111constructorimpl(Dp.m7111constructorimpl(NavigationRailTokens.INSTANCE.m3357getNoLabelActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m3355getIconSizeD9Ej5fM()) / f2);
    }
}
