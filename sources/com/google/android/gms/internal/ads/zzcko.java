package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcko implements Runnable {
    public final /* synthetic */ zzckp zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcko(zzckp zzckp, Runnable runnable) {
        this.zza = zzckp;
        this.zzb = runnable;
    }

    public final void run() {
        zzcaj.zze.execute(new zzckm(this.zza, this.zzb));
    }
}
