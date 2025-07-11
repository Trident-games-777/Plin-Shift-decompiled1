package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbvk extends zzayc implements zzbvm {
    zzbvk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    public final void zze(zzba zzba) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzba);
        zzdc(2, zza);
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, parcelFileDescriptor);
        zzdc(1, zza);
    }
}
