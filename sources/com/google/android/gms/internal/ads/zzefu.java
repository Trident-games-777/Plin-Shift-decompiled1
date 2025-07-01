package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzefu implements zzefh {
    private final Context zza;
    private final zzcor zzb;

    zzefu(Context context, zzcor zzcor) {
        this.zza = context;
        this.zzb = zzcor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzehg zzehg = new zzehg(zzfet, (zzbrf) zzefe.zzb, AdFormat.APP_OPEN_AD);
        zzcoo zza2 = this.zzb.zza(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdfn(zzehg, (zzcfk) null), new zzcop(zzfet.zzaa));
        zzehg.zzb(zza2.zzc());
        ((zzegx) zzefe.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        try {
            ((zzbrf) zzefe.zzb).zzq(zzfet.zzZ);
            ((zzbrf) zzefe.zzb).zzi(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefs(zzefe, (zzeft) null), (zzbpm) zzefe.zzc);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zze.zzb("Remote exception loading an app open RTB ad", remoteException);
            throw new zzffv(remoteException);
        }
    }
}
