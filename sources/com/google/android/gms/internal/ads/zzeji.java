package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeji implements zzefh {
    private final Context zza;
    private final Executor zzb;
    private final zzdow zzc;

    public zzeji(Context context, Executor executor, zzdow zzdow) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdow;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzdos zze = this.zzc.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdot(new zzejh(zzefe)));
        zze.zzd().zzo(new zzcmr((zzfgm) zzefe.zzb), this.zzb);
        ((zzegx) zzefe.zzc).zzc(zze.zzn());
        return zze.zzi();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        try {
            zzffo zzffo = zzfff.zza.zza;
            if (zzffo.zzo.zza == 3) {
                ((zzfgm) zzefe.zzb).zzr(this.zza, zzffo.zzd, zzfet.zzv.toString(), (zzbpm) zzefe.zzc);
            } else {
                ((zzfgm) zzefe.zzb).zzq(this.zza, zzffo.zzd, zzfet.zzv.toString(), (zzbpm) zzefe.zzc);
            }
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzefe.zza)), e);
        }
    }
}
