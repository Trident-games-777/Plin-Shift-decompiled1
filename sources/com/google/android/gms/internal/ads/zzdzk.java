package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdzk implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzdzk(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
    }

    /* renamed from: zza */
    public final zzdzj zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzdyn zza2 = ((zzdyo) this.zza).zzb();
        zzdyn zzdyn = zza2;
        Context zza3 = ((zzchq) this.zzd).zza();
        Context context = zza3;
        VersionInfoParcel zza4 = ((zzcid) this.zze).zza();
        VersionInfoParcel versionInfoParcel = zza4;
        return new zzdzj(zzc2, zza2, zzhfw.zza(zzhgi.zza(this.zzb)), (zzfko) this.zzc.zzb(), zza3, zza4);
    }
}
