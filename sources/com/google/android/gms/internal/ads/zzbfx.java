package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbfx extends zzayd implements zzbfy {
    public zzbfx() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbfy zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzbfy ? (zzbfy) queryLocalInterface : new zzbfw(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper zzf = zzf();
            parcel2.writeNoException();
            zzaye.zzf(parcel2, zzf);
        } else if (i == 2) {
            Uri zze = zze();
            parcel2.writeNoException();
            zzaye.zze(parcel2, zze);
        } else if (i == 3) {
            double zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeDouble(zzb);
        } else if (i == 4) {
            int zzd = zzd();
            parcel2.writeNoException();
            parcel2.writeInt(zzd);
        } else if (i != 5) {
            return false;
        } else {
            int zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
        }
        return true;
    }
}
