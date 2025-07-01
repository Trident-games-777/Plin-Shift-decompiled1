package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdsh {
    private final ConcurrentHashMap zza;
    private final zzcad zzb;
    private final zzffo zzc;
    private final String zzd;
    private final String zze;
    private final zzk zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdsh(Context context, zzdsr zzdsr, zzcad zzcad, zzffo zzffo, String str, String str2, zzk zzk) {
        ActivityManager.MemoryInfo zzc2;
        String str3;
        ConcurrentHashMap zzc3 = zzdsr.zzc();
        this.zza = zzc3;
        this.zzb = zzcad;
        this.zzc = zzffo;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzk;
        this.zzh = context;
        zzc3.put(FirebaseAnalytics.Param.AD_FORMAT, str2.toUpperCase(Locale.ROOT));
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzje)).booleanValue();
        String str4 = DiskLruCache.VERSION;
        if (booleanValue) {
            int zzp = zzk.zzp();
            int i = zzp - 1;
            if (zzp != 0) {
                if (i != 0) {
                    str3 = i != 1 ? "na" : ExifInterface.GPS_MEASUREMENT_2D;
                } else {
                    str3 = str4;
                }
                zzc3.put("asv", str3);
            } else {
                throw null;
            }
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzc("rt_f", String.valueOf(runtime.freeMemory()));
            zzc("rt_m", String.valueOf(runtime.maxMemory()));
            zzc("rt_t", String.valueOf(runtime.totalMemory()));
            zzc("wv_c", String.valueOf(zzv.zzp().zzb()));
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzcn)).booleanValue() && (zzc2 = zzf.zzc(context)) != null) {
                zzc("mem_avl", String.valueOf(zzc2.availMem));
                zzc("mem_tt", String.valueOf(zzc2.totalMem));
                zzc("low_m", true != zzc2.lowMemory ? "0" : str4);
            }
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgO)).booleanValue()) {
            int zzf2 = com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzf(zzffo) - 1;
            if (zzf2 != 0) {
                if (zzf2 == 1) {
                    zzc3.put("request_id", str);
                    zzc3.put("se", "query_g");
                } else if (zzf2 == 2) {
                    zzc3.put("se", "r_adinfo");
                } else if (zzf2 != 3) {
                    zzc3.put("se", "r_both");
                } else {
                    zzc3.put("se", "r_adstring");
                }
                zzc3.put("scar", "true");
                zzc("ragent", zzffo.zzd.zzp);
                zzc("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzc(zzffo.zzd)));
                return;
            }
            zzc3.put("request_id", str);
            zzc3.put("scar", "false");
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final void zzd(zzfff zzfff) {
        String str;
        if (!zzfff.zzb.zza.isEmpty()) {
            zzfet zzfet = (zzfet) zzfff.zzb.zza.get(0);
            zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfet.zza(zzfet.zzb));
            if (zzfet.zzb == 6) {
                ConcurrentHashMap concurrentHashMap = this.zza;
                if (true != this.zzb.zzm()) {
                    str = "0";
                } else {
                    str = DiskLruCache.VERSION;
                }
                concurrentHashMap.put("as", str);
            }
        }
        zzc("gqi", zzfff.zzb.zzb.zzb);
    }

    public final void zze(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("cnt")) {
                zzc("network_coarse", Integer.toString(bundle.getInt("cnt")));
            }
            if (bundle.containsKey("gnt")) {
                zzc("network_fine", Integer.toString(bundle.getInt("gnt")));
            }
        }
    }
}
