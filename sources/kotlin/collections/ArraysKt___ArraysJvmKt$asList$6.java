package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$6", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Double;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: _ArraysJvm.kt */
public final class ArraysKt___ArraysJvmKt$asList$6 extends AbstractList<Double> implements RandomAccess {
    final /* synthetic */ double[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$6(double[] dArr) {
        this.$this_asList = dArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Double)) {
            return false;
        }
        return contains(((Number) obj).doubleValue());
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        return indexOf(((Number) obj).doubleValue());
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        return lastIndexOf(((Number) obj).doubleValue());
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(double d) {
        for (double doubleToLongBits : this.$this_asList) {
            if (Double.doubleToLongBits(doubleToLongBits) == Double.doubleToLongBits(d)) {
                return true;
            }
        }
        return false;
    }

    public Double get(int i) {
        return Double.valueOf(this.$this_asList[i]);
    }

    public int indexOf(double d) {
        double[] dArr = this.$this_asList;
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (Double.doubleToLongBits(dArr[i]) == Double.doubleToLongBits(d)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(double d) {
        double[] dArr = this.$this_asList;
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d)) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }
}
