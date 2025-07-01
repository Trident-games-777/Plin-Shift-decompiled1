package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzkz implements Runnable {
    public final /* synthetic */ zzlb zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzun zzc;

    public /* synthetic */ zzkz(zzlb zzlb, Pair pair, zzun zzun) {
        this.zza = zzlb;
        this.zzb = pair;
        this.zzc = zzun;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zzur) pair.second, this.zzc);
    }
}
