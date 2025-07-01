package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzefm implements zzefb {
    private final zzcor zza;
    private final Context zzb;
    private final zzdpn zzc;
    private final zzffo zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbju zzg;
    private final boolean zzh = ((Boolean) zzbe.zzc().zza(zzbcn.zziy)).booleanValue();
    private final zzeea zzi;
    private final zzdsh zzj;

    public zzefm(zzcor zzcor, Context context, Executor executor, zzdpn zzdpn, zzffo zzffo, VersionInfoParcel versionInfoParcel, zzbju zzbju, zzeea zzeea, zzdsh zzdsh) {
        this.zzb = context;
        this.zza = zzcor;
        this.zze = executor;
        this.zzc = zzdpn;
        this.zzd = zzffo;
        this.zzf = versionInfoParcel;
        this.zzg = zzbju;
        this.zzi = zzeea;
        this.zzj = zzdsh;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzdpr zzdpr = new zzdpr();
        ListenableFuture zzn = zzgei.zzn(zzgei.zzh((Object) null), new zzefi(this, zzfet, zzfff, zzdpr), this.zze);
        Objects.requireNonNull(zzdpr);
        zzn.addListener(new zzefj(zzdpr), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        zzfey zzfey = zzfet.zzs;
        return (zzfey == null || zzfey.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfet zzfet, zzfff zzfff, zzdpr zzdpr, Object obj) throws Exception {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzdpn zzdpn = this.zzc;
        zzffo zzffo = this.zzd;
        zzcfk zza2 = zzdpn.zza(zzffo.zze, zzfet, zzfff.zzb.zzb);
        zza2.zzac(zzfet.zzW);
        zzdpr.zza(this.zzb, zza2.zzF());
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzcao zzcao = new zzcao();
        zzbju zzbju = null;
        zzfet zzfet2 = zzfet;
        zzcoo zza3 = this.zza.zza(new zzcsg(zzfff, zzfet, (String) null), new zzdfn(new zzefo(this.zzf, zzcao, zzfet2, zza2, this.zzd, this.zzh, this.zzg, this.zzi), zza2), new zzcop(zzfet2.zzaa));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_AD_COMPONENT_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzdpm zzh2 = zza3.zzh();
        if (this.zzh) {
            zzbju = this.zzg;
        }
        zzh2.zzi(zza2, false, zzbju, this.zzj.zza());
        zzcao.zzc(zza3);
        zza3.zzc().zzo(new zzefk(zza2), zzcaj.zzf);
        String str = zzfet2.zzs.zza;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() && zza3.zzi().zze(true)) {
            str = zzcgv.zzb(str, zzcgv.zza(zzfet2));
        }
        zza3.zzh();
        return zzgei.zzm(zzdpm.zzj(zza2, zzfet2.zzs.zzb, str, this.zzj.zza()), new zzefl(this, zza2, zzfet2, zza3), this.zze);
    }
}
