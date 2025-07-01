package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzefq implements zzefh {
    private final Context zza;
    private final zzcor zzb;
    private final Executor zzc;

    zzefq(Context context, zzcor zzcor, Executor executor) {
        this.zza = context;
        this.zzb = zzcor;
        this.zzc = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzcoo zza2 = this.zzb.zza(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdfn(new zzefp(zzefe), (zzcfk) null), new zzcop(zzfet.zzaa));
        zza2.zzd().zzo(new zzcmr((zzfgm) zzefe.zzb), this.zzc);
        ((zzegx) zzefe.zzc).zzc(zza2.zzk());
        return zza2.zza();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        zzffo zzffo = zzfff.zza.zza;
        String jSONObject = zzfet.zzv.toString();
        ((zzfgm) zzefe.zzb).zzl(this.zza, zzffo.zzd, jSONObject, (zzbpm) zzefe.zzc);
    }
}
