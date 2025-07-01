package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzewq implements Runnable {
    public final /* synthetic */ Throwable zza;

    public /* synthetic */ zzewq(Throwable th) {
        this.zza = th;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzkc)).booleanValue();
        Throwable th = this.zza;
        if (booleanValue) {
            zzv.zzp().zzx(th, "TopicsSignalUnsampled.fetchTopicsSignal");
        } else {
            zzv.zzp().zzv(th, "TopicsSignal.fetchTopicsSignal");
        }
    }
}
