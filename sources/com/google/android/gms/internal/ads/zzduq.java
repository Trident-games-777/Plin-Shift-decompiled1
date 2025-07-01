package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzduq implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;
    private final zzhgp zzi;

    public zzduq(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
        this.zzi = zzhgp10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zzb).zza();
        Context context = zza2;
        WeakReference zza3 = ((zzchr) this.zzc).zza();
        WeakReference weakReference = zza3;
        VersionInfoParcel zza4 = ((zzcid) this.zzg).zza();
        VersionInfoParcel versionInfoParcel = zza4;
        zzddk zza5 = ((zzddl) this.zzh).zzb();
        zzddk zzddk = zza5;
        return new zzdup((Executor) this.zza.zzb(), zza2, zza3, zzfin.zzc(), (zzdqd) this.zzd.zzb(), (ScheduledExecutorService) this.zze.zzb(), (zzdsw) this.zzf.zzb(), zza4, zza5, (zzfko) this.zzi.zzb());
    }
}
