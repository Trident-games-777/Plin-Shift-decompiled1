package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.zzat;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegc implements zzefb {
    private final zzcqh zza;
    private final Context zzb;
    private final zzdpn zzc;
    private final zzffo zzd;
    private final Executor zze;
    private final zzfwh zzf;
    private final zzdsh zzg;

    public zzegc(zzcqh zzcqh, Context context, Executor executor, zzdpn zzdpn, zzffo zzffo, zzfwh zzfwh, zzdsh zzdsh) {
        this.zzb = context;
        this.zza = zzcqh;
        this.zze = executor;
        this.zzc = zzdpn;
        this.zzd = zzffo;
        this.zzf = zzfwh;
        this.zzg = zzdsh;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        return zzgei.zzn(zzgei.zzh((Object) null), new zzegb(this, zzfff, zzfet), this.zze);
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        zzfey zzfey = zzfet.zzs;
        return (zzfey == null || zzfey.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfff zzfff, zzfet zzfet, Object obj) throws Exception {
        View view;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzg.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzs zza2 = zzffu.zza(this.zzb, zzfet.zzu);
        zzcfk zza3 = this.zzc.zza(zza2, zzfet, zzfff.zzb.zzb);
        zza3.zzac(zzfet.zzW);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhy)).booleanValue() || !zzfet.zzag) {
            view = new zzdpq(this.zzb, zza3.zzF(), (zzat) this.zzf.apply(zzfet));
        } else {
            view = zzcrc.zza(this.zzb, zza3.zzF(), zzfet);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzg.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzcqh zzcqh = this.zza;
        zzcsg zzcsg = new zzcsg(zzfff, zzfet, (String) null);
        Objects.requireNonNull(zza3);
        zzcpe zza4 = zzcqh.zza(zzcsg, new zzcpk(view, zza3, new zzefw(zza3), zzffu.zzb(zza2)));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzg.zza().putLong(zzdrv.RENDERING_AD_COMPONENT_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zza4.zzh().zzi(zza3, false, (zzbju) null, this.zzg.zza());
        zza4.zzc().zzo(new zzefx(zza3), zzcaj.zzf);
        String str = zzfet.zzs.zza;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() && zza4.zzi().zze(true)) {
            str = zzcgv.zzb(str, zzcgv.zza(zzfet));
        }
        zza4.zzh();
        ListenableFuture zzj = zzdpm.zzj(zza3, zzfet.zzs.zzb, str, this.zzg.zza());
        if (zzfet.zzM) {
            Objects.requireNonNull(zza3);
            zzj.addListener(new zzefy(zza3), this.zze);
        }
        zzj.addListener(new zzefz(this, zza3), this.zze);
        return zzgei.zzm(zzj, new zzega(zza4), zzcaj.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcfk zzcfk) {
        zzcfk.zzab();
        zzffo zzffo = this.zzd;
        zzcgm zzq = zzcfk.zzq();
        zzga zzga = zzffo.zza;
        if (!(zzga == null || zzq == null)) {
            zzq.zzs(zzga);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbp)).booleanValue() && !zzcfk.isAttachedToWindow()) {
            zzcfk.onPause();
            zzcfk.zzav(true);
        }
    }
}
