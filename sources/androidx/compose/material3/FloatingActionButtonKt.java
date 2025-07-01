package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.messaging.ServiceStarter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u001a|\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001aq\u0010&\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aq\u0010)\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u001aq\u0010+\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public final class FloatingActionButtonKt {
    /* access modifiers changed from: private */
    public static final ExitTransition ExtendedFabCollapseAnimation = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, MotionTokens.INSTANCE.getEasingLinearCubicBezier(), 2, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(ServiceStarter.ERROR_UNKNOWN, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, (Object) null), Alignment.Companion.getStart(), false, (Function1) null, 12, (Object) null));
    /* access modifiers changed from: private */
    public static final float ExtendedFabEndIconPadding = Dp.m7111constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final EnterTransition ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, MotionTokens.INSTANCE.getEasingLinearCubicBezier()), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(ServiceStarter.ERROR_UNKNOWN, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, (Object) null), Alignment.Companion.getStart(), false, (Function1) null, 12, (Object) null));
    /* access modifiers changed from: private */
    public static final float ExtendedFabMinimumWidth = Dp.m7111constructorimpl((float) 80);
    /* access modifiers changed from: private */
    public static final float ExtendedFabStartIconPadding = Dp.m7111constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final float ExtendedFabTextPadding = Dp.m7111constructorimpl((float) 20);

    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010e  */
    /* renamed from: FloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2099FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, androidx.compose.material3.FloatingActionButtonElevation r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r10 = r41
            r11 = r43
            r12 = r44
            r0 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
            r1 = r42
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)100@4948L5,101@5012L14,102@5054L31,103@5163L11,116@5678L54,118@5792L536,109@5399L929:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r11 | 6
            r13 = r32
            goto L_0x002f
        L_0x001d:
            r1 = r11 & 6
            r13 = r32
            if (r1 != 0) goto L_0x002e
            boolean r1 = r6.changedInstance(r13)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r11
            goto L_0x002f
        L_0x002e:
            r1 = r11
        L_0x002f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0049
        L_0x0036:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0049
            r3 = r33
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
            goto L_0x004b
        L_0x0049:
            r3 = r33
        L_0x004b:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0064
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005e
            r4 = r34
            boolean r5 = r6.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r4 = r34
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r5
            goto L_0x0066
        L_0x0064:
            r4 = r34
        L_0x0066:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007d
            r5 = r12 & 8
            r7 = r35
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6.changed((long) r7)
            if (r5 == 0) goto L_0x0079
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r5
            goto L_0x007f
        L_0x007d:
            r7 = r35
        L_0x007f:
            r5 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x0096
            r5 = r12 & 16
            r14 = r37
            if (r5 != 0) goto L_0x0092
            boolean r5 = r6.changed((long) r14)
            if (r5 == 0) goto L_0x0092
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r5
            goto L_0x0098
        L_0x0096:
            r14 = r37
        L_0x0098:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r11
            if (r5 != 0) goto L_0x00b2
            r5 = r12 & 32
            if (r5 != 0) goto L_0x00ac
            r5 = r39
            boolean r9 = r6.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x00ae
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r5 = r39
        L_0x00ae:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r9
            goto L_0x00b4
        L_0x00b2:
            r5 = r39
        L_0x00b4:
            r9 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r9 == 0) goto L_0x00bf
            r1 = r1 | r16
            r0 = r40
            goto L_0x00d2
        L_0x00bf:
            r16 = r11 & r16
            r0 = r40
            if (r16 != 0) goto L_0x00d2
            boolean r17 = r6.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ce
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r17
        L_0x00d2:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00db
            r1 = r1 | r17
            goto L_0x00eb
        L_0x00db:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00eb
            boolean r0 = r6.changedInstance(r10)
            if (r0 == 0) goto L_0x00e8
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r1 = r1 | r0
        L_0x00eb:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r1
            r42 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x010e
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x00fd
            goto L_0x010e
        L_0x00fd:
            r6.skipToGroupEnd()
            r9 = r40
            r2 = r3
            r3 = r4
            r26 = r6
            r30 = r7
            r8 = r5
            r4 = r30
            r6 = r14
            goto L_0x026b
        L_0x010e:
            r6.startDefaults()
            r0 = r11 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x014a
            boolean r0 = r6.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0122
            goto L_0x014a
        L_0x0122:
            r6.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012b
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012b:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0131
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0131:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0137
            r1 = r1 & r18
        L_0x0137:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013d
            r1 = r1 & r17
        L_0x013d:
            r2 = r1
            r16 = r4
            r17 = r7
            r0 = 0
            r4 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
        L_0x0146:
            r1 = r40
            goto L_0x01bd
        L_0x014a:
            if (r42 == 0) goto L_0x0151
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0152
        L_0x0151:
            r0 = r3
        L_0x0152:
            r3 = r12 & 4
            r2 = 6
            if (r3 == 0) goto L_0x0162
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r6, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r19 = r3
            goto L_0x0164
        L_0x0162:
            r19 = r4
        L_0x0164:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0176
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r3.getContainerColor(r6, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r30 = r2
            r3 = r1
            r1 = r30
            goto L_0x0178
        L_0x0176:
            r3 = r1
            r1 = r7
        L_0x0178:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x0187
            int r4 = r3 >> 9
            r4 = r4 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r1, r6, r4)
            r3 = r3 & r18
            r14 = r7
        L_0x0187:
            r18 = r3
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01a9
            r7 = r1
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r2 = r7
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r20 = r4
            r4 = 0
            r5 = 0
            r33 = r0
            r0 = 0
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m2091elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r18 & r17
            r5 = r1
            r1 = r2
            goto L_0x01b0
        L_0x01a9:
            r33 = r0
            r20 = r1
            r0 = 0
            r1 = r18
        L_0x01b0:
            r3 = r33
            r2 = r1
            r16 = r19
            r17 = r20
            r4 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
            if (r9 == 0) goto L_0x0146
            r1 = r0
        L_0x01bd:
            r6.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x01cc
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:106)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r2, r7, r8)
        L_0x01cc:
            r4 = 519755085(0x1efad54d, float:2.6557999E-20)
            r6.startReplaceGroup(r4)
            java.lang.String r4 = "108@5355L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r4)
            if (r1 != 0) goto L_0x01fc
            r4 = 519755736(0x1efad7d8, float:2.655905E-20)
            java.lang.String r7 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r7)
            java.lang.Object r4 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r4 != r7) goto L_0x01f4
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r4)
        L_0x01f4:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r24 = r4
            goto L_0x01fe
        L_0x01fc:
            r24 = r1
        L_0x01fe:
            r6.endReplaceGroup()
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$1 r4 = androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r7 = 0
            r8 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r7, r4, r8, r0)
            float r21 = r5.m2094tonalElevationD9Ej5fM$material3_release()
            r4 = r24
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            int r7 = r2 >> 12
            r7 = r7 & 112(0x70, float:1.57E-43)
            androidx.compose.runtime.State r4 = r5.shadowElevation$material3_release(r4, r6, r7)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.unit.Dp r4 = (androidx.compose.ui.unit.Dp) r4
            float r22 = r4.m7125unboximpl()
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2 r4 = new androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
            r4.<init>(r14, r10)
            r7 = 54
            r9 = 1249316354(0x4a770e02, float:4047744.5)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r8, r4, r6, r7)
            r25 = r4
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r4 = r2 & 14
            int r2 = r2 << 3
            r7 = r2 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r2
            r4 = r4 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r7
            r27 = r4 | r2
            r28 = 6
            r29 = 260(0x104, float:3.64E-43)
            r19 = r14
            r15 = 0
            r23 = 0
            r14 = r0
            r26 = r6
            androidx.compose.material3.SurfaceKt.m2539Surfaceo_FOJdg(r13, r14, r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0260
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0260:
            r9 = r1
            r2 = r3
            r8 = r5
            r26 = r6
            r3 = r16
            r4 = r17
            r6 = r19
        L_0x026b:
            androidx.compose.runtime.ScopeUpdateScope r13 = r26.endRestartGroup()
            if (r13 == 0) goto L_0x027d
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3 r0 = new androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
            r1 = r32
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x027d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2099FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0111  */
    /* renamed from: SmallFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2101SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.material3.FloatingActionButtonElevation r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r11 = r39
            r12 = r40
            r0 = 1444748300(0x561d1c0c, float:4.3185946E13)
            r1 = r38
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SmallFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)170@8224L10,171@8293L14,172@8335L31,173@8444L11,177@8559L455:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r13 = r28
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r13 = r28
            if (r1 != 0) goto L_0x002c
            boolean r1 = r6.changedInstance(r13)
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
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0047
            r3 = r29
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r29
        L_0x0049:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005c
            r4 = r30
            boolean r5 = r6.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r4 = r30
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r30
        L_0x0064:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007b
            r5 = r12 & 8
            r7 = r31
            if (r5 != 0) goto L_0x0077
            boolean r5 = r6.changed((long) r7)
            if (r5 == 0) goto L_0x0077
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r5
            goto L_0x007d
        L_0x007b:
            r7 = r31
        L_0x007d:
            r5 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x0094
            r5 = r12 & 16
            r9 = r33
            if (r5 != 0) goto L_0x0090
            boolean r5 = r6.changed((long) r9)
            if (r5 == 0) goto L_0x0090
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r1 = r1 | r5
            goto L_0x0096
        L_0x0094:
            r9 = r33
        L_0x0096:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r11
            if (r5 != 0) goto L_0x00b0
            r5 = r12 & 32
            if (r5 != 0) goto L_0x00aa
            r5 = r35
            boolean r14 = r6.changed((java.lang.Object) r5)
            if (r14 == 0) goto L_0x00ac
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00aa:
            r5 = r35
        L_0x00ac:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r1 = r1 | r14
            goto L_0x00b2
        L_0x00b0:
            r5 = r35
        L_0x00b2:
            r14 = r12 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00ba
            r1 = r1 | r15
            goto L_0x00cd
        L_0x00ba:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00cd
            r15 = r36
            boolean r16 = r6.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00c8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ca:
            r1 = r1 | r16
            goto L_0x00cf
        L_0x00cd:
            r15 = r36
        L_0x00cf:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00d8
            r1 = r1 | r17
            goto L_0x00ec
        L_0x00d8:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00ec
            r0 = r37
            boolean r17 = r6.changedInstance(r0)
            if (r17 == 0) goto L_0x00e7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00e7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e9:
            r1 = r1 | r17
            goto L_0x00ee
        L_0x00ec:
            r0 = r37
        L_0x00ee:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r17
            r38 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0111
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x0101
            goto L_0x0111
        L_0x0101:
            r6.skipToGroupEnd()
            r2 = r3
            r3 = r4
            r23 = r6
            r26 = r7
            r8 = r5
            r4 = r26
            r6 = r9
            r9 = r15
            goto L_0x0222
        L_0x0111:
            r6.startDefaults()
            r0 = r11 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x014d
            boolean r0 = r6.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0125
            goto L_0x014d
        L_0x0125:
            r6.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012e
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012e:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0134
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0134:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0139
            r1 = r1 & r2
        L_0x0139:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013f
            r1 = r1 & r17
        L_0x013f:
            r20 = r5
            r16 = r7
            r18 = r9
            r21 = r15
            r0 = 1444748300(0x561d1c0c, float:4.3185946E13)
            r15 = r4
            goto L_0x01cd
        L_0x014d:
            if (r38 == 0) goto L_0x0154
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0154:
            r0 = r3
        L_0x0155:
            r3 = r12 & 4
            r38 = r2
            r2 = 6
            if (r3 == 0) goto L_0x0167
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getSmallShape(r6, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r18 = r3
            goto L_0x0169
        L_0x0167:
            r18 = r4
        L_0x0169:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x017b
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r3.getContainerColor(r6, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r26 = r2
            r3 = r1
            r1 = r26
            goto L_0x017d
        L_0x017b:
            r3 = r1
            r1 = r7
        L_0x017d:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x018c
            int r4 = r3 >> 9
            r4 = r4 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r1, r6, r4)
            r3 = r3 & r38
            r9 = r7
        L_0x018c:
            r19 = r3
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01ab
            r7 = r1
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r2 = r7
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r20 = r4
            r4 = 0
            r5 = 0
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m2091elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r19 & r17
            r5 = r1
            r1 = r2
            goto L_0x01af
        L_0x01ab:
            r20 = r1
            r1 = r19
        L_0x01af:
            if (r14 == 0) goto L_0x01bf
            r2 = 0
            r3 = r0
            r15 = r18
            r16 = r20
            r0 = 1444748300(0x561d1c0c, float:4.3185946E13)
            r21 = r2
            r20 = r5
            goto L_0x01cb
        L_0x01bf:
            r3 = r0
            r16 = r20
            r0 = 1444748300(0x561d1c0c, float:4.3185946E13)
            r20 = r5
            r21 = r15
            r15 = r18
        L_0x01cb:
            r18 = r9
        L_0x01cd:
            r6.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01dc
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:176)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r4)
        L_0x01dc:
            androidx.compose.material3.tokens.FabPrimarySmallTokens r0 = androidx.compose.material3.tokens.FabPrimarySmallTokens.INSTANCE
            float r0 = r0.m3224getContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.FabPrimarySmallTokens r2 = androidx.compose.material3.tokens.FabPrimarySmallTokens.INSTANCE
            float r2 = r2.m3223getContainerHeightD9Ej5fM()
            r4 = 12
            r5 = 0
            r7 = 0
            r8 = 0
            r30 = r0
            r31 = r2
            r29 = r3
            r34 = r4
            r35 = r5
            r32 = r7
            r33 = r8
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m849sizeInqDBjuR0$default(r29, r30, r31, r32, r33, r34, r35)
            r0 = 33554318(0x1ffff8e, float:9.403891E-38)
            r24 = r1 & r0
            r25 = 0
            r22 = r37
            r23 = r6
            m2099FloatingActionButtonXz6DiA(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0216
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0216:
            r2 = r3
            r23 = r6
            r3 = r15
            r4 = r16
            r6 = r18
            r8 = r20
            r9 = r21
        L_0x0222:
            androidx.compose.runtime.ScopeUpdateScope r13 = r23.endRestartGroup()
            if (r13 == 0) goto L_0x0236
            androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$1 r0 = new androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$1
            r1 = r28
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0236:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2101SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0111  */
    /* renamed from: LargeFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2100LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.material3.FloatingActionButtonElevation r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r11 = r39
            r12 = r40
            r0 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            r1 = r38
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LargeFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)226@10910L10,227@10979L14,228@11021L31,229@11130L11,233@11245L455:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r13 = r28
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r13 = r28
            if (r1 != 0) goto L_0x002c
            boolean r1 = r6.changedInstance(r13)
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
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0047
            r3 = r29
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r29
        L_0x0049:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005c
            r4 = r30
            boolean r5 = r6.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r4 = r30
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r30
        L_0x0064:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007b
            r5 = r12 & 8
            r7 = r31
            if (r5 != 0) goto L_0x0077
            boolean r5 = r6.changed((long) r7)
            if (r5 == 0) goto L_0x0077
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r5
            goto L_0x007d
        L_0x007b:
            r7 = r31
        L_0x007d:
            r5 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x0094
            r5 = r12 & 16
            r9 = r33
            if (r5 != 0) goto L_0x0090
            boolean r5 = r6.changed((long) r9)
            if (r5 == 0) goto L_0x0090
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r1 = r1 | r5
            goto L_0x0096
        L_0x0094:
            r9 = r33
        L_0x0096:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r11
            if (r5 != 0) goto L_0x00b0
            r5 = r12 & 32
            if (r5 != 0) goto L_0x00aa
            r5 = r35
            boolean r14 = r6.changed((java.lang.Object) r5)
            if (r14 == 0) goto L_0x00ac
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00aa:
            r5 = r35
        L_0x00ac:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r1 = r1 | r14
            goto L_0x00b2
        L_0x00b0:
            r5 = r35
        L_0x00b2:
            r14 = r12 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00ba
            r1 = r1 | r15
            goto L_0x00cd
        L_0x00ba:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00cd
            r15 = r36
            boolean r16 = r6.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00c8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ca:
            r1 = r1 | r16
            goto L_0x00cf
        L_0x00cd:
            r15 = r36
        L_0x00cf:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00d8
            r1 = r1 | r17
            goto L_0x00ec
        L_0x00d8:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00ec
            r0 = r37
            boolean r17 = r6.changedInstance(r0)
            if (r17 == 0) goto L_0x00e7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00e7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e9:
            r1 = r1 | r17
            goto L_0x00ee
        L_0x00ec:
            r0 = r37
        L_0x00ee:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r17
            r38 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0111
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x0101
            goto L_0x0111
        L_0x0101:
            r6.skipToGroupEnd()
            r2 = r3
            r3 = r4
            r23 = r6
            r26 = r7
            r8 = r5
            r4 = r26
            r6 = r9
            r9 = r15
            goto L_0x0222
        L_0x0111:
            r6.startDefaults()
            r0 = r11 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x014d
            boolean r0 = r6.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0125
            goto L_0x014d
        L_0x0125:
            r6.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012e
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012e:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0134
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0134:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0139
            r1 = r1 & r2
        L_0x0139:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013f
            r1 = r1 & r17
        L_0x013f:
            r20 = r5
            r16 = r7
            r18 = r9
            r21 = r15
            r0 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            r15 = r4
            goto L_0x01cd
        L_0x014d:
            if (r38 == 0) goto L_0x0154
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0154:
            r0 = r3
        L_0x0155:
            r3 = r12 & 4
            r38 = r2
            r2 = 6
            if (r3 == 0) goto L_0x0167
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getLargeShape(r6, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r18 = r3
            goto L_0x0169
        L_0x0167:
            r18 = r4
        L_0x0169:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x017b
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r3.getContainerColor(r6, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r26 = r2
            r3 = r1
            r1 = r26
            goto L_0x017d
        L_0x017b:
            r3 = r1
            r1 = r7
        L_0x017d:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x018c
            int r4 = r3 >> 9
            r4 = r4 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r1, r6, r4)
            r3 = r3 & r38
            r9 = r7
        L_0x018c:
            r19 = r3
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01ab
            r7 = r1
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r2 = r7
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r20 = r4
            r4 = 0
            r5 = 0
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m2091elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r19 & r17
            r5 = r1
            r1 = r2
            goto L_0x01af
        L_0x01ab:
            r20 = r1
            r1 = r19
        L_0x01af:
            if (r14 == 0) goto L_0x01bf
            r2 = 0
            r3 = r0
            r15 = r18
            r16 = r20
            r0 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            r21 = r2
            r20 = r5
            goto L_0x01cb
        L_0x01bf:
            r3 = r0
            r16 = r20
            r0 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            r20 = r5
            r21 = r15
            r15 = r18
        L_0x01cb:
            r18 = r9
        L_0x01cd:
            r6.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01dc
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:232)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r4)
        L_0x01dc:
            androidx.compose.material3.tokens.FabPrimaryLargeTokens r0 = androidx.compose.material3.tokens.FabPrimaryLargeTokens.INSTANCE
            float r0 = r0.m3213getContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.FabPrimaryLargeTokens r2 = androidx.compose.material3.tokens.FabPrimaryLargeTokens.INSTANCE
            float r2 = r2.m3212getContainerHeightD9Ej5fM()
            r4 = 12
            r5 = 0
            r7 = 0
            r8 = 0
            r30 = r0
            r31 = r2
            r29 = r3
            r34 = r4
            r35 = r5
            r32 = r7
            r33 = r8
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m849sizeInqDBjuR0$default(r29, r30, r31, r32, r33, r34, r35)
            r0 = 33554318(0x1ffff8e, float:9.403891E-38)
            r24 = r1 & r0
            r25 = 0
            r22 = r37
            r23 = r6
            m2099FloatingActionButtonXz6DiA(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0216
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0216:
            r2 = r3
            r23 = r6
            r3 = r15
            r4 = r16
            r6 = r18
            r8 = r20
            r9 = r21
        L_0x0222:
            androidx.compose.runtime.ScopeUpdateScope r13 = r23.endRestartGroup()
            if (r13 == 0) goto L_0x0236
            androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$1 r0 = new androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$1
            r1 = r28
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0236:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2100LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010e  */
    /* renamed from: ExtendedFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2098ExtendedFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.material3.FloatingActionButtonElevation r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r10 = r37
            r11 = r39
            r12 = r40
            r0 = -326283107(0xffffffffec8d509d, float:-1.3667138E27)
            r1 = r38
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExtendedFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)285@13734L16,286@13809L14,287@13851L31,288@13960L11,300@14347L335,292@14084L598:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r11 | 6
            r13 = r28
            goto L_0x002f
        L_0x001d:
            r1 = r11 & 6
            r13 = r28
            if (r1 != 0) goto L_0x002e
            boolean r1 = r6.changedInstance(r13)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r11
            goto L_0x002f
        L_0x002e:
            r1 = r11
        L_0x002f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0049
        L_0x0036:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0049
            r3 = r29
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
            goto L_0x004b
        L_0x0049:
            r3 = r29
        L_0x004b:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0064
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005e
            r4 = r30
            boolean r5 = r6.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r4 = r30
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r5
            goto L_0x0066
        L_0x0064:
            r4 = r30
        L_0x0066:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007d
            r5 = r12 & 8
            r7 = r31
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6.changed((long) r7)
            if (r5 == 0) goto L_0x0079
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r5
            goto L_0x007f
        L_0x007d:
            r7 = r31
        L_0x007f:
            r5 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x0096
            r5 = r12 & 16
            r14 = r33
            if (r5 != 0) goto L_0x0092
            boolean r5 = r6.changed((long) r14)
            if (r5 == 0) goto L_0x0092
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r5
            goto L_0x0098
        L_0x0096:
            r14 = r33
        L_0x0098:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r11
            if (r5 != 0) goto L_0x00b2
            r5 = r12 & 32
            if (r5 != 0) goto L_0x00ac
            r5 = r35
            boolean r9 = r6.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x00ae
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r5 = r35
        L_0x00ae:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r9
            goto L_0x00b4
        L_0x00b2:
            r5 = r35
        L_0x00b4:
            r9 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r9 == 0) goto L_0x00bf
            r1 = r1 | r16
            r0 = r36
            goto L_0x00d2
        L_0x00bf:
            r16 = r11 & r16
            r0 = r36
            if (r16 != 0) goto L_0x00d2
            boolean r17 = r6.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ce
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r17
        L_0x00d2:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00db
            r1 = r1 | r17
            goto L_0x00eb
        L_0x00db:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00eb
            boolean r0 = r6.changedInstance(r10)
            if (r0 == 0) goto L_0x00e8
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r1 = r1 | r0
        L_0x00eb:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r1
            r38 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x010e
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x00fd
            goto L_0x010e
        L_0x00fd:
            r6.skipToGroupEnd()
            r9 = r36
            r2 = r3
            r3 = r4
            r23 = r6
            r26 = r7
            r8 = r5
            r4 = r26
            r6 = r14
            goto L_0x022f
        L_0x010e:
            r6.startDefaults()
            r0 = r11 & 1
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x014d
            boolean r0 = r6.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0122
            goto L_0x014d
        L_0x0122:
            r6.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012b
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012b:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0131
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0131:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0136
            r1 = r1 & r2
        L_0x0136:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013c
            r1 = r1 & r18
        L_0x013c:
            r21 = r36
            r20 = r5
            r18 = r14
            r0 = r17
            r2 = -326283107(0xffffffffec8d509d, float:-1.3667138E27)
            r14 = r3
            r15 = r4
            r16 = r7
            goto L_0x01d7
        L_0x014d:
            if (r38 == 0) goto L_0x0154
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0154:
            r0 = r3
        L_0x0155:
            r3 = r12 & 4
            r38 = r2
            r2 = 6
            if (r3 == 0) goto L_0x0167
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getExtendedFabShape(r6, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r19 = r3
            goto L_0x0169
        L_0x0167:
            r19 = r4
        L_0x0169:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x017b
            androidx.compose.material3.FloatingActionButtonDefaults r3 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r3.getContainerColor(r6, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r26 = r2
            r3 = r1
            r1 = r26
            goto L_0x017d
        L_0x017b:
            r3 = r1
            r1 = r7
        L_0x017d:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x018c
            int r4 = r3 >> 9
            r4 = r4 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r1, r6, r4)
            r3 = r3 & r38
            r14 = r7
        L_0x018c:
            r20 = r3
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01ab
            r7 = r1
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r2 = r7
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r21 = r4
            r4 = 0
            r5 = 0
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m2091elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r20 & r18
            r5 = r1
            r1 = r2
            goto L_0x01af
        L_0x01ab:
            r21 = r1
            r1 = r20
        L_0x01af:
            if (r9 == 0) goto L_0x01c5
            r2 = 0
            r26 = r14
            r15 = r19
            r18 = r26
            r14 = r0
            r20 = r5
            r0 = r17
            r16 = r21
            r21 = r2
            r2 = -326283107(0xffffffffec8d509d, float:-1.3667138E27)
            goto L_0x01d7
        L_0x01c5:
            r26 = r14
            r15 = r19
            r18 = r26
            r14 = r0
            r20 = r5
            r0 = r17
            r16 = r21
            r2 = -326283107(0xffffffffec8d509d, float:-1.3667138E27)
            r21 = r36
        L_0x01d7:
            r6.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01e6
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:291)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r3, r4)
        L_0x01e6:
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$1 r2 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$1
            r2.<init>(r10)
            r3 = 54
            r4 = 398457247(0x17bff99f, float:1.2406099E-24)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r5, r2, r6, r3)
            r22 = r2
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r2 = r1 & 14
            r0 = r0 | r2
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r2
            r24 = r0 | r1
            r25 = 0
            r23 = r6
            m2099FloatingActionButtonXz6DiA(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0223
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0223:
            r23 = r6
            r2 = r14
            r3 = r15
            r4 = r16
            r6 = r18
            r8 = r20
            r9 = r21
        L_0x022f:
            androidx.compose.runtime.ScopeUpdateScope r13 = r23.endRestartGroup()
            if (r13 == 0) goto L_0x0241
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2 r0 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
            r1 = r28
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0241:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2098ExtendedFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0115  */
    /* renamed from: ExtendedFloatingActionButton-ElI5-7k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2097ExtendedFloatingActionButtonElI57k(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.ui.graphics.Shape r33, long r34, long r36, androidx.compose.material3.FloatingActionButtonElevation r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r1 = r28
            r2 = r29
            r13 = r41
            r14 = r42
            r0 = -1387401842(0xffffffffad4ded8e, float:-1.1705649E-11)
            r3 = r40
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(ExtendedFloatingActionButton)P(9,4,7,6,3,8,0:c#ui.graphics.Color,1:c#ui.graphics.Color)359@17300L16,360@17375L14,361@17417L31,362@17526L11,373@17867L1053,365@17604L1316:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r14 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r13 | 6
            goto L_0x002d
        L_0x001d:
            r4 = r13 & 6
            if (r4 != 0) goto L_0x002c
            boolean r4 = r3.changedInstance(r1)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r13
            goto L_0x002d
        L_0x002c:
            r4 = r13
        L_0x002d:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0044
        L_0x0034:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x0044
            boolean r5 = r3.changedInstance(r2)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r4 = r4 | r5
        L_0x0044:
            r5 = r14 & 4
            if (r5 == 0) goto L_0x004d
            r4 = r4 | 384(0x180, float:5.38E-43)
            r15 = r30
            goto L_0x005f
        L_0x004d:
            r5 = r13 & 384(0x180, float:5.38E-43)
            r15 = r30
            if (r5 != 0) goto L_0x005f
            boolean r5 = r3.changedInstance(r15)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r4 = r4 | r5
        L_0x005f:
            r5 = r14 & 8
            if (r5 == 0) goto L_0x0066
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r6 = r13 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0079
            r6 = r31
            boolean r7 = r3.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0075
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r4 = r4 | r7
            goto L_0x007b
        L_0x0079:
            r6 = r31
        L_0x007b:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0082
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r8 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0095
            r8 = r32
            boolean r9 = r3.changed((boolean) r8)
            if (r9 == 0) goto L_0x0091
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r4 = r4 | r9
            goto L_0x0097
        L_0x0095:
            r8 = r32
        L_0x0097:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00b1
            r9 = r14 & 32
            if (r9 != 0) goto L_0x00ab
            r9 = r33
            boolean r10 = r3.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00ad
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ab:
            r9 = r33
        L_0x00ad:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r4 = r4 | r10
            goto L_0x00b3
        L_0x00b1:
            r9 = r33
        L_0x00b3:
            r10 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00cd
            r10 = r14 & 64
            if (r10 != 0) goto L_0x00c7
            r10 = r34
            boolean r12 = r3.changed((long) r10)
            if (r12 == 0) goto L_0x00c9
            r12 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cb
        L_0x00c7:
            r10 = r34
        L_0x00c9:
            r12 = 524288(0x80000, float:7.34684E-40)
        L_0x00cb:
            r4 = r4 | r12
            goto L_0x00cf
        L_0x00cd:
            r10 = r34
        L_0x00cf:
            r12 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r13 & r12
            if (r16 != 0) goto L_0x00eb
            r40 = r12
            r12 = r14 & 128(0x80, float:1.794E-43)
            r0 = r36
            if (r12 != 0) goto L_0x00e6
            boolean r16 = r3.changed((long) r0)
            if (r16 == 0) goto L_0x00e6
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e8
        L_0x00e6:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e8:
            r4 = r4 | r16
            goto L_0x00ef
        L_0x00eb:
            r0 = r36
            r40 = r12
        L_0x00ef:
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x010b
            r12 = r14 & 256(0x100, float:3.59E-43)
            if (r12 != 0) goto L_0x0104
            r12 = r38
            boolean r17 = r3.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x0106
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0108
        L_0x0104:
            r12 = r38
        L_0x0106:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0108:
            r4 = r4 | r17
            goto L_0x010d
        L_0x010b:
            r12 = r38
        L_0x010d:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r1 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0115
            r4 = r4 | r1
            goto L_0x0128
        L_0x0115:
            r1 = r1 & r13
            if (r1 != 0) goto L_0x0128
            r1 = r39
            boolean r17 = r3.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x0123
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0125
        L_0x0123:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0125:
            r4 = r4 | r17
            goto L_0x012a
        L_0x0128:
            r1 = r39
        L_0x012a:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r18 = r0
            r0 = r4 & r17
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x014b
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x013d
            goto L_0x014b
        L_0x013d:
            r3.skipToGroupEnd()
            r4 = r6
            r5 = r8
            r6 = r9
            r7 = r10
            r11 = r12
            r9 = r36
            r12 = r39
            goto L_0x025e
        L_0x014b:
            r3.startDefaults()
            r0 = r13 & 1
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = -458753(0xfffffffffff8ffff, float:NaN)
            r21 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = 1
            if (r0 == 0) goto L_0x018d
            boolean r0 = r3.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0166
            goto L_0x018d
        L_0x0166:
            r3.skipToGroupEnd()
            r0 = r14 & 32
            if (r0 == 0) goto L_0x016f
            r4 = r4 & r20
        L_0x016f:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x0175
            r4 = r4 & r19
        L_0x0175:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x017b
            r4 = r4 & r17
        L_0x017b:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0181
            r4 = r4 & r21
        L_0x0181:
            r20 = r36
            r23 = r39
            r17 = r9
            r18 = r10
            r22 = r12
            goto L_0x01fa
        L_0x018d:
            if (r5 == 0) goto L_0x0194
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0194:
            if (r7 == 0) goto L_0x0197
            r8 = r1
        L_0x0197:
            r0 = r14 & 32
            r5 = 6
            if (r0 == 0) goto L_0x01a5
            androidx.compose.material3.FloatingActionButtonDefaults r0 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getExtendedFabShape(r3, r5)
            r4 = r4 & r20
            r9 = r0
        L_0x01a5:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01b1
            androidx.compose.material3.FloatingActionButtonDefaults r0 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r10 = r0.getContainerColor(r3, r5)
            r4 = r4 & r19
        L_0x01b1:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01c0
            int r0 = r4 >> 18
            r0 = r0 & 14
            long r19 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r10, r3, r0)
            r4 = r4 & r17
            goto L_0x01c2
        L_0x01c0:
            r19 = r36
        L_0x01c2:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01ea
            androidx.compose.material3.FloatingActionButtonDefaults r0 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r5 = 24576(0x6000, float:3.4438E-41)
            r7 = 15
            r12 = 0
            r17 = 0
            r22 = 0
            r23 = 0
            r31 = r0
            r36 = r3
            r37 = r5
            r38 = r7
            r32 = r12
            r33 = r17
            r34 = r22
            r35 = r23
            androidx.compose.material3.FloatingActionButtonElevation r0 = r31.m2091elevationxZ9QkE(r32, r33, r34, r35, r36, r37, r38)
            r4 = r4 & r21
            r12 = r0
        L_0x01ea:
            if (r18 == 0) goto L_0x01f0
            r0 = 0
            r23 = r0
            goto L_0x01f2
        L_0x01f0:
            r23 = r39
        L_0x01f2:
            r17 = r9
            r22 = r12
            r20 = r19
            r18 = r10
        L_0x01fa:
            r3.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x020c
            r0 = -1
            java.lang.String r5 = "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:364)"
            r12 = -1387401842(0xffffffffad4ded8e, float:-1.1705649E-11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r4, r0, r5)
        L_0x020c:
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3 r0 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
            r5 = r28
            r0.<init>(r8, r2, r5)
            r7 = 54
            r9 = 1172118032(0x45dd1a10, float:7075.258)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r1, r0, r3, r7)
            r24 = r0
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r0 = r4 >> 6
            r1 = r0 & 14
            r1 = r1 | r40
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r4 >> 9
            r4 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r4
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r1
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r1
            r0 = r0 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r4
            r26 = r0 | r1
            r27 = 0
            r25 = r3
            r16 = r6
            m2099FloatingActionButtonXz6DiA(r15, r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0251
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0251:
            r5 = r8
            r4 = r16
            r6 = r17
            r7 = r18
            r9 = r20
            r11 = r22
            r12 = r23
        L_0x025e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r3.endRestartGroup()
            if (r15 == 0) goto L_0x0272
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$4 r0 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$4
            r1 = r28
            r3 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0272:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2097ExtendedFloatingActionButtonElI57k(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }
}
