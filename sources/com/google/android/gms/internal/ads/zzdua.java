package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdua extends zzbxi {
    final /* synthetic */ zzduc zza;

    zzdua(zzduc zzduc) {
        this.zza = zzduc;
    }

    public final void zze(int i) throws RemoteException {
        zzduc zzduc = this.zza;
        zzduc.zzb.zzm(zzduc.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        zzduc zzduc = this.zza;
        zzduc.zzb.zzm(zzduc.zza, zze.zza);
    }

    public final void zzg() throws RemoteException {
        zzduc zzduc = this.zza;
        zzduc.zzb.zzp(zzduc.zza);
    }
}
