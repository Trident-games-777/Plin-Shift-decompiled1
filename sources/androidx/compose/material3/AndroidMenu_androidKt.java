package androidx.compose.material3;

import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a¢\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ad\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0001\u0010%\u001a\u00020\u00052\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\u00142\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\u00142\b\b\u0002\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u00101\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"DefaultMenuProperties", "Landroidx/compose/ui/window/PopupProperties;", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX WARNING: Removed duplicated region for block: B:107:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011c  */
    /* renamed from: DropdownMenu-IlH_yew  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1713DropdownMenuIlH_yew(boolean r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.ui.Modifier r39, long r40, androidx.compose.foundation.ScrollState r42, androidx.compose.ui.window.PopupProperties r43, androidx.compose.ui.graphics.Shape r44, long r45, float r47, float r48, androidx.compose.foundation.BorderStroke r49, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.runtime.Composer r51, int r52, int r53, int r54) {
        /*
            r15 = r52
            r0 = r54
            r1 = 1431928300(0x55597dec, float:1.49459283E13)
            r2 = r51
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r1)
            java.lang.String r3 = "C(DropdownMenu)P(3,6,4,5:c#ui.unit.DpOffset,8,7,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)182@6555L21,185@6667L5,187@6715L14,55@2073L42,59@2260L51,60@2347L7,62@2403L251,72@2825L494,68@2664L655:AndroidMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r0 & 1
            if (r3 == 0) goto L_0x001c
            r3 = r15 | 6
            r6 = r3
            r3 = r37
            goto L_0x0030
        L_0x001c:
            r3 = r15 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r37
            boolean r6 = r2.changed((boolean) r3)
            if (r6 == 0) goto L_0x002a
            r6 = 4
            goto L_0x002b
        L_0x002a:
            r6 = 2
        L_0x002b:
            r6 = r6 | r15
            goto L_0x0030
        L_0x002d:
            r3 = r37
            r6 = r15
        L_0x0030:
            r7 = r0 & 2
            if (r7 == 0) goto L_0x0037
            r6 = r6 | 48
            goto L_0x004a
        L_0x0037:
            r7 = r15 & 48
            if (r7 != 0) goto L_0x004a
            r7 = r38
            boolean r10 = r2.changedInstance(r7)
            if (r10 == 0) goto L_0x0046
            r10 = 32
            goto L_0x0048
        L_0x0046:
            r10 = 16
        L_0x0048:
            r6 = r6 | r10
            goto L_0x004c
        L_0x004a:
            r7 = r38
        L_0x004c:
            r10 = r0 & 4
            if (r10 == 0) goto L_0x0053
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0066
            r11 = r39
            boolean r12 = r2.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0062
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r6 = r6 | r12
            goto L_0x0068
        L_0x0066:
            r11 = r39
        L_0x0068:
            r12 = r0 & 8
            if (r12 == 0) goto L_0x0071
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            r8 = r40
            goto L_0x0084
        L_0x0071:
            r14 = r15 & 3072(0xc00, float:4.305E-42)
            r8 = r40
            if (r14 != 0) goto L_0x0084
            boolean r16 = r2.changed((long) r8)
            if (r16 == 0) goto L_0x0080
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r6 = r6 | r16
        L_0x0084:
            r4 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x009e
            r4 = r0 & 16
            if (r4 != 0) goto L_0x0097
            r4 = r42
            boolean r17 = r2.changed((java.lang.Object) r4)
            if (r17 == 0) goto L_0x0099
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r4 = r42
        L_0x0099:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r6 = r6 | r17
            goto L_0x00a0
        L_0x009e:
            r4 = r42
        L_0x00a0:
            r17 = r0 & 32
            r18 = 196608(0x30000, float:2.75506E-40)
            if (r17 == 0) goto L_0x00ab
            r6 = r6 | r18
            r14 = r43
            goto L_0x00be
        L_0x00ab:
            r18 = r15 & r18
            r14 = r43
            if (r18 != 0) goto L_0x00be
            boolean r19 = r2.changed((java.lang.Object) r14)
            if (r19 == 0) goto L_0x00ba
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r6 = r6 | r19
        L_0x00be:
            r19 = 1572864(0x180000, float:2.204052E-39)
            r19 = r15 & r19
            if (r19 != 0) goto L_0x00d8
            r19 = r0 & 64
            r13 = r44
            if (r19 != 0) goto L_0x00d3
            boolean r20 = r2.changed((java.lang.Object) r13)
            if (r20 == 0) goto L_0x00d3
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r6 = r6 | r20
            goto L_0x00da
        L_0x00d8:
            r13 = r44
        L_0x00da:
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r20 = r15 & r20
            if (r20 != 0) goto L_0x00f3
            r5 = r0 & 128(0x80, float:1.794E-43)
            r3 = r45
            if (r5 != 0) goto L_0x00ef
            boolean r5 = r2.changed((long) r3)
            if (r5 == 0) goto L_0x00ef
            r5 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ef:
            r5 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r6 = r6 | r5
            goto L_0x00f5
        L_0x00f3:
            r3 = r45
        L_0x00f5:
            r5 = r0 & 256(0x100, float:3.59E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r5 == 0) goto L_0x0100
            r6 = r6 | r21
            r1 = r47
            goto L_0x0113
        L_0x0100:
            r21 = r15 & r21
            r1 = r47
            if (r21 != 0) goto L_0x0113
            boolean r22 = r2.changed((float) r1)
            if (r22 == 0) goto L_0x010f
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0111
        L_0x010f:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0111:
            r6 = r6 | r22
        L_0x0113:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x011c
            r6 = r6 | r22
            goto L_0x0132
        L_0x011c:
            r22 = r15 & r22
            if (r22 != 0) goto L_0x0132
            r22 = r1
            r1 = r48
            boolean r23 = r2.changed((float) r1)
            if (r23 == 0) goto L_0x012d
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012f
        L_0x012d:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012f:
            r6 = r6 | r23
            goto L_0x0136
        L_0x0132:
            r22 = r1
            r1 = r48
        L_0x0136:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0141
            r16 = r53 | 6
            r23 = r1
            r1 = r49
            goto L_0x015d
        L_0x0141:
            r23 = r53 & 6
            if (r23 != 0) goto L_0x0157
            r23 = r1
            r1 = r49
            boolean r24 = r2.changed((java.lang.Object) r1)
            if (r24 == 0) goto L_0x0152
            r16 = 4
            goto L_0x0154
        L_0x0152:
            r16 = 2
        L_0x0154:
            r16 = r53 | r16
            goto L_0x015d
        L_0x0157:
            r23 = r1
            r1 = r49
            r16 = r53
        L_0x015d:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0164
            r16 = r16 | 48
            goto L_0x017a
        L_0x0164:
            r1 = r53 & 48
            if (r1 != 0) goto L_0x0178
            r1 = r50
            boolean r24 = r2.changedInstance(r1)
            if (r24 == 0) goto L_0x0173
            r18 = 32
            goto L_0x0175
        L_0x0173:
            r18 = 16
        L_0x0175:
            r16 = r16 | r18
            goto L_0x017a
        L_0x0178:
            r1 = r50
        L_0x017a:
            r1 = r16
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r6 & r16
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x01a7
            r3 = r1 & 19
            r4 = 18
            if (r3 != r4) goto L_0x01a7
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x0193
            goto L_0x01a7
        L_0x0193:
            r2.skipToGroupEnd()
            r6 = r42
            r12 = r48
            r1 = r2
            r4 = r8
            r3 = r11
            r8 = r13
            r9 = r45
            r11 = r47
            r13 = r49
        L_0x01a4:
            r7 = r14
            goto L_0x039e
        L_0x01a7:
            r2.startDefaults()
            r3 = r15 & 1
            r51 = -57345(0xffffffffffff1fff, float:NaN)
            r4 = 1
            if (r3 == 0) goto L_0x01e2
            boolean r3 = r2.getDefaultsInvalid()
            if (r3 == 0) goto L_0x01b9
            goto L_0x01e2
        L_0x01b9:
            r2.skipToGroupEnd()
            r3 = r0 & 16
            if (r3 == 0) goto L_0x01c2
            r6 = r6 & r51
        L_0x01c2:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x01ca
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r3
        L_0x01ca:
            r3 = r0 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x01d2
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r6 = r6 & r3
        L_0x01d2:
            r28 = r42
            r30 = r45
            r32 = r47
            r33 = r48
            r34 = r49
            r25 = r11
            r29 = r13
            goto L_0x0264
        L_0x01e2:
            if (r10 == 0) goto L_0x01e9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01ea
        L_0x01e9:
            r3 = r11
        L_0x01ea:
            r10 = 0
            if (r12 == 0) goto L_0x01fa
            float r8 = (float) r10
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
            float r8 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
            long r8 = androidx.compose.ui.unit.DpKt.m7132DpOffsetYgX7TsA(r9, r8)
        L_0x01fa:
            r11 = r0 & 16
            if (r11 == 0) goto L_0x0205
            androidx.compose.foundation.ScrollState r11 = androidx.compose.foundation.ScrollKt.rememberScrollState(r10, r2, r10, r4)
            r6 = r6 & r51
            goto L_0x0207
        L_0x0205:
            r11 = r42
        L_0x0207:
            if (r17 == 0) goto L_0x020c
            androidx.compose.ui.window.PopupProperties r10 = DefaultMenuProperties
            r14 = r10
        L_0x020c:
            r10 = r0 & 64
            r12 = 6
            if (r10 == 0) goto L_0x021c
            androidx.compose.material3.MenuDefaults r10 = androidx.compose.material3.MenuDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r10 = r10.getShape(r2, r12)
            r13 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r13
            goto L_0x021d
        L_0x021c:
            r10 = r13
        L_0x021d:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x022d
            androidx.compose.material3.MenuDefaults r13 = androidx.compose.material3.MenuDefaults.INSTANCE
            long r12 = r13.getContainerColor(r2, r12)
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r6 = r6 & r17
            goto L_0x022f
        L_0x022d:
            r12 = r45
        L_0x022f:
            if (r5 == 0) goto L_0x0238
            androidx.compose.material3.MenuDefaults r5 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r5 = r5.m2203getTonalElevationD9Ej5fM()
            goto L_0x023a
        L_0x0238:
            r5 = r47
        L_0x023a:
            if (r22 == 0) goto L_0x0243
            androidx.compose.material3.MenuDefaults r17 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r17 = r17.m2202getShadowElevationD9Ej5fM()
            goto L_0x0245
        L_0x0243:
            r17 = r48
        L_0x0245:
            if (r23 == 0) goto L_0x0256
            r25 = r3
            r32 = r5
            r29 = r10
            r28 = r11
            r30 = r12
            r33 = r17
            r34 = 0
            goto L_0x0264
        L_0x0256:
            r34 = r49
            r25 = r3
            r32 = r5
            r29 = r10
            r28 = r11
            r30 = r12
            r33 = r17
        L_0x0264:
            r2.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0275
            java.lang.String r3 = "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:54)"
            r5 = 1431928300(0x55597dec, float:1.49459283E13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r6, r1, r3)
        L_0x0275:
            r1 = 1468213501(0x578328fd, float:2.88424133E14)
            java.lang.String r3 = "CC(remember):AndroidMenu.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r3)
            java.lang.Object r1 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r1 != r5) goto L_0x0298
            androidx.compose.animation.core.MutableTransitionState r1 = new androidx.compose.animation.core.MutableTransitionState
            r18 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r18)
            r1.<init>(r5)
            r2.updateRememberedValue(r1)
            goto L_0x029a
        L_0x0298:
            r18 = 0
        L_0x029a:
            androidx.compose.animation.core.MutableTransitionState r1 = (androidx.compose.animation.core.MutableTransitionState) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r37)
            r1.setTargetState$animation_core_release(r5)
            java.lang.Object r5 = r1.getCurrentState()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x02c2
            java.lang.Object r5 = r1.getTargetState()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x02bf
            goto L_0x02c2
        L_0x02bf:
            r1 = r2
            goto L_0x0384
        L_0x02c2:
            r5 = 1468219494(0x57834066, float:2.88625225E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r3)
            java.lang.Object r5 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r5 != r10) goto L_0x02e7
            androidx.compose.ui.graphics.TransformOrigin$Companion r5 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r10 = r5.m4673getCenterSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4660boximpl(r10)
            r10 = 0
            r11 = 2
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r10, r11, r10)
            r2.updateRememberedValue(r5)
        L_0x02e7:
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r12)
            java.lang.Object r10 = r2.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            r11 = 1468224270(0x5783530e, float:2.88785481E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r3)
            r3 = r6 & 7168(0x1c00, float:1.0045E-41)
            r11 = 2048(0x800, float:2.87E-42)
            if (r3 != r11) goto L_0x0311
            r18 = r4
        L_0x0311:
            boolean r3 = r2.changed((java.lang.Object) r10)
            r3 = r18 | r3
            java.lang.Object r11 = r2.rememberedValue()
            if (r3 != 0) goto L_0x0325
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r11 != r3) goto L_0x0348
        L_0x0325:
            androidx.compose.material3.internal.DropdownMenuPositionProvider r3 = new androidx.compose.material3.internal.DropdownMenuPositionProvider
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 r11 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            r11.<init>(r5)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 4
            r13 = 0
            r16 = 0
            r39 = r3
            r40 = r8
            r42 = r10
            r44 = r11
            r45 = r12
            r46 = r13
            r43 = r16
            r39.<init>(r40, r42, r43, r44, r45, r46)
            r11 = r39
            r2.updateRememberedValue(r11)
        L_0x0348:
            androidx.compose.material3.internal.DropdownMenuPositionProvider r11 = (androidx.compose.material3.internal.DropdownMenuPositionProvider) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.window.PopupPositionProvider r11 = (androidx.compose.ui.window.PopupPositionProvider) r11
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1 r24 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
            r35 = r50
            r26 = r1
            r27 = r5
            r24.<init>(r25, r26, r27, r28, r29, r30, r32, r33, r34, r35)
            r1 = r24
            r3 = 54
            r5 = 2126968933(0x7ec6f865, float:1.3223844E38)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r4, r1, r2, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r6 & 112(0x70, float:1.57E-43)
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            int r4 = r6 >> 9
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = 0
            r42 = r1
            r43 = r2
            r44 = r3
            r45 = r4
            r40 = r7
            r39 = r11
            r41 = r14
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r39, r40, r41, r42, r43, r44, r45)
            r1 = r43
        L_0x0384:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x038d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x038d:
            r4 = r8
            r3 = r25
            r6 = r28
            r8 = r29
            r9 = r30
            r11 = r32
            r12 = r33
            r13 = r34
            goto L_0x01a4
        L_0x039e:
            androidx.compose.runtime.ScopeUpdateScope r1 = r1.endRestartGroup()
            if (r1 == 0) goto L_0x03bc
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2 r0 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
            r2 = r38
            r14 = r50
            r16 = r53
            r17 = r54
            r36 = r1
            r1 = r37
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x03bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m1713DropdownMenuIlH_yew(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.foundation.ScrollState, androidx.compose.ui.window.PopupProperties, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ed  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith = @kotlin.ReplaceWith(expression = "DropdownMenu(\n    expanded = expanded,\n    onDismissRequest = onDismissRequest,\n    modifier = modifier,\n    offset = offset,\n    scrollState = scrollState,\n    properties = properties,\n    shape = MenuDefaults.shape,\n    containerColor = MenuDefaults.containerColor,\n    tonalElevation = MenuDefaults.TonalElevation,\n    shadowElevation = MenuDefaults.ShadowElevation,\n    border = null,\n    content = content,\n)", imports = {}))
    /* renamed from: DropdownMenu-4kj-_NE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1711DropdownMenu4kj_NE(boolean r28, kotlin.jvm.functions.Function0 r29, androidx.compose.ui.Modifier r30, long r31, androidx.compose.foundation.ScrollState r33, androidx.compose.ui.window.PopupProperties r34, kotlin.jvm.functions.Function3 r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r9 = r37
            r0 = -1137929566(0xffffffffbc2c92a2, float:-0.010533007)
            r1 = r36
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)119@4573L21,130@4960L5,131@5005L14,123@4721L465:AndroidMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r38 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r9 | 6
            r10 = r28
            goto L_0x002b
        L_0x0019:
            r2 = r9 & 6
            r10 = r28
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changed((boolean) r10)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r9
            goto L_0x002b
        L_0x002a:
            r2 = r9
        L_0x002b:
            r3 = r38 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            r11 = r29
            goto L_0x0046
        L_0x0034:
            r3 = r9 & 48
            r11 = r29
            if (r3 != 0) goto L_0x0046
            boolean r3 = r1.changedInstance(r11)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r38 & 4
            if (r3 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r4 = r9 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r30
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r5
            goto L_0x0062
        L_0x0060:
            r4 = r30
        L_0x0062:
            r5 = r38 & 8
            if (r5 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r6 = r9 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007c
            r6 = r31
            boolean r8 = r1.changed((long) r6)
            if (r8 == 0) goto L_0x0078
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r8
            goto L_0x007e
        L_0x007c:
            r6 = r31
        L_0x007e:
            r8 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0097
            r8 = r38 & 16
            if (r8 != 0) goto L_0x0091
            r8 = r33
            boolean r12 = r1.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x0093
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r8 = r33
        L_0x0093:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r12
            goto L_0x0099
        L_0x0097:
            r8 = r33
        L_0x0099:
            r12 = r38 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a1
            r2 = r2 | r13
            goto L_0x00b3
        L_0x00a1:
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00b3
            r13 = r34
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00af
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r14
            goto L_0x00b5
        L_0x00b3:
            r13 = r34
        L_0x00b5:
            r14 = r38 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bd
            r2 = r2 | r15
            goto L_0x00d0
        L_0x00bd:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00d0
            r14 = r35
            boolean r15 = r1.changedInstance(r14)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00d0:
            r14 = r35
        L_0x00d2:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r2
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ed
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00ed
        L_0x00e2:
            r1.skipToGroupEnd()
            r24 = r1
            r3 = r4
            r4 = r6
            r6 = r8
            r7 = r13
            goto L_0x01b0
        L_0x00ed:
            r1.startDefaults()
            r0 = r9 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x010f
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00fe
            goto L_0x010f
        L_0x00fe:
            r1.skipToGroupEnd()
            r0 = r38 & 16
            if (r0 == 0) goto L_0x0106
            r2 = r2 & r15
        L_0x0106:
            r12 = r4
        L_0x0107:
            r15 = r8
            r16 = r13
            r0 = -1137929566(0xffffffffbc2c92a2, float:-0.010533007)
            r13 = r6
            goto L_0x0151
        L_0x010f:
            if (r3 == 0) goto L_0x0116
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0117
        L_0x0116:
            r0 = r4
        L_0x0117:
            r3 = 0
            if (r5 == 0) goto L_0x0128
            float r4 = (float) r3
            float r5 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            long r4 = androidx.compose.ui.unit.DpKt.m7132DpOffsetYgX7TsA(r5, r4)
            r6 = r4
        L_0x0128:
            r4 = r38 & 16
            if (r4 == 0) goto L_0x0133
            r4 = 1
            androidx.compose.foundation.ScrollState r3 = androidx.compose.foundation.ScrollKt.rememberScrollState(r3, r1, r3, r4)
            r2 = r2 & r15
            r8 = r3
        L_0x0133:
            if (r12 == 0) goto L_0x014f
            androidx.compose.ui.window.PopupProperties r17 = new androidx.compose.ui.window.PopupProperties
            r22 = 14
            r23 = 0
            r18 = 1
            r19 = 0
            r20 = 0
            r21 = 0
            r17.<init>((boolean) r18, (boolean) r19, (boolean) r20, (boolean) r21, (int) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            r12 = r0
            r13 = r6
            r15 = r8
            r16 = r17
            r0 = -1137929566(0xffffffffbc2c92a2, float:-0.010533007)
            goto L_0x0151
        L_0x014f:
            r12 = r0
            goto L_0x0107
        L_0x0151:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0160
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:123)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x0160:
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            r3 = 6
            androidx.compose.ui.graphics.Shape r17 = r0.getShape(r1, r3)
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            long r18 = r0.getContainerColor(r1, r3)
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r20 = r0.m2203getTonalElevationD9Ej5fM()
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r21 = r0.m2202getShadowElevationD9Ej5fM()
            r0 = r2 & 14
            r4 = 905969664(0x36000000, float:1.9073486E-6)
            r0 = r0 | r4
            r4 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            r4 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r2
            r25 = r0 | r4
            int r0 = r2 >> 15
            r0 = r0 & 112(0x70, float:1.57E-43)
            r26 = r0 | 6
            r27 = 0
            r22 = 0
            r23 = r35
            r24 = r1
            m1713DropdownMenuIlH_yew(r10, r11, r12, r13, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ab
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ab:
            r3 = r12
            r4 = r13
            r6 = r15
            r7 = r16
        L_0x01b0:
            androidx.compose.runtime.ScopeUpdateScope r11 = r24.endRestartGroup()
            if (r11 == 0) goto L_0x01c8
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$3 r0 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$3
            r1 = r28
            r2 = r29
            r8 = r35
            r10 = r38
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m1711DropdownMenu4kj_NE(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.foundation.ScrollState, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @kotlin.ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1712DropdownMenuILWXrKs(boolean r27, kotlin.jvm.functions.Function0 r28, androidx.compose.ui.Modifier r29, long r30, androidx.compose.ui.window.PopupProperties r32, kotlin.jvm.functions.Function3 r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r8 = r35
            r0 = 354826666(0x152639aa, float:3.3568922E-26)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)163@6060L21,158@5896L251:AndroidMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r8 | 6
            r9 = r27
            goto L_0x002b
        L_0x0019:
            r2 = r8 & 6
            r9 = r27
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changed((boolean) r9)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r8
            goto L_0x002b
        L_0x002a:
            r2 = r8
        L_0x002b:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            r10 = r28
            goto L_0x0046
        L_0x0034:
            r3 = r8 & 48
            r10 = r28
            if (r3 != 0) goto L_0x0046
            boolean r3 = r1.changedInstance(r10)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r36 & 4
            if (r3 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r29
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r5
            goto L_0x0062
        L_0x0060:
            r4 = r29
        L_0x0062:
            r5 = r36 & 8
            if (r5 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007c
            r6 = r30
            boolean r11 = r1.changed((long) r6)
            if (r11 == 0) goto L_0x0078
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r11
            goto L_0x007e
        L_0x007c:
            r6 = r30
        L_0x007e:
            r11 = r36 & 16
            if (r11 == 0) goto L_0x0085
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r12 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0098
            r12 = r32
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r13
            goto L_0x009a
        L_0x0098:
            r12 = r32
        L_0x009a:
            r13 = r36 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a2
            r2 = r2 | r14
            goto L_0x00b5
        L_0x00a2:
            r13 = r8 & r14
            if (r13 != 0) goto L_0x00b5
            r13 = r33
            boolean r14 = r1.changedInstance(r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r33
        L_0x00b7:
            r14 = 74899(0x12493, float:1.04956E-40)
            r14 = r14 & r2
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00d1
            boolean r14 = r1.getSkipping()
            if (r14 != 0) goto L_0x00c7
            goto L_0x00d1
        L_0x00c7:
            r1.skipToGroupEnd()
            r23 = r1
            r3 = r4
            r4 = r6
            r6 = r12
            goto L_0x013e
        L_0x00d1:
            if (r3 == 0) goto L_0x00d8
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00d9
        L_0x00d8:
            r3 = r4
        L_0x00d9:
            r4 = 0
            if (r5 == 0) goto L_0x00ea
            float r5 = (float) r4
            float r6 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r5)
            float r5 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r5)
            long r5 = androidx.compose.ui.unit.DpKt.m7132DpOffsetYgX7TsA(r6, r5)
            r6 = r5
        L_0x00ea:
            if (r11 == 0) goto L_0x00fe
            androidx.compose.ui.window.PopupProperties r14 = new androidx.compose.ui.window.PopupProperties
            r19 = 14
            r20 = 0
            r15 = 1
            r16 = 0
            r17 = 0
            r18 = 0
            r14.<init>((boolean) r15, (boolean) r16, (boolean) r17, (boolean) r18, (int) r19, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            r15 = r14
            goto L_0x00ff
        L_0x00fe:
            r15 = r12
        L_0x00ff:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x010b
            r5 = -1
            java.lang.String r11 = "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:158)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r5, r11)
        L_0x010b:
            r0 = 1
            androidx.compose.foundation.ScrollState r14 = androidx.compose.foundation.ScrollKt.rememberScrollState(r4, r1, r4, r0)
            r0 = r2 & 8190(0x1ffe, float:1.1477E-41)
            int r4 = r2 << 3
            r5 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r5
            r24 = r0 | r4
            int r0 = r2 >> 12
            r25 = r0 & 112(0x70, float:1.57E-43)
            r26 = 1984(0x7c0, float:2.78E-42)
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = r1
            r11 = r3
            r22 = r13
            r12 = r6
            m1713DropdownMenuIlH_yew(r9, r10, r11, r12, r14, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x013b:
            r3 = r11
            r4 = r12
            r6 = r15
        L_0x013e:
            androidx.compose.runtime.ScopeUpdateScope r10 = r23.endRestartGroup()
            if (r10 == 0) goto L_0x0156
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$4 r0 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$4
            r1 = r27
            r2 = r28
            r7 = r33
            r9 = r36
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0156:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m1712DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItem(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, boolean r28, androidx.compose.material3.MenuItemColors r29, androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r10 = r33
            r11 = r34
            r0 = 1826340448(0x6cdbbe60, float:2.1252302E27)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(DropdownMenuItem)P(7,6,5,4,8,2)194@8925L12,180@6505L319:AndroidMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r12 = r23
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r12 = r23
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r12)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r10
            goto L_0x002d
        L_0x002c:
            r2 = r10
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r13 = r24
            goto L_0x0048
        L_0x0036:
            r3 = r10 & 48
            r13 = r24
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r13)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r4 = r10 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r25
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
            r4 = r25
        L_0x0064:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r6 = r10 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007e
            r6 = r26
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x007a
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r7
            goto L_0x0080
        L_0x007e:
            r6 = r26
        L_0x0080:
            r7 = r11 & 16
            if (r7 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r8 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x009a
            r8 = r27
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
            r8 = r27
        L_0x009c:
            r9 = r11 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r9 == 0) goto L_0x00a4
            r2 = r2 | r14
            goto L_0x00b6
        L_0x00a4:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b6
            r14 = r28
            boolean r15 = r1.changed((boolean) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r28
        L_0x00b8:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00d3
            r15 = r11 & 64
            if (r15 != 0) goto L_0x00cc
            r15 = r29
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r15 = r29
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r2 = r2 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r29
        L_0x00d5:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00de
            r2 = r2 | r17
            goto L_0x00f4
        L_0x00de:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00f4
            r17 = r0
            r0 = r30
            boolean r18 = r1.changed((java.lang.Object) r0)
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
            r0 = r30
        L_0x00f8:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0101
            r2 = r2 | r18
            goto L_0x0117
        L_0x0101:
            r18 = r10 & r18
            if (r18 != 0) goto L_0x0117
            r18 = r0
            r0 = r31
            boolean r19 = r1.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x0112
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0114
        L_0x0112:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0114:
            r2 = r2 | r19
            goto L_0x011b
        L_0x0117:
            r18 = r0
            r0 = r31
        L_0x011b:
            r19 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r19
            r32 = r2
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x013e
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x012e
            goto L_0x013e
        L_0x012e:
            r1.skipToGroupEnd()
            r9 = r31
            r21 = r1
            r3 = r4
            r4 = r6
            r5 = r8
            r6 = r14
            r7 = r15
            r8 = r30
            goto L_0x01d5
        L_0x013e:
            r1.startDefaults()
            r0 = r10 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x016f
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014f
            goto L_0x016f
        L_0x014f:
            r1.skipToGroupEnd()
            r0 = r11 & 64
            if (r0 == 0) goto L_0x015d
            r2 = r32 & r2
            r19 = r30
            r20 = r31
            goto L_0x0163
        L_0x015d:
            r19 = r30
            r20 = r31
            r2 = r32
        L_0x0163:
            r16 = r8
            r17 = r14
            r18 = r15
            r0 = 1826340448(0x6cdbbe60, float:2.1252302E27)
            r14 = r4
            r15 = r6
            goto L_0x01a7
        L_0x016f:
            if (r3 == 0) goto L_0x0176
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0176:
            r0 = 0
            if (r5 == 0) goto L_0x017a
            r6 = r0
        L_0x017a:
            if (r7 == 0) goto L_0x017d
            r8 = r0
        L_0x017d:
            if (r9 == 0) goto L_0x0181
            r3 = 1
            r14 = r3
        L_0x0181:
            r3 = r11 & 64
            if (r3 == 0) goto L_0x0190
            androidx.compose.material3.MenuDefaults r3 = androidx.compose.material3.MenuDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.MenuItemColors r3 = r3.itemColors(r1, r5)
            r2 = r32 & r2
            r15 = r3
            goto L_0x0192
        L_0x0190:
            r2 = r32
        L_0x0192:
            if (r17 == 0) goto L_0x019b
            androidx.compose.material3.MenuDefaults r3 = androidx.compose.material3.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r3 = r3.getDropdownMenuItemContentPadding()
            goto L_0x019d
        L_0x019b:
            r3 = r30
        L_0x019d:
            if (r18 == 0) goto L_0x01a2
            r20 = r0
            goto L_0x01a4
        L_0x01a2:
            r20 = r31
        L_0x01a4:
            r19 = r3
            goto L_0x0163
        L_0x01a7:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01b6
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:179)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x01b6:
            r0 = 268435454(0xffffffe, float:2.5243546E-29)
            r22 = r2 & r0
            r21 = r1
            androidx.compose.material3.MenuKt.DropdownMenuItemContent(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c9:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
        L_0x01d5:
            androidx.compose.runtime.ScopeUpdateScope r12 = r21.endRestartGroup()
            if (r12 == 0) goto L_0x01e9
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenuItem$1 r0 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenuItem$1
            r1 = r23
            r2 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.DropdownMenuItem(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.MenuItemColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }
}
