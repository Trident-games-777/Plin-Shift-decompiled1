package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaax implements Runnable {
    public final /* synthetic */ zzabf zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzaax(zzabf zzabf, int i, long j) {
        this.zza = zzabf;
        this.zzb = i;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
