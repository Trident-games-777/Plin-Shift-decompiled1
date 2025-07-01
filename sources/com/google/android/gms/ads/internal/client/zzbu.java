package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbmk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface zzbu extends IInterface {
    zzbr zze() throws RemoteException;

    void zzf(zzbgw zzbgw) throws RemoteException;

    void zzg(zzbgz zzbgz) throws RemoteException;

    void zzh(String str, zzbhf zzbhf, zzbhc zzbhc) throws RemoteException;

    void zzi(zzbmk zzbmk) throws RemoteException;

    void zzj(zzbhj zzbhj, zzs zzs) throws RemoteException;

    void zzk(zzbhm zzbhm) throws RemoteException;

    void zzl(zzbl zzbl) throws RemoteException;

    void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzn(zzbmb zzbmb) throws RemoteException;

    void zzo(zzbfn zzbfn) throws RemoteException;

    void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzq(zzcq zzcq) throws RemoteException;
}
