package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001aW\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020!0,¢\u0006\u0002\b-H\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0001\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020!0,2\u0011\u00104\u001a\r\u0012\u0004\u0012\u00020!0,¢\u0006\u0002\b-2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u00105\u001a\u0002022\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020!\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020!\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020AH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0016\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0016\u0010\u0014\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0016\u0010\u0016\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0010\"\u0016\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0010\"\u0016\u0010\u001a\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0010\"\u0010\u0010\u001c\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\u001d\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0016\u0010\u001e\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"ActiveIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorColor", "ActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveLabelTextColor", "IconSize", "Landroidx/compose/ui/unit/Dp;", "F", "InactiveIconColor", "InactiveLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "NavigationBarHeight", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "()F", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "StartIconItemActiveIndicatorHeight", "StartIconToLabelPadding", "getStartIconToLabelPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconItemActiveIndicatorHeight", "TopIconItemActiveIndicatorWidth", "TopIconItemVerticalPadding", "getTopIconItemVerticalPadding", "ExpressiveNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/NavigationBarArrangement;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ExpressiveNavigationBar-NiJtXQ4", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ExpressiveNavigationBarItem", "selected", "", "onClick", "icon", "enabled", "label", "badge", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ExpressiveNavigationBarItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExpressiveNavigationBar.kt */
public final class ExpressiveNavigationBarKt {
    /* access modifiers changed from: private */
    public static final ColorSchemeKeyTokens ActiveIconColor = ColorSchemeKeyTokens.Secondary;
    /* access modifiers changed from: private */
    public static final ColorSchemeKeyTokens ActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
    private static final ShapeKeyTokens ActiveIndicatorShape = ShapeKeyTokens.CornerFull;
    /* access modifiers changed from: private */
    public static final ColorSchemeKeyTokens ActiveLabelTextColor = ColorSchemeKeyTokens.Secondary;
    private static final float IconSize;
    /* access modifiers changed from: private */
    public static final ColorSchemeKeyTokens InactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    /* access modifiers changed from: private */
    public static final ColorSchemeKeyTokens InactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final TypographyKeyTokens LabelTextFont = TypographyKeyTokens.LabelMedium;
    /* access modifiers changed from: private */
    public static final float NavigationBarHeight = Dp.m7111constructorimpl((float) 64);
    private static final float StartIconIndicatorHorizontalPadding = Dp.m7111constructorimpl((float) 16);
    private static final float StartIconIndicatorVerticalPadding;
    private static final float StartIconItemActiveIndicatorHeight;
    private static final float StartIconToLabelPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorToLabelPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final float TopIconItemActiveIndicatorHeight;
    private static final float TopIconItemActiveIndicatorWidth;
    private static final float TopIconItemVerticalPadding = Dp.m7111constructorimpl((float) 6);

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x017c  */
    /* renamed from: ExpressiveNavigationBar-NiJtXQ4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2069ExpressiveNavigationBarNiJtXQ4(androidx.compose.ui.Modifier r23, long r24, long r26, androidx.compose.foundation.layout.WindowInsets r28, int r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r30
            r9 = r32
            r0 = -1171105467(0xffffffffba325945, float:-6.8034633E-4)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ExpressiveNavigationBar)P(4,1:c#ui.graphics.Color,3:c#ui.graphics.Color,5,0:c#material3.NavigationBarArrangement)83@3944L14,84@4018L12,85@4097L12,92@4328L779,89@4244L863:ExpressiveNavigationBar.kt#uh7d8r"
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
            r7 = r9 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007d
            r7 = r33 & 8
            if (r7 != 0) goto L_0x0077
            r7 = r28
            boolean r12 = r1.changed((java.lang.Object) r7)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r7 = r28
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r4 = r4 | r12
            goto L_0x007f
        L_0x007d:
            r7 = r28
        L_0x007f:
            r12 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0098
            r12 = r33 & 16
            if (r12 != 0) goto L_0x0092
            r12 = r29
            boolean r13 = r1.changed((int) r12)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r12 = r29
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r13
            goto L_0x009a
        L_0x0098:
            r12 = r29
        L_0x009a:
            r13 = r33 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a2
            r4 = r4 | r14
            goto L_0x00b2
        L_0x00a2:
            r13 = r9 & r14
            if (r13 != 0) goto L_0x00b2
            boolean r13 = r1.changedInstance(r8)
            if (r13 == 0) goto L_0x00af
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r4 = r4 | r13
        L_0x00b2:
            r13 = 74899(0x12493, float:1.04956E-40)
            r13 = r13 & r4
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00ce
            boolean r13 = r1.getSkipping()
            if (r13 != 0) goto L_0x00c2
            goto L_0x00ce
        L_0x00c2:
            r1.skipToGroupEnd()
            r20 = r1
            r1 = r3
            r2 = r5
            r6 = r7
            r4 = r10
            r7 = r12
            goto L_0x0184
        L_0x00ce:
            r1.startDefaults()
            r13 = r9 & 1
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            if (r13 == 0) goto L_0x00fb
            boolean r13 = r1.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00df
            goto L_0x00fb
        L_0x00df:
            r1.skipToGroupEnd()
            r2 = r33 & 2
            if (r2 == 0) goto L_0x00e8
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00e8:
            r2 = r33 & 4
            if (r2 == 0) goto L_0x00ee
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ee:
            r2 = r33 & 8
            if (r2 == 0) goto L_0x00f4
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00f4:
            r2 = r33 & 16
            if (r2 == 0) goto L_0x00f9
            r4 = r4 & r14
        L_0x00f9:
            r2 = r3
            goto L_0x0137
        L_0x00fb:
            if (r2 == 0) goto L_0x0102
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0103
        L_0x0102:
            r2 = r3
        L_0x0103:
            r3 = r33 & 2
            r13 = 6
            if (r3 == 0) goto L_0x0110
            androidx.compose.material3.ExpressiveNavigationBarDefaults r3 = androidx.compose.material3.ExpressiveNavigationBarDefaults.INSTANCE
            long r5 = r3.getContainerColor(r1, r13)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0110:
            r3 = r33 & 4
            if (r3 == 0) goto L_0x011c
            androidx.compose.material3.ExpressiveNavigationBarDefaults r3 = androidx.compose.material3.ExpressiveNavigationBarDefaults.INSTANCE
            long r10 = r3.getContentColor(r1, r13)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x011c:
            r3 = r33 & 8
            if (r3 == 0) goto L_0x0129
            androidx.compose.material3.ExpressiveNavigationBarDefaults r3 = androidx.compose.material3.ExpressiveNavigationBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r13)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r7 = r3
        L_0x0129:
            r3 = r33 & 16
            if (r3 == 0) goto L_0x0137
            androidx.compose.material3.ExpressiveNavigationBarDefaults r3 = androidx.compose.material3.ExpressiveNavigationBarDefaults.INSTANCE
            int r3 = r3.m2068getArrangementEbr7WPU()
            r4 = r4 & r14
            r12 = r5
            r14 = r10
            goto L_0x013a
        L_0x0137:
            r14 = r10
            r3 = r12
            r12 = r5
        L_0x013a:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0149
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.ExpressiveNavigationBar (ExpressiveNavigationBar.kt:88)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r5, r6)
        L_0x0149:
            androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$1 r0 = new androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$1
            r0.<init>(r2, r7, r3, r8)
            r5 = 54
            r6 = 1573697866(0x5dccb94a, float:1.84398793E18)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r10, r0, r1, r5)
            r19 = r0
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            int r0 = r4 << 3
            r4 = r0 & 896(0x380, float:1.256E-42)
            r5 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r5
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r21 = r4 | r0
            r22 = 115(0x73, float:1.61E-43)
            r10 = 0
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = r1
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017f:
            r1 = r2
            r6 = r7
            r4 = r14
            r7 = r3
            r2 = r12
        L_0x0184:
            androidx.compose.runtime.ScopeUpdateScope r11 = r20.endRestartGroup()
            if (r11 == 0) goto L_0x0196
            androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$2 r0 = new androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$2
            r10 = r33
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExpressiveNavigationBarKt.m2069ExpressiveNavigationBarNiJtXQ4(androidx.compose.ui.Modifier, long, long, androidx.compose.foundation.layout.WindowInsets, int, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0114  */
    /* renamed from: ExpressiveNavigationBarItem-pli-t6k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2070ExpressiveNavigationBarItemplit6k(boolean r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, int r41, androidx.compose.material3.NavigationItemColors r42, androidx.compose.foundation.interaction.MutableInteractionSource r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r11 = r45
            r12 = r46
            r0 = 1250474866(0x4a88bb72, float:4480441.0)
            r1 = r44
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ExpressiveNavigationBarItem)P(9,8,3,7,2,6!1,4:c#material3.NavigationItemIconPosition)195@8610L8,219@9391L5,220@9444L5,215@9259L800:ExpressiveNavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r11 | 6
            r13 = r34
            goto L_0x002d
        L_0x001b:
            r2 = r11 & 6
            r13 = r34
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((boolean) r13)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r11
            goto L_0x002d
        L_0x002c:
            r2 = r11
        L_0x002d:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r14 = r35
            goto L_0x0048
        L_0x0036:
            r3 = r11 & 48
            r14 = r35
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r14)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r36
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
            r3 = r36
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r37
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r37
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r38
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r38
        L_0x009c:
            r8 = r12 & 32
            r9 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a4
            r2 = r2 | r9
            goto L_0x00b6
        L_0x00a4:
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00b6
            r9 = r39
            boolean r10 = r1.changedInstance(r9)
            if (r10 == 0) goto L_0x00b2
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r10
            goto L_0x00b8
        L_0x00b6:
            r9 = r39
        L_0x00b8:
            r10 = r12 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r10 == 0) goto L_0x00c0
            r2 = r2 | r15
            goto L_0x00d3
        L_0x00c0:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00d3
            r15 = r40
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r2 = r2 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r40
        L_0x00d5:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00de
            r2 = r2 | r17
            goto L_0x00f4
        L_0x00de:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x00f4
            r17 = r0
            r0 = r41
            boolean r18 = r1.changed((int) r0)
            if (r18 == 0) goto L_0x00ef
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ef:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r2 = r2 | r18
            goto L_0x00f8
        L_0x00f4:
            r17 = r0
            r0 = r41
        L_0x00f8:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0114
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010d
            r0 = r42
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010f
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0111
        L_0x010d:
            r0 = r42
        L_0x010f:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0111:
            r2 = r2 | r18
            goto L_0x0116
        L_0x0114:
            r0 = r42
        L_0x0116:
            r0 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011f
            r2 = r2 | r18
            goto L_0x0135
        L_0x011f:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0135
            r18 = r0
            r0 = r43
            boolean r19 = r1.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x0130
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r2 = r2 | r19
            goto L_0x0139
        L_0x0135:
            r18 = r0
            r0 = r43
        L_0x0139:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r2 & r19
            r44 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x015d
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x014c
            goto L_0x015d
        L_0x014c:
            r1.skipToGroupEnd()
            r8 = r41
            r10 = r43
            r31 = r1
            r4 = r5
            r5 = r7
            r6 = r9
            r7 = r15
            r9 = r42
            goto L_0x028d
        L_0x015d:
            r1.startDefaults()
            r0 = r11 & 1
            r19 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = 6
            if (r0 == 0) goto L_0x0199
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016f
            goto L_0x0199
        L_0x016f:
            r1.skipToGroupEnd()
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0188
            r0 = r44 & r19
            r4 = r41
            r24 = r42
            r8 = r0
            r25 = r5
            r26 = r7
            r27 = r9
            r28 = r15
            r0 = r43
            goto L_0x01d1
        L_0x0188:
            r4 = r41
            r24 = r42
            r0 = r43
            r8 = r44
            r25 = r5
        L_0x0192:
            r26 = r7
            r27 = r9
            r28 = r15
            goto L_0x01d1
        L_0x0199:
            if (r4 == 0) goto L_0x01a0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x01a0:
            if (r6 == 0) goto L_0x01a4
            r0 = 1
            r7 = r0
        L_0x01a4:
            r0 = 0
            if (r8 == 0) goto L_0x01a8
            r9 = r0
        L_0x01a8:
            if (r10 == 0) goto L_0x01ab
            r15 = r0
        L_0x01ab:
            if (r17 == 0) goto L_0x01b4
            androidx.compose.material3.NavigationItemIconPosition$Companion r4 = androidx.compose.material3.NavigationItemIconPosition.Companion
            int r4 = r4.m2289getTopxw1Ddg()
            goto L_0x01b6
        L_0x01b4:
            r4 = r41
        L_0x01b6:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x01c3
            androidx.compose.material3.ExpressiveNavigationBarItemDefaults r6 = androidx.compose.material3.ExpressiveNavigationBarItemDefaults.INSTANCE
            androidx.compose.material3.NavigationItemColors r6 = r6.colors(r1, r2)
            r8 = r44 & r19
            goto L_0x01c7
        L_0x01c3:
            r6 = r42
            r8 = r44
        L_0x01c7:
            if (r18 == 0) goto L_0x01ca
            goto L_0x01cc
        L_0x01ca:
            r0 = r43
        L_0x01cc:
            r25 = r5
            r24 = r6
            goto L_0x0192
        L_0x01d1:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01e3
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.ExpressiveNavigationBarItem (ExpressiveNavigationBar.kt:197)"
            r7 = 1250474866(0x4a88bb72, float:4480441.0)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r8, r5, r6)
        L_0x01e3:
            r5 = -986536477(0xffffffffc532a5e3, float:-2858.368)
            r1.startReplaceGroup(r5)
            java.lang.String r5 = "199@8762L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            if (r0 != 0) goto L_0x0213
            r5 = -986535826(0xffffffffc532a86e, float:-2858.5269)
            java.lang.String r6 = "CC(remember):ExpressiveNavigationBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r6)
            java.lang.Object r5 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x020b
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r5)
        L_0x020b:
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r30 = r5
            goto L_0x0215
        L_0x0213:
            r30 = r0
        L_0x0215:
            r1.endReplaceGroup()
            androidx.compose.material3.NavigationItemIconPosition$Companion r5 = androidx.compose.material3.NavigationItemIconPosition.Companion
            int r5 = r5.m2289getTopxw1Ddg()
            boolean r5 = androidx.compose.material3.NavigationItemIconPosition.m2284equalsimpl0(r4, r5)
            if (r5 == 0) goto L_0x0227
            float r6 = TopIconIndicatorHorizontalPadding
            goto L_0x0229
        L_0x0227:
            float r6 = StartIconIndicatorHorizontalPadding
        L_0x0229:
            r19 = r6
            if (r5 == 0) goto L_0x0230
            float r5 = TopIconIndicatorVerticalPadding
            goto L_0x0232
        L_0x0230:
            float r5 = StartIconIndicatorVerticalPadding
        L_0x0232:
            r20 = r5
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = LabelTextFont
            androidx.compose.ui.text.TextStyle r16 = androidx.compose.material3.TypographyKt.getValue(r5, r1, r2)
            androidx.compose.material3.tokens.ShapeKeyTokens r5 = ActiveIndicatorShape
            androidx.compose.ui.graphics.Shape r17 = androidx.compose.material3.ShapesKt.getValue(r5, r1, r2)
            float r18 = TopIconItemActiveIndicatorWidth
            float r21 = TopIconIndicatorToLabelPadding
            float r22 = StartIconToLabelPadding
            float r23 = TopIconItemVerticalPadding
            r5 = r8 & 14
            r6 = 906166272(0x36030000, float:1.9520521E-6)
            r5 = r5 | r6
            r6 = r8 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = r8 & 896(0x380, float:1.256E-42)
            r32 = r5 | r6
            int r5 = r8 >> 21
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            int r5 = r8 >> 3
            r6 = r5 & 896(0x380, float:1.256E-42)
            r2 = r2 | r6
            r6 = r5 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r5
            r2 = r2 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r5
            r2 = r2 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r6
            r33 = r2 | r5
            r31 = r1
            r15 = r3
            r29 = r4
            androidx.compose.material3.NavigationItemKt.m2290NavigationItemSHbi2eg(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0280
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0280:
            r10 = r0
            r9 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
        L_0x028d:
            androidx.compose.runtime.ScopeUpdateScope r13 = r31.endRestartGroup()
            if (r13 == 0) goto L_0x02a3
            androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBarItem$1 r0 = new androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBarItem$1
            r1 = r34
            r2 = r35
            r3 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExpressiveNavigationBarKt.m2070ExpressiveNavigationBarItemplit6k(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, androidx.compose.material3.NavigationItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final int calculateCenteredContentHorizontalPadding(int i, int i2) {
        if (i > 6) {
            return 0;
        }
        return MathKt.roundToInt(((((float) (100 - ((i + 3) * 10))) / 2.0f) / ((float) 100)) * ((float) i2));
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }

    static {
        float r0 = Dp.m7111constructorimpl((float) 24.0d);
        IconSize = r0;
        float r1 = Dp.m7111constructorimpl((float) 56);
        TopIconItemActiveIndicatorWidth = r1;
        float r2 = Dp.m7111constructorimpl((float) 32);
        TopIconItemActiveIndicatorHeight = r2;
        float r3 = Dp.m7111constructorimpl((float) 40);
        StartIconItemActiveIndicatorHeight = r3;
        float f = (float) 2;
        TopIconIndicatorVerticalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(r2 - r0) / f);
        TopIconIndicatorHorizontalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(r1 - r0) / f);
        StartIconIndicatorVerticalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(r3 - r0) / f);
        float f2 = (float) 4;
        TopIconIndicatorToLabelPadding = Dp.m7111constructorimpl(f2);
        StartIconToLabelPadding = Dp.m7111constructorimpl(f2);
    }
}
