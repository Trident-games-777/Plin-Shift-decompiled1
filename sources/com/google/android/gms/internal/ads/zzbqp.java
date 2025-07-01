package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbqp extends zzayd implements zzbqq {
    public zzbqp() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzg();
        } else if (i == 3) {
            String readString = parcel.readString();
            zzaye.zzc(parcel);
            zze(readString);
        } else if (i != 4) {
            return false;
        } else {
            zzaye.zzc(parcel);
            zzf((zze) zzaye.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
