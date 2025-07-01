package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzehv implements zzehp {
    private final zzdhj zza;
    private final zzges zzb;
    private final zzdlr zzc;
    private final zzfgn zzd;
    private final zzdoi zze;
    private final zzdsh zzf;

    public zzehv(zzdhj zzdhj, zzges zzges, zzdlr zzdlr, zzfgn zzfgn, zzdoi zzdoi, zzdsh zzdsh) {
        this.zza = zzdhj;
        this.zzb = zzges;
        this.zzc = zzdlr;
        this.zzd = zzfgn;
        this.zze = zzdoi;
        this.zzf = zzdsh;
    }

    private final ListenableFuture zzg(zzfff zzfff, zzfet zzfet, JSONObject jSONObject) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzf.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_START.zza(), zzv.zzC().currentTimeMillis());
        }
        zzfgn zzfgn = this.zzd;
        zzdlr zzdlr = this.zzc;
        ListenableFuture zza2 = zzfgn.zza();
        ListenableFuture zza3 = zzdlr.zza(zzfff, zzfet, jSONObject);
        return zzgei.zzc(zza2, zza3).zza(new zzehq(this, zza3, zza2, zzfff, zzfet, jSONObject), this.zzb);
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        return zzgei.zzn(zzgei.zzn(this.zzd.zza(), new zzehs(this, zzfet), this.zzb), new zzeht(this, zzfff, zzfet), this.zzb);
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        zzfey zzfey = zzfet.zzs;
        return (zzfey == null || zzfey.zzc == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdit zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfff zzfff, zzfet zzfet, JSONObject jSONObject) throws Exception {
        zzdiy zzdiy = (zzdiy) listenableFuture.get();
        zzdoc zzdoc = (zzdoc) listenableFuture2.get();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzf.zza().putLong(zzdrv.RENDERING_WEBVIEW_CREATION_END.zza(), zzv.zzC().currentTimeMillis());
        }
        zzdiz zzd2 = this.zza.zzd(new zzcsg(zzfff, zzfet, (String) null), new zzdjk(zzdiy), new zzdhw(jSONObject, zzdoc));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            this.zzf.zza().putLong(zzdrv.RENDERING_AD_COMPONENT_CREATION_END.zza(), currentTimeMillis);
            this.zzf.zza().putLong(zzdrv.RENDERING_CONFIGURE_WEBVIEW_START.zza(), currentTimeMillis);
        }
        zzd2.zzh().zzb();
        zzd2.zzi().zza(zzdoc);
        zzd2.zzg().zza(zzdiy.zzs());
        zzd2.zzl().zza(this.zze, zzdiy.zzq());
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
            this.zzf.zza().putLong(zzdrv.RENDERING_CONFIGURE_WEBVIEW_END.zza(), zzv.zzC().currentTimeMillis());
        }
        return zzd2.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzdoc zzdoc, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgei.zzh(zzdoc));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzgei.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbnx("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzfet zzfet, zzdoc zzdoc) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzim)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfet.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgei.zzn(zzdoc.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzehr(this, zzdoc), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfff zzfff, zzfet zzfet, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgei.zzg(new zzdwn(3));
        }
        if (zzfff.zza.zza.zzk <= 1) {
            return zzgei.zzm(zzg(zzfff, zzfet, jSONArray.getJSONObject(0)), new zzehu(), this.zzb);
        }
        int length = jSONArray.length();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcl)).booleanValue()) {
            this.zzf.zzc("nsl", String.valueOf(length));
        }
        this.zzd.zzc(Math.min(length, zzfff.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfff.zza.zza.zzk);
        for (int i = 0; i < zzfff.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzfff, zzfet, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzgei.zzg(new zzdwn(3)));
            }
        }
        return zzgei.zzh(arrayList);
    }
}
