package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzhfx;
import com.google.android.gms.internal.ads.zzhgp;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class CsiParamDefaults_Factory implements zzhfx<CsiParamDefaults> {
    private final zzhgp zza;
    private final zzhgp zzb;

    public CsiParamDefaults_Factory(zzhgp<Context> zzhgp, zzhgp<VersionInfoParcel> zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public static CsiParamDefaults_Factory create(zzhgp<Context> zzhgp, zzhgp<VersionInfoParcel> zzhgp2) {
        return new CsiParamDefaults_Factory(zzhgp, zzhgp2);
    }

    public static CsiParamDefaults newInstance(Context context, VersionInfoParcel versionInfoParcel) {
        return new CsiParamDefaults(context, versionInfoParcel);
    }

    /* renamed from: get */
    public CsiParamDefaults zzb() {
        return newInstance((Context) this.zza.zzb(), (VersionInfoParcel) this.zzb.zzb());
    }
}
