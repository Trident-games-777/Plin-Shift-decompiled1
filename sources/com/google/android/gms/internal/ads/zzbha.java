package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbha extends zzayc implements zzbhc {
    zzbha(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbgs zzbgs, String str) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbgs);
        zza.writeString(str);
        zzdc(1, zza);
    }
}
