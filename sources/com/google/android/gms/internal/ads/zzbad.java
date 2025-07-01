package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbad extends zzayc implements zzbaf {
    zzbad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzby zze() throws RemoteException {
        throw null;
    }

    public final zzdy zzf() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzdy zzb = zzdx.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final void zzg(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzaye.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(6, zza);
    }

    public final void zzh(zzdr zzdr) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzdr);
        zzdc(7, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbam zzbam) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbam);
        zzdc(4, zza);
    }
}
