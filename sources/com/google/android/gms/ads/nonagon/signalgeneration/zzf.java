package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzf implements Runnable {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Pair zzc;

    public /* synthetic */ zzf(zzj zzj, Object obj, Pair pair) {
        this.zza = zzj;
        this.zzb = obj;
        this.zzc = pair;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc);
    }
}
