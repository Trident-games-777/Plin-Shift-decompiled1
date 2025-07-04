package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbcc extends zzbce {
    zzbcc(int i, String str, String str2, String str3) {
        super(1, str, str2, str3, (zzbcd) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return jSONObject.optString(zzl(), (String) zzk());
    }

    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        if (bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzl()))) {
            return bundle.getString("com.google.android.gms.ads.flag.".concat(zzl()));
        }
        return (String) zzk();
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(zzl(), (String) zzk());
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putString(zzl(), (String) obj);
    }
}
