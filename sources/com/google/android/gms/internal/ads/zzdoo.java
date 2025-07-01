package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdoo implements zzbki {
    private final zzcxt zza;
    private final zzbwv zzb;
    private final String zzc;
    private final String zzd;

    public zzdoo(zzcxt zzcxt, zzfet zzfet) {
        this.zza = zzcxt;
        this.zzb = zzfet.zzl;
        this.zzc = zzfet.zzj;
        this.zzd = zzfet.zzk;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzbwv zzbwv) {
        int i;
        String str;
        zzbwv zzbwv2 = this.zzb;
        if (zzbwv2 != null) {
            zzbwv = zzbwv2;
        }
        if (zzbwv != null) {
            str = zzbwv.zza;
            i = zzbwv.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbwg(str, i), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
