package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfts extends zzayc implements zzftu {
    zzfts(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    public final void zze(Bundle bundle, zzftw zzftw) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, bundle);
        zzaye.zzf(zza, zzftw);
        zzdd(2, zza);
    }

    public final void zzf(String str, Bundle bundle, zzftw zzftw) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaye.zzd(zza, bundle);
        zzaye.zzf(zza, zzftw);
        zzdd(1, zza);
    }

    public final void zzg(Bundle bundle, zzftw zzftw) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, bundle);
        zzaye.zzf(zza, zzftw);
        zzdd(3, zza);
    }
}
