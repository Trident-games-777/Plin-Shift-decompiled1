package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcit extends zzexr {
    private final zzeyo zza;
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

    /* synthetic */ zzcit(zzciy zzciy, zzeyo zzeyo, zzckd zzckd) {
        this.zzb = zzciy;
        this.zza = zzeyo;
        zzeyq zzeyq = new zzeyq(zzeyo);
        this.zzc = zzeyq;
        zzhgg zzc2 = zzhfw.zzc(zzdrh.zza());
        this.zzd = zzc2;
        zzhgg zzc3 = zzhfw.zzc(zzdrf.zza());
        this.zze = zzc3;
        zzhgg zzc4 = zzhfw.zzc(zzdrj.zza());
        this.zzf = zzc4;
        zzhgg zzc5 = zzhfw.zzc(zzdrl.zza());
        this.zzg = zzc5;
        zzhga zzc6 = zzhgb.zzc(4);
        zzc6.zzb(zzfjl.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfjl.BUILD_URL, zzc3);
        zzc6.zzb(zzfjl.HTTP, zzc4);
        zzc6.zzb(zzfjl.PRE_PROCESS, zzc5);
        zzhgb zzc7 = zzc6.zzc();
        this.zzh = zzc7;
        zzhgg zzc8 = zzhfw.zzc(new zzdrm(zzeyq, zzciy.zzh, zzfin.zza(), zzc7));
        this.zzi = zzc8;
        zzhgk zza2 = zzhgl.zza(0, 1);
        zza2.zza(zzc8);
        zzhgl zzc9 = zza2.zzc();
        this.zzj = zzc9;
        zzfju zzfju = new zzfju(zzc9);
        this.zzk = zzfju;
        this.zzl = zzhfw.zzc(new zzfjt(zzfin.zza(), zzciy.zze, zzfju));
        this.zzm = zzhfw.zzc(new zzfkm(zzciy.zzz));
    }

    public final zzewc zza() {
        Context zzc2 = zzchq.zzc(this.zzb.zza);
        zzeyi zzeyi = new zzeyi(zzclg.zza(), zzfin.zzc(), zzeyp.zza(this.zza));
        zzciy zzciy = this.zzb;
        zzges zzc3 = zzfin.zzc();
        HashSet hashSet = new HashSet();
        hashSet.add(new zzeun(zzeyi, 0, (ScheduledExecutorService) zzciy.zze.zzb()));
        zzewc zzewc = new zzewc(zzc2, zzc3, hashSet, (zzfkl) this.zzm.zzb(), (zzdsm) this.zzb.zzM.zzb());
        zzewc zzewc2 = zzewc;
        return zzewc;
    }

    public final zzfjr zzb() {
        return (zzfjr) this.zzl.zzb();
    }
}
