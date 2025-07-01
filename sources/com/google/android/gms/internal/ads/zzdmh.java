package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdmh implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;
    private final zzhgp zzi;
    private final zzhgp zzj;
    private final zzhgp zzk;
    private final zzhgp zzl;
    private final zzhgp zzm;
    private final zzhgp zzn;
    private final zzhgp zzo;
    private final zzhgp zzp;

    public zzdmh(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10, zzhgp zzhgp11, zzhgp zzhgp12, zzhgp zzhgp13, zzhgp zzhgp14, zzhgp zzhgp15, zzhgp zzhgp16, zzhgp zzhgp17) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
        this.zzi = zzhgp10;
        this.zzj = zzhgp11;
        this.zzk = zzhgp12;
        this.zzl = zzhgp13;
        this.zzm = zzhgp14;
        this.zzn = zzhgp15;
        this.zzo = zzhgp16;
        this.zzp = zzhgp17;
    }

    /* renamed from: zza */
    public final zzdmg zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zzd).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zza zza3 = ((zzckf) this.zze).zza();
        zza zza4 = zza3;
        zzffo zza5 = ((zzcwd) this.zzg).zza();
        zzffo zzffo = zza5;
        return new zzdmg((Context) this.zza.zzb(), (zzdlk) this.zzb.zzb(), (zzavc) this.zzc.zzb(), zza2, zza3, (zzbbl) this.zzf.zzb(), zzfin.zzc(), zza5, (zzdmy) this.zzh.zzb(), (zzdpn) this.zzi.zzb(), (ScheduledExecutorService) this.zzj.zzb(), (zzdsm) this.zzk.zzb(), (zzflr) this.zzl.zzb(), (zzedp) this.zzm.zzb(), (zzdoi) this.zzn.zzb(), (zzeea) this.zzo.zzb(), (zzffs) this.zzp.zzb());
    }
}
