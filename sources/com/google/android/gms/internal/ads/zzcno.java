package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcno implements zzhfx {
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

    public zzcno(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10, zzhgp zzhgp11, zzhgp zzhgp12, zzhgp zzhgp13, zzhgp zzhgp14, zzhgp zzhgp15) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
        this.zzi = zzhgp10;
        this.zzj = zzhgp11;
        this.zzk = zzhgp12;
        this.zzl = zzhgp14;
        this.zzm = zzhgp15;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzfff zza3 = ((zzcsk) this.zzd).zza();
        zzfff zzfff = zza3;
        zzfet zza4 = ((zzcsh) this.zze).zza();
        zzfet zzfet = zza4;
        zzbdw zza5 = zzckg.zza();
        zzbdw zzbdw = zza5;
        zzcvo zza6 = ((zzcwa) this.zzm).zza();
        zzcvo zzcvo = zza6;
        return new zzcnn(zza2, zzfin.zzc(), (Executor) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zza3, zza4, (zzfln) this.zzf.zzb(), (zzfga) this.zzg.zzb(), (View) this.zzh.zzb(), (zzcfk) this.zzi.zzb(), (zzavc) this.zzj.zzb(), (zzbdu) this.zzk.zzb(), zza5, (zzfkl) this.zzl.zzb(), zza6);
    }
}
