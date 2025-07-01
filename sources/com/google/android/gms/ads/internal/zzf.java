package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbce;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbof;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzdsl;
import com.google.android.gms.internal.ads.zzdsm;
import com.google.android.gms.internal.ads.zzfjz;
import com.google.android.gms.internal.ads.zzfka;
import com.google.android.gms.internal.ads.zzfko;
import com.google.android.gms.internal.ads.zzgei;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzf {
    private Context zza;
    private long zzb = 0;

    static final /* synthetic */ ListenableFuture zzd(Long l, zzdsm zzdsm, zzfko zzfko, zzfka zzfka, JSONObject jSONObject) throws Exception {
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzv.zzp().zzi().zzs(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdsm, "cld_s", zzv.zzC().elapsedRealtime() - l.longValue());
            }
        }
        zzfka.zzg(optBoolean);
        zzfko.zzb(zzfka.zzm());
        return zzgei.zzh((Object) null);
    }

    /* access modifiers changed from: private */
    public static final void zzf(zzdsm zzdsm, String str, long j) {
        if (zzdsm != null) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzmp)).booleanValue()) {
                zzdsl zza2 = zzdsm.zza();
                zza2.zzb("action", "lat_init");
                zza2.zzb(str, Long.toString(j));
                zza2.zzf();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfko zzfko, zzdsm zzdsm, Long l) {
        zzb(context, versionInfoParcel, true, (zzbzt) null, str, (String) null, runnable, zzfko, zzdsm, l);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzbzt zzbzt, String str, String str2, Runnable runnable, zzfko zzfko, zzdsm zzdsm, Long l) {
        Exception exc;
        zzfka zzfka;
        PackageInfo packageInfo;
        if (zzv.zzC().elapsedRealtime() - this.zzb < CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
            zzm.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzv.zzC().elapsedRealtime();
        if (zzbzt != null && !TextUtils.isEmpty(zzbzt.zzc())) {
            if (zzv.zzC().currentTimeMillis() - zzbzt.zza() <= ((Long) zzbe.zzc().zza(zzbcn.zzei)).longValue() && zzbzt.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzm.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            zzfka zza2 = zzfjz.zza(context, 4);
            zza2.zzi();
            zzbny zza3 = zzv.zzg().zza(this.zza, versionInfoParcel, zzfko).zza("google.afma.config.fetchAppSettings", zzbof.zza, zzbof.zza);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONObject.put("app_id", str);
                    } catch (Exception e) {
                        exc = e;
                        zzfka = zza2;
                    }
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbce zzbce = zzbcn.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzbe.zza().zza()));
                jSONObject.put("js", versionInfoParcel.afmaVersion);
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zze.zza("Error fetching PackageInfo.");
                }
                ListenableFuture zzb2 = zza3.zzb(jSONObject);
                zzfka zzfka2 = zza2;
                Long l2 = l;
                try {
                    zzfka = zzfka2;
                    try {
                        ListenableFuture zzn = zzgei.zzn(zzb2, new zzd(this, l2, zzdsm, zzfko, zzfka2), zzcaj.zzf);
                        if (runnable != null) {
                            zzb2.addListener(runnable, zzcaj.zzf);
                        }
                        if (l2 != null) {
                            zzdsm zzdsm2 = zzdsm;
                            zzb2.addListener(new zze(this, zzdsm, l2), zzcaj.zzf);
                        }
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhr)).booleanValue()) {
                            zzcam.zzb(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                        } else {
                            zzcam.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                        }
                    } catch (Exception e2) {
                        e = e2;
                        exc = e;
                        zzm.zzh("Error requesting application settings", exc);
                        zzfka.zzh(exc);
                        zzfka.zzg(false);
                        zzfko.zzb(zzfka.zzm());
                    }
                } catch (Exception e3) {
                    e = e3;
                    zzfka = zzfka2;
                    exc = e;
                    zzm.zzh("Error requesting application settings", exc);
                    zzfka.zzh(exc);
                    zzfka.zzg(false);
                    zzfko.zzb(zzfka.zzm());
                }
            } catch (Exception e4) {
                e = e4;
                zzfka = zza2;
                exc = e;
                zzm.zzh("Error requesting application settings", exc);
                zzfka.zzh(exc);
                zzfka.zzg(false);
                zzfko.zzb(zzfka.zzm());
            }
        } else {
            zzm.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, zzbzt zzbzt, zzfko zzfko) {
        zzb(context, versionInfoParcel, false, zzbzt, zzbzt != null ? zzbzt.zzb() : null, str, (Runnable) null, zzfko, (zzdsm) null, (Long) null);
    }
}
