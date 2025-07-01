package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010&J\u0001\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020!2\b\b\u0002\u0010,\u001a\u00020!2\b\b\u0002\u0010-\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010/\u001a\u00020!2\b\b\u0002\u00100\u001a\u00020!2\b\b\u0002\u00101\u001a\u00020!2\b\b\u0002\u00102\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104J'\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010:R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/material3/SegmentedButtonDefaults;", "", "()V", "BorderWidth", "Landroidx/compose/ui/unit/Dp;", "getBorderWidth-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "baseShape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getBaseShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "defaultSegmentedButtonColors", "Landroidx/compose/material3/SegmentedButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSegmentedButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SegmentedButtonColors;", "ActiveIcon", "", "(Landroidx/compose/runtime/Composer;I)V", "Icon", "active", "", "activeContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "inactiveContent", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "color", "Landroidx/compose/ui/graphics/Color;", "width", "borderStroke-l07J4OM", "(JF)Landroidx/compose/foundation/BorderStroke;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SegmentedButtonColors;", "activeContainerColor", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "colors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SegmentedButtonColors;", "itemShape", "Landroidx/compose/ui/graphics/Shape;", "index", "", "count", "(IILandroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
public final class SegmentedButtonDefaults {
    public static final int $stable = 0;
    private static final float BorderWidth = OutlinedSegmentedButtonTokens.INSTANCE.m3381getOutlineWidthD9Ej5fM();
    public static final SegmentedButtonDefaults INSTANCE = new SegmentedButtonDefaults();
    private static final float IconSize = OutlinedSegmentedButtonTokens.INSTANCE.m3380getIconSizeD9Ej5fM();

    private SegmentedButtonDefaults() {
    }

    public final SegmentedButtonColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 679457321, "C(colors)431@18542L11:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(679457321, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:431)");
        }
        SegmentedButtonColors defaultSegmentedButtonColors$material3_release = getDefaultSegmentedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSegmentedButtonColors$material3_release;
    }

    /* renamed from: colors-XqyqHi0  reason: not valid java name */
    public final SegmentedButtonColors m2437colorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, 132526205, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,9:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color,6:c#ui.graphics.Color)467@20709L11:SegmentedButton.kt#uh7d8r");
        long r7 = (i4 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i4 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r11 = (i4 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i4 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r15 = (i4 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r17 = (i4 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r19 = (i4 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        long r21 = (i4 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j8;
        long r23 = (i4 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j9;
        long r25 = (i4 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j10;
        long r27 = (i4 & 1024) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j11;
        long r29 = (i4 & 2048) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(132526205, i, i2, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:467)");
        }
        SegmentedButtonColors r1 = getDefaultSegmentedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2421copy2qZNXz8(r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SegmentedButtonColors defaultSegmentedButtonColorsCached$material3_release = colorScheme2.getDefaultSegmentedButtonColorsCached$material3_release();
        if (defaultSegmentedButtonColorsCached$material3_release != null) {
            return defaultSegmentedButtonColorsCached$material3_release;
        }
        SegmentedButtonColors segmentedButtonColors = new SegmentedButtonColors(ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), colorScheme2.m1872getSurface0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultSegmentedButtonColorsCached$material3_release(segmentedButtonColors);
        return segmentedButtonColors;
    }

    public final CornerBasedShape getBaseShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1264240381, "C512@23272L5:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264240381, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.<get-baseShape> (SegmentedButton.kt:512)");
        }
        Shape value = ShapesKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getShape(), composer, 6);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cornerBasedShape;
    }

    /* renamed from: getBorderWidth-D9Ej5fM  reason: not valid java name */
    public final float m2438getBorderWidthD9Ej5fM() {
        return BorderWidth;
    }

    public final Shape itemShape(int i, int i2, CornerBasedShape cornerBasedShape, Composer composer, int i3, int i4) {
        Shape shape;
        ComposerKt.sourceInformationMarkerStart(composer, -942072063, "C(itemShape)P(2,1)528@23938L9:SegmentedButton.kt#uh7d8r");
        if ((i4 & 4) != 0) {
            cornerBasedShape = getBaseShape(composer, (i3 >> 9) & 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942072063, i3, -1, "androidx.compose.material3.SegmentedButtonDefaults.itemShape (SegmentedButton.kt:528)");
        }
        if (i2 == 1) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return cornerBasedShape;
        }
        if (i == 0) {
            shape = ShapesKt.start(cornerBasedShape);
        } else if (i == i2 - 1) {
            shape = ShapesKt.end(cornerBasedShape);
        } else {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2439getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final void ActiveIcon(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1273041460);
        ComposerKt.sourceInformation(startRestartGroup, "C(ActiveIcon)546@24428L147:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1273041460, i2, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:545)");
            }
            IconKt.m2124Iconww6aTOc(CheckKt.getCheck(Icons.Filled.INSTANCE), (String) null, SizeKt.m845size3ABfNKs(Modifier.Companion, IconSize), 0, startRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SegmentedButtonDefaults$ActiveIcon$1(this, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Icon(boolean r17, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r16 = this;
            r5 = r21
            r0 = 683517296(0x28bda570, float:2.1054962E-14)
            r1 = r20
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Icon):SegmentedButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r22 & 1
            r2 = 2
            if (r1 == 0) goto L_0x001a
            r1 = r5 | 6
            r6 = r17
            goto L_0x002c
        L_0x001a:
            r1 = r5 & 6
            r6 = r17
            if (r1 != 0) goto L_0x002b
            boolean r1 = r11.changed((boolean) r6)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            r1 = r1 | r5
            goto L_0x002c
        L_0x002b:
            r1 = r5
        L_0x002c:
            r3 = r22 & 2
            if (r3 == 0) goto L_0x0033
            r1 = r1 | 48
            goto L_0x0046
        L_0x0033:
            r4 = r5 & 48
            if (r4 != 0) goto L_0x0046
            r4 = r18
            boolean r7 = r11.changedInstance(r4)
            if (r7 == 0) goto L_0x0042
            r7 = 32
            goto L_0x0044
        L_0x0042:
            r7 = 16
        L_0x0044:
            r1 = r1 | r7
            goto L_0x0048
        L_0x0046:
            r4 = r18
        L_0x0048:
            r7 = r22 & 4
            if (r7 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0062
            r8 = r19
            boolean r9 = r11.changedInstance(r8)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r9
            goto L_0x0064
        L_0x0062:
            r8 = r19
        L_0x0064:
            r9 = r1 & 147(0x93, float:2.06E-43)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x0078
            boolean r9 = r11.getSkipping()
            if (r9 != 0) goto L_0x0071
            goto L_0x0078
        L_0x0071:
            r11.skipToGroupEnd()
            r3 = r4
            r4 = r8
            goto L_0x012c
        L_0x0078:
            if (r3 == 0) goto L_0x0081
            androidx.compose.material3.ComposableSingletons$SegmentedButtonKt r3 = androidx.compose.material3.ComposableSingletons$SegmentedButtonKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1937getLambda1$material3_release()
            goto L_0x0082
        L_0x0081:
            r3 = r4
        L_0x0082:
            r4 = 0
            if (r7 == 0) goto L_0x0087
            r15 = r4
            goto L_0x0088
        L_0x0087:
            r15 = r8
        L_0x0088:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0094
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.SegmentedButtonDefaults.Icon (SegmentedButton.kt:566)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r7, r8)
        L_0x0094:
            r7 = 1
            if (r15 != 0) goto L_0x00f1
            r8 = 1631306250(0x613bc20a, float:2.164702E20)
            r11.startReplaceGroup(r8)
            java.lang.String r8 = "578@25645L47,568@25168L524"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r8)
            androidx.compose.animation.ExitTransition$Companion r8 = androidx.compose.animation.ExitTransition.Companion
            androidx.compose.animation.ExitTransition r9 = r8.getNone()
            r8 = 350(0x15e, float:4.9E-43)
            r10 = 0
            r12 = 6
            androidx.compose.animation.core.TweenSpec r13 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r8, r10, r4, r12, r4)
            androidx.compose.animation.core.FiniteAnimationSpec r13 = (androidx.compose.animation.core.FiniteAnimationSpec) r13
            r14 = 0
            androidx.compose.animation.EnterTransition r2 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r14, r2, r4)
            r13 = 1065353216(0x3f800000, float:1.0)
            r20 = r1
            long r0 = androidx.compose.ui.graphics.TransformOriginKt.TransformOrigin(r14, r13)
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r8, r10, r4, r12, r4)
            androidx.compose.animation.core.FiniteAnimationSpec r4 = (androidx.compose.animation.core.FiniteAnimationSpec) r4
            androidx.compose.animation.EnterTransition r0 = androidx.compose.animation.EnterExitTransitionKt.m79scaleInL8ZKhE(r4, r14, r0)
            androidx.compose.animation.EnterTransition r8 = r2.plus(r0)
            androidx.compose.material3.SegmentedButtonDefaults$Icon$1 r0 = new androidx.compose.material3.SegmentedButtonDefaults$Icon$1
            r0.<init>(r3)
            r1 = -750750819(0xffffffffd340739d, float:-8.2657339E11)
            r2 = 54
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r7, r0, r11, r2)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 196608(0x30000, float:2.75506E-40)
            r2 = r20 & 14
            r13 = r2 | r1
            r14 = 18
            r7 = 0
            r10 = 0
            r12 = r11
            r11 = r0
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r6, (androidx.compose.ui.Modifier) r7, (androidx.compose.animation.EnterTransition) r8, (androidx.compose.animation.ExitTransition) r9, (java.lang.String) r10, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r11, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            r11 = r12
            r11.endReplaceGroup()
            goto L_0x0122
        L_0x00f1:
            r20 = r1
            r0 = 1631842116(0x6143ef44, float:2.2589725E20)
            r11.startReplaceGroup(r0)
            java.lang.String r0 = "582@25754L50,582@25722L82"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r17)
            androidx.compose.material3.SegmentedButtonDefaults$Icon$2 r0 = new androidx.compose.material3.SegmentedButtonDefaults$Icon$2
            r0.<init>(r3, r15)
            r1 = -1364873619(0xffffffffaea5ae6d, float:-7.5343155E-11)
            r2 = 54
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r7, r0, r11, r2)
            r10 = r0
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            r0 = r20 & 14
            r12 = r0 | 24576(0x6000, float:3.4438E-41)
            r13 = 14
            r7 = 0
            r8 = 0
            r9 = 0
            androidx.compose.animation.CrossfadeKt.Crossfade(r6, (androidx.compose.ui.Modifier) r7, (androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float>) r8, (java.lang.String) r9, r10, (androidx.compose.runtime.Composer) r11, (int) r12, (int) r13)
            r11.endReplaceGroup()
        L_0x0122:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x012b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x012b:
            r4 = r15
        L_0x012c:
            androidx.compose.runtime.ScopeUpdateScope r7 = r11.endRestartGroup()
            if (r7 == 0) goto L_0x0142
            androidx.compose.material3.SegmentedButtonDefaults$Icon$3 r0 = new androidx.compose.material3.SegmentedButtonDefaults$Icon$3
            r1 = r16
            r2 = r17
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonDefaults.Icon(boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: borderStroke-l07J4OM$default  reason: not valid java name */
    public static /* synthetic */ BorderStroke m2435borderStrokel07J4OM$default(SegmentedButtonDefaults segmentedButtonDefaults, long j, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = BorderWidth;
        }
        return segmentedButtonDefaults.m2436borderStrokel07J4OM(j, f);
    }

    /* renamed from: borderStroke-l07J4OM  reason: not valid java name */
    public final BorderStroke m2436borderStrokel07J4OM(long j, float f) {
        return BorderStrokeKt.m275BorderStrokecXLIe8U(f, j);
    }
}
