package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbkj implements zzbjr {
    private final zzbki zza;

    public zzbkj(zzbki zzbki) {
        this.zza = zzbki;
    }

    public static void zzb(zzcfk zzcfk, zzbki zzbki) {
        zzcfk.zzag("/reward", new zzbkj(zzbki));
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzbwv zzbwv = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzbwv = new zzbwv(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse reward amount.", e);
            }
            this.zza.zza(zzbwv);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
