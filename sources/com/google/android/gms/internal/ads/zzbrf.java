package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface zzbrf extends IInterface {
    zzeb zze() throws RemoteException;

    zzbru zzf() throws RemoteException;

    zzbru zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzs zzs, zzbri zzbri) throws RemoteException;

    void zzi(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqq zzbqq, zzbpm zzbpm) throws RemoteException;

    void zzj(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqt zzbqt, zzbpm zzbpm, zzs zzs) throws RemoteException;

    void zzk(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqt zzbqt, zzbpm zzbpm, zzs zzs) throws RemoteException;

    void zzl(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqw zzbqw, zzbpm zzbpm) throws RemoteException;

    void zzm(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqz zzbqz, zzbpm zzbpm) throws RemoteException;

    void zzn(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqz zzbqz, zzbpm zzbpm, zzbfn zzbfn) throws RemoteException;

    void zzo(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbrc zzbrc, zzbpm zzbpm) throws RemoteException;

    void zzp(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbrc zzbrc, zzbpm zzbpm) throws RemoteException;

    void zzq(String str) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
