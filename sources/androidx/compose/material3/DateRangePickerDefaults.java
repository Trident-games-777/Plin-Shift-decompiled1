package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DateRangePickerHeadline-v84Udv0", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "DateRangePickerHeadline-0YIUgSQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerTitle", "DateRangePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* renamed from: DateRangePickerTitle-hOD91z4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2001DateRangePickerTitlehOD91z4(int r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r28 = this;
            r2 = r29
            r0 = -1412719908(0xffffffffabcb9adc, float:-1.4467E-12)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(DateRangePickerTitle)P(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r33 & 1
            if (r3 == 0) goto L_0x0017
            r3 = r32 | 6
            goto L_0x0029
        L_0x0017:
            r3 = r32 & 6
            if (r3 != 0) goto L_0x0027
            boolean r3 = r1.changed((int) r2)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r32 | r3
            goto L_0x0029
        L_0x0027:
            r3 = r32
        L_0x0029:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r32 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r30
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r30
        L_0x0045:
            r6 = r3 & 19
            r7 = 18
            if (r6 != r7) goto L_0x0059
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x0052
            goto L_0x0059
        L_0x0052:
            r1.skipToGroupEnd()
            r0 = r1
            r3 = r5
            goto L_0x011e
        L_0x0059:
            if (r4 == 0) goto L_0x0060
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0061
        L_0x0060:
            r4 = r5
        L_0x0061:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x006d
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:334)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r6)
        L_0x006d:
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m2031getPickerjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r2, r0)
            r5 = 0
            if (r0 == 0) goto L_0x00bd
            r0 = 980462952(0x3a70ad68, float:9.181113E-4)
            r1.startReplaceGroup(r0)
            java.lang.String r0 = "337@15482L48,337@15477L75"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.material3.internal.Strings$Companion r0 = androidx.compose.material3.internal.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_picker_title
            int r0 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r0)
            java.lang.String r0 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r0, r1, r5)
            r25 = r3 & 112(0x70, float:1.57E-43)
            r26 = 0
            r27 = 131068(0x1fffc, float:1.83665E-40)
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r3 = r0
            r24 = r1
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (long) r5, (long) r7, (androidx.compose.ui.text.font.FontStyle) r9, (androidx.compose.ui.text.font.FontWeight) r10, (androidx.compose.ui.text.font.FontFamily) r11, (long) r12, (androidx.compose.ui.text.style.TextDecoration) r14, (androidx.compose.ui.text.style.TextAlign) r15, (long) r16, (int) r18, (boolean) r19, (int) r20, (int) r21, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r22, (androidx.compose.ui.text.TextStyle) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            r0 = r24
            r0.endReplaceGroup()
            goto L_0x0114
        L_0x00bd:
            r0 = r1
            androidx.compose.material3.DisplayMode$Companion r1 = androidx.compose.material3.DisplayMode.Companion
            int r1 = r1.m2030getInputjFl4v0()
            boolean r1 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r2, r1)
            if (r1 == 0) goto L_0x010b
            r1 = 980466951(0x3a70bd07, float:9.1834407E-4)
            r0.startReplaceGroup(r1)
            java.lang.String r1 = "339@15607L47,339@15602L74"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.material3.internal.Strings$Companion r1 = androidx.compose.material3.internal.Strings.Companion
            int r1 = androidx.compose.material3.R.string.m3c_date_range_input_title
            int r1 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r1)
            java.lang.String r1 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r1, r0, r5)
            r25 = r3 & 112(0x70, float:1.57E-43)
            r26 = 0
            r27 = 131068(0x1fffc, float:1.83665E-40)
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = r0
            r3 = r1
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (long) r5, (long) r7, (androidx.compose.ui.text.font.FontStyle) r9, (androidx.compose.ui.text.font.FontWeight) r10, (androidx.compose.ui.text.font.FontFamily) r11, (long) r12, (androidx.compose.ui.text.style.TextDecoration) r14, (androidx.compose.ui.text.style.TextAlign) r15, (long) r16, (int) r18, (boolean) r19, (int) r20, (int) r21, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r22, (androidx.compose.ui.text.TextStyle) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            r0.endReplaceGroup()
            goto L_0x0114
        L_0x010b:
            r1 = 329785445(0x13a82065, float:4.2441106E-27)
            r0.startReplaceGroup(r1)
            r0.endReplaceGroup()
        L_0x0114:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x011d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x011d:
            r3 = r4
        L_0x011e:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 == 0) goto L_0x0134
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1 r0 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1
            r1 = r28
            r4 = r32
            r5 = r33
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.m2001DateRangePickerTitlehOD91z4(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* renamed from: DateRangePickerHeadline-v84Udv0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2000DateRangePickerHeadlinev84Udv0(java.lang.Long r18, java.lang.Long r19, int r20, androidx.compose.material3.DatePickerFormatter r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r17 = this;
            r4 = r21
            r14 = r24
            r0 = -1611069472(0xffffffff9ff907e0, float:-1.0546863E-19)
            r1 = r23
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DateRangePickerHeadline)P(4,3,1:c#material3.DisplayMode)363@16696L47,364@16770L45,373@17203L30,374@17268L28,365@16824L534:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r25 & 1
            if (r1 == 0) goto L_0x001c
            r1 = r14 | 6
            r2 = r1
            r1 = r18
            goto L_0x0030
        L_0x001c:
            r1 = r14 & 6
            if (r1 != 0) goto L_0x002d
            r1 = r18
            boolean r2 = r11.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r14
            goto L_0x0030
        L_0x002d:
            r1 = r18
            r2 = r14
        L_0x0030:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x004a
            r3 = r19
            boolean r5 = r11.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r2 = r2 | r5
            goto L_0x004c
        L_0x004a:
            r3 = r19
        L_0x004c:
            r5 = r25 & 4
            if (r5 == 0) goto L_0x0053
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0066
            r5 = r20
            boolean r6 = r11.changed((int) r5)
            if (r6 == 0) goto L_0x0062
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r6
            goto L_0x0068
        L_0x0066:
            r5 = r20
        L_0x0068:
            r6 = r25 & 8
            if (r6 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x006f:
            r6 = r14 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0088
            r6 = r14 & 4096(0x1000, float:5.74E-42)
            if (r6 != 0) goto L_0x007c
            boolean r6 = r11.changed((java.lang.Object) r4)
            goto L_0x0080
        L_0x007c:
            boolean r6 = r11.changedInstance(r4)
        L_0x0080:
            if (r6 == 0) goto L_0x0085
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r2 = r2 | r6
        L_0x0088:
            r6 = r25 & 16
            if (r6 == 0) goto L_0x008f
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008f:
            r7 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a2
            r7 = r22
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009e
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r2 = r2 | r8
            goto L_0x00a4
        L_0x00a2:
            r7 = r22
        L_0x00a4:
            r8 = r25 & 32
            r9 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00ac
            r2 = r2 | r9
            goto L_0x00bf
        L_0x00ac:
            r8 = r14 & r9
            if (r8 != 0) goto L_0x00bf
            r8 = r17
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00bb
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r2 = r2 | r9
            goto L_0x00c1
        L_0x00bf:
            r8 = r17
        L_0x00c1:
            r9 = 74899(0x12493, float:1.04956E-40)
            r9 = r9 & r2
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r9 != r10) goto L_0x00d7
            boolean r9 = r11.getSkipping()
            if (r9 != 0) goto L_0x00d1
            goto L_0x00d7
        L_0x00d1:
            r11.skipToGroupEnd()
            r6 = r7
            goto L_0x015a
        L_0x00d7:
            if (r6 == 0) goto L_0x00de
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r7 = r6
        L_0x00de:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00ea
            r6 = -1
            java.lang.String r9 = "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:362)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r6, r9)
        L_0x00ea:
            androidx.compose.material3.internal.Strings$Companion r0 = androidx.compose.material3.internal.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_picker_start_headline
            int r0 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r0)
            r6 = 0
            java.lang.String r0 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r0, r11, r6)
            androidx.compose.material3.internal.Strings$Companion r9 = androidx.compose.material3.internal.Strings.Companion
            int r9 = androidx.compose.material3.R.string.m3c_date_range_picker_end_headline
            int r9 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r9)
            java.lang.String r6 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r9, r11, r6)
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1 r9 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
            r9.<init>(r0)
            r10 = 482821121(0x1cc74401, float:1.3186294E-21)
            r12 = 1
            r13 = 54
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r12, r9, r11, r13)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2 r10 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
            r10.<init>(r6)
            r15 = -1522669758(0xffffffffa53de742, float:-1.647149E-16)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r12, r10, r11, r13)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            androidx.compose.material3.ComposableSingletons$DateRangePickerKt r12 = androidx.compose.material3.ComposableSingletons$DateRangePickerKt.INSTANCE
            kotlin.jvm.functions.Function2 r12 = r12.m1922getLambda1$material3_release()
            r13 = r2 & 14
            r15 = 918552576(0x36c00000, float:5.722046E-6)
            r13 = r13 | r15
            r15 = r2 & 112(0x70, float:1.57E-43)
            r13 = r13 | r15
            r15 = r2 & 896(0x380, float:1.256E-42)
            r13 = r13 | r15
            r15 = r2 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r2
            r13 = r13 | r15
            int r2 = r2 >> 15
            r2 = r2 & 14
            r16 = r6
            r6 = r0
            r0 = r8
            r8 = r9
            r9 = r10
            r10 = r12
            r12 = r13
            r13 = r2
            r2 = r3
            r3 = r5
            r5 = r7
            r7 = r16
            r0.m1998DateRangePickerHeadline0YIUgSQ(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0159
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0159:
            r6 = r5
        L_0x015a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r11.endRestartGroup()
            if (r9 == 0) goto L_0x0177
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3 r0 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r8 = r25
            r7 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.m2000DateRangePickerHeadlinev84Udv0(java.lang.Long, java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DateRangePickerHeadline-0YIUgSQ  reason: not valid java name */
    public final void m1998DateRangePickerHeadline0YIUgSQ(Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2, int i3) {
        int i4;
        Long l3;
        Composer composer2;
        String str3;
        Long l4 = l;
        Long l5 = l2;
        int i5 = i;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        Modifier modifier2 = modifier;
        String str4 = str;
        String str5 = str2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        int i6 = i2;
        int i7 = i3;
        Composer startRestartGroup = composer.startRestartGroup(-820363420);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerHeadline)P(7,6,2:c#material3.DisplayMode!1,5,9,4,8,3)416@19379L15,452@20912L168,450@20838L748:DateRangePicker.kt#uh7d8r");
        if ((i6 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) l4) ? 4 : 2) | i6;
        } else {
            i4 = i6;
        }
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) l5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i4 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i4 |= (i6 & 4096) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i4 |= startRestartGroup.changed((Object) modifier2) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) str4) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) str5) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((100663296 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function25) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function26) ? 536870912 : 268435456;
        }
        if ((306783379 & i4) == 306783378 && (i7 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            l3 = l4;
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820363420, i4, i7, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:415)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(startRestartGroup, 0);
            int i8 = i4;
            composer2 = startRestartGroup;
            String formatDate$default = DatePickerFormatter.formatDate$default(datePickerFormatter2, l, defaultLocale, false, 4, (Object) null);
            l3 = l;
            Long l6 = l2;
            DatePickerFormatter datePickerFormatter3 = datePickerFormatter;
            String formatDate$default2 = DatePickerFormatter.formatDate$default(datePickerFormatter3, l6, defaultLocale, false, 4, (Object) null);
            String formatDate = datePickerFormatter3.formatDate(l3, defaultLocale, true);
            composer2.startReplaceGroup(1063152176);
            String str6 = "";
            ComposerKt.sourceInformation(composer2, str6);
            if (formatDate != null) {
                str3 = formatDate$default2;
            } else if (DisplayMode.m2026equalsimpl0(i5, DisplayMode.Companion.m2031getPickerjFl4v0())) {
                composer2.startReplaceGroup(1063160130);
                ComposerKt.sourceInformation(composer2, "430@19972L51");
                Strings.Companion companion = Strings.Companion;
                str3 = formatDate$default2;
                formatDate = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_picker_no_selection_description), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                str3 = formatDate$default2;
                if (DisplayMode.m2026equalsimpl0(i5, DisplayMode.Companion.m2030getInputjFl4v0())) {
                    composer2.startReplaceGroup(1063163101);
                    ComposerKt.sourceInformation(composer2, "431@20065L46");
                    Strings.Companion companion2 = Strings.Companion;
                    String r3 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_no_input_description), composer2, 0);
                    composer2.endReplaceGroup();
                    formatDate = r3;
                } else {
                    composer2.startReplaceGroup(-1401609201);
                    composer2.endReplaceGroup();
                    formatDate = str6;
                }
            }
            composer2.endReplaceGroup();
            String formatDate2 = datePickerFormatter3.formatDate(l6, defaultLocale, true);
            composer2.startReplaceGroup(1063168270);
            ComposerKt.sourceInformation(composer2, str6);
            if (formatDate2 != null) {
                str6 = formatDate2;
            } else if (DisplayMode.m2026equalsimpl0(i5, DisplayMode.Companion.m2031getPickerjFl4v0())) {
                composer2.startReplaceGroup(1063176162);
                ComposerKt.sourceInformation(composer2, "442@20473L51");
                Strings.Companion companion3 = Strings.Companion;
                str6 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_picker_no_selection_description), composer2, 0);
                composer2.endReplaceGroup();
            } else if (DisplayMode.m2026equalsimpl0(i5, DisplayMode.Companion.m2030getInputjFl4v0())) {
                composer2.startReplaceGroup(1063179133);
                ComposerKt.sourceInformation(composer2, "443@20566L46");
                Strings.Companion companion4 = Strings.Companion;
                str6 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_no_input_description), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1401112209);
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
            String str7 = str4 + ": " + formatDate;
            String str8 = str5 + ": " + str6;
            ComposerKt.sourceInformationMarkerStart(composer2, 1063190327, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = composer2.changed((Object) str7) | composer2.changed((Object) str8);
            Object rememberedValue = composer2.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateRangePickerDefaults$DateRangePickerHeadline$4$1(str7, str8);
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier2, (Function1) rememberedValue);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical r4 = Arrangement.INSTANCE.m623spacedBy0680j_4(Dp.m7111constructorimpl((float) 4));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(r4, centerVertically, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i9 = currentCompositeKeyHash;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r1 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r1, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(i9))) {
                r1.updateRememberedValue(Integer.valueOf(i9));
                r1.apply(Integer.valueOf(i9), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r1, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 303323611, "C464@21398L16:DateRangePicker.kt#uh7d8r");
            if (formatDate$default != null) {
                composer2.startReplaceGroup(303346581);
                ComposerKt.sourceInformation(composer2, "460@21280L31");
                TextKt.m2692Text4IGK_g(formatDate$default, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(303414750);
                ComposerKt.sourceInformation(composer2, "462@21349L22");
                function24.invoke(composer2, Integer.valueOf((i8 >> 21) & 14));
                composer2.endReplaceGroup();
            }
            function26.invoke(composer2, Integer.valueOf((i8 >> 27) & 14));
            if (str3 != null) {
                composer2.startReplaceGroup(303539959);
                ComposerKt.sourceInformation(composer2, "466@21475L29");
                TextKt.m2692Text4IGK_g(str3, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(303606144);
                ComposerKt.sourceInformation(composer2, "468@21542L20");
                function25.invoke(composer2, Integer.valueOf((i8 >> 24) & 14));
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerDefaults$DateRangePickerHeadline$6(this, l3, l2, i5, datePickerFormatter, modifier2, str4, str5, function24, function25, function26, i2, i7));
        }
    }
}
