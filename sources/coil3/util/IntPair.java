package coil3.util;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\u0001\u0002\u0001\u00020\u0003¨\u0006\u0013"}, d2 = {"Lcoil3/util/IntPair;", "", "value", "", "constructor-impl", "(J)J", "first", "", "second", "(II)J", "getFirst-impl", "(J)I", "getSecond-impl", "equals", "", "other", "hashCode", "toString", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* compiled from: collections.kt */
public final class IntPair {
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntPair m7552boximpl(long j) {
        return new IntPair(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m7554constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7555equalsimpl(long j, Object obj) {
        return (obj instanceof IntPair) && j == ((IntPair) obj).m7561unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7556equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFirst-impl  reason: not valid java name */
    public static final int m7557getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: getSecond-impl  reason: not valid java name */
    public static final int m7558getSecondimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7559hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7560toStringimpl(long j) {
        return "IntPair(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m7555equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7559hashCodeimpl(this.value);
    }

    public String toString() {
        return m7560toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m7561unboximpl() {
        return this.value;
    }

    private /* synthetic */ IntPair(long j) {
        this.value = j;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m7553constructorimpl(int i, int i2) {
        return m7554constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }
}
