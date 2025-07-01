package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"androidx/navigation/NavType$Companion$LongArrayType$1", "Landroidx/navigation/CollectionNavType;", "", "name", "", "getName", "()Ljava/lang/String;", "emptyCollection", "get", "bundle", "Landroid/os/Bundle;", "key", "parseValue", "value", "previousValue", "put", "", "serializeAsValues", "", "valueEquals", "", "other", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavType.kt */
public final class NavType$Companion$LongArrayType$1 extends CollectionNavType<long[]> {
    public long[] emptyCollection() {
        return new long[0];
    }

    NavType$Companion$LongArrayType$1() {
        super(true);
    }

    public String getName() {
        return "long[]";
    }

    public void put(Bundle bundle, String str, long[] jArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putLongArray(str, jArr);
    }

    public long[] get(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        return (long[]) bundle.get(str);
    }

    public long[] parseValue(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new long[]{NavType.LongType.parseValue(str).longValue()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.ArraysKt.plus(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long[] parseValue(java.lang.String r2, long[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0013
            long[] r0 = r1.parseValue((java.lang.String) r2)
            long[] r3 = kotlin.collections.ArraysKt.plus((long[]) r3, (long[]) r0)
            if (r3 != 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            return r3
        L_0x0013:
            long[] r2 = r1.parseValue((java.lang.String) r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$LongArrayType$1.parseValue(java.lang.String, long[]):long[]");
    }

    public boolean valueEquals(long[] jArr, long[] jArr2) {
        Long[] lArr = null;
        Long[] typedArray = jArr != null ? ArraysKt.toTypedArray(jArr) : null;
        if (jArr2 != null) {
            lArr = ArraysKt.toTypedArray(jArr2);
        }
        return ArraysKt.contentDeepEquals(typedArray, lArr);
    }

    public List<String> serializeAsValues(long[] jArr) {
        List<Long> list;
        if (jArr == null || (list = ArraysKt.toList(jArr)) == null) {
            return CollectionsKt.emptyList();
        }
        Iterable<Number> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Number longValue : iterable) {
            arrayList.add(String.valueOf(longValue.longValue()));
        }
        return (List) arrayList;
    }
}
