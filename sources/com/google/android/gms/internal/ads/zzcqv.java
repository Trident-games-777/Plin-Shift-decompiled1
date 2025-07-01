package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcqv implements Runnable {
    public final /* synthetic */ zzcqw zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcqv(zzcqw zzcqw, Runnable runnable) {
        this.zza = zzcqw;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
