package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfhu implements zzgee {
    final /* synthetic */ zzfhx zza;
    final /* synthetic */ zzfhy zzb;

    zzfhu(zzfhy zzfhy, zzfhx zzfhx) {
        this.zza = zzfhx;
        this.zzb = zzfhy;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzfhy zzfhy = this.zzb;
            if (zzfhy.zzf == 1) {
                zzfhy.zzh();
            }
        }
    }
}
