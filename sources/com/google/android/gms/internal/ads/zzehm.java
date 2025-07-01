package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzehm implements zzefh {
    private final Context zza;
    private final zzdgn zzb;

    public zzehm(Context context, zzdgn zzdgn) {
        this.zza = context;
        this.zzb = zzdgn;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzehg zzehg = new zzehg(zzfet, (zzbrf) zzefe.zzb, AdFormat.INTERSTITIAL);
        zzdfk zze = this.zzb.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdfn(zzehg, (zzcfk) null));
        zzehg.zzb(zze.zzc());
        ((zzegx) zzefe.zzc).zzc(zze.zzj());
        return zze.zzg();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        try {
            ((zzbrf) zzefe.zzb).zzq(zzfet.zzZ);
            ((zzbrf) zzefe.zzb).zzl(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehk(this, zzefe, (zzehl) null), (zzbpm) zzefe.zzc);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zze.zzb("Remote exception loading a interstitial RTB ad", remoteException);
            throw new zzffv(remoteException);
        }
    }
}
