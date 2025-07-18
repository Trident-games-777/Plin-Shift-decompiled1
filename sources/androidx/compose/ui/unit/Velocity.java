package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 22\u00020\u0001:\u00012B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0002ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010%J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u0019J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u0019J\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0001\u0002\u0001\u00020\u0003\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/compose/ui/unit/Velocity;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OhffZ5M", "(JFF)J", "div", "operand", "div-adjELrA", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-AH228Gc", "(JJ)J", "plus", "plus-AH228Gc", "rem", "rem-adjELrA", "times", "times-adjELrA", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-9UxMQ8M", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Velocity.kt */
public final class Velocity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Zero = m7344constructorimpl(0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Velocity m7341boximpl(long j) {
        return new Velocity(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m7344constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7348equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).m7359unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7349equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7352hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m7348equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m7352hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m7359unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m7342component1impl(long j) {
        return m7350getXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m7343component2impl(long j) {
        return m7351getYimpl(j);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/Velocity$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/Velocity;", "getZero-9UxMQ8M$annotations", "getZero-9UxMQ8M", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Velocity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-9UxMQ8M$annotations  reason: not valid java name */
        public static /* synthetic */ void m7360getZero9UxMQ8M$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-9UxMQ8M  reason: not valid java name */
        public final long m7361getZero9UxMQ8M() {
            return Velocity.Zero;
        }
    }

    /* renamed from: unaryMinus-9UxMQ8M  reason: not valid java name */
    public static final long m7358unaryMinus9UxMQ8M(long j) {
        return m7344constructorimpl(j ^ -9223372034707292160L);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7357toStringimpl(long j) {
        return "(" + m7350getXimpl(j) + ", " + m7351getYimpl(j) + ") px/sec";
    }

    public String toString() {
        return m7357toStringimpl(this.packedValue);
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m7350getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m7351getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: copy-OhffZ5M  reason: not valid java name */
    public static final long m7345copyOhffZ5M(long j, float f, float f2) {
        return m7344constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }

    /* renamed from: copy-OhffZ5M$default  reason: not valid java name */
    public static /* synthetic */ long m7346copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m7345copyOhffZ5M(j, f, f2);
    }

    /* renamed from: minus-AH228Gc  reason: not valid java name */
    public static final long m7353minusAH228Gc(long j, long j2) {
        return m7344constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    /* renamed from: plus-AH228Gc  reason: not valid java name */
    public static final long m7354plusAH228Gc(long j, long j2) {
        return m7344constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    /* renamed from: times-adjELrA  reason: not valid java name */
    public static final long m7356timesadjELrA(long j, float f) {
        return m7344constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) * f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) * f)) & 4294967295L));
    }

    /* renamed from: div-adjELrA  reason: not valid java name */
    public static final long m7347divadjELrA(long j, float f) {
        return m7344constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) / f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) / f)) & 4294967295L));
    }

    /* renamed from: rem-adjELrA  reason: not valid java name */
    public static final long m7355remadjELrA(long j, float f) {
        return m7344constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) % f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) % f)) & 4294967295L));
    }
}
