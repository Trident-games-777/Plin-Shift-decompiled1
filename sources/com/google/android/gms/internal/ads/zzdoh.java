package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdoh {
    private final zzcwk zza;
    private final zzcxt zzb;
    private final zzcyg zzc;
    private final zzcys zzd;
    private final zzdbi zze;
    private final zzdej zzf;
    private final zzdsm zzg;
    private final zzflr zzh;
    private final zzedp zzi;
    private final zzcnb zzj;

    zzdoh(zzcwk zzcwk, zzcxt zzcxt, zzcyg zzcyg, zzcys zzcys, zzdbi zzdbi, zzdej zzdej, zzdsm zzdsm, zzflr zzflr, zzedp zzedp, zzcnb zzcnb) {
        this.zza = zzcwk;
        this.zzb = zzcxt;
        this.zzc = zzcyg;
        this.zzd = zzcys;
        this.zze = zzdbi;
        this.zzf = zzdej;
        this.zzg = zzdsm;
        this.zzh = zzflr;
        this.zzi = zzedp;
        this.zzj = zzcnb;
    }

    public final void zza(zzdoi zzdoi, zzcfk zzcfk) {
        zzdof zza2 = zzdoi.zza;
        zzcxt zzcxt = this.zzb;
        Objects.requireNonNull(zzcxt);
        zza2.zzi(this.zza, this.zzc, this.zzd, this.zze, new zzdog(zzcxt), this.zzf);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjO)).booleanValue() && zzcfk != null && zzcfk.zzN() != null) {
            zzchc zzN = zzcfk.zzN();
            zzN.zzJ(this.zzj, this.zzi, this.zzh);
            zzN.zzL(this.zzj, this.zzi, this.zzg);
        }
    }
}
