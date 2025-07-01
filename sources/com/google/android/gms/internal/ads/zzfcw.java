package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfcw implements zzeni {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzchk zzc;
    /* access modifiers changed from: private */
    public final zzems zzd;
    /* access modifiers changed from: private */
    public final zzfdw zze;
    private zzbdi zzf;
    /* access modifiers changed from: private */
    public final zzfko zzg;
    private final zzffm zzh;
    /* access modifiers changed from: private */
    public ListenableFuture zzi;

    public zzfcw(Context context, Executor executor, zzchk zzchk, zzems zzems, zzfdw zzfdw, zzffm zzffm) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzchk;
        this.zzd = zzems;
        this.zzh = zzffm;
        this.zze = zzfdw;
        this.zzg = zzchk.zzz();
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return listenableFuture != null && !listenableFuture.isDone();
    }

    public final boolean zzb(zzm zzm, String str, zzeng zzeng, zzenh zzenh) {
        zzdgn zzf2;
        zzfkl zzfkl;
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzfcq(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue() && zzm.zzf) {
                this.zzc.zzl().zzo(true);
            }
            zzs zzs = ((zzfcp) zzeng).zza;
            Bundle zza2 = zzdrx.zza(new Pair(zzdrv.PUBLIC_API_CALL.zza(), Long.valueOf(zzm.zzz)), new Pair(zzdrv.DYNAMITE_ENTER.zza(), Long.valueOf(zzv.zzC().currentTimeMillis())));
            zzffm zzffm = this.zzh;
            zzffm.zzt(str);
            zzffm.zzs(zzs);
            zzffm.zzH(zzm);
            zzffm.zzA(zza2);
            Context context = this.zza;
            zzffo zzJ = zzffm.zzJ();
            zzfka zzb2 = zzfjz.zzb(context, zzfkk.zzf(zzJ), 4, zzm);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhQ)).booleanValue()) {
                zzdgm zzg2 = this.zzc.zzg();
                zzcvu zzcvu = new zzcvu();
                zzcvu.zze(this.zza);
                zzcvu.zzi(zzJ);
                zzg2.zze(zzcvu.zzj());
                zzdcd zzdcd = new zzdcd();
                zzdcd.zzj(this.zzd, this.zzb);
                zzdcd.zzk(this.zzd, this.zzb);
                zzg2.zzd(zzdcd.zzn());
                zzg2.zzc(new zzelb(this.zzf));
                zzf2 = zzg2.zzf();
            } else {
                zzdcd zzdcd2 = new zzdcd();
                zzfdw zzfdw = this.zze;
                if (zzfdw != null) {
                    zzdcd2.zze(zzfdw, this.zzb);
                    zzdcd2.zzf(this.zze, this.zzb);
                    zzdcd2.zzb(this.zze, this.zzb);
                }
                zzdgm zzg3 = this.zzc.zzg();
                zzcvu zzcvu2 = new zzcvu();
                zzcvu2.zze(this.zza);
                zzcvu2.zzi(zzJ);
                zzg3.zze(zzcvu2.zzj());
                zzdcd2.zzj(this.zzd, this.zzb);
                zzdcd2.zze(this.zzd, this.zzb);
                zzdcd2.zzf(this.zzd, this.zzb);
                zzdcd2.zzb(this.zzd, this.zzb);
                zzdcd2.zza(this.zzd, this.zzb);
                zzdcd2.zzl(this.zzd, this.zzb);
                zzdcd2.zzk(this.zzd, this.zzb);
                zzdcd2.zzi(this.zzd, this.zzb);
                zzdcd2.zzc(this.zzd, this.zzb);
                zzg3.zzd(zzdcd2.zzn());
                zzg3.zzc(new zzelb(this.zzf));
                zzf2 = zzg3.zzf();
            }
            zzdgn zzdgn = zzf2;
            if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
                zzfkl = zzdgn.zzf();
                zzfkl.zzi(4);
                zzfkl.zzb(zzm.zzp);
                zzfkl.zzf(zzm.zzm);
            } else {
                zzfkl = null;
            }
            zzcsy zza3 = zzdgn.zza();
            ListenableFuture zzi2 = zza3.zzi(zza3.zzj());
            this.zzi = zzi2;
            zzgei.zzr(zzi2, new zzfcv(this, zzenh, zzfkl, zzb2, zzdgn), this.zzb);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zzdB(zzfgq.zzd(6, (String) null, (zze) null));
    }

    public final void zzi(zzbdi zzbdi) {
        this.zzf = zzbdi;
    }
}
