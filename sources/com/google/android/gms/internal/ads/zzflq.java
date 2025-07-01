package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzflq implements Runnable {
    public final /* synthetic */ zzflr zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzfkl zzc;

    public /* synthetic */ zzflq(zzflr zzflr, String str, zzfkl zzfkl) {
        this.zza = zzflr;
        this.zzb = str;
        this.zzc = zzfkl;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
