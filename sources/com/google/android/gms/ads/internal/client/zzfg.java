package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzfg extends zzbq {
    final /* synthetic */ zzfi zza;

    /* synthetic */ zzfg(zzfi zzfi, zzfh zzfh) {
        this.zza = zzfi;
    }

    public final String zze() throws RemoteException {
        return null;
    }

    public final String zzf() throws RemoteException {
        return null;
    }

    public final void zzg(zzm zzm) throws RemoteException {
        zzh(zzm, 1);
    }

    public final void zzh(zzm zzm, int i) throws RemoteException {
        zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new zzff(this));
    }

    public final boolean zzi() throws RemoteException {
        return false;
    }
}
