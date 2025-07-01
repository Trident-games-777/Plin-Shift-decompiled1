package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbzf extends zzayc implements zzbzh {
    zzbzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, iObjectWrapper2);
        zza.writeString(str);
        zzaye.zzf(zza, iObjectWrapper3);
        Parcel zzdb = zzdb(11, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbzl zzbzl, zzbze zzbze) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzbzl);
        zzaye.zzf(zza, zzbze);
        zzdc(1, zza);
    }

    public final void zzg(zzbue zzbue) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbue);
        zzdc(7, zza);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbtv);
        zzdc(10, zza);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbtv);
        zzdc(9, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(8, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(2, zza);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbtv);
        zzdc(6, zza);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbtv);
        zzdc(5, zza);
    }
}
