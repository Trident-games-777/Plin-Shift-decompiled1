package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzexa implements zzevy {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;
    private final zzfth zzc;

    public zzexa(AdvertisingIdClient.Info info, String str, zzfth zzfth) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfth;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject zzg = zzbr.zzg((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                String str = this.zzb;
                if (str != null) {
                    zzg.put("pdid", str);
                    zzg.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            zzg.put("rdid", this.zza.getId());
            zzg.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            zzg.put("idtype", "adid");
            if (this.zzc.zzc()) {
                zzg.put("paidv1_id_android_3p", this.zzc.zza());
                zzg.put("paidv1_creation_time_android_3p", this.zzc.zzb().toEpochMilli());
            }
        } catch (JSONException e) {
            zze.zzb("Failed putting Ad ID.", e);
        }
    }
}
