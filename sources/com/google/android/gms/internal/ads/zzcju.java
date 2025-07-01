package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcju implements zzfcz {
    private final zzciy zza;
    private final zzhgg zzb;
    private final zzhgg zzc;
    private final zzhgg zzd;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;
    private final zzhgg zzh;

    /* synthetic */ zzcju(zzciy zzciy, Context context, String str, zzs zzs, zzckd zzckd) {
        this.zza = zzciy;
        zzhfx zza2 = zzhfy.zza(context);
        this.zzb = zza2;
        zzhfx zza3 = zzhfy.zza(zzs);
        this.zzc = zza3;
        zzhfx zza4 = zzhfy.zza(str);
        this.zzd = zza4;
        zzhgg zzc2 = zzhfw.zzc(new zzemt(zzciy.zzM));
        this.zze = zzc2;
        zzhgg zzc3 = zzhfw.zzc(new zzfdx(zzciy.zzbd));
        this.zzf = zzc3;
        zzhgg zzc4 = zzhfw.zzc(new zzfcx(zza2, zzciy.zzc, zzciy.zzS, zzc2, zzc3, zzffq.zza()));
        this.zzg = zzc4;
        zzhgg zzhgg = zzc3;
        zzhgg zzhgg2 = zzc2;
        this.zzh = zzhfw.zzc(new zzenb(zza2, zza3, zza4, zzc4, zzhgg2, zzhgg, zzciy.zzl, zzciy.zzU, zzciy.zzM));
    }

    public final zzena zza() {
        return (zzena) this.zzh.zzb();
    }
}
