package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbmi extends zzayc implements zzbmk {
    zzbmi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public final void zze(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zze);
        zzdc(3, zza);
    }

    public final void zzg(zzbme zzbme) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbme);
        zzdc(1, zza);
    }
}
