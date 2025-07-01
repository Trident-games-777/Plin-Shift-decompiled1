package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdvu implements Runnable {
    public final /* synthetic */ zzdvv zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdvu(zzdvv zzdvv, String str) {
        this.zza = zzdvv;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
