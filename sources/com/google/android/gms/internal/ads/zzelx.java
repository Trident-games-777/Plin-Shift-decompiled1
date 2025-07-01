package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzelx implements zzenh {
    final /* synthetic */ zzely zza;

    zzelx(zzely zzely) {
        this.zza = zzely;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpd zzcpd = (zzcpd) obj;
        synchronized (this.zza) {
            zzely zzely = this.zza;
            if (zzely.zzi != null) {
                zzely.zzi.zzb();
            }
            this.zza.zzi = zzcpd;
            this.zza.zzi.zzk();
        }
    }
}
