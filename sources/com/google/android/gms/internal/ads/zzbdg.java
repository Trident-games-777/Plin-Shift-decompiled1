package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbdg extends zzayc implements zzbdi {
    zzbdg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbdf zzbdf) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbdf);
        zzdc(1, zza);
    }
}
