package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfmn extends zzflu {
    final /* synthetic */ zzfmo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfmn(zzfmo zzfmo, zzgfa zzgfa) {
        super(zzgfa);
        this.zza = zzfmo;
    }

    public final void zza(zze zze) {
        this.zza.zzj.set(false);
        int i = zze.zza;
        if (i == 1 || i == 8 || i == 10 || i == 11) {
            zzft zzft = this.zza.zze;
            int i2 = zzft.zzb;
            String str = zzft.zza;
            zzm.zzi("Preloading " + i2 + ", for adUnitId:" + str + ", Ad load failed. Stop preloading due to non-retriable error:");
            this.zza.zzf.set(false);
            return;
        }
        this.zza.zzo(true);
    }
}
