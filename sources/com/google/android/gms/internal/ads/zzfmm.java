package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfmm implements zzgee {
    final /* synthetic */ zzfmo zza;

    zzfmm(zzfmo zzfmo) {
        this.zza = zzfmo;
    }

    public final void zza(Throwable th) {
        this.zza.zzj.set(false);
        if (!(th instanceof zzflt) || ((zzflt) th).zza() != 0) {
            this.zza.zzo(true);
            return;
        }
        throw null;
    }

    public final void zzb(Object obj) {
        this.zza.zzj.set(false);
        if (obj != null) {
            this.zza.zzi.zzc();
            this.zza.zzm(obj);
            this.zza.zzo(false);
            return;
        }
        this.zza.zzo(true);
    }
}
