package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzccq implements Runnable {
    public final /* synthetic */ zzccx zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzccq(zzccx zzccx, boolean z, long j) {
        this.zza = zzccx;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzJ(this.zzb, this.zzc);
    }
}
