package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J.\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "currentStartDateMillis", "", "currentEndDateMillis", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentEndDateMillis$material3_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "setCurrentStartDateMillis$material3_release", "validate", "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public DateInputValidator(IntRange intRange, SelectableDates selectableDates2, DateInputFormat dateInputFormat2, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2) {
        this.yearRange = intRange;
        this.selectableDates = selectableDates2;
        this.dateInputFormat = dateInputFormat2;
        this.dateFormatter = datePickerFormatter;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
        this.currentStartDateMillis = l;
        this.currentEndDateMillis = l2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DateInputValidator(kotlin.ranges.IntRange r2, androidx.compose.material3.SelectableDates r3, androidx.compose.material3.internal.DateInputFormat r4, androidx.compose.material3.DatePickerFormatter r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Long r10, java.lang.Long r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 256(0x100, float:3.59E-43)
            r0 = 0
            if (r13 == 0) goto L_0x0006
            r10 = r0
        L_0x0006:
            r12 = r12 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x000c
            r12 = r0
            goto L_0x000d
        L_0x000c:
            r12 = r11
        L_0x000d:
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.<init>(kotlin.ranges.IntRange, androidx.compose.material3.SelectableDates, androidx.compose.material3.internal.DateInputFormat, androidx.compose.material3.DatePickerFormatter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getCurrentStartDateMillis$material3_release() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentStartDateMillis$material3_release(Long l) {
        this.currentStartDateMillis = l;
    }

    public final Long getCurrentEndDateMillis$material3_release() {
        return this.currentEndDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long l) {
        this.currentEndDateMillis = l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r0 < (r11 != null ? r11.longValue() : Long.MAX_VALUE)) goto L_0x009a;
     */
    /* renamed from: validate-XivgLIo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m1951validateXivgLIo(androidx.compose.material3.internal.CalendarDate r9, int r10, java.util.Locale r11) {
        /*
            r8 = this;
            r0 = 1
            java.lang.String r1 = "format(this, *args)"
            if (r9 != 0) goto L_0x0029
            java.lang.String r9 = r8.errorDatePattern
            androidx.compose.material3.internal.DateInputFormat r10 = r8.dateInputFormat
            java.lang.String r10 = r10.getPatternWithDelimiters()
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r10 = r10.toUpperCase(r11)
            java.lang.String r11 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Object[] r10 = new java.lang.Object[]{r10}
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r0)
            java.lang.String r9 = java.lang.String.format(r9, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            return r9
        L_0x0029:
            kotlin.ranges.IntRange r2 = r8.yearRange
            int r3 = r9.getYear()
            boolean r2 = r2.contains((int) r3)
            if (r2 != 0) goto L_0x0061
            java.lang.String r9 = r8.errorDateOutOfYearRange
            kotlin.ranges.IntRange r10 = r8.yearRange
            int r2 = r10.getFirst()
            r6 = 7
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r10 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r2, r3, r4, r5, r6, r7)
            kotlin.ranges.IntRange r11 = r8.yearRange
            int r2 = r11.getLast()
            java.lang.String r11 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r2, r3, r4, r5, r6, r7)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}
            r11 = 2
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.lang.String r9 = java.lang.String.format(r9, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            return r9
        L_0x0061:
            androidx.compose.material3.SelectableDates r2 = r8.selectableDates
            int r3 = r9.getYear()
            boolean r3 = r2.isSelectableYear(r3)
            if (r3 == 0) goto L_0x00bf
            long r3 = r9.getUtcTimeMillis()
            boolean r2 = r2.isSelectableDate(r3)
            if (r2 != 0) goto L_0x0078
            goto L_0x00bf
        L_0x0078:
            androidx.compose.material3.InputIdentifier$Companion r11 = androidx.compose.material3.InputIdentifier.Companion
            int r11 = r11.m2150getStartDateInputJ2x2o4M()
            boolean r11 = androidx.compose.material3.InputIdentifier.m2144equalsimpl0(r10, r11)
            if (r11 == 0) goto L_0x009a
            long r0 = r9.getUtcTimeMillis()
            java.lang.Long r11 = r8.currentEndDateMillis
            if (r11 == 0) goto L_0x0091
            long r2 = r11.longValue()
            goto L_0x0096
        L_0x0091:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0096:
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 >= 0) goto L_0x00b9
        L_0x009a:
            androidx.compose.material3.InputIdentifier$Companion r11 = androidx.compose.material3.InputIdentifier.Companion
            int r11 = r11.m2148getEndDateInputJ2x2o4M()
            boolean r10 = androidx.compose.material3.InputIdentifier.m2144equalsimpl0(r10, r11)
            if (r10 == 0) goto L_0x00bc
            long r9 = r9.getUtcTimeMillis()
            java.lang.Long r11 = r8.currentStartDateMillis
            if (r11 == 0) goto L_0x00b3
            long r0 = r11.longValue()
            goto L_0x00b5
        L_0x00b3:
            r0 = -9223372036854775808
        L_0x00b5:
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x00bc
        L_0x00b9:
            java.lang.String r9 = r8.errorInvalidRangeInput
            return r9
        L_0x00bc:
            java.lang.String r9 = ""
            return r9
        L_0x00bf:
            java.lang.String r10 = r8.errorInvalidNotAllowed
            androidx.compose.material3.DatePickerFormatter r2 = r8.dateFormatter
            long r3 = r9.getUtcTimeMillis()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r6 = 4
            r7 = 0
            r5 = 0
            r4 = r11
            java.lang.String r9 = androidx.compose.material3.DatePickerFormatter.formatDate$default(r2, r3, r4, r5, r6, r7)
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            java.lang.String r9 = java.lang.String.format(r10, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m1951validateXivgLIo(androidx.compose.material3.internal.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
