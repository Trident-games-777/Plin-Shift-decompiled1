package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float ContainerMaxWidth = Dp.m7111constructorimpl((float) 600);
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m7111constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m7111constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset = Dp.m7111constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m7111constructorimpl((float) 2);
    private static final float SnackbarVerticalPadding = Dp.m7111constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing;

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011a  */
    /* renamed from: Snackbar-eQBnUkQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2519SnackbareQBnUkQ(androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, boolean r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, long r33, long r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r15 = r39
            r0 = r40
            r1 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r1)
            java.lang.String r3 = "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)107@5066L5,108@5118L5,109@5168L12,110@5231L18,111@5307L25,120@5574L1123,114@5378L1319:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r0 & 1
            if (r3 == 0) goto L_0x001c
            r4 = r15 | 6
            r5 = r4
            r4 = r24
            goto L_0x0030
        L_0x001c:
            r4 = r15 & 6
            if (r4 != 0) goto L_0x002d
            r4 = r24
            boolean r5 = r2.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x002a
            r5 = 4
            goto L_0x002b
        L_0x002a:
            r5 = 2
        L_0x002b:
            r5 = r5 | r15
            goto L_0x0030
        L_0x002d:
            r4 = r24
            r5 = r15
        L_0x0030:
            r6 = r0 & 2
            if (r6 == 0) goto L_0x0037
            r5 = r5 | 48
            goto L_0x004a
        L_0x0037:
            r7 = r15 & 48
            if (r7 != 0) goto L_0x004a
            r7 = r25
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x0046
            r8 = 32
            goto L_0x0048
        L_0x0046:
            r8 = 16
        L_0x0048:
            r5 = r5 | r8
            goto L_0x004c
        L_0x004a:
            r7 = r25
        L_0x004c:
            r8 = r0 & 4
            if (r8 == 0) goto L_0x0053
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r9 = r15 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0066
            r9 = r26
            boolean r10 = r2.changedInstance(r9)
            if (r10 == 0) goto L_0x0062
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r5 = r5 | r10
            goto L_0x0068
        L_0x0066:
            r9 = r26
        L_0x0068:
            r10 = r0 & 8
            if (r10 == 0) goto L_0x006f
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r11 = r15 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0082
            r11 = r27
            boolean r12 = r2.changed((boolean) r11)
            if (r12 == 0) goto L_0x007e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r5 = r5 | r12
            goto L_0x0084
        L_0x0082:
            r11 = r27
        L_0x0084:
            r12 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009d
            r12 = r0 & 16
            if (r12 != 0) goto L_0x0097
            r12 = r28
            boolean r13 = r2.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0099
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r12 = r28
        L_0x0099:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r5 = r5 | r13
            goto L_0x009f
        L_0x009d:
            r12 = r28
        L_0x009f:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x00ba
            r13 = r0 & 32
            if (r13 != 0) goto L_0x00b3
            r13 = r29
            boolean r16 = r2.changed((long) r13)
            if (r16 == 0) goto L_0x00b5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b3:
            r13 = r29
        L_0x00b5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r5 = r5 | r16
            goto L_0x00bc
        L_0x00ba:
            r13 = r29
        L_0x00bc:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00d8
            r16 = r0 & 64
            r38 = r3
            r3 = r31
            if (r16 != 0) goto L_0x00d3
            boolean r16 = r2.changed((long) r3)
            if (r16 == 0) goto L_0x00d3
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r5 = r5 | r16
            goto L_0x00dc
        L_0x00d8:
            r38 = r3
            r3 = r31
        L_0x00dc:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00f5
            r1 = r0 & 128(0x80, float:1.794E-43)
            r3 = r33
            if (r1 != 0) goto L_0x00f1
            boolean r1 = r2.changed((long) r3)
            if (r1 == 0) goto L_0x00f1
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r1 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r5 = r5 | r1
            goto L_0x00f7
        L_0x00f5:
            r3 = r33
        L_0x00f7:
            r1 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 & r15
            if (r1 != 0) goto L_0x010f
            r1 = r0 & 256(0x100, float:3.59E-43)
            r3 = r35
            if (r1 != 0) goto L_0x010b
            boolean r1 = r2.changed((long) r3)
            if (r1 == 0) goto L_0x010b
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x010b:
            r1 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r5 = r5 | r1
            goto L_0x0111
        L_0x010f:
            r3 = r35
        L_0x0111:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r17 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x011a
            r5 = r5 | r17
            goto L_0x012e
        L_0x011a:
            r1 = r15 & r17
            if (r1 != 0) goto L_0x012e
            r1 = r37
            boolean r17 = r2.changedInstance(r1)
            if (r17 == 0) goto L_0x0129
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012b
        L_0x0129:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012b:
            r5 = r5 | r17
            goto L_0x0130
        L_0x012e:
            r1 = r37
        L_0x0130:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r5 & r17
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r3) goto L_0x0154
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x0141
            goto L_0x0154
        L_0x0141:
            r2.skipToGroupEnd()
            r1 = r24
            r0 = r2
            r2 = r7
            r3 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r8 = r31
            r10 = r33
            r12 = r35
            goto L_0x027b
        L_0x0154:
            r2.startDefaults()
            r1 = r15 & 1
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x019f
            boolean r1 = r2.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0171
            goto L_0x019f
        L_0x0171:
            r2.skipToGroupEnd()
            r1 = r0 & 16
            if (r1 == 0) goto L_0x017a
            r5 = r5 & r19
        L_0x017a:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0180
            r5 = r5 & r18
        L_0x0180:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0186
            r5 = r5 & r17
        L_0x0186:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x018b
            r5 = r5 & r4
        L_0x018b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0190
            r5 = r5 & r3
        L_0x0190:
            r1 = r24
            r17 = r33
            r21 = r35
            r20 = r9
            r6 = r11
            r8 = r12
            r10 = r13
            r12 = r31
            goto L_0x0201
        L_0x019f:
            if (r38 == 0) goto L_0x01a6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01a8
        L_0x01a6:
            r1 = r24
        L_0x01a8:
            r20 = 0
            if (r6 == 0) goto L_0x01ae
            r7 = r20
        L_0x01ae:
            if (r8 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r20 = r9
        L_0x01b3:
            if (r10 == 0) goto L_0x01b7
            r6 = 0
            goto L_0x01b8
        L_0x01b7:
            r6 = r11
        L_0x01b8:
            r8 = r0 & 16
            r9 = 6
            if (r8 == 0) goto L_0x01c6
            androidx.compose.material3.SnackbarDefaults r8 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r8 = r8.getShape(r2, r9)
            r5 = r5 & r19
            goto L_0x01c7
        L_0x01c6:
            r8 = r12
        L_0x01c7:
            r10 = r0 & 32
            if (r10 == 0) goto L_0x01d4
            androidx.compose.material3.SnackbarDefaults r10 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r10 = r10.getColor(r2, r9)
            r5 = r5 & r18
            goto L_0x01d5
        L_0x01d4:
            r10 = r13
        L_0x01d5:
            r12 = r0 & 64
            if (r12 == 0) goto L_0x01e2
            androidx.compose.material3.SnackbarDefaults r12 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r12 = r12.getContentColor(r2, r9)
            r5 = r5 & r17
            goto L_0x01e4
        L_0x01e2:
            r12 = r31
        L_0x01e4:
            r14 = r0 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x01f1
            androidx.compose.material3.SnackbarDefaults r14 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r17 = r14.getActionContentColor(r2, r9)
            r4 = r4 & r5
            r5 = r4
            goto L_0x01f3
        L_0x01f1:
            r17 = r33
        L_0x01f3:
            r4 = r0 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x01ff
            androidx.compose.material3.SnackbarDefaults r4 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r21 = r4.getDismissActionContentColor(r2, r9)
            r5 = r5 & r3
            goto L_0x0201
        L_0x01ff:
            r21 = r35
        L_0x0201:
            r2.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0213
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.Snackbar (Snackbar.kt:113)"
            r9 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r5, r3, r4)
        L_0x0213:
            androidx.compose.material3.tokens.SnackbarTokens r3 = androidx.compose.material3.tokens.SnackbarTokens.INSTANCE
            float r3 = r3.m3524getContainerElevationD9Ej5fM()
            androidx.compose.material3.SnackbarKt$Snackbar$1 r4 = new androidx.compose.material3.SnackbarKt$Snackbar$1
            r27 = r37
            r24 = r4
            r25 = r6
            r26 = r7
            r29 = r17
            r28 = r20
            r31 = r21
            r24.<init>(r25, r26, r27, r28, r29, r31)
            r9 = 54
            r14 = -1829663446(0xffffffff92f18d2a, float:-1.5244038E-27)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r14, r0, r4, r2, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4 = r5 & 14
            r9 = 12779520(0xc30000, float:1.7907922E-38)
            r4 = r4 | r9
            int r5 = r5 >> 9
            r9 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r9
            r9 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            r5 = 80
            r9 = 0
            r14 = 0
            r33 = r0
            r24 = r1
            r34 = r2
            r31 = r3
            r35 = r4
            r36 = r5
            r25 = r8
            r30 = r9
            r26 = r10
            r28 = r12
            r32 = r14
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r24, r25, r26, r28, r30, r31, r32, r33, r34, r35, r36)
            r0 = r34
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0270
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0270:
            r4 = r6
            r2 = r7
            r5 = r8
            r6 = r10
            r8 = r12
            r10 = r17
            r3 = r20
            r12 = r21
        L_0x027b:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x0294
            r14 = r0
            androidx.compose.material3.SnackbarKt$Snackbar$2 r0 = new androidx.compose.material3.SnackbarKt$Snackbar$2
            r16 = r40
            r23 = r14
            r14 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r12, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14 = r23
            r14.updateScope(r0)
        L_0x0294:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m2519SnackbareQBnUkQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x010e  */
    /* renamed from: Snackbar-sDKtq54  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2520SnackbarsDKtq54(androidx.compose.material3.SnackbarData r34, androidx.compose.ui.Modifier r35, boolean r36, androidx.compose.ui.graphics.Shape r37, long r38, long r40, long r42, long r44, long r46, androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r1 = r34
            r15 = r49
            r0 = r50
            r2 = 274621471(0x105e641f, float:4.385891E-29)
            r3 = r48
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)205@9602L5,206@9654L5,207@9704L12,208@9760L11,209@9822L18,210@9898L25,251@11371L38,241@10959L456:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r0 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r15 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r15
            goto L_0x002b
        L_0x002a:
            r4 = r15
        L_0x002b:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r15 & 48
            if (r6 != 0) goto L_0x0045
            r6 = r35
            boolean r7 = r3.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r35
        L_0x0047:
            r7 = r0 & 4
            if (r7 == 0) goto L_0x004e
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r8 = r15 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0061
            r8 = r36
            boolean r9 = r3.changed((boolean) r8)
            if (r9 == 0) goto L_0x005d
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r4 = r4 | r9
            goto L_0x0063
        L_0x0061:
            r8 = r36
        L_0x0063:
            r9 = r15 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007c
            r9 = r0 & 8
            if (r9 != 0) goto L_0x0076
            r9 = r37
            boolean r10 = r3.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r9 = r37
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r10
            goto L_0x007e
        L_0x007c:
            r9 = r37
        L_0x007e:
            r10 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0097
            r10 = r0 & 16
            if (r10 != 0) goto L_0x0091
            r10 = r38
            boolean r12 = r3.changed((long) r10)
            if (r12 == 0) goto L_0x0093
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r10 = r38
        L_0x0093:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r4 = r4 | r12
            goto L_0x0099
        L_0x0097:
            r10 = r38
        L_0x0099:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r15
            if (r12 != 0) goto L_0x00b3
            r12 = r0 & 32
            if (r12 != 0) goto L_0x00ad
            r12 = r40
            boolean r14 = r3.changed((long) r12)
            if (r14 == 0) goto L_0x00af
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r12 = r40
        L_0x00af:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r4 = r4 | r14
            goto L_0x00b5
        L_0x00b3:
            r12 = r40
        L_0x00b5:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r15
            if (r14 != 0) goto L_0x00d6
            r14 = r0 & 64
            if (r14 != 0) goto L_0x00cc
            r14 = r4
            r48 = r5
            r4 = r42
            boolean r16 = r3.changed((long) r4)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00cc:
            r14 = r4
            r48 = r5
            r4 = r42
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r14 = r14 | r16
            goto L_0x00db
        L_0x00d6:
            r14 = r4
            r48 = r5
            r4 = r42
        L_0x00db:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00f4
            r2 = r0 & 128(0x80, float:1.794E-43)
            r4 = r44
            if (r2 != 0) goto L_0x00f0
            boolean r2 = r3.changed((long) r4)
            if (r2 == 0) goto L_0x00f0
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r14 = r14 | r2
            goto L_0x00f6
        L_0x00f4:
            r4 = r44
        L_0x00f6:
            r2 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 & r15
            if (r2 != 0) goto L_0x010e
            r2 = r0 & 256(0x100, float:3.59E-43)
            r4 = r46
            if (r2 != 0) goto L_0x010a
            boolean r2 = r3.changed((long) r4)
            if (r2 == 0) goto L_0x010a
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010c
        L_0x010a:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010c:
            r14 = r14 | r2
            goto L_0x0110
        L_0x010e:
            r4 = r46
        L_0x0110:
            r2 = 38347923(0x2492493, float:1.4777644E-37)
            r2 = r2 & r14
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r4) goto L_0x0132
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x0120
            goto L_0x0132
        L_0x0120:
            r3.skipToGroupEnd()
            r30 = r3
            r2 = r6
            r3 = r8
            r4 = r9
            r5 = r10
            r7 = r12
            r9 = r42
            r11 = r44
            r13 = r46
            goto L_0x02c2
        L_0x0132:
            r3.startDefaults()
            r2 = r15 & 1
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r5 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r2 == 0) goto L_0x0185
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x014f
            goto L_0x0185
        L_0x014f:
            r3.skipToGroupEnd()
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0158
            r14 = r14 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0158:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x015e
            r14 = r14 & r19
        L_0x015e:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x0164
            r14 = r14 & r18
        L_0x0164:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x016a
            r14 = r14 & r17
        L_0x016a:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x016f
            r14 = r14 & r5
        L_0x016f:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0174
            r14 = r14 & r4
        L_0x0174:
            r4 = r42
            r25 = r44
            r27 = r46
            r2 = r6
            r19 = r8
            r20 = r9
            r21 = r10
            r23 = r12
            goto L_0x0203
        L_0x0185:
            if (r48 == 0) goto L_0x018c
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x018d
        L_0x018c:
            r2 = r6
        L_0x018d:
            if (r7 == 0) goto L_0x0191
            r6 = 0
            goto L_0x0192
        L_0x0191:
            r6 = r8
        L_0x0192:
            r7 = r0 & 8
            r8 = 6
            if (r7 == 0) goto L_0x01a0
            androidx.compose.material3.SnackbarDefaults r7 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r7 = r7.getShape(r3, r8)
            r14 = r14 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01a1
        L_0x01a0:
            r7 = r9
        L_0x01a1:
            r9 = r0 & 16
            if (r9 == 0) goto L_0x01ae
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r9 = r9.getColor(r3, r8)
            r14 = r14 & r19
            goto L_0x01af
        L_0x01ae:
            r9 = r10
        L_0x01af:
            r11 = r0 & 32
            if (r11 == 0) goto L_0x01bc
            androidx.compose.material3.SnackbarDefaults r11 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r11 = r11.getContentColor(r3, r8)
            r14 = r14 & r18
            goto L_0x01bd
        L_0x01bc:
            r11 = r12
        L_0x01bd:
            r13 = r0 & 64
            if (r13 == 0) goto L_0x01ca
            androidx.compose.material3.SnackbarDefaults r13 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r18 = r13.getActionColor(r3, r8)
            r14 = r14 & r17
            goto L_0x01cc
        L_0x01ca:
            r18 = r42
        L_0x01cc:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x01d9
            androidx.compose.material3.SnackbarDefaults r13 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r20 = r13.getActionContentColor(r3, r8)
            r5 = r5 & r14
            r14 = r5
            goto L_0x01db
        L_0x01d9:
            r20 = r44
        L_0x01db:
            r5 = r0 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x01f5
            androidx.compose.material3.SnackbarDefaults r5 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r22 = r5.getDismissActionContentColor(r3, r8)
            r14 = r14 & r4
            r4 = r18
            r25 = r20
            r27 = r22
            r19 = r6
            r20 = r7
            r21 = r9
            r23 = r11
            goto L_0x0203
        L_0x01f5:
            r27 = r46
            r23 = r11
            r4 = r18
            r25 = r20
            r19 = r6
            r20 = r7
            r21 = r9
        L_0x0203:
            r3.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0215
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.Snackbar (Snackbar.kt:211)"
            r8 = 274621471(0x105e641f, float:4.385891E-29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r14, r6, r7)
        L_0x0215:
            androidx.compose.material3.SnackbarVisuals r6 = r1.getVisuals()
            java.lang.String r6 = r6.getActionLabel()
            r7 = 1561344786(0x5d103b12, float:6.4955752E17)
            r3.startReplaceGroup(r7)
            java.lang.String r7 = "215@10097L267"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r7)
            r7 = 0
            r8 = 54
            r9 = 1
            if (r6 == 0) goto L_0x023f
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1 r10 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
            r10.<init>(r4, r1, r6)
            r6 = -1378313599(0xffffffffadd89a81, float:-2.462497E-11)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r9, r10, r3, r8)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r17 = r6
            goto L_0x0241
        L_0x023f:
            r17 = r7
        L_0x0241:
            r3.endReplaceGroup()
            r6 = 1561358724(0x5d107184, float:6.5051533E17)
            r3.startReplaceGroup(r6)
            java.lang.String r6 = "227@10548L362"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            androidx.compose.material3.SnackbarVisuals r6 = r1.getVisuals()
            boolean r6 = r6.getWithDismissAction()
            if (r6 == 0) goto L_0x0268
            androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1 r6 = new androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
            r6.<init>(r1)
            r7 = -1812633777(0xffffffff93f5674f, float:-6.1948565E-27)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r9, r6, r3, r8)
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
        L_0x0268:
            r18 = r7
            r3.endReplaceGroup()
            r6 = 12
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r6)
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.PaddingKt.m775padding3ABfNKs(r2, r6)
            androidx.compose.material3.SnackbarKt$Snackbar$3 r6 = new androidx.compose.material3.SnackbarKt$Snackbar$3
            r6.<init>(r1)
            r7 = -1266389126(0xffffffffb4846f7a, float:-2.4668026E-7)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r9, r6, r3, r8)
            r29 = r6
            kotlin.jvm.functions.Function2 r29 = (kotlin.jvm.functions.Function2) r29
            int r6 = r14 << 3
            r7 = r6 & 7168(0x1c00, float:1.0045E-41)
            r8 = 805306368(0x30000000, float:4.656613E-10)
            r7 = r7 | r8
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r6
            r7 = r7 | r8
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r6
            r7 = r7 | r8
            r8 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r8
            r6 = r6 | r7
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r14
            r6 = r6 | r7
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r7 & r14
            r31 = r6 | r7
            r32 = 0
            r30 = r3
            m2519SnackbareQBnUkQ(r16, r17, r18, r19, r20, r21, r23, r25, r27, r29, r30, r31, r32)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02b5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b5:
            r9 = r4
            r3 = r19
            r4 = r20
            r5 = r21
            r7 = r23
            r11 = r25
            r13 = r27
        L_0x02c2:
            androidx.compose.runtime.ScopeUpdateScope r0 = r30.endRestartGroup()
            if (r0 == 0) goto L_0x02da
            r16 = r0
            androidx.compose.material3.SnackbarKt$Snackbar$4 r0 = new androidx.compose.material3.SnackbarKt$Snackbar$4
            r33 = r16
            r16 = r50
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r13, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x02da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m2520SnackbarsDKtq54(androidx.compose.material3.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2517NewLineButtonSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        TextStyle textStyle2 = textStyle;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)264@11690L1175:Snackbar.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 2048 : 1024;
        }
        long j3 = j;
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 16384 : 8192;
        }
        long j4 = j2;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:263)");
            }
            Modifier r0 = PaddingKt.m779paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m852widthInVpY3zN4$default(Modifier.Companion, 0.0f, ContainerMaxWidth, 1, (Object) null), 0.0f, 1, (Object) null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i4 = i2;
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
            Composer r6 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r6, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r6, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -376152340, "C272@11979L191,279@12180L679:Snackbar.kt#uh7d8r");
            Modifier r22 = AlignmentLineKt.m595paddingFromBaselineVpY3zN4(Modifier.Companion, HeightToFirstLine, LongButtonVerticalOffset);
            float f = HorizontalSpacingButtonSide;
            Modifier r62 = PaddingKt.m779paddingqDBjuR0$default(r22, 0.0f, 0.0f, f, 0.0f, 11, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r62);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            int i5 = currentCompositeKeyHash2;
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
            Composer r10 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r10, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(i5))) {
                r10.updateRememberedValue(Integer.valueOf(i5));
                r10.apply(Integer.valueOf(i5), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1482962025, "C276@12154L6:Snackbar.kt#uh7d8r");
            function24.invoke(startRestartGroup, Integer.valueOf(i4 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier align = columnScope.align(Modifier.Companion, Alignment.Companion.getEnd());
            if (function26 != null) {
                f = Dp.m7111constructorimpl((float) 0);
            }
            Modifier r02 = PaddingKt.m779paddingqDBjuR0$default(align, 0.0f, 0.0f, f, 0.0f, 11, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, r02);
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
            Composer r63 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r63, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r63, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r63.getInserting() || !Intrinsics.areEqual(r63.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r63.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r63.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r63, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1482754232, "C283@12348L501:Snackbar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer r9 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r9, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r9.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3682setimpl(r9, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1996615437, "C284@12370L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle2)}, function25, startRestartGroup, ProvidedValue.$stable | (i4 & 112));
            startRestartGroup.startReplaceGroup(618603253);
            ComposerKt.sourceInformation(startRestartGroup, "290@12644L173");
            if (function26 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j4)), function26, startRestartGroup, ProvidedValue.$stable | ((i4 >> 3) & 112));
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
            endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(function24, function25, function26, textStyle2, j, j4, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2518OneRowSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        int i2;
        float f;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        TextStyle textStyle2 = textStyle;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)338@14229L3580,312@13223L4586:Snackbar.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 2048 : 1024;
        }
        long j3 = j;
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 16384 : 8192;
        }
        long j4 = j2;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:308)");
            }
            Modifier modifier = Modifier.Companion;
            float f2 = HorizontalSpacing;
            if (function26 == null) {
                f = HorizontalSpacingButtonSide;
            } else {
                f = Dp.m7111constructorimpl((float) 0);
            }
            Modifier r8 = PaddingKt.m779paddingqDBjuR0$default(modifier, f2, 0.0f, f, 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1386942712, "CC(remember):Snackbar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            int i4 = i2;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarKt$OneRowSnackbar$2$1("action", "dismissAction", "text");
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r8);
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
            Composer r10 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r10, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r10, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2016566027, "C314@13253L86:Snackbar.kt#uh7d8r");
            Modifier r7 = PaddingKt.m777paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
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
            Composer r82 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r82, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r82, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r82.getInserting() || !Intrinsics.areEqual(r82.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r82.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r82.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r82, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1308937155, "C314@13331L6:Snackbar.kt#uh7d8r");
            function24.invoke(startRestartGroup, Integer.valueOf(i4 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-904778058);
            ComposerKt.sourceInformation(startRestartGroup, "316@13390L295");
            if (function25 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "action");
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
                Composer r72 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r72, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r72, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r72.getInserting() || !Intrinsics.areEqual(r72.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r72.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r72.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3682setimpl(r72, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1309057900, "C317@13446L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle2)}, function25, startRestartGroup, ProvidedValue.$stable | (i4 & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-904766579);
            ComposerKt.sourceInformation(startRestartGroup, "325@13757L247");
            if (function26 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "dismissAction");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r102 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r102, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r102, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r102.getInserting() || !Intrinsics.areEqual(r102.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                    r102.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    r102.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3682setimpl(r102, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1309427203, "C326@13820L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j2)), function26, startRestartGroup, ProvidedValue.$stable | ((i4 >> 3) & 112));
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
            endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(function24, function25, function26, textStyle2, j, j2, i));
        }
    }

    static {
        float f = (float) 8;
        HorizontalSpacingButtonSide = Dp.m7111constructorimpl(f);
        TextEndExtraSpacing = Dp.m7111constructorimpl(f);
    }
}
