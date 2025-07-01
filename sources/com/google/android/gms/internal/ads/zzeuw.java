package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeuw implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzeuw(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    /* renamed from: zza */
    public final zzeuu zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzffo zza3 = ((zzcwd) this.zzb).zza();
        zzffo zzffo = zza3;
        VersionInfoParcel zza4 = ((zzcid) this.zzc).zza();
        VersionInfoParcel versionInfoParcel = zza4;
        return new zzeuu(zza2, zzc2, zza3, zza4);
    }
}
