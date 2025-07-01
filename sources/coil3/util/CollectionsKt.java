package coil3.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0004\u001a-\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\b0\fH\b\u001a3\u0010\r\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\b0\u000eH\b\u001a?\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u0010*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\t0\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\fH\b\u001a?\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\t0\n2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\fH\b\u001aF\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u0015\u001a\u0002H\u00102\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00100\u000eH\b¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0018\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00100\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\t0\fH\b¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u001d0\fH\b¨\u0006\u001e"}, d2 = {"component1", "", "Lcoil3/util/IntPair;", "component1-wuMLFU8", "(J)I", "component2", "component2-wuMLFU8", "forEachIndices", "", "T", "", "action", "Lkotlin/Function1;", "forEachIndexedIndices", "Lkotlin/Function2;", "mapNotNullIndices", "R", "", "transform", "flatMapIndices", "foldIndices", "initial", "operation", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "firstNotNullOfOrNullIndices", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeIfIndices", "", "predicate", "", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: collections.kt */
public final class CollectionsKt {
    /* renamed from: component1-wuMLFU8  reason: not valid java name */
    public static final int m7550component1wuMLFU8(long j) {
        return IntPair.m7557getFirstimpl(j);
    }

    /* renamed from: component2-wuMLFU8  reason: not valid java name */
    public static final int m7551component2wuMLFU8(long j) {
        return IntPair.m7558getSecondimpl(j);
    }

    public static final <T> void forEachIndices(List<? extends T> list, Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(list.get(i));
        }
    }

    public static final <T> void forEachIndexedIndices(List<? extends T> list, Function2<? super Integer, ? super T, Unit> function2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(i), list.get(i));
        }
    }

    public static final <T, R> List<R> mapNotNullIndices(List<? extends T> list, Function1<? super T, ? extends R> function1) {
        List<R> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object invoke = function1.invoke(list.get(i));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static final <T, R> List<R> flatMapIndices(List<? extends T> list, Function1<? super T, ? extends List<? extends R>> function1) {
        List<R> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            kotlin.collections.CollectionsKt.addAll(arrayList, (Iterable) function1.invoke(list.get(i)));
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> R foldIndices(java.util.List<? extends T> r3, R r4, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r5) {
        /*
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x0015
            java.lang.Object r2 = r3.get(r1)
            java.lang.Object r4 = r5.invoke(r4, r2)
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0015:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.util.CollectionsKt.foldIndices(java.util.List, java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static final <R, T> T firstNotNullOfOrNullIndices(List<? extends R> list, Function1<? super R, ? extends T> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T invoke = function1.invoke(list.get(i));
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    public static final <T> void removeIfIndices(List<T> list, Function1<? super T, Boolean> function1) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 - i;
            if (function1.invoke(list.get(i3)).booleanValue()) {
                list.remove(i3);
                i++;
            }
        }
    }
}
