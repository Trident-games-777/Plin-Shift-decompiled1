package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfau implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;

    public zzfau(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfck zza2 = ((zzfcm) this.zzd).zzb();
        zzfck zzfck = zza2;
        zzffm zzffm = new zzffm();
        zzffm zzffm2 = zzffm;
        VersionInfoParcel zza3 = ((zzcid) this.zzf).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        return new zzfat((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (zzchk) this.zzc.zzb(), zza2, (zzfar) this.zze.zzb(), zzffm, zza3);
    }
}
