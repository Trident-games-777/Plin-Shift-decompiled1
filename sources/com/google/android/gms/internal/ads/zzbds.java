package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.zza;
import com.google.android.gms.ads.nonagon.signalgeneration.zzj;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.firebase.messaging.Constants;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbds {
    private final ScheduledExecutorService zza;
    private final zzj zzb;
    private final zza zzc;
    private final zzdsr zzd;
    private Runnable zze;
    private zzbdp zzf;
    /* access modifiers changed from: private */
    public CustomTabsSession zzg;
    private String zzh;
    private long zzi = 0;
    private long zzj;
    private JSONArray zzk;
    private Context zzl;

    public zzbds(ScheduledExecutorService scheduledExecutorService, zzj zzj2, zza zza2, zzdsr zzdsr) {
        this.zza = scheduledExecutorService;
        this.zzb = zzj2;
        this.zzc = zza2;
        this.zzd = zzdsr;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzjv)).booleanValue() != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbdp r0 = r5.zzf
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            return
        L_0x000a:
            java.lang.Boolean r0 = r0.zza()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r0 = r5.zzh
            if (r0 == 0) goto L_0x0070
            androidx.browser.customtabs.CustomTabsSession r0 = r5.zzg
            if (r0 == 0) goto L_0x0070
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            if (r0 == 0) goto L_0x0070
            long r0 = r5.zzi
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()
            long r0 = r0.elapsedRealtime()
            long r2 = r5.zzi
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzjv
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0070
        L_0x004b:
            androidx.browser.customtabs.CustomTabsSession r0 = r5.zzg
            java.lang.String r1 = r5.zzh
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.requestPostMessageChannel(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            java.lang.Runnable r1 = r5.zze
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzjw
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L_0x0070:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbds.zzj():void");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzk == null) {
                this.zzk = new JSONArray((String) zzbe.zzc().zza(zzbcn.zzjy));
            }
            jSONObject.put("eids", this.zzk);
        } catch (JSONException e) {
            zzm.zzh("Error fetching the PACT active eids JSON: ", e);
        }
    }

    @Nullable
    public final CustomTabsSession zzb() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzc(String str, String str2) throws JSONException {
        long j;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str2);
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            j = ((Long) zzbe.zzc().zza(zzbcn.zzjz)).longValue();
        } else {
            j = 0;
        }
        jSONObject.put("sdk_ttl_ms", j);
        zzk(jSONObject);
        if (((Boolean) zzbes.zza.zze()).booleanValue()) {
            jSONObject.put("appLevelSignals", this.zzc.zza());
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzd(String str, String str2) throws JSONException {
        long j;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            j = ((Long) zzbe.zzc().zza(zzbcn.zzjz)).longValue();
        } else {
            j = 0;
        }
        jSONObject.put("sdk_ttl_ms", j);
        zzk(jSONObject);
        if (((Boolean) zzbes.zza.zze()).booleanValue()) {
            jSONObject.put("appLevelSignals", this.zzc.zza());
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        this.zzi = zzv.zzC().elapsedRealtime() + ((long) ((Integer) zzbe.zzc().zza(zzbcn.zzju)).intValue());
        if (this.zze == null) {
            this.zze = new zzbdq(this);
        }
        zzj();
    }

    /* access modifiers changed from: package-private */
    public final void zzh(String str) {
        try {
            CustomTabsSession customTabsSession = this.zzg;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzj).toString());
            zzk(jSONObject);
            if (((Boolean) zzbes.zza.zze()).booleanValue()) {
                jSONObject.put("appLevelSignals", this.zzc.zza());
            }
            customTabsSession.postMessage(jSONObject.toString(), (Bundle) null);
            zzbdr zzbdr = new zzbdr(this, str);
            if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
                this.zzb.zzg(this.zzg, zzbdr);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzl, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), zzbdr);
        } catch (JSONException e) {
            zzm.zzh("Error creating JSON: ", e);
        }
    }

    public final void zzi(long j) {
        this.zzj = j;
    }

    public final void zzg(@Nonnull Context context, @Nonnull CustomTabsClient customTabsClient, @Nonnull String str, @Nullable CustomTabsCallback customTabsCallback) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        } else if (customTabsClient != null) {
            this.zzl = context;
            this.zzh = str;
            zzbdp zzbdp = new zzbdp(this, customTabsCallback, this.zzd);
            this.zzf = zzbdp;
            CustomTabsSession newSession = customTabsClient.newSession(zzbdp);
            this.zzg = newSession;
            if (newSession == null) {
                zzm.zzg("CustomTabsClient failed to create new session.");
            }
            com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzd(this.zzd, (zzdsh) null, "pact_action", new Pair("pe", "pact_init"));
        } else {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
    }
}
