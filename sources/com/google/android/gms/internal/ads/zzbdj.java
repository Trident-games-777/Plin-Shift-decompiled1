package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbdj implements Runnable {
    public final /* synthetic */ zzbdm zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbdj(zzbdm zzbdm, int i) {
        this.zza = zzbdm;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
