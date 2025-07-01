package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeuo implements zzevz, zzevy {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;
    private final Context zzc;
    private final zzdsh zzd;

    zzeuo(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context, zzdsh zzdsh) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
        this.zzd = zzdsh;
    }

    public final int zza() {
        return 29;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzh(this);
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num;
        Bundle bundle = (Bundle) obj;
        String str = this.zza.packageName;
        PackageInfo packageInfo = this.zzb;
        String str2 = null;
        if (packageInfo == null) {
            num = null;
        } else {
            num = Integer.valueOf(packageInfo.versionCode);
        }
        bundle.putString("pn", str);
        if (num != null) {
            bundle.putInt("vc", num.intValue());
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzco)).booleanValue()) {
                this.zzd.zzc("vc", num.toString());
            }
        }
        PackageInfo packageInfo2 = this.zzb;
        if (packageInfo2 != null) {
            str2 = packageInfo2.versionName;
        }
        if (str2 != null) {
            bundle.putString("vnm", str2);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzco)).booleanValue()) {
                this.zzd.zzc("vn", str2);
            }
        }
        try {
            Context context = this.zzc;
            String str3 = this.zza.packageName;
            zzftd zzftd = zzs.zza;
            String valueOf = String.valueOf(Wrappers.packageManager(context).getApplicationLabel(str3));
            if (valueOf != null) {
                bundle.putString("dl", valueOf);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzmu)).booleanValue()) {
                try {
                    InstallSourceInfo installSourceInfo = this.zzc.getPackageManager().getInstallSourceInfo(str);
                    if (installSourceInfo != null) {
                        String installingPackageName = installSourceInfo.getInstallingPackageName();
                        if (!TextUtils.isEmpty(installingPackageName)) {
                            bundle.putString("ins_pn", installingPackageName);
                        } else {
                            zze.zza("No installing package name found");
                        }
                        String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                        if (!TextUtils.isEmpty(initiatingPackageName)) {
                            bundle.putString("ini_pn", initiatingPackageName);
                        } else {
                            zze.zza("No initiating package name found");
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    zzv.zzp().zzw(e, "PackageInfoSignalsource.compose");
                }
            }
        }
    }
}
