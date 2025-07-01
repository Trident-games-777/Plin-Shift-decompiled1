package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzemz implements zzenh {
    final /* synthetic */ zzena zza;

    zzemz(zzena zzena) {
        this.zza = zzena;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdfj zzdfj = (zzdfj) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdfj;
            this.zza.zzj.zzk();
        }
    }
}
