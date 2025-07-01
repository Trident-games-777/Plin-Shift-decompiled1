package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdnb implements Runnable {
    public final /* synthetic */ zzdnd zza;

    public /* synthetic */ zzdnb(zzdnd zzdnd) {
        this.zza = zzdnd;
    }

    public final void run() {
        try {
            this.zza.zzd();
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
