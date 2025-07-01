package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.zzap;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzw;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzchk implements zzclo {
    @Nullable
    private static zzchk zza;

    private static synchronized zzchk zzG(Context context, @Nullable zzbpg zzbpg, int i, boolean z, int i2, zzcio zzcio) {
        synchronized (zzchk.class) {
            zzchk zzchk = zza;
            if (zzchk != null) {
                return zzchk;
            }
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            zzbcn.zza(context);
            if (((Boolean) zzbef.zze.zze()).booleanValue()) {
                zzbbx.zzd(context);
            }
            zzfgk zzd = zzfgk.zzd(context);
            VersionInfoParcel zzc = zzd.zzc(243799000, false, i2);
            zzd.zzf(zzbpg);
            zzcjj zzcjj = new zzcjj((zzckd) null);
            zzchl zzchl = new zzchl();
            zzchl.zzf(zzc);
            zzchl.zze(context);
            zzchl.zzd(currentTimeMillis);
            zzcjj.zzb(new zzchn(zzchl, (zzchm) null));
            zzcjj.zzc(new zzcke(zzcio));
            zzchk zza2 = zzcjj.zza();
            zzv.zzp().zzu(context, zzc);
            zzv.zzc().zzi(context);
            zzv.zzq().zzl(context);
            zzv.zzq().zzk(context);
            zzd.zza(context);
            zzv.zzb().zzd(context);
            zzv.zzw().zzb(context);
            zza2.zza().zzc();
            zzbyw.zzd(context);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue()) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzaF)).booleanValue()) {
                    new zzedc(context, zzc, new zzbbl(new zzbbr(context)), new zzech(new zzecd(context), zza2.zzB())).zzb(zzv.zzp().zzi().zzN());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzchk zzb(Context context, @Nullable zzbpg zzbpg, int i) {
        return zzG(context, zzbpg, 243799000, false, i, new zzcio());
    }

    public abstract zzfma zzA();

    public abstract zzges zzB();

    public abstract Executor zzC();

    public abstract ScheduledExecutorService zzD();

    public abstract zzbzo zzE();

    public final zzbzo zzF() {
        return zzE();
    }

    public abstract zzca zza();

    public abstract zzckp zzc();

    public abstract zzcoq zzd();

    public abstract zzcqg zze();

    public abstract zzcze zzf();

    public abstract zzdgm zzg();

    public abstract zzdhi zzh();

    public abstract zzdov zzi();

    public abstract zzdsm zzj();

    public abstract zzdtv zzk();

    public abstract zzdvk zzl();

    public abstract zzdwh zzm();

    public abstract zzeea zzn();

    public abstract zzq zzo();

    public abstract zzw zzp();

    public abstract zzap zzq();

    public final zzexc zzr(zzbvx zzbvx, int i) {
        return zzs(new zzeyv(zzbvx, i));
    }

    /* access modifiers changed from: protected */
    public abstract zzexc zzs(zzeyv zzeyv);

    public abstract zzezt zzt();

    public abstract zzfbh zzu();

    public abstract zzfcy zzv();

    public abstract zzfem zzw();

    public abstract zzfgd zzx();

    public abstract zzfgn zzy();

    public abstract zzfko zzz();
}
