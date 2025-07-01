package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeww implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;

    public zzeww(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzg zza2 = ((zzcho) this.zza).zzb();
        zzg zzg = zza2;
        Context zza3 = ((zzchq) this.zzb).zza();
        Context context = zza3;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzeez zza4 = ((zzefa) this.zzd).zzb();
        zzeez zzeez = zza4;
        zzffo zza5 = ((zzcwd) this.zze).zza();
        zzffo zzffo = zza5;
        VersionInfoParcel zza6 = ((zzcid) this.zzf).zza();
        VersionInfoParcel versionInfoParcel = zza6;
        return new zzewt(zza2, zza3, zzc2, (ScheduledExecutorService) this.zzc.zzb(), zza4, zza5, zza6);
    }
}
