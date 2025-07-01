package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzegs implements Runnable {
    public final /* synthetic */ zzegv zza;
    public final /* synthetic */ zzfff zzb;
    public final /* synthetic */ zzfet zzc;

    public /* synthetic */ zzegs(zzegv zzegv, zzfff zzfff, zzfet zzfet) {
        this.zza = zzegv;
        this.zzb = zzfff;
        this.zzc = zzfet;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
