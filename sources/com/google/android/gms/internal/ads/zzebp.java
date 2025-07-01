package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzebp implements zzgee {
    final /* synthetic */ zzbvm zza;

    zzebp(zzebq zzebq, zzbvm zzbvm) {
        this.zza = zzbvm;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zze(zzba.zzb(th));
        } catch (RemoteException e) {
            zze.zzb("Ad service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zze.zzb("Ad service can't call client", e);
        }
    }
}
