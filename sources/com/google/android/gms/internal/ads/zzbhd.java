package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbhd extends zzayc implements zzbhf {
    zzbhd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbgs zzbgs) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbgs);
        zzdc(1, zza);
    }
}
