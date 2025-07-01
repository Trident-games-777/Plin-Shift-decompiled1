package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/BitVector;", "", "()V", "first", "", "others", "", "second", "size", "", "getSize", "()I", "get", "", "index", "nextClear", "nextSet", "set", "", "value", "setRange", "start", "end", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class BitVector {
    public static final int $stable = 8;
    private long first;
    private long[] others;
    private long second;

    public final int getSize() {
        long[] jArr = this.others;
        if (jArr != null) {
            return (jArr.length + 2) * 64;
        }
        return 128;
    }

    public final boolean get(int i) {
        int i2;
        if (i < 0 || i >= getSize()) {
            throw new IllegalStateException(("Index " + i + " out of bound").toString());
        } else if (i < 64) {
            return ((1 << i) & this.first) != 0;
        } else if (i < 128) {
            return ((1 << (i - 64)) & this.second) != 0;
        } else {
            long[] jArr = this.others;
            if (jArr == null || (i / 64) - 2 >= jArr.length) {
                return false;
            }
            return ((1 << (i % 64)) & jArr[i2]) != 0;
        }
    }

    public final void set(int i, boolean z) {
        if (i < 64) {
            long j = 1 << i;
            this.first = z ? this.first | j : this.first & (~j);
        } else if (i < 128) {
            long j2 = 1 << (i - 64);
            this.second = z ? this.second | j2 : this.second & (~j2);
        } else {
            int i2 = i / 64;
            int i3 = i2 - 2;
            long j3 = 1 << (i % 64);
            long[] jArr = this.others;
            if (jArr == null) {
                BitVector bitVector = this;
                jArr = new long[(i2 - 1)];
                this.others = jArr;
            }
            if (i3 >= jArr.length) {
                jArr = Arrays.copyOf(jArr, i2 - 1);
                Intrinsics.checkNotNullExpressionValue(jArr, "copyOf(this, newSize)");
                this.others = jArr;
            }
            long j4 = jArr[i3];
            jArr[i3] = z ? j3 | j4 : (~j3) & j4;
        }
    }

    public final int nextSet(int i) {
        int size = getSize();
        while (i < size) {
            if (get(i)) {
                return i;
            }
            i++;
        }
        return Integer.MAX_VALUE;
    }

    public final int nextClear(int i) {
        int size = getSize();
        while (i < size) {
            if (!get(i)) {
                return i;
            }
            i++;
        }
        return Integer.MAX_VALUE;
    }

    public final void setRange(int i, int i2) {
        while (i < i2) {
            set(i, true);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BitVector [");
        int size = getSize();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            if (get(i)) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i);
                z = false;
            }
        }
        sb.append(']');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
