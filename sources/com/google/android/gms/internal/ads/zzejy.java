package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzejy implements zzefb {
    private final Context zza;
    private final zzdpn zzb;
    private final zzdow zzc;
    private final zzffo zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbju zzg;
    private final boolean zzh = ((Boolean) zzbe.zzc().zza(zzbcn.zziy)).booleanValue();
    private final zzeea zzi;
    private final zzdsh zzj;

    public zzejy(Context context, VersionInfoParcel versionInfoParcel, zzffo zzffo, Executor executor, zzdow zzdow, zzdpn zzdpn, zzbju zzbju, zzeea zzeea, zzdsh zzdsh) {
        this.zza = context;
        this.zzd = zzffo;
        this.zzc = zzdow;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpn;
        this.zzg = zzbju;
        this.zzi = zzeea;
        this.zzj = zzdsh;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzdpr zzdpr = new zzdpr();
        ListenableFuture zzn = zzgei.zzn(zzgei.zzh((Object) null), new zzejr(this, zzfet, zzfff, zzdpr), this.zze);
        Objects.requireNonNull(zzdpr);
        zzn.addListener(new zzejs(zzdpr), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        zzfey zzfey = zzfet.zzs;
        return (zzfey == null || zzfey.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfet zzfet, zzfff zzfff, zzdpr zzdpr, Object obj) throws Exception {
        zzfet zzfet2 = zzfet;
        zzfff zzfff2 = zzfff;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzcfk zza2 = this.zzb.zza(this.zzd.zze, zzfet2, zzfff2.zzb.zzb);
        zza2.zzac(zzfet2.zzW);
        zzdpr.zza(this.zza, zza2.zzF());
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzcao zzcao = new zzcao();
        zzdos zze2 = this.zzc.zze(new zzcsg(zzfff2, zzfet2, (String) null), new zzdot(new zzejx(this.zza, this.zzb, this.zzd, this.zzf, zzfet2, zzcao, zza2, this.zzg, this.zzh, this.zzi, this.zzj), zza2));
        zzcao.zzc(zze2);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_AD_COMPONENT_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzbkj.zzb(zza2, zze2.zzg());
        zze2.zzc().zzo(new zzejt(zza2), zzcaj.zzf);
        zze2.zzl().zzi(zza2, true, this.zzh ? this.zzg : null, this.zzj.zza());
        String str = zzfet2.zzs.zza;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() && zze2.zzm().zze(true)) {
            str = zzcgv.zzb(str, zzcgv.zza(zzfet2));
        }
        zze2.zzl();
        return zzgei.zzm(zzdpm.zzj(zza2, zzfet2.zzs.zzb, str, this.zzj.zza()), new zzeju(this, zza2, zzfet2, zze2), this.zze);
    }
}
