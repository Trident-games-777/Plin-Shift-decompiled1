package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import coil3.disk.DiskLruCache;
import com.google.android.ump.ConsentInformation;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzap {
    static final zzde zza = zzde.zzj("IABTCF_TCString", "IABGPP_HDR_GppString", "IABGPP_GppSID", "IABUSPrivacy_String");
    private final Application zzb;
    private final SharedPreferences zzc;
    private final Set zzd;

    zzap(Application application) {
        this.zzb = application;
        SharedPreferences sharedPreferences = application.getSharedPreferences("__GOOGLE_FUNDING_CHOICE_SDK_INTERNAL__", 0);
        this.zzc = sharedPreferences;
        this.zzd = new HashSet(sharedPreferences.getStringSet("written_values", Collections.emptySet()));
    }

    public final int zza() {
        return this.zzc.getInt("consent_status", 0);
    }

    public final ConsentInformation.PrivacyOptionsRequirementStatus zzb() {
        return ConsentInformation.PrivacyOptionsRequirementStatus.valueOf(this.zzc.getString("privacy_options_requirement_status", ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN.name()));
    }

    public final Map zzc() {
        String str;
        Set<String> stringSet = this.zzc.getStringSet("stored_info", zzde.zzi());
        if (stringSet.isEmpty()) {
            stringSet = zza;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : stringSet) {
            Application application = this.zzb;
            zzcm zza2 = zzco.zza(application, str2);
            if (zza2 == null) {
                Log.d("UserMessagingPlatform", "Fetching request info: failed for key: ".concat(String.valueOf(str2)));
            } else {
                Object obj = application.getSharedPreferences(zza2.zza, 0).getAll().get(zza2.zzb);
                if (obj == null) {
                    Log.d("UserMessagingPlatform", "Stored info not exists: ".concat(String.valueOf(str2)));
                } else {
                    if (obj instanceof Boolean) {
                        if (true != ((Boolean) obj).booleanValue()) {
                            str = "0";
                        } else {
                            str = DiskLruCache.VERSION;
                        }
                    } else if (obj instanceof Number) {
                        str = obj.toString();
                    } else if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        Log.d("UserMessagingPlatform", "Failed to fetch stored info: ".concat(String.valueOf(str2)));
                    }
                    hashMap.put(str2, str);
                }
            }
        }
        return hashMap;
    }

    public final Set zzd() {
        return this.zzd;
    }

    public final void zze() {
        zzco.zzb(this.zzb, this.zzd);
        this.zzd.clear();
        this.zzc.edit().remove("stored_info").remove("consent_status").remove("consent_type").remove("privacy_options_requirement_status").remove("is_pub_misconfigured").remove("written_values").apply();
    }

    public final void zzf() {
        this.zzc.edit().putStringSet("written_values", this.zzd).apply();
    }

    public final void zzg(int i) {
        this.zzc.edit().putInt("consent_status", i).apply();
    }

    public final void zzh(boolean z) {
        this.zzc.edit().putBoolean("is_pub_misconfigured", z).apply();
    }

    public final void zzi(ConsentInformation.PrivacyOptionsRequirementStatus privacyOptionsRequirementStatus) {
        this.zzc.edit().putString("privacy_options_requirement_status", privacyOptionsRequirementStatus.name()).apply();
    }

    public final void zzj(Set set) {
        this.zzc.edit().putStringSet("stored_info", set).apply();
    }

    public final boolean zzk() {
        return this.zzc.getBoolean("is_pub_misconfigured", false);
    }
}
