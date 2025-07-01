package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.messaging.Constants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbik implements zzbjr {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get(Constants.ScionAnalytics.PARAM_LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzm.zzj("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzm.zzj("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzv.zzC().elapsedRealtime() + (Long.parseLong(str4) - zzv.zzC().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzcfk.zzm().zzc(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzm.zzk("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzm.zzj("No value given for CSI experiment.");
            } else {
                zzcfk.zzm().zza().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzm.zzj("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzm.zzj("No name given for CSI extra.");
            } else {
                zzcfk.zzm().zza().zzd(str6, str7);
            }
        }
    }
}
