package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbag extends zzayc implements zzbai {
    zzbag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(2, zza);
    }

    public final void zzc(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zze);
        zzdc(3, zza);
    }

    public final void zzd(zzbaf zzbaf) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbaf);
        zzdc(1, zza);
    }
}
