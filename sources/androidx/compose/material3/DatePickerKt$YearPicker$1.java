package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPicker$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPicker$1(CalendarModel calendarModel, long j, IntRange intRange, DatePickerColors datePickerColors, Modifier modifier, Function1<? super Integer, Unit> function1, SelectableDates selectableDates) {
        super(2);
        this.$calendarModel = calendarModel;
        this.$displayedMonthMillis = j;
        this.$yearRange = intRange;
        this.$colors = datePickerColors;
        this.$modifier = modifier;
        this.$onYearSelected = function1;
        this.$selectableDates = selectableDates;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r11 = r24
            r1 = r25
            java.lang.String r2 = "C1988@89414L281,1995@89876L24,1996@89941L53,1997@90033L51,2012@90779L2661,1998@90093L3347:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001b
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            r11.skipToGroupEnd()
            return
        L_0x001b:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002a
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1985)"
            r5 = 1301915789(0x4d99a88d, float:3.22245024E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r2, r4)
        L_0x002a:
            androidx.compose.material3.internal.CalendarModel r1 = r0.$calendarModel
            androidx.compose.material3.internal.CalendarDate r2 = r1.getToday()
            androidx.compose.material3.internal.CalendarMonth r1 = r1.getMonth((androidx.compose.material3.internal.CalendarDate) r2)
            int r1 = r1.getYear()
            androidx.compose.material3.internal.CalendarModel r2 = r0.$calendarModel
            long r4 = r0.$displayedMonthMillis
            androidx.compose.material3.internal.CalendarMonth r2 = r2.getMonth((long) r4)
            int r2 = r2.getYear()
            kotlin.ranges.IntRange r4 = r0.$yearRange
            int r4 = r4.getFirst()
            int r4 = r2 - r4
            r5 = 3
            int r4 = r4 - r5
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            androidx.compose.foundation.lazy.grid.LazyGridState r14 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r4, r6, r11, r6, r3)
            androidx.compose.material3.DatePickerColors r3 = r0.$colors
            long r16 = r3.m1954getContainerColor0d7_KjU()
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r4 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            r3 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r4 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x008a
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r11)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r3)
            r11.updateRememberedValue(r4)
            r3 = r4
        L_0x008a:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            kotlinx.coroutines.CoroutineScope r3 = r3.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_date_picker_scroll_to_earlier_years
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
            java.lang.String r4 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r4, r11, r6)
            androidx.compose.material3.internal.Strings$Companion r7 = androidx.compose.material3.internal.Strings.Companion
            int r7 = androidx.compose.material3.R.string.m3c_date_picker_scroll_to_later_years
            int r7 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r7)
            java.lang.String r7 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r7, r11, r6)
            androidx.compose.foundation.lazy.grid.GridCells$Fixed r8 = new androidx.compose.foundation.lazy.grid.GridCells$Fixed
            r8.<init>(r5)
            androidx.compose.ui.Modifier r15 = r0.$modifier
            r19 = 2
            r20 = 0
            r18 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.BackgroundKt.m248backgroundbw27NRU$default(r15, r16, r18, r19, r20)
            androidx.compose.material3.DatePickerKt$YearPicker$1$1 r9 = androidx.compose.material3.DatePickerKt$YearPicker$1.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r10 = 1
            r12 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r6, r9, r10, r12)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.getSpaceEvenly()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r10 = androidx.compose.material3.DatePickerKt.YearsVerticalPadding
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r9 = r9.m623spacedBy0680j_4(r10)
            androidx.compose.foundation.lazy.grid.GridCells r8 = (androidx.compose.foundation.lazy.grid.GridCells) r8
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = (androidx.compose.foundation.layout.Arrangement.Vertical) r9
            androidx.compose.foundation.layout.Arrangement$Horizontal r6 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r6
            r10 = 15757458(0xf07092, float:2.2080902E-38)
            java.lang.String r12 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r10, r12)
            kotlin.ranges.IntRange r10 = r0.$yearRange
            boolean r10 = r11.changedInstance(r10)
            boolean r12 = r11.changed((java.lang.Object) r14)
            r10 = r10 | r12
            boolean r12 = r11.changedInstance(r3)
            r10 = r10 | r12
            boolean r12 = r11.changed((java.lang.Object) r4)
            r10 = r10 | r12
            boolean r12 = r11.changed((java.lang.Object) r7)
            r10 = r10 | r12
            boolean r12 = r11.changed((int) r2)
            r10 = r10 | r12
            boolean r12 = r11.changed((int) r1)
            r10 = r10 | r12
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r12 = r0.$onYearSelected
            boolean r12 = r11.changed((java.lang.Object) r12)
            r10 = r10 | r12
            androidx.compose.material3.SelectableDates r12 = r0.$selectableDates
            boolean r12 = r11.changed((java.lang.Object) r12)
            r10 = r10 | r12
            androidx.compose.material3.DatePickerColors r12 = r0.$colors
            boolean r12 = r11.changed((java.lang.Object) r12)
            r10 = r10 | r12
            kotlin.ranges.IntRange r13 = r0.$yearRange
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r12 = r0.$onYearSelected
            androidx.compose.material3.SelectableDates r15 = r0.$selectableDates
            r19 = r1
            androidx.compose.material3.DatePickerColors r1 = r0.$colors
            java.lang.Object r0 = r11.rememberedValue()
            if (r10 != 0) goto L_0x0138
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r0 != r10) goto L_0x0150
        L_0x0138:
            r20 = r12
            androidx.compose.material3.DatePickerKt$YearPicker$1$2$1 r12 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1
            r22 = r1
            r18 = r2
            r16 = r4
            r17 = r7
            r21 = r15
            r15 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r12
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r11.updateRememberedValue(r0)
        L_0x0150:
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r12 = 1769472(0x1b0000, float:2.479558E-39)
            r13 = 408(0x198, float:5.72E-43)
            r4 = 0
            r2 = r5
            r5 = 0
            r1 = r8
            r8 = 0
            r7 = r6
            r6 = r9
            r9 = 0
            r3 = r14
            androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$YearPicker$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
