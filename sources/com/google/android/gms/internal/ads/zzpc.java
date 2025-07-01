package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzpc implements Runnable {
    public final /* synthetic */ zzpm zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzpc(zzpm zzpm, long j) {
        this.zza = zzpm;
        this.zzb = j;
    }

    public final void run() {
        this.zza.zzs(this.zzb);
    }
}
