package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbsc implements Runnable {
    public final /* synthetic */ zzbse zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzbsc(zzbse zzbse, boolean z) {
        this.zza = zzbse;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
