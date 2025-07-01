package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjd implements zzezu {
    private final zzciy zza;
    private final zzhgg zzb;
    private final zzhgg zzc;
    private final zzhgg zzd;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;

    /* synthetic */ zzcjd(zzciy zzciy, Context context, String str, zzckd zzckd) {
        this.zza = zzciy;
        zzhfx zza2 = zzhfy.zza(context);
        this.zzb = zza2;
        zzhfx zza3 = zzhfy.zza(str);
        this.zzc = zza3;
        zzfcm zzfcm = new zzfcm(zza2, zzciy.zzbd, zzciy.zzbe);
        this.zzd = zzfcm;
        zzhgg zzc2 = zzhfw.zzc(new zzfas(zzciy.zzbd));
        this.zze = zzc2;
        zzhgg zzc3 = zzhfw.zzc(new zzfau(zza2, zzciy.zzc, zzciy.zzS, zzfcm, zzc2, zzffq.zza(), zzciy.zzl));
        this.zzf = zzc3;
        this.zzg = zzhfw.zzc(new zzfba(zzciy.zzS, zza2, zza3, zzc3, zzc2, zzciy.zzl, zzciy.zzM));
    }

    public final zzfaz zza() {
        return (zzfaz) this.zzg.zzb();
    }
}
