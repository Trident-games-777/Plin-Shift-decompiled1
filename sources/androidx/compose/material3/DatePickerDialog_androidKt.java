package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DialogButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DialogButtonsMainAxisSpacing", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePickerDialog.android.kt */
public final class DatePickerDialog_androidKt {
    /* access modifiers changed from: private */
    public static final float DialogButtonsCrossAxisSpacing = Dp.m7111constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float DialogButtonsMainAxisSpacing;
    /* access modifiers changed from: private */
    public static final PaddingValues DialogButtonsPadding;

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fe  */
    /* renamed from: DatePickerDialog-GmEhDVc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1982DatePickerDialogGmEhDVc(kotlin.jvm.functions.Function0<kotlin.Unit> r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.ui.graphics.Shape r23, float r24, androidx.compose.material3.DatePickerColors r25, androidx.compose.ui.window.DialogProperties r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r10 = r29
            r11 = r30
            r0 = -36517340(0xfffffffffdd2ca24, float:-3.5023432E37)
            r1 = r28
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DatePickerDialog)P(5,1,4,3,7,8:c#ui.unit.Dp!1,6)71@3518L5,73@3635L8,81@3937L1615,77@3787L1765:DatePickerDialog.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x001c
            r1 = r10 | 6
            r2 = r1
            r1 = r19
            goto L_0x0030
        L_0x001c:
            r1 = r10 & 6
            if (r1 != 0) goto L_0x002d
            r1 = r19
            boolean r2 = r5.changedInstance(r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r10
            goto L_0x0030
        L_0x002d:
            r1 = r19
            r2 = r10
        L_0x0030:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r3 = r10 & 48
            if (r3 != 0) goto L_0x004a
            r3 = r20
            boolean r4 = r5.changedInstance(r3)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r2 = r2 | r4
            goto L_0x004c
        L_0x004a:
            r3 = r20
        L_0x004c:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0053
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0066
            r6 = r21
            boolean r7 = r5.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r21
        L_0x0068:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0082
            r8 = r22
            boolean r9 = r5.changedInstance(r8)
            if (r9 == 0) goto L_0x007e
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r2 = r2 | r9
            goto L_0x0084
        L_0x0082:
            r8 = r22
        L_0x0084:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009d
            r9 = r11 & 16
            if (r9 != 0) goto L_0x0097
            r9 = r23
            boolean r12 = r5.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0099
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r9 = r23
        L_0x0099:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r2 = r2 | r12
            goto L_0x009f
        L_0x009d:
            r9 = r23
        L_0x009f:
            r12 = r11 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a7
            r2 = r2 | r13
            goto L_0x00b9
        L_0x00a7:
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b9
            r13 = r24
            boolean r14 = r5.changed((float) r13)
            if (r14 == 0) goto L_0x00b5
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r14
            goto L_0x00bb
        L_0x00b9:
            r13 = r24
        L_0x00bb:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00d5
            r14 = r11 & 64
            if (r14 != 0) goto L_0x00cf
            r14 = r25
            boolean r15 = r5.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00d1
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00cf:
            r14 = r25
        L_0x00d1:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r2 = r2 | r15
            goto L_0x00d7
        L_0x00d5:
            r14 = r25
        L_0x00d7:
            r15 = r11 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00e2
            r2 = r2 | r16
            r0 = r26
            goto L_0x00f5
        L_0x00e2:
            r16 = r10 & r16
            r0 = r26
            if (r16 != 0) goto L_0x00f5
            boolean r17 = r5.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00f1
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r2 = r2 | r17
        L_0x00f5:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fe
            r2 = r2 | r17
            goto L_0x0112
        L_0x00fe:
            r0 = r10 & r17
            if (r0 != 0) goto L_0x0112
            r0 = r27
            boolean r17 = r5.changedInstance(r0)
            if (r17 == 0) goto L_0x010d
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010d:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r2 = r2 | r17
            goto L_0x0114
        L_0x0112:
            r0 = r27
        L_0x0114:
            r17 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r17
            r1 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r1) goto L_0x0132
            boolean r0 = r5.getSkipping()
            if (r0 != 0) goto L_0x0125
            goto L_0x0132
        L_0x0125:
            r5.skipToGroupEnd()
            r0 = r5
            r3 = r6
            r4 = r8
            r5 = r9
            r6 = r13
            r8 = r26
        L_0x012f:
            r7 = r14
            goto L_0x01f6
        L_0x0132:
            r5.startDefaults()
            r0 = r10 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r28 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = 0
            if (r0 == 0) goto L_0x015e
            boolean r0 = r5.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0147
            goto L_0x015e
        L_0x0147:
            r5.skipToGroupEnd()
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0150
            r2 = r2 & r17
        L_0x0150:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0156
            r2 = r2 & r28
        L_0x0156:
            r3 = r26
        L_0x0158:
            r0 = r6
            r17 = r8
            r15 = r13
            r13 = r9
            goto L_0x01a7
        L_0x015e:
            if (r4 == 0) goto L_0x0165
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0165:
            if (r7 == 0) goto L_0x0168
            r8 = r1
        L_0x0168:
            r0 = r11 & 16
            r4 = 6
            if (r0 == 0) goto L_0x0176
            androidx.compose.material3.DatePickerDefaults r0 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getShape(r5, r4)
            r2 = r2 & r17
            r9 = r0
        L_0x0176:
            if (r12 == 0) goto L_0x017f
            androidx.compose.material3.DatePickerDefaults r0 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            float r0 = r0.m1981getTonalElevationD9Ej5fM()
            r13 = r0
        L_0x017f:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x018c
            androidx.compose.material3.DatePickerDefaults r0 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            androidx.compose.material3.DatePickerColors r0 = r0.colors(r5, r4)
            r2 = r2 & r28
            r14 = r0
        L_0x018c:
            if (r15 == 0) goto L_0x0156
            androidx.compose.ui.window.DialogProperties r0 = new androidx.compose.ui.window.DialogProperties
            r4 = 3
            r7 = 0
            r12 = 0
            r15 = 0
            r17 = 0
            r21 = r0
            r25 = r4
            r26 = r7
            r22 = r12
            r23 = r15
            r24 = r17
            r21.<init>((boolean) r22, (boolean) r23, (boolean) r24, (int) r25, (kotlin.jvm.internal.DefaultConstructorMarker) r26)
            r3 = r0
            goto L_0x0158
        L_0x01a7:
            r5.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01b9
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:76)"
            r7 = -36517340(0xfffffffffdd2ca24, float:-3.5023432E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r4, r6)
        L_0x01b9:
            r4 = 0
            r6 = 3
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r0, r1, r4, r6, r1)
            androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1 r12 = new androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
            r18 = r20
            r16 = r27
            r12.<init>(r13, r14, r15, r16, r17, r18)
            r4 = 54
            r6 = -10625622(0xffffffffff5dddaa, float:-2.9491033E38)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r12, r5, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r6 = r2 & 14
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            int r2 = r2 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r6 = r6 | r2
            r7 = 0
            r2 = r1
            r1 = r19
            androidx.compose.material3.AlertDialogKt.BasicAlertDialog(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ed
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ed:
            r8 = r3
            r6 = r15
            r4 = r17
            r3 = r0
            r0 = r5
            r5 = r13
            goto L_0x012f
        L_0x01f6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x020c
            androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$2 r0 = new androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$2
            r1 = r19
            r2 = r20
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x020c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDialog_androidKt.m1982DatePickerDialogGmEhDVc(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, float, androidx.compose.material3.DatePickerColors, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 8;
        DialogButtonsPadding = PaddingKt.m772PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m7111constructorimpl((float) 6), Dp.m7111constructorimpl(f), 3, (Object) null);
        DialogButtonsMainAxisSpacing = Dp.m7111constructorimpl(f);
    }
}
