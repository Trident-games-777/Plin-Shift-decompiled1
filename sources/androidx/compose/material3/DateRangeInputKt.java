package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.google.android.material.internal.ViewUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062:\u0010\b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\u0010\u0018\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0019"}, d2 = {"TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m7111constructorimpl((float) 8);

    public static final void DateRangeInputContent(Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        DateInputFormat dateInputFormat;
        Long l3 = l;
        Long l4 = l2;
        Function2<? super Long, ? super Long, Unit> function22 = function2;
        CalendarModel calendarModel2 = calendarModel;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-607499086);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangeInputContent)P(6,5,3!1,7,2,4)45@1775L15,47@1825L75,48@1928L45,49@2008L44,50@2086L45,51@2160L50,53@2248L530,70@2991L2331:DateRangeInput.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) l3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) l4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            intRange2 = intRange;
            i2 |= startRestartGroup.changedInstance(intRange2) ? 16384 : 8192;
        } else {
            intRange2 = intRange;
        }
        if ((196608 & i3) == 0) {
            i2 |= (i3 & 262144) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 1048576 : 524288;
        } else {
            selectableDates2 = selectableDates;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((i3 & 12582912) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 8388608 : 4194304;
        }
        if ((i2 & 4793491) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-607499086, i2, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:43)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 998328518, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) defaultLocale);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel2.getDateInputFormat(defaultLocale);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            DateInputFormat dateInputFormat2 = (DateInputFormat) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Strings.Companion companion = Strings.Companion;
            String r21 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_invalid_for_pattern), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            String r22 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_invalid_year_range), startRestartGroup, 0);
            Strings.Companion companion3 = Strings.Companion;
            String r23 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_invalid_not_allowed), startRestartGroup, 0);
            Strings.Companion companion4 = Strings.Companion;
            String r24 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_input_invalid_range_input), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 998342509, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean changed2 = ((i2 & 458752) == 131072 || ((i2 & 262144) != 0 && startRestartGroup.changed((Object) datePickerFormatter2))) | startRestartGroup.changed((Object) dateInputFormat2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                dateInputFormat = dateInputFormat2;
                rememberedValue2 = new DateInputValidator(intRange2, selectableDates2, dateInputFormat, datePickerFormatter2, r21, r22, r23, r24, (Long) null, (Long) null, ViewUtils.EDGE_TO_EDGE_FLAGS, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            } else {
                dateInputFormat = dateInputFormat2;
            }
            DateInputValidator dateInputValidator = (DateInputValidator) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            dateInputValidator.setCurrentStartDateMillis$material3_release(l3);
            dateInputValidator.setCurrentEndDateMillis$material3_release(l4);
            Modifier padding = PaddingKt.padding(Modifier.Companion, DateInputKt.getInputTextFieldPadding());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m623spacedBy0680j_4(TextFieldSpacing), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
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
            Composer r1 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r1, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r1, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1199006788, "C75@3252L56,88@3849L203,79@3446L218,86@3692L62,76@3317L972,98@4317L54,110@4882L199,102@4509L190,108@4727L62,99@4380L936:DateRangeInput.kt#uh7d8r");
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Strings.Companion companion5 = Strings.Companion;
            String r12 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 0.5f, false, 2, (Object) null);
            int r10 = InputIdentifier.Companion.m2150getStartDateInputJ2x2o4M();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1485363141, "CC(remember):DateRangeInput.kt#9igjgp");
            int i4 = i2 & 896;
            Modifier modifier = weight$default;
            int i5 = i2 & 112;
            boolean z = (i4 == 256) | (i5 == 32);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DateRangeInputKt$DateRangeInputContent$2$1$1(function22, l4);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i6 = i5;
            int i7 = i2 & 7168;
            int i8 = ((i2 << 3) & 112) | 1794048 | i7;
            int i9 = i4;
            Function1 function1 = (Function1) rememberedValue3;
            int i10 = i7;
            String str = upperCase;
            int i11 = (i2 >> 21) & 14;
            boolean z2 = false;
            int i12 = i8;
            Locale locale = defaultLocale;
            int i13 = r10;
            DateInputFormat dateInputFormat3 = dateInputFormat;
            DatePickerColors datePickerColors3 = datePickerColors2;
            Function2 rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(665407211, true, new DateRangeInputKt$DateRangeInputContent$2$3(upperCase), startRestartGroup, 54);
            Modifier modifier2 = modifier;
            int i14 = i6;
            int i15 = i2;
            Function2 rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(801434508, true, new DateRangeInputKt$DateRangeInputContent$2$2(r12, upperCase), startRestartGroup, 54);
            Long l5 = l;
            DateInputKt.m1950DateInputTextFieldtQNruF0(modifier2, l5, function1, calendarModel2, rememberComposableLambda2, rememberComposableLambda, i13, dateInputValidator, dateInputFormat3, locale, datePickerColors3, startRestartGroup, i12, i11);
            Long l6 = l5;
            Strings.Companion companion6 = Strings.Companion;
            String r13 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
            Modifier weight$default2 = RowScope.weight$default(rowScope, Modifier.Companion, 0.5f, false, 2, (Object) null);
            int r6 = InputIdentifier.Companion.m2148getEndDateInputJ2x2o4M();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1485396193, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean z3 = i9 == 256;
            if ((i15 & 14) == 4) {
                z2 = true;
            }
            boolean z4 = z3 | z2;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new DateRangeInputKt$DateRangeInputContent$2$4$1(function22, l6);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String str2 = str;
            DateInputKt.m1950DateInputTextFieldtQNruF0(weight$default2, l2, (Function1) rememberedValue4, calendarModel, ComposableLambdaKt.rememberComposableLambda(911487285, true, new DateRangeInputKt$DateRangeInputContent$2$5(r13, str2), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-961726252, true, new DateRangeInputKt$DateRangeInputContent$2$6(str2), startRestartGroup, 54), r6, dateInputValidator, dateInputFormat3, locale, datePickerColors, startRestartGroup, i14 | 1794048 | i10, i11);
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
            endRestartGroup.updateScope(new DateRangeInputKt$DateRangeInputContent$3(l, l2, function22, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }
}
