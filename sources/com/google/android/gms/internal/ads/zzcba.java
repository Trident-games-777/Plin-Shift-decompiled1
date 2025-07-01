package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcba implements Runnable {
    public final /* synthetic */ zzcbj zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzcba(zzcbj zzcbj, int i) {
        this.zza = zzcbj;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
