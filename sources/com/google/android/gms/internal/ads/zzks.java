package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzks implements Runnable {
    public final /* synthetic */ zzkt zza;
    public final /* synthetic */ zzfzl zzb;
    public final /* synthetic */ zzur zzc;

    public /* synthetic */ zzks(zzkt zzkt, zzfzl zzfzl, zzur zzur) {
        this.zza = zzkt;
        this.zzb = zzfzl;
        this.zzc = zzur;
    }

    public final void run() {
        this.zza.zzk(this.zzb, this.zzc);
    }
}
