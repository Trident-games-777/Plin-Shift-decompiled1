package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzbvl extends zzayd implements zzbvm {
    public zzbvl() {
        super("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaye.zzc(parcel);
            zzf((ParcelFileDescriptor) zzaye.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzaye.zzc(parcel);
            zze((zzba) zzaye.zza(parcel, zzba.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
