package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzbvi extends zzayd implements zzbvj {
    public zzbvi() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbvm zzbvm = null;
        if (i == 1) {
            zzbuv zzbuv = (zzbuv) zzaye.zza(parcel, zzbuv.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbvm = queryLocalInterface instanceof zzbvm ? (zzbvm) queryLocalInterface : new zzbvk(readStrongBinder);
            }
            zzaye.zzc(parcel);
            zzf(zzbuv, zzbvm);
        } else if (i == 2) {
            zzbuv zzbuv2 = (zzbuv) zzaye.zza(parcel, zzbuv.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface2 instanceof zzbvm) {
                    zzbvm zzbvm2 = (zzbvm) queryLocalInterface2;
                }
            }
            zzaye.zzc(parcel);
        } else if (i != 3) {
            return false;
        } else {
            zzbvb zzbvb = (zzbvb) zzaye.zza(parcel, zzbvb.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbvm = queryLocalInterface3 instanceof zzbvm ? (zzbvm) queryLocalInterface3 : new zzbvk(readStrongBinder3);
            }
            zzaye.zzc(parcel);
            zze(zzbvb, zzbvm);
        }
        parcel2.writeNoException();
        return true;
    }
}
