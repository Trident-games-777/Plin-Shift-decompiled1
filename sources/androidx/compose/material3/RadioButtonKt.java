package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0015"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m7111constructorimpl((float) 12);
    private static final float RadioButtonPadding;
    /* access modifiers changed from: private */
    public static final float RadioStrokeWidth;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RadioButton(boolean r20, kotlin.jvm.functions.Function0<kotlin.Unit> r21, androidx.compose.ui.Modifier r22, boolean r23, androidx.compose.material3.RadioButtonColors r24, androidx.compose.foundation.interaction.MutableInteractionSource r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r20
            r2 = r21
            r7 = r27
            r0 = 408580840(0x185a72e8, float:2.8233852E-24)
            r3 = r26
            androidx.compose.runtime.Composer r12 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(RadioButton)P(5,4,3,1)80@3770L8,84@3868L176,88@4073L29,119@5097L415,106@4679L833:RadioButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = r28 & 1
            r15 = 2
            if (r3 == 0) goto L_0x001c
            r3 = r7 | 6
            goto L_0x002c
        L_0x001c:
            r3 = r7 & 6
            if (r3 != 0) goto L_0x002b
            boolean r3 = r12.changed((boolean) r1)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = r15
        L_0x0029:
            r3 = r3 | r7
            goto L_0x002c
        L_0x002b:
            r3 = r7
        L_0x002c:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0033
            r3 = r3 | 48
            goto L_0x0043
        L_0x0033:
            r4 = r7 & 48
            if (r4 != 0) goto L_0x0043
            boolean r4 = r12.changedInstance(r2)
            if (r4 == 0) goto L_0x0040
            r4 = 32
            goto L_0x0042
        L_0x0040:
            r4 = 16
        L_0x0042:
            r3 = r3 | r4
        L_0x0043:
            r4 = r28 & 4
            if (r4 == 0) goto L_0x004a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r5 = r7 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x005d
            r5 = r22
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0059
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r6
            goto L_0x005f
        L_0x005d:
            r5 = r22
        L_0x005f:
            r6 = r28 & 8
            if (r6 == 0) goto L_0x0066
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r8 = r7 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r23
            boolean r9 = r12.changed((boolean) r8)
            if (r9 == 0) goto L_0x0075
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r9
            goto L_0x007b
        L_0x0079:
            r8 = r23
        L_0x007b:
            r9 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0094
            r9 = r28 & 16
            if (r9 != 0) goto L_0x008e
            r9 = r24
            boolean r10 = r12.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0090
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r9 = r24
        L_0x0090:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r3 = r3 | r10
            goto L_0x0096
        L_0x0094:
            r9 = r24
        L_0x0096:
            r10 = r28 & 32
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x009e
            r3 = r3 | r11
            goto L_0x00b0
        L_0x009e:
            r11 = r11 & r7
            if (r11 != 0) goto L_0x00b0
            r11 = r25
            boolean r13 = r12.changed((java.lang.Object) r11)
            if (r13 == 0) goto L_0x00ac
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r3 = r3 | r13
            goto L_0x00b2
        L_0x00b0:
            r11 = r25
        L_0x00b2:
            r13 = 74899(0x12493, float:1.04956E-40)
            r13 = r13 & r3
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00cb
            boolean r13 = r12.getSkipping()
            if (r13 != 0) goto L_0x00c2
            goto L_0x00cb
        L_0x00c2:
            r12.skipToGroupEnd()
            r3 = r5
            r4 = r8
            r6 = r11
        L_0x00c8:
            r5 = r9
            goto L_0x0222
        L_0x00cb:
            r12.startDefaults()
            r13 = r7 & 1
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r26 = r10
            r10 = 0
            r11 = 6
            if (r13 == 0) goto L_0x00ef
            boolean r13 = r12.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00e0
            goto L_0x00ef
        L_0x00e0:
            r12.skipToGroupEnd()
            r4 = r28 & 16
            if (r4 == 0) goto L_0x00e8
            r3 = r3 & r14
        L_0x00e8:
            r2 = r25
            r6 = r3
            r4 = r5
        L_0x00ec:
            r3 = r8
            r5 = r9
            goto L_0x0112
        L_0x00ef:
            if (r4 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00f7
        L_0x00f6:
            r4 = r5
        L_0x00f7:
            if (r6 == 0) goto L_0x00fb
            r5 = 1
            r8 = r5
        L_0x00fb:
            r5 = r28 & 16
            if (r5 == 0) goto L_0x0107
            androidx.compose.material3.RadioButtonDefaults r5 = androidx.compose.material3.RadioButtonDefaults.INSTANCE
            androidx.compose.material3.RadioButtonColors r5 = r5.colors(r12, r11)
            r3 = r3 & r14
            r9 = r5
        L_0x0107:
            if (r26 == 0) goto L_0x010e
            r6 = r3
            r3 = r8
            r5 = r9
            r2 = r10
            goto L_0x0112
        L_0x010e:
            r2 = r25
            r6 = r3
            goto L_0x00ec
        L_0x0112:
            r12.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0121
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.RadioButton (RadioButton.kt:82)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r8, r9)
        L_0x0121:
            r0 = 0
            if (r1 == 0) goto L_0x012d
            float r8 = RadioButtonDotSize
            float r9 = (float) r15
            float r8 = r8 / r9
            float r8 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
            goto L_0x0132
        L_0x012d:
            float r8 = (float) r0
            float r8 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
        L_0x0132:
            r9 = 100
            androidx.compose.animation.core.TweenSpec r9 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r0, r10, r11, r10)
            androidx.compose.animation.core.AnimationSpec r9 = (androidx.compose.animation.core.AnimationSpec) r9
            r13 = 48
            r14 = 12
            r16 = r10
            r10 = 0
            r17 = r11
            r11 = 0
            androidx.compose.runtime.State r8 = androidx.compose.animation.core.AnimateAsStateKt.m140animateDpAsStateAjpBEmI(r8, r9, r10, r11, r12, r13, r14)
            int r9 = r6 >> 9
            r9 = r9 & 14
            int r10 = r6 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            int r6 = r6 >> 6
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r9
            androidx.compose.runtime.State r6 = r5.radioColor$material3_release(r3, r1, r12, r6)
            r9 = 1327106656(0x4f1a0a60, float:2.5843712E9)
            r12.startReplaceGroup(r9)
            java.lang.String r9 = "98@4448L164"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            if (r21 == 0) goto L_0x01a1
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r9 = androidx.compose.ui.semantics.Role.Companion
            int r17 = r9.m6371getRadioButtono7Vup1c()
            androidx.compose.material3.tokens.RadioButtonTokens r9 = androidx.compose.material3.tokens.RadioButtonTokens.INSTANCE
            float r9 = r9.m3492getStateLayerSizeD9Ej5fM()
            float r10 = (float) r15
            float r9 = r9 / r10
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r9)
            r13 = 54
            r14 = 4
            r10 = r8
            r8 = 0
            r18 = r10
            r10 = 0
            r19 = r18
            androidx.compose.foundation.Indication r8 = androidx.compose.material3.RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(r8, r9, r10, r12, r13, r14)
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            androidx.compose.ui.semantics.Role r9 = androidx.compose.ui.semantics.Role.m6360boximpl(r17)
            r10 = r9
            r9 = r5
            r5 = r10
            r11 = r0
            r10 = r4
            r0 = r16
            r4 = r3
            r3 = r8
            r8 = r6
            r6 = r21
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m1108selectableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01ac
        L_0x01a1:
            r11 = r0
            r10 = r4
            r9 = r5
            r19 = r8
            r4 = r3
            r8 = r6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x01ac:
            r12.endReplaceGroup()
            if (r21 == 0) goto L_0x01ba
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x01be
        L_0x01ba:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x01be:
            androidx.compose.ui.Modifier r1 = r10.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r3 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r1, r11, r15, r3)
            float r1 = RadioButtonPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m775padding3ABfNKs(r0, r1)
            androidx.compose.material3.tokens.RadioButtonTokens r1 = androidx.compose.material3.tokens.RadioButtonTokens.INSTANCE
            float r1 = r1.m3491getIconSizeD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m837requiredSize3ABfNKs(r0, r1)
            r1 = 1327137161(0x4f1a8189, float:2.59218048E9)
            java.lang.String r3 = "CC(remember):RadioButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r3)
            boolean r1 = r12.changed((java.lang.Object) r8)
            r3 = r19
            boolean r5 = r12.changed((java.lang.Object) r3)
            r1 = r1 | r5
            java.lang.Object r5 = r12.rememberedValue()
            if (r1 != 0) goto L_0x0202
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r5 != r1) goto L_0x020d
        L_0x0202:
            androidx.compose.material3.RadioButtonKt$RadioButton$1$1 r1 = new androidx.compose.material3.RadioButtonKt$RadioButton$1$1
            r1.<init>(r8, r3)
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r12.updateRememberedValue(r5)
        L_0x020d:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.foundation.CanvasKt.Canvas(r0, r5, r12, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x021e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021e:
            r6 = r2
            r3 = r10
            goto L_0x00c8
        L_0x0222:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 == 0) goto L_0x0238
            androidx.compose.material3.RadioButtonKt$RadioButton$2 r0 = new androidx.compose.material3.RadioButtonKt$RadioButton$2
            r1 = r20
            r2 = r21
            r8 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.RadioButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 2;
        RadioButtonPadding = Dp.m7111constructorimpl(f);
        RadioStrokeWidth = Dp.m7111constructorimpl(f);
    }
}
