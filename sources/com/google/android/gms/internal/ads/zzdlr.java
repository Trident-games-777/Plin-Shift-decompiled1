package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Optional;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdlr {
    private final zzges zza;
    private final zzdmg zzb;
    private final zzdml zzc;

    public zzdlr(zzges zzges, zzdmg zzdmg, zzdml zzdml) {
        this.zza = zzges;
        this.zzb = zzdmg;
        this.zzc = zzdml;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet, JSONObject jSONObject) {
        zzcao zzcao;
        ListenableFuture zzn;
        zzfet zzfet2 = zzfet;
        JSONObject jSONObject2 = jSONObject;
        ListenableFuture zzb2 = this.zza.zzb(new zzdlm(this, zzfff, zzfet2, jSONObject2));
        ListenableFuture zzf = this.zzb.zzf(jSONObject2, "images");
        zzfew zzfew = zzfff.zzb.zzb;
        zzdmg zzdmg = this.zzb;
        ListenableFuture zzg = zzdmg.zzg(jSONObject2, "images", zzfet2, zzfew);
        ListenableFuture zze = zzdmg.zze(jSONObject2, "secondary_image");
        ListenableFuture zze2 = zzdmg.zze(jSONObject2, "app_icon");
        ListenableFuture zzd = zzdmg.zzd(jSONObject2, "attribution");
        ListenableFuture zzh = this.zzb.zzh(jSONObject2, zzfet2, zzfff.zzb.zzb);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzmF)).booleanValue() || ((Integer) Optional.ofNullable(jSONObject2.optJSONObject("video")).map(new zzdln()).map(new zzdlo()).map(new zzdlp()).orElse(0)).intValue() != 3) {
            zzcao = zzgei.zzh(new Bundle());
        } else {
            zzdmg zzdmg2 = this.zzb;
            zzcao zzcao2 = new zzcao();
            zzgei.zzr(zzh, new zzdmf(zzdmg2, zzcao2), zzcaj.zze);
            zzcao = zzcao2;
        }
        ListenableFuture listenableFuture = zzcao;
        ListenableFuture zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        zzdmg zzdmg3 = this.zzb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzn = zzgei.zzh((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzn = zzgei.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzn = zzgei.zzh((Object) null);
                } else {
                    zzn = zzgei.zzn(zzgei.zzh((Object) null), new zzdlt(zzdmg3, optString), zzcaj.zze);
                }
            }
        }
        ListenableFuture listenableFuture2 = zzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb2);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(listenableFuture);
        arrayList.add(zza2);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfk)).booleanValue()) {
            arrayList.add(listenableFuture2);
        }
        return zzgei.zza(arrayList).zza(new zzdlq(this, zzb2, zzf, zze2, zze, zzd, jSONObject2, zzh, listenableFuture, zzg, listenableFuture2, zza2), this.zza);
    }
}
