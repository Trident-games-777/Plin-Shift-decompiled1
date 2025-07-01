package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Optional;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmd {
    private final zzdsm zza;

    zzfmd(zzdsm zzdsm) {
        this.zza = zzdsm;
    }

    public final void zza(AdFormat adFormat, long j, Optional optional) {
        zzdsl zza2 = this.zza.zza();
        zza2.zzb("plaac_ts", Long.toString(j));
        zza2.zzb(FirebaseAnalytics.Param.AD_FORMAT, adFormat.name());
        zza2.zzb("action", "is_ad_available");
        optional.ifPresent(new zzfmc(zza2));
        zza2.zzf();
    }
}
