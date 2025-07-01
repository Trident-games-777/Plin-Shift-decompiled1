package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzph implements Runnable {
    public final /* synthetic */ zzpm zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzph(zzpm zzpm, Exception exc) {
        this.zza = zzpm;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
