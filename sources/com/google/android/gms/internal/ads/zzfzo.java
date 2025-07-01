package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfzo<E> extends zzfzj<E> implements List<E>, RandomAccess {
    private static final zzgbv zza = new zzfzm(zzgba.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzfzo() {
    }

    public static zzfzl zzi(int i) {
        zzfyl.zza(i, "expectedSize");
        return new zzfzl(i);
    }

    static zzfzo zzj(Object[] objArr, int i) {
        if (i == 0) {
            return zzgba.zza;
        }
        return new zzgba(objArr, i);
    }

    public static zzfzo zzl(Collection collection) {
        if (collection instanceof zzfzj) {
            zzfzo zzd2 = ((zzfzj) collection).zzd();
            if (!zzd2.zzf()) {
                return zzd2;
            }
            Object[] array = zzd2.toArray();
            return zzj(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzgay.zzb(array2, length);
        return zzj(array2, length);
    }

    public static zzfzo zzm(Object[] objArr) {
        if (objArr.length == 0) {
            return zzgba.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzgay.zzb(objArr2, length);
        return zzj(objArr2, length);
    }

    public static zzfzo zzn() {
        return zzgba.zza;
    }

    public static zzfzo zzo(Object obj) {
        Object[] objArr = {obj};
        zzgay.zzb(objArr, 1);
        return zzj(objArr, 1);
    }

    public static zzfzo zzp(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzgay.zzb(objArr, 2);
        return zzj(objArr, 2);
    }

    public static zzfzo zzq(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzgay.zzb(objArr, 3);
        return zzj(objArr, 3);
    }

    public static zzfzo zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzgay.zzb(objArr, 5);
        return zzj(objArr, 5);
    }

    public static zzfzo zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {"3010", "3008", "1005", "1009", "2011", "2007"};
        zzgay.zzb(objArr, 6);
        return zzj(objArr, 6);
    }

    @SafeVarargs
    public static zzfzo zzt(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        Object[] objArr2 = objArr;
        int length = objArr2.length;
        int i = length + 12;
        Object[] objArr3 = new Object[i];
        objArr3[0] = obj;
        objArr3[1] = obj2;
        objArr3[2] = obj3;
        objArr3[3] = obj4;
        objArr3[4] = obj5;
        objArr3[5] = obj6;
        objArr3[6] = obj7;
        objArr3[7] = obj8;
        objArr3[8] = obj9;
        objArr3[9] = obj10;
        objArr3[10] = obj11;
        objArr3[11] = obj12;
        System.arraycopy(objArr2, 0, objArr3, 12, length);
        zzgay.zzb(objArr3, i);
        return zzj(objArr3, i);
    }

    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@javax.annotation.CheckForNull java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.List
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.List r7 = (java.util.List) r7
            int r1 = r6.size()
            int r3 = r7.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r3 = r7 instanceof java.util.RandomAccess
            if (r3 == 0) goto L_0x0031
            r3 = r2
        L_0x001c:
            if (r3 >= r1) goto L_0x0030
            java.lang.Object r4 = r6.get(r3)
            java.lang.Object r5 = r7.get(r3)
            boolean r4 = com.google.android.gms.internal.ads.zzfwn.zza(r4, r5)
            if (r4 != 0) goto L_0x002d
            return r2
        L_0x002d:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0030:
            return r0
        L_0x0031:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x0039:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0055
            boolean r3 = r7.hasNext()
            if (r3 != 0) goto L_0x0046
            return r2
        L_0x0046:
            java.lang.Object r3 = r1.next()
            java.lang.Object r4 = r7.next()
            boolean r3 = com.google.android.gms.internal.ads.zzfwn.zza(r3, r4)
            if (r3 != 0) goto L_0x0039
            return r2
        L_0x0055:
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x005c
            return r0
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfzo.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final zzfzo zzd() {
        return this;
    }

    public final zzgbu zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzfzo subList(int i, int i2) {
        zzfwq.zzj(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzgba.zza;
        }
        return new zzfzn(this, i, i3);
    }

    /* renamed from: zzu */
    public final zzgbv listIterator(int i) {
        zzfwq.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzfzm(this, i);
    }

    public static zzfzo zzk(Iterable iterable) {
        iterable.getClass();
        return zzl((Collection) iterable);
    }
}
