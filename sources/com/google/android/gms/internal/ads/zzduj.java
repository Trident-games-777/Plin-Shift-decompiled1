package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzduj implements Runnable {
    public final /* synthetic */ zzdup zza;
    public final /* synthetic */ zzblw zzb;

    public /* synthetic */ zzduj(zzdup zzdup, zzblw zzblw) {
        this.zza = zzdup;
        this.zzb = zzblw;
    }

    public final void run() {
        zzdup zzdup = this.zza;
        try {
            this.zzb.zzb(zzdup.zzg());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
