package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcph implements zzhfx {
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

    public zzcph(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp7;
        this.zzh = zzhgp8;
        this.zzi = zzhgp9;
        this.zzj = zzhgp10;
    }

    public static zzcpg zzc(zzcrp zzcrp, Context context, zzfeu zzfeu, View view, zzcfk zzcfk, zzcro zzcro, zzdjj zzdjj, zzden zzden, zzhfr zzhfr, Executor executor) {
        return new zzcpg(zzcrp, context, zzfeu, view, zzcfk, zzcro, zzdjj, zzden, zzhfr, executor);
    }

    /* renamed from: zza */
    public final zzcpg zzb() {
        zzcrp zza2 = ((zzcua) this.zza).zzb();
        zzcrp zzcrp = zza2;
        zzfeu zza3 = ((zzcpn) this.zzc).zza();
        zzfeu zzfeu = zza3;
        View zza4 = ((zzcpm) this.zzd).zza();
        View view = zza4;
        zzcfk zza5 = ((zzcqa) this.zze).zza();
        zzcfk zzcfk = zza5;
        zzcro zza6 = ((zzcpo) this.zzf).zza();
        zzcro zzcro = zza6;
        zzdjj zza7 = ((zzdhh) this.zzg).zza();
        zzdjj zzdjj = zza7;
        return new zzcpg(zza2, (Context) this.zzb.zzb(), zza3, zza4, zza5, zza6, zza7, (zzden) this.zzh.zzb(), zzhfw.zza(zzhgi.zza(this.zzi)), (Executor) this.zzj.zzb());
    }
}
