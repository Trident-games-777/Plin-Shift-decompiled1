package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzko {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzko(zzkm zzkm, zzkn zzkn) {
        this.zza = zzkm.zza;
        this.zzb = zzkm.zzb;
        this.zzc = zzkm.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzko)) {
            return false;
        }
        zzko zzko = (zzko) obj;
        return this.zza == zzko.zza && this.zzb == zzko.zzb && this.zzc == zzko.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final zzkm zza() {
        return new zzkm(this, (zzkn) null);
    }
}
