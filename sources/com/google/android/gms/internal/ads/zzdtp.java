package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdtp {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    /* synthetic */ zzdtp(String str, zzdtq zzdtq) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdtp zzdtp) {
        String str = (String) zzbe.zzc().zza(zzbcn.zzjF);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdtp.zza);
            jSONObject.put("eventCategory", zzdtp.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, zzdtp.zzc);
            jSONObject.putOpt("errorCode", zzdtp.zzd);
            jSONObject.putOpt("rewardType", zzdtp.zze);
            jSONObject.putOpt("rewardAmount", zzdtp.zzf);
        } catch (JSONException unused) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return str + "(\"h5adsEvent\"," + jSONObject2 + ");";
    }
}
