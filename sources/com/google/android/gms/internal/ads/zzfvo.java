package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfvo implements Runnable {
    public final /* synthetic */ zzfvu zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzfvo(zzfvu zzfvu, Runnable runnable) {
        this.zza = zzfvu;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
