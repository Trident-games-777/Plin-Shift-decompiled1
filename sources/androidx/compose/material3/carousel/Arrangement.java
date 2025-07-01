package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Arrangement.kt */
public final class Arrangement {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i2;
        this.mediumSize = f2;
        this.mediumCount = i3;
        this.largeSize = f3;
        this.largeCount = i4;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    private final boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f2 = this.mediumSize;
        return f > f2 && f2 > this.smallSize;
    }

    /* access modifiers changed from: private */
    public final float cost(float f) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f - this.largeSize) * ((float) this.priority);
    }

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float calculateLargeSize(float f, int i, float f2, int i2, int i3) {
            float f3 = ((float) i2) / 2.0f;
            return (f - ((((float) i) + f3) * f2)) / (((float) i3) + f3);
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float f, float f2, float f3, float f4, float f5, int[] iArr, float f6, int[] iArr2, float f7, int[] iArr3) {
            int[] iArr4 = iArr;
            int[] iArr5 = iArr2;
            int[] iArr6 = iArr3;
            int length = iArr6.length;
            Arrangement arrangement = null;
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr6[i2];
                int length2 = iArr5.length;
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = iArr5[i4];
                    int length3 = iArr4.length;
                    int i6 = 0;
                    while (i6 < length3) {
                        float f8 = f7;
                        Arrangement arrangement2 = arrangement;
                        int i7 = i2;
                        int i8 = length2;
                        int i9 = length3;
                        int i10 = i6;
                        int i11 = i4;
                        Arrangement fit = fit(i, f, f2, iArr4[i6], f3, f4, f5, i5, f6, i3, f8);
                        if (arrangement2 != null && fit.cost(f8) >= arrangement2.cost(f8)) {
                            arrangement = arrangement2;
                        } else if (fit.cost(f8) == 0.0f) {
                            return fit;
                        } else {
                            arrangement = fit;
                        }
                        i++;
                        i6 = i10 + 1;
                        iArr4 = iArr;
                        i2 = i7;
                        length2 = i8;
                        i4 = i11;
                        length3 = i9;
                    }
                    float f9 = f7;
                    Arrangement arrangement3 = arrangement;
                    int i12 = i2;
                    int i13 = length2;
                    i4++;
                    iArr4 = iArr;
                }
                float f10 = f7;
                i2++;
                iArr4 = iArr;
            }
            return arrangement;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final androidx.compose.material3.carousel.Arrangement fit(int r5, float r6, float r7, int r8, float r9, float r10, float r11, int r12, float r13, int r14, float r15) {
            /*
                r4 = this;
                int r0 = r14 + r12
                int r0 = r0 + r8
                int r0 = r0 + -1
                float r0 = (float) r0
                float r0 = r0 * r7
                float r7 = r6 - r0
                float r6 = kotlin.ranges.RangesKt.coerceIn((float) r9, (float) r10, (float) r11)
                float r0 = (float) r14
                float r9 = r15 * r0
                float r1 = (float) r12
                float r13 = r13 * r1
                float r9 = r9 + r13
                float r13 = (float) r8
                float r2 = r6 * r13
                float r9 = r9 + r2
                float r9 = r7 - r9
                r2 = 0
                if (r8 <= 0) goto L_0x0028
                int r3 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r3 <= 0) goto L_0x0028
                float r9 = r9 / r13
                float r11 = r11 - r6
                float r9 = java.lang.Math.min(r9, r11)
            L_0x0026:
                float r6 = r6 + r9
                goto L_0x0035
            L_0x0028:
                if (r8 <= 0) goto L_0x0035
                int r11 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r11 >= 0) goto L_0x0035
                float r9 = r9 / r13
                float r10 = r10 - r6
                float r9 = java.lang.Math.max(r9, r10)
                goto L_0x0026
            L_0x0035:
                if (r8 <= 0) goto L_0x003c
                r9 = r6
                r10 = r12
                r11 = r14
                r6 = r4
                goto L_0x0040
            L_0x003c:
                r9 = r2
                r6 = r4
                r10 = r12
                r11 = r14
            L_0x0040:
                float r7 = r6.calculateLargeSize(r7, r8, r9, r10, r11)
                r6 = r9
                float r9 = r7 + r6
                r12 = 1073741824(0x40000000, float:2.0)
                float r9 = r9 / r12
                if (r10 <= 0) goto L_0x006f
                int r12 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
                if (r12 != 0) goto L_0x0051
                goto L_0x006f
            L_0x0051:
                float r15 = r15 - r7
                float r15 = r15 * r0
                r12 = 1036831949(0x3dcccccd, float:0.1)
                float r12 = r12 * r9
                float r12 = r12 * r1
                float r13 = java.lang.Math.abs(r15)
                float r12 = java.lang.Math.min(r13, r12)
                int r13 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
                if (r13 <= 0) goto L_0x006a
                float r13 = r12 / r1
                float r9 = r9 - r13
                float r12 = r12 / r0
                float r7 = r7 + r12
                goto L_0x006f
            L_0x006a:
                float r13 = r12 / r1
                float r9 = r9 + r13
                float r12 = r12 / r0
                float r7 = r7 - r12
            L_0x006f:
                r14 = r7
                r12 = r9
                r15 = r11
                r11 = r8
                androidx.compose.material3.carousel.Arrangement r8 = new androidx.compose.material3.carousel.Arrangement
                r9 = r5
                r13 = r10
                r10 = r6
                r8.<init>(r9, r10, r11, r12, r13, r14, r15)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.fit(int, float, float, int, float, float, float, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }
    }
}
