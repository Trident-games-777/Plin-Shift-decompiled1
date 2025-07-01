package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdoc {
    /* access modifiers changed from: private */
    public final zzdnp zza = new zzdnp();
    private final zza zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzdsm zzd;
    private final Executor zze;
    private final zzavc zzf;
    private final VersionInfoParcel zzg;
    private final zzbkh zzh = new zzbkh();
    /* access modifiers changed from: private */
    public final zzedp zzi;
    /* access modifiers changed from: private */
    public final zzflr zzj;
    private final zzeea zzk;
    private final zzffs zzl;
    private ListenableFuture zzm;

    zzdoc(zzdnz zzdnz) {
        this.zzc = zzdnz.zzb;
        this.zze = zzdnz.zze;
        this.zzf = zzdnz.zzf;
        this.zzg = zzdnz.zzg;
        this.zzb = zzdnz.zza;
        this.zzi = zzdnz.zzd;
        this.zzj = zzdnz.zzh;
        this.zzd = zzdnz.zzc;
        this.zzk = zzdnz.zzi;
        this.zzl = zzdnz.zzj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcfk zza(zzcfk zzcfk) {
        zzcfk zzcfk2 = zzcfk;
        zzcfk2.zzag("/result", this.zzh);
        zzchc zzN = zzcfk2.zzN();
        zzb zzb2 = new zzb(this.zzc, (zzbyh) null, (zzbux) null);
        zzedp zzedp = this.zzi;
        zzflr zzflr = this.zzj;
        zzdsm zzdsm = this.zzd;
        zzdnp zzdnp = this.zza;
        zzN.zzU((com.google.android.gms.ads.internal.client.zza) null, zzdnp, zzdnp, zzdnp, zzdnp, false, (zzbju) null, zzb2, (zzbsl) null, (zzbyh) null, zzedp, zzflr, zzdsm, (zzbkl) null, (zzdel) null, (zzbkk) null, (zzbke) null, (zzbjs) null, (zzcnb) null);
        return zzcfk2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(String str, JSONObject jSONObject, zzcfk zzcfk) throws Exception {
        return this.zzh.zzb(zzcfk, str, jSONObject);
    }

    public final synchronized ListenableFuture zzg(String str, JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return zzgei.zzh((Object) null);
        }
        return zzgei.zzn(listenableFuture, new zzdnq(this, str, jSONObject), this.zze);
    }

    public final synchronized void zzh(zzfet zzfet, zzfew zzfew, zzcnb zzcnb) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgei.zzr(listenableFuture, new zzdnw(this, zzfet, zzfew, zzcnb), this.zze);
        }
    }

    public final synchronized void zzi() {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgei.zzr(listenableFuture, new zzdns(this), this.zze);
            this.zzm = null;
        }
    }

    public final synchronized void zzj(String str, Map map) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgei.zzr(listenableFuture, new zzdnv(this, "sendMessageToNativeJs", map), this.zze);
        }
    }

    public final synchronized void zzk() {
        zzbce zzbce = zzbcn.zzdP;
        ListenableFuture zzm2 = zzgei.zzm(zzgei.zzk(new zzcfv(this.zzc, this.zzf, this.zzg, this.zzb, this.zzk, this.zzl, (String) zzbe.zzc().zza(zzbce)), zzcaj.zze), new zzdnr(this), this.zze);
        this.zzm = zzm2;
        zzcam.zza(zzm2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbjr zzbjr) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgei.zzr(listenableFuture, new zzdnt(this, str, zzbjr), this.zze);
        }
    }

    public final void zzm(WeakReference weakReference, String str, zzbjr zzbjr) {
        String str2 = str;
        zzl(str2, new zzdoa(this, weakReference, str2, zzbjr, (zzdob) null));
    }

    public final synchronized void zzn(String str, zzbjr zzbjr) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            zzgei.zzr(listenableFuture, new zzdnu(this, str, zzbjr), this.zze);
        }
    }
}
