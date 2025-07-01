package com.github.megatronking.stringfog;

public final class Base64 {
    private static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    private static final int URL_SAFE = 8;

    static abstract class Coder {
        int op;
        byte[] output;

        /* access modifiers changed from: protected */
        public abstract int maxOutputSize(int i);

        /* access modifiers changed from: protected */
        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        Coder() {
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    private static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[((i2 * 3) / 4)]);
        if (!decoder.process(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (decoder.op == decoder.output.length) {
            return decoder.output;
        } else {
            byte[] bArr2 = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr2, 0, decoder.op);
            return bArr2;
        }
    }

    private static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        private Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:73:0x00eb A[EDGE_INSN: B:73:0x00eb->B:54:0x00eb ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r17, int r18, int r19, boolean r20) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.state
                r2 = 0
                r3 = 6
                if (r1 != r3) goto L_0x0009
                return r2
            L_0x0009:
                int r4 = r19 + r18
                int r5 = r0.value
                byte[] r6 = r0.output
                int[] r7 = r0.alphabet
                r9 = r2
                r8 = r5
                r5 = r1
                r1 = r18
            L_0x0016:
                r10 = 3
                r11 = 4
                r12 = 2
                r13 = 1
                if (r1 >= r4) goto L_0x00eb
                if (r5 != 0) goto L_0x0063
            L_0x001e:
                int r14 = r1 + 4
                if (r14 > r4) goto L_0x005f
                byte r8 = r17[r1]
                r8 = r8 & 255(0xff, float:3.57E-43)
                r8 = r7[r8]
                int r8 = r8 << 18
                int r15 = r1 + 1
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << 12
                r8 = r8 | r15
                int r15 = r1 + 2
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << r3
                r8 = r8 | r15
                int r15 = r1 + 3
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                r8 = r8 | r15
                if (r8 < 0) goto L_0x005f
                int r1 = r9 + 2
                byte r15 = (byte) r8
                r6[r1] = r15
                int r1 = r9 + 1
                int r15 = r8 >> 8
                byte r15 = (byte) r15
                r6[r1] = r15
                int r1 = r8 >> 16
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 3
                r1 = r14
                goto L_0x001e
            L_0x005f:
                if (r1 < r4) goto L_0x0063
                goto L_0x00eb
            L_0x0063:
                int r14 = r1 + 1
                byte r1 = r17[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r1 = r7[r1]
                r15 = -1
                if (r5 == 0) goto L_0x00dd
                if (r5 == r13) goto L_0x00d2
                r13 = -2
                if (r5 == r12) goto L_0x00be
                r12 = 5
                if (r5 == r10) goto L_0x008c
                if (r5 == r11) goto L_0x0081
                if (r5 == r12) goto L_0x007c
                goto L_0x00e8
            L_0x007c:
                if (r1 == r15) goto L_0x00e8
                r0.state = r3
                return r2
            L_0x0081:
                if (r1 != r13) goto L_0x0087
                int r5 = r5 + 1
                goto L_0x00e8
            L_0x0087:
                if (r1 == r15) goto L_0x00e8
                r0.state = r3
                return r2
            L_0x008c:
                if (r1 < 0) goto L_0x00a7
                int r5 = r8 << 6
                r1 = r1 | r5
                int r5 = r9 + 2
                byte r8 = (byte) r1
                r6[r5] = r8
                int r5 = r9 + 1
                int r8 = r1 >> 8
                byte r8 = (byte) r8
                r6[r5] = r8
                int r5 = r1 >> 16
                byte r5 = (byte) r5
                r6[r9] = r5
                int r9 = r9 + 3
                r8 = r1
                r5 = r2
                goto L_0x00e8
            L_0x00a7:
                if (r1 != r13) goto L_0x00b9
                int r1 = r9 + 1
                int r5 = r8 >> 2
                byte r5 = (byte) r5
                r6[r1] = r5
                int r1 = r8 >> 10
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 2
                r5 = r12
                goto L_0x00e8
            L_0x00b9:
                if (r1 == r15) goto L_0x00e8
                r0.state = r3
                return r2
            L_0x00be:
                if (r1 < 0) goto L_0x00c1
                goto L_0x00d4
            L_0x00c1:
                if (r1 != r13) goto L_0x00cd
                int r1 = r9 + 1
                int r5 = r8 >> 4
                byte r5 = (byte) r5
                r6[r9] = r5
                r9 = r1
                r5 = r11
                goto L_0x00e8
            L_0x00cd:
                if (r1 == r15) goto L_0x00e8
                r0.state = r3
                return r2
            L_0x00d2:
                if (r1 < 0) goto L_0x00d8
            L_0x00d4:
                int r8 = r8 << 6
                r1 = r1 | r8
                goto L_0x00df
            L_0x00d8:
                if (r1 == r15) goto L_0x00e8
                r0.state = r3
                return r2
            L_0x00dd:
                if (r1 < 0) goto L_0x00e3
            L_0x00df:
                int r5 = r5 + 1
                r8 = r1
                goto L_0x00e8
            L_0x00e3:
                if (r1 == r15) goto L_0x00e8
                r0.state = r3
                return r2
            L_0x00e8:
                r1 = r14
                goto L_0x0016
            L_0x00eb:
                if (r20 != 0) goto L_0x00f4
                r0.state = r5
                r0.value = r8
                r0.op = r9
                return r13
            L_0x00f4:
                if (r5 == r13) goto L_0x011c
                if (r5 == r12) goto L_0x010f
                if (r5 == r10) goto L_0x0100
                if (r5 == r11) goto L_0x00fd
                goto L_0x0117
            L_0x00fd:
                r0.state = r3
                return r2
            L_0x0100:
                int r1 = r9 + 1
                int r2 = r8 >> 10
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r9 + 2
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                goto L_0x0117
            L_0x010f:
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
            L_0x0117:
                r0.state = r5
                r0.op = r9
                return r13
            L_0x011c:
                r0.state = r3
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.megatronking.stringfog.Base64.Decoder.process(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] encode(String str, int i) {
        return encode(str.getBytes(), i);
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    private static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, (byte[]) null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!encoder.do_padding) {
            int i6 = i2 % 3;
            if (i6 == 1) {
                i4 += 2;
            } else if (i6 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!encoder.do_cr) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        return encoder.output;
    }

    private static class Encoder extends Coder {
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        final boolean do_cr;
        final boolean do_newline;
        final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        private Encoder(int i, byte[] bArr) {
            this.output = bArr;
            boolean z = true;
            this.do_padding = (i & 1) == 0;
            boolean z2 = (i & 2) == 0;
            this.do_newline = z2;
            this.do_cr = (i & 4) == 0 ? false : z;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z2 ? 19 : -1;
        }

        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00ee A[EDGE_INSN: B:84:0x00ee->B:30:0x00ee ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.alphabet
                byte[] r2 = r0.output
                int r3 = r0.count
                int r4 = r20 + r19
                int r5 = r0.tailLen
                r6 = 2
                r7 = 1
                r8 = 0
                r9 = -1
                if (r5 == r7) goto L_0x0031
                if (r5 == r6) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r19 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.tail
                byte r11 = r10[r8]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r7]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.tailLen = r8
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.tail
                byte r5 = r5[r8]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r19 + 2
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.tailLen = r8
                goto L_0x0053
            L_0x0050:
                r11 = r19
                r10 = r9
            L_0x0053:
                r5 = 19
                r12 = 13
                r13 = 4
                r14 = 10
                if (r10 == r9) goto L_0x0090
                int r9 = r10 >> 18
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r8] = r9
                int r9 = r10 >> 12
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r7] = r9
                int r9 = r10 >> 6
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r6] = r9
                r9 = r10 & 63
                byte r9 = r1[r9]
                r10 = 3
                r2[r10] = r9
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008e
                boolean r3 = r0.do_cr
                if (r3 == 0) goto L_0x0087
                r2[r13] = r12
                r3 = 5
                goto L_0x0088
            L_0x0087:
                r3 = r13
            L_0x0088:
                int r9 = r3 + 1
                r2[r3] = r14
                r3 = r5
                goto L_0x0091
            L_0x008e:
                r9 = r13
                goto L_0x0091
            L_0x0090:
                r9 = r8
            L_0x0091:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00ee
                byte r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                r20 = r6
                byte r6 = r18[r16]
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << 8
                r6 = r6 | r15
                int r11 = r11 + 2
                byte r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r6 = r6 | r11
                int r11 = r6 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r9] = r11
                int r11 = r9 + 1
                int r15 = r6 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r9 + 2
                int r15 = r6 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r9 + 3
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r11] = r6
                int r6 = r9 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e9
                boolean r3 = r0.do_cr
                if (r3 == 0) goto L_0x00e0
                int r9 = r9 + 5
                r2[r6] = r12
                r6 = r9
            L_0x00e0:
                int r9 = r6 + 1
                r2[r6] = r14
                r6 = r20
                r3 = r5
                r11 = r10
                goto L_0x0091
            L_0x00e9:
                r9 = r6
                r11 = r10
                r6 = r20
                goto L_0x0091
            L_0x00ee:
                r20 = r6
                if (r21 == 0) goto L_0x01bb
                int r6 = r0.tailLen
                int r10 = r11 - r6
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0140
                if (r6 <= 0) goto L_0x0104
                byte[] r4 = r0.tail
                byte r4 = r4[r8]
                r8 = r7
                goto L_0x0106
            L_0x0104:
                byte r4 = r18[r11]
            L_0x0106:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r13
                int r6 = r6 - r8
                r0.tailLen = r6
                int r5 = r9 + 1
                int r6 = r4 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r9 + 2
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.do_padding
                if (r1 == 0) goto L_0x012a
                int r1 = r9 + 3
                r2[r6] = r16
                int r6 = r9 + 4
                r2[r1] = r16
            L_0x012a:
                boolean r1 = r0.do_newline
                if (r1 == 0) goto L_0x013d
                boolean r1 = r0.do_cr
                if (r1 == 0) goto L_0x0137
                int r1 = r6 + 1
                r2[r6] = r12
                r6 = r1
            L_0x0137:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x01b9
            L_0x013d:
                r9 = r6
                goto L_0x01e5
            L_0x0140:
                int r10 = r11 - r6
                int r4 = r4 + -2
                if (r10 != r4) goto L_0x01a4
                if (r6 <= r7) goto L_0x014e
                byte[] r4 = r0.tail
                byte r4 = r4[r8]
                r8 = r7
                goto L_0x0154
            L_0x014e:
                int r4 = r11 + 1
                byte r5 = r18[r11]
                r11 = r4
                r4 = r5
            L_0x0154:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                if (r6 <= 0) goto L_0x0161
                byte[] r5 = r0.tail
                int r10 = r8 + 1
                byte r5 = r5[r8]
                r8 = r10
                goto L_0x0163
            L_0x0161:
                byte r5 = r18[r11]
            L_0x0163:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 2
                r4 = r4 | r5
                int r6 = r6 - r8
                r0.tailLen = r6
                int r5 = r9 + 1
                int r6 = r4 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r9 + 2
                int r8 = r4 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r5] = r8
                int r5 = r9 + 3
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.do_padding
                if (r1 == 0) goto L_0x0190
                int r9 = r9 + 4
                r2[r5] = r16
                r5 = r9
            L_0x0190:
                boolean r1 = r0.do_newline
                if (r1 == 0) goto L_0x01a2
                boolean r1 = r0.do_cr
                if (r1 == 0) goto L_0x019d
                int r1 = r5 + 1
                r2[r5] = r12
                r5 = r1
            L_0x019d:
                int r1 = r5 + 1
                r2[r5] = r14
                goto L_0x01b9
            L_0x01a2:
                r9 = r5
                goto L_0x01e5
            L_0x01a4:
                boolean r1 = r0.do_newline
                if (r1 == 0) goto L_0x01e5
                if (r9 <= 0) goto L_0x01e5
                if (r3 == r5) goto L_0x01e5
                boolean r1 = r0.do_cr
                if (r1 == 0) goto L_0x01b5
                int r1 = r9 + 1
                r2[r9] = r12
                r9 = r1
            L_0x01b5:
                int r1 = r9 + 1
                r2[r9] = r14
            L_0x01b9:
                r9 = r1
                goto L_0x01e5
            L_0x01bb:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01cc
                byte[] r1 = r0.tail
                int r2 = r0.tailLen
                int r4 = r2 + 1
                r0.tailLen = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01e5
            L_0x01cc:
                int r4 = r4 + -2
                if (r11 != r4) goto L_0x01e5
                byte[] r1 = r0.tail
                int r2 = r0.tailLen
                int r4 = r2 + 1
                r0.tailLen = r4
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r2 + 2
                r0.tailLen = r2
                int r11 = r11 + r7
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01e5:
                r0.op = r9
                r0.count = r3
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.megatronking.stringfog.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }
}
