package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzky implements Runnable {
    public final /* synthetic */ zzlb zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzui zzc;
    public final /* synthetic */ zzun zzd;

    public /* synthetic */ zzky(zzlb zzlb, Pair pair, zzui zzui, zzun zzun) {
        this.zza = zzlb;
        this.zzb = pair;
        this.zzc = zzui;
        this.zzd = zzun;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzaj(((Integer) pair.first).intValue(), (zzur) pair.second, this.zzc, this.zzd);
    }
}
