package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgcq extends AbstractList implements RandomAccess, Serializable {
    final int[] zza;
    final int zzb;
    final int zzc;

    zzgcq(int[] iArr, int i, int i2) {
        this.zza = iArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return (obj instanceof Integer) && zzgcr.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc) != -1;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgcq)) {
            return super.equals(obj);
        }
        zzgcq zzgcq = (zzgcq) obj;
        int i = this.zzc - this.zzb;
        if (zzgcq.zzc - zzgcq.zzb != i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[this.zzb + i2] != zzgcq.zza[zzgcq.zzb + i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfwq.zza(i, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        return Integer.valueOf(this.zza[this.zzb + i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = this.zzb; i2 < this.zzc; i2++) {
            i = (i * 31) + this.zza[i2];
        }
        return i;
    }

    public final int indexOf(@CheckForNull Object obj) {
        int zza2;
        if (!(obj instanceof Integer) || (zza2 = zzgcr.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc)) < 0) {
            return -1;
        }
        return zza2 - this.zzb;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.zza;
            int intValue = ((Integer) obj).intValue();
            int i = this.zzb;
            int i2 = this.zzc - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                } else if (iArr[i2] == intValue) {
                    break;
                } else {
                    i2--;
                }
            }
            if (i2 >= 0) {
                return i2 - this.zzb;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        zzfwq.zza(i, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        int[] iArr = this.zza;
        int i2 = this.zzb + i;
        int i3 = iArr[i2];
        num.getClass();
        Integer num2 = num;
        iArr[i2] = num.intValue();
        return Integer.valueOf(i3);
    }

    public final int size() {
        return this.zzc - this.zzb;
    }

    public final List subList(int i, int i2) {
        zzfwq.zzj(i, i2, this.zzc - this.zzb);
        if (i == i2) {
            return Collections.emptyList();
        }
        int[] iArr = this.zza;
        int i3 = this.zzb;
        return new zzgcq(iArr, i3 + i, i2 + i3);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 5);
        sb.append('[');
        sb.append(this.zza[this.zzb]);
        int i = this.zzb;
        while (true) {
            i++;
            if (i < this.zzc) {
                sb.append(", ");
                sb.append(this.zza[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
