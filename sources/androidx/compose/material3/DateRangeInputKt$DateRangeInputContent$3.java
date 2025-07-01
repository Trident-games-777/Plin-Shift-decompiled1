package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
final class DateRangeInputKt$DateRangeInputContent$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangeInputKt$DateRangeInputContent$3(Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i) {
        super(2);
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$onDatesSelectionChange = function2;
        this.$calendarModel = calendarModel;
        this.$yearRange = intRange;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DateRangeInputKt.DateRangeInputContent(this.$selectedStartDateMillis, this.$selectedEndDateMillis, this.$onDatesSelectionChange, this.$calendarModel, this.$yearRange, this.$dateFormatter, this.$selectableDates, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
