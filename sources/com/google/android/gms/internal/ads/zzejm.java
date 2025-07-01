package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzejm implements zzefh {
    private final Context zza;
    private final zzdow zzb;

    public zzejm(Context context, zzdow zzdow) {
        this.zza = context;
        this.zzb = zzdow;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzehg zzehg = new zzehg(zzfet, (zzbrf) zzefe.zzb, AdFormat.REWARDED);
        zzdos zze = this.zzb.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdot(zzehg));
        zzehg.zzb(zze.zzc());
        ((zzegx) zzefe.zzc).zzc(zze.zzo());
        return zze.zzi();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        try {
            ((zzbrf) zzefe.zzb).zzq(zzfet.zzZ);
            if (zzfff.zza.zza.zzo.zza == 3) {
                ((zzbrf) zzefe.zzb).zzo(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejk(this, zzefe, (zzejl) null), (zzbpm) zzefe.zzc);
            } else {
                ((zzbrf) zzefe.zzb).zzp(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejk(this, zzefe, (zzejl) null), (zzbpm) zzefe.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
