package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b\u0018¢\u0006\u0002\b*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = Dp.m7111constructorimpl((float) 6);
    private static final float HorizontalTextPadding = Dp.m7111constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    /* access modifiers changed from: private */
    public static final float LargeTabHeight = Dp.m7111constructorimpl((float) 72);
    private static final float SingleLineTextBaselineWithIcon = Dp.m7111constructorimpl((float) 14);
    /* access modifiers changed from: private */
    public static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m3482getContainerHeightD9Ej5fM();
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    /* access modifiers changed from: private */
    public static final float TextDistanceFromLeadingIcon = Dp.m7111constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0102  */
    /* renamed from: Tab-wqdebIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2573TabwqdebIU(boolean r27, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, long r33, long r35, androidx.compose.foundation.interaction.MutableInteractionSource r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r12 = r39
            r13 = r40
            r0 = -350627181(0xffffffffeb19da93, float:-1.8599784E26)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)99@4483L7,121@5133L65,113@4964L234:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r12 | 6
            r14 = r27
            goto L_0x002d
        L_0x001b:
            r2 = r12 & 6
            r14 = r27
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((boolean) r14)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r12
            goto L_0x002d
        L_0x002c:
            r2 = r12
        L_0x002d:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r15 = r28
            goto L_0x0048
        L_0x0036:
            r3 = r12 & 48
            r15 = r28
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r15)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r13 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r4 = r12 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r29
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r29
        L_0x0064:
            r5 = r13 & 8
            if (r5 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r6 = r12 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007e
            r6 = r30
            boolean r7 = r1.changed((boolean) r6)
            if (r7 == 0) goto L_0x007a
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r7
            goto L_0x0080
        L_0x007e:
            r6 = r30
        L_0x0080:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r8 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x009a
            r8 = r31
            boolean r9 = r1.changedInstance(r8)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r9
            goto L_0x009c
        L_0x009a:
            r8 = r31
        L_0x009c:
            r9 = r13 & 32
            r10 = 196608(0x30000, float:2.75506E-40)
            if (r9 == 0) goto L_0x00a4
            r2 = r2 | r10
            goto L_0x00b6
        L_0x00a4:
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00b6
            r10 = r32
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x00b2
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r11
            goto L_0x00b8
        L_0x00b6:
            r10 = r32
        L_0x00b8:
            r11 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00d9
            r11 = r13 & 64
            if (r11 != 0) goto L_0x00cf
            r11 = r2
            r38 = r3
            r2 = r33
            boolean r16 = r1.changed((long) r2)
            if (r16 == 0) goto L_0x00d4
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00cf:
            r11 = r2
            r38 = r3
            r2 = r33
        L_0x00d4:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r11 = r11 | r16
            goto L_0x00de
        L_0x00d9:
            r11 = r2
            r38 = r3
            r2 = r33
        L_0x00de:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00f7
            r0 = r13 & 128(0x80, float:1.794E-43)
            r2 = r35
            if (r0 != 0) goto L_0x00f3
            boolean r0 = r1.changed((long) r2)
            if (r0 == 0) goto L_0x00f3
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f3:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r11 = r11 | r0
            goto L_0x00f9
        L_0x00f7:
            r2 = r35
        L_0x00f9:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0102
            r11 = r11 | r18
            goto L_0x0118
        L_0x0102:
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0118
            r18 = r0
            r0 = r37
            boolean r19 = r1.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x0113
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r11 = r11 | r19
            goto L_0x011c
        L_0x0118:
            r18 = r0
            r0 = r37
        L_0x011c:
            r19 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r11 & r19
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x013e
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x012d
            goto L_0x013e
        L_0x012d:
            r1.skipToGroupEnd()
            r11 = r37
            r24 = r1
            r3 = r4
            r4 = r6
            r5 = r8
            r6 = r10
            r7 = r33
            r9 = r35
            goto L_0x0246
        L_0x013e:
            r1.startDefaults()
            r0 = r12 & 1
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = 0
            r20 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = 1
            if (r0 == 0) goto L_0x0171
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0155
            goto L_0x0171
        L_0x0155:
            r1.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x015d
            r11 = r11 & r3
        L_0x015d:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0163
            r11 = r11 & r20
        L_0x0163:
            r20 = r35
            r22 = r37
            r17 = r6
            r0 = r19
            r3 = -350627181(0xffffffffeb19da93, float:-1.8599784E26)
            r18 = r33
            goto L_0x01cb
        L_0x0171:
            if (r38 == 0) goto L_0x0178
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0178:
            if (r5 == 0) goto L_0x017b
            r6 = r2
        L_0x017b:
            if (r7 == 0) goto L_0x017f
            r8 = r19
        L_0x017f:
            if (r9 == 0) goto L_0x0183
            r10 = r19
        L_0x0183:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x01a4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r7)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r21 = r0.m4249unboximpl()
            r11 = r11 & r3
            goto L_0x01a6
        L_0x01a4:
            r21 = r33
        L_0x01a6:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01b0
            r0 = r11 & r20
            r11 = r0
            r23 = r21
            goto L_0x01b2
        L_0x01b0:
            r23 = r35
        L_0x01b2:
            r17 = r6
            r0 = r19
            if (r18 == 0) goto L_0x01c2
            r3 = -350627181(0xffffffffeb19da93, float:-1.8599784E26)
            r18 = r21
            r20 = r23
            r22 = r0
            goto L_0x01cb
        L_0x01c2:
            r18 = r21
            r20 = r23
            r3 = -350627181(0xffffffffeb19da93, float:-1.8599784E26)
            r22 = r37
        L_0x01cb:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01da
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.Tab (Tab.kt:102)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r11, r5, r6)
        L_0x01da:
            r3 = 79583089(0x4be5771, float:4.4749088E-36)
            r1.startReplaceGroup(r3)
            java.lang.String r3 = "*105@4702L247"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = 54
            if (r8 != 0) goto L_0x01ea
            goto L_0x01f8
        L_0x01ea:
            androidx.compose.material3.TabKt$Tab$styledText$1$1 r0 = new androidx.compose.material3.TabKt$Tab$styledText$1$1
            r0.<init>(r8)
            r5 = 708874428(0x2a4090bc, float:1.710324E-13)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r2, r0, r1, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x01f8:
            r1.endReplaceGroup()
            androidx.compose.material3.TabKt$Tab$1 r5 = new androidx.compose.material3.TabKt$Tab$1
            r5.<init>(r0, r10)
            r0 = 1540996038(0x5bd9bbc6, float:1.22573058E17)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r2, r5, r1, r3)
            r23 = r0
            kotlin.jvm.functions.Function3 r23 = (kotlin.jvm.functions.Function3) r23
            r0 = r11 & 14
            r0 = r0 | r16
            r2 = r11 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r11 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r11 >> 6
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r25 = r0 | r2
            r26 = 0
            r24 = r1
            r16 = r4
            m2572TabbogVsAg(r14, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x023a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x023a:
            r5 = r8
            r6 = r10
            r3 = r16
            r4 = r17
            r7 = r18
            r9 = r20
            r11 = r22
        L_0x0246:
            androidx.compose.runtime.ScopeUpdateScope r14 = r24.endRestartGroup()
            if (r14 == 0) goto L_0x025a
            androidx.compose.material3.TabKt$Tab$2 r0 = new androidx.compose.material3.TabKt$Tab$2
            r1 = r27
            r2 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x025a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2573TabwqdebIU(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fc  */
    /* renamed from: LeadingIconTab-wqdebIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2571LeadingIconTabwqdebIU(boolean r20, kotlin.jvm.functions.Function0<kotlin.Unit> r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, boolean r25, long r26, long r28, androidx.compose.foundation.interaction.MutableInteractionSource r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r12 = r32
            r13 = r33
            r0 = -777316544(0xffffffffd1ab1740, float:-9.1853685E10)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)164@7036L7,171@7399L76,173@7551L950,173@7481L1020:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r12 | 6
            r5 = r20
            goto L_0x002d
        L_0x001b:
            r2 = r12 & 6
            r5 = r20
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((boolean) r5)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r12
            goto L_0x002d
        L_0x002c:
            r2 = r12
        L_0x002d:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r9 = r21
            goto L_0x0048
        L_0x0036:
            r3 = r12 & 48
            r9 = r21
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r9)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r13 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r12 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r22
            boolean r4 = r1.changedInstance(r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r22
        L_0x0064:
            r4 = r13 & 8
            if (r4 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r4 = r12 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x007e
            r4 = r23
            boolean r6 = r1.changedInstance(r4)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r6
            goto L_0x0080
        L_0x007e:
            r4 = r23
        L_0x0080:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r24
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r24
        L_0x009c:
            r8 = r13 & 32
            r10 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a4
            r2 = r2 | r10
            goto L_0x00b6
        L_0x00a4:
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00b6
            r10 = r25
            boolean r11 = r1.changed((boolean) r10)
            if (r11 == 0) goto L_0x00b2
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r11
            goto L_0x00b8
        L_0x00b6:
            r10 = r25
        L_0x00b8:
            r11 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00d0
            r11 = r13 & 64
            r14 = r26
            if (r11 != 0) goto L_0x00cc
            boolean r11 = r1.changed((long) r14)
            if (r11 == 0) goto L_0x00cc
            r11 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r11 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r11
            goto L_0x00d2
        L_0x00d0:
            r14 = r26
        L_0x00d2:
            r11 = 12582912(0xc00000, float:1.7632415E-38)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00ed
            r11 = r13 & 128(0x80, float:1.794E-43)
            r31 = r2
            r2 = r28
            if (r11 != 0) goto L_0x00e8
            boolean r11 = r1.changed((long) r2)
            if (r11 == 0) goto L_0x00e8
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r11 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r11 = r31 | r11
            goto L_0x00f3
        L_0x00ed:
            r31 = r2
            r2 = r28
            r11 = r31
        L_0x00f3:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fc
            r11 = r11 | r17
            goto L_0x0112
        L_0x00fc:
            r17 = r12 & r17
            if (r17 != 0) goto L_0x0112
            r17 = r0
            r0 = r30
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010d
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010d:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r11 = r11 | r18
            goto L_0x0116
        L_0x0112:
            r17 = r0
            r0 = r30
        L_0x0116:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r11 & r18
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x0134
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0127
            goto L_0x0134
        L_0x0127:
            r1.skipToGroupEnd()
            r11 = r30
            r5 = r7
            r6 = r10
            r7 = r14
            r9 = r28
            r14 = r1
            goto L_0x020a
        L_0x0134:
            r1.startDefaults()
            r0 = r12 & 1
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r31 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = 1
            if (r0 == 0) goto L_0x015e
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0149
            goto L_0x015e
        L_0x0149:
            r1.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0151
            r11 = r11 & r3
        L_0x0151:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0157
            r11 = r11 & r31
        L_0x0157:
            r18 = r28
        L_0x0159:
            r6 = r30
        L_0x015b:
            r8 = r10
            r0 = r11
            goto L_0x0199
        L_0x015e:
            if (r6 == 0) goto L_0x0165
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r7 = r0
        L_0x0165:
            if (r8 == 0) goto L_0x0168
            r10 = r2
        L_0x0168:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0188
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r8)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r14 = r0.m4249unboximpl()
            r11 = r11 & r3
        L_0x0188:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0192
            r0 = r11 & r31
            r11 = r0
            r18 = r14
            goto L_0x0194
        L_0x0192:
            r18 = r28
        L_0x0194:
            if (r17 == 0) goto L_0x0159
            r0 = 0
            r6 = r0
            goto L_0x015b
        L_0x0199:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01ab
            r3 = -1
            java.lang.String r10 = "androidx.compose.material3.LeadingIconTab (Tab.kt:167)"
            r11 = -777316544(0xffffffffd1ab1740, float:-9.1853685E10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r0, r3, r10)
        L_0x01ab:
            int r3 = r0 >> 12
            r3 = r3 & 896(0x380, float:1.256E-42)
            r3 = r3 | 6
            r10 = 2
            r11 = 1
            r16 = 0
            r28 = r1
            r29 = r3
            r30 = r10
            r24 = r11
            r26 = r14
            r25 = r16
            androidx.compose.foundation.Indication r1 = androidx.compose.material3.RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(r24, r25, r26, r28, r29, r30)
            r15 = r26
            r14 = r28
            androidx.compose.material3.TabKt$LeadingIconTab$1 r3 = new androidx.compose.material3.TabKt$LeadingIconTab$1
            r11 = r22
            r10 = r4
            r4 = r7
            r7 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = 54
            r5 = -429037564(0xffffffffe66d6804, float:-2.802799E23)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r2, r3, r14, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = r0 >> 18
            r3 = r2 & 14
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r0 = r0 << 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r28 = r20
            r31 = r0
            r29 = r1
            r30 = r14
            r24 = r15
            r26 = r18
            m2574TabTransitionKlgxPg(r24, r26, r28, r29, r30, r31)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0204
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0204:
            r5 = r4
            r11 = r6
            r6 = r8
            r7 = r15
            r9 = r18
        L_0x020a:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 == 0) goto L_0x0222
            androidx.compose.material3.TabKt$LeadingIconTab$2 r0 = new androidx.compose.material3.TabKt$LeadingIconTab$2
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0222:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2571LeadingIconTabwqdebIU(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0114  */
    /* renamed from: Tab-bogVsAg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2572TabbogVsAg(boolean r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, long r27, long r29, androidx.compose.foundation.interaction.MutableInteractionSource r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r34
            r12 = r35
            r0 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            r1 = r33
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)238@10306L7,246@10715L76,248@10867L600,248@10797L670:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r5 = r23
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r5 = r23
            if (r1 != 0) goto L_0x002c
            boolean r1 = r7.changed((boolean) r5)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0047
        L_0x0034:
            r2 = r11 & 48
            if (r2 != 0) goto L_0x0047
            r2 = r24
            boolean r3 = r7.changedInstance(r2)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r1 = r1 | r3
            goto L_0x0049
        L_0x0047:
            r2 = r24
        L_0x0049:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0063
            r4 = r25
            boolean r6 = r7.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x005f
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r1 = r1 | r6
            goto L_0x0065
        L_0x0063:
            r4 = r25
        L_0x0065:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x006c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r11 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r26
            boolean r9 = r7.changed((boolean) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r26
        L_0x0081:
            r9 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r12 & 16
            if (r9 != 0) goto L_0x0094
            r9 = r27
            boolean r13 = r7.changed((long) r9)
            if (r13 == 0) goto L_0x0096
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r9 = r27
        L_0x0096:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r13
            goto L_0x009c
        L_0x009a:
            r9 = r27
        L_0x009c:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b6
            r13 = r12 & 32
            if (r13 != 0) goto L_0x00b0
            r13 = r29
            boolean r15 = r7.changed((long) r13)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r13 = r29
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r15
            goto L_0x00b8
        L_0x00b6:
            r13 = r29
        L_0x00b8:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c3
            r1 = r1 | r16
            r0 = r31
            goto L_0x00d6
        L_0x00c3:
            r16 = r11 & r16
            r0 = r31
            if (r16 != 0) goto L_0x00d6
            boolean r17 = r7.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d2
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r1 = r1 | r17
        L_0x00d6:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00df
            r1 = r1 | r17
            goto L_0x00f3
        L_0x00df:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00f3
            r0 = r32
            boolean r17 = r7.changedInstance(r0)
            if (r17 == 0) goto L_0x00ee
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ee:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r1 = r1 | r17
            goto L_0x00f5
        L_0x00f3:
            r0 = r32
        L_0x00f5:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r17
            r33 = r1
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x0114
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x0108
            goto L_0x0114
        L_0x0108:
            r7.skipToGroupEnd()
            r3 = r4
            r0 = r7
            r4 = r8
            r5 = r9
            r7 = r13
            r9 = r31
            goto L_0x01f0
        L_0x0114:
            r7.startDefaults()
            r0 = r11 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = 1
            if (r0 == 0) goto L_0x0148
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0129
            goto L_0x0148
        L_0x0129:
            r7.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0133
            r0 = r33 & r17
            goto L_0x0135
        L_0x0133:
            r0 = r33
        L_0x0135:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x013b
            r0 = r0 & r18
        L_0x013b:
            r21 = r13
            r14 = r4
            r3 = r21
            r16 = r31
            r18 = r8
            r6 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            goto L_0x018c
        L_0x0148:
            if (r3 == 0) goto L_0x014f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x014f:
            if (r6 == 0) goto L_0x0152
            r8 = r1
        L_0x0152:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0174
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r6)
            java.lang.Object r0 = r7.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r9 = r0.m4249unboximpl()
            r0 = r33 & r17
            goto L_0x0176
        L_0x0174:
            r0 = r33
        L_0x0176:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x017d
            r0 = r0 & r18
            r13 = r9
        L_0x017d:
            if (r15 == 0) goto L_0x013b
            r3 = 0
            r16 = r3
            r18 = r8
            r6 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            r21 = r13
            r14 = r4
            r3 = r21
        L_0x018c:
            r7.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x019b
            r8 = -1
            java.lang.String r13 = "androidx.compose.material3.Tab (Tab.kt:242)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r0, r8, r13)
        L_0x019b:
            int r6 = r0 >> 6
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | 6
            r8 = 2
            r13 = 1
            r15 = 0
            r30 = r6
            r29 = r7
            r31 = r8
            r27 = r9
            r25 = r13
            r26 = r15
            androidx.compose.foundation.Indication r17 = androidx.compose.material3.RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(r25, r26, r27, r29, r30, r31)
            androidx.compose.material3.TabKt$Tab$3 r13 = new androidx.compose.material3.TabKt$Tab$3
            r20 = r32
            r19 = r2
            r15 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r2 = 54
            r5 = -551896140(0xffffffffdf1abbb4, float:-1.1149703E19)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r1, r13, r7, r2)
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            int r1 = r0 >> 12
            r2 = r1 & 14
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r0 = r0 << 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            r8 = r1 | r0
            r5 = r23
            r1 = r9
            m2574TabTransitionKlgxPg(r1, r3, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01e8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e8:
            r0 = r7
            r5 = r9
            r9 = r16
            r7 = r3
            r3 = r14
            r4 = r18
        L_0x01f0:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 == 0) goto L_0x0206
            androidx.compose.material3.TabKt$Tab$4 r0 = new androidx.compose.material3.TabKt$Tab$4
            r1 = r23
            r2 = r24
            r10 = r32
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0206:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2572TabbogVsAg(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    public static final void m2574TabTransitionKlgxPg(long j, long j2, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        boolean z2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(735731848);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)280@11898L26,282@11961L548,297@12514L77:Tab.kt#uh7d8r");
        long j3 = j;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        long j4 = j2;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:279)");
            }
            int i4 = i2 >> 6;
            Transition updateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, startRestartGroup, i4 & 14, 2);
            Function3 function3 = TabKt$TabTransition$color$2.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            boolean booleanValue = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            Transition transition = updateTransition;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j5 = booleanValue ? j3 : j4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            ColorSpace r10 = Color.m4243getColorSpaceimpl(j5);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1918408083, "CC(remember):Transition.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r10);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r10);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
            boolean booleanValue2 = ((Boolean) transition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            boolean z3 = booleanValue2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j6 = z3 ? j3 : j4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Color r0 = Color.m4229boximpl(j6);
            boolean booleanValue3 = ((Boolean) transition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            Color color = r0;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j7 = booleanValue3 ? j3 : j4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation(transition, color, Color.m4229boximpl(j7), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), startRestartGroup, 0), twoWayConverter, "ColorAnimation", startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(TabTransition_Klgx_Pg$lambda$2(createTransitionAnimation))), function22, startRestartGroup, (i4 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$TabTransition$1(j3, j2, z2, function22, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabBaselineLayout)P(1)314@13233L2042,307@12989L2286:Tab.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:306)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 370960155, "CC(remember):Tab.kt#9igjgp");
            int i4 = i2 & 14;
            boolean z = true;
            boolean z2 = i4 == 4;
            if ((i2 & 112) != 32) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TabKt$TabBaselineLayout$2$1(function23, function24);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer r14 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r14, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r14, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r14.getInserting() || !Intrinsics.areEqual(r14.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r14.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r14, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1248753480, "C:Tab.kt#uh7d8r");
            startRestartGroup.startReplaceGroup(871566271);
            ComposerKt.sourceInformation(startRestartGroup, "309@13038L85");
            if (function23 != null) {
                Modifier r7 = PaddingKt.m777paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), HorizontalTextPadding, 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r7);
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
                Composer r13 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r13, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r13, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r13.getInserting() || !Intrinsics.areEqual(r13.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r13.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r13, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719667646, "C309@13115L6:Tab.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf(i4));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(871570579);
            ComposerKt.sourceInformation(startRestartGroup, "312@13174L41");
            if (function24 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
                Composer r6 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r6, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3682setimpl(r6, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719758910, "C312@13207L6:Tab.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new TabKt$TabBaselineLayout$3(function23, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        Density density2 = density;
        int i5 = i3;
        int i6 = i4;
        if (i5 == i6) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int r3 = density2.m7086roundToPx0680j_4(f) + density2.m7086roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m3480getActiveIndicatorHeightD9Ej5fM());
        int i7 = (i2 - i6) - r3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i7, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i7 - ((placeable2.getHeight() + density2.m7085roundToPxR2X_6o(IconDistanceFromBaseline)) - i5), 0.0f, 4, (Object) null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m4249unboximpl();
    }
}
