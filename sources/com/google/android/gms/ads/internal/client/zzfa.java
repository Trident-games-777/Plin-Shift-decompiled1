package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfa {
    private final String zza;
    private final Bundle zzb;
    private final String zzc;

    public zzfa(String str, Bundle bundle, String str2) {
        this.zza = str;
        this.zzb = bundle;
        this.zzc = str2;
    }

    public final Bundle zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        if (!TextUtils.isEmpty(this.zzc)) {
            try {
                return new JSONObject(this.zzc).optString("request_id", "");
            } catch (JSONException unused) {
            }
        }
        return "";
    }
}
