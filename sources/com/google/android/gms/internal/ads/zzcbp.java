package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcbp implements Runnable {
    public final /* synthetic */ zzcbt zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzcbp(zzcbt zzcbt, boolean z) {
        this.zza = zzcbt;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
