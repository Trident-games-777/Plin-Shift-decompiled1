package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbl;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenf {
    private final zzdjj zza;
    private final zzems zzb;
    private final zzcwp zzc;

    public zzenf(zzdjj zzdjj, zzdsm zzdsm) {
        this.zza = zzdjj;
        zzems zzems = new zzems(zzdsm);
        this.zzb = zzems;
        this.zzc = new zzene(zzems, zzdjj.zzg());
    }

    public final zzcwp zza() {
        return this.zzc;
    }

    public final zzcya zzb() {
        return this.zzb;
    }

    public final zzdhe zzc() {
        return new zzdhe(this.zza, this.zzb.zzg());
    }

    public final zzems zzd() {
        return this.zzb;
    }

    public final void zze(zzbl zzbl) {
        this.zzb.zzj(zzbl);
    }
}
