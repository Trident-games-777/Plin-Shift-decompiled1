package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcdy implements Runnable {
    public final /* synthetic */ zzccf zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcdy(zzccf zzccf, boolean z, long j) {
        this.zza = zzccf;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        int i = zzcea.zzd;
        this.zza.zzv(this.zzb, this.zzc);
    }
}
