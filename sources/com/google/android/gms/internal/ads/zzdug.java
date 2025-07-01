package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdug implements Runnable {
    public final /* synthetic */ zzdup zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzcao zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ zzfka zzf;

    public /* synthetic */ zzdug(zzdup zzdup, Object obj, zzcao zzcao, String str, long j, zzfka zzfka) {
        this.zza = zzdup;
        this.zzb = obj;
        this.zzc = zzcao;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzfka;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
