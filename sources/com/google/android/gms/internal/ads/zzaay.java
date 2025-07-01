package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaay implements Runnable {
    public final /* synthetic */ zzabf zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzaay(zzabf zzabf, Object obj, long j) {
        this.zza = zzabf;
        this.zzb = obj;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzm(this.zzb, this.zzc);
    }
}
