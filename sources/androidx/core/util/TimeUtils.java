package androidx.core.util;

import java.io.PrintWriter;

public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync = new Object();

    private static int accumField(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    private static int printField(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= 2) || i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        cArr[i4 + 1] = c;
        return i4 + 2;
    }

    private static int formatDurationLocked(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        long j2 = j;
        int i6 = i;
        if (sFormatStr.length < i6) {
            sFormatStr = new char[i6];
        }
        char[] cArr = sFormatStr;
        int i7 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i7 == 0) {
            int i8 = i6 - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i7 > 0) {
            c = '+';
        } else {
            j2 = -j2;
            c = '-';
        }
        int i9 = (int) (j2 % 1000);
        int floor = (int) Math.floor((double) (j2 / 1000));
        if (floor > SECONDS_PER_DAY) {
            i2 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i2;
        } else {
            i2 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i3 = floor / SECONDS_PER_HOUR;
            floor -= i3 * SECONDS_PER_HOUR;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i10 = floor / 60;
            floor -= i10 * 60;
            i4 = i10;
        } else {
            i4 = 0;
        }
        if (i6 != 0) {
            int accumField = accumField(i2, 1, false, 0);
            int accumField2 = accumField + accumField(i3, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i4, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(floor, 1, accumField3 > 0, 2);
            i5 = 0;
            for (int accumField5 = accumField4 + accumField(i9, 2, true, accumField4 > 0 ? 3 : 0) + 1; accumField5 < i6; accumField5++) {
                cArr[i5] = ' ';
                i5++;
            }
        } else {
            i5 = 0;
        }
        cArr[i5] = c;
        int i11 = i5 + 1;
        boolean z = i6 != 0;
        int printField = printField(cArr, i2, 'd', i11, false, 0);
        int i12 = i11;
        boolean z2 = printField != i12;
        int i13 = i12;
        int i14 = i3;
        int i15 = i13;
        int printField2 = printField(cArr, i14, 'h', printField, z2, z ? 2 : 0);
        int printField3 = printField(cArr, i4, 'm', printField2, printField2 != i15, z ? 2 : 0);
        int printField4 = printField(cArr, floor, 's', printField3, printField3 != i15, z ? 2 : 0);
        int printField5 = printField(cArr, i9, 'm', printField4, true, (!z || printField4 == i15) ? 0 : 3);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }

    private TimeUtils() {
    }
}
