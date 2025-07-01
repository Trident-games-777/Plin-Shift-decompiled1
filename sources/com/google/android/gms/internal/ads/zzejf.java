package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzejf implements zzhfx {
    private final zzeje zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzejf(zzeje zzeje, zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzeje;
        this.zzb = zzhgp;
        this.zzc = zzhgp2;
        this.zzd = zzhgp3;
        this.zze = zzhgp4;
    }

    public final /* synthetic */ Object zzb() {
        zzeix zza2 = ((zzeiy) this.zzc).zzb();
        zzeix zzeix = zza2;
        zzeiv zza3 = this.zza.zza((Clock) this.zzb.zzb(), zza2, (zzefg) this.zzd.zzb(), (zzflr) this.zze.zzb());
        zzeiv zzeiv = zza3;
        return zza3;
    }
}
