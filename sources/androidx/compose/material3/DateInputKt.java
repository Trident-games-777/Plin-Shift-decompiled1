package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
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
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001ad\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010 ¢\u0006\u0002\b!2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010 ¢\u0006\u0002\b!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\n\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006.²\u0006\n\u0010/\u001a\u000200X\u0002"}, d2 = {"InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-tQNruF0", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "material3_release", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding = Dp.m7111constructorimpl((float) 16);

    public static final void DateInputContent(Long l, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        IntRange intRange2;
        Composer composer2;
        int i3;
        Locale locale;
        DateInputFormat dateInputFormat;
        Composer composer3;
        boolean z;
        Long l2 = l;
        CalendarModel calendarModel2 = calendarModel;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(643325609);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputContent)P(5,3!1,6,2,4)62@2605L15,64@2655L75,65@2758L45,66@2838L44,67@2916L45,69@2999L551,82@3639L42,86@3836L164,92@4024L62,83@3686L901:DateInput.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) l2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            Function1<? super Long, Unit> function12 = function1;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            intRange2 = intRange;
            i2 |= startRestartGroup.changedInstance(intRange2) ? 2048 : 1024;
        } else {
            intRange2 = intRange;
        }
        if ((i4 & 24576) == 0) {
            i2 |= (i4 & 32768) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates) ? 131072 : 65536;
        } else {
            SelectableDates selectableDates2 = selectableDates;
        }
        if ((1572864 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors) ? 1048576 : 524288;
        } else {
            DatePickerColors datePickerColors2 = datePickerColors;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643325609, i2, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:60)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1825155115, "CC(remember):DateInput.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) defaultLocale);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel2.getDateInputFormat(defaultLocale);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            DateInputFormat dateInputFormat2 = (DateInputFormat) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Strings.Companion companion = Strings.Companion;
            String r14 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_invalid_for_pattern), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            String r10 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_invalid_year_range), startRestartGroup, 0);
            Strings.Companion companion3 = Strings.Companion;
            String r0 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_invalid_not_allowed), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1825166599, "CC(remember):DateInput.kt#9igjgp");
            Locale locale2 = defaultLocale;
            boolean changed2 = startRestartGroup.changed((Object) dateInputFormat2) | ((57344 & i2) == 16384 || ((i2 & 32768) != 0 && startRestartGroup.changed((Object) datePickerFormatter2)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                composer3 = startRestartGroup;
                locale = locale2;
                i3 = i2;
                IntRange intRange3 = intRange2;
                dateInputFormat = dateInputFormat2;
                String str = r0;
                z = true;
                DateInputValidator dateInputValidator = new DateInputValidator(intRange3, selectableDates, dateInputFormat, datePickerFormatter2, r14, r10, str, "", (Long) null, (Long) null, ViewUtils.EDGE_TO_EDGE_FLAGS, (DefaultConstructorMarker) null);
                composer3.updateRememberedValue(dateInputValidator);
                rememberedValue2 = dateInputValidator;
            } else {
                composer3 = startRestartGroup;
                i3 = i2;
                dateInputFormat = dateInputFormat2;
                locale = locale2;
                z = true;
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Strings.Companion companion4 = Strings.Companion;
            String r5 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_label), composer3, 0);
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, z ? 1 : 0, (Object) null), InputTextFieldPadding);
            int r8 = InputIdentifier.Companion.m2149getSingleDateInputJ2x2o4M();
            dateInputValidator2.setCurrentStartDateMillis$material3_release(l2);
            int i5 = i3 << 3;
            Composer composer4 = composer3;
            m1950DateInputTextFieldtQNruF0(padding, l2, function1, calendarModel2, ComposableLambdaKt.rememberComposableLambda(-1819015125, z, new DateInputKt$DateInputContent$2(r5, upperCase), composer3, 54), ComposableLambdaKt.rememberComposableLambda(-564233108, z, new DateInputKt$DateInputContent$3(upperCase), composer3, 54), r8, dateInputValidator2, dateInputFormat, locale, datePickerColors, composer4, (i5 & 112) | 1794054 | (i5 & 896) | (i5 & 7168), (i3 >> 18) & 14);
            composer2 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateInputKt$DateInputContent$4(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    /* renamed from: DateInputTextField-tQNruF0  reason: not valid java name */
    public static final void m1950DateInputTextFieldtQNruF0(Modifier modifier, Long l, Function1<? super Long, Unit> function1, CalendarModel calendarModel, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, DatePickerColors datePickerColors, Composer composer, int i2, int i3) {
        int i4;
        Function1<? super Long, Unit> function12;
        int i5;
        Composer composer2;
        MutableState mutableState;
        int i6;
        float f;
        Long l2 = l;
        CalendarModel calendarModel2 = calendarModel;
        DateInputFormat dateInputFormat2 = dateInputFormat;
        Locale locale2 = locale;
        int i7 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-857008589);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputTextField)P(8,4,9!1,6,10,5:c#material3.InputIdentifier,3,2,7)122@5091L39,124@5207L488,124@5155L540,142@5766L1458,188@7730L60,191@7875L59,140@5701L2642:DateInput.kt#uh7d8r");
        if ((i7 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i7;
        } else {
            Modifier modifier2 = modifier;
            i4 = i7;
        }
        if ((i7 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) l2) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            function12 = function1;
            i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        if ((i7 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(calendarModel2) ? 2048 : 1024;
        }
        if ((i7 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        }
        if ((196608 & i7) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        }
        int i8 = i;
        if ((i7 & 1572864) == 0) {
            i4 |= startRestartGroup.changed(i8) ? 1048576 : 524288;
        }
        DateInputValidator dateInputValidator2 = dateInputValidator;
        if ((i7 & 12582912) == 0) {
            i4 |= startRestartGroup.changed((Object) dateInputValidator2) ? 8388608 : 4194304;
        }
        if ((i7 & 100663296) == 0) {
            i4 |= startRestartGroup.changed((Object) dateInputFormat2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i7 & 805306368) == 0) {
            i4 |= startRestartGroup.changedInstance(locale2) ? 536870912 : 268435456;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed((Object) datePickerColors2) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-857008589, i4, i5, "androidx.compose.material3.DateInputTextField (DateInput.kt:121)");
            }
            Composer composer3 = startRestartGroup;
            Composer composer4 = composer3;
            MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, DateInputKt$DateInputTextField$errorText$1.INSTANCE, composer3, 3072, 6);
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.Companion.getSaver();
            ComposerKt.sourceInformationMarkerStart(composer4, 236419420, "CC(remember):DateInput.kt#9igjgp");
            MutableState mutableState3 = mutableState2;
            int i9 = 234881024 & i4;
            boolean changedInstance = ((i4 & 112) == 32) | composer4.changedInstance(calendarModel2) | (i9 == 67108864) | composer4.changedInstance(locale2);
            Object rememberedValue = composer4.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateInputKt$DateInputTextField$text$2$1(l2, calendarModel2, dateInputFormat2, locale2);
                composer4.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            MutableState mutableState4 = mutableState3;
            Composer composer5 = composer4;
            Saver<TextFieldValue, Object> saver2 = saver;
            Function0 function0 = (Function0) rememberedValue;
            int i10 = i9;
            MutableState<T> rememberSaveable = RememberSaveableKt.rememberSaveable(objArr, saver2, (String) null, function0, composer5, 0, 4);
            Composer composer6 = composer5;
            TextFieldValue DateInputTextField_tQNruF0$lambda$4 = DateInputTextField_tQNruF0$lambda$4(rememberSaveable);
            ComposerKt.sourceInformationMarkerStart(composer6, 236438278, "CC(remember):DateInput.kt#9igjgp");
            boolean changed = ((i4 & 896) == 256) | (i10 == 67108864) | composer6.changed((Object) rememberSaveable) | composer6.changed((Object) mutableState4) | composer6.changedInstance(calendarModel2) | ((29360128 & i4) == 8388608) | ((3670016 & i4) == 1048576) | composer6.changedInstance(locale2);
            Object rememberedValue2 = composer6.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                int i11 = i8;
                mutableState = mutableState4;
                i6 = i4;
                CalendarModel calendarModel3 = calendarModel2;
                DateInputFormat dateInputFormat3 = dateInputFormat2;
                dateInputFormat2 = dateInputFormat3;
                rememberedValue2 = new DateInputKt$DateInputTextField$1$1(dateInputFormat3, mutableState, function12, calendarModel3, dateInputValidator2, i11, locale2, rememberSaveable);
                composer6.updateRememberedValue(rememberedValue2);
            } else {
                mutableState = mutableState4;
                i6 = i4;
            }
            Function1 function13 = (Function1) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer6);
            if (!StringsKt.isBlank((CharSequence) mutableState.getValue())) {
                f = Dp.m7111constructorimpl((float) 0);
            } else {
                f = InputTextNonErroneousBottomPadding;
            }
            float f2 = f;
            Composer composer7 = composer6;
            Modifier r3 = PaddingKt.m779paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f2, 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer7, 236499728, "CC(remember):DateInput.kt#9igjgp");
            boolean changed2 = composer7.changed((Object) mutableState);
            Object rememberedValue3 = composer7.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DateInputKt$DateInputTextField$2$1(mutableState);
                composer7.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer7);
            composer2 = composer7;
            OutlinedTextFieldKt.OutlinedTextField(DateInputTextField_tQNruF0$lambda$4, (Function1<? super TextFieldValue, Unit>) function13, SemanticsModifierKt.semantics$default(r3, false, (Function1) rememberedValue3, 1, (Object) null), false, false, (TextStyle) null, function2, function22, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-591991974, true, new DateInputKt$DateInputTextField$3(mutableState), composer7, 54), !StringsKt.isBlank((CharSequence) mutableState.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat2), new KeyboardOptions(0, (Boolean) false, KeyboardType.Companion.m6811getNumberPjHm6EE(), ImeAction.Companion.m6755getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 113, (DefaultConstructorMarker) null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, datePickerColors.getDateTextFieldColors(), composer2, (i6 << 6) & 33030144, 12779904, 0, 4001592);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateInputKt$DateInputTextField$4(modifier, l, function1, calendarModel, function2, function22, i, dateInputValidator, dateInputFormat2, locale, datePickerColors, i7, i3));
        }
    }

    private static final TextFieldValue DateInputTextField_tQNruF0$lambda$4(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }

    /* access modifiers changed from: private */
    public static final void DateInputTextField_tQNruF0$lambda$5(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    static {
        float f = (float) 24;
        InputTextFieldPadding = PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl(f), Dp.m7111constructorimpl((float) 10), Dp.m7111constructorimpl(f), 0.0f, 8, (Object) null);
    }
}
