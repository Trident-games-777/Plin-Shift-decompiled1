package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdpm {
    private final zzcwk zza;
    private final zzdej zzb;
    /* access modifiers changed from: private */
    public final zzcxt zzc;
    private final zzcyg zzd;
    private final zzcys zze;
    private final zzdbi zzf;
    private final Executor zzg;
    private final zzdef zzh;
    private final zzcny zzi;
    private final zzb zzj;
    private final zzbyh zzk;
    private final zzavc zzl;
    /* access modifiers changed from: private */
    public final zzdaz zzm;
    private final zzedp zzn;
    private final zzflr zzo;
    private final zzdsm zzp;
    private final zzcnb zzq;
    private final zzdps zzr;

    public zzdpm(zzcwk zzcwk, zzcxt zzcxt, zzcyg zzcyg, zzcys zzcys, zzdbi zzdbi, Executor executor, zzdef zzdef, zzcny zzcny, zzb zzb2, zzbyh zzbyh, zzavc zzavc, zzdaz zzdaz, zzedp zzedp, zzflr zzflr, zzdsm zzdsm, zzdej zzdej, zzcnb zzcnb, zzdps zzdps) {
        this.zza = zzcwk;
        this.zzc = zzcxt;
        this.zzd = zzcyg;
        this.zze = zzcys;
        this.zzf = zzdbi;
        this.zzg = executor;
        this.zzh = zzdef;
        this.zzi = zzcny;
        this.zzj = zzb2;
        this.zzk = zzbyh;
        this.zzl = zzavc;
        this.zzm = zzdaz;
        this.zzn = zzedp;
        this.zzo = zzflr;
        this.zzp = zzdsm;
        this.zzb = zzdej;
        this.zzq = zzcnb;
        this.zzr = zzdps;
    }

    public static final ListenableFuture zzj(zzcfk zzcfk, String str, String str2, Bundle bundle) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            bundle.putLong(zzdrv.RENDERING_WEBVIEW_LOAD_HTML_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzcao zzcao = new zzcao();
        zzcfk.zzN().zzB(new zzdpd(bundle, zzcao));
        zzcfk.zzae(str, str2, (String) null);
        return zzcao;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcfk zzcfk, zzcfk zzcfk2, Map map) {
        this.zzi.zzh(zzcfk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjI)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final void zzi(zzcfk zzcfk, boolean z, zzbju zzbju, Bundle bundle) {
        zzaux zzc2;
        zzcfk zzcfk2 = zzcfk;
        Bundle bundle2 = bundle;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            bundle2.putLong(zzdrv.RENDERING_CONFIGURE_WEBVIEW_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzchc zzN = zzcfk2.zzN();
        zzdpe zzdpe = new zzdpe(this);
        zzcyg zzcyg = this.zzd;
        zzcys zzcys = this.zze;
        zzdpf zzdpf = new zzdpf(this);
        zzdpg zzdpg = new zzdpg(this);
        zzb zzb2 = this.zzj;
        zzdpl zzdpl = new zzdpl(this);
        zzbyh zzbyh = this.zzk;
        zzedp zzedp = this.zzn;
        zzflr zzflr = this.zzo;
        zzdsm zzdsm = this.zzp;
        zzdsm zzdsm2 = zzdsm;
        zzdej zzdej = this.zzb;
        boolean z2 = z;
        zzbju zzbju2 = zzbju;
        zzN.zzU(zzdpe, zzcyg, zzcys, zzdpf, zzdpg, z2, zzbju2, zzb2, zzdpl, zzbyh, zzedp, zzflr, zzdsm2, (zzbkl) null, zzdej, (zzbkk) null, (zzbke) null, (zzbjs) null, this.zzq);
        zzcfk2.setOnTouchListener(new zzdph(this));
        zzcfk2.setOnClickListener(new zzdpi(this));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcJ)).booleanValue() && (zzc2 = this.zzl.zzc()) != null) {
            zzc2.zzo(zzcfk2.zzF());
        }
        this.zzh.zzo(zzcfk2, this.zzg);
        this.zzh.zzo(new zzdpj(zzcfk2), this.zzg);
        this.zzh.zza(zzcfk2.zzF());
        zzcfk2.zzag("/trackActiveViewUnit", new zzdpk(this, zzcfk2));
        this.zzi.zzi(zzcfk2);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            bundle2.putLong(zzdrv.RENDERING_CONFIGURE_WEBVIEW_END.zza(), zzv.zzC().currentTimeMillis());
        }
    }
}
