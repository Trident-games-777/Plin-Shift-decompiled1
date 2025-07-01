package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedVisibilityScope;", "invoke", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$4$2 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ CalendarMonth $displayedMonth;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$4$2(long j, MutableState<Boolean> mutableState, CoroutineScope coroutineScope, LazyListState lazyListState, IntRange intRange, CalendarMonth calendarMonth, SelectableDates selectableDates, CalendarModel calendarModel, DatePickerColors datePickerColors) {
        super(3);
        this.$displayedMonthMillis = j;
        this.$yearPickerVisible$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$monthsListState = lazyListState;
        this.$yearRange = intRange;
        this.$displayedMonth = calendarMonth;
        this.$selectableDates = selectableDates;
        this.$calendarModel = calendarModel;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.animation.AnimatedVisibilityScope r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r5 = r20
            java.lang.String r1 = "C1556@71903L48,1557@72005L30,1557@71968L1887:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x001a
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1556)"
            r3 = 1193716082(0x4726a972, float:42665.445)
            r4 = r21
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r1, r2)
        L_0x001a:
            androidx.compose.material3.internal.Strings$Companion r1 = androidx.compose.material3.internal.Strings.Companion
            int r1 = androidx.compose.material3.R.string.m3c_date_picker_year_picker_pane_title
            int r1 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r1)
            r2 = 0
            java.lang.String r1 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r1, r5, r2)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 14700341(0xe04f35, float:2.0599565E-38)
            java.lang.String r6 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r6)
            boolean r4 = r5.changed((java.lang.Object) r1)
            java.lang.Object r7 = r5.rememberedValue()
            if (r4 != 0) goto L_0x0045
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x0050
        L_0x0045:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$1$1 r4 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$1$1
            r4.<init>(r1)
            r7 = r4
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r5.updateRememberedValue(r7)
        L_0x0050:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r1 = 1
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r2, r7, r1, r4)
            long r7 = r0.$displayedMonthMillis
            androidx.compose.runtime.MutableState<java.lang.Boolean> r11 = r0.$yearPickerVisible$delegate
            kotlinx.coroutines.CoroutineScope r10 = r0.$coroutineScope
            androidx.compose.foundation.lazy.LazyListState r12 = r0.$monthsListState
            kotlin.ranges.IntRange r13 = r0.$yearRange
            androidx.compose.material3.internal.CalendarMonth r14 = r0.$displayedMonth
            androidx.compose.material3.SelectableDates r3 = r0.$selectableDates
            androidx.compose.material3.internal.CalendarModel r15 = r0.$calendarModel
            r16 = r7
            androidx.compose.material3.DatePickerColors r8 = r0.$colors
            r7 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            java.lang.String r9 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r9)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getTop()
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r9 = r9.getStart()
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r7, r9, r5, r2)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r4)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r2)
            androidx.compose.runtime.CompositionLocalMap r4 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            r0 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r21 = r2
            java.lang.String r2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r2)
            androidx.compose.runtime.Applier r0 = r5.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x00b6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b6:
            r5.startReusableNode()
            boolean r0 = r5.getInserting()
            if (r0 == 0) goto L_0x00c3
            r5.createNode(r9)
            goto L_0x00c6
        L_0x00c3:
            r5.useNode()
        L_0x00c6:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3675constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r4, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r4 = r0.getInserting()
            if (r4 != 0) goto L_0x00f6
            java.lang.Object r4 = r0.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r21)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r7)
            if (r4 != 0) goto L_0x0104
        L_0x00f6:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r21)
            r0.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r21)
            r0.apply(r4, r2)
        L_0x0104:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r1, r2)
            r0 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            java.lang.String r1 = "C87@4365L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 535553211(0x1febe4bb, float:9.9904774E-20)
            java.lang.String r1 = "C1569@72779L767,1558@72059L1711,1586@73791L46:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r1 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
            r2 = 7
            float r2 = (float) r2
            float r1 = r1 * r2
            float r1 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r1)
            androidx.compose.material3.DividerDefaults r2 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r2 = r2.m2032getThicknessD9Ej5fM()
            float r1 = r1 - r2
            float r1 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m834requiredHeight3ABfNKs(r0, r1)
            float r1 = androidx.compose.material3.DatePickerKt.getDatePickerHorizontalPadding()
            r2 = 0
            r4 = 2
            r7 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m777paddingVpY3zN4$default(r0, r1, r2, r4, r7)
            r0 = -2060912043(0xffffffff8528fa55, float:-7.945301E-36)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r6)
            boolean r0 = r5.changed((java.lang.Object) r11)
            boolean r2 = r5.changedInstance(r10)
            r0 = r0 | r2
            boolean r2 = r5.changed((java.lang.Object) r12)
            r0 = r0 | r2
            boolean r2 = r5.changedInstance(r13)
            r0 = r0 | r2
            boolean r2 = r5.changed((java.lang.Object) r14)
            r0 = r0 | r2
            java.lang.Object r2 = r5.rememberedValue()
            if (r0 != 0) goto L_0x0176
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0181
        L_0x0176:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1 r9 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1
            r9.<init>(r10, r11, r12, r13, r14)
            r2 = r9
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5.updateRememberedValue(r2)
        L_0x0181:
            r4 = r2
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r10 = 6
            r9 = r5
            r7 = r13
            r6 = r15
            r5 = r3
            r2 = r16
            androidx.compose.material3.DatePickerKt.YearPicker(r1, r2, r4, r5, r6, r7, r8, r9, r10)
            long r3 = r8.m1965getDividerColor0d7_KjU()
            r6 = 0
            r7 = 3
            r1 = 0
            r2 = 0
            r5 = r20
            androidx.compose.material3.DividerKt.m2034HorizontalDivider9IZ8Weo(r1, r2, r3, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            r20.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2.invoke(androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):void");
    }
}
