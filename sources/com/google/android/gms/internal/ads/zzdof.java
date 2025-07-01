package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdof extends zzdnp implements zzdel {
    private zzdel zza;

    public final synchronized void zzdG() {
        zzdel zzdel = this.zza;
        if (zzdel != null) {
            zzdel.zzdG();
        }
    }

    public final synchronized void zzdf() {
        zzdel zzdel = this.zza;
        if (zzdel != null) {
            zzdel.zzdf();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzi(zza zza2, zzbih zzbih, zzr zzr, zzbij zzbij, zzac zzac, zzdel zzdel) {
        try {
            super.zzh(zza2, zzbih, zzr, zzbij, zzac);
            try {
                this.zza = zzdel;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
