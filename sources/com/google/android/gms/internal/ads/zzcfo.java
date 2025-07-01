package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcfo implements Runnable {
    public final /* synthetic */ zzcfs zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcfo(zzcfs zzcfs, boolean z, long j) {
        this.zza = zzcfs;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
