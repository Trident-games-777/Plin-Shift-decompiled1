package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfba implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;

    public zzfba(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zzf).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        return new zzfaz((zzchk) this.zza.zzb(), (Context) this.zzb.zzb(), (String) this.zzc.zzb(), (zzfat) this.zzd.zzb(), (zzfar) this.zze.zzb(), zza2, (zzdsm) this.zzg.zzb());
    }
}
