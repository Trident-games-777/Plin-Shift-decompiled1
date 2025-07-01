package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J%\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J°\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00101\u001a\u000202H\u0016J%\u00103\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010+J%\u00105\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010+J%\u00107\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010+R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0015R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedIconColor-0d7_KjU", "getCheckedThumbColor-0d7_KjU", "getCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "borderColor", "enabled", "", "checked", "borderColor-WaAFU9c$material3_release", "(ZZ)J", "copy", "copy-Q_H9qLU", "(JJJJJJJJJJJJJJJJ)Landroidx/compose/material3/SwitchColors;", "equals", "other", "hashCode", "", "iconColor", "iconColor-WaAFU9c$material3_release", "thumbColor", "thumbColor-WaAFU9c$material3_release", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
    }

    private SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.checkedBorderColor = j3;
        this.checkedIconColor = j4;
        this.uncheckedThumbColor = j5;
        this.uncheckedTrackColor = j6;
        this.uncheckedBorderColor = j7;
        this.uncheckedIconColor = j8;
        this.disabledCheckedThumbColor = j9;
        this.disabledCheckedTrackColor = j10;
        this.disabledCheckedBorderColor = j11;
        this.disabledCheckedIconColor = j12;
        this.disabledUncheckedThumbColor = j13;
        this.disabledUncheckedTrackColor = j14;
        this.disabledUncheckedBorderColor = j15;
        this.disabledUncheckedIconColor = j16;
    }

    /* renamed from: getCheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2551getCheckedThumbColor0d7_KjU() {
        return this.checkedThumbColor;
    }

    /* renamed from: getCheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2552getCheckedTrackColor0d7_KjU() {
        return this.checkedTrackColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2549getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getCheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2550getCheckedIconColor0d7_KjU() {
        return this.checkedIconColor;
    }

    /* renamed from: getUncheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2563getUncheckedThumbColor0d7_KjU() {
        return this.uncheckedThumbColor;
    }

    /* renamed from: getUncheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2564getUncheckedTrackColor0d7_KjU() {
        return this.uncheckedTrackColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2561getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getUncheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2562getUncheckedIconColor0d7_KjU() {
        return this.uncheckedIconColor;
    }

    /* renamed from: getDisabledCheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2555getDisabledCheckedThumbColor0d7_KjU() {
        return this.disabledCheckedThumbColor;
    }

    /* renamed from: getDisabledCheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2556getDisabledCheckedTrackColor0d7_KjU() {
        return this.disabledCheckedTrackColor;
    }

    /* renamed from: getDisabledCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2553getDisabledCheckedBorderColor0d7_KjU() {
        return this.disabledCheckedBorderColor;
    }

    /* renamed from: getDisabledCheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2554getDisabledCheckedIconColor0d7_KjU() {
        return this.disabledCheckedIconColor;
    }

    /* renamed from: getDisabledUncheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2559getDisabledUncheckedThumbColor0d7_KjU() {
        return this.disabledUncheckedThumbColor;
    }

    /* renamed from: getDisabledUncheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2560getDisabledUncheckedTrackColor0d7_KjU() {
        return this.disabledUncheckedTrackColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2557getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledUncheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2558getDisabledUncheckedIconColor0d7_KjU() {
        return this.disabledUncheckedIconColor;
    }

    /* renamed from: copy-Q_H9qLU$default  reason: not valid java name */
    public static /* synthetic */ SwitchColors m2546copyQ_H9qLU$default(SwitchColors switchColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i, Object obj) {
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        SwitchColors switchColors2;
        SwitchColors switchColors3 = switchColors;
        int i2 = i;
        long j32 = (i2 & 1) != 0 ? switchColors3.checkedThumbColor : j;
        long j33 = (i2 & 2) != 0 ? switchColors3.checkedTrackColor : j2;
        long j34 = (i2 & 4) != 0 ? switchColors3.checkedBorderColor : j3;
        long j35 = (i2 & 8) != 0 ? switchColors3.checkedIconColor : j4;
        long j36 = (i2 & 16) != 0 ? switchColors3.uncheckedThumbColor : j5;
        long j37 = (i2 & 32) != 0 ? switchColors3.uncheckedTrackColor : j6;
        long j38 = (i2 & 64) != 0 ? switchColors3.uncheckedBorderColor : j7;
        long j39 = j32;
        long j40 = (i2 & 128) != 0 ? switchColors3.uncheckedIconColor : j8;
        long j41 = (i2 & 256) != 0 ? switchColors3.disabledCheckedThumbColor : j9;
        long j42 = (i2 & 512) != 0 ? switchColors3.disabledCheckedTrackColor : j10;
        long j43 = (i2 & 1024) != 0 ? switchColors3.disabledCheckedBorderColor : j11;
        long j44 = (i2 & 2048) != 0 ? switchColors3.disabledCheckedIconColor : j12;
        long j45 = (i2 & 4096) != 0 ? switchColors3.disabledUncheckedThumbColor : j13;
        long j46 = (i2 & 8192) != 0 ? switchColors3.disabledUncheckedTrackColor : j14;
        long j47 = (i2 & 16384) != 0 ? switchColors3.disabledUncheckedBorderColor : j15;
        if ((i2 & 32768) != 0) {
            j18 = j47;
            j17 = switchColors3.disabledUncheckedIconColor;
            j24 = j41;
            j23 = j42;
            j22 = j43;
            j21 = j44;
            j20 = j45;
            j19 = j46;
            j31 = j33;
            j30 = j34;
            j29 = j35;
            j28 = j36;
            j27 = j37;
            j26 = j38;
            j25 = j40;
            switchColors2 = switchColors3;
        } else {
            j17 = j16;
            j18 = j47;
            j25 = j40;
            j24 = j41;
            j23 = j42;
            j22 = j43;
            j21 = j44;
            j20 = j45;
            j19 = j46;
            switchColors2 = switchColors3;
            j31 = j33;
            j30 = j34;
            j29 = j35;
            j28 = j36;
            j27 = j37;
            j26 = j38;
        }
        return switchColors2.m2548copyQ_H9qLU(j39, j31, j30, j29, j28, j27, j26, j25, j24, j23, j22, j21, j20, j19, j18, j17);
    }

    /* renamed from: copy-Q_H9qLU  reason: not valid java name */
    public final SwitchColors m2548copyQ_H9qLU(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        long j32 = j != 16 ? j : this.checkedThumbColor;
        if (j2 != 16) {
            j17 = j2;
        } else {
            j17 = this.checkedTrackColor;
        }
        if (j3 != 16) {
            j18 = j3;
        } else {
            j18 = this.checkedBorderColor;
        }
        if (j4 != 16) {
            j19 = j4;
        } else {
            j19 = this.checkedIconColor;
        }
        if (j5 != 16) {
            j20 = j5;
        } else {
            j20 = this.uncheckedThumbColor;
        }
        if (j6 != 16) {
            j21 = j6;
        } else {
            j21 = this.uncheckedTrackColor;
        }
        if (j7 != 16) {
            j22 = j7;
        } else {
            j22 = this.uncheckedBorderColor;
        }
        if (j8 != 16) {
            j23 = j8;
        } else {
            j23 = this.uncheckedIconColor;
        }
        if (j9 != 16) {
            j24 = j9;
        } else {
            j24 = this.disabledCheckedThumbColor;
        }
        if (j10 != 16) {
            j25 = j10;
        } else {
            j25 = this.disabledCheckedTrackColor;
        }
        if (j11 != 16) {
            j26 = j11;
        } else {
            j26 = this.disabledCheckedBorderColor;
        }
        if (j12 != 16) {
            j27 = j12;
        } else {
            j27 = this.disabledCheckedIconColor;
        }
        if (j13 != 16) {
            j28 = j13;
        } else {
            j28 = this.disabledUncheckedThumbColor;
        }
        if (j14 != 16) {
            j29 = j14;
        } else {
            j29 = this.disabledUncheckedTrackColor;
        }
        if (j15 != 16) {
            j30 = j15;
        } else {
            j30 = this.disabledUncheckedBorderColor;
        }
        if (j16 != 16) {
            j31 = j16;
        } else {
            j31 = this.disabledUncheckedIconColor;
        }
        return new SwitchColors(j32, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, (DefaultConstructorMarker) null);
    }

    /* renamed from: thumbColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2566thumbColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedThumbColor : this.uncheckedThumbColor : z2 ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
    }

    /* renamed from: trackColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2567trackColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedTrackColor : this.uncheckedTrackColor : z2 ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
    }

    /* renamed from: borderColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2547borderColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedBorderColor : this.uncheckedBorderColor : z2 ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
    }

    /* renamed from: iconColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2565iconColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedIconColor : this.uncheckedIconColor : z2 ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return Color.m4240equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && Color.m4240equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && Color.m4240equalsimpl0(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m4240equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Color.m4240equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Color.m4240equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Color.m4240equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m4240equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Color.m4240equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Color.m4240equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Color.m4240equalsimpl0(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m4240equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Color.m4240equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Color.m4240equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Color.m4240equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m4240equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.m4246hashCodeimpl(this.checkedThumbColor) * 31) + Color.m4246hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m4246hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.checkedIconColor)) * 31) + Color.m4246hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m4246hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m4246hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m4246hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m4246hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m4246hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m4246hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m4246hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m4246hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.disabledUncheckedIconColor);
    }
}
