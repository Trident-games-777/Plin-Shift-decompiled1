package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzkw implements Runnable {
    public final /* synthetic */ zzlb zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzui zzc;
    public final /* synthetic */ zzun zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzkw(zzlb zzlb, Pair pair, zzui zzui, zzun zzun, IOException iOException, boolean z) {
        this.zza = zzlb;
        this.zzb = pair;
        this.zzc = zzui;
        this.zzd = zzun;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzur) pair.second, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
