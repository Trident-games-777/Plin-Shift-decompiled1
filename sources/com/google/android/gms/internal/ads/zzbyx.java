package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbyx {
    static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    public static String zzb(Uri uri, Context context, Map map) {
        if (!zzv.zzo().zzp(context)) {
            return uri.toString();
        }
        String zza = zzv.zzo().zza(context);
        if (zza == null) {
            return uri.toString();
        }
        String str = (String) zzbe.zzc().zza(zzbcn.zzap);
        String uri2 = uri.toString();
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzao)).booleanValue() || !uri2.contains(str)) {
            if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzan)).booleanValue()) {
                    String uri3 = zza(zzd(uri2, context), "fbs_aeid", zza).toString();
                    zzv.zzo().zzj(context, zza, (Map) map.get("_ac"));
                    return uri3;
                }
            }
            return uri2;
        }
        zzv.zzo().zzj(context, zza, (Map) map.get("_ac"));
        return zzd(uri2, context).replace(str, zza);
    }

    public static String zzc(String str, Context context, boolean z, Map map) {
        String zza;
        if ((((Boolean) zzbe.zzc().zza(zzbcn.zzaw)).booleanValue() && !z) || !zzv.zzo().zzp(context) || TextUtils.isEmpty(str) || (zza = zzv.zzo().zza(context)) == null) {
            return str;
        }
        String str2 = (String) zzbe.zzc().zza(zzbcn.zzap);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzao)).booleanValue() || !str.contains(str2)) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzan)).booleanValue()) {
                return str;
            }
            if (zzv.zzq().zzi(str)) {
                zzv.zzo().zzj(context, zza, (Map) map.get("_ac"));
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            } else if (!zzv.zzq().zzj(str)) {
                return str;
            } else {
                zzv.zzo().zzk(context, zza, (Map) map.get("_ai"));
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            }
        } else if (zzv.zzq().zzi(str)) {
            zzv.zzo().zzj(context, zza, (Map) map.get("_ac"));
            return zzd(str, context).replace(str2, zza);
        } else if (!zzv.zzq().zzj(str)) {
            return str;
        } else {
            zzv.zzo().zzk(context, zza, (Map) map.get("_ai"));
            return zzd(str, context).replace(str2, zza);
        }
    }

    private static String zzd(String str, Context context) {
        String zzd = zzv.zzo().zzd(context);
        String zzb = zzv.zzo().zzb(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzd)) {
            str = zza(str, "gmp_app_id", zzd).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzb)) ? str : zza(str, "fbs_aiid", zzb).toString();
    }
}
