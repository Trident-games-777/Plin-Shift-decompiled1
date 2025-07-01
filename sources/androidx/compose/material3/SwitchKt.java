package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001al\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001aR\u0010 \u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001d\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0003¢\u0006\u0002\u0010$\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u0010\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u000b¨\u0006%"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SnapSpec", "Landroidx/compose/animation/core/SnapSpec;", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SwitchColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SnapSpec<Float> SnapSpec = new SnapSpec<>(0, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float SwitchHeight;
    /* access modifiers changed from: private */
    public static final float SwitchWidth = SwitchTokens.INSTANCE.m3548getTrackWidthD9Ej5fM();
    private static final float ThumbDiameter;
    /* access modifiers changed from: private */
    public static final float ThumbPadding;
    private static final float UncheckedThumbDiameter = SwitchTokens.INSTANCE.m3550getUnselectedHandleWidthD9Ej5fM();

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r19, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, boolean r23, androidx.compose.material3.SwitchColors r24, androidx.compose.foundation.interaction.MutableInteractionSource r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r6 = r20
            r8 = r27
            r0 = 1580463220(0x5e33f474, float:3.24177919E18)
            r1 = r26
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Switch)P(!1,5,4,6,2)97@4514L8,129@5619L5,119@5244L424:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r28 & 1
            if (r1 == 0) goto L_0x001c
            r1 = r8 | 6
            r2 = r1
            r1 = r19
            goto L_0x0030
        L_0x001c:
            r1 = r8 & 6
            if (r1 != 0) goto L_0x002d
            r1 = r19
            boolean r2 = r7.changed((boolean) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r8
            goto L_0x0030
        L_0x002d:
            r1 = r19
            r2 = r8
        L_0x0030:
            r3 = r28 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x0047
        L_0x0037:
            r3 = r8 & 48
            if (r3 != 0) goto L_0x0047
            boolean r3 = r7.changedInstance(r6)
            if (r3 == 0) goto L_0x0044
            r3 = 32
            goto L_0x0046
        L_0x0044:
            r3 = 16
        L_0x0046:
            r2 = r2 | r3
        L_0x0047:
            r3 = r28 & 4
            if (r3 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0061
            r4 = r21
            boolean r5 = r7.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005d
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r5
            goto L_0x0063
        L_0x0061:
            r4 = r21
        L_0x0063:
            r5 = r28 & 8
            if (r5 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007d
            r10 = r22
            boolean r11 = r7.changedInstance(r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r22
        L_0x007f:
            r11 = r28 & 16
            if (r11 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r12 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0099
            r12 = r23
            boolean r13 = r7.changed((boolean) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r23
        L_0x009b:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b5
            r13 = r28 & 32
            if (r13 != 0) goto L_0x00af
            r13 = r24
            boolean r14 = r7.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r13 = r24
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r24
        L_0x00b7:
            r14 = r28 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bf
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00bf:
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00d2
            r15 = r25
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r2 = r2 | r16
            goto L_0x00d4
        L_0x00d2:
            r15 = r25
        L_0x00d4:
            r16 = 599187(0x92493, float:8.3964E-40)
            r9 = r2 & r16
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r9 != r0) goto L_0x00f1
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            r7.skipToGroupEnd()
            r3 = r4
            r16 = r7
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r15
            goto L_0x01f5
        L_0x00f1:
            r7.startDefaults()
            r0 = r8 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r9 = 6
            if (r0 == 0) goto L_0x0114
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0103
            goto L_0x0114
        L_0x0103:
            r7.skipToGroupEnd()
            r0 = r28 & 32
            if (r0 == 0) goto L_0x010c
            r2 = r2 & r17
        L_0x010c:
            r14 = r2
            r11 = r12
            r12 = r13
            r18 = r15
            r13 = r10
            r10 = r4
            goto L_0x013f
        L_0x0114:
            if (r3 == 0) goto L_0x011b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x011c
        L_0x011b:
            r0 = r4
        L_0x011c:
            if (r5 == 0) goto L_0x011f
            r10 = 0
        L_0x011f:
            if (r11 == 0) goto L_0x0123
            r3 = 1
            r12 = r3
        L_0x0123:
            r3 = r28 & 32
            if (r3 == 0) goto L_0x0130
            androidx.compose.material3.SwitchDefaults r3 = androidx.compose.material3.SwitchDefaults.INSTANCE
            androidx.compose.material3.SwitchColors r3 = r3.colors(r7, r9)
            r2 = r2 & r17
            r13 = r3
        L_0x0130:
            if (r14 == 0) goto L_0x0138
            r14 = r2
            r11 = r12
            r12 = r13
            r18 = 0
            goto L_0x013d
        L_0x0138:
            r14 = r2
            r11 = r12
            r12 = r13
            r18 = r15
        L_0x013d:
            r13 = r10
            r10 = r0
        L_0x013f:
            r7.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0151
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.Switch (Switch.kt:99)"
            r3 = 1580463220(0x5e33f474, float:3.24177919E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r0, r2)
        L_0x0151:
            r0 = 783532531(0x2eb3c1f3, float:8.17443E-11)
            r7.startReplaceGroup(r0)
            java.lang.String r0 = "101@4666L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            if (r18 != 0) goto L_0x0180
            r0 = 783533182(0x2eb3c47e, float:8.1748816E-11)
            java.lang.String r2 = "CC(remember):Switch.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r2)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0179
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x0179:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r2 = r0
            goto L_0x0182
        L_0x0180:
            r2 = r18
        L_0x0182:
            r7.endReplaceGroup()
            if (r6 == 0) goto L_0x01a1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r0)
            androidx.compose.ui.semantics.Role$Companion r3 = androidx.compose.ui.semantics.Role.Companion
            int r3 = r3.m6372getSwitcho7Vup1c()
            r4 = r3
            r3 = 0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m6360boximpl(r4)
            r4 = r11
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m1113toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01a5
        L_0x01a1:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x01a5:
            androidx.compose.ui.Modifier r0 = r10.then(r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r3 = 0
            r4 = 0
            r5 = 2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r1, r3, r5, r4)
            float r1 = SwitchWidth
            float r3 = SwitchHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m839requiredSizeVpY3zN4(r0, r1, r3)
            androidx.compose.material3.tokens.SwitchTokens r1 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r1 = r1.getHandleShape()
            androidx.compose.ui.graphics.Shape r15 = androidx.compose.material3.ShapesKt.getValue(r1, r7, r9)
            androidx.compose.foundation.interaction.InteractionSource r2 = (androidx.compose.foundation.interaction.InteractionSource) r2
            int r1 = r14 << 3
            r3 = r1 & 112(0x70, float:1.57E-43)
            int r4 = r14 >> 6
            r5 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r5
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r17 = r3 | r1
            r9 = r0
            r14 = r2
            r16 = r7
            r0 = r10
            r10 = r19
            SwitchImpl(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ef
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ef:
            r3 = r0
            r5 = r11
            r6 = r12
            r4 = r13
            r7 = r18
        L_0x01f5:
            androidx.compose.runtime.ScopeUpdateScope r10 = r16.endRestartGroup()
            if (r10 == 0) goto L_0x020b
            androidx.compose.material3.SwitchKt$Switch$1 r0 = new androidx.compose.material3.SwitchKt$Switch$1
            r1 = r19
            r2 = r20
            r9 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void SwitchImpl(Modifier modifier, boolean z, boolean z2, SwitchColors switchColors, Function2<? super Composer, ? super Integer, Unit> function2, InteractionSource interactionSource, Shape shape, Composer composer, int i) {
        int i2;
        Modifier modifier2 = modifier;
        boolean z3 = z;
        boolean z4 = z2;
        SwitchColors switchColors2 = switchColors;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        InteractionSource interactionSource2 = interactionSource;
        Shape shape2 = shape;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1594099146);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchImpl)P(4!1,2!1,5)147@6165L5,149@6176L1114:Switch.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) switchColors2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) interactionSource2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) shape2) ? 1048576 : 524288;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594099146, i2, -1, "androidx.compose.material3.SwitchImpl (Switch.kt:144)");
            }
            long r11 = switchColors2.m2567trackColorWaAFU9c$material3_release(z4, z3);
            long r14 = switchColors2.m2566thumbColorWaAFU9c$material3_release(z4, z3);
            Shape value = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), startRestartGroup, 6);
            int i4 = i2;
            Modifier r0 = BackgroundKt.m247backgroundbw27NRU(BorderKt.m259borderxT4_qwU(modifier2, SwitchTokens.INSTANCE.m3547getTrackOutlineWidthD9Ej5fM(), switchColors2.m2547borderColorWaAFU9c$material3_release(z4, z3), value), r11, value);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            String str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
            long j = r14;
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
            Composer r12 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r12, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r12, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r12.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r12, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -249502072, "C161@6662L183,154@6351L933:Switch.kt#uh7d8r");
            String str2 = "C73@3429L9:Box.kt#2w3rfo";
            Modifier r02 = BackgroundKt.m247backgroundbw27NRU(IndicationKt.indication(BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenterStart()).then(new ThumbElement(interactionSource2, z3)), interactionSource2, RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(false, Dp.m7111constructorimpl(SwitchTokens.INSTANCE.m3545getStateLayerSizeD9Ej5fM() / ((float) 2)), 0, startRestartGroup, 54, 4)), j, shape2);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, str);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r02);
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
            Composer r3 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, str2);
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1707453249, "C:Switch.kt#uh7d8r");
            startRestartGroup.startReplaceGroup(1163457794);
            ComposerKt.sourceInformation(startRestartGroup, "171@7116L144");
            z3 = z;
            z4 = z2;
            switchColors2 = switchColors;
            if (function2 != null) {
                function22 = function2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(switchColors2.m2565iconColorWaAFU9c$material3_release(z4, z3))), function22, startRestartGroup, ProvidedValue.$stable | ((i4 >> 9) & 112));
            } else {
                function22 = function2;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new SwitchKt$SwitchImpl$2(modifier, z3, z4, switchColors2, function22, interactionSource2, shape2, i));
        }
    }

    static {
        float r0 = SwitchTokens.INSTANCE.m3543getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = r0;
        float r1 = SwitchTokens.INSTANCE.m3546getTrackHeightD9Ej5fM();
        SwitchHeight = r1;
        ThumbPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(r1 - r0) / ((float) 2));
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
