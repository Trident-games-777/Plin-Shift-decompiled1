package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfbf implements zzeni {
    private final Context zza;
    private final Executor zzb;
    private final zzchk zzc;
    private final zzems zzd;
    private final zzemw zze;
    private final ViewGroup zzf;
    private zzbdi zzg;
    /* access modifiers changed from: private */
    public final zzcze zzh;
    /* access modifiers changed from: private */
    public final zzfko zzi;
    /* access modifiers changed from: private */
    public final zzdbk zzj;
    private final zzffm zzk;
    private ListenableFuture zzl;
    /* access modifiers changed from: private */
    public boolean zzm = true;
    /* access modifiers changed from: private */
    public zze zzn = null;
    private zzenh zzo = null;

    public zzfbf(Context context, Executor executor, zzs zzs, zzchk zzchk, zzems zzems, zzemw zzemw, zzffm zzffm, zzdbk zzdbk) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzchk;
        this.zzd = zzems;
        this.zze = zzemw;
        this.zzk = zzffm;
        this.zzh = zzchk.zzf();
        this.zzi = zzchk.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdbk;
        zzffm.zzs(zzs);
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        this.zzl = null;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhO)).booleanValue()) {
            this.zzb.execute(new zzfbb(this));
        }
        zzenh zzenh = this.zzo;
        if (zzenh != null) {
            zzenh.zza();
        }
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return listenableFuture != null && !listenableFuture.isDone();
    }

    public final boolean zzb(zzm zzm2, String str, zzeng zzeng, zzenh zzenh) throws RemoteException {
        zzcqh zzcqh;
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzfbd(this));
            return false;
        }
        if (!zza()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue() && zzm2.zzf) {
                this.zzc.zzl().zzo(true);
            }
            Bundle zza2 = zzdrx.zza(new Pair(zzdrv.PUBLIC_API_CALL.zza(), Long.valueOf(zzm2.zzz)), new Pair(zzdrv.DYNAMITE_ENTER.zza(), Long.valueOf(zzv.zzC().currentTimeMillis())));
            zzffm zzffm = this.zzk;
            zzffm.zzt(str);
            zzffm.zzH(zzm2);
            zzffm.zzA(zza2);
            Context context = this.zza;
            zzffo zzJ = zzffm.zzJ();
            zzfka zzb2 = zzfjz.zzb(context, zzfkk.zzf(zzJ), 3, zzm2);
            zzfkl zzfkl = null;
            if (!((Boolean) zzbet.zze.zze()).booleanValue() || !this.zzk.zzh().zzk) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhO)).booleanValue()) {
                    zzcqg zze2 = this.zzc.zze();
                    zzcvu zzcvu = new zzcvu();
                    zzcvu.zze(this.zza);
                    zzcvu.zzi(zzJ);
                    zze2.zzi(zzcvu.zzj());
                    zzdcd zzdcd = new zzdcd();
                    zzdcd.zzj(this.zzd, this.zzb);
                    zzdcd.zzk(this.zzd, this.zzb);
                    zze2.zzf(zzdcd.zzn());
                    zze2.zze(new zzelb(this.zzg));
                    zze2.zzd(new zzdhe(zzdjj.zza, (zzbl) null));
                    zze2.zzg(new zzcri(this.zzh, this.zzj));
                    zze2.zzc(new zzcpa(this.zzf));
                    zzcqh = zze2.zzk();
                } else {
                    zzcqg zze3 = this.zzc.zze();
                    zzcvu zzcvu2 = new zzcvu();
                    zzcvu2.zze(this.zza);
                    zzcvu2.zzi(zzJ);
                    zze3.zzi(zzcvu2.zzj());
                    zzdcd zzdcd2 = new zzdcd();
                    zzdcd2.zzj(this.zzd, this.zzb);
                    zzdcd2.zza(this.zzd, this.zzb);
                    zzdcd2.zza(this.zze, this.zzb);
                    zzdcd2.zzl(this.zzd, this.zzb);
                    zzdcd2.zzd(this.zzd, this.zzb);
                    zzdcd2.zze(this.zzd, this.zzb);
                    zzdcd2.zzf(this.zzd, this.zzb);
                    zzdcd2.zzb(this.zzd, this.zzb);
                    zzdcd2.zzk(this.zzd, this.zzb);
                    zzdcd2.zzi(this.zzd, this.zzb);
                    zze3.zzf(zzdcd2.zzn());
                    zze3.zze(new zzelb(this.zzg));
                    zze3.zzd(new zzdhe(zzdjj.zza, (zzbl) null));
                    zze3.zzg(new zzcri(this.zzh, this.zzj));
                    zze3.zzc(new zzcpa(this.zzf));
                    zzcqh = zze3.zzk();
                }
                if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
                    zzfkl = zzcqh.zzj();
                    zzfkl.zzi(3);
                    zzfkl.zzb(zzm2.zzp);
                    zzfkl.zzf(zzm2.zzm);
                }
                this.zzo = zzenh;
                zzcsy zzd2 = zzcqh.zzd();
                ListenableFuture zzi2 = zzd2.zzi(zzd2.zzj());
                this.zzl = zzi2;
                zzgei.zzr(zzi2, new zzfbe(this, zzfkl, zzb2, zzcqh), this.zzb);
                return true;
            }
            zzems zzems = this.zzd;
            if (zzems != null) {
                zzems.zzdB(zzfgq.zzd(7, (String) null, (zze) null));
            }
        } else if (!this.zzk.zzS()) {
            this.zzm = true;
        }
        return false;
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final zzffm zzg() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(this.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl() {
        this.zzd.zzdB(zzfgq.zzd(6, (String) null, (zze) null));
    }

    public final void zzm() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzn() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final void zzo(zzbi zzbi) {
        this.zze.zza(zzbi);
    }

    public final void zzp(zzcyy zzcyy) {
        this.zzh.zzo(zzcyy, this.zzb);
    }

    public final void zzq(zzbdi zzbdi) {
        this.zzg = zzbdi;
    }

    public final void zzr() {
        synchronized (this) {
            ListenableFuture listenableFuture = this.zzl;
            if (listenableFuture != null && listenableFuture.isDone()) {
                try {
                    zzcpd zzcpd = (zzcpd) this.zzl.get();
                    this.zzl = null;
                    this.zzf.removeAllViews();
                    if (zzcpd.zzd() != null) {
                        ViewParent parent = zzcpd.zzd().getParent();
                        if (parent instanceof ViewGroup) {
                            String str = "";
                            if (zzcpd.zzm() != null) {
                                str = zzcpd.zzm().zzg();
                            }
                            com.google.android.gms.ads.internal.util.client.zzm.zzj("Banner view provided from " + str + " already has a parent view. Removing its old parent.");
                            ((ViewGroup) parent).removeView(zzcpd.zzd());
                        }
                    }
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzhO)).booleanValue()) {
                        zzdas zzo2 = zzcpd.zzo();
                        zzo2.zza(this.zzd);
                        zzo2.zzc(this.zze);
                    }
                    this.zzf.addView(zzcpd.zzd());
                    this.zzo.zzb(zzcpd);
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzhO)).booleanValue()) {
                        Executor executor = this.zzb;
                        zzems zzems = this.zzd;
                        Objects.requireNonNull(zzems);
                        executor.execute(new zzfbc(zzems));
                    }
                    if (zzcpd.zza() >= 0) {
                        this.zzm = false;
                        this.zzh.zzd(zzcpd.zza());
                        this.zzh.zze(zzcpd.zzc());
                    } else {
                        this.zzm = true;
                        this.zzh.zzd(zzcpd.zzc());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzu();
                    com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                    this.zzm = true;
                    this.zzh.zza();
                }
            } else if (this.zzl != null) {
                com.google.android.gms.ads.internal.util.zze.zza("Show timer went off but there is an ongoing ad request.");
                this.zzm = true;
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                this.zzm = true;
                this.zzh.zza();
            }
        }
    }

    public final boolean zzt() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzv.zzq();
        return com.google.android.gms.ads.internal.util.zzs.zzW(view, view.getContext());
    }
}
