package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface zzbgs extends IInterface {
    zzeb zze() throws RemoteException;

    zzbfv zzf() throws RemoteException;

    zzbfy zzg(String str) throws RemoteException;

    IObjectWrapper zzh() throws RemoteException;

    String zzi() throws RemoteException;

    String zzj(String str) throws RemoteException;

    List zzk() throws RemoteException;

    void zzl() throws RemoteException;

    void zzm() throws RemoteException;

    void zzn(String str) throws RemoteException;

    void zzo() throws RemoteException;

    void zzp(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzq() throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt() throws RemoteException;
}
