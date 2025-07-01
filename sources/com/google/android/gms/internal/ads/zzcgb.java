package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcgb implements Runnable {
    public final /* synthetic */ zzcgc zza;
    public final /* synthetic */ zzeeu zzb;

    public /* synthetic */ zzcgb(zzcgc zzcgc, zzeeu zzeeu) {
        this.zza = zzcgc;
        this.zzb = zzeeu;
    }

    public final void run() {
        this.zzb.zzf(new zzcfz(this.zza));
    }
}
