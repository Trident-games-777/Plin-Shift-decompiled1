package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzciv extends zzext {
    private final zzexh zza;
    private final zzciy zzb;
    private final zzhgg zzc;
    private final zzhgg zzd;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;
    private final zzhgg zzh;
    private final zzhgg zzi;
    private final zzhgg zzj;
    private final zzhgg zzk;
    private final zzhgg zzl;
    private final zzhgg zzm;

    /* synthetic */ zzciv(zzciy zzciy, zzexh zzexh, zzckd zzckd) {
        this.zzb = zzciy;
        this.zza = zzexh;
        this.zzc = zzhfw.zzc(new zzfkm(zzciy.zzz));
        zzexp zzexp = new zzexp(zzexh);
        this.zzd = zzexp;
        zzhgg zzc2 = zzhfw.zzc(zzdrh.zza());
        this.zze = zzc2;
        zzhgg zzc3 = zzhfw.zzc(zzdrf.zza());
        this.zzf = zzc3;
        zzhgg zzc4 = zzhfw.zzc(zzdrj.zza());
        this.zzg = zzc4;
        zzhgg zzc5 = zzhfw.zzc(zzdrl.zza());
        this.zzh = zzc5;
        zzhga zzc6 = zzhgb.zzc(4);
        zzc6.zzb(zzfjl.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfjl.BUILD_URL, zzc3);
        zzc6.zzb(zzfjl.HTTP, zzc4);
        zzc6.zzb(zzfjl.PRE_PROCESS, zzc5);
        zzhgb zzc7 = zzc6.zzc();
        this.zzi = zzc7;
        zzhgg zzc8 = zzhfw.zzc(new zzdrm(zzexp, zzciy.zzh, zzfin.zza(), zzc7));
        this.zzj = zzc8;
        zzhgk zza2 = zzhgl.zza(0, 1);
        zza2.zza(zzc8);
        zzhgl zzc9 = zza2.zzc();
        this.zzk = zzc9;
        zzfju zzfju = new zzfju(zzc9);
        this.zzl = zzfju;
        this.zzm = zzhfw.zzc(new zzfjt(zzfin.zza(), zzciy.zze, zzfju));
    }

    public final zzewc zza() {
        Context zzc2 = zzchq.zzc(this.zzb.zza);
        zzexh zzexh = this.zza;
        zzges zzc3 = zzfin.zzc();
        zzevz zza2 = zzezg.zza(new zzeyi(zzclg.zza(), zzfin.zzc(), zzexi.zza(zzexh)), zzeuh.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), 0);
        zzevz zza3 = zzezh.zza(new zzeys(zzcli.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzchq.zzc(this.zzb.zza)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzciy zzciy = this.zzb;
        zzexh zzexh2 = this.zza;
        zzevz zza4 = zzeze.zza(zzexb.zza(zzclk.zza(), zzchq.zzc(zzciy.zza), (ScheduledExecutorService) this.zzb.zze.zzb(), zzfin.zzc(), zzexj.zza(zzexh2), zzexl.zza(zzexh2), zzexm.zza(zzexh2)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzevz zza5 = zzezi.zza(new zzezq(zzfin.zzc()), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzciy zzciy2 = this.zzb;
        zzevz zza6 = zzezf.zza();
        zzeya zzeya = new zzeya(zzcle.zza(), zzfin.zzc(), zzchq.zzc(zzciy2.zza));
        zzexh zzexh3 = this.zza;
        zzexh zzexh4 = this.zza;
        return new zzewc(zzc2, zzc3, zzfzt.zzs(zza2, zza3, zza4, zza5, zza6, zzeya, new zzeym(zzckz.zza(), zzfin.zzc(), zzexk.zza(zzexh3)), new zzexf(zzclk.zza(), zzfin.zzc(), zzexn.zza(zzexh4), zzexo.zza(zzexh4), zzexj.zza(zzexh4)), (zzevz) this.zzb.zzbh.zzb(), zzexy.zza(zzexi.zza(this.zza), zzclc.zza(), (zzbzz) this.zzb.zzaj.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzfin.zzc())), (zzfkl) this.zzc.zzb(), (zzdsm) this.zzb.zzM.zzb());
    }

    public final zzfjr zzb() {
        return (zzfjr) this.zzm.zzb();
    }
}
