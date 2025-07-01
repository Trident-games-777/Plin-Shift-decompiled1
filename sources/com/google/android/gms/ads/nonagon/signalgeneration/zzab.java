package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdoc;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzab implements Runnable {
    public final /* synthetic */ zzap zza;
    public final /* synthetic */ zzdoc[] zzb;

    public /* synthetic */ zzab(zzap zzap, zzdoc[] zzdocArr) {
        this.zza = zzap;
        this.zzb = zzdocArr;
    }

    public final void run() {
        this.zza.zzJ(this.zzb);
    }
}
