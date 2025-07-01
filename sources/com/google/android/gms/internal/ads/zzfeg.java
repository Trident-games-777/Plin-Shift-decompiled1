package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfeg implements zzeni {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzchk zzc;
    /* access modifiers changed from: private */
    public final zzfdw zzd;
    /* access modifiers changed from: private */
    public final zzfck zze;
    private final zzffg zzf;
    /* access modifiers changed from: private */
    public final zzfko zzg;
    private final zzffm zzh;
    private ListenableFuture zzi;

    public zzfeg(Context context, Executor executor, zzchk zzchk, zzfck zzfck, zzfdw zzfdw, zzffm zzffm, zzffg zzffg) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzchk;
        this.zze = zzfck;
        this.zzd = zzfdw;
        this.zzh = zzffm;
        this.zzf = zzffg;
        this.zzg = zzchk.zzz();
    }

    /* access modifiers changed from: private */
    public final zzdov zzk(zzfci zzfci) {
        zzdov zzi2 = this.zzc.zzi();
        zzcvu zzcvu = new zzcvu();
        zzcvu.zze(this.zza);
        zzcvu.zzi(((zzfee) zzfci).zza);
        zzcvu.zzh(this.zzf);
        zzi2.zzd(zzcvu.zzj());
        zzi2.zzc(new zzdcd().zzn());
        return zzi2;
    }

    public final boolean zza() {
        throw null;
    }

    public final boolean zzb(zzm zzm, String str, zzeng zzeng, zzenh zzenh) throws RemoteException {
        zzfkl zzfkl;
        zzbwq zzbwq = new zzbwq(zzm, str);
        zzfdy zzfdy = (zzfdy) zzeng;
        if (zzbwq.zzb == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzfdz(this));
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            zzfck zzfck = this.zze;
            if (zzfck.zzd() != null) {
                zzfkl zzh2 = ((zzdow) zzfck.zzd()).zzh();
                zzh2.zzi(5);
                zzh2.zzb(zzbwq.zza.zzp);
                zzh2.zzf(zzbwq.zza.zzm);
                zzfkl = zzh2;
                zzfgl.zza(this.zza, zzbwq.zza.zzf);
                if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue() && zzbwq.zza.zzf) {
                    this.zzc.zzl().zzo(true);
                }
                Bundle zza2 = zzdrx.zza(new Pair(zzdrv.PUBLIC_API_CALL.zza(), Long.valueOf(zzbwq.zza.zzz)), new Pair(zzdrv.DYNAMITE_ENTER.zza(), Long.valueOf(zzv.zzC().currentTimeMillis())));
                zzffm zzffm = this.zzh;
                zzffm.zzt(zzbwq.zzb);
                zzffm.zzs(zzs.zzd());
                zzffm.zzH(zzbwq.zza);
                zzffm.zzA(zza2);
                Context context = this.zza;
                zzffo zzJ = zzffm.zzJ();
                zzfka zzb2 = zzfjz.zzb(context, zzfkk.zzf(zzJ), 5, zzbwq.zza);
                zzfee zzfee = new zzfee((zzfef) null);
                zzfee.zza = zzJ;
                ListenableFuture zzc2 = this.zze.zzc(new zzfcl(zzfee, (zzbvx) null), new zzfea(this), (Object) null);
                this.zzi = zzc2;
                zzgei.zzr(zzc2, new zzfed(this, zzenh, zzfkl, zzb2, zzfee), this.zzb);
                return true;
            }
        }
        zzfkl = null;
        zzfgl.zza(this.zza, zzbwq.zza.zzf);
        this.zzc.zzl().zzo(true);
        Bundle zza22 = zzdrx.zza(new Pair(zzdrv.PUBLIC_API_CALL.zza(), Long.valueOf(zzbwq.zza.zzz)), new Pair(zzdrv.DYNAMITE_ENTER.zza(), Long.valueOf(zzv.zzC().currentTimeMillis())));
        zzffm zzffm2 = this.zzh;
        zzffm2.zzt(zzbwq.zzb);
        zzffm2.zzs(zzs.zzd());
        zzffm2.zzH(zzbwq.zza);
        zzffm2.zzA(zza22);
        Context context2 = this.zza;
        zzffo zzJ2 = zzffm2.zzJ();
        zzfka zzb22 = zzfjz.zzb(context2, zzfkk.zzf(zzJ2), 5, zzbwq.zza);
        zzfee zzfee2 = new zzfee((zzfef) null);
        zzfee2.zza = zzJ2;
        ListenableFuture zzc22 = this.zze.zzc(new zzfcl(zzfee2, (zzbvx) null), new zzfea(this), (Object) null);
        this.zzi = zzc22;
        zzgei.zzr(zzc22, new zzfed(this, zzenh, zzfkl, zzb22, zzfee2), this.zzb);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zzd.zzdB(zzfgq.zzd(6, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i) {
        this.zzh.zzp().zza(i);
    }
}
