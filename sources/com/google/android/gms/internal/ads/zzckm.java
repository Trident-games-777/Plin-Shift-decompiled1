package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzckm implements Runnable {
    public final /* synthetic */ zzckp zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzckm(zzckp zzckp, Runnable runnable) {
        this.zza = zzckp;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
