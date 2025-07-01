package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

@JvmInline
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b@\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0013\u0010\u0017\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001b\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b.\u0010(J\u0013\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\nJ\r\u00101\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\bL\u0010@J\u0013\u0010M\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\nJ\u0018\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0001\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Float16.kt */
public final class Float16 implements Comparable<Float16> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final short Epsilon = m4349constructorimpl(5120);
    /* access modifiers changed from: private */
    public static final short LowestValue = m4349constructorimpl(-1025);
    public static final int MaxExponent = 15;
    /* access modifiers changed from: private */
    public static final short MaxValue = m4349constructorimpl(31743);
    public static final int MinExponent = -14;
    /* access modifiers changed from: private */
    public static final short MinNormal = m4349constructorimpl(1024);
    /* access modifiers changed from: private */
    public static final short MinValue = m4349constructorimpl(1);
    /* access modifiers changed from: private */
    public static final short NaN = m4349constructorimpl(32256);
    /* access modifiers changed from: private */
    public static final short NegativeInfinity = m4349constructorimpl(-1024);
    /* access modifiers changed from: private */
    public static final short NegativeZero = m4349constructorimpl((short) ShortCompanionObject.MIN_VALUE);
    /* access modifiers changed from: private */
    public static final short PositiveInfinity = m4349constructorimpl(31744);
    /* access modifiers changed from: private */
    public static final short PositiveZero = m4349constructorimpl(0);
    public static final int Size = 16;
    private final short halfValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Float16 m4344boximpl(short s) {
        return new Float16(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m4349constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4350equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m4375unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4351equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: getExponent-impl  reason: not valid java name */
    public static final int m4353getExponentimpl(short s) {
        return ((s >>> 10) & 31) - 15;
    }

    /* renamed from: getSignificand-impl  reason: not valid java name */
    public static final int m4355getSignificandimpl(short s) {
        return s & 1023;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4356hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m4357isFiniteimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) != 31744;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m4358isInfiniteimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) == 31744;
    }

    /* renamed from: isNaN-impl  reason: not valid java name */
    public static final boolean m4359isNaNimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) > 31744;
    }

    /* renamed from: isNormalized-impl  reason: not valid java name */
    public static final boolean m4360isNormalizedimpl(short s) {
        short s2 = s & 31744;
        return (s2 == 0 || s2 == 31744) ? false : true;
    }

    /* renamed from: toRawBits-impl  reason: not valid java name */
    public static final int m4369toRawBitsimpl(short s) {
        return s & UShort.MAX_VALUE;
    }

    public boolean equals(Object obj) {
        return m4350equalsimpl(this.halfValue, obj);
    }

    public int hashCode() {
        return m4356hashCodeimpl(this.halfValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m4375unboximpl() {
        return this.halfValue;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m4374compareTo41bOqos(((Float16) obj).m4375unboximpl());
    }

    private /* synthetic */ Float16(short s) {
        this.halfValue = s;
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m4347constructorimpl(double d) {
        return m4348constructorimpl((float) d);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m4363toByteimpl(short s) {
        return (byte) ((int) m4365toFloatimpl(s));
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m4370toShortimpl(short s) {
        return (short) ((int) m4365toFloatimpl(s));
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m4367toIntimpl(short s) {
        return (int) m4365toFloatimpl(s);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m4368toLongimpl(short s) {
        return (long) m4365toFloatimpl(s);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m4364toDoubleimpl(short s) {
        return (double) m4365toFloatimpl(s);
    }

    /* renamed from: toBits-impl  reason: not valid java name */
    public static final int m4362toBitsimpl(short s) {
        return m4359isNaNimpl(s) ? NaN : s & UShort.MAX_VALUE;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4371toStringimpl(short s) {
        return String.valueOf(m4365toFloatimpl(s));
    }

    public String toString() {
        return m4371toStringimpl(this.halfValue);
    }

    /* renamed from: compareTo-41bOqos  reason: not valid java name */
    public int m4374compareTo41bOqos(short s) {
        return m4346compareTo41bOqos(this.halfValue, s);
    }

    /* renamed from: compareTo-41bOqos  reason: not valid java name */
    public static int m4346compareTo41bOqos(short s, short s2) {
        if (m4359isNaNimpl(s)) {
            return m4359isNaNimpl(s2) ^ true ? 1 : 0;
        }
        if (m4359isNaNimpl(s2)) {
            return -1;
        }
        return Intrinsics.compare((s & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE, (s2 & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s2 & UShort.MAX_VALUE) : s2 & UShort.MAX_VALUE);
    }

    /* renamed from: getSign-slo4al4  reason: not valid java name */
    public static final short m4354getSignslo4al4(short s) {
        if (m4359isNaNimpl(s)) {
            return NaN;
        }
        if (m4346compareTo41bOqos(s, NegativeZero) < 0) {
            return Float16Kt.NegativeOne;
        }
        return m4346compareTo41bOqos(s, PositiveZero) > 0 ? Float16Kt.One : s;
    }

    /* renamed from: withSign-qCeQghg  reason: not valid java name */
    public static final short m4373withSignqCeQghg(short s, short s2) {
        return m4349constructorimpl((short) ((s & ShortCompanionObject.MAX_VALUE) | (s2 & ShortCompanionObject.MIN_VALUE)));
    }

    /* renamed from: absoluteValue-slo4al4  reason: not valid java name */
    public static final short m4343absoluteValueslo4al4(short s) {
        return m4349constructorimpl((short) (s & ShortCompanionObject.MAX_VALUE));
    }

    /* renamed from: round-slo4al4  reason: not valid java name */
    public static final short m4361roundslo4al4(short s) {
        short s2 = UShort.MAX_VALUE;
        short s3 = s & UShort.MAX_VALUE;
        short s4 = s & ShortCompanionObject.MAX_VALUE;
        if (s4 < 15360) {
            short s5 = s & ShortCompanionObject.MIN_VALUE;
            if (s4 < 14336) {
                s2 = 0;
            }
            s3 = s5 | (s2 & 15360);
        } else if (s4 < 25600) {
            int i = s4 >> 10;
            s3 = (s3 + (1 << (24 - i))) & (~((1 << (25 - i)) - 1));
        }
        return m4349constructorimpl((short) s3);
    }

    /* renamed from: ceil-slo4al4  reason: not valid java name */
    public static final short m4345ceilslo4al4(short s) {
        short s2 = 65535 & s;
        short s3 = s & ShortCompanionObject.MAX_VALUE;
        int i = 1;
        if (s3 < 15360) {
            short s4 = s & ShortCompanionObject.MIN_VALUE;
            int i2 = ~(s2 >> 15);
            if (s3 == 0) {
                i = 0;
            }
            s2 = ((-(i2 & i)) & 15360) | s4;
        } else if (s3 < 25600) {
            int i3 = (1 << (25 - (s3 >> 10))) - 1;
            s2 = (s2 + (((s2 >> 15) - 1) & i3)) & (~i3);
        }
        return m4349constructorimpl((short) s2);
    }

    /* renamed from: floor-slo4al4  reason: not valid java name */
    public static final short m4352floorslo4al4(short s) {
        short s2 = UShort.MAX_VALUE;
        short s3 = s & UShort.MAX_VALUE;
        short s4 = s & ShortCompanionObject.MAX_VALUE;
        if (s4 < 15360) {
            short s5 = s & ShortCompanionObject.MIN_VALUE;
            if (s3 <= 32768) {
                s2 = 0;
            }
            s3 = s5 | (s2 & 15360);
        } else if (s4 < 25600) {
            int i = (1 << (25 - (s4 >> 10))) - 1;
            s3 = (s3 + ((-(s3 >> 15)) & i)) & (~i);
        }
        return m4349constructorimpl((short) s3);
    }

    /* renamed from: trunc-slo4al4  reason: not valid java name */
    public static final short m4372truncslo4al4(short s) {
        short s2 = 65535 & s;
        short s3 = s & ShortCompanionObject.MAX_VALUE;
        if (s3 < 15360) {
            s2 = 32768 & s;
        } else if (s3 < 25600) {
            s2 &= ~((1 << (25 - (s3 >> 10))) - 1);
        }
        return m4349constructorimpl((short) s2);
    }

    /* renamed from: toHexString-impl  reason: not valid java name */
    public static final String m4366toHexStringimpl(short s) {
        StringBuilder sb = new StringBuilder();
        short s2 = 65535 & s;
        int i = s2 >>> 15;
        int i2 = (s2 >>> 10) & 31;
        short s3 = s & 1023;
        if (i2 != 31) {
            if (i == 1) {
                sb.append('-');
            }
            if (i2 != 0) {
                sb.append("0x1.");
                String num = Integer.toString(s3, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(num, ""));
                sb.append('p');
                sb.append(String.valueOf(i2 - 15));
            } else if (s3 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                String num2 = Integer.toString(s3, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(num2, ""));
                sb.append("p-14");
            }
        } else if (s3 == 0) {
            if (i != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0014\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001a\u0010\u0006R\u0019\u0010\u001b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001c\u0010\u0006R\u000e\u0010\u001d\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Float16.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEpsilon-slo4al4  reason: not valid java name */
        public final short m4376getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4  reason: not valid java name */
        public final short m4377getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4  reason: not valid java name */
        public final short m4378getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4  reason: not valid java name */
        public final short m4379getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4  reason: not valid java name */
        public final short m4380getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4  reason: not valid java name */
        public final short m4381getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4  reason: not valid java name */
        public final short m4382getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4  reason: not valid java name */
        public final short m4383getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4  reason: not valid java name */
        public final short m4384getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4  reason: not valid java name */
        public final short m4385getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m4348constructorimpl(float f) {
        int i;
        int i2;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int i3 = floatToRawIntBits >>> 31;
        int i4 = (floatToRawIntBits >>> 23) & 255;
        int i5 = 8388607 & floatToRawIntBits;
        int i6 = 31;
        int i7 = 0;
        if (i4 == 255) {
            if (i5 != 0) {
                i2 = 512;
            }
            i = (i3 << 15) | (i6 << 10) | i7;
            return m4349constructorimpl((short) i);
        }
        int i8 = i4 - 112;
        if (i8 >= 31) {
            i6 = 49;
        } else if (i8 > 0) {
            i7 = i5 >> 13;
            if ((floatToRawIntBits & 4096) != 0) {
                i = (((i8 << 10) | i7) + 1) | (i3 << 15);
                return m4349constructorimpl((short) i);
            }
            i6 = i8;
        } else if (i8 >= -10) {
            int i9 = (8388608 | i5) >> (1 - i8);
            if ((i9 & 4096) != 0) {
                i9 += 8192;
            }
            i2 = i9 >> 13;
            i6 = 0;
        } else {
            i6 = 0;
        }
        i = (i3 << 15) | (i6 << 10) | i7;
        return m4349constructorimpl((short) i);
        i7 = i2;
        i = (i3 << 15) | (i6 << 10) | i7;
        return m4349constructorimpl((short) i);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m4365toFloatimpl(short s) {
        int i;
        int i2;
        int i3;
        short s2 = 32768 & s;
        int i4 = ((65535 & s) >>> 10) & 31;
        short s3 = s & 1023;
        if (i4 != 0) {
            int i5 = s3 << 13;
            if (i4 == 31) {
                i3 = 255;
                if (i5 != 0) {
                    i5 |= 4194304;
                }
            } else {
                i3 = i4 + 112;
            }
            int i6 = i3;
            i2 = i5;
            i = i6;
        } else if (s3 != 0) {
            float intBitsToFloat = Float.intBitsToFloat(s3 + 1056964608) - Float16Kt.Fp32DenormalFloat;
            return s2 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i << 23) | (s2 << 16) | i2);
    }
}
