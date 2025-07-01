package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1$2$1 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ List<CustomAccessibilityAction> $customAccessibilityAction;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ CalendarDate $today;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1$2$1(IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, Long l, Long l2, Function1<? super Long, Unit> function1, CalendarDate calendarDate, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, List<CustomAccessibilityAction> list) {
        super(1);
        this.$yearRange = intRange;
        this.$calendarModel = calendarModel;
        this.$firstMonth = calendarMonth;
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$onDateSelectionChange = function1;
        this.$today = calendarDate;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
        this.$customAccessibilityAction = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        int numberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(this.$yearRange);
        final CalendarModel calendarModel = this.$calendarModel;
        final CalendarMonth calendarMonth = this.$firstMonth;
        final Long l = this.$selectedStartDateMillis;
        final Long l2 = this.$selectedEndDateMillis;
        final Function1<Long, Unit> function1 = this.$onDateSelectionChange;
        final CalendarDate calendarDate = this.$today;
        final DatePickerFormatter datePickerFormatter = this.$dateFormatter;
        final SelectableDates selectableDates = this.$selectableDates;
        final DatePickerColors datePickerColors = this.$colors;
        final List<CustomAccessibilityAction> list = this.$customAccessibilityAction;
        LazyListScope.items$default(lazyListScope, numberOfMonthsInRange, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1413501381, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: androidx.compose.material3.SelectedRangeInfo} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(androidx.compose.foundation.lazy.LazyItemScope r18, int r19, androidx.compose.runtime.Composer r20, int r21) {
                /*
                    r17 = this;
                    r0 = r17
                    r1 = r18
                    r2 = r19
                    r11 = r20
                    java.lang.String r3 = "C797@35229L2126:DateRangePicker.kt#uh7d8r"
                    androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                    r3 = r21 & 6
                    if (r3 != 0) goto L_0x001d
                    boolean r3 = r11.changed((java.lang.Object) r1)
                    if (r3 == 0) goto L_0x0019
                    r3 = 4
                    goto L_0x001a
                L_0x0019:
                    r3 = 2
                L_0x001a:
                    r3 = r21 | r3
                    goto L_0x001f
                L_0x001d:
                    r3 = r21
                L_0x001f:
                    r4 = 48
                    r5 = r21 & 48
                    if (r5 != 0) goto L_0x0031
                    boolean r5 = r11.changed((int) r2)
                    if (r5 == 0) goto L_0x002e
                    r5 = 32
                    goto L_0x0030
                L_0x002e:
                    r5 = 16
                L_0x0030:
                    r3 = r3 | r5
                L_0x0031:
                    r5 = r3 & 147(0x93, float:2.06E-43)
                    r6 = 146(0x92, float:2.05E-43)
                    if (r5 != r6) goto L_0x0042
                    boolean r5 = r11.getSkipping()
                    if (r5 != 0) goto L_0x003e
                    goto L_0x0042
                L_0x003e:
                    r11.skipToGroupEnd()
                    return
                L_0x0042:
                    boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r5 == 0) goto L_0x0051
                    r5 = -1
                    java.lang.String r6 = "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:796)"
                    r7 = -1413501381(0xffffffffabbfae3b, float:-1.3619725E-12)
                    androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r6)
                L_0x0051:
                    androidx.compose.material3.internal.CalendarModel r3 = r4
                    androidx.compose.material3.internal.CalendarMonth r5 = r5
                    androidx.compose.material3.internal.CalendarMonth r2 = r3.plusMonths(r5, r2)
                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                    androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                    r5 = 0
                    r6 = 1
                    r7 = 0
                    androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.LazyItemScope.fillParentMaxWidth$default(r1, r3, r5, r6, r7)
                    java.lang.Long r5 = r6
                    java.lang.Long r3 = r7
                    kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> r8 = r8
                    androidx.compose.material3.internal.CalendarDate r9 = r9
                    r10 = r8
                    androidx.compose.material3.DatePickerFormatter r8 = r10
                    r12 = r9
                    androidx.compose.material3.SelectableDates r9 = r11
                    r13 = r10
                    androidx.compose.material3.DatePickerColors r10 = r12
                    java.util.List<androidx.compose.ui.semantics.CustomAccessibilityAction> r14 = r13
                    androidx.compose.material3.internal.CalendarModel r15 = r4
                    r7 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
                    java.lang.String r4 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r4)
                    androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
                    androidx.compose.foundation.layout.Arrangement$Vertical r4 = r4.getTop()
                    androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
                    androidx.compose.ui.Alignment$Horizontal r7 = r7.getStart()
                    r6 = 0
                    androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r4, r7, r11, r6)
                    r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                    java.lang.String r0 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r0)
                    int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r6)
                    androidx.compose.runtime.CompositionLocalMap r6 = r11.getCurrentCompositionLocalMap()
                    androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r1)
                    androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
                    kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
                    r18 = r0
                    r0 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
                    r16 = r9
                    java.lang.String r9 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r9)
                    androidx.compose.runtime.Applier r0 = r11.getApplier()
                    boolean r0 = r0 instanceof androidx.compose.runtime.Applier
                    if (r0 != 0) goto L_0x00c3
                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                L_0x00c3:
                    r11.startReusableNode()
                    boolean r0 = r11.getInserting()
                    if (r0 == 0) goto L_0x00d0
                    r11.createNode(r7)
                    goto L_0x00d3
                L_0x00d0:
                    r11.useNode()
                L_0x00d3:
                    androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
                    androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
                    kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
                    androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r4, r7)
                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                    kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
                    androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r6, r4)
                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                    kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
                    boolean r6 = r0.getInserting()
                    if (r6 != 0) goto L_0x0103
                    java.lang.Object r6 = r0.rememberedValue()
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r18)
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                    if (r6 != 0) goto L_0x0111
                L_0x0103:
                    java.lang.Integer r6 = java.lang.Integer.valueOf(r18)
                    r0.updateRememberedValue(r6)
                    java.lang.Integer r6 = java.lang.Integer.valueOf(r18)
                    r0.apply(r6, r4)
                L_0x0111:
                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                    kotlin.jvm.functions.Function2 r4 = r4.getSetModifier()
                    androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r1, r4)
                    r0 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
                    java.lang.String r1 = "C87@4365L9:Column.kt#2w3rfo"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
                    androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
                    androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
                    r0 = 1459498729(0x56fe2ee9, float:1.39738716E14)
                    java.lang.String r1 = "C798@35370L5,798@35377L623,798@35300L700,824@36791L546:DateRangePicker.kt#uh7d8r"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
                    androidx.compose.material3.tokens.DatePickerModalTokens r0 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
                    androidx.compose.material3.tokens.TypographyKeyTokens r0 = r0.getRangeSelectionMonthSubheadFont()
                    r1 = 6
                    androidx.compose.ui.text.TextStyle r0 = androidx.compose.material3.TypographyKt.getValue(r0, r11, r1)
                    androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1 r1 = new androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1
                    r1.<init>(r8, r2, r14, r10)
                    r4 = 54
                    r6 = 1622100276(0x60af4934, float:1.0104547E20)
                    r7 = 1
                    androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r1, r11, r4)
                    kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                    r4 = 48
                    androidx.compose.material3.TextKt.ProvideTextStyle(r0, r1, r11, r4)
                    r0 = 2125314509(0x7eadb9cd, float:1.1546059E38)
                    r11.startReplaceGroup(r0)
                    java.lang.String r0 = "813@36190L488"
                    androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
                    if (r5 == 0) goto L_0x019d
                    if (r3 == 0) goto L_0x019d
                    r0 = 2125317517(0x7eadc58d, float:1.1549109E38)
                    java.lang.String r1 = "CC(remember):DateRangePicker.kt#9igjgp"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
                    boolean r0 = r11.changed((java.lang.Object) r5)
                    boolean r1 = r11.changed((java.lang.Object) r3)
                    r0 = r0 | r1
                    java.lang.Object r1 = r11.rememberedValue()
                    if (r0 != 0) goto L_0x017d
                    androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r0 = r0.getEmpty()
                    if (r1 != r0) goto L_0x0196
                L_0x017d:
                    androidx.compose.material3.SelectedRangeInfo$Companion r0 = androidx.compose.material3.SelectedRangeInfo.Companion
                    long r6 = r5.longValue()
                    androidx.compose.material3.internal.CalendarDate r1 = r15.getCanonicalDate(r6)
                    long r6 = r3.longValue()
                    androidx.compose.material3.internal.CalendarDate r4 = r15.getCanonicalDate(r6)
                    androidx.compose.material3.SelectedRangeInfo r1 = r0.calculateRangeInfo(r2, r1, r4)
                    r11.updateRememberedValue(r1)
                L_0x0196:
                    r7 = r1
                    androidx.compose.material3.SelectedRangeInfo r7 = (androidx.compose.material3.SelectedRangeInfo) r7
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
                    goto L_0x019e
                L_0x019d:
                    r7 = 0
                L_0x019e:
                    r11.endReplaceGroup()
                    long r0 = r12.getUtcTimeMillis()
                    r12 = 0
                    r6 = r3
                    r9 = r16
                    r3 = r0
                    r1 = r2
                    r2 = r13
                    androidx.compose.material3.DatePickerKt.Month(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
                    r20.endNode()
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r0 == 0) goto L_0x01ca
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                L_0x01ca:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.AnonymousClass1.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
            }
        }), 6, (Object) null);
    }
}
