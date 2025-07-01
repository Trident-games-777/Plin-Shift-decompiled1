package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcna implements zzgee {
    final /* synthetic */ zzflr zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcnb zzc;

    zzcna(zzcnb zzcnb, zzflr zzflr, String str) {
        this.zza = zzflr;
        this.zzb = str;
        this.zzc = zzcnb;
    }

    public final void zza(Throwable th) {
        this.zzc.zzg.zza(new zzcmy(this, th));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zzg.zza(new zzcmz(this, (String) obj));
    }
}
