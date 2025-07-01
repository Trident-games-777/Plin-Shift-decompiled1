package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzez;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdmg {
    private final Context zza;
    private final zzdlk zzb;
    private final zzavc zzc;
    private final VersionInfoParcel zzd;
    private final zza zze;
    private final zzbbl zzf;
    private final Executor zzg;
    private final zzbfn zzh;
    private final zzdmy zzi;
    private final zzdpn zzj;
    private final ScheduledExecutorService zzk;
    private final zzdoi zzl;
    private final zzdsm zzm;
    private final zzflr zzn;
    private final zzedp zzo;
    private final zzeea zzp;
    private final zzffs zzq;

    public zzdmg(Context context, zzdlk zzdlk, zzavc zzavc, VersionInfoParcel versionInfoParcel, zza zza2, zzbbl zzbbl, Executor executor, zzffo zzffo, zzdmy zzdmy, zzdpn zzdpn, ScheduledExecutorService scheduledExecutorService, zzdsm zzdsm, zzflr zzflr, zzedp zzedp, zzdoi zzdoi, zzeea zzeea, zzffs zzffs) {
        this.zza = context;
        this.zzb = zzdlk;
        this.zzc = zzavc;
        this.zzd = versionInfoParcel;
        this.zze = zza2;
        this.zzf = zzbbl;
        this.zzg = executor;
        this.zzh = zzffo.zzi;
        this.zzi = zzdmy;
        this.zzj = zzdpn;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdsm;
        this.zzn = zzflr;
        this.zzo = zzedp;
        this.zzl = zzdoi;
        this.zzp = zzeea;
        this.zzq = zzffs;
    }

    public static final zzez zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzfzo.zzn();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfzo.zzn();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzez zzr = zzr(optJSONArray.optJSONObject(i));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfzo.zzl(arrayList);
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, Object obj) {
        return zzgei.zzf(listenableFuture, Exception.class, new zzdmc((Object) null), zzcaj.zzf);
    }

    private static ListenableFuture zzm(boolean z, ListenableFuture listenableFuture, Object obj) {
        if (z) {
            return zzgei.zzn(listenableFuture, new zzdmd(listenableFuture), zzcaj.zzf);
        }
        return zzl(listenableFuture, (Object) null);
    }

    private final ListenableFuture zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzgei.zzh((Object) null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzgei.zzh((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzgei.zzh(new zzbfl((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        int i = optInt2;
        return zzm(jSONObject.optBoolean("require"), zzgei.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzdlu(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final ListenableFuture zzo(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgei.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z));
        }
        return zzgei.zzm(zzgei.zzd(arrayList), new zzdlz(), this.zzg);
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzfet zzfet, zzfew zzfew) {
        ListenableFuture zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfet, zzfew, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgei.zzn(zzb2, new zzdlv(zzb2), zzcaj.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final zzez zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzez(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbfi zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzq2 = zzq(jSONObject, "bg_color");
        Integer zzq3 = zzq(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        int i = optInt2;
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzbfi(optString, list, zzq2, zzq3, num, optInt3 + i, this.zzh.zze, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzs zzs, zzfet zzfet, zzfew zzfew, String str, String str2, Object obj) throws Exception {
        zzcfk zza2 = this.zzj.zza(zzs, zzfet, zzfew);
        zzcan zza3 = zzcan.zza(zza2);
        zzdof zzb2 = this.zzl.zzb();
        zzchc zzN = zza2.zzN();
        zzb zzb3 = new zzb(this.zza, (zzbyh) null, (zzbux) null);
        zzedp zzedp = this.zzo;
        zzflr zzflr = this.zzn;
        zzflr zzflr2 = zzflr;
        zzN.zzU(zzb2, zzb2, zzb2, zzb2, zzb2, false, (zzbju) null, zzb3, (zzbsl) null, (zzbyh) null, zzedp, zzflr2, this.zzm, (zzbkl) null, zzb2, (zzbkk) null, (zzbke) null, (zzbjs) null, (zzcnb) null);
        zza2.zzag("/getNativeAdViewSignals", zzbjq.zzs);
        zza2.zzag("/getNativeClickMeta", zzbjq.zzt);
        zza2.zzN().zzE(true);
        zza2.zzN().zzB(new zzdly(zza3));
        zza2.zzae(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(String str, Object obj) throws Exception {
        zzv.zzA();
        zzcfk zza2 = zzcfx.zza(this.zza, zzche.zza(), "native-omid", false, false, this.zzc, (zzbdu) null, this.zzd, (zzbdc) null, (zzn) null, this.zze, this.zzf, (zzfet) null, (zzfew) null, this.zzp, this.zzq);
        zzcan zza3 = zzcan.zza(zza2);
        zza2.zzN().zzB(new zzdma(zza3));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfh)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
            return zza3;
        }
        zza2.loadData(str, "text/html", "UTF-8");
        return zza3;
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzgei.zzh((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzgei.zzm(zzo(optJSONArray, false, true), new zzdmb(this, optJSONObject), this.zzg), (Object) null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str) {
        zzbfn zzbfn = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbfn.zzb, zzbfn.zzd);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, zzfet zzfet, zzfew zzfew) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjH)).booleanValue()) {
            return zzgei.zzh((Object) null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzgei.zzh((Object) null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzgei.zzh((Object) null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzs zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzgei.zzh((Object) null);
        }
        ListenableFuture zzn2 = zzgei.zzn(zzgei.zzh((Object) null), new zzdlw(this, zzk2, zzfet, zzfew, optString, optString2), zzcaj.zze);
        return zzgei.zzn(zzn2, new zzdlx(zzn2), zzcaj.zzf);
    }

    public final ListenableFuture zzh(JSONObject jSONObject, zzfet zzfet, zzfew zzfew) {
        ListenableFuture listenableFuture;
        boolean z = false;
        JSONObject zzh2 = zzbr.zzh(jSONObject, "html_containers", "instream");
        if (zzh2 != null) {
            return zzp(zzh2, zzfet, zzfew);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzgei.zzh((Object) null);
        }
        String optString = optJSONObject.optString("vast_xml");
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjG)).booleanValue() && optJSONObject.has("html")) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                zzm.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzgei.zzh((Object) null);
            }
        } else if (!z) {
            listenableFuture = this.zzi.zza(optJSONObject);
            return zzl(zzgei.zzo(listenableFuture, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzdR)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        listenableFuture = zzp(optJSONObject, zzfet, zzfew);
        return zzl(zzgei.zzo(listenableFuture, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzdR)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }

    private final zzs zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return zzs.zzc();
            }
            i = 0;
        }
        return new zzs(this.zza, new AdSize(i, i2));
    }
}
