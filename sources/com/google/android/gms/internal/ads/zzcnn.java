package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnn implements zzcwm, zzcya, zzcxg, zza, zzcxc, zzdec {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzfff zze;
    /* access modifiers changed from: private */
    public final zzfet zzf;
    /* access modifiers changed from: private */
    public final zzfln zzg;
    /* access modifiers changed from: private */
    public final zzfga zzh;
    private final zzavc zzi;
    private final zzbdu zzj;
    private final WeakReference zzk;
    private final WeakReference zzl;
    private final zzcvo zzm;
    private boolean zzn;
    private final AtomicBoolean zzo = new AtomicBoolean();

    zzcnn(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfff zzfff, zzfet zzfet, zzfln zzfln, zzfga zzfga, View view, zzcfk zzcfk, zzavc zzavc, zzbdu zzbdu, zzbdw zzbdw, zzfkl zzfkl, zzcvo zzcvo) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfff;
        this.zzf = zzfet;
        this.zzg = zzfln;
        this.zzh = zzfga;
        this.zzi = zzavc;
        this.zzk = new WeakReference(view);
        this.zzl = new WeakReference(zzcfk);
        this.zzj = zzbdu;
        this.zzm = zzcvo;
    }

    /* access modifiers changed from: private */
    public final List zzu() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzla)).booleanValue()) {
            zzv.zzq();
            if (zzs.zzB(this.zza)) {
                zzv.zzq();
                Integer zzs = zzs.zzs(this.zza);
                if (zzs != null) {
                    Integer valueOf = Integer.valueOf(Math.min(zzs.intValue(), 20));
                    ArrayList arrayList = new ArrayList();
                    for (String parse : this.zzf.zzd) {
                        arrayList.add(Uri.parse(parse).buildUpon().appendQueryParameter("dspct", Integer.toString(valueOf.intValue())).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        String str;
        int i;
        List list = this.zzf.zzd;
        if (list != null && !list.isEmpty()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdD)).booleanValue()) {
                str = this.zzi.zzc().zzh(this.zza, (View) this.zzk.get(), (Activity) null);
            } else {
                str = null;
            }
            if ((!((Boolean) zzbe.zzc().zza(zzbcn.zzay)).booleanValue() || !this.zze.zzb.zzb.zzh) && ((Boolean) zzbem.zzh.zze()).booleanValue()) {
                if (((Boolean) zzbem.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
                    zzcfk zzcfk = (zzcfk) this.zzl.get();
                }
                zzgei.zzr((zzgdz) zzgei.zzo(zzgdz.zzu(zzgei.zzh((Object) null)), ((Long) zzbe.zzc().zza(zzbcn.zzbc)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcnm(this, str), this.zzb);
                return;
            }
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, false, str, (String) null, zzu()));
        }
    }

    private final void zzw(int i, int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzv();
        } else {
            this.zzd.schedule(new zzcnk(this, i, i2), (long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzbe.zzc().zza(zzbcn.zzay)).booleanValue() || !this.zze.zzb.zzb.zzh) && ((Boolean) zzbem.zzd.zze()).booleanValue()) {
            zzgei.zzr((zzgdz) zzgei.zze(zzgdz.zzu(this.zzj.zza()), Throwable.class, new zzcnh(), zzcaj.zzf), new zzcnl(this), this.zzb);
            return;
        }
        zzfga zzfga = this.zzh;
        zzfln zzfln = this.zzg;
        zzfff zzfff = this.zze;
        zzfet zzfet = this.zzf;
        Context context = this.zza;
        List zzc2 = zzfln.zzc(zzfff, zzfet, zzfet.zzc);
        int i = 1;
        if (true == zzv.zzp().zzA(context)) {
            i = 2;
        }
        zzfga.zzc(zzc2, i);
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzds(zzbwj zzbwj, String str, String str2) {
        zzfga zzfga = this.zzh;
        zzfln zzfln = this.zzg;
        zzfet zzfet = this.zzf;
        zzfga.zza(zzfln.zze(zzfet, zzfet.zzh, zzbwj));
    }

    public final void zze() {
        zzfga zzfga = this.zzh;
        zzfln zzfln = this.zzg;
        zzfff zzfff = this.zze;
        zzfet zzfet = this.zzf;
        zzfga.zza(zzfln.zzc(zzfff, zzfet, zzfet.zzi));
    }

    public final void zzf() {
        zzfga zzfga = this.zzh;
        zzfln zzfln = this.zzg;
        zzfff zzfff = this.zze;
        zzfet zzfet = this.zzf;
        zzfga.zza(zzfln.zzc(zzfff, zzfet, zzfet.zzg));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzb.execute(new zzcnj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(int i, int i2) {
        zzw(i - 1, i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        this.zzb.execute(new zzcni(this, i, i2));
    }

    public final void zzq(zze zze2) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbB)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfln.zzf(2, zze2.zza, this.zzf.zzo)));
        }
    }

    public final void zzr() {
        if (this.zzo.compareAndSet(false, true)) {
            int intValue = ((Integer) zzbe.zzc().zza(zzbcn.zzdM)).intValue();
            if (intValue > 0) {
                zzw(intValue, ((Integer) zzbe.zzc().zza(zzbcn.zzdN)).intValue());
                return;
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdL)).booleanValue()) {
                this.zzc.execute(new zzcng(this));
            } else {
                zzv();
            }
        }
    }

    public final synchronized void zzs() {
        zzcvo zzcvo;
        if (this.zzn) {
            ArrayList arrayList = new ArrayList(zzu());
            arrayList.addAll(this.zzf.zzf);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzfga zzfga = this.zzh;
            zzfln zzfln = this.zzg;
            zzfff zzfff = this.zze;
            zzfet zzfet = this.zzf;
            zzfga.zza(zzfln.zzc(zzfff, zzfet, zzfet.zzm));
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdI)).booleanValue() && (zzcvo = this.zzm) != null) {
                List zzh2 = zzfln.zzh(zzfln.zzg(zzcvo.zzb().zzm, zzcvo.zza().zzg()), this.zzm.zza().zza());
                zzfga zzfga2 = this.zzh;
                zzfln zzfln2 = this.zzg;
                zzcvo zzcvo2 = this.zzm;
                zzfga2.zza(zzfln2.zzc(zzcvo2.zzc(), zzcvo2.zzb(), zzh2));
            }
            zzfga zzfga3 = this.zzh;
            zzfln zzfln3 = this.zzg;
            zzfff zzfff2 = this.zze;
            zzfet zzfet2 = this.zzf;
            zzfga3.zza(zzfln3.zzc(zzfff2, zzfet2, zzfet2.zzf));
        }
        this.zzn = true;
    }

    public final void zzt() {
        zzfga zzfga = this.zzh;
        zzfln zzfln = this.zzg;
        zzfff zzfff = this.zze;
        zzfet zzfet = this.zzf;
        zzfga.zza(zzfln.zzc(zzfff, zzfet, zzfet.zzau));
    }
}
