package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzbpg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzcv extends zzayd implements zzcw {
    public zzcv() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static zzcw asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return queryLocalInterface instanceof zzcw ? (zzcw) queryLocalInterface : new zzcu(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzfb liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzaye.zze(parcel2, liteSdkVersion);
        } else if (i != 2) {
            return false;
        } else {
            zzbpg adapterCreator = getAdapterCreator();
            parcel2.writeNoException();
            zzaye.zzf(parcel2, adapterCreator);
        }
        return true;
    }
}
