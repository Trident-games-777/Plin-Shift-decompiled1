package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeba implements zzgee {
    final /* synthetic */ zzbuz zza;
    final /* synthetic */ zzbvq zzb;

    zzeba(zzebg zzebg, zzbvq zzbvq, zzbuz zzbuz) {
        this.zzb = zzbvq;
        this.zza = zzbuz;
    }

    public final void zza(Throwable th) {
        try {
            this.zzb.zze(zzba.zzb(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zzb.zzf((String) obj, this.zza);
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
