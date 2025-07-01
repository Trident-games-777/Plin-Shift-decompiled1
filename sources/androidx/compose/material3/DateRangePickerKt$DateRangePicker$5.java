package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$DateRangePicker$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePicker$5(DateRangePickerState dateRangePickerState, CalendarModel calendarModel, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors) {
        super(2);
        this.$state = dateRangePickerState;
        this.$calendarModel = calendarModel;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r13 = r17
            r1 = r18
            java.lang.String r2 = "C142@6428L467,153@6934L91,137@6121L1123:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001b
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            r13.skipToGroupEnd()
            return
        L_0x001b:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002a
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:137)"
            r4 = -57534331(0xfffffffffc921885, float:-6.068581E36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002a:
            androidx.compose.material3.DateRangePickerState r1 = r0.$state
            java.lang.Long r1 = r1.getSelectedStartDateMillis()
            androidx.compose.material3.DateRangePickerState r2 = r0.$state
            java.lang.Long r2 = r2.getSelectedEndDateMillis()
            androidx.compose.material3.DateRangePickerState r3 = r0.$state
            long r3 = r3.getDisplayedMonthMillis()
            androidx.compose.material3.DateRangePickerState r5 = r0.$state
            int r5 = r5.m2010getDisplayModejFl4v0()
            r6 = 1752274220(0x6871952c, float:4.5633682E24)
            java.lang.String r7 = "CC(remember):DateRangePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            androidx.compose.material3.DateRangePickerState r6 = r0.$state
            boolean r6 = r13.changed((java.lang.Object) r6)
            androidx.compose.material3.DateRangePickerState r8 = r0.$state
            java.lang.Object r9 = r13.rememberedValue()
            if (r6 != 0) goto L_0x0060
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r9 != r6) goto L_0x006b
        L_0x0060:
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1 r6 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
            r6.<init>(r8)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r13.updateRememberedValue(r9)
        L_0x006b:
            r6 = r9
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r8 = 1752290036(0x6871d2f4, float:4.567927E24)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r7)
            androidx.compose.material3.DateRangePickerState r7 = r0.$state
            boolean r7 = r13.changed((java.lang.Object) r7)
            androidx.compose.material3.DateRangePickerState r8 = r0.$state
            java.lang.Object r9 = r13.rememberedValue()
            if (r7 != 0) goto L_0x008d
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0098
        L_0x008d:
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1 r7 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
            r7.<init>(r8)
            r9 = r7
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r13.updateRememberedValue(r9)
        L_0x0098:
            r7 = r9
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.material3.internal.CalendarModel r8 = r0.$calendarModel
            androidx.compose.material3.DateRangePickerState r9 = r0.$state
            kotlin.ranges.IntRange r9 = r9.getYearRange()
            androidx.compose.material3.DatePickerFormatter r10 = r0.$dateFormatter
            androidx.compose.material3.DateRangePickerState r11 = r0.$state
            androidx.compose.material3.SelectableDates r11 = r11.getSelectableDates()
            androidx.compose.material3.DatePickerColors r12 = r0.$colors
            r14 = 0
            r15 = 0
            androidx.compose.material3.DateRangePickerKt.m2004SwitchableDateEntryContentRN2D1Q(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00be
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
