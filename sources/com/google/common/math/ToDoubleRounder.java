package com.google.common.math;

import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {
    /* access modifiers changed from: package-private */
    public abstract X minus(X x, X x2);

    /* access modifiers changed from: package-private */
    public abstract double roundToDoubleArbitrarily(X x);

    /* access modifiers changed from: package-private */
    public abstract int sign(X x);

    /* access modifiers changed from: package-private */
    public abstract X toX(double d, RoundingMode roundingMode);

    ToDoubleRounder() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double roundToDouble(X r13, java.math.RoundingMode r14) {
        /*
            r12 = this;
            java.lang.String r0 = "x"
            com.google.common.base.Preconditions.checkNotNull(r13, r0)
            java.lang.String r0 = "mode"
            com.google.common.base.Preconditions.checkNotNull(r14, r0)
            double r0 = r12.roundToDoubleArbitrarily(r13)
            boolean r2 = java.lang.Double.isInfinite(r0)
            r3 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r5 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            if (r2 == 0) goto L_0x0069
            int[] r2 = com.google.common.math.ToDoubleRounder.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r7 = r14.ordinal()
            r2 = r2[r7]
            r7 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            switch(r2) {
                case 1: goto L_0x0062;
                case 2: goto L_0x0062;
                case 3: goto L_0x0062;
                case 4: goto L_0x0062;
                case 5: goto L_0x005c;
                case 6: goto L_0x0051;
                case 7: goto L_0x013c;
                case 8: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0069
        L_0x002a:
            java.lang.ArithmeticException r14 = new java.lang.ArithmeticException
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r0 = java.lang.String.valueOf(r13)
            int r0 = r0.length()
            int r0 = r0 + 44
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.StringBuilder r13 = r1.append(r13)
            java.lang.String r0 = " cannot be represented precisely as a double"
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        L_0x0051:
            int r13 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x0056
            return r5
        L_0x0056:
            r13 = -4503599627370497(0xffefffffffffffff, double:-1.7976931348623157E308)
            return r13
        L_0x005c:
            int r13 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x0061
            return r7
        L_0x0061:
            return r3
        L_0x0062:
            int r13 = r12.sign(r13)
            double r13 = (double) r13
            double r13 = r13 * r7
            return r13
        L_0x0069:
            java.math.RoundingMode r2 = java.math.RoundingMode.UNNECESSARY
            java.lang.Number r2 = r12.toX(r0, r2)
            r7 = r13
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            int r7 = r7.compareTo(r2)
            int[] r8 = com.google.common.math.ToDoubleRounder.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r9 = r14.ordinal()
            r8 = r8[r9]
            java.lang.String r9 = "impossible"
            switch(r8) {
                case 1: goto L_0x012c;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00bc;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00b3;
                case 6: goto L_0x00aa;
                case 7: goto L_0x0092;
                case 8: goto L_0x0089;
                default: goto L_0x0083;
            }
        L_0x0083:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            r13.<init>(r9)
            throw r13
        L_0x0089:
            if (r7 != 0) goto L_0x008d
            r13 = 1
            goto L_0x008e
        L_0x008d:
            r13 = 0
        L_0x008e:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r13)
            return r0
        L_0x0092:
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x00a1
            if (r7 > 0) goto L_0x009c
            goto L_0x013c
        L_0x009c:
            double r13 = java.lang.Math.nextUp(r0)
            return r13
        L_0x00a1:
            if (r7 < 0) goto L_0x00a5
            goto L_0x013c
        L_0x00a5:
            double r13 = com.google.common.math.DoubleUtils.nextDown(r0)
            return r13
        L_0x00aa:
            if (r7 > 0) goto L_0x00ae
            goto L_0x013c
        L_0x00ae:
            double r13 = java.lang.Math.nextUp(r0)
            return r13
        L_0x00b3:
            if (r7 < 0) goto L_0x00b7
            goto L_0x013c
        L_0x00b7:
            double r13 = com.google.common.math.DoubleUtils.nextDown(r0)
            return r13
        L_0x00bc:
            if (r7 < 0) goto L_0x00cf
            double r3 = java.lang.Math.nextUp(r0)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x00c8
            goto L_0x013c
        L_0x00c8:
            java.math.RoundingMode r5 = java.math.RoundingMode.CEILING
            java.lang.Number r5 = r12.toX(r3, r5)
            goto L_0x00e4
        L_0x00cf:
            double r5 = com.google.common.math.DoubleUtils.nextDown(r0)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x00d9
            goto L_0x013c
        L_0x00d9:
            java.math.RoundingMode r3 = java.math.RoundingMode.FLOOR
            java.lang.Number r3 = r12.toX(r5, r3)
            r10 = r5
            r5 = r2
            r2 = r3
            r3 = r0
            r0 = r10
        L_0x00e4:
            java.lang.Number r2 = r12.minus(r13, r2)
            java.lang.Number r5 = r12.minus(r5, r13)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r5)
            if (r2 >= 0) goto L_0x00f5
            goto L_0x012a
        L_0x00f5:
            if (r2 <= 0) goto L_0x00f8
            goto L_0x012b
        L_0x00f8:
            int[] r2 = com.google.common.math.ToDoubleRounder.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r14 = r14.ordinal()
            r14 = r2[r14]
            r2 = 2
            if (r14 == r2) goto L_0x011d
            r2 = 3
            if (r14 == r2) goto L_0x0116
            r2 = 4
            if (r14 != r2) goto L_0x0110
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x012a
            goto L_0x012b
        L_0x0110:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            r13.<init>(r9)
            throw r13
        L_0x0116:
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x012b
            goto L_0x012a
        L_0x011d:
            long r13 = java.lang.Double.doubleToRawLongBits(r0)
            r5 = 1
            long r13 = r13 & r5
            r5 = 0
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x012b
        L_0x012a:
            return r0
        L_0x012b:
            return r3
        L_0x012c:
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x013a
            if (r7 < 0) goto L_0x0135
            goto L_0x013c
        L_0x0135:
            double r13 = com.google.common.math.DoubleUtils.nextDown(r0)
            return r13
        L_0x013a:
            if (r7 > 0) goto L_0x013d
        L_0x013c:
            return r0
        L_0x013d:
            double r13 = java.lang.Math.nextUp(r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.ToDoubleRounder.roundToDouble(java.lang.Number, java.math.RoundingMode):double");
    }

    /* renamed from: com.google.common.math.ToDoubleRounder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.ToDoubleRounder.AnonymousClass1.<clinit>():void");
        }
    }
}
