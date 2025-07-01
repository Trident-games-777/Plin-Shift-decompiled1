package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepx implements zzhfx {
    private final zzhgp zza;

    public zzepx(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
    }

    /* renamed from: zza */
    public final zzepv zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zza).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zzges zzc = zzfin.zzc();
        zzges zzges = zzc;
        return new zzepv(zza2, zzc);
    }
}
