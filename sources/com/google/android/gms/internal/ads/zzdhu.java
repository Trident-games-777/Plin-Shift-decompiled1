package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdhu implements zzdjg {
    private long zzA = 0;
    private long zzB = 0;
    private zzdd zzC;
    private final Context zza;
    private final zzdjj zzb;
    private final JSONObject zzc;
    private final zzdoc zzd;
    private final zzdiy zze;
    private final zzavc zzf;
    /* access modifiers changed from: private */
    public final zzcxe zzg;
    /* access modifiers changed from: private */
    public final zzcwk zzh;
    /* access modifiers changed from: private */
    public final zzdej zzi;
    private final zzfet zzj;
    private final VersionInfoParcel zzk;
    private final zzffo zzl;
    private final zzcny zzm;
    private final zzdkc zzn;
    private final Clock zzo;
    private final zzdef zzp;
    private final zzflr zzq;
    private final zzdps zzr;
    private final zzfkl zzs;
    private final zzeea zzt;
    private boolean zzu = false;
    private boolean zzv;
    private boolean zzw = false;
    private boolean zzx = false;
    private Point zzy = new Point();
    private Point zzz = new Point();

    public zzdhu(Context context, zzdjj zzdjj, JSONObject jSONObject, zzdoc zzdoc, zzdiy zzdiy, zzavc zzavc, zzcxe zzcxe, zzcwk zzcwk, zzdej zzdej, zzfet zzfet, VersionInfoParcel versionInfoParcel, zzffo zzffo, zzcny zzcny, zzdkc zzdkc, Clock clock, zzdef zzdef, zzflr zzflr, zzfkl zzfkl, zzeea zzeea, zzdps zzdps) {
        this.zza = context;
        this.zzb = zzdjj;
        this.zzc = jSONObject;
        this.zzd = zzdoc;
        this.zze = zzdiy;
        this.zzf = zzavc;
        this.zzg = zzcxe;
        this.zzh = zzcwk;
        this.zzi = zzdej;
        this.zzj = zzfet;
        this.zzk = versionInfoParcel;
        this.zzl = zzffo;
        this.zzm = zzcny;
        this.zzn = zzdkc;
        this.zzo = clock;
        this.zzp = zzdef;
        this.zzq = zzflr;
        this.zzs = zzfkl;
        this.zzt = zzeea;
        this.zzr = zzdps;
    }

    private final String zzD(View view) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzdD)).booleanValue()) {
            return null;
        }
        try {
            return this.zzf.zzc().zzh(this.zza, view, (Activity) null);
        } catch (Exception unused) {
            zzm.zzg("Exception getting data.");
            return null;
        }
    }

    private final String zzE(View view, Map map) {
        if (!(map == null || view == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int zzc2 = this.zze.zzc();
        if (zzc2 == 1) {
            return "1099";
        }
        if (zzc2 == 2) {
            return "2099";
        }
        if (zzc2 != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzF(String str) {
        JSONObject optJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    private final boolean zzG() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean zzH(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdD)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            zzv.zzq();
            DisplayMetrics zzt2 = zzs.zzt((WindowManager) context.getSystemService("window"));
            try {
                jSONObject7.put("width", zzbc.zzb().zzb(context, zzt2.widthPixels));
                jSONObject7.put("height", zzbc.zzb().zzb(context, zzt2.heightPixels));
            } catch (JSONException unused) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", jSONObject7);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzij)).booleanValue()) {
                this.zzd.zzl("/clickRecorded", new zzdhr(this, (zzdht) null));
            } else {
                this.zzd.zzl("/logScionEvent", new zzdhq(this, (zzdht) null));
            }
            this.zzd.zzl("/nativeImpression", new zzdhs(this, (zzdht) null));
            zzcam.zza(this.zzd.zzg("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzu) {
                return true;
            }
            zzfet zzfet = this.zzj;
            this.zzu = zzv.zzt().zzn(this.zza, this.zzk.afmaVersion, zzfet.zzC.toString(), this.zzl.zzf);
            return true;
        } catch (JSONException e) {
            zzm.zzh("Unable to create impression JSON.", e);
            return false;
        }
    }

    public final boolean zzA() {
        if (zza() == 0) {
            return true;
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlh)).booleanValue()) {
            return true;
        }
        return this.zzl.zzi.zzj;
    }

    public final boolean zzB() {
        return zzG();
    }

    public final boolean zzC(Bundle bundle) {
        if (!zzF("impression_reporting")) {
            zzm.zzg("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        String str = null;
        JSONObject zzk2 = zzbc.zzb().zzk(bundle, (JSONObject) null);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzld)).booleanValue()) {
            str = zzD((View) null);
        }
        return zzH((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, zzk2, false);
    }

    public final int zza() {
        if (this.zzl.zzi == null) {
            return 0;
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlh)).booleanValue()) {
            return 0;
        }
        return this.zzl.zzi.zzi;
    }

    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject zzd2 = zzbu.zzd(context, map, map2, view, scaleType);
        JSONObject zzg2 = zzbu.zzg(context, view);
        JSONObject zzf2 = zzbu.zzf(view);
        JSONObject zze2 = zzbu.zze(context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zzd2);
            jSONObject.put("ad_view_signal", zzg2);
            jSONObject.put("scroll_view_signal", zzf2);
            jSONObject.put("lock_screen_signal", zze2);
            return jSONObject;
        } catch (JSONException e) {
            zzm.zzh("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        JSONObject zze2 = zze(view, map, map2, scaleType);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzx && zzG()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (zze2 != null) {
                jSONObject.put("nas", zze2);
                return jSONObject;
            }
        } catch (JSONException e) {
            zzm.zzh("Unable to create native click meta data JSON.", e);
        }
        return jSONObject;
    }

    public final void zzg() {
        try {
            zzdd zzdd = this.zzC;
            if (zzdd != null) {
                zzdd.zze();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzh() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzb();
        }
    }

    public final void zzi() {
        this.zzd.zzi();
    }

    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject zzd2 = zzbu.zzd(context, map, map2, view2, scaleType);
        JSONObject zzg2 = zzbu.zzg(context, view2);
        JSONObject jSONObject = zzd2;
        JSONObject zzf2 = zzbu.zzf(view2);
        JSONObject jSONObject2 = zzg2;
        JSONObject zze2 = zzbu.zze(context, view2);
        String zzE = zzE(view, map);
        JSONObject zzc2 = zzbu.zzc(zzE, context, this.zzz, this.zzy);
        JSONObject jSONObject3 = jSONObject;
        String str = zzE;
        zzn(true == ((Boolean) zzbe.zzc().zza(zzbcn.zzdK)).booleanValue() ? view2 : view, jSONObject2, jSONObject3, zzf2, zze2, str, zzc2, (JSONObject) null, z, false);
    }

    public final void zzl(String str) {
        zzn((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzm(Bundle bundle) {
        if (bundle == null) {
            zzm.zze("Click data is null. No click is reported.");
        } else if (!zzF("click_reporting")) {
            zzm.zzg("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zzn((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzbc.zzb().zzk(bundle, (JSONObject) null), false, false);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        String str2;
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzc);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzb.zzc(this.zze.zzA()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zze.zzc());
            jSONObject8.put("view_aware_api_used", z);
            zzbfn zzbfn = this.zzl.zzi;
            jSONObject8.put("custom_mute_requested", zzbfn != null && zzbfn.zzg);
            jSONObject8.put("custom_mute_enabled", !this.zze.zzH().isEmpty() && this.zze.zzk() != null);
            if (this.zzn.zza() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzo.currentTimeMillis());
            if (this.zzx && zzG()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzb.zzc(this.zze.zzA()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            String str3 = null;
            try {
                JSONObject optJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                str2 = this.zzf.zzc().zzd(this.zza, optJSONObject.optString("click_string"), view);
            } catch (Exception e) {
                zzm.zzh("Exception obtaining click signals", e);
                str2 = null;
            }
            jSONObject8.put("click_signals", str2);
            jSONObject8.put("open_chrome_custom_tab", true);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzin)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzio)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzo.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzA);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzB);
            jSONObject7.put("touch_signal", jSONObject9);
            if (this.zzj.zzai) {
                JSONObject jSONObject10 = (JSONObject) this.zzc.get("tracking_urls_and_actions");
                if (jSONObject10 != null) {
                    str3 = jSONObject10.getString("gws_query_id");
                }
                if (str3 != null) {
                    this.zzt.zzq(str3, this.zze);
                }
            }
            zzcam.zza(this.zzd.zzg("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzm.zzh("Unable to create click JSON.", e2);
        }
    }

    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        JSONObject jSONObject;
        View view3 = view2;
        Map map3 = map;
        boolean z2 = false;
        if (this.zzc.optBoolean("allow_sdk_custom_click_gesture", false)) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzlh)).booleanValue()) {
                z2 = true;
            }
        }
        if (!z2) {
            if (!this.zzx) {
                zzm.zze("Custom click reporting failed. enableCustomClickGesture is not set.");
                return;
            } else if (!zzG()) {
                zzm.zze("Custom click reporting failed. Ad unit id not in the allow list.");
                return;
            }
        }
        JSONObject zzd2 = zzbu.zzd(this.zza, map3, map2, view3, scaleType);
        JSONObject zzg2 = zzbu.zzg(this.zza, view3);
        boolean z3 = z2;
        JSONObject zzf2 = zzbu.zzf(view3);
        JSONObject zze2 = zzbu.zze(this.zza, view3);
        String zzE = zzE(view, map3);
        JSONObject zzc2 = zzbu.zzc(zzE, this.zza, this.zzz, this.zzy);
        if (z3) {
            try {
                JSONObject jSONObject2 = this.zzc;
                Point point = this.zzz;
                Point point2 = this.zzy;
                try {
                    jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        if (point != null) {
                            jSONObject3.put("x", point.x);
                            jSONObject3.put("y", point.y);
                        }
                        if (point2 != null) {
                            jSONObject4.put("x", point2.x);
                            jSONObject4.put("y", point2.y);
                        }
                        jSONObject.put("start_point", jSONObject3);
                        jSONObject.put("end_point", jSONObject4);
                        jSONObject.put("duration_ms", i);
                    } catch (Exception e) {
                        e = e;
                        zzm.zzh("Error occurred while grabbing custom click gesture signals.", e);
                        jSONObject2.put("custom_click_gesture_signal", jSONObject);
                        zzn(view2, zzg2, zzd2, zzf2, zze2, zzE, zzc2, (JSONObject) null, z, true);
                    }
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                    zzm.zzh("Error occurred while grabbing custom click gesture signals.", e);
                    jSONObject2.put("custom_click_gesture_signal", jSONObject);
                    zzn(view2, zzg2, zzd2, zzf2, zze2, zzE, zzc2, (JSONObject) null, z, true);
                }
                jSONObject2.put("custom_click_gesture_signal", jSONObject);
            } catch (JSONException e3) {
                zzm.zzh("Error occurred while adding CustomClickGestureSignals to adJson.", e3);
                zzv.zzp().zzw(e3, "FirstPartyNativeAdCore.performCustomClickGesture");
            }
        }
        zzn(view2, zzg2, zzd2, zzf2, zze2, zzE, zzc2, (JSONObject) null, z, true);
    }

    public final void zzp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzcam.zza(this.zzd.zzg("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzm.zzh("", e);
        }
    }

    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        zzH(zzbu.zzg(context, view), zzbu.zzd(context, map, map2, view, scaleType), zzbu.zzf(view), zzbu.zze(context, view), zzD(view), (JSONObject) null, zzbu.zzh(context, this.zzj));
    }

    public final void zzr() {
        zzH((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzs(View view, MotionEvent motionEvent, View view2) {
        this.zzy = zzbu.zza(motionEvent, view2);
        long currentTimeMillis = this.zzo.currentTimeMillis();
        this.zzB = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
            this.zzA = currentTimeMillis;
            this.zzz = this.zzy;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation((float) this.zzy.x, (float) this.zzy.y);
        this.zzf.zzd(obtain);
        obtain.recycle();
    }

    public final void zzt(Bundle bundle) {
        if (bundle == null) {
            zzm.zze("Touch event data is null. No touch event is reported.");
        } else if (!zzF("touch_reporting")) {
            zzm.zzg("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzf.zzc().zzl((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    public final void zzu(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzm.zzj("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdkc zzdkc = this.zzn;
        if (view != null) {
            view.setOnClickListener(zzdkc);
            view.setClickable(true);
            zzdkc.zzc = new WeakReference(view);
        }
    }

    public final void zzv() {
        this.zzx = true;
    }

    public final void zzw(zzdd zzdd) {
        this.zzC = zzdd;
    }

    public final void zzx(zzbhs zzbhs) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzm.zzj("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzn.zzc(zzbhs);
        }
    }

    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (!this.zzv) {
            this.zzp.zza(view);
            this.zzv = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzi(this);
        boolean zzi2 = zzbu.zzi(this.zzk.clientJarVersion);
        if (map != null) {
            for (Map.Entry value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzi2) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzi2) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zzz(View view, Map map) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzv = false;
    }

    public final void zzj(zzdh zzdh) {
        try {
            if (!this.zzw) {
                if (zzdh == null) {
                    zzdiy zzdiy = this.zze;
                    if (zzdiy.zzk() != null) {
                        this.zzw = true;
                        this.zzq.zzc(zzdiy.zzk().zzf(), this.zzs);
                        zzg();
                        return;
                    }
                }
                this.zzw = true;
                this.zzq.zzc(zzdh.zzf(), this.zzs);
                zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
