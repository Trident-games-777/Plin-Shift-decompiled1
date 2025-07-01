package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeny implements zzevy {
    final zzffo zza;
    private final long zzb;

    public zzeny(zzffo zzffo, long j) {
        Preconditions.checkNotNull(zzffo, "the targeting must not be null");
        this.zza = zzffo;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzm zzm = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzm.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        if (i != 0) {
            int i2 = i - 1;
            boolean z = true;
            if (i2 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i2 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            zzfgc.zzg(bundle, "is_sdk_preload", true, zzm.zzb());
            zzfgc.zzf(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzm.zzb)), zzm.zzb != -1);
            zzfgc.zzb(bundle, "extras", zzm.zzc);
            int i3 = zzm.zzd;
            zzfgc.zze(bundle, "cust_gender", i3, i3 != -1);
            zzfgc.zzd(bundle, "kw", zzm.zze);
            int i4 = zzm.zzg;
            zzfgc.zze(bundle, "tag_for_child_directed_treatment", i4, i4 != -1);
            if (zzm.zzf) {
                bundle.putBoolean("test_request", true);
            }
            bundle.putInt("ppt_p13n", zzm.zzy);
            zzfgc.zze(bundle, "d_imp_hdr", 1, zzm.zza >= 2 && zzm.zzh);
            String str = zzm.zzi;
            zzfgc.zzf(bundle, "ppid", str, zzm.zza >= 2 && !TextUtils.isEmpty(str));
            Location location = zzm.zzk;
            if (location != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", location.getAccuracy() * 1000.0f);
                bundle2.putLong("lat", (long) (location.getLatitude() * 1.0E7d));
                bundle2.putLong("long", (long) (1.0E7d * location.getLongitude()));
                bundle2.putLong("time", location.getTime() * 1000);
                bundle.putBundle("uule", bundle2);
            }
            zzfgc.zzc(bundle, ImagesContract.URL, zzm.zzl);
            zzfgc.zzd(bundle, "neighboring_content_urls", zzm.zzv);
            zzfgc.zzb(bundle, "custom_targeting", zzm.zzn);
            zzfgc.zzd(bundle, "category_exclusions", zzm.zzo);
            zzfgc.zzc(bundle, "request_agent", zzm.zzp);
            zzfgc.zzc(bundle, "request_pkg", zzm.zzq);
            zzfgc.zzg(bundle, "is_designed_for_families", zzm.zzr, zzm.zza >= 7);
            if (zzm.zza >= 8) {
                int i5 = zzm.zzt;
                if (i5 == -1) {
                    z = false;
                }
                zzfgc.zze(bundle, "tag_for_under_age_of_consent", i5, z);
                zzfgc.zzc(bundle, "max_ad_content_rating", zzm.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
