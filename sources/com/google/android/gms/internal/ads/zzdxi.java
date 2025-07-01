package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxi implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdxi(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        ApplicationInfo zza2 = ((zzdxg) this.zzb).zzb();
        ApplicationInfo applicationInfo = zza2;
        try {
            return Wrappers.packageManager(context).getPackageInfo(zza2.packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
