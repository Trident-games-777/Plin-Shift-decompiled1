package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzw implements zzfwh {
    public final /* synthetic */ zzbvx zza;

    public /* synthetic */ zzdzw(zzbvx zzbvx) {
        this.zza = zzbvx;
    }

    public final Object apply(Object obj) {
        zzbvx zzbvx = this.zza;
        String zzc = zzfxf.zzc(zzbvx.zza.getString("ms"));
        ApplicationInfo applicationInfo = zzbvx.zzc;
        String str = zzbvx.zzh;
        return new zzbuv(applicationInfo, zzbvx.zzd, zzbvx.zzf, zzc, -1, str, zzbvx.zze, zzbvx.zzk, zzbvx.zzl);
    }
}
