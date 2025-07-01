package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a>\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0016\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "TextSelectionBackgroundOpacity", "", "MaterialExpressiveTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialTheme", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
public final class MaterialThemeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(MaterialThemeKt$LocalUsingExpressiveTheme$1.INSTANCE);
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00af, code lost:
        if ((r22 & 4) != 0) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MaterialTheme(androidx.compose.material3.ColorScheme r16, androidx.compose.material3.Shapes r17, androidx.compose.material3.Typography r18, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r4 = r19
            r5 = r21
            r0 = -2127166334(0xffffffff81360482, float:-3.3431355E-38)
            r1 = r20
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(MaterialTheme)P(!1,2,3)51@2364L11,52@2412L6,53@2463L10,56@2542L32,57@2601L40,67@3101L81,59@2681L501:MaterialTheme.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r5 & 6
            r2 = 4
            r3 = 2
            if (r1 != 0) goto L_0x002b
            r1 = r22 & 1
            if (r1 != 0) goto L_0x0026
            r1 = r16
            boolean r6 = r10.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x0029
        L_0x0026:
            r1 = r16
        L_0x0028:
            r6 = r3
        L_0x0029:
            r6 = r6 | r5
            goto L_0x002e
        L_0x002b:
            r1 = r16
            r6 = r5
        L_0x002e:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0047
            r7 = r22 & 2
            if (r7 != 0) goto L_0x0041
            r7 = r17
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0043
            r8 = 32
            goto L_0x0045
        L_0x0041:
            r7 = r17
        L_0x0043:
            r8 = 16
        L_0x0045:
            r6 = r6 | r8
            goto L_0x0049
        L_0x0047:
            r7 = r17
        L_0x0049:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0062
            r8 = r22 & 4
            if (r8 != 0) goto L_0x005c
            r8 = r18
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r8 = r18
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r6 = r6 | r9
            goto L_0x0064
        L_0x0062:
            r8 = r18
        L_0x0064:
            r9 = r22 & 8
            if (r9 == 0) goto L_0x006b
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x006b:
            r9 = r5 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007b
            boolean r9 = r10.changedInstance(r4)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r6 = r6 | r9
        L_0x007b:
            r9 = r6 & 1171(0x493, float:1.641E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r9 != r11) goto L_0x008f
            boolean r9 = r10.getSkipping()
            if (r9 != 0) goto L_0x0088
            goto L_0x008f
        L_0x0088:
            r10.skipToGroupEnd()
            r2 = r7
            r3 = r8
            goto L_0x015e
        L_0x008f:
            r10.startDefaults()
            r9 = r5 & 1
            r13 = 6
            if (r9 == 0) goto L_0x00b2
            boolean r9 = r10.getDefaultsInvalid()
            if (r9 == 0) goto L_0x009e
            goto L_0x00b2
        L_0x009e:
            r10.skipToGroupEnd()
            r9 = r22 & 1
            if (r9 == 0) goto L_0x00a7
            r6 = r6 & -15
        L_0x00a7:
            r9 = r22 & 2
            if (r9 == 0) goto L_0x00ad
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ad:
            r9 = r22 & 4
            if (r9 == 0) goto L_0x00d6
            goto L_0x00d4
        L_0x00b2:
            r9 = r22 & 1
            if (r9 == 0) goto L_0x00be
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r1 = r1.getColorScheme(r10, r13)
            r6 = r6 & -15
        L_0x00be:
            r9 = r22 & 2
            if (r9 == 0) goto L_0x00ca
            androidx.compose.material3.MaterialTheme r7 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Shapes r7 = r7.getShapes(r10, r13)
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ca:
            r9 = r22 & 4
            if (r9 == 0) goto L_0x00d6
            androidx.compose.material3.MaterialTheme r8 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r8 = r8.getTypography(r10, r13)
        L_0x00d4:
            r6 = r6 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d6:
            r14 = r7
            r15 = r8
            r10.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00e7
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:55)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r7, r8)
        L_0x00e7:
            r11 = 0
            r12 = 7
            r0 = r6
            r6 = 0
            r7 = 0
            r8 = 0
            androidx.compose.foundation.Indication r6 = androidx.compose.material3.RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(r6, r7, r8, r10, r11, r12)
            r0 = r0 & 14
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = rememberTextSelectionColors(r1, r10, r0)
            androidx.compose.runtime.ProvidedValue[] r7 = new androidx.compose.runtime.ProvidedValue[r13]
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material3.ColorSchemeKt.getLocalColorScheme()
            androidx.compose.runtime.ProvidedValue r8 = r8.provides(r1)
            r9 = 0
            r7[r9] = r8
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            androidx.compose.runtime.ProvidedValue r6 = r8.provides(r6)
            r8 = 1
            r7[r8] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material.ripple.RippleThemeKt.getLocalRippleTheme()
            androidx.compose.material3.CompatRippleTheme r9 = androidx.compose.material3.CompatRippleTheme.INSTANCE
            androidx.compose.runtime.ProvidedValue r6 = r6.provides(r9)
            r7[r3] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.ShapesKt.getLocalShapes()
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r14)
            r6 = 3
            r7[r6] = r3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r0 = r3.provides(r0)
            r7[r2] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TypographyKt.getLocalTypography()
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r15)
            r2 = 5
            r7[r2] = r0
            androidx.compose.material3.MaterialThemeKt$MaterialTheme$1 r0 = new androidx.compose.material3.MaterialThemeKt$MaterialTheme$1
            r0.<init>(r15, r4)
            r2 = 54
            r3 = -1066563262(0xffffffffc06d8942, float:-3.7115026)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r8, r0, r10, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r2 = androidx.compose.runtime.ProvidedValue.$stable
            r2 = r2 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r10, (int) r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x015c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015c:
            r2 = r14
            r3 = r15
        L_0x015e:
            androidx.compose.runtime.ScopeUpdateScope r7 = r10.endRestartGroup()
            if (r7 == 0) goto L_0x0170
            androidx.compose.material3.MaterialThemeKt$MaterialTheme$2 r0 = new androidx.compose.material3.MaterialThemeKt$MaterialTheme$2
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.MaterialTheme(androidx.compose.material3.ColorScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void MaterialExpressiveTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Typography typography2;
        int i4 = i;
        Composer composer2 = composer;
        Composer startRestartGroup = composer.startRestartGroup(-1399457222);
        ComposerKt.sourceInformation(startRestartGroup, "C(MaterialExpressiveTheme)P(!1,2,3)134@5791L7:MaterialTheme.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) colorScheme) ? 4 : 2) | i4;
        } else {
            i3 = i4;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i4 & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) shapes) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i4 & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) typography) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i4 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            Typography typography3 = null;
            if (i5 != 0) {
                colorScheme = null;
            }
            if (i6 != 0) {
                shapes = null;
            }
            if (i7 == 0) {
                typography3 = typography;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1399457222, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:133)");
            }
            ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalUsingExpressiveTheme;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (((Boolean) consume).booleanValue()) {
                startRestartGroup.startReplaceGroup(547059915);
                ComposerKt.sourceInformation(startRestartGroup, "135@5810L240");
                startRestartGroup.startReplaceGroup(1126027167);
                ComposerKt.sourceInformation(startRestartGroup, "136@5880L11");
                ColorScheme colorScheme2 = colorScheme == null ? MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6) : colorScheme;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1126029309);
                ComposerKt.sourceInformation(startRestartGroup, "137@5946L10");
                Typography typography4 = typography3 == null ? MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6) : typography3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1126031253);
                ComposerKt.sourceInformation(startRestartGroup, "138@6003L6");
                Shapes shapes2 = shapes == null ? MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6) : shapes;
                startRestartGroup.endReplaceGroup();
                MaterialTheme(colorScheme2, shapes2, typography4, function2, startRestartGroup, i3 & 7168, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(547327197);
                ComposerKt.sourceInformation(startRestartGroup, "142@6138L412,142@6072L478");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) providableCompositionLocal.provides(true), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2050809758, true, new MaterialThemeKt$MaterialExpressiveTheme$1(colorScheme, shapes, typography3, function2), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
        } else {
            startRestartGroup.skipToGroupEnd();
            typography2 = typography;
        }
        ColorScheme colorScheme3 = colorScheme;
        Shapes shapes3 = shapes;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MaterialThemeKt$MaterialExpressiveTheme$2(colorScheme3, shapes3, typography2, function2, i4, i2));
        }
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1866455512, "C(rememberTextSelectionColors)161@6816L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        }
        long r3 = colorScheme.m1867getPrimary0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(composer, -1160063291, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean changed = composer.changed(r3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(r3, Color.m4238copywmQWz5c$default(r3, 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
            composer.updateRememberedValue(textSelectionColors);
            rememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }
}
