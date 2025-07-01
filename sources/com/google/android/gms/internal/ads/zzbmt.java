package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbmt implements Runnable {
    public final /* synthetic */ zzbmx zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbmt(zzbmx zzbmx, String str) {
        this.zza = zzbmx;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
