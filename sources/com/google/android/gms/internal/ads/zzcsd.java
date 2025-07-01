package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcsd implements zzgee {
    final /* synthetic */ zzgee zza;
    final /* synthetic */ zzcsf zzb;

    zzcsd(zzcsf zzcsf, zzgee zzgee) {
        this.zza = zzgee;
        this.zzb = zzcsf;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzcaj.zze.execute(new zzcrz(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcsf.zzb(this.zzb, ((zzcry) obj).zza, this.zza);
    }
}
