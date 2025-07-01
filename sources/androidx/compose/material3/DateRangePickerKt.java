package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ak\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a°\u0001\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010.\u001a`\u0010/\u001a\u00020\f2\n\u00100\u001a\u000601j\u0002`22\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a½\u0001\u0010:\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010;\u001a\u0002072:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a°\u0001\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010A\u001a.\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010\u000b\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002\u001aT\u0010J\u001a\u00020\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001ae\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001c2\b\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010P\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 H\u0002¢\u0006\u0002\u0010Q\u001a&\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayedMonthMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "displayMode", "SwitchableDateEntryContent-RN-2D1Q", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl((float) 24), Dp.m7111constructorimpl((float) 20), 0.0f, Dp.m7111constructorimpl((float) 8), 4, (Object) null);
    /* access modifiers changed from: private */
    public static final PaddingValues DateRangePickerHeadlinePadding;
    /* access modifiers changed from: private */
    public static final PaddingValues DateRangePickerTitlePadding;
    private static final float HeaderHeightOffset = Dp.m7111constructorimpl((float) 60);

    /* JADX WARNING: Removed duplicated region for block: B:118:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0254  */
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
    public static final void DateRangePicker(androidx.compose.material3.DateRangePickerState r26, androidx.compose.ui.Modifier r27, androidx.compose.material3.DatePickerFormatter r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.material3.DatePickerColors r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r1 = r26
            r0 = r28
            r8 = r34
            r2 = 650830774(0x26cae3b6, float:1.4078287E-15)
            r3 = r33
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(DateRangePicker)P(5,3,1,6,2,4)95@4412L47,96@4500L185,102@4729L352,112@5169L8,114@5206L15,115@5246L62,132@5955L5,136@6111L1139,116@5313L1937:DateRangePicker.kt#uh7d8r"
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
            goto L_0x024e
        L_0x00f1:
            r3.startDefaults()
            r2 = r8 & 1
            r33 = -3670017(0xffffffffffc7ffff, float:NaN)
            java.lang.String r15 = "CC(remember):DateRangePicker.kt#9igjgp"
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
            r2 = -1454781303(0xffffffffa949cc89, float:-4.480837E-14)
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
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$2 r5 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$2
            r5.<init>(r1)
            r7 = -162164694(0xfffffffff655902a, float:-1.0828938E33)
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
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$3 r7 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$3
            r7.<init>(r1, r2)
            r10 = -185279404(0xfffffffff4f4dc54, float:-1.5519888E32)
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
            java.lang.String r7 = "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:113)"
            r12 = 650830774(0x26cae3b6, float:1.4078287E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r5, r6, r7)
        L_0x01ab:
            r6 = 0
            java.util.Locale r6 = androidx.compose.material3.CalendarLocale_androidKt.defaultLocale(r3, r6)
            r7 = -1454754600(0xffffffffa94a34d8, float:-4.4898845E-14)
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
            r6 = -1454747621(0xffffffffa94a501b, float:-4.492249E-14)
            r3.startReplaceGroup(r6)
            java.lang.String r6 = "122@5491L323"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            if (r4 == 0) goto L_0x01f2
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$4 r6 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
            r6.<init>(r1)
            r7 = -1490010652(0xffffffffa7303de4, float:-2.4458458E-15)
            r14 = 54
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r0, r6, r3, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            goto L_0x01f3
        L_0x01f2:
            r6 = 0
        L_0x01f3:
            r3.endReplaceGroup()
            androidx.compose.material3.tokens.DatePickerModalTokens r7 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r7 = r7.getRangeSelectionHeaderHeadlineFont()
            r14 = 6
            androidx.compose.ui.text.TextStyle r7 = androidx.compose.material3.TypographyKt.getValue(r7, r3, r14)
            androidx.compose.material3.tokens.DatePickerModalTokens r14 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r14 = r14.m3173getRangeSelectionHeaderContainerHeightD9Ej5fM()
            float r15 = HeaderHeightOffset
            float r14 = r14 - r15
            float r15 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r14)
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$5 r14 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
            r14.<init>(r1, r12, r2, r13)
            r12 = -57534331(0xfffffffffc921885, float:-6.068581E36)
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
            androidx.compose.material3.DatePickerKt.m1983DateEntryContainerau3_HiA(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0247
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0247:
            r3 = r2
            r6 = r4
            r2 = r9
            r4 = r10
            r7 = r13
            goto L_0x00ee
        L_0x024e:
            androidx.compose.runtime.ScopeUpdateScope r10 = r17.endRestartGroup()
            if (r10 == 0) goto L_0x0262
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$6 r0 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$6
            r1 = r26
            r9 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.DateRangePicker(androidx.compose.material3.DateRangePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: rememberDateRangePickerState-IlFM19s  reason: not valid java name */
    public static final DateRangePickerState m2007rememberDateRangePickerStateIlFM19s(Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        ComposerKt.sourceInformationMarkerStart(composer2, -2012087461, "C(rememberDateRangePickerState)P(3,2,1,5,0:c#material3.DisplayMode)262@11757L15,263@11866L435,263@11784L517:DateRangePicker.kt#uh7d8r");
        Long l4 = (i3 & 1) != 0 ? null : l;
        Long l5 = (i3 & 2) != 0 ? null : l2;
        Long l6 = (i3 & 4) != 0 ? l4 : l3;
        IntRange yearRange = (i3 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        int r10 = (i3 & 16) != 0 ? DisplayMode.Companion.m2031getPickerjFl4v0() : i;
        SelectableDates allDates = (i3 & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012087461, i4, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:261)");
        }
        Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(composer2, 0);
        Object[] objArr = new Object[0];
        Saver<DateRangePickerStateImpl, Object> Saver = DateRangePickerStateImpl.Companion.Saver(allDates, defaultLocale);
        ComposerKt.sourceInformationMarkerStart(composer2, -250595241, "CC(remember):DateRangePicker.kt#9igjgp");
        boolean changedInstance = ((((i4 & 112) ^ 48) > 32 && composer2.changed((Object) l5)) || (i4 & 48) == 32) | ((((i4 & 14) ^ 6) > 4 && composer2.changed((Object) l4)) || (i4 & 6) == 4) | ((((i4 & 896) ^ 384) > 256 && composer2.changed((Object) l6)) || (i4 & 384) == 256) | composer2.changedInstance(yearRange) | ((((57344 & i4) ^ 24576) > 16384 && composer2.changed(r10)) || (i4 & 24576) == 16384) | ((((458752 & i4) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer2.changed((Object) allDates)) || (i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer2.changedInstance(defaultLocale);
        Object rememberedValue = composer2.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DateRangePickerKt$rememberDateRangePickerState$1$1(l4, l5, l6, yearRange, r10, allDates, defaultLocale);
            composer2.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        DateRangePickerStateImpl dateRangePickerStateImpl = (DateRangePickerStateImpl) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) rememberedValue, composer2, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dateRangePickerStateImpl;
    }

    /* renamed from: DateRangePickerState-HVP43zI$default  reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m2003DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        if ((i2 & 8) != 0) {
            l3 = l;
        }
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 32) != 0) {
            i = DisplayMode.Companion.m2031getPickerjFl4v0();
        }
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m2002DateRangePickerStateHVP43zI(locale, l, l2, l3, intRange, i, selectableDates);
    }

    /* renamed from: DateRangePickerState-HVP43zI  reason: not valid java name */
    public static final DateRangePickerState m2002DateRangePickerStateHVP43zI(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: SwitchableDateEntryContent-RN-2D1Q  reason: not valid java name */
    public static final void m2004SwitchableDateEntryContentRN2D1Q(Long l, Long l2, long j, int i, Function2<? super Long, ? super Long, Unit> function2, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i2, int i3) {
        int i4;
        Long l3;
        long j2;
        Function2<? super Long, ? super Long, Unit> function22;
        Function1<? super Long, Unit> function12;
        CalendarModel calendarModel2;
        IntRange intRange2;
        int i5;
        Composer composer2;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-532789335);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchableDateEntryContent)P(9,8,4,3:c#material3.DisplayMode,5,6!1,10,2,7)672@30082L1249,664@29854L1477:DateRangePicker.kt#uh7d8r");
        if ((i6 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) l) ? 4 : 2) | i6;
        } else {
            Long l4 = l;
            i4 = i6;
        }
        if ((i6 & 48) == 0) {
            l3 = l2;
            i4 |= startRestartGroup.changed((Object) l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i6 & 384) == 0) {
            j2 = j;
            i4 |= startRestartGroup.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        int i7 = i;
        if ((i6 & 3072) == 0) {
            i4 |= startRestartGroup.changed(i7) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            function22 = function2;
            i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if ((196608 & i6) == 0) {
            function12 = function1;
            i4 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        } else {
            function12 = function1;
        }
        if ((1572864 & i6) == 0) {
            calendarModel2 = calendarModel;
            i4 |= startRestartGroup.changedInstance(calendarModel2) ? 1048576 : 524288;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((12582912 & i6) == 0) {
            intRange2 = intRange;
            i4 |= startRestartGroup.changedInstance(intRange2) ? 8388608 : 4194304;
        } else {
            intRange2 = intRange;
        }
        if ((i6 & 100663296) == 0) {
            i4 |= (i6 & 134217728) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        SelectableDates selectableDates2 = selectableDates;
        if ((i6 & 805306368) == 0) {
            i4 |= startRestartGroup.changed((Object) selectableDates2) ? 536870912 : 268435456;
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
                ComposerKt.traceEventStart(-532789335, i4, i5, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:661)");
            }
            composer2 = startRestartGroup;
            CrossfadeKt.Crossfade(DisplayMode.m2023boximpl(i7), SemanticsModifierKt.semantics$default(Modifier.Companion, false, DateRangePickerKt$SwitchableDateEntryContent$1.INSTANCE, 1, (Object) null), (FiniteAnimationSpec<Float>) AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1026642619, true, new DateRangePickerKt$SwitchableDateEntryContent$2(l, l3, j2, function22, function12, calendarModel2, intRange2, datePickerFormatter2, selectableDates, datePickerColors), startRestartGroup, 54), composer2, ((i4 >> 9) & 14) | 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerKt$SwitchableDateEntryContent$3(l, l2, j, i7, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void DateRangePickerContent(Long l, Long l2, long j, Function2<? super Long, ? super Long, Unit> function2, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Long l3;
        Function2<? super Long, ? super Long, Unit> function22;
        Function1<? super Long, Unit> function12;
        SelectableDates selectableDates2;
        long j2 = j;
        CalendarModel calendarModel2 = calendarModel;
        IntRange intRange2 = intRange;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        DatePickerColors datePickerColors2 = datePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerContent)P(8,7,3,4,5!1,9,2,6)718@31942L87,719@32034L648:DateRangePicker.kt#uh7d8r");
        Long l4 = l;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) l4) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            l3 = l2;
            i2 |= startRestartGroup.changed((Object) l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            function22 = function2;
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i2 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= (16777216 & i3) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i3 & 805306368) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:715)");
            }
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(calendarModel2.getMonth(j2).indexIn(intRange2), 0, startRestartGroup, 0, 2);
            Modifier r0 = PaddingKt.m777paddingVpY3zN4$default(Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i4 = currentCompositeKeyHash;
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
            Composer r3 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(i4))) {
                r3.updateRememberedValue(Integer.valueOf(i4));
                r3.apply(Integer.valueOf(i4), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 556336155, "C720@32122L31,721@32162L514:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors2, calendarModel2, startRestartGroup, ((i2 >> 27) & 14) | ((i2 >> 12) & 112));
            VerticalMonthsList(rememberLazyListState, l, l3, function22, function12, calendarModel2, intRange2, datePickerFormatter2, selectableDates2, datePickerColors2, startRestartGroup, ((i2 << 3) & PointerIconCompat.TYPE_TEXT) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2));
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
            endRestartGroup.updateScope(new DateRangePickerKt$DateRangePickerContent$2(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalMonthsList(LazyListState lazyListState, Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Long l3;
        Long l4;
        Function2<? super Long, ? super Long, Unit> function22;
        Function2 function23;
        LazyListState lazyListState2 = lazyListState;
        CalendarModel calendarModel2 = calendarModel;
        IntRange intRange2 = intRange;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1257365001);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalMonthsList)P(3,8,7,4,5!1,9,2,6)756@33410L158,762@33630L5,762@33637L3748,762@33573L3812,839@37420L228,839@37390L258:DateRangePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) lazyListState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            l3 = l;
            i2 |= startRestartGroup.changed((Object) l3) ? 32 : 16;
        } else {
            l3 = l;
        }
        if ((i3 & 384) == 0) {
            l4 = l2;
            i2 |= startRestartGroup.changed((Object) l4) ? 256 : 128;
        } else {
            l4 = l2;
        }
        if ((i3 & 3072) == 0) {
            function22 = function2;
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        } else {
            Function1<? super Long, Unit> function12 = function1;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= (16777216 & i3) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 8388608 : 4194304;
        }
        SelectableDates selectableDates2 = selectableDates;
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors) ? 536870912 : 268435456;
        } else {
            DatePickerColors datePickerColors2 = datePickerColors;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257365001, i2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:753)");
            }
            CalendarDate today = calendarModel2.getToday();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2140165432, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) intRange2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel2.getMonth(intRange2.getFirst(), 1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), startRestartGroup, 6);
            IntRange intRange3 = intRange2;
            LazyListState lazyListState3 = lazyListState2;
            Long l5 = l3;
            Function2<? super Long, ? super Long, Unit> function24 = function22;
            CalendarMonth calendarMonth = (CalendarMonth) rememberedValue;
            int i4 = i2;
            Long l6 = l4;
            IntRange intRange4 = intRange3;
            DateRangePickerKt$VerticalMonthsList$1 dateRangePickerKt$VerticalMonthsList$1 = new DateRangePickerKt$VerticalMonthsList$1(l5, l6, function24, lazyListState3, intRange4, calendarModel2, calendarMonth, datePickerFormatter2, datePickerColors, today, selectableDates2);
            IntRange intRange5 = intRange4;
            TextKt.ProvideTextStyle(value, ComposableLambdaKt.rememberComposableLambda(1090773432, true, dateRangePickerKt$VerticalMonthsList$1, startRestartGroup, 54), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2140037042, "CC(remember):DateRangePicker.kt#9igjgp");
            int i5 = i4 & 14;
            boolean changedInstance = (i5 == 4) | ((57344 & i4) == 16384) | startRestartGroup.changedInstance(calendarModel2) | startRestartGroup.changedInstance(intRange5);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                lazyListState2 = lazyListState;
                function23 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, function1, calendarModel2, intRange5, (Continuation<? super DateRangePickerKt$VerticalMonthsList$2$1>) null);
                startRestartGroup.updateRememberedValue(function23);
            } else {
                function23 = rememberedValue2;
                lazyListState2 = lazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect((Object) lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function23, startRestartGroup, i5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerKt$VerticalMonthsList$3(lazyListState2, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void updateDateSelection(long j, Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2) {
        if ((l == null && l2 == null) || (l != null && l2 != null)) {
            function2.invoke(Long.valueOf(j), null);
        } else if (l == null || j < l.longValue()) {
            function2.invoke(Long.valueOf(j), null);
        } else {
            function2.invoke(l, Long.valueOf(j));
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* renamed from: drawRangeBackground-mxwnekA  reason: not valid java name */
    public static final void m2006drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j) {
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float r1 = contentDrawScope2.m7091toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float r2 = contentDrawScope2.m7091toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float r3 = contentDrawScope2.m7091toPx0680j_4(DatePickerModalTokens.INSTANCE.m3166getDateStateLayerHeightD9Ej5fM());
        float f = (float) 2;
        float f2 = (r2 - r3) / f;
        float f3 = (float) 7;
        float r6 = (Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()) - (f3 * r1)) / f3;
        long r7 = selectedRangeInfo.m2456getGridStartCoordinatesnOccac();
        int r9 = IntOffset.m7241getXimpl(r7);
        int r72 = IntOffset.m7242getYimpl(r7);
        long r10 = selectedRangeInfo.m2455getGridEndCoordinatesnOccac();
        int r8 = IntOffset.m7241getXimpl(r10);
        int r102 = IntOffset.m7242getYimpl(r10);
        float f4 = r1 + r6;
        float f5 = 0.0f;
        float f6 = r6 / f;
        float f7 = (((float) r9) * f4) + (selectedRangeInfo.getFirstIsSelectionStart() ? r1 / f : 0.0f) + f6;
        float f8 = (((float) r72) * r2) + f2;
        float f9 = ((float) r8) * f4;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            r1 /= f;
        }
        float f10 = f9 + r1 + f6;
        float f11 = (((float) r102) * r2) + f2;
        boolean z = contentDrawScope2.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            f7 = Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()) - f7;
            f10 = Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()) - f10;
        }
        DrawScope drawScope = contentDrawScope2;
        DrawScope.m4840drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset(f7, f8), SizeKt.Size(r72 == r102 ? f10 - f7 : z ? -f7 : Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()) - f7, r3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        if (r72 != r102) {
            for (int i = (r102 - r72) - 1; i > 0; i--) {
                DrawScope.m4840drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset(0.0f, (((float) i) * r2) + f8), SizeKt.Size(Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()), r3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
            }
            if (contentDrawScope2.getLayoutDirection() != LayoutDirection.Ltr) {
                f5 = Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc());
            }
            long Offset = OffsetKt.Offset(f5, f11);
            if (z) {
                f10 -= Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc());
            }
            DrawScope.m4840drawRectnJ9OG0$default(drawScope, j, Offset, SizeKt.Size(f10, r3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyListState lazyListState, CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf(new CustomAccessibilityAction(str, new DateRangePickerKt$customScrollActions$scrollUpAction$1(lazyListState, coroutineScope)), new CustomAccessibilityAction(str2, new DateRangePickerKt$customScrollActions$scrollDownAction$1(lazyListState, coroutineScope)));
    }

    static {
        float f = (float) 64;
        float f2 = (float) 12;
        DateRangePickerTitlePadding = PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl(f), 0.0f, Dp.m7111constructorimpl(f2), 0.0f, 10, (Object) null);
        DateRangePickerHeadlinePadding = PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl(f), 0.0f, Dp.m7111constructorimpl(f2), Dp.m7111constructorimpl(f2), 2, (Object) null);
    }
}
