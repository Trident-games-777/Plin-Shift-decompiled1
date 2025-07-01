package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzavd;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzdsh;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzffs;
import com.google.android.gms.internal.ads.zzfkl;
import com.google.android.gms.internal.ads.zzflr;
import com.google.android.gms.internal.ads.zzges;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;
    private final zzavc zzc;
    private final zzffs zzd;
    private final int zze;
    private final zzdsr zzf;
    private final boolean zzg;
    /* access modifiers changed from: private */
    public final zzges zzh = zzcaj.zze;
    private final zzflr zzi;
    private final zzj zzj;
    /* access modifiers changed from: private */
    public final zza zzk;
    /* access modifiers changed from: private */
    public final zze zzl;

    TaggingLibraryJsInterface(WebView webView, zzavc zzavc, zzdsr zzdsr, zzflr zzflr, zzffs zzffs, zzj zzj2, zza zza2, zze zze2) {
        this.zzb = webView;
        Context context = webView.getContext();
        this.zza = context;
        this.zzc = zzavc;
        this.zzf = zzdsr;
        zzbcn.zza(context);
        this.zze = ((Integer) zzbe.zzc().zza(zzbcn.zzjh)).intValue();
        this.zzg = ((Boolean) zzbe.zzc().zza(zzbcn.zzji)).booleanValue();
        this.zzi = zzflr;
        this.zzd = zzffs;
        this.zzj = zzj2;
        this.zzk = zza2;
        this.zzl = zze2;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        try {
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            String zzd2 = this.zzc.zzc().zzd(this.zza, str, this.zzb);
            if (this.zzg) {
                long currentTimeMillis2 = zzv.zzC().currentTimeMillis() - currentTimeMillis;
                zzv.zzd(this.zzf, (zzdsh) null, "csg", new Pair("clat", String.valueOf(currentTimeMillis2)));
            }
            return zzd2;
        } catch (RuntimeException e) {
            zzm.zzh("Exception getting click signals. ", e);
            zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getClickSignalsWithTimeout(String str, int i) {
        if (i <= 0) {
            zzm.zzg("Invalid timeout for getting click signals. Timeout=" + i);
            return "";
        }
        int min = Math.min(i, this.zze);
        try {
            return (String) zzcaj.zza.zzb(new zzbg(this, str)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzh("Exception getting click signals with timeout. ", e);
            zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        zzv.zzq();
        String uuid = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        zzbk zzbk = new zzbk(this, uuid);
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            this.zzj.zzg(this.zzb, zzbk);
            return uuid;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjk)).booleanValue()) {
            this.zzh.execute(new zzbh(this, bundle, zzbk));
            return uuid;
        }
        QueryInfo.generate(this.zza, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), zzbk);
        return uuid;
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            String zzh2 = this.zzc.zzc().zzh(this.zza, this.zzb, (Activity) null);
            if (this.zzg) {
                long currentTimeMillis2 = zzv.zzC().currentTimeMillis() - currentTimeMillis;
                zzv.zzd(this.zzf, (zzdsh) null, "vsg", new Pair("vlat", String.valueOf(currentTimeMillis2)));
            }
            return zzh2;
        } catch (RuntimeException e) {
            zzm.zzh("Exception getting view signals. ", e);
            zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getViewSignalsWithTimeout(int i) {
        if (i <= 0) {
            zzm.zzg("Invalid timeout for getting view signals. Timeout=" + i);
            return "";
        }
        int min = Math.min(i, this.zze);
        try {
            return (String) zzcaj.zza.zzb(new zzbe(this)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzh("Exception getting view signals with timeout. ", e);
            zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    public void recordClick(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjm)).booleanValue() && !TextUtils.isEmpty(str)) {
            zzcaj.zza.execute(new zzbf(this, str));
        }
    }

    @JavascriptInterface
    public void reportTouchEvent(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = jSONObject.getInt("x");
            int i3 = jSONObject.getInt("y");
            int i4 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i5 = jSONObject.getInt("type");
            if (i5 != 0) {
                i = 1;
                if (i5 != 1) {
                    i = 2;
                    if (i5 != 2) {
                        i = 3;
                        if (i5 != 3) {
                            i = -1;
                        }
                    }
                }
            } else {
                i = 0;
            }
            try {
                this.zzc.zzd(MotionEvent.obtain(0, (long) i4, i, (float) i2, (float) i3, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException | JSONException e) {
                e = e;
                zzm.zzh("Failed to parse the touch string. ", e);
                zzv.zzp().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e2) {
            e = e2;
            zzm.zzh("Failed to parse the touch string. ", e);
            zzv.zzp().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        CookieManager zza2 = zzv.zzr().zza(this.zza);
        bundle.putBoolean("accept_3p_cookie", zza2 != null ? zza2.acceptThirdPartyCookies(this.zzb) : false);
        QueryInfo.generate(this.zza, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), queryInfoGenerationCallback);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(String str) {
        zzffs zzffs;
        Uri parse = Uri.parse(str);
        try {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlI)).booleanValue() || (zzffs = this.zzd) == null) {
                parse = this.zzc.zza(parse, this.zza, this.zzb, (Activity) null);
            } else {
                parse = zzffs.zza(parse, this.zza, this.zzb, (Activity) null);
            }
        } catch (zzavd e) {
            zzm.zzf("Failed to append the click signal to URL: ", e);
            zzv.zzp().zzw(e, "TaggingLibraryJsInterface.recordClick");
        }
        this.zzi.zzc(parse.toString(), (zzfkl) null);
    }
}
