package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzehe implements zzefb {
    private final Context zza;
    private final zzdpn zzb;
    private final zzdgn zzc;
    private final zzffo zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbju zzg;
    private final boolean zzh = ((Boolean) zzbe.zzc().zza(zzbcn.zziy)).booleanValue();
    private final zzeea zzi;
    private final zzdsh zzj;

    public zzehe(Context context, VersionInfoParcel versionInfoParcel, zzffo zzffo, Executor executor, zzdgn zzdgn, zzdpn zzdpn, zzbju zzbju, zzeea zzeea, zzdsh zzdsh) {
        this.zza = context;
        this.zzd = zzffo;
        this.zzc = zzdgn;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpn;
        this.zzg = zzbju;
        this.zzi = zzeea;
        this.zzj = zzdsh;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzdpr zzdpr = new zzdpr();
        ListenableFuture zzn = zzgei.zzn(zzgei.zzh((Object) null), new zzehb(this, zzfet, zzfff, zzdpr), this.zze);
        Objects.requireNonNull(zzdpr);
        zzn.addListener(new zzehc(zzdpr), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        zzfey zzfey = zzfet.zzs;
        return (zzfey == null || zzfey.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfet zzfet, zzfff zzfff, zzdpr zzdpr, Object obj) throws Exception {
        zzfff zzfff2 = zzfff;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzdpn zzdpn = this.zzb;
        zzffo zzffo = this.zzd;
        zzcfk zza2 = zzdpn.zza(zzffo.zze, zzfet, zzfff2.zzb.zzb);
        zza2.zzac(zzfet.zzW);
        zzdpr.zza(this.zza, zza2.zzF());
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzcao zzcao = new zzcao();
        zzbju zzbju = null;
        zzdfk zze2 = this.zzc.zze(new zzcsg(zzfff2, zzfet, (String) null), new zzdfn(new zzehd(this.zza, this.zzf, zzcao, zzfet, zza2, this.zzd, this.zzh, this.zzg, this.zzi), zza2));
        zzcao.zzc(zze2);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzj.zza().putLong(zzdrv.RENDERING_AD_COMPONENT_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zze2.zzc().zzo(new zzegz(zza2), zzcaj.zzf);
        String str = zzfet.zzs.zza;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() && zze2.zzl().zze(true)) {
            str = zzcgv.zzb(str, zzcgv.zza(zzfet));
        }
        zzdpm zzi2 = zze2.zzi();
        if (this.zzh) {
            zzbju = this.zzg;
        }
        zzi2.zzi(zza2, true, zzbju, this.zzj.zza());
        zze2.zzi();
        return zzgei.zzm(zzdpm.zzj(zza2, zzfet.zzs.zzb, str, this.zzj.zza()), new zzeha(this, zza2, zzfet, zze2), this.zze);
    }
}
