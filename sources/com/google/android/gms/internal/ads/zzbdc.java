package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbdc {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbdc(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public static final zzbcz zzf() {
        return new zzbcz(zzv.zzC().elapsedRealtime(), (String) null, (zzbcz) null);
    }

    public final zzbdb zza() {
        zzbdb zzbdb;
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbcz zzbcz : this.zza) {
                long zza2 = zzbcz.zza();
                String zzc2 = zzbcz.zzc();
                zzbcz zzb2 = zzbcz.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb.append(zzc2);
                    sb.append('.');
                    sb.append(zza2 - zzb2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb2.append('+');
                            sb2.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzv.zzC().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzv.zzC().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzbdb = new zzbdb(sb.toString(), str);
        }
        return zzbdb;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            zzv.zzp().zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbdc zzbdc) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbcs zzg;
        if (!TextUtils.isEmpty(str2) && (zzg = zzv.zzp().zzg()) != null) {
            synchronized (this.zzc) {
                zzbcy zza2 = zzg.zza(str);
                Map map = this.zzb;
                map.put(str, zza2.zza((String) map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzbcz zzbcz, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbcz(j, strArr[0], zzbcz));
        }
        return true;
    }
}
