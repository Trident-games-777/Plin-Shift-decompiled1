package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzflp implements Runnable {
    public final /* synthetic */ zzflr zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzflp(zzflr zzflr, String str) {
        this.zza = zzflr;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
