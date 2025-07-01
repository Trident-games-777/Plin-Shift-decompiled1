package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdip implements Runnable {
    public final /* synthetic */ zzdit zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzdip(zzdit zzdit, boolean z) {
        this.zza = zzdit;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzy(this.zzb);
    }
}
