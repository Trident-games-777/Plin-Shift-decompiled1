package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcse implements zzgee {
    final /* synthetic */ zzgee zza;
    final /* synthetic */ zzcsf zzb;

    zzcse(zzcsf zzcsf, zzgee zzgee) {
        this.zza = zzgee;
        this.zzb = zzcsf;
    }

    public final void zza(Throwable th) {
        zzcaj.zze.execute(new zzcrz(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcaj.zze.execute(new zzcrz(this.zzb));
        this.zza.zzb((zzcrq) obj);
    }
}
