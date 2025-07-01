package com.google.android.gms.ads.internal;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ zzk zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzi(zzk zzk, boolean z) {
        this.zza = zzk;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
