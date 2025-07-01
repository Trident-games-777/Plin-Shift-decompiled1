package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfmr extends zzbxi {
    final /* synthetic */ zzgfa zza;
    final /* synthetic */ zzbxc zzb;
    final /* synthetic */ zzfms zzc;

    zzfmr(zzfms zzfms, zzgfa zzgfa, zzbxc zzbxc) {
        this.zza = zzgfa;
        this.zzb = zzbxc;
        this.zzc = zzfms;
    }

    public final void zze(int i) {
    }

    public final void zzf(zze zze) {
        String adError = zze.zzb().toString();
        String str = this.zzc.zze.zza;
        zzm.zzj("Failed to load rewarded ad with error: " + adError + ", adUnitId: " + str);
        new zzfmn(this.zzc, this.zza).zza(zze);
    }

    public final void zzg() {
        new zzfmn(this.zzc, this.zza).zzb(this.zzb);
    }
}
