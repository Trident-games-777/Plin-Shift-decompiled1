package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzegk extends zzbqs {
    final /* synthetic */ zzegm zza;
    private final zzefe zzb;

    /* synthetic */ zzegk(zzegm zzegm, zzefe zzefe, zzegl zzegl) {
        this.zza = zzegm;
        this.zzb = zzefe;
    }

    public final void zze(String str) throws RemoteException {
        ((zzegx) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzegx) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzegx) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbpp zzbpp) throws RemoteException {
        this.zza.zzd = zzbpp;
        ((zzegx) this.zzb.zzc).zzo();
    }
}
