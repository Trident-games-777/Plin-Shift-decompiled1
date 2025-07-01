package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface zzbaf extends IInterface {
    zzby zze() throws RemoteException;

    zzdy zzf() throws RemoteException;

    void zzg(boolean z) throws RemoteException;

    void zzh(zzdr zzdr) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, zzbam zzbam) throws RemoteException;
}
