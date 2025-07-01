package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbzv extends zzb {
    final /* synthetic */ zzbzz zza;

    zzbzv(zzbzz zzbzz) {
        this.zza = zzbzz;
    }

    public final void zza() {
        zzbzz zzbzz = this.zza;
        zzbcq zzbcq = new zzbcq(zzbzz.zze, zzbzz.zzf.afmaVersion);
        synchronized (this.zza.zza) {
            try {
                zzv.zze();
                zzbct.zza(this.zza.zzh, zzbcq);
            } catch (IllegalArgumentException e) {
                zzm.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
