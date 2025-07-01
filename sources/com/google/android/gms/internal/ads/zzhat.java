package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhat extends zzgxb implements RandomAccess {
    private static final zzhat zza = new zzhat(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    zzhat() {
        this(new Object[10], 0, true);
    }

    public static zzhat zzd() {
        return zza;
    }

    private static int zzg(int i) {
        return ((i * 3) / 2) + 1;
    }

    private final String zzh(int i) {
        int i2 = this.zzc;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void zzi(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    public final void add(int i, Object obj) {
        int i2;
        zzdJ();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        int i3 = i + 1;
        Object[] objArr = this.zzb;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[zzg(i2)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.zzb, i, objArr2, i3, this.zzc - i);
            this.zzb = objArr2;
        }
        this.zzb[i] = obj;
        this.zzc++;
        this.modCount++;
    }

    public final Object get(int i) {
        zzi(i);
        return this.zzb[i];
    }

    public final Object remove(int i) {
        zzdJ();
        zzi(i);
        Object[] objArr = this.zzb;
        Object obj = objArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i, Object obj) {
        zzdJ();
        zzi(i);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zze(int i) {
        int length = this.zzb.length;
        if (i > length) {
            while (length < i) {
                length = zzg(length);
            }
            this.zzb = Arrays.copyOf(this.zzb, length);
        }
    }

    public final /* bridge */ /* synthetic */ zzgzj zzf(int i) {
        if (i >= this.zzc) {
            return new zzhat(Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzhat(Object[] objArr, int i, boolean z) {
        super(z);
        this.zzb = objArr;
        this.zzc = i;
    }

    public final boolean add(Object obj) {
        zzdJ();
        int i = this.zzc;
        Object[] objArr = this.zzb;
        if (i == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, zzg(i));
        }
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }
}
