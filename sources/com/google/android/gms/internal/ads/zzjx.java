package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzjx implements Runnable {
    public final /* synthetic */ zzkh zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzjx(zzkh zzkh, int i, boolean z) {
        this.zza = zzkh;
        this.zzb = i;
        this.zzc = z;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
