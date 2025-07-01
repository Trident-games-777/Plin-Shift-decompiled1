package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÊ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a \u0010(\u001a\u00020\u00052\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0002\b*H\u0003¢\u0006\u0002\u0010+\u001a\u001a\u0010,\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"DefaultObfuscationCharacter", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "then", "next", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = '•';
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARNING: Code restructure failed: missing block: B:192:0x02a7, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x02ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0131  */
    /* renamed from: BasicSecureTextField-Jb9bMDk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1156BasicSecureTextFieldJb9bMDk(androidx.compose.foundation.text.input.TextFieldState r32, androidx.compose.ui.Modifier r33, boolean r34, androidx.compose.foundation.text.input.InputTransformation r35, androidx.compose.ui.text.TextStyle r36, androidx.compose.foundation.text.KeyboardOptions r37, androidx.compose.foundation.text.input.KeyboardActionHandler r38, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, androidx.compose.ui.graphics.Brush r41, androidx.compose.foundation.text.input.TextFieldDecorator r42, int r43, char r44, androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            r0 = r42
            r14 = r46
            r15 = r47
            r1 = r48
            r2 = 1399310985(0x5367ca89, float:9.9553542E11)
            r3 = r45
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(BasicSecureTextField)P(9,6,2,3,12,5,7,8,4!2,11:c#foundation.text.input.TextObfuscationMode)131@7694L46,132@7777L60,133@7884L130,133@7842L172,144@8392L129,144@8353L168,150@8557L384,176@9335L825,176@9320L840:BasicSecureTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r1 & 1
            if (r4 == 0) goto L_0x0020
            r4 = r14 | 6
            r7 = r4
            r4 = r32
            goto L_0x0034
        L_0x0020:
            r4 = r14 & 6
            if (r4 != 0) goto L_0x0031
            r4 = r32
            boolean r7 = r3.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x002e
            r7 = 4
            goto L_0x002f
        L_0x002e:
            r7 = 2
        L_0x002f:
            r7 = r7 | r14
            goto L_0x0034
        L_0x0031:
            r4 = r32
            r7 = r14
        L_0x0034:
            r8 = r1 & 2
            if (r8 == 0) goto L_0x003b
            r7 = r7 | 48
            goto L_0x004e
        L_0x003b:
            r11 = r14 & 48
            if (r11 != 0) goto L_0x004e
            r11 = r33
            boolean r12 = r3.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x004a
            r12 = 32
            goto L_0x004c
        L_0x004a:
            r12 = 16
        L_0x004c:
            r7 = r7 | r12
            goto L_0x0050
        L_0x004e:
            r11 = r33
        L_0x0050:
            r12 = r1 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0059
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x0059:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x006d
            r5 = r34
            boolean r17 = r3.changed((boolean) r5)
            if (r17 == 0) goto L_0x0068
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r17 = r16
        L_0x006a:
            r7 = r7 | r17
            goto L_0x006f
        L_0x006d:
            r5 = r34
        L_0x006f:
            r17 = r1 & 8
            if (r17 == 0) goto L_0x0076
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0076:
            r6 = r14 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x008a
            r6 = r35
            boolean r19 = r3.changed((java.lang.Object) r6)
            if (r19 == 0) goto L_0x0085
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r19 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r7 = r7 | r19
            goto L_0x008c
        L_0x008a:
            r6 = r35
        L_0x008c:
            r19 = r1 & 16
            if (r19 == 0) goto L_0x0093
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0093:
            r9 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x00a7
            r9 = r36
            boolean r21 = r3.changed((java.lang.Object) r9)
            if (r21 == 0) goto L_0x00a2
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r7 = r7 | r21
            goto L_0x00a9
        L_0x00a7:
            r9 = r36
        L_0x00a9:
            r21 = r1 & 32
            r22 = 196608(0x30000, float:2.75506E-40)
            if (r21 == 0) goto L_0x00b4
            r7 = r7 | r22
            r13 = r37
            goto L_0x00c7
        L_0x00b4:
            r22 = r14 & r22
            r13 = r37
            if (r22 != 0) goto L_0x00c7
            boolean r23 = r3.changed((java.lang.Object) r13)
            if (r23 == 0) goto L_0x00c3
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r7 = r7 | r23
        L_0x00c7:
            r23 = r1 & 64
            r24 = 1572864(0x180000, float:2.204052E-39)
            if (r23 == 0) goto L_0x00d2
            r7 = r7 | r24
            r10 = r38
            goto L_0x00e5
        L_0x00d2:
            r24 = r14 & r24
            r10 = r38
            if (r24 != 0) goto L_0x00e5
            boolean r25 = r3.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00e1
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r7 = r7 | r25
        L_0x00e5:
            r2 = r1 & 128(0x80, float:1.794E-43)
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            if (r2 == 0) goto L_0x00ee
            r7 = r7 | r26
            goto L_0x0104
        L_0x00ee:
            r26 = r14 & r26
            if (r26 != 0) goto L_0x0104
            r26 = r2
            r2 = r39
            boolean r27 = r3.changedInstance(r2)
            if (r27 == 0) goto L_0x00ff
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r7 = r7 | r27
            goto L_0x0108
        L_0x0104:
            r26 = r2
            r2 = r39
        L_0x0108:
            r2 = r1 & 256(0x100, float:3.59E-43)
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x0111
            r7 = r7 | r27
            goto L_0x0127
        L_0x0111:
            r27 = r14 & r27
            if (r27 != 0) goto L_0x0127
            r27 = r2
            r2 = r40
            boolean r28 = r3.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x0122
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r7 = r7 | r28
            goto L_0x012b
        L_0x0127:
            r27 = r2
            r2 = r40
        L_0x012b:
            r2 = r1 & 512(0x200, float:7.175E-43)
            r28 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0134
            r7 = r7 | r28
            goto L_0x014a
        L_0x0134:
            r28 = r14 & r28
            if (r28 != 0) goto L_0x014a
            r28 = r2
            r2 = r41
            boolean r29 = r3.changed((java.lang.Object) r2)
            if (r29 == 0) goto L_0x0145
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0147
        L_0x0145:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0147:
            r7 = r7 | r29
            goto L_0x014e
        L_0x014a:
            r28 = r2
            r2 = r41
        L_0x014e:
            r2 = r1 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0155
            r18 = r15 | 6
            goto L_0x0172
        L_0x0155:
            r29 = r15 & 6
            if (r29 != 0) goto L_0x0170
            r29 = r15 & 8
            if (r29 != 0) goto L_0x0162
            boolean r29 = r3.changed((java.lang.Object) r0)
            goto L_0x0166
        L_0x0162:
            boolean r29 = r3.changedInstance(r0)
        L_0x0166:
            if (r29 == 0) goto L_0x016b
            r18 = 4
            goto L_0x016d
        L_0x016b:
            r18 = 2
        L_0x016d:
            r18 = r15 | r18
            goto L_0x0172
        L_0x0170:
            r18 = r15
        L_0x0172:
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x017b
            r18 = r18 | 48
            r29 = r0
            goto L_0x0195
        L_0x017b:
            r29 = r15 & 48
            if (r29 != 0) goto L_0x0191
            r29 = r0
            r0 = r43
            boolean r30 = r3.changed((int) r0)
            if (r30 == 0) goto L_0x018c
            r20 = 32
            goto L_0x018e
        L_0x018c:
            r20 = 16
        L_0x018e:
            r18 = r18 | r20
            goto L_0x0195
        L_0x0191:
            r29 = r0
            r0 = r43
        L_0x0195:
            r0 = r18
            r18 = r2
            r2 = r1 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x01a0
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01b9
        L_0x01a0:
            r20 = r0
            r0 = r15 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b5
            r0 = r44
            boolean r30 = r3.changed((char) r0)
            if (r30 == 0) goto L_0x01b0
            r16 = 256(0x100, float:3.59E-43)
        L_0x01b0:
            r16 = r20 | r16
            r0 = r16
            goto L_0x01b9
        L_0x01b5:
            r0 = r44
            r0 = r20
        L_0x01b9:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r7 & r16
            r16 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01ea
            r1 = r0 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x01ea
            boolean r1 = r3.getSkipping()
            if (r1 != 0) goto L_0x01d2
            goto L_0x01ea
        L_0x01d2:
            r3.skipToGroupEnd()
            r8 = r39
            r12 = r43
            r0 = r3
            r3 = r5
            r4 = r6
            r5 = r9
            r7 = r10
            r2 = r11
            r6 = r13
            r9 = r40
            r10 = r41
            r11 = r42
            r13 = r44
            goto L_0x03b0
        L_0x01ea:
            if (r8 == 0) goto L_0x01f1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01f2
        L_0x01f1:
            r1 = r11
        L_0x01f2:
            if (r12 == 0) goto L_0x01f5
            r5 = 1
        L_0x01f5:
            r8 = 0
            if (r17 == 0) goto L_0x01f9
            r6 = r8
        L_0x01f9:
            if (r19 == 0) goto L_0x0201
            androidx.compose.ui.text.TextStyle$Companion r9 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r9 = r9.getDefault()
        L_0x0201:
            if (r21 == 0) goto L_0x020a
            androidx.compose.foundation.text.KeyboardOptions$Companion r11 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r11 = r11.getSecureTextField$foundation_release()
            goto L_0x020b
        L_0x020a:
            r11 = r13
        L_0x020b:
            if (r23 == 0) goto L_0x020e
            r10 = r8
        L_0x020e:
            if (r26 == 0) goto L_0x0213
            r26 = r8
            goto L_0x0215
        L_0x0213:
            r26 = r39
        L_0x0215:
            if (r27 == 0) goto L_0x021a
            r27 = r8
            goto L_0x021c
        L_0x021a:
            r27 = r40
        L_0x021c:
            if (r28 == 0) goto L_0x0231
            androidx.compose.ui.graphics.SolidColor r12 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion
            r45 = r3
            long r2 = r13.m4265getBlack0d7_KjU()
            r12.<init>(r2, r8)
            r2 = r12
            androidx.compose.ui.graphics.Brush r2 = (androidx.compose.ui.graphics.Brush) r2
            r28 = r2
            goto L_0x0235
        L_0x0231:
            r45 = r3
            r28 = r41
        L_0x0235:
            if (r18 == 0) goto L_0x023a
            r30 = r8
            goto L_0x023c
        L_0x023a:
            r30 = r42
        L_0x023c:
            if (r29 == 0) goto L_0x0245
            androidx.compose.foundation.text.input.TextObfuscationMode$Companion r2 = androidx.compose.foundation.text.input.TextObfuscationMode.Companion
            int r2 = r2.m1334getRevealLastTypedvTwcZD0()
            goto L_0x0247
        L_0x0245:
            r2 = r43
        L_0x0247:
            if (r16 == 0) goto L_0x024c
            r3 = 8226(0x2022, float:1.1527E-41)
            goto L_0x024e
        L_0x024c:
            r3 = r44
        L_0x024e:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x025c
            java.lang.String r12 = "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:130)"
            r13 = 1399310985(0x5367ca89, float:9.9553542E11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r7, r0, r12)
        L_0x025c:
            java.lang.Character r7 = java.lang.Character.valueOf(r3)
            int r12 = r0 >> 6
            r12 = r12 & 14
            r13 = r45
            androidx.compose.runtime.State r7 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r7, r13, r12)
            r12 = 120982059(0x7360a2b, float:1.3695146E-34)
            java.lang.String r8 = "CC(remember):BasicSecureTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r12, r8)
            java.lang.Object r12 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r0
            java.lang.Object r0 = r16.getEmpty()
            if (r12 != r0) goto L_0x0288
            androidx.compose.foundation.text.SecureTextFieldController r12 = new androidx.compose.foundation.text.SecureTextFieldController
            r12.<init>(r7)
            r13.updateRememberedValue(r12)
        L_0x0288:
            androidx.compose.foundation.text.SecureTextFieldController r12 = (androidx.compose.foundation.text.SecureTextFieldController) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r0 = 120985553(0x73617d1, float:1.3699157E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r8)
            boolean r0 = r13.changedInstance(r12)
            r35 = r0
            java.lang.Object r0 = r13.rememberedValue()
            if (r35 != 0) goto L_0x02aa
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r35 = r3
            java.lang.Object r3 = r16.getEmpty()
            if (r0 != r3) goto L_0x02b7
            goto L_0x02ac
        L_0x02aa:
            r35 = r3
        L_0x02ac:
            androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$1$1 r0 = new androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$1$1
            r3 = 0
            r0.<init>(r12, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateRememberedValue(r0)
        L_0x02b7:
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r13, (int) r3)
            androidx.compose.foundation.text.input.TextObfuscationMode$Companion r0 = androidx.compose.foundation.text.input.TextObfuscationMode.Companion
            int r0 = r0.m1334getRevealLastTypedvTwcZD0()
            boolean r0 = androidx.compose.foundation.text.input.TextObfuscationMode.m1329equalsimpl0(r2, r0)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            r4 = 121001808(0x7365750, float:1.3717817E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r8)
            boolean r4 = r13.changed((boolean) r0)
            boolean r16 = r13.changedInstance(r12)
            r4 = r4 | r16
            r37 = r4
            java.lang.Object r4 = r13.rememberedValue()
            if (r37 != 0) goto L_0x02f3
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r19 = r5
            java.lang.Object r5 = r16.getEmpty()
            if (r4 != r5) goto L_0x02f1
            goto L_0x02f5
        L_0x02f1:
            r5 = 0
            goto L_0x0300
        L_0x02f3:
            r19 = r5
        L_0x02f5:
            androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$2$1 r4 = new androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$2$1
            r5 = 0
            r4.<init>(r0, r12, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r13.updateRememberedValue(r4)
        L_0x0300:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r5 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r4, (androidx.compose.runtime.Composer) r13, (int) r5)
            r3 = 121007343(0x7366cef, float:1.3724171E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r8)
            r3 = r17 & 112(0x70, float:1.57E-43)
            r4 = 32
            if (r3 != r4) goto L_0x0316
            r5 = 1
        L_0x0316:
            java.lang.Object r3 = r13.rememberedValue()
            if (r5 != 0) goto L_0x0324
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x034c
        L_0x0324:
            androidx.compose.foundation.text.input.TextObfuscationMode$Companion r3 = androidx.compose.foundation.text.input.TextObfuscationMode.Companion
            int r3 = r3.m1334getRevealLastTypedvTwcZD0()
            boolean r3 = androidx.compose.foundation.text.input.TextObfuscationMode.m1329equalsimpl0(r2, r3)
            if (r3 == 0) goto L_0x0335
            androidx.compose.foundation.text.input.internal.CodepointTransformation r8 = r12.getCodepointTransformation()
            goto L_0x0348
        L_0x0335:
            androidx.compose.foundation.text.input.TextObfuscationMode$Companion r3 = androidx.compose.foundation.text.input.TextObfuscationMode.Companion
            int r3 = r3.m1333getHiddenvTwcZD0()
            boolean r3 = androidx.compose.foundation.text.input.TextObfuscationMode.m1329equalsimpl0(r2, r3)
            if (r3 == 0) goto L_0x0347
            androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda0 r8 = new androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda0
            r8.<init>(r7)
            goto L_0x0348
        L_0x0347:
            r8 = 0
        L_0x0348:
            r13.updateRememberedValue(r8)
            r3 = r8
        L_0x034c:
            r29 = r3
            androidx.compose.foundation.text.input.internal.CodepointTransformation r29 = (androidx.compose.foundation.text.input.internal.CodepointTransformation) r29
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1 r3 = androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r1, r4, r3)
            if (r0 == 0) goto L_0x0363
            androidx.compose.ui.Modifier r4 = r12.getFocusChangeModifier()
            goto L_0x0367
        L_0x0363:
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
        L_0x0367:
            androidx.compose.ui.Modifier r18 = r3.then(r4)
            androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3 r16 = new androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3
            r17 = r32
            r20 = r0
            r21 = r6
            r23 = r9
            r25 = r10
            r24 = r11
            r22 = r12
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r0 = r16
            r3 = 54
            r4 = 2023988909(0x78a39ead, float:2.6548835E34)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r5, r0, r13, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3 = 6
            DisableCutCopy(r0, r13, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0399
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0399:
            r12 = r2
            r0 = r13
            r3 = r19
            r4 = r21
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r30
            r13 = r35
            r2 = r1
        L_0x03b0:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x03c9
            r1 = r0
            androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$4 r0 = new androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$4
            r16 = r48
            r31 = r1
            r1 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r31
            r1.updateScope(r0)
        L_0x03c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicSecureTextFieldKt.m1156BasicSecureTextFieldJb9bMDk(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.TextFieldDecorator, int, char, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final int BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* access modifiers changed from: private */
    public static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        if (inputTransformation == null) {
            return inputTransformation2;
        }
        return inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }

    /* access modifiers changed from: private */
    public static final void DisableCutCopy(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1085555050);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)311@13911L7,312@13949L680,331@14706L361,331@14634L433:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085555050, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:310)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextToolbar textToolbar = (TextToolbar) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1202776994, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) textToolbar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1(textToolbar);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) rememberedValue), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1448819882, true, new BasicSecureTextFieldKt$DisableCutCopy$1(function2), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicSecureTextFieldKt$DisableCutCopy$2(function2, i));
        }
    }
}
