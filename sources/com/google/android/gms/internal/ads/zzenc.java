package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzenc implements zzenh {
    final /* synthetic */ zzend zza;

    zzenc(zzend zzend) {
        this.zza = zzend;
    }

    public final void zza() {
        synchronized (this.zza) {
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcrq zzcrq = (zzcrq) obj;
        synchronized (this.zza) {
            this.zza.zzc = zzcrq.zzm();
            zzcrq.zzk();
        }
    }
}
