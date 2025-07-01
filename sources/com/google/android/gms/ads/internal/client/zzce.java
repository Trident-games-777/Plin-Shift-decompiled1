package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzce extends zzayd implements zzcf {
    public zzce() {
        super("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaye.zzc(parcel);
            zze((zzft) zzaye.zza(parcel, zzft.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzaye.zzc(parcel);
            zzf((zzft) zzaye.zza(parcel, zzft.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
