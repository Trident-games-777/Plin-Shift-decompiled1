package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdmy {
    private final zzffo zza;
    private final Executor zzb;
    private final zzdpn zzc;
    private final zzdoi zzd;
    private final Context zze;
    private final zzdsm zzf;
    private final zzflr zzg;
    private final zzedp zzh;

    public zzdmy(zzffo zzffo, Executor executor, zzdpn zzdpn, Context context, zzdsm zzdsm, zzflr zzflr, zzedp zzedp, zzdoi zzdoi) {
        this.zza = zzffo;
        this.zzb = executor;
        this.zzc = zzdpn;
        this.zze = context;
        this.zzf = zzdsm;
        this.zzg = zzflr;
        this.zzh = zzedp;
        this.zzd = zzdoi;
    }

    private final void zzh(zzcfk zzcfk) {
        zzj(zzcfk);
        zzcfk.zzag("/video", zzbjq.zzl);
        zzcfk.zzag("/videoMeta", zzbjq.zzm);
        zzcfk.zzag("/precache", new zzcds());
        zzcfk.zzag("/delayPageLoaded", zzbjq.zzp);
        zzcfk.zzag("/instrument", zzbjq.zzn);
        zzcfk.zzag("/log", zzbjq.zzg);
        zzcfk.zzag("/click", new zzbip((zzdel) null, (zzcnb) null));
        if (this.zza.zzb != null) {
            zzcfk.zzN().zzF(true);
            zzcfk.zzag("/open", new zzbkd((zzb) null, (zzbse) null, (zzedp) null, (zzdsm) null, (zzcnb) null));
        } else {
            zzcfk.zzN().zzF(false);
        }
        if (zzv.zzo().zzp(zzcfk.getContext())) {
            Map hashMap = new HashMap();
            if (zzcfk.zzD() != null) {
                hashMap = zzcfk.zzD().zzaw;
            }
            zzcfk.zzag("/logScionEvent", new zzbjx(zzcfk.getContext(), hashMap));
        }
    }

    private final void zzi(zzcfk zzcfk, zzcan zzcan) {
        if (!(this.zza.zza == null || zzcfk.zzq() == null)) {
            zzcfk.zzq().zzs(this.zza.zza);
        }
        zzcan.zzb();
    }

    private static final void zzj(zzcfk zzcfk) {
        zzcfk.zzag("/videoClicked", zzbjq.zzh);
        zzcfk.zzN().zzH(true);
        zzcfk.zzag("/getNativeAdViewSignals", zzbjq.zzs);
        zzcfk.zzag("/getNativeClickMeta", zzbjq.zzt);
    }

    public final ListenableFuture zza(JSONObject jSONObject) {
        return zzgei.zzn(zzgei.zzn(zzgei.zzh((Object) null), new zzdmp(this), this.zzb), new zzdmo(this, jSONObject), this.zzb);
    }

    public final ListenableFuture zzb(String str, String str2, zzfet zzfet, zzfew zzfew, zzs zzs) {
        return zzgei.zzn(zzgei.zzh((Object) null), new zzdmn(this, zzs, zzfet, zzfew, str, str2), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, zzcfk zzcfk) throws Exception {
        zzbmb zzbmb = this.zza.zzb;
        zzcan zza2 = zzcan.zza(zzcfk);
        if (zzbmb != null) {
            zzcfk.zzaj(zzche.zzd());
        } else {
            zzcfk.zzaj(zzche.zze());
        }
        zzcfk.zzN().zzB(new zzdmq(this, zzcfk, zza2));
        zzcfk.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzs zzs, zzfet zzfet, zzfew zzfew, String str, String str2, Object obj) throws Exception {
        zzcfk zza2 = this.zzc.zza(zzs, zzfet, zzfew);
        zzcan zza3 = zzcan.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzaj(zzche.zzd());
        } else {
            zzdof zzb2 = this.zzd.zzb();
            zzchc zzN = zza2.zzN();
            zzb zzb3 = new zzb(this.zze, (zzbyh) null, (zzbux) null);
            zzedp zzedp = this.zzh;
            zzedp zzedp2 = zzedp;
            zzN.zzU(zzb2, zzb2, zzb2, zzb2, zzb2, false, (zzbju) null, zzb3, (zzbsl) null, (zzbyh) null, zzedp2, this.zzg, this.zzf, (zzbkl) null, zzb2, (zzbkk) null, (zzbke) null, (zzbjs) null, (zzcnb) null);
            zzj(zza2);
        }
        zza2.zzN().zzB(new zzdmr(this, zza2, zza3));
        zza2.zzae(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzcfk zza2 = this.zzc.zza(zzs.zzc(), (zzfet) null, (zzfew) null);
        zzcan zza3 = zzcan.zza(zza2);
        zzh(zza2);
        zza2.zzN().zzI(new zzdms(zza3));
        zza2.loadUrl((String) zzbe.zzc().zza(zzbcn.zzdQ));
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcfk zzcfk, zzcan zzcan, boolean z, int i, String str, String str2) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzdY)).booleanValue()) {
            zzi(zzcfk, zzcan);
        } else if (z) {
            zzi(zzcfk, zzcan);
        } else {
            zzcan.zzd(new zzeiz(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcfk zzcfk, zzcan zzcan, boolean z, int i, String str, String str2) {
        if (z) {
            if (!(this.zza.zza == null || zzcfk.zzq() == null)) {
                zzcfk.zzq().zzs(this.zza.zza);
            }
            zzcan.zzb();
            return;
        }
        zzcan.zzd(new zzeiz(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
