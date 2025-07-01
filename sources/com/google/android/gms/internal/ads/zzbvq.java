package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbvq extends zzayc implements IInterface {
    zzbvq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
    }

    public final void zze(zzba zzba) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzba);
        zzdc(2, zza);
    }

    public final void zzf(String str, zzbuz zzbuz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaye.zzd(zza, zzbuz);
        zzdc(1, zza);
    }
}
