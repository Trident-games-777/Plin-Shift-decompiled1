package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxg implements zzhfx {
    private final zzhgp zza;

    public zzdxg(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = ((Context) this.zza.zzb()).getApplicationInfo();
        zzhgf.zzb(applicationInfo);
        ApplicationInfo applicationInfo2 = applicationInfo;
        return applicationInfo;
    }
}
