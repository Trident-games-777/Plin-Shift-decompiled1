package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcmt implements Runnable {
    public final /* synthetic */ zzcnb zza;
    public final /* synthetic */ Throwable zzb;

    public /* synthetic */ zzcmt(zzcnb zzcnb, Throwable th) {
        this.zza = zzcnb;
        this.zzb = th;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
