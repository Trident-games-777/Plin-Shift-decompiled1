package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaaz implements Runnable {
    public final /* synthetic */ zzabf zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzaaz(zzabf zzabf, long j, int i) {
        this.zza = zzabf;
        this.zzb = j;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
