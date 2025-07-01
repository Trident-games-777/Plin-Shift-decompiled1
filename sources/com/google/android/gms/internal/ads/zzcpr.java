package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcpr implements zzhfx {
    private final zzhgp zza;

    public zzcpr(zzcpk zzcpk, zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzt zzfzt;
        zzcqs zza2 = ((zzcqt) this.zza).zzb();
        zzcqs zzcqs = zza2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmm)).booleanValue()) {
            zzfzt = zzfzt.zzo(new zzded(zza2, zzcaj.zza));
        } else {
            zzfzt = zzfzt.zzn();
        }
        zzhgf.zzb(zzfzt);
        return zzfzt;
    }
}
