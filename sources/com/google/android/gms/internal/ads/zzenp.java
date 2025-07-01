package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenp implements zzeni {
    private final zzffm zza;
    /* access modifiers changed from: private */
    public final zzchk zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzenf zzd;
    /* access modifiers changed from: private */
    public final zzfko zze;
    private zzcsf zzf;

    public zzenp(zzchk zzchk, Context context, zzenf zzenf, zzffm zzffm) {
        this.zzb = zzchk;
        this.zzc = context;
        this.zzd = zzenf;
        this.zza = zzffm;
        this.zze = zzchk.zzz();
        zzffm.zzv(zzenf.zzd());
    }

    public final boolean zza() {
        zzcsf zzcsf = this.zzf;
        return zzcsf != null && zzcsf.zzf();
    }

    public final boolean zzb(zzm zzm, String str, zzeng zzeng, zzenh zzenh) throws RemoteException {
        zzv.zzq();
        if (zzs.zzH(this.zzc) && zzm.zzs == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzC().execute(new zzenk(this));
            return false;
        } else if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzC().execute(new zzenl(this));
            return false;
        } else {
            zzfgl.zza(this.zzc, zzm.zzf);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue() && zzm.zzf) {
                this.zzb.zzl().zzo(true);
            }
            int i = ((zzenj) zzeng).zza;
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            String zza2 = zzdrv.PUBLIC_API_CALL.zza();
            Long valueOf = Long.valueOf(currentTimeMillis);
            Bundle zza3 = zzdrx.zza(new Pair(zza2, valueOf), new Pair(zzdrv.DYNAMITE_ENTER.zza(), valueOf));
            zzffm zzffm = this.zza;
            zzffm.zzH(zzm);
            zzffm.zzA(zza3);
            zzffm.zzC(i);
            Context context = this.zzc;
            zzffo zzJ = zzffm.zzJ();
            zzfka zzb2 = zzfjz.zzb(context, zzfkk.zzf(zzJ), 8, zzm);
            zzcm zzcm = zzJ.zzn;
            if (zzcm != null) {
                this.zzd.zzd().zzm(zzcm);
            }
            zzdhi zzh = this.zzb.zzh();
            zzcvu zzcvu = new zzcvu();
            zzcvu.zze(this.zzc);
            zzcvu.zzi(zzJ);
            zzh.zzf(zzcvu.zzj());
            zzdcd zzdcd = new zzdcd();
            zzdcd.zzk(this.zzd.zzd(), this.zzb.zzC());
            zzh.zze(zzdcd.zzn());
            zzh.zzd(this.zzd.zzc());
            zzfkl zzfkl = null;
            zzh.zzc(new zzcpa((ViewGroup) null));
            zzdhj zzg = zzh.zzg();
            if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
                zzfkl = zzg.zzf();
                zzfkl.zzi(8);
                zzfkl.zzb(zzm.zzp);
                zzfkl.zzf(zzm.zzm);
            }
            zzfkl zzfkl2 = zzfkl;
            this.zzb.zzy().zzc(1);
            zzchk zzchk = this.zzb;
            zzges zzc2 = zzfin.zzc();
            ScheduledExecutorService zzD = zzchk.zzD();
            zzcsy zza4 = zzg.zza();
            zzcsf zzcsf = new zzcsf(zzc2, zzD, zza4.zzi(zza4.zzj()));
            this.zzf = zzcsf;
            zzcsf.zze(new zzeno(this, zzenh, zzfkl2, zzb2, zzg));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zzdB(zzfgq.zzd(4, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zzdB(zzfgq.zzd(6, (String) null, (zze) null));
    }
}
