package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbxc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface zzci extends IInterface {
    zzbaf zze(String str) throws RemoteException;

    zzby zzf(String str) throws RemoteException;

    zzbxc zzg(String str) throws RemoteException;

    void zzh(zzbpg zzbpg) throws RemoteException;

    void zzi(List list, zzcf zzcf) throws RemoteException;

    boolean zzj(String str) throws RemoteException;

    boolean zzk(String str) throws RemoteException;

    boolean zzl(String str) throws RemoteException;
}
