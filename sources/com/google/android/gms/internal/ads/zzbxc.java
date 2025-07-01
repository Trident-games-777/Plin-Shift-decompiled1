package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface zzbxc extends IInterface {
    Bundle zzb() throws RemoteException;

    zzdy zzc() throws RemoteException;

    zzbwz zzd() throws RemoteException;

    String zze() throws RemoteException;

    void zzf(zzm zzm, zzbxj zzbxj) throws RemoteException;

    void zzg(zzm zzm, zzbxj zzbxj) throws RemoteException;

    void zzh(boolean z) throws RemoteException;

    void zzi(zzdo zzdo) throws RemoteException;

    void zzj(zzdr zzdr) throws RemoteException;

    void zzk(zzbxf zzbxf) throws RemoteException;

    void zzl(zzbxq zzbxq) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    boolean zzo() throws RemoteException;

    void zzp(zzbxk zzbxk) throws RemoteException;
}
