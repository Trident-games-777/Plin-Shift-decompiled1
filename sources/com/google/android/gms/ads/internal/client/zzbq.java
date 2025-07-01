package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbq extends zzayd implements zzbr {
    public zzbq() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaye.zzc(parcel);
            zzg((zzm) zzaye.zza(parcel, zzm.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i == 3) {
            boolean zzi = zzi();
            parcel2.writeNoException();
            int i3 = zzaye.zza;
            parcel2.writeInt(zzi ? 1 : 0);
        } else if (i == 4) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i != 5) {
            return false;
        } else {
            int readInt = parcel.readInt();
            zzaye.zzc(parcel);
            zzh((zzm) zzaye.zza(parcel, zzm.CREATOR), readInt);
            parcel2.writeNoException();
        }
        return true;
    }
}
