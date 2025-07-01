package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzyn implements Runnable {
    public final /* synthetic */ zzyo zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzyn(zzyo zzyo, int i, long j, long j2) {
        this.zza = zzyo;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzb.zzY(this.zzb, this.zzc, this.zzd);
    }
}
