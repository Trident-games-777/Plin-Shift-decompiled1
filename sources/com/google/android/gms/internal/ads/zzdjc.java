package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzbr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdjc extends zzdjd {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdjc(zzfet zzfet, JSONObject jSONObject) {
        super(zzfet);
        boolean z = false;
        this.zzb = zzbr.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzc = zzbr.zzl(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = zzbr.zzl(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zze = zzbr.zzl(false, jSONObject, "enable_omid");
        this.zzg = zzbr.zzb("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null ? true : z;
        this.zzh = ((Boolean) zzbe.zzc().zza(zzbcn.zzfi)).booleanValue() ? jSONObject.optJSONObject("omid_settings") : null;
    }

    public final zzffr zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzffr(jSONObject) : this.zza.zzV;
    }

    public final String zzb() {
        return this.zzg;
    }

    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
