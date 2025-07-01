package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbce;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzfxf;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class CsiParamDefaults {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = versionInfoParcel.afmaVersion;
    }

    public void set(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzv.zzq();
        map.put("device", zzs.zzr());
        map.put("app", this.zzb);
        zzv.zzq();
        String str = "0";
        map.put("is_lite_sdk", true != zzs.zzE(this.zza) ? str : DiskLruCache.VERSION);
        zzbce zzbce = zzbcn.zza;
        List zzb2 = zzbe.zza().zzb();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgK)).booleanValue()) {
            zzb2.addAll(zzv.zzp().zzi().zzg().zzd());
        }
        map.put("e", TextUtils.join(",", zzb2));
        map.put("sdkVersion", this.zzc);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkX)).booleanValue()) {
            zzv.zzq();
            if (true == zzs.zzB(this.zza)) {
                str = DiskLruCache.VERSION;
            }
            map.put("is_bstar", str);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziZ)).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzcs)).booleanValue()) {
                map.put("plugin", zzfxf.zzc(zzv.zzp().zzn()));
            }
        }
    }
}
