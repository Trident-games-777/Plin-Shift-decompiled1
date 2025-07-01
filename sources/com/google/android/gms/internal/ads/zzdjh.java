package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdjh {
    zzbgz zza;
    zzbgw zzb;
    zzbhm zzc;
    zzbhj zzd;
    zzbmk zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdjh zza(zzbgw zzbgw) {
        this.zzb = zzbgw;
        return this;
    }

    public final zzdjh zzb(zzbgz zzbgz) {
        this.zza = zzbgz;
        return this;
    }

    public final zzdjh zzc(String str, zzbhf zzbhf, zzbhc zzbhc) {
        this.zzf.put(str, zzbhf);
        if (zzbhc != null) {
            this.zzg.put(str, zzbhc);
        }
        return this;
    }

    public final zzdjh zzd(zzbmk zzbmk) {
        this.zze = zzbmk;
        return this;
    }

    public final zzdjh zze(zzbhj zzbhj) {
        this.zzd = zzbhj;
        return this;
    }

    public final zzdjh zzf(zzbhm zzbhm) {
        this.zzc = zzbhm;
        return this;
    }

    public final zzdjj zzg() {
        return new zzdjj(this);
    }
}
