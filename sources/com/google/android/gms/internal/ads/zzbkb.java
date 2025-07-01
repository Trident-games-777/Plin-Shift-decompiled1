package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzaa;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbkb implements zzaa {
    boolean zza = false;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zza zzc;
    final /* synthetic */ Map zzd;
    final /* synthetic */ Map zze;

    zzbkb(zzbkd zzbkd, boolean z, zza zza2, Map map, Map map2) {
        this.zzb = z;
        this.zzc = zza2;
        this.zzd = map;
        this.zze = map2;
    }

    public final void zza(boolean z) {
        if (!this.zza) {
            if (z && this.zzb) {
                ((zzdel) this.zzc).zzdG();
            }
            this.zza = true;
            this.zzd.put((String) this.zze.get("event_id"), Boolean.valueOf(z));
            ((zzbmm) this.zzc).zzd("openIntentAsync", this.zzd);
        }
    }

    public final void zzb(int i) {
    }
}
