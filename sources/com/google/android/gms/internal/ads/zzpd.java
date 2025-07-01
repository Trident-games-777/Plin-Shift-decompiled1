package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzpd implements Runnable {
    public final /* synthetic */ zzpm zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzpd(zzpm zzpm, int i, long j, long j2) {
        this.zza = zzpm;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzu(this.zzb, this.zzc, this.zzd);
    }
}
