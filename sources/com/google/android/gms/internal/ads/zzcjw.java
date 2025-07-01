package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjw implements zzfen {
    private final zzciy zza;
    private final zzhgg zzb;
    private final zzhgg zzc;
    private final zzhgg zzd;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;
    private final zzhgg zzh;
    private final zzhgg zzi;

    /* synthetic */ zzcjw(zzciy zzciy, Context context, String str, zzckd zzckd) {
        this.zza = zzciy;
        zzhfx zza2 = zzhfy.zza(context);
        this.zzb = zza2;
        zzfcn zzfcn = new zzfcn(zza2, zzciy.zzbd, zzciy.zzbe);
        this.zzc = zzfcn;
        zzhgg zzc2 = zzhfw.zzc(new zzfdx(zzciy.zzbd));
        this.zzd = zzc2;
        zzhgg zzc3 = zzhfw.zzc(zzffl.zza());
        this.zze = zzc3;
        zzfeh zzfeh = new zzfeh(zza2, zzciy.zzc, zzciy.zzS, zzfcn, zzc2, zzffq.zza(), zzc3);
        zzhgg zzhgg = zzc2;
        zzhgg zzhgg2 = zzc3;
        zzhgg zzc4 = zzhfw.zzc(zzfeh);
        this.zzf = zzc4;
        this.zzg = zzhfw.zzc(new zzfer(zzc4, zzhgg, zzhgg2));
        zzhfx zzc5 = zzhfy.zzc(str);
        this.zzh = zzc5;
        zzhfx zzhfx = zza2;
        this.zzi = zzhfw.zzc(new zzfel(zzc5, zzc4, zzhfx, zzhgg, zzhgg2, zzciy.zzl, zzciy.zzU, zzciy.zzM));
    }

    public final zzfek zza() {
        return (zzfek) this.zzi.zzb();
    }

    public final zzfeq zzb() {
        return (zzfeq) this.zzg.zzb();
    }
}
