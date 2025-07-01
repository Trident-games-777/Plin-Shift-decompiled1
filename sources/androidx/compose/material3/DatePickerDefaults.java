package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(J$\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010-J\u0002\u0010,\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u00020/2\b\b\u0002\u00104\u001a\u00020/2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020/2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ$\u0010#\u001a\u00020$2\b\b\u0002\u0010K\u001a\u00020\r2\b\b\u0002\u0010L\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020\rJ'\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0001¢\u0006\u0004\bU\u0010VR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8AX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "DatePickerHeadline", "", "selectedDateMillis", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DatePickerHeadline-3kbWawI", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "DatePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "yearSelectionSkeleton", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerDefaults {
    public static final int $stable = 0;
    private static final SelectableDates AllDates = new DatePickerDefaults$AllDates$1();
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m3195getLevel0D9Ej5fM();
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    private static final IntRange YearRange = new IntRange(1900, 2100);

    private DatePickerDefaults() {
    }

    public final DatePickerColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -275219611, "C(colors)428@18618L11,428@18630L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, i, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:428)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColors;
    }

    /* renamed from: colors-bSRYm20  reason: not valid java name */
    public final DatePickerColors m1980colorsbSRYm20(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, Composer composer, int i, int i2, int i3, int i4) {
        Composer composer2 = composer;
        int i5 = i4;
        ComposerKt.sourceInformationMarkerStart(composer2, 1991626358, "C(colors)P(0:c#ui.graphics.Color,20:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,19:c#ui.graphics.Color,14:c#ui.graphics.Color,24:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,18:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,21:c#ui.graphics.Color,22:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color)497@22914L11,497@22926L23:DatePicker.kt#uh7d8r");
        long r7 = (i5 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i5 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r11 = (i5 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i5 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r15 = (i5 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r17 = (i5 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r19 = (i5 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        long r21 = (i5 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j8;
        long r23 = (i5 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j9;
        long r25 = (i5 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j10;
        long r27 = (i5 & 1024) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j11;
        long r29 = (i5 & 2048) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j12;
        long r31 = (i5 & 4096) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j13;
        long r33 = (i5 & 8192) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j14;
        long r35 = (i5 & 16384) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j15;
        long r37 = (32768 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j16;
        long r39 = (65536 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j17;
        long r41 = (131072 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j18;
        long r43 = (262144 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j19;
        long r45 = (524288 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j20;
        long r47 = (1048576 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j21;
        long r51 = (2097152 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j22;
        long r49 = (4194304 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j23;
        long r53 = (8388608 & i5) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j24;
        TextFieldColors textFieldColors2 = (i5 & 16777216) != 0 ? null : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991626358, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:497)");
        }
        DatePickerColors r1 = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), composer2, (i3 >> 12) & 112).m1953copytNwlRmA(r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, textFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme colorScheme, Composer composer, int i) {
        ColorScheme colorScheme2 = colorScheme;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 1180555308, "C:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, i2, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:527)");
        }
        DatePickerColors defaultDatePickerColorsCached$material3_release = colorScheme2.getDefaultDatePickerColorsCached$material3_release();
        composer2.startReplaceGroup(-653687021);
        ComposerKt.sourceInformation(composer2, "*585@28652L30");
        if (defaultDatePickerColorsCached$material3_release == null) {
            DatePickerColors datePickerColors = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), colorScheme2.m1862getOnSurfaceVariant0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme2, composer2, (i2 & 14) | 48), (DefaultConstructorMarker) null);
            colorScheme2.setDefaultDatePickerColorsCached$material3_release(datePickerColors);
            defaultDatePickerColorsCached$material3_release = datePickerColors;
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return defaultDatePickerColorsCached$material3_release;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    public final DatePickerFormatter dateFormatter(String str, String str2, String str3) {
        return new DatePickerFormatterImpl(str, str2, str3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* renamed from: DatePickerTitle-hOD91z4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1979DatePickerTitlehOD91z4(int r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r28 = this;
            r2 = r29
            r0 = 327413563(0x1383ef3b, float:3.330495E-27)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(DatePickerTitle)P(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r"
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
            java.lang.String r6 = "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:625)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r6)
        L_0x006d:
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m2031getPickerjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r2, r0)
            r5 = 0
            if (r0 == 0) goto L_0x00bd
            r0 = 406433164(0x1839ad8c, float:2.3998308E-24)
            r1.startReplaceGroup(r0)
            java.lang.String r0 = "628@30634L43,628@30622L77"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.material3.internal.Strings$Companion r0 = androidx.compose.material3.internal.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_picker_title
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
            r1 = 406437227(0x1839bd6b, float:2.4006321E-24)
            r0.startReplaceGroup(r1)
            java.lang.String r1 = "630@30761L42,630@30749L76"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.material3.internal.Strings$Companion r1 = androidx.compose.material3.internal.Strings.Companion
            int r1 = androidx.compose.material3.R.string.m3c_date_input_title
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
            r1 = -285264893(0xffffffffeeff3403, float:-3.9490778E28)
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
            androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1 r0 = new androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1
            r1 = r28
            r4 = r32
            r5 = r33
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.m1979DatePickerTitlehOD91z4(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* renamed from: DatePickerHeadline-3kbWawI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1978DatePickerHeadline3kbWawI(java.lang.Long r34, int r35, androidx.compose.material3.DatePickerFormatter r36, androidx.compose.ui.Modifier r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r33 = this;
            r1 = r34
            r6 = r35
            r0 = r36
            r7 = r39
            r2 = 1502835813(0x59937465, float:5.1880998E15)
            r3 = r38
            androidx.compose.runtime.Composer r8 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(DatePickerHeadline)P(3,1:c#material3.DisplayMode)651@31604L15,684@32955L135,681@32858L268:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            r3 = r40 & 1
            if (r3 == 0) goto L_0x001d
            r3 = r7 | 6
            goto L_0x002d
        L_0x001d:
            r3 = r7 & 6
            if (r3 != 0) goto L_0x002c
            boolean r3 = r8.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r7
            goto L_0x002d
        L_0x002c:
            r3 = r7
        L_0x002d:
            r4 = r40 & 2
            if (r4 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0044
        L_0x0034:
            r4 = r7 & 48
            if (r4 != 0) goto L_0x0044
            boolean r4 = r8.changed((int) r6)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r3 = r3 | r4
        L_0x0044:
            r4 = r40 & 4
            if (r4 == 0) goto L_0x004b
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x004b:
            r4 = r7 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0064
            r4 = r7 & 512(0x200, float:7.175E-43)
            if (r4 != 0) goto L_0x0058
            boolean r4 = r8.changed((java.lang.Object) r0)
            goto L_0x005c
        L_0x0058:
            boolean r4 = r8.changedInstance(r0)
        L_0x005c:
            if (r4 == 0) goto L_0x0061
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r3 = r3 | r4
        L_0x0064:
            r4 = r40 & 8
            if (r4 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r7 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r37
            boolean r9 = r8.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r9
            goto L_0x0080
        L_0x007e:
            r5 = r37
        L_0x0080:
            r9 = r3 & 1171(0x493, float:1.641E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x0094
            boolean r9 = r8.getSkipping()
            if (r9 != 0) goto L_0x008d
            goto L_0x0094
        L_0x008d:
            r8.skipToGroupEnd()
            r29 = r8
            goto L_0x0254
        L_0x0094:
            if (r4 == 0) goto L_0x009c
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r9 = r4
            goto L_0x009d
        L_0x009c:
            r9 = r5
        L_0x009d:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00a9
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:650)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r4, r5)
        L_0x00a9:
            r10 = 0
            java.util.Locale r2 = androidx.compose.material3.CalendarLocale_androidKt.defaultLocale(r8, r10)
            r4 = 4
            r5 = 0
            r3 = 0
            java.lang.String r3 = androidx.compose.material3.DatePickerFormatter.formatDate$default(r0, r1, r2, r3, r4, r5)
            r4 = 1
            java.lang.String r2 = r0.formatDate(r1, r2, r4)
            r5 = 1148829161(0x4479bde9, float:998.96735)
            r8.startReplaceGroup(r5)
            java.lang.String r5 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            if (r2 != 0) goto L_0x011f
            androidx.compose.material3.DisplayMode$Companion r2 = androidx.compose.material3.DisplayMode.Companion
            int r2 = r2.m2031getPickerjFl4v0()
            boolean r2 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r6, r2)
            if (r2 == 0) goto L_0x00ee
            r2 = 1148836960(0x4479dc60, float:999.44336)
            r8.startReplaceGroup(r2)
            java.lang.String r2 = "661@32047L51"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            androidx.compose.material3.internal.Strings$Companion r2 = androidx.compose.material3.internal.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_picker_no_selection_description
            int r2 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r2)
            java.lang.String r2 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r2, r8, r10)
            r8.endReplaceGroup()
            goto L_0x011f
        L_0x00ee:
            androidx.compose.material3.DisplayMode$Companion r2 = androidx.compose.material3.DisplayMode.Companion
            int r2 = r2.m2030getInputjFl4v0()
            boolean r2 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r6, r2)
            if (r2 == 0) goto L_0x0115
            r2 = 1148839931(0x4479e7fb, float:999.6247)
            r8.startReplaceGroup(r2)
            java.lang.String r2 = "662@32140L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            androidx.compose.material3.internal.Strings$Companion r2 = androidx.compose.material3.internal.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_input_no_input_description
            int r2 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r2)
            java.lang.String r2 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r2, r8, r10)
            r8.endReplaceGroup()
            goto L_0x011f
        L_0x0115:
            r2 = 1254372529(0x4ac434b1, float:6429272.5)
            r8.startReplaceGroup(r2)
            r8.endReplaceGroup()
            r2 = r5
        L_0x011f:
            r8.endReplaceGroup()
            r11 = 1148844497(0x4479f9d1, float:999.9034)
            r8.startReplaceGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            if (r3 != 0) goto L_0x0185
            androidx.compose.material3.DisplayMode$Companion r3 = androidx.compose.material3.DisplayMode.Companion
            int r3 = r3.m2031getPickerjFl4v0()
            boolean r3 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r6, r3)
            if (r3 == 0) goto L_0x0154
            r3 = 1148847346(0x447a04f2, float:1000.0773)
            r8.startReplaceGroup(r3)
            java.lang.String r3 = "669@32372L37"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            androidx.compose.material3.internal.Strings$Companion r3 = androidx.compose.material3.internal.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_date_picker_headline
            int r3 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r3)
            java.lang.String r3 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r3, r8, r10)
            r8.endReplaceGroup()
            goto L_0x0185
        L_0x0154:
            androidx.compose.material3.DisplayMode$Companion r3 = androidx.compose.material3.DisplayMode.Companion
            int r3 = r3.m2030getInputjFl4v0()
            boolean r3 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r6, r3)
            if (r3 == 0) goto L_0x017b
            r3 = 1148849873(0x447a0ed1, float:1000.2315)
            r8.startReplaceGroup(r3)
            java.lang.String r3 = "670@32451L36"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            androidx.compose.material3.internal.Strings$Companion r3 = androidx.compose.material3.internal.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_date_input_headline
            int r3 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r3)
            java.lang.String r3 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r3, r8, r10)
            r8.endReplaceGroup()
            goto L_0x0185
        L_0x017b:
            r3 = 1254671121(0x4ac8c311, float:6578568.5)
            r8.startReplaceGroup(r3)
            r8.endReplaceGroup()
            r3 = r5
        L_0x0185:
            r8.endReplaceGroup()
            androidx.compose.material3.DisplayMode$Companion r11 = androidx.compose.material3.DisplayMode.Companion
            int r11 = r11.m2031getPickerjFl4v0()
            boolean r11 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r6, r11)
            if (r11 == 0) goto L_0x01af
            r5 = 1148856029(0x447a26dd, float:1000.60724)
            r8.startReplaceGroup(r5)
            java.lang.String r5 = "676@32643L48"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            androidx.compose.material3.internal.Strings$Companion r5 = androidx.compose.material3.internal.Strings.Companion
            int r5 = androidx.compose.material3.R.string.m3c_date_picker_headline_description
            int r5 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r5)
            java.lang.String r5 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r5, r8, r10)
            r8.endReplaceGroup()
            goto L_0x01df
        L_0x01af:
            androidx.compose.material3.DisplayMode$Companion r11 = androidx.compose.material3.DisplayMode.Companion
            int r11 = r11.m2030getInputjFl4v0()
            boolean r11 = androidx.compose.material3.DisplayMode.m2026equalsimpl0(r6, r11)
            if (r11 == 0) goto L_0x01d6
            r5 = 1148858780(0x447a319c, float:1000.77515)
            r8.startReplaceGroup(r5)
            java.lang.String r5 = "677@32729L47"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            androidx.compose.material3.internal.Strings$Companion r5 = androidx.compose.material3.internal.Strings.Companion
            int r5 = androidx.compose.material3.R.string.m3c_date_input_headline_description
            int r5 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r5)
            java.lang.String r5 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r5, r8, r10)
            r8.endReplaceGroup()
            goto L_0x01df
        L_0x01d6:
            r11 = 1254953841(0x4acd1371, float:6719928.5)
            r8.startReplaceGroup(r11)
            r8.endReplaceGroup()
        L_0x01df:
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            java.lang.String r2 = java.lang.String.format(r5, r2)
            java.lang.String r5 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r5 = 1148866100(0x447a4e34, float:1001.2219)
            java.lang.String r11 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r5, r11)
            boolean r5 = r8.changed((java.lang.Object) r2)
            java.lang.Object r11 = r8.rememberedValue()
            if (r5 != 0) goto L_0x020a
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r11 != r5) goto L_0x0215
        L_0x020a:
            androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1 r5 = new androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1
            r5.<init>(r2)
            r11 = r5
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r8.updateRememberedValue(r11)
        L_0x0215:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r2 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r9, r10, r11, r4, r2)
            r31 = 3072(0xc00, float:4.305E-42)
            r32 = 122876(0x1dffc, float:1.72186E-40)
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 1
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r29 = r8
            r4 = r9
            r9 = r2
            r8 = r3
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (long) r12, (androidx.compose.ui.text.font.FontStyle) r14, (androidx.compose.ui.text.font.FontWeight) r15, (androidx.compose.ui.text.font.FontFamily) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.text.style.TextAlign) r20, (long) r21, (int) r23, (boolean) r24, (int) r25, (int) r26, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r27, (androidx.compose.ui.text.TextStyle) r28, (androidx.compose.runtime.Composer) r29, (int) r30, (int) r31, (int) r32)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0253
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0253:
            r5 = r4
        L_0x0254:
            androidx.compose.runtime.ScopeUpdateScope r8 = r29.endRestartGroup()
            if (r8 == 0) goto L_0x026d
            androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2 r0 = new androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2
            r4 = r36
            r2 = r1
            r3 = r6
            r6 = r7
            r1 = r33
            r7 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x026d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.m1978DatePickerHeadline3kbWawI(java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2036003494, "C(rememberSnapFlingBehavior)P(1)704@33614L669:DatePicker.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:703)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2078670519, "CC(remember):DatePicker.kt#9igjgp");
        boolean changed = ((((i & 14) ^ 6) > 4 && composer.changed((Object) lazyListState)) || (i & 6) == 4) | composer.changed((Object) decayAnimationSpec);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapFlingBehaviorKt.snapFlingBehavior(new DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1(LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(lazyListState, (SnapPosition) null, 2, (Object) null)), decayAnimationSpec, AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null));
            composer.updateRememberedValue(rememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return targetedFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m1981getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 700927667, "C730@34663L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:730)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }
}
