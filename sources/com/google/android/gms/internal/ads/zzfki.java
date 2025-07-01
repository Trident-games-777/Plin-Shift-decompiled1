package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfki implements zzgee {
    final /* synthetic */ zzfkl zza;
    final /* synthetic */ zzfka zzb;
    final /* synthetic */ boolean zzc;

    zzfki(zzfkl zzfkl, zzfka zzfka, boolean z) {
        this.zza = zzfkl;
        this.zzb = zzfka;
        this.zzc = z;
    }

    public final void zza(Throwable th) {
        zzfka zzfka = this.zzb;
        if (zzfka.zzk()) {
            zzfkl zzfkl = this.zza;
            zzfka.zzh(th);
            zzfka.zzg(false);
            zzfkl.zza(zzfka);
            if (this.zzc) {
                this.zza.zzh();
            }
        }
    }

    public final void zzb(Object obj) {
        zzfka zzfka = this.zzb;
        zzfka.zzg(true);
        this.zza.zza(zzfka);
        if (this.zzc) {
            this.zza.zzh();
        }
    }
}
