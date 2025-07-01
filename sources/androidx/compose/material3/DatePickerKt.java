package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
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
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001ak\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010+\u001a\u0001\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aT\u0010E\u001a\u00020&2\n\u0010F\u001a\u00060Gj\u0002`H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001an\u0010O\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010X\u001a6\u0010Y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020L2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001401H\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a\u0001\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2\b\u0010-\u001a\u0004\u0018\u00010.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010a\u001av\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020d2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012\u0006\u0010e\u001a\u00020.2\b\u0010f\u001a\u0004\u0018\u00010.2\b\u0010g\u001a\u0004\u0018\u00010.2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010j\u001ag\u0010k\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020W2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010s\u001a\u0001\u0010t\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2\u0006\u0010Z\u001a\u00020L2#\u00100\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\bu\u0010v\u001a\u001d\u0010w\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u0010x\u001a^\u0010y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010S\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010{\u001a`\u0010|\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.2!\u0010}\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(~\u0012\u0004\u0012\u00020\u0014012\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001aC\u0010\u0001\u001a\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0007\u0010\u0001\u001a\u00020*2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0003\u0010\u0001\u001a6\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\u0007\u0010%\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020WH\u0002\u001a>\u0010\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*H\u0003¢\u0006\u0003\u0010\u0001\u001a\u0011\u0010\u0001\u001a\u00020\f2\u0006\u00109\u001a\u00020:H\u0000\u001aK\u0010\u0001\u001a\u00020&2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001aK\u0010\u0001\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H@¢\u0006\u0003\u0010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0001²\u0006\n\u0010n\u001a\u00020*X\u0002"}, d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "showModeToggle", "", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "selectedDateMillis", "", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/internal/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "SwitchableDateEntryContent-d7iavvg", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "numberOfMonthsInRange", "rememberDatePickerState", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerKt {
    /* access modifiers changed from: private */
    public static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    /* access modifiers changed from: private */
    public static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final float MonthYearHeight = Dp.m7111constructorimpl((float) 56);
    private static final float RecommendedSizeForAccessibility = Dp.m7111constructorimpl((float) 48);
    private static final int YearsInRow = 3;
    /* access modifiers changed from: private */
    public static final float YearsVerticalPadding;

    /* JADX WARNING: Removed duplicated region for block: B:118:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DatePicker(androidx.compose.material3.DatePickerState r26, androidx.compose.ui.Modifier r27, androidx.compose.material3.DatePickerFormatter r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.material3.DatePickerColors r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r1 = r26
            r0 = r28
            r8 = r34
            r2 = 809701813(0x304311b5, float:7.096575E-10)
            r3 = r33
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(DatePicker)P(5,3,1,6,2,4)171@8197L47,172@8285L170,178@8499L278,187@8865L8,189@8902L15,190@8942L62,207@9637L5,210@9746L655,191@9009L1392:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r35 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r8 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r8 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r8
            goto L_0x002b
        L_0x002a:
            r4 = r8
        L_0x002b:
            r5 = r35 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0045
            r6 = r27
            boolean r7 = r3.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r27
        L_0x0047:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r35 & 4
            if (r7 != 0) goto L_0x0061
            r7 = r8 & 512(0x200, float:7.175E-43)
            if (r7 != 0) goto L_0x0058
            boolean r7 = r3.changed((java.lang.Object) r0)
            goto L_0x005c
        L_0x0058:
            boolean r7 = r3.changedInstance(r0)
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r7
        L_0x0064:
            r7 = r35 & 8
            if (r7 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007e
            r9 = r29
            boolean r10 = r3.changedInstance(r9)
            if (r10 == 0) goto L_0x007a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r10
            goto L_0x0080
        L_0x007e:
            r9 = r29
        L_0x0080:
            r10 = r35 & 16
            if (r10 == 0) goto L_0x0087
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009a
            r11 = r30
            boolean r12 = r3.changedInstance(r11)
            if (r12 == 0) goto L_0x0096
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r4 = r4 | r12
            goto L_0x009c
        L_0x009a:
            r11 = r30
        L_0x009c:
            r12 = r35 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a4
            r4 = r4 | r13
            goto L_0x00b6
        L_0x00a4:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b6
            r13 = r31
            boolean r14 = r3.changed((boolean) r13)
            if (r14 == 0) goto L_0x00b2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r4 = r4 | r14
            goto L_0x00b8
        L_0x00b6:
            r13 = r31
        L_0x00b8:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d2
            r14 = r35 & 64
            if (r14 != 0) goto L_0x00cc
            r14 = r32
            boolean r15 = r3.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r14 = r32
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r15
            goto L_0x00d4
        L_0x00d2:
            r14 = r32
        L_0x00d4:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r4
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r2) goto L_0x00f1
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x00e4
            goto L_0x00f1
        L_0x00e4:
            r3.skipToGroupEnd()
            r17 = r3
            r2 = r6
            r4 = r9
            r6 = r13
            r7 = r14
            r3 = r0
        L_0x00ee:
            r5 = r11
            goto L_0x0247
        L_0x00f1:
            r3.startDefaults()
            r2 = r8 & 1
            r33 = -3670017(0xffffffffffc7ffff, float:NaN)
            java.lang.String r15 = "CC(remember):DatePicker.kt#9igjgp"
            r0 = 1
            if (r2 == 0) goto L_0x011d
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0105
            goto L_0x011d
        L_0x0105:
            r3.skipToGroupEnd()
            r2 = r35 & 4
            if (r2 == 0) goto L_0x010e
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010e:
            r2 = r35 & 64
            if (r2 == 0) goto L_0x0114
            r4 = r4 & r33
        L_0x0114:
            r2 = r28
        L_0x0116:
            r5 = r4
            r10 = r9
            r4 = r13
            r13 = r14
        L_0x011a:
            r9 = r6
            goto L_0x0199
        L_0x011d:
            if (r5 == 0) goto L_0x0124
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r6 = r2
        L_0x0124:
            r2 = r35 & 4
            if (r2 == 0) goto L_0x0155
            r2 = 255556878(0xf3b7d0e, float:9.2438965E-30)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r2, r15)
            java.lang.Object r2 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x014d
            androidx.compose.material3.DatePickerDefaults r19 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            r23 = 7
            r24 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            androidx.compose.material3.DatePickerFormatter r2 = androidx.compose.material3.DatePickerDefaults.dateFormatter$default(r19, r20, r21, r22, r23, r24)
            r3.updateRememberedValue(r2)
        L_0x014d:
            androidx.compose.material3.DatePickerFormatter r2 = (androidx.compose.material3.DatePickerFormatter) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0157
        L_0x0155:
            r2 = r28
        L_0x0157:
            if (r7 == 0) goto L_0x016f
            androidx.compose.material3.DatePickerKt$DatePicker$2 r5 = new androidx.compose.material3.DatePickerKt$DatePicker$2
            r5.<init>(r1)
            r7 = -1504998463(0xffffffffa64b8bc1, float:-7.0619175E-16)
            r9 = 54
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r0, r5, r3, r9)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r25 = r9
            r9 = r5
            r5 = r25
            goto L_0x0171
        L_0x016f:
            r5 = 54
        L_0x0171:
            if (r10 == 0) goto L_0x0183
            androidx.compose.material3.DatePickerKt$DatePicker$3 r7 = new androidx.compose.material3.DatePickerKt$DatePicker$3
            r7.<init>(r1, r2)
            r10 = -1780043561(0xffffffff95e6b0d7, float:-9.3175264E-26)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r0, r7, r3, r5)
            r5 = r7
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r11 = r5
        L_0x0183:
            if (r12 == 0) goto L_0x0186
            r13 = r0
        L_0x0186:
            r5 = r35 & 64
            if (r5 == 0) goto L_0x0116
            androidx.compose.material3.DatePickerDefaults r5 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            r7 = 6
            androidx.compose.material3.DatePickerColors r5 = r5.colors(r3, r7)
            r4 = r4 & r33
            r10 = r5
            r5 = r4
            r4 = r13
            r13 = r10
            r10 = r9
            goto L_0x011a
        L_0x0199:
            r3.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01ab
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.DatePicker (DatePicker.kt:188)"
            r12 = 809701813(0x304311b5, float:7.096575E-10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r5, r6, r7)
        L_0x01ab:
            r6 = 0
            java.util.Locale r6 = androidx.compose.material3.CalendarLocale_androidKt.defaultLocale(r3, r6)
            r7 = 255580733(0xf3bda3d, float:9.261843E-30)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r15)
            boolean r7 = r3.changed((java.lang.Object) r6)
            java.lang.Object r12 = r3.rememberedValue()
            if (r7 != 0) goto L_0x01c8
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r12 != r7) goto L_0x01cf
        L_0x01c8:
            androidx.compose.material3.internal.CalendarModel r12 = androidx.compose.material3.internal.CalendarModel_androidKt.createCalendarModel(r6)
            r3.updateRememberedValue(r12)
        L_0x01cf:
            androidx.compose.material3.internal.CalendarModel r12 = (androidx.compose.material3.internal.CalendarModel) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r6 = 255587712(0xf3bf580, float:9.2670934E-30)
            r3.startReplaceGroup(r6)
            java.lang.String r6 = "197@9187L323"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            if (r4 == 0) goto L_0x01f2
            androidx.compose.material3.DatePickerKt$DatePicker$4 r6 = new androidx.compose.material3.DatePickerKt$DatePicker$4
            r6.<init>(r1)
            r7 = 1982226759(0x76266147, float:8.436468E32)
            r14 = 54
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r0, r6, r3, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            goto L_0x01f3
        L_0x01f2:
            r6 = 0
        L_0x01f3:
            r3.endReplaceGroup()
            androidx.compose.material3.tokens.DatePickerModalTokens r7 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r7 = r7.getHeaderHeadlineFont()
            r14 = 6
            androidx.compose.ui.text.TextStyle r7 = androidx.compose.material3.TypographyKt.getValue(r7, r3, r14)
            androidx.compose.material3.tokens.DatePickerModalTokens r14 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r15 = r14.m3169getHeaderContainerHeightD9Ej5fM()
            androidx.compose.material3.DatePickerKt$DatePicker$5 r14 = new androidx.compose.material3.DatePickerKt$DatePicker$5
            r14.<init>(r1, r12, r2, r13)
            r12 = -1840727866(0xffffffff9248b8c6, float:-6.3336623E-28)
            r1 = 54
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r0, r14, r3, r1)
            r16 = r0
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            int r0 = r5 >> 3
            r0 = r0 & 14
            r1 = 14155776(0xd80000, float:1.9836467E-38)
            r0 = r0 | r1
            r18 = 6
            int r1 = r5 >> 6
            r5 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r5
            r5 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r5
            r18 = r0 | r1
            r17 = r3
            r12 = r6
            r14 = r7
            m1983DateEntryContainerau3_HiA(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0240
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0240:
            r3 = r2
            r6 = r4
            r2 = r9
            r4 = r10
            r7 = r13
            goto L_0x00ee
        L_0x0247:
            androidx.compose.runtime.ScopeUpdateScope r10 = r17.endRestartGroup()
            if (r10 == 0) goto L_0x025b
            androidx.compose.material3.DatePickerKt$DatePicker$6 r0 = new androidx.compose.material3.DatePickerKt$DatePicker$6
            r1 = r26
            r9 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x025b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePicker(androidx.compose.material3.DatePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: rememberDatePickerState-EU0dCGE  reason: not valid java name */
    public static final DatePickerState m1990rememberDatePickerStateEU0dCGE(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        ComposerKt.sourceInformationMarkerStart(composer2, 2065763010, "C(rememberDatePickerState)P(2,1,4,0:c#material3.DisplayMode)365@15667L15,366@15771L347,366@15694L424:DatePicker.kt#uh7d8r");
        Long l3 = (i3 & 1) != 0 ? null : l;
        Long l4 = (i3 & 2) != 0 ? l3 : l2;
        IntRange yearRange = (i3 & 4) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        int r9 = (i3 & 8) != 0 ? DisplayMode.Companion.m2031getPickerjFl4v0() : i;
        SelectableDates allDates = (i3 & 16) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065763010, i4, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:364)");
        }
        boolean z = false;
        Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(composer2, 0);
        Object[] objArr = new Object[0];
        Saver<DatePickerStateImpl, Object> Saver = DatePickerStateImpl.Companion.Saver(allDates, defaultLocale);
        ComposerKt.sourceInformationMarkerStart(composer2, -390857696, "CC(remember):DatePicker.kt#9igjgp");
        boolean changedInstance = ((((i4 & 14) ^ 6) > 4 && composer2.changed((Object) l3)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer2.changed((Object) l4)) || (i4 & 48) == 32) | composer2.changedInstance(yearRange) | ((((i4 & 7168) ^ 3072) > 2048 && composer2.changed(r9)) || (i4 & 3072) == 2048);
        if ((((57344 & i4) ^ 24576) > 16384 && composer2.changed((Object) allDates)) || (i4 & 24576) == 16384) {
            z = true;
        }
        boolean changedInstance2 = changedInstance | z | composer2.changedInstance(defaultLocale);
        Object rememberedValue = composer2.rememberedValue();
        if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DatePickerKt$rememberDatePickerState$1$1(l3, l4, yearRange, r9, allDates, defaultLocale);
            composer2.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) rememberedValue, composer2, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerStateImpl;
    }

    /* renamed from: DatePickerState-sHin3Bw$default  reason: not valid java name */
    public static /* synthetic */ DatePickerState m1986DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = l;
        }
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 16) != 0) {
            i = DisplayMode.Companion.m2031getPickerjFl4v0();
        }
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        int i3 = i;
        SelectableDates selectableDates2 = selectableDates;
        return m1985DatePickerStatesHin3Bw(locale, l, l2, intRange, i3, selectableDates2);
    }

    /* renamed from: DatePickerState-sHin3Bw  reason: not valid java name */
    public static final DatePickerState m1985DatePickerStatesHin3Bw(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, (DefaultConstructorMarker) null);
    }

    /* renamed from: DateEntryContainer-au3_HiA  reason: not valid java name */
    public static final void m1983DateEntryContainerau3_HiA(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, DatePickerColors datePickerColors, TextStyle textStyle, float f, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        DatePickerColors datePickerColors2;
        TextStyle textStyle2;
        Composer composer2;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1507356255);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1303@60987L1775:DatePicker.kt#uh7d8r");
        Modifier modifier2 = modifier;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            function25 = function2;
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        } else {
            function25 = function2;
        }
        if ((i3 & 384) == 0) {
            function26 = function22;
            i2 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        } else {
            function26 = function22;
        }
        if ((i3 & 3072) == 0) {
            function27 = function23;
            i2 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function23;
        }
        if ((i3 & 24576) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 16384 : 8192;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((196608 & i3) == 0) {
            textStyle2 = textStyle;
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed(f) ? 1048576 : 524288;
        } else {
            float f2 = f;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function28) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, i2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1302)");
            }
            Modifier r0 = BackgroundKt.m248backgroundbw27NRU$default(SemanticsModifierKt.semantics$default(SizeKt.m849sizeInqDBjuR0$default(modifier2, DatePickerModalTokens.INSTANCE.m3163getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, (Object) null), false, DatePickerKt$DateEntryContainer$1.INSTANCE, 1, (Object) null), datePickerColors2.m1954getContainerColor0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
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
            Composer r13 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r13, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r13, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r13.getInserting() || !Intrinsics.areEqual(r13.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r13.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r13, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 133224346, "C1319@61556L1182,1313@61306L1432,1345@62747L9:DatePicker.kt#uh7d8r");
            Composer composer3 = startRestartGroup;
            m1984DatePickerHeaderpc5RIQQ(Modifier.Companion, function2, datePickerColors2.m1973getTitleContentColor0d7_KjU(), datePickerColors2.m1966getHeadlineContentColor0d7_KjU(), f, ComposableLambdaKt.rememberComposableLambda(-229007058, true, new DatePickerKt$DateEntryContainer$2$1(function26, function27, function25, datePickerColors2, textStyle2), startRestartGroup, 54), composer3, (i2 & 112) | 196614 | (57344 & (i2 >> 6)));
            composer2 = composer3;
            function28.invoke(composer2, Integer.valueOf((i2 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DateEntryContainer$3(modifier, function2, function22, function23, datePickerColors, textStyle, f, function28, i3));
        }
    }

    /* renamed from: DisplayModeToggleButton-tER2X8s  reason: not valid java name */
    public static final void m1987DisplayModeToggleButtontER2X8s(Modifier modifier, int i, Function1<? super DisplayMode, Unit> function1, Composer composer, int i2) {
        int i3;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(1393846115);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1355)");
            }
            boolean z = true;
            if (DisplayMode.m2026equalsimpl0(i, DisplayMode.Companion.m2031getPickerjFl4v0())) {
                startRestartGroup.startReplaceGroup(-411460444);
                ComposerKt.sourceInformation(startRestartGroup, "1357@63035L42,1357@63014L262");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -428914158, "CC(remember):DatePicker.kt#9igjgp");
                if ((i3 & 896) != 256) {
                    z = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DatePickerKt$DisplayModeToggleButton$1$1(function1);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                modifier2 = modifier;
                IconButtonKt.IconButton((Function0) rememberedValue, modifier2, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1918getLambda1$material3_release(), startRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-411178437);
                ComposerKt.sourceInformation(startRestartGroup, "1364@63319L43,1364@63298L271");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -428905069, "CC(remember):DatePicker.kt#9igjgp");
                if ((i3 & 896) != 256) {
                    z = false;
                }
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new DatePickerKt$DisplayModeToggleButton$2$1(function1);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                modifier2 = modifier;
                IconButtonKt.IconButton((Function0) rememberedValue2, modifier2, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1919getLambda2$material3_release(), startRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DisplayModeToggleButton$3(modifier2, i, function1, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: SwitchableDateEntryContent-d7iavvg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1988SwitchableDateEntryContentd7iavvg(java.lang.Long r19, long r20, int r22, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r24, androidx.compose.material3.internal.CalendarModel r25, kotlin.ranges.IntRange r26, androidx.compose.material3.DatePickerFormatter r27, androidx.compose.material3.SelectableDates r28, androidx.compose.material3.DatePickerColors r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            r8 = r27
            r12 = r31
            r0 = -895379221(0xffffffffcaa198eb, float:-5295221.5)
            r1 = r30
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwitchableDateEntryContent)P(8,4,3:c#material3.DisplayMode,5,6!1,9,2,7)*1393@64365L7,1401@64621L2301,1445@66979L1081,1394@64401L3659:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r12 & 6
            if (r1 != 0) goto L_0x0023
            r1 = r19
            boolean r2 = r11.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0020
            r2 = 4
            goto L_0x0021
        L_0x0020:
            r2 = 2
        L_0x0021:
            r2 = r2 | r12
            goto L_0x0026
        L_0x0023:
            r1 = r19
            r2 = r12
        L_0x0026:
            r3 = r12 & 48
            if (r3 != 0) goto L_0x0039
            r3 = r20
            boolean r5 = r11.changed((long) r3)
            if (r5 == 0) goto L_0x0035
            r5 = 32
            goto L_0x0037
        L_0x0035:
            r5 = 16
        L_0x0037:
            r2 = r2 | r5
            goto L_0x003b
        L_0x0039:
            r3 = r20
        L_0x003b:
            r5 = r12 & 384(0x180, float:5.38E-43)
            r13 = r22
            if (r5 != 0) goto L_0x004d
            boolean r5 = r11.changed((int) r13)
            if (r5 == 0) goto L_0x004a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r2 = r2 | r5
        L_0x004d:
            r5 = r12 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0060
            r5 = r23
            boolean r6 = r11.changedInstance(r5)
            if (r6 == 0) goto L_0x005c
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x005e
        L_0x005c:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x005e:
            r2 = r2 | r6
            goto L_0x0062
        L_0x0060:
            r5 = r23
        L_0x0062:
            r6 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0075
            r6 = r24
            boolean r7 = r11.changedInstance(r6)
            if (r7 == 0) goto L_0x0071
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0073
        L_0x0071:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0073:
            r2 = r2 | r7
            goto L_0x0077
        L_0x0075:
            r6 = r24
        L_0x0077:
            r7 = 196608(0x30000, float:2.75506E-40)
            r7 = r7 & r12
            if (r7 != 0) goto L_0x008b
            r7 = r25
            boolean r9 = r11.changedInstance(r7)
            if (r9 == 0) goto L_0x0087
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0089
        L_0x0087:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x0089:
            r2 = r2 | r9
            goto L_0x008d
        L_0x008b:
            r7 = r25
        L_0x008d:
            r9 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 & r12
            if (r9 != 0) goto L_0x00a1
            r9 = r26
            boolean r10 = r11.changedInstance(r9)
            if (r10 == 0) goto L_0x009d
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x009f
        L_0x009d:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x009f:
            r2 = r2 | r10
            goto L_0x00a3
        L_0x00a1:
            r9 = r26
        L_0x00a3:
            r10 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00be
            r10 = 16777216(0x1000000, float:2.3509887E-38)
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00b2
            boolean r10 = r11.changed((java.lang.Object) r8)
            goto L_0x00b6
        L_0x00b2:
            boolean r10 = r11.changedInstance(r8)
        L_0x00b6:
            if (r10 == 0) goto L_0x00bb
            r10 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00bd
        L_0x00bb:
            r10 = 4194304(0x400000, float:5.877472E-39)
        L_0x00bd:
            r2 = r2 | r10
        L_0x00be:
            r10 = 100663296(0x6000000, float:2.4074124E-35)
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00d2
            r10 = r28
            boolean r14 = r11.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x00ce
            r14 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00d0
        L_0x00ce:
            r14 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00d0:
            r2 = r2 | r14
            goto L_0x00d4
        L_0x00d2:
            r10 = r28
        L_0x00d4:
            r14 = 805306368(0x30000000, float:4.656613E-10)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00e8
            r14 = r29
            boolean r15 = r11.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00e4
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00e6
        L_0x00e4:
            r15 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00e6:
            r2 = r2 | r15
            goto L_0x00ea
        L_0x00e8:
            r14 = r29
        L_0x00ea:
            r15 = r2
            r2 = 306783379(0x12492493, float:6.34695E-28)
            r2 = r2 & r15
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r0) goto L_0x0101
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            r11.skipToGroupEnd()
            r8 = r11
            goto L_0x01af
        L_0x0101:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0110
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1390)"
            r1 = -895379221(0xffffffffcaa198eb, float:-5295221.5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r15, r0, r2)
        L_0x0110:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 48
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r1)
            int r0 = r0.m7086roundToPx0680j_4(r1)
            int r0 = -r0
            androidx.compose.material3.DisplayMode r16 = androidx.compose.material3.DisplayMode.m2023boximpl(r13)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1 r2 = androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = 0
            r4 = 0
            r12 = 1
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r4, r2, r12, r3)
            r1 = -742574493(0xffffffffd3bd3663, float:-1.62532255E12)
            java.lang.String r2 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            boolean r1 = r11.changed((int) r0)
            java.lang.Object r2 = r11.rememberedValue()
            if (r1 != 0) goto L_0x0160
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x016b
        L_0x0160:
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1 r1 = new androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1
            r1.<init>(r0)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r11.updateRememberedValue(r2)
        L_0x016b:
            r18 = r2
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3 r0 = new androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
            r1 = r19
            r2 = r20
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            r9 = r10
            r10 = r14
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10)
            r1 = 54
            r2 = -459778869(0xffffffffe49854cb, float:-2.248012E22)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r12, r0, r11, r1)
            r7 = r0
            kotlin.jvm.functions.Function4 r7 = (kotlin.jvm.functions.Function4) r7
            int r0 = r15 >> 6
            r0 = r0 & 14
            r1 = 1597440(0x186000, float:2.23849E-39)
            r9 = r0 | r1
            r10 = 40
            r4 = 0
            java.lang.String r5 = "DatePickerDisplayModeAnimation"
            r6 = 0
            r8 = r11
            r1 = r16
            r2 = r17
            r3 = r18
            androidx.compose.animation.AnimatedContentKt.AnimatedContent(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01af
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01af:
            androidx.compose.runtime.ScopeUpdateScope r14 = r8.endRestartGroup()
            if (r14 == 0) goto L_0x01d4
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4 r0 = new androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4
            r1 = r19
            r2 = r20
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r12 = r31
            r4 = r13
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x01d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.m1988SwitchableDateEntryContentd7iavvg(java.lang.Long, long, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.material3.internal.CalendarModel, kotlin.ranges.IntRange, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DatePickerContent(java.lang.Long r31, long r32, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r34, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r35, androidx.compose.material3.internal.CalendarModel r36, kotlin.ranges.IntRange r37, androidx.compose.material3.DatePickerFormatter r38, androidx.compose.material3.SelectableDates r39, androidx.compose.material3.DatePickerColors r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r1 = r32
            r6 = r36
            r7 = r37
            r8 = r38
            r10 = r40
            r0 = r42
            r3 = -434467002(0xffffffffe61a8f46, float:-1.8247184E23)
            r4 = r41
            androidx.compose.runtime.Composer r12 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(DatePickerContent)P(7,3,4,5!1,8,2,6)1488@68600L87,1489@68713L24,1490@68767L42,1491@68834L15,1492@68854L5031:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = r0 & 6
            if (r4 != 0) goto L_0x002b
            r4 = r31
            boolean r9 = r12.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0028
            r9 = 4
            goto L_0x0029
        L_0x0028:
            r9 = 2
        L_0x0029:
            r9 = r9 | r0
            goto L_0x002e
        L_0x002b:
            r4 = r31
            r9 = r0
        L_0x002e:
            r11 = r0 & 48
            if (r11 != 0) goto L_0x003e
            boolean r11 = r12.changed((long) r1)
            if (r11 == 0) goto L_0x003b
            r11 = 32
            goto L_0x003d
        L_0x003b:
            r11 = 16
        L_0x003d:
            r9 = r9 | r11
        L_0x003e:
            r11 = r0 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0051
            r11 = r34
            boolean r13 = r12.changedInstance(r11)
            if (r13 == 0) goto L_0x004d
            r13 = 256(0x100, float:3.59E-43)
            goto L_0x004f
        L_0x004d:
            r13 = 128(0x80, float:1.794E-43)
        L_0x004f:
            r9 = r9 | r13
            goto L_0x0053
        L_0x0051:
            r11 = r34
        L_0x0053:
            r13 = r0 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x0066
            r13 = r35
            boolean r14 = r12.changedInstance(r13)
            if (r14 == 0) goto L_0x0062
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r9 = r9 | r14
            goto L_0x0068
        L_0x0066:
            r13 = r35
        L_0x0068:
            r14 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x0078
            boolean r14 = r12.changedInstance(r6)
            if (r14 == 0) goto L_0x0075
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0077
        L_0x0075:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0077:
            r9 = r9 | r14
        L_0x0078:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r0
            if (r14 != 0) goto L_0x0089
            boolean r14 = r12.changedInstance(r7)
            if (r14 == 0) goto L_0x0086
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0088
        L_0x0086:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x0088:
            r9 = r9 | r14
        L_0x0089:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r0
            if (r14 != 0) goto L_0x00a4
            r14 = 2097152(0x200000, float:2.938736E-39)
            r14 = r14 & r0
            if (r14 != 0) goto L_0x0098
            boolean r14 = r12.changed((java.lang.Object) r8)
            goto L_0x009c
        L_0x0098:
            boolean r14 = r12.changedInstance(r8)
        L_0x009c:
            if (r14 == 0) goto L_0x00a1
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00a3
        L_0x00a1:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00a3:
            r9 = r9 | r14
        L_0x00a4:
            r14 = 12582912(0xc00000, float:1.7632415E-38)
            r14 = r14 & r0
            if (r14 != 0) goto L_0x00b8
            r14 = r39
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b4
            r15 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b6
        L_0x00b4:
            r15 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b6:
            r9 = r9 | r15
            goto L_0x00ba
        L_0x00b8:
            r14 = r39
        L_0x00ba:
            r15 = 100663296(0x6000000, float:2.4074124E-35)
            r15 = r15 & r0
            if (r15 != 0) goto L_0x00cb
            boolean r15 = r12.changed((java.lang.Object) r10)
            if (r15 == 0) goto L_0x00c8
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00ca
        L_0x00c8:
            r15 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00ca:
            r9 = r9 | r15
        L_0x00cb:
            r15 = 38347923(0x2492493, float:1.4777644E-37)
            r15 = r15 & r9
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r15 != r5) goto L_0x00e0
            boolean r5 = r12.getSkipping()
            if (r5 != 0) goto L_0x00db
            goto L_0x00e0
        L_0x00db:
            r12.skipToGroupEnd()
            goto L_0x0531
        L_0x00e0:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00ec
            r5 = -1
            java.lang.String r15 = "androidx.compose.material3.DatePickerContent (DatePicker.kt:1485)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r9, r5, r15)
        L_0x00ec:
            androidx.compose.material3.internal.CalendarMonth r3 = r6.getMonth((long) r1)
            int r5 = r3.indexIn(r7)
            r15 = 0
            r0 = 2
            androidx.compose.foundation.lazy.LazyListState r5 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r5, r15, r12, r15, r0)
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r15 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r15)
            r0 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r15 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r15)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L_0x0127
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r12)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r15 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r15.<init>(r0)
            r12.updateRememberedValue(r15)
            r0 = r15
        L_0x0127:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r15 = 0
            java.lang.Object[] r11 = new java.lang.Object[r15]
            androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2 r16 = androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2.INSTANCE
            kotlin.jvm.functions.Function0 r16 = (kotlin.jvm.functions.Function0) r16
            r14 = r16
            r16 = 3072(0xc00, float:4.305E-42)
            r17 = 6
            r18 = r12
            r12 = 0
            r13 = 0
            r1 = r15
            r15 = r18
            java.lang.Object r2 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r11, r12, (java.lang.String) r13, r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            r12 = r15
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            java.util.Locale r11 = androidx.compose.material3.CalendarLocale_androidKt.defaultLocale(r12, r1)
            r13 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            java.lang.String r14 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r14)
            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            androidx.compose.foundation.layout.Arrangement r16 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r13 = r16.getTop()
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            r20 = r3
            androidx.compose.ui.Alignment$Horizontal r3 = r16.getStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r13, r3, r12, r1)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r4)
            int r16 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r1)
            androidx.compose.runtime.CompositionLocalMap r13 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r15 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r12, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r1 = r19.getConstructor()
            r7 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r6 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r7, r6)
            androidx.compose.runtime.Applier r7 = r12.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x019d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x019d:
            r12.startReusableNode()
            boolean r7 = r12.getInserting()
            if (r7 == 0) goto L_0x01aa
            r12.createNode(r1)
            goto L_0x01ad
        L_0x01aa:
            r12.useNode()
        L_0x01ad:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3675constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r3, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r13, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r7 = r1.getInserting()
            if (r7 != 0) goto L_0x01dd
            java.lang.Object r7 = r1.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r7 != 0) goto L_0x01eb
        L_0x01dd:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)
            r1.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)
            r1.apply(r7, r3)
        L_0x01eb:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r15, r3)
            r1 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            java.lang.String r3 = "C87@4365L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r3)
            androidx.compose.foundation.layout.ColumnScopeInstance r7 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r7 = (androidx.compose.foundation.layout.ColumnScope) r7
            r7 = -1437690694(0xffffffffaa4e94ba, float:-1.8348075E-13)
            java.lang.String r13 = "C1503@69381L511,1515@69926L520,1527@70488L42,1493@68871L1698,1531@70579L3300:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r7, r13)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            float r13 = DatePickerHorizontalPadding
            r15 = 0
            r1 = 0
            r16 = r9
            r9 = 2
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m777paddingVpY3zN4$default(r7, r13, r15, r9, r1)
            boolean r10 = r5.getCanScrollForward()
            boolean r9 = r5.getCanScrollBackward()
            boolean r19 = DatePickerContent$lambda$8(r2)
            java.lang.Long r15 = java.lang.Long.valueOf(r32)
            java.lang.String r11 = r8.formatMonthYear(r15, r11)
            if (r11 != 0) goto L_0x022f
            java.lang.String r11 = "-"
        L_0x022f:
            r15 = 230729368(0xdc0a698, float:1.187302E-30)
            java.lang.String r1 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r15, r1)
            boolean r15 = r12.changedInstance(r0)
            boolean r22 = r12.changed((java.lang.Object) r5)
            r15 = r15 | r22
            r22 = r7
            java.lang.Object r7 = r12.rememberedValue()
            if (r15 != 0) goto L_0x0251
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r7 != r15) goto L_0x025b
        L_0x0251:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1 r7 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1
            r7.<init>(r0, r5)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r12.updateRememberedValue(r7)
        L_0x025b:
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r15 = 230746817(0xdc0eac1, float:1.18894285E-30)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r15, r1)
            boolean r15 = r12.changedInstance(r0)
            boolean r23 = r12.changed((java.lang.Object) r5)
            r15 = r15 | r23
            r23 = r7
            java.lang.Object r7 = r12.rememberedValue()
            if (r15 != 0) goto L_0x0280
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r7 != r15) goto L_0x028a
        L_0x0280:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1 r7 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1
            r7.<init>(r0, r5)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r12.updateRememberedValue(r7)
        L_0x028a:
            r15 = r7
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r7 = 230764323(0xdc12f23, float:1.1905891E-30)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r7, r1)
            boolean r1 = r12.changed((java.lang.Object) r2)
            java.lang.Object r7 = r12.rememberedValue()
            if (r1 != 0) goto L_0x02a8
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r7 != r1) goto L_0x02b3
        L_0x02a8:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1 r1 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1
            r1.<init>(r2)
            r7 = r1
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r12.updateRememberedValue(r7)
        L_0x02b3:
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r16 & r1
            r18 = r12
            r12 = r19
            r24 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r19 = r1 | 6
            r17 = r16
            r16 = r7
            r7 = r17
            r17 = r40
            r21 = r0
            r0 = r13
            r13 = r11
            r11 = r9
            r9 = r22
            r22 = r1
            r1 = r14
            r14 = r23
            r23 = r2
            r2 = r24
            MonthsNavigation(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r10 = r17
            r12 = r18
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r11 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r9, r11)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getTopStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r11, r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r4)
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r15)
            androidx.compose.runtime.CompositionLocalMap r14 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r12, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            r2 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r6)
            androidx.compose.runtime.Applier r2 = r12.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0321
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0321:
            r12.startReusableNode()
            boolean r2 = r12.getInserting()
            if (r2 == 0) goto L_0x032e
            r12.createNode(r15)
            goto L_0x0331
        L_0x032e:
            r12.useNode()
        L_0x0331:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m3675constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r11, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r14, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            boolean r14 = r2.getInserting()
            if (r14 != 0) goto L_0x0361
            java.lang.Object r14 = r2.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r13)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 != 0) goto L_0x036f
        L_0x0361:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)
            r2.updateRememberedValue(r14)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r2.apply(r13, r11)
        L_0x036f:
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r9, r11)
            r2 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r9 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r9)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = 2145148451(0x7fdc5e23, float:NaN)
            java.lang.String r9 = "C1532@70597L683,1551@71579L2290,1546@71320L2549:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r9)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r9 = 0
            r11 = 2
            r13 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m777paddingVpY3zN4$default(r2, r0, r9, r11, r13)
            r2 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r1)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r1 = r1.getTop()
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r1, r2, r12, r15)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r4)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r15)
            androidx.compose.runtime.CompositionLocalMap r4 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r12, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r11, r6)
            androidx.compose.runtime.Applier r6 = r12.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x03d7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03d7:
            r12.startReusableNode()
            boolean r6 = r12.getInserting()
            if (r6 == 0) goto L_0x03e4
            r12.createNode(r9)
            goto L_0x03e7
        L_0x03e4:
            r12.useNode()
        L_0x03e7:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r1, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r6.getInserting()
            if (r4 != 0) goto L_0x0417
            java.lang.Object r4 = r6.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r4 != 0) goto L_0x0425
        L_0x0417:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r6.updateRememberedValue(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.apply(r2, r1)
        L_0x0425:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r0, r1)
            r0 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r3)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 454425903(0x1b15fd2f, float:1.2406799E-22)
            java.lang.String r1 = "C1533@70693L31,1534@70741L525:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r1)
            int r0 = r7 >> 24
            r0 = r0 & 14
            int r1 = r7 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r6 = r36
            WeekDays(r10, r6, r12, r0)
            int r0 = r7 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r1 = r7 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r7
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r7
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r7
            r0 = r0 | r1
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r7
            r0 = r0 | r1
            r13 = r0 | r22
            r4 = r31
            r3 = r5
            r7 = r6
            r9 = r8
            r11 = r10
            r5 = r34
            r6 = r35
            r8 = r37
            r10 = r39
            HorizontalMonthsList(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r5 = r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r12.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            boolean r11 = DatePickerContent$lambda$8(r23)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            r18 = 15
            r19 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            androidx.compose.animation.EnterTransition r0 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r14, r15, r16, r17, r18, r19)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r14 = 1
            r2 = 0
            androidx.compose.animation.EnterTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r2, r1, r14, r2)
            androidx.compose.animation.EnterTransition r15 = r0.plus(r1)
            r29 = 15
            r30 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r25, r26, r27, r28, r29, r30)
            r1 = 3
            r9 = 0
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r2, r9, r1, r2)
            androidx.compose.animation.ExitTransition r16 = r0.plus(r1)
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2 r0 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2
            r1 = r32
            r9 = r36
            r6 = r37
            r8 = r39
            r10 = r40
            r7 = r20
            r4 = r21
            r3 = r23
            r0.<init>(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 54
            r2 = 1193716082(0x4726a972, float:42665.445)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r14, r0, r12, r1)
            r9 = r0
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r4 = r11
            r11 = 200112(0x30db0, float:2.80417E-40)
            r18 = r12
            r12 = 16
            r8 = 0
            r5 = r13
            r6 = r15
            r7 = r16
            r10 = r18
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r4, (androidx.compose.ui.Modifier) r5, (androidx.compose.animation.EnterTransition) r6, (androidx.compose.animation.ExitTransition) r7, (java.lang.String) r8, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            r12 = r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r12.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r12.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0531
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0531:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 == 0) goto L_0x0555
            androidx.compose.material3.DatePickerKt$DatePickerContent$2 r0 = new androidx.compose.material3.DatePickerKt$DatePickerContent$2
            r1 = r31
            r2 = r32
            r4 = r34
            r5 = r35
            r6 = r36
            r7 = r37
            r8 = r38
            r9 = r39
            r10 = r40
            r11 = r42
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0555:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePickerContent(java.lang.Long, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.material3.internal.CalendarModel, kotlin.ranges.IntRange, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void DatePickerContent$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: DatePickerHeader-pc5RIQQ  reason: not valid java name */
    public static final void m1984DatePickerHeaderpc5RIQQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        Modifier modifier3 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        float f2 = f;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-996037719);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1609@74344L539:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 32 : 16;
        }
        long j3 = j;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 256 : 128;
        }
        long j4 = j2;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1601)");
            }
            if (function23 != null) {
                modifier2 = SizeKt.m830defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f2, 1, (Object) null);
            } else {
                modifier2 = Modifier.Companion;
            }
            Modifier then = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null).then(modifier2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i4 = i2;
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
            Updater.m3682setimpl(r1, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r1, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1243392968, "C1619@74785L92:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceGroup(594298678);
            ComposerKt.sourceInformation(startRestartGroup, "1614@74573L5,1615@74677L89,1615@74591L175");
            if (function23 != null) {
                ProvideContentColorTextStyleKt.m2920ProvideContentColorTextStyle3JVO9M(j3, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont(), startRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1936268514, true, new DatePickerKt$DatePickerHeader$1$1(function23), startRestartGroup, 54), startRestartGroup, ((i4 >> 6) & 14) | 384);
            }
            startRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j4)), function24, startRestartGroup, ProvidedValue.$stable | ((i4 >> 12) & 112));
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
            endRestartGroup.updateScope(new DatePickerKt$DatePickerHeader$2(modifier, function23, j, j4, f2, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void HorizontalMonthsList(LazyListState lazyListState, Long l, Function1<? super Long, Unit> function1, Function1<? super Long, Unit> function12, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Long l2;
        Function1<? super Long, Unit> function13;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        Function2 function2;
        LazyListState lazyListState2 = lazyListState;
        CalendarModel calendarModel2 = calendarModel;
        IntRange intRange2 = intRange;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1994757941);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalMonthsList)P(3,7,4,5!1,8,2,6)1639@75443L158,1645@75663L5,1645@75670L1365,1645@75606L1429,1676@77071L228,1676@77041L258:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) lazyListState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            l2 = l;
            i2 |= startRestartGroup.changed((Object) l2) ? 32 : 16;
        } else {
            l2 = l;
        }
        if ((i3 & 384) == 0) {
            function13 = function1;
            i2 |= startRestartGroup.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        Function1<? super Long, Unit> function14 = function12;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function14) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= (2097152 & i3) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 8388608 : 4194304;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((100663296 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994757941, i2, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1636)");
            }
            CalendarDate today = calendarModel2.getToday();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1217547306, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) intRange2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel2.getMonth(intRange2.getFirst(), 1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            DatePickerColors datePickerColors3 = datePickerColors2;
            SelectableDates selectableDates3 = selectableDates2;
            DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
            Long l3 = l2;
            CalendarMonth calendarMonth = (CalendarMonth) rememberedValue;
            int i4 = i2;
            IntRange intRange3 = intRange;
            IntRange intRange4 = intRange3;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), startRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1504086906, true, new DatePickerKt$HorizontalMonthsList$1(lazyListState2, intRange3, calendarModel2, calendarMonth, function13, today, l3, datePickerFormatter3, selectableDates3, datePickerColors3), startRestartGroup, 54), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1217495140, "CC(remember):DatePicker.kt#9igjgp");
            int i5 = i4 & 14;
            boolean changedInstance = (i5 == 4) | ((i4 & 7168) == 2048) | startRestartGroup.changedInstance(calendarModel2) | startRestartGroup.changedInstance(intRange4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                lazyListState2 = lazyListState;
                function2 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState2, function14, calendarModel2, intRange4, (Continuation<? super DatePickerKt$HorizontalMonthsList$2$1>) null);
                startRestartGroup.updateRememberedValue(function2);
            } else {
                function2 = rememberedValue2;
                lazyListState2 = lazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect((Object) lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2, startRestartGroup, i5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$HorizontalMonthsList$3(lazyListState2, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    public static final Object updateDisplayedMonth(LazyListState lazyListState, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new DatePickerKt$updateDisplayedMonth$2(lazyListState)).collect(new DatePickerKt$updateDisplayedMonth$3(lazyListState, function1, calendarModel, intRange), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final void WeekDays(DatePickerColors datePickerColors, CalendarModel calendarModel, Composer composer, int i) {
        int i2;
        Composer composer2;
        DatePickerColors datePickerColors2 = datePickerColors;
        CalendarModel calendarModel2 = calendarModel;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation(startRestartGroup, "C(WeekDays)P(1)1719@78602L5,1721@78613L974:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) datePickerColors2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i2, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1708)");
            }
            int firstDayOfWeek = calendarModel2.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel2.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i4 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i5 = i4; i5 < size; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            boolean z = false;
            for (int i6 = 0; i6 < i4; i6++) {
                arrayList.add(weekdayNames.get(i6));
            }
            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), startRestartGroup, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m830defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, RecommendedSizeForAccessibility, 1, (Object) null), 0.0f, 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), centerVertically, startRestartGroup, 54);
            int i7 = -1323940314;
            String str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            String str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r10 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r10, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r10, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -603629529, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceGroup(396170355);
            ComposerKt.sourceInformation(startRestartGroup, "*1730@78979L33,1728@78897L674");
            List list = arrayList;
            int size2 = list.size();
            int i8 = 0;
            while (i8 < size2) {
                Pair pair = (Pair) list.get(i8);
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1458727475, "CC(remember):DatePicker.kt#9igjgp");
                boolean changed = startRestartGroup.changed((Object) pair);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DatePickerKt$WeekDays$1$1$1$1(pair);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) rememberedValue);
                float f = RecommendedSizeForAccessibility;
                Modifier r11 = SizeKt.m847sizeVpY3zN4(clearAndSetSemantics, f, f);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, z);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, i7, str);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, z ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r11);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r7, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r7, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r7.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r7, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 87052400, "C1737@79293L264:DatePicker.kt#uh7d8r");
                Composer composer3 = startRestartGroup;
                TextKt.m2692Text4IGK_g((String) pair.getSecond(), SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), datePickerColors2.m1976getWeekdayContentColor0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m6979boximpl(TextAlign.Companion.m6986getCentere0LSkKk()), 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, value, composer3, 48, 0, 65016);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                i8++;
                startRestartGroup = composer3;
                str = str;
                i7 = -1323940314;
                z = false;
                size2 = size2;
                str2 = str2;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$WeekDays$2(datePickerColors2, calendarModel2, i3));
        }
    }

    public static final void Month(CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, long j, Long l, Long l2, SelectedRangeInfo selectedRangeInfo, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        CalendarMonth calendarMonth2;
        Composer composer2;
        Modifier modifier;
        String str;
        int i3;
        String str2;
        int i4;
        String str3;
        String str4;
        int i5;
        Composer composer3;
        String str5;
        Locale locale;
        int i6;
        boolean z;
        boolean z2;
        char c;
        Locale locale2;
        MutableState mutableState;
        boolean z3;
        Function1<? super Long, Unit> function12 = function1;
        long j2 = j;
        Long l3 = l;
        Long l4 = l2;
        SelectedRangeInfo selectedRangeInfo2 = selectedRangeInfo;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        SelectableDates selectableDates2 = selectableDates;
        DatePickerColors datePickerColors2 = datePickerColors;
        int i7 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1912870997);
        ComposerKt.sourceInformation(startRestartGroup, "C(Month)P(3,4,8,7,2,5,1,6)1773@80392L15,1775@80434L5256:DatePicker.kt#uh7d8r");
        if ((i7 & 6) == 0) {
            calendarMonth2 = calendarMonth;
            i2 = (startRestartGroup.changed((Object) calendarMonth2) ? 4 : 2) | i7;
        } else {
            calendarMonth2 = calendarMonth;
            i2 = i7;
        }
        if ((i7 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i7 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) l3) ? 2048 : 1024;
        }
        if ((i7 & 24576) == 0) {
            i2 |= startRestartGroup.changed((Object) l4) ? 16384 : 8192;
        }
        if ((196608 & i7) == 0) {
            i2 |= startRestartGroup.changed((Object) selectedRangeInfo2) ? 131072 : 65536;
        }
        if ((1572864 & i7) == 0) {
            i2 |= (2097152 & i7) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 1048576 : 524288;
        }
        if ((12582912 & i7) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 8388608 : 4194304;
        }
        if ((100663296 & i7) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912870997, i2, -1, "androidx.compose.material3.Month (DatePicker.kt:1762)");
            }
            startRestartGroup.startReplaceGroup(1821406531);
            ComposerKt.sourceInformation(startRestartGroup, "1765@80175L143");
            String str6 = "CC(remember):DatePicker.kt#9igjgp";
            if (selectedRangeInfo2 != null) {
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1821408684, str6);
                boolean z4 = ((i2 & 458752) == 131072) | ((i2 & 234881024) == 67108864);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DatePickerKt$Month$rangeSelectionDrawModifier$1$1(selectedRangeInfo2, datePickerColors2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                modifier = DrawModifierKt.drawWithContent(modifier2, (Function1) rememberedValue);
            } else {
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceGroup();
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(startRestartGroup, 0);
            Modifier then = SizeKt.m834requiredHeight3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(RecommendedSizeForAccessibility * ((float) 6))).then(modifier);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.Companion.getStart(), startRestartGroup, 6);
            String str7 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str7);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            String str8 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str8);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            String str9 = "C:DatePicker.kt#uh7d8r";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1402700144, str9);
            startRestartGroup.startReplaceGroup(-647488269);
            ComposerKt.sourceInformation(startRestartGroup, "*1782@80726L4948");
            int i8 = 0;
            int i9 = 0;
            int i10 = 6;
            while (i8 < i10) {
                int i11 = i8;
                int i12 = i9;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), centerVertically, startRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str7);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str8);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r0 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r0, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r0, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r0.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r0, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1553857275, str9);
                startRestartGroup.startReplaceGroup(-88422904);
                String str10 = "";
                ComposerKt.sourceInformation(startRestartGroup, str10);
                int i13 = i12;
                int i14 = 0;
                while (i14 < 7) {
                    if (i13 < calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth() || i13 >= calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth2.getNumberOfDays()) {
                        str3 = str10;
                        str4 = str9;
                        i4 = i14;
                        str2 = str7;
                        i5 = i13;
                        str = str8;
                        composer3 = startRestartGroup;
                        str5 = str6;
                        i3 = i2;
                        locale = defaultLocale;
                        composer3.startReplaceGroup(1554022070);
                        ComposerKt.sourceInformation(composer3, "1794@81308L315");
                        float f = RecommendedSizeForAccessibility;
                        SpacerKt.Spacer(SizeKt.m839requiredSizeVpY3zN4(Modifier.Companion, f, f), composer3, 6);
                        composer3.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(1554536112);
                        ComposerKt.sourceInformation(startRestartGroup, "1822@82897L365,1838@83755L39,1844@84162L550,1862@85212L376,1835@83586L2002");
                        int daysFromStartOfWeekToFirstOfMonth = i13 - calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth();
                        str3 = str10;
                        str4 = str9;
                        long startUtcTimeMillis = calendarMonth2.getStartUtcTimeMillis() + (((long) daysFromStartOfWeekToFirstOfMonth) * CalendarModelKt.MillisecondsIn24Hours);
                        boolean z5 = startUtcTimeMillis == j;
                        boolean z6 = l != null && startUtcTimeMillis == l.longValue();
                        if (l2 != null && startUtcTimeMillis == l2.longValue()) {
                            i6 = i2;
                            z = true;
                        } else {
                            i6 = i2;
                            z = false;
                        }
                        i4 = i14;
                        startRestartGroup.startReplaceGroup(-88387804);
                        ComposerKt.sourceInformation(startRestartGroup, "1810@82233L435");
                        if (selectedRangeInfo != null) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -88385906, str6);
                            str2 = str7;
                            boolean changed = ((i6 & 458752) == 131072) | startRestartGroup.changed(startUtcTimeMillis);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                if (startUtcTimeMillis >= (l != null ? l.longValue() : Long.MAX_VALUE)) {
                                    if (startUtcTimeMillis <= (l2 != null ? l2.longValue() : Long.MIN_VALUE)) {
                                        z3 = true;
                                        i5 = i13;
                                        c = 2;
                                        mutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                        startRestartGroup.updateRememberedValue(mutableState);
                                    }
                                }
                                z3 = false;
                                i5 = i13;
                                c = 2;
                                mutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(mutableState);
                            } else {
                                mutableState = rememberedValue2;
                                i5 = i13;
                                c = 2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Locale locale3 = defaultLocale;
                            z2 = ((Boolean) mutableState.getValue()).booleanValue();
                            locale2 = locale3;
                        } else {
                            str2 = str7;
                            i5 = i13;
                            c = 2;
                            locale2 = defaultLocale;
                            z2 = false;
                        }
                        startRestartGroup.endReplaceGroup();
                        char c2 = c;
                        str5 = str6;
                        int i15 = i6;
                        Composer composer4 = startRestartGroup;
                        boolean z7 = z6;
                        Locale locale4 = locale2;
                        String dayContentDescription = dayContentDescription(selectedRangeInfo != null, z5, z7, z, z2, composer4, 0);
                        boolean z8 = z2;
                        boolean z9 = z5;
                        Composer composer5 = composer4;
                        boolean z10 = z8;
                        i3 = i15;
                        String formatDate = datePickerFormatter2.formatDate(Long.valueOf(startUtcTimeMillis), locale4, true);
                        if (formatDate == null) {
                            formatDate = str3;
                        }
                        Modifier modifier3 = Modifier.Companion;
                        boolean z11 = z7 || z;
                        ComposerKt.sourceInformationMarkerStart(composer5, -88337598, str5);
                        str = str8;
                        boolean changed2 = ((i3 & 112) == 32) | composer5.changed(startUtcTimeMillis);
                        Object rememberedValue3 = composer5.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new DatePickerKt$Month$1$1$1$1(function12, startUtcTimeMillis);
                            composer5.updateRememberedValue(rememberedValue3);
                        }
                        Function0 function0 = (Function0) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerStart(composer5, -88324063, str5);
                        boolean changed3 = composer5.changed(startUtcTimeMillis);
                        Object rememberedValue4 = composer5.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = Boolean.valueOf(selectableDates2.isSelectableYear(calendarMonth.getYear()) && selectableDates2.isSelectableDate(startUtcTimeMillis));
                            composer5.updateRememberedValue(rememberedValue4);
                        }
                        boolean booleanValue = ((Boolean) rememberedValue4).booleanValue();
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        if (dayContentDescription != null) {
                            formatDate = dayContentDescription + ", " + formatDate;
                        }
                        Composer composer6 = composer5;
                        boolean z12 = z11;
                        boolean z13 = booleanValue;
                        locale = locale4;
                        Day(modifier3, z12, function0, z7, z13, z9, z10, formatDate, datePickerColors, ComposableLambdaKt.rememberComposableLambda(-2095706591, true, new DatePickerKt$Month$1$1$3(daysFromStartOfWeekToFirstOfMonth), composer5, 54), composer6, (i3 & 234881024) | 805306374);
                        composer3 = composer6;
                        composer3.endReplaceGroup();
                    }
                    defaultLocale = locale;
                    i14 = i4 + 1;
                    str6 = str5;
                    startRestartGroup = composer3;
                    str10 = str3;
                    str7 = str2;
                    i2 = i3;
                    str8 = str;
                    calendarMonth2 = calendarMonth;
                    function12 = function1;
                    i13 = i5 + 1;
                    str9 = str4;
                }
                int i16 = i13;
                String str11 = str8;
                Composer composer7 = startRestartGroup;
                String str12 = str6;
                int i17 = i2;
                Locale locale5 = defaultLocale;
                composer7.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                function12 = function1;
                DatePickerColors datePickerColors3 = datePickerColors;
                i8 = i11 + 1;
                i9 = i16;
                str9 = str9;
                calendarMonth2 = calendarMonth;
                i10 = 6;
                str7 = str7;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$Month$2(calendarMonth, function1, j, l, l2, selectedRangeInfo, datePickerFormatter2, selectableDates2, datePickerColors, i));
        }
    }

    public static final int numberOfMonthsInRange(IntRange intRange) {
        return ((intRange.getLast() - intRange.getFirst()) + 1) * 12;
    }

    private static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 502032503, "C(dayContentDescription)P(4,3,2):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1889)");
        }
        StringBuilder sb = new StringBuilder();
        composer.startReplaceGroup(-647758197);
        ComposerKt.sourceInformation(composer, "");
        if (z) {
            if (z3) {
                composer.startReplaceGroup(-647755172);
                ComposerKt.sourceInformation(composer, "1894@86219L56");
                Strings.Companion companion = Strings.Companion;
                sb.append(Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z4) {
                composer.startReplaceGroup(-647751174);
                ComposerKt.sourceInformation(composer, "1896@86344L54");
                Strings.Companion companion2 = Strings.Companion;
                sb.append(Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z5) {
                composer.startReplaceGroup(-647747239);
                ComposerKt.sourceInformation(composer, "1898@86467L53");
                Strings.Companion companion3 = Strings.Companion;
                sb.append(Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_day_in_range), composer, 0));
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1394740614);
                composer.endReplaceGroup();
            }
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-647744489);
        ComposerKt.sourceInformation(composer, "1903@86668L54");
        if (z2) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.Companion;
            sb.append(Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_picker_today_description), composer, 0));
        }
        composer.endReplaceGroup();
        String sb2 = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sb2;
    }

    /* access modifiers changed from: private */
    public static final void Day(Modifier modifier, boolean z, Function0<Unit> function0, boolean z2, boolean z3, boolean z4, boolean z5, String str, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        boolean z6;
        boolean z7;
        boolean z8;
        DatePickerColors datePickerColors2;
        Modifier modifier2 = modifier;
        boolean z9 = z;
        boolean z10 = z4;
        String str2 = str;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1434777861);
        ComposerKt.sourceInformation(startRestartGroup, "C(Day)P(6,8,7!1,4,9,5,3)1931@87580L114,1936@87780L5,1939@87839L83,1943@88006L190,1959@88508L319,1922@87151L1676:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(z9) ? 32 : 16;
        }
        Function0<Unit> function02 = function0;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            z6 = z2;
            i2 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        } else {
            z6 = z2;
        }
        if ((i3 & 24576) == 0) {
            z7 = z3;
            i2 |= startRestartGroup.changed(z7) ? 16384 : 8192;
        } else {
            z7 = z3;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(z10) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            z8 = z5;
            i2 |= startRestartGroup.changed(z8) ? 1048576 : 524288;
        } else {
            z8 = z5;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((805306368 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
        }
        int i4 = i2;
        if ((306783379 & i4) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434777861, i4, -1, "androidx.compose.material3.Day (DatePicker.kt:1921)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 67481739, "CC(remember):DatePicker.kt#9igjgp");
            boolean z11 = (29360128 & i4) == 8388608;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DatePickerKt$Day$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics = SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), startRestartGroup, 6);
            int i5 = i4 >> 3;
            int i6 = i4 >> 15;
            int i7 = i5;
            long r18 = datePickerColors2.dayContainerColor$material3_release(z9, z7, z6, startRestartGroup, (i6 & 7168) | (i5 & 14) | ((i4 >> 9) & 112) | (i5 & 896)).getValue().m4249unboximpl();
            int i8 = i4 >> 12;
            Composer composer2 = startRestartGroup;
            Composer composer3 = composer2;
            Modifier modifier3 = semantics;
            Composer composer4 = composer3;
            SurfaceKt.m2537Surfaced85dljk(z, function0, modifier3, z3, value, r18, datePickerColors.dayContentColor$material3_release(z4, z, z8, z3, composer2, (i6 & 14) | (i4 & 112) | (i8 & 896) | (i7 & 7168) | (i8 & 57344)).getValue().m4249unboximpl(), 0.0f, 0.0f, (!z4 || z) ? null : BorderStrokeKt.m275BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m3168getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.m1975getTodayDateBorderColor0d7_KjU()), (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2031780827, true, new DatePickerKt$Day$2(function22), composer3, 54), composer4, i7 & 7294, 48, 1408);
            startRestartGroup = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$Day$3(modifier2, z, function0, z2, z3, z4, z5, str, datePickerColors, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void YearPicker(Modifier modifier, long j, Function1<? super Integer, Unit> function1, SelectableDates selectableDates, CalendarModel calendarModel, IntRange intRange, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        Function1<? super Integer, Unit> function12;
        SelectableDates selectableDates2;
        CalendarModel calendarModel2;
        IntRange intRange2;
        DatePickerColors datePickerColors2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1286899812);
        ComposerKt.sourceInformation(startRestartGroup, "C(YearPicker)P(3,2,4,5!1,6)1984@89212L5,1984@89219L4227,1984@89138L4308:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i2 = i3;
        }
        long j2 = j;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function12 = function1;
            i2 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        if ((i3 & 3072) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 2048 : 1024;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i3 & 24576) == 0) {
            calendarModel2 = calendarModel;
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 16384 : 8192;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((196608 & i3) == 0) {
            intRange2 = intRange;
            i2 |= startRestartGroup.changedInstance(intRange2) ? 131072 : 65536;
        } else {
            intRange2 = intRange;
        }
        if ((1572864 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 1048576 : 524288;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286899812, i2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1983)");
            }
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), startRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1301915789, true, new DatePickerKt$YearPicker$1(calendarModel2, j2, intRange2, datePickerColors2, modifier2, function12, selectableDates2), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$YearPicker$2(modifier, j, function1, selectableDates, calendarModel, intRange, datePickerColors, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void Year(Modifier modifier, boolean z, boolean z2, Function0<Unit> function0, boolean z3, String str, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        int i3;
        BorderStroke borderStroke;
        Modifier modifier2 = modifier;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        String str2 = str;
        DatePickerColors datePickerColors2 = datePickerColors;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(238547184);
        ComposerKt.sourceInformation(startRestartGroup, "C(Year)P(5,7,2,6,4,3)2079@93760L393,2097@94528L102,2102@94726L5,2103@94756L58,2106@94881L83,2109@95020L106,2090@94158L968:DatePicker.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        } else {
            Function0<Unit> function02 = function0;
        }
        if ((i4 & 24576) == 0) {
            i2 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238547184, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:2077)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1682614743, "CC(remember):DatePicker.kt#9igjgp");
            int i5 = i2 & 112;
            boolean z7 = ((i2 & 896) == 256) | (i5 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.Companion.getEmpty()) {
                if (!z5 || z4) {
                    i3 = i2;
                    borderStroke = null;
                } else {
                    i3 = i2;
                    borderStroke = BorderStrokeKt.m275BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m3168getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors2.m1975getTodayDateBorderColor0d7_KjU());
                }
                startRestartGroup.updateRememberedValue(borderStroke);
            } else {
                borderStroke = rememberedValue;
                i3 = i2;
            }
            BorderStroke borderStroke2 = borderStroke;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1682590458, "CC(remember):DatePicker.kt#9igjgp");
            boolean z8 = (458752 & i3) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new DatePickerKt$Year$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics = SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), startRestartGroup, 6);
            int i6 = i3 >> 3;
            int i7 = i6 & 14;
            int i8 = i3 >> 9;
            long r20 = datePickerColors2.yearContainerColor$material3_release(z4, z6, startRestartGroup, i7 | (i8 & 112) | ((i3 >> 12) & 896)).getValue().m4249unboximpl();
            int i9 = i3 >> 6;
            int i10 = i6;
            Shape shape = value;
            Composer composer2 = startRestartGroup;
            SurfaceKt.m2537Surfaced85dljk(z, function0, semantics, z3, shape, r20, datePickerColors2.yearContentColor$material3_release(z5, z4, z6, startRestartGroup, i5 | (i9 & 14) | (i9 & 896) | (i8 & 7168)).getValue().m4249unboximpl(), 0.0f, 0.0f, borderStroke2, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1573188346, true, new DatePickerKt$Year$2(function22), startRestartGroup, 54), composer2, i7 | (i9 & 112) | (i10 & 7168), 48, 1408);
            startRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$Year$3(modifier2, z, z2, function0, z3, str, datePickerColors, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void MonthsNavigation(Modifier modifier, boolean z, boolean z2, boolean z3, String str, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Function0<Unit> function04;
        DatePickerColors datePickerColors2;
        Arrangement.Horizontal horizontal;
        Modifier modifier2 = modifier;
        boolean z4 = z3;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-773929258);
        ComposerKt.sourceInformation(startRestartGroup, "C(MonthsNavigation)P(1,2,6,8,7,3,4,5)2131@95632L2049:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        boolean z5 = z;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        boolean z6 = z2;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        }
        String str2 = str;
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 16384 : 8192;
        }
        Function0<Unit> function05 = function0;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function05) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        } else {
            Function0<Unit> function06 = function02;
        }
        if ((12582912 & i3) == 0) {
            function04 = function03;
            i2 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        } else {
            function04 = function03;
        }
        if ((100663296 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773929258, i2, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2130)");
            }
            Modifier r0 = SizeKt.m834requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), MonthYearHeight);
            if (z4) {
                horizontal = Arrangement.INSTANCE.getStart();
            } else {
                horizontal = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -857484277, "C2141@96047L1628,2141@95964L1711:DatePicker.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(datePickerColors2.m1967getNavigationContentColor0d7_KjU())), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-962805198, true, new DatePickerKt$MonthsNavigation$1$1(function04, z4, str2, function02, z6, function05, z5), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
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
            endRestartGroup.updateScope(new DatePickerKt$MonthsNavigation$2(modifier, z, z2, z3, str, function0, function02, function03, datePickerColors2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void YearPickerMenuButton(kotlin.jvm.functions.Function0<kotlin.Unit> r19, boolean r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r2 = r20
            r4 = r22
            r5 = r24
            r0 = 409654418(0x186ad492, float:3.0351112E-24)
            r1 = r23
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(YearPickerMenuButton)P(3,1,2)2192@98101L7,2192@98051L58,2195@98166L453,2188@97922L697:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r25 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r5 | 6
            r3 = r1
            r1 = r19
            goto L_0x0032
        L_0x001e:
            r1 = r5 & 6
            if (r1 != 0) goto L_0x002f
            r1 = r19
            boolean r3 = r15.changedInstance(r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r5
            goto L_0x0032
        L_0x002f:
            r1 = r19
            r3 = r5
        L_0x0032:
            r6 = r25 & 2
            if (r6 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x0049
        L_0x0039:
            r6 = r5 & 48
            if (r6 != 0) goto L_0x0049
            boolean r6 = r15.changed((boolean) r2)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
        L_0x0049:
            r6 = r25 & 4
            if (r6 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r7 = r5 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r21
            boolean r8 = r15.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r8
            goto L_0x0065
        L_0x0063:
            r7 = r21
        L_0x0065:
            r8 = r25 & 8
            if (r8 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x006c:
            r8 = r5 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            boolean r8 = r15.changedInstance(r4)
            if (r8 == 0) goto L_0x0079
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r8
        L_0x007c:
            r8 = r3 & 1171(0x493, float:1.641E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r8 != r9) goto L_0x008f
            boolean r8 = r15.getSkipping()
            if (r8 != 0) goto L_0x0089
            goto L_0x008f
        L_0x0089:
            r15.skipToGroupEnd()
        L_0x008c:
            r3 = r7
            goto L_0x0111
        L_0x008f:
            if (r6 == 0) goto L_0x0098
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r18 = r6
            goto L_0x009a
        L_0x0098:
            r18 = r7
        L_0x009a:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00a6
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2187)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r6, r7)
        L_0x00a6:
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            androidx.compose.material3.ButtonDefaults r6 = androidx.compose.material3.ButtonDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r8, r9)
            java.lang.Object r7 = r15.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r9 = r7.m4249unboximpl()
            r16 = 24576(0x6000, float:3.4438E-41)
            r17 = 13
            r7 = 0
            r11 = 0
            r13 = 0
            androidx.compose.material3.ButtonColors r10 = r6.m1772textButtonColorsro_MJ88(r7, r9, r11, r13, r15, r16, r17)
            androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1 r6 = new androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
            r6.<init>(r4, r2)
            r7 = 54
            r8 = 1899012021(0x71309fb5, float:8.74599E29)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r6, r15, r7)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r7 = r3 & 14
            r8 = 807075840(0x301b0000, float:5.638867E-10)
            r7 = r7 | r8
            int r3 = r3 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r17 = r7 | r3
            r7 = r18
            r18 = 388(0x184, float:5.44E-43)
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r9 = r0
            r16 = r15
            r15 = r6
            r6 = r1
            androidx.compose.material3.ButtonKt.TextButton(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r15 = r16
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x008c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x008c
        L_0x0111:
            androidx.compose.runtime.ScopeUpdateScope r7 = r15.endRestartGroup()
            if (r7 == 0) goto L_0x0125
            androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2 r0 = new androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2
            r1 = r19
            r6 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.YearPickerMenuButton(kotlin.jvm.functions.Function0, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyGridState lazyGridState, CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf(new CustomAccessibilityAction(str, new DatePickerKt$customScrollActions$scrollUpAction$1(lazyGridState, coroutineScope)), new CustomAccessibilityAction(str2, new DatePickerKt$customScrollActions$scrollDownAction$1(lazyGridState, coroutineScope)));
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    static {
        float f = (float) 12;
        DatePickerHorizontalPadding = Dp.m7111constructorimpl(f);
        DatePickerModeTogglePadding = PaddingKt.m772PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m7111constructorimpl(f), Dp.m7111constructorimpl(f), 3, (Object) null);
        float f2 = (float) 24;
        float f3 = (float) 16;
        DatePickerTitlePadding = PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl(f2), Dp.m7111constructorimpl(f3), Dp.m7111constructorimpl(f), 0.0f, 8, (Object) null);
        DatePickerHeadlinePadding = PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl(f2), 0.0f, Dp.m7111constructorimpl(f), Dp.m7111constructorimpl(f), 2, (Object) null);
        YearsVerticalPadding = Dp.m7111constructorimpl(f3);
    }
}
