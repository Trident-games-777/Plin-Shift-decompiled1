package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcji implements zzfbi {
    private final Context zza;
    private final zzs zzb;
    private final String zzc;
    private final zzciy zzd;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;
    private final zzhgg zzh;
    private final zzhgg zzi;
    private final zzhgg zzj;

    /* synthetic */ zzcji(zzciy zzciy, Context context, String str, zzs zzs, zzckd zzckd) {
        this.zzd = zzciy;
        this.zza = context;
        this.zzb = zzs;
        this.zzc = str;
        zzhfx zza2 = zzhfy.zza(context);
        this.zze = zza2;
        zzhfx zza3 = zzhfy.zza(zzs);
        this.zzf = zza3;
        zzhgg zzc2 = zzhfw.zzc(new zzemt(zzciy.zzM));
        this.zzg = zzc2;
        zzhgg zzc3 = zzhfw.zzc(zzemy.zza());
        this.zzh = zzc3;
        zzhgg zzc4 = zzhfw.zzc(zzdbm.zza());
        this.zzi = zzc4;
        this.zzj = zzhfw.zzc(new zzfbg(zza2, zzciy.zzc, zza3, zzciy.zzS, zzc2, zzc3, zzffq.zza(), zzc4));
    }

    public final zzely zza() {
        return new zzely(this.zza, this.zzb, this.zzc, (zzfbf) this.zzj.zzb(), (zzems) this.zzg.zzb(), zzcid.zzc(this.zzd.zza), (zzdsm) this.zzd.zzM.zzb());
    }
}
