package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbgu extends zzayc implements zzbgw {
    zzbgu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbgn zzbgn) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbgn);
        zzdc(1, zza);
    }
}
