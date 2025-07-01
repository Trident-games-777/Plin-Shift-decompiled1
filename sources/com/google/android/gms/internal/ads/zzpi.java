package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzpi implements Runnable {
    public final /* synthetic */ zzpm zza;
    public final /* synthetic */ zzad zzb;
    public final /* synthetic */ zzhy zzc;

    public /* synthetic */ zzpi(zzpm zzpm, zzad zzad, zzhy zzhy) {
        this.zza = zzpm;
        this.zzb = zzad;
        this.zzc = zzhy;
    }

    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
