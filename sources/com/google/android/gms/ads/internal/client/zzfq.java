package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbwz;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxf;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbxq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfq extends zzbxb {
    private static void zzr(zzbxj zzbxj) {
        zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new zzfp(zzbxj));
    }

    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    public final zzdy zzc() {
        return null;
    }

    public final zzbwz zzd() {
        return null;
    }

    public final String zze() throws RemoteException {
        return "";
    }

    public final void zzf(zzm zzm, zzbxj zzbxj) throws RemoteException {
        zzr(zzbxj);
    }

    public final void zzg(zzm zzm, zzbxj zzbxj) throws RemoteException {
        zzr(zzbxj);
    }

    public final void zzh(boolean z) {
    }

    public final void zzi(zzdo zzdo) throws RemoteException {
    }

    public final void zzj(zzdr zzdr) {
    }

    public final void zzk(zzbxf zzbxf) throws RemoteException {
    }

    public final void zzl(zzbxq zzbxq) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }

    public final boolean zzo() throws RemoteException {
        return false;
    }

    public final void zzp(zzbxk zzbxk) throws RemoteException {
    }
}
