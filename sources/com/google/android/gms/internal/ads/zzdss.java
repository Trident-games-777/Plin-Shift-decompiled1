package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdss implements Runnable {
    public final /* synthetic */ zzdsu zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdss(zzdsu zzdsu, String str) {
        this.zza = zzdsu;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzd.zza(this.zzb);
    }
}
