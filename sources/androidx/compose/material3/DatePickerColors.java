package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0002\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cø\u0001\u0000¢\u0006\u0004\b;\u0010<J-\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0001¢\u0006\u0004\bC\u0010DJ5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010E\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010F\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001a\u00020@2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010K\u001a\u00020LH\u0016J%\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bN\u0010OJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010P\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bQ\u0010DJ!\u0010R\u001a\u00020\u001c*\u0004\u0018\u00010\u001c2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001c0TH\u0000¢\u0006\u0002\bUR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b0\u0010\u001fR\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b1\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b3\u0010\u001fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b4\u0010\u001fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b5\u0010\u001fR\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b6\u0010\u001fR\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b7\u0010\u001fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b8\u0010\u001fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b9\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getCurrentYearContentColor-0d7_KjU", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "getDayContentColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "copy", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "dayContainerColor", "Landroidx/compose/runtime/State;", "selected", "", "enabled", "animate", "dayContainerColor$material3_release", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isToday", "inRange", "dayContentColor$material3_release", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "yearContainerColor", "yearContainerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3_release", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, textFieldColors);
    }

    private DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors) {
        this.containerColor = j;
        this.titleContentColor = j2;
        this.headlineContentColor = j3;
        this.weekdayContentColor = j4;
        this.subheadContentColor = j5;
        this.navigationContentColor = j6;
        this.yearContentColor = j7;
        this.disabledYearContentColor = j8;
        this.currentYearContentColor = j9;
        this.selectedYearContentColor = j10;
        this.disabledSelectedYearContentColor = j11;
        this.selectedYearContainerColor = j12;
        this.disabledSelectedYearContainerColor = j13;
        this.dayContentColor = j14;
        this.disabledDayContentColor = j15;
        this.selectedDayContentColor = j16;
        this.disabledSelectedDayContentColor = j17;
        this.selectedDayContainerColor = j18;
        this.disabledSelectedDayContainerColor = j19;
        this.todayContentColor = j20;
        this.todayDateBorderColor = j21;
        this.dayInSelectionRangeContainerColor = j22;
        this.dayInSelectionRangeContentColor = j23;
        this.dividerColor = j24;
        this.dateTextFieldColors = textFieldColors;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1954getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m1973getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* renamed from: getHeadlineContentColor-0d7_KjU  reason: not valid java name */
    public final long m1966getHeadlineContentColor0d7_KjU() {
        return this.headlineContentColor;
    }

    /* renamed from: getWeekdayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1976getWeekdayContentColor0d7_KjU() {
        return this.weekdayContentColor;
    }

    /* renamed from: getSubheadContentColor-0d7_KjU  reason: not valid java name */
    public final long m1972getSubheadContentColor0d7_KjU() {
        return this.subheadContentColor;
    }

    /* renamed from: getNavigationContentColor-0d7_KjU  reason: not valid java name */
    public final long m1967getNavigationContentColor0d7_KjU() {
        return this.navigationContentColor;
    }

    /* renamed from: getYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1977getYearContentColor0d7_KjU() {
        return this.yearContentColor;
    }

    /* renamed from: getDisabledYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1964getDisabledYearContentColor0d7_KjU() {
        return this.disabledYearContentColor;
    }

    /* renamed from: getCurrentYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1955getCurrentYearContentColor0d7_KjU() {
        return this.currentYearContentColor;
    }

    /* renamed from: getSelectedYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1971getSelectedYearContentColor0d7_KjU() {
        return this.selectedYearContentColor;
    }

    /* renamed from: getDisabledSelectedYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1963getDisabledSelectedYearContentColor0d7_KjU() {
        return this.disabledSelectedYearContentColor;
    }

    /* renamed from: getSelectedYearContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1970getSelectedYearContainerColor0d7_KjU() {
        return this.selectedYearContainerColor;
    }

    /* renamed from: getDisabledSelectedYearContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1962getDisabledSelectedYearContainerColor0d7_KjU() {
        return this.disabledSelectedYearContainerColor;
    }

    /* renamed from: getDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1956getDayContentColor0d7_KjU() {
        return this.dayContentColor;
    }

    /* renamed from: getDisabledDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1959getDisabledDayContentColor0d7_KjU() {
        return this.disabledDayContentColor;
    }

    /* renamed from: getSelectedDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1969getSelectedDayContentColor0d7_KjU() {
        return this.selectedDayContentColor;
    }

    /* renamed from: getDisabledSelectedDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1961getDisabledSelectedDayContentColor0d7_KjU() {
        return this.disabledSelectedDayContentColor;
    }

    /* renamed from: getSelectedDayContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1968getSelectedDayContainerColor0d7_KjU() {
        return this.selectedDayContainerColor;
    }

    /* renamed from: getDisabledSelectedDayContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1960getDisabledSelectedDayContainerColor0d7_KjU() {
        return this.disabledSelectedDayContainerColor;
    }

    /* renamed from: getTodayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1974getTodayContentColor0d7_KjU() {
        return this.todayContentColor;
    }

    /* renamed from: getTodayDateBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1975getTodayDateBorderColor0d7_KjU() {
        return this.todayDateBorderColor;
    }

    /* renamed from: getDayInSelectionRangeContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1957getDayInSelectionRangeContainerColor0d7_KjU() {
        return this.dayInSelectionRangeContainerColor;
    }

    /* renamed from: getDayInSelectionRangeContentColor-0d7_KjU  reason: not valid java name */
    public final long m1958getDayInSelectionRangeContentColor0d7_KjU() {
        return this.dayInSelectionRangeContentColor;
    }

    /* renamed from: getDividerColor-0d7_KjU  reason: not valid java name */
    public final long m1965getDividerColor0d7_KjU() {
        return this.dividerColor;
    }

    public final TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    /* renamed from: copy-tNwlRmA$default  reason: not valid java name */
    public static /* synthetic */ DatePickerColors m1952copytNwlRmA$default(DatePickerColors datePickerColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, int i, Object obj) {
        TextFieldColors textFieldColors2;
        DatePickerColors datePickerColors2 = datePickerColors;
        int i2 = i;
        long j25 = (i2 & 1) != 0 ? datePickerColors2.containerColor : j;
        long j26 = (i2 & 2) != 0 ? datePickerColors2.titleContentColor : j2;
        long j27 = (i2 & 4) != 0 ? datePickerColors2.headlineContentColor : j3;
        long j28 = (i2 & 8) != 0 ? datePickerColors2.weekdayContentColor : j4;
        long j29 = (i2 & 16) != 0 ? datePickerColors2.subheadContentColor : j5;
        long j30 = (i2 & 32) != 0 ? datePickerColors2.navigationContentColor : j6;
        long j31 = (i2 & 64) != 0 ? datePickerColors2.yearContentColor : j7;
        long j32 = j25;
        long j33 = (i2 & 128) != 0 ? datePickerColors2.disabledYearContentColor : j8;
        long j34 = (i2 & 256) != 0 ? datePickerColors2.currentYearContentColor : j9;
        long j35 = (i2 & 512) != 0 ? datePickerColors2.selectedYearContentColor : j10;
        long j36 = (i2 & 1024) != 0 ? datePickerColors2.disabledSelectedYearContentColor : j11;
        long j37 = (i2 & 2048) != 0 ? datePickerColors2.selectedYearContainerColor : j12;
        long j38 = (i2 & 4096) != 0 ? datePickerColors2.disabledSelectedYearContainerColor : j13;
        long j39 = (i2 & 8192) != 0 ? datePickerColors2.dayContentColor : j14;
        long j40 = (i2 & 16384) != 0 ? datePickerColors2.disabledDayContentColor : j15;
        long j41 = (i2 & 32768) != 0 ? datePickerColors2.selectedDayContentColor : j16;
        long j42 = (i & 65536) != 0 ? datePickerColors2.disabledSelectedDayContentColor : j17;
        long j43 = (i & 131072) != 0 ? datePickerColors2.selectedDayContainerColor : j18;
        long j44 = (i & 262144) != 0 ? datePickerColors2.disabledSelectedDayContainerColor : j19;
        long j45 = (i & 524288) != 0 ? datePickerColors2.todayContentColor : j20;
        long j46 = (i & 1048576) != 0 ? datePickerColors2.todayDateBorderColor : j21;
        long j47 = (i & 2097152) != 0 ? datePickerColors2.dayInSelectionRangeContainerColor : j22;
        long j48 = (i & 4194304) != 0 ? datePickerColors2.dayInSelectionRangeContentColor : j23;
        long j49 = (i & 8388608) != 0 ? datePickerColors2.dividerColor : j24;
        if ((i & 16777216) != 0) {
            textFieldColors2 = datePickerColors2.dateTextFieldColors;
        } else {
            textFieldColors2 = textFieldColors;
        }
        return datePickerColors2.m1953copytNwlRmA(j32, j26, j27, j28, j29, j30, j31, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, textFieldColors2);
    }

    /* renamed from: copy-tNwlRmA  reason: not valid java name */
    public final DatePickerColors m1953copytNwlRmA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors) {
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        long j32;
        long j33;
        long j34;
        long j35;
        long j36;
        long j37;
        long j38;
        long j39;
        long j40;
        long j41;
        long j42;
        long j43;
        long j44;
        long j45;
        long j46;
        long j47;
        long j48 = j != 16 ? j : this.containerColor;
        if (j2 != 16) {
            j25 = j2;
        } else {
            j25 = this.titleContentColor;
        }
        if (j3 != 16) {
            j26 = j3;
        } else {
            j26 = this.headlineContentColor;
        }
        if (j4 != 16) {
            j27 = j4;
        } else {
            j27 = this.weekdayContentColor;
        }
        if (j5 != 16) {
            j28 = j5;
        } else {
            j28 = this.subheadContentColor;
        }
        if (j6 != 16) {
            j29 = j6;
        } else {
            j29 = this.navigationContentColor;
        }
        if (j7 != 16) {
            j30 = j7;
        } else {
            j30 = this.yearContentColor;
        }
        if (j8 != 16) {
            j31 = j8;
        } else {
            j31 = this.disabledYearContentColor;
        }
        if (j9 != 16) {
            j32 = j9;
        } else {
            j32 = this.currentYearContentColor;
        }
        if (j10 != 16) {
            j33 = j10;
        } else {
            j33 = this.selectedYearContentColor;
        }
        if (j11 != 16) {
            j34 = j11;
        } else {
            j34 = this.disabledSelectedYearContentColor;
        }
        if (j12 != 16) {
            j35 = j12;
        } else {
            j35 = this.selectedYearContainerColor;
        }
        if (j13 != 16) {
            j36 = j13;
        } else {
            j36 = this.disabledSelectedYearContainerColor;
        }
        if (j14 != 16) {
            j37 = j14;
        } else {
            j37 = this.dayContentColor;
        }
        if (j15 != 16) {
            j38 = j15;
        } else {
            j38 = this.disabledDayContentColor;
        }
        if (j16 != 16) {
            j39 = j16;
        } else {
            j39 = this.selectedDayContentColor;
        }
        if (j17 != 16) {
            j40 = j17;
        } else {
            j40 = this.disabledSelectedDayContentColor;
        }
        if (j18 != 16) {
            j41 = j18;
        } else {
            j41 = this.selectedDayContainerColor;
        }
        if (j19 != 16) {
            j42 = j19;
        } else {
            j42 = this.disabledSelectedDayContainerColor;
        }
        if (j20 != 16) {
            j43 = j20;
        } else {
            j43 = this.todayContentColor;
        }
        if (j21 != 16) {
            j44 = j21;
        } else {
            j44 = this.todayDateBorderColor;
        }
        if (j22 != 16) {
            j45 = j22;
        } else {
            j45 = this.dayInSelectionRangeContainerColor;
        }
        if (j23 != 16) {
            j46 = j23;
        } else {
            j46 = this.dayInSelectionRangeContentColor;
        }
        if (j24 != 16) {
            j47 = j24;
        } else {
            j47 = this.dividerColor;
        }
        return new DatePickerColors(j48, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, takeOrElse$material3_release(textFieldColors, new DatePickerColors$copy$25(this)), (DefaultConstructorMarker) null);
    }

    public final TextFieldColors takeOrElse$material3_release(TextFieldColors textFieldColors, Function0<TextFieldColors> function0) {
        return textFieldColors == null ? function0.invoke() : textFieldColors;
    }

    public final State<Color> dayContentColor$material3_release(boolean z, boolean z2, boolean z3, boolean z4, Composer composer, int i) {
        long j;
        State<Color> state;
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1233694918, "C(dayContentColor)P(2,3,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233694918, i, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:897)");
        }
        if (z2 && z4) {
            j = this.selectedDayContentColor;
        } else if (z2 && !z4) {
            j = this.disabledSelectedDayContentColor;
        } else if (z3 && z4) {
            j = this.dayInSelectionRangeContentColor;
        } else if (z3 && !z4) {
            j = this.disabledDayContentColor;
        } else if (z) {
            j = this.todayContentColor;
        } else if (z4) {
            j = this.dayContentColor;
        } else {
            j = this.disabledDayContentColor;
        }
        long j2 = j;
        if (z3) {
            composer.startReplaceGroup(-828488761);
            ComposerKt.sourceInformation(composer, "910@44387L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4229boximpl(j2), composer, 0);
            composer.endReplaceGroup();
            composer2 = composer;
        } else {
            composer.startReplaceGroup(-828426947);
            ComposerKt.sourceInformation(composer, "913@44523L88");
            composer2 = composer;
            state = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return state;
    }

    public final State<Color> dayContainerColor$material3_release(boolean z, boolean z2, boolean z3, Composer composer, int i) {
        long j;
        State<Color> state;
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1240482658, "C(dayContainerColor)P(2,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1240482658, i, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:929)");
        }
        if (z) {
            j = z2 ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor;
        } else {
            j = Color.Companion.m4274getTransparent0d7_KjU();
        }
        long j2 = j;
        if (z3) {
            composer.startReplaceGroup(-217548653);
            ComposerKt.sourceInformation(composer, "937@45329L88");
            composer2 = composer;
            state = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-217433457);
            ComposerKt.sourceInformation(composer2, "939@45447L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4229boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return state;
    }

    public final State<Color> yearContentColor$material3_release(boolean z, boolean z2, boolean z3, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, 874111097, "C(yearContentColor)P(!1,2)965@46323L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(874111097, i, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:955)");
        }
        if (z2 && z3) {
            j = this.selectedYearContentColor;
        } else if (z2 && !z3) {
            j = this.disabledSelectedYearContentColor;
        } else if (z) {
            j = this.currentYearContentColor;
        } else if (z3) {
            j = this.yearContentColor;
        } else {
            j = this.disabledYearContentColor;
        }
        Composer composer2 = composer;
        State<Color> r9 = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r9;
    }

    public final State<Color> yearContainerColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, -1306331107, "C(yearContainerColor)P(1)985@47010L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1306331107, i, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:978)");
        }
        if (z) {
            j = z2 ? this.selectedYearContainerColor : this.disabledSelectedYearContainerColor;
        } else {
            j = Color.Companion.m4274getTransparent0d7_KjU();
        }
        Composer composer2 = composer;
        State<Color> r9 = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r9;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DatePickerColors)) {
            return false;
        }
        DatePickerColors datePickerColors = (DatePickerColors) obj;
        if (Color.m4240equalsimpl0(this.containerColor, datePickerColors.containerColor) && Color.m4240equalsimpl0(this.titleContentColor, datePickerColors.titleContentColor) && Color.m4240equalsimpl0(this.headlineContentColor, datePickerColors.headlineContentColor) && Color.m4240equalsimpl0(this.weekdayContentColor, datePickerColors.weekdayContentColor) && Color.m4240equalsimpl0(this.subheadContentColor, datePickerColors.subheadContentColor) && Color.m4240equalsimpl0(this.yearContentColor, datePickerColors.yearContentColor) && Color.m4240equalsimpl0(this.disabledYearContentColor, datePickerColors.disabledYearContentColor) && Color.m4240equalsimpl0(this.currentYearContentColor, datePickerColors.currentYearContentColor) && Color.m4240equalsimpl0(this.selectedYearContentColor, datePickerColors.selectedYearContentColor) && Color.m4240equalsimpl0(this.disabledSelectedYearContentColor, datePickerColors.disabledSelectedYearContentColor) && Color.m4240equalsimpl0(this.selectedYearContainerColor, datePickerColors.selectedYearContainerColor) && Color.m4240equalsimpl0(this.disabledSelectedYearContainerColor, datePickerColors.disabledSelectedYearContainerColor) && Color.m4240equalsimpl0(this.dayContentColor, datePickerColors.dayContentColor) && Color.m4240equalsimpl0(this.disabledDayContentColor, datePickerColors.disabledDayContentColor) && Color.m4240equalsimpl0(this.selectedDayContentColor, datePickerColors.selectedDayContentColor) && Color.m4240equalsimpl0(this.disabledSelectedDayContentColor, datePickerColors.disabledSelectedDayContentColor) && Color.m4240equalsimpl0(this.selectedDayContainerColor, datePickerColors.selectedDayContainerColor) && Color.m4240equalsimpl0(this.disabledSelectedDayContainerColor, datePickerColors.disabledSelectedDayContainerColor) && Color.m4240equalsimpl0(this.todayContentColor, datePickerColors.todayContentColor) && Color.m4240equalsimpl0(this.todayDateBorderColor, datePickerColors.todayDateBorderColor) && Color.m4240equalsimpl0(this.dayInSelectionRangeContainerColor, datePickerColors.dayInSelectionRangeContainerColor) && Color.m4240equalsimpl0(this.dayInSelectionRangeContentColor, datePickerColors.dayInSelectionRangeContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.m4246hashCodeimpl(this.containerColor) * 31) + Color.m4246hashCodeimpl(this.titleContentColor)) * 31) + Color.m4246hashCodeimpl(this.headlineContentColor)) * 31) + Color.m4246hashCodeimpl(this.weekdayContentColor)) * 31) + Color.m4246hashCodeimpl(this.subheadContentColor)) * 31) + Color.m4246hashCodeimpl(this.yearContentColor)) * 31) + Color.m4246hashCodeimpl(this.disabledYearContentColor)) * 31) + Color.m4246hashCodeimpl(this.currentYearContentColor)) * 31) + Color.m4246hashCodeimpl(this.selectedYearContentColor)) * 31) + Color.m4246hashCodeimpl(this.disabledSelectedYearContentColor)) * 31) + Color.m4246hashCodeimpl(this.selectedYearContainerColor)) * 31) + Color.m4246hashCodeimpl(this.disabledSelectedYearContainerColor)) * 31) + Color.m4246hashCodeimpl(this.dayContentColor)) * 31) + Color.m4246hashCodeimpl(this.disabledDayContentColor)) * 31) + Color.m4246hashCodeimpl(this.selectedDayContentColor)) * 31) + Color.m4246hashCodeimpl(this.disabledSelectedDayContentColor)) * 31) + Color.m4246hashCodeimpl(this.selectedDayContainerColor)) * 31) + Color.m4246hashCodeimpl(this.disabledSelectedDayContainerColor)) * 31) + Color.m4246hashCodeimpl(this.todayContentColor)) * 31) + Color.m4246hashCodeimpl(this.todayDateBorderColor)) * 31) + Color.m4246hashCodeimpl(this.dayInSelectionRangeContainerColor)) * 31) + Color.m4246hashCodeimpl(this.dayInSelectionRangeContentColor);
    }
}
