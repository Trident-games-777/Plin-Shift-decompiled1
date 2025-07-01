package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzxa implements zzyd {
    protected final zzbw zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzad[] zzd;
    private int zze;

    public zzxa(zzbw zzbw, int[] iArr, int i) {
        int length = iArr.length;
        zzdb.zzf(length > 0);
        zzbw.getClass();
        zzbw zzbw2 = zzbw;
        this.zza = zzbw;
        this.zzb = length;
        this.zzd = new zzad[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzd[i2] = zzbw.zzb(iArr[i2]);
        }
        Arrays.sort(this.zzd, new zzwz());
        this.zzc = new int[this.zzb];
        for (int i3 = 0; i3 < this.zzb; i3++) {
            this.zzc[i3] = zzbw.zza(this.zzd[i3]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxa zzxa = (zzxa) obj;
            return this.zza.equals(zzxa.zza) && Arrays.equals(this.zzc, zzxa.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = identityHashCode;
        return identityHashCode;
    }

    public final int zza(int i) {
        return this.zzc[i];
    }

    public final int zzb(int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (this.zzc[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final int zzc() {
        return this.zzc.length;
    }

    public final zzad zzd(int i) {
        return this.zzd[i];
    }

    public final zzbw zze() {
        return this.zza;
    }
}
