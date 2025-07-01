package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzevq implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzevq(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    /* renamed from: zza */
    public final zzevo zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        String zza4 = ((zzchv) this.zzc).zzb();
        String str = zza4;
        return new zzevo(zzc2, zza2, zza3, zza4);
    }
}
