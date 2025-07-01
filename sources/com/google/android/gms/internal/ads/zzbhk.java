package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbhk extends zzayc implements zzbhm {
    zzbhk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbhv zzbhv) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbhv);
        zzdc(1, zza);
    }
}
