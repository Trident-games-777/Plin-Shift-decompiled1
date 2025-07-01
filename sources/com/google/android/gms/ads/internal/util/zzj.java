package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzazl;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzj implements zzg {
    private String zzA = "{}";
    private int zzB = -1;
    private int zzC = -1;
    private long zzD = 0;
    private final Object zza = new Object();
    private boolean zzb;
    private final List zzc = new ArrayList();
    private ListenableFuture zzd;
    private zzazl zze = null;
    private SharedPreferences zzf;
    private SharedPreferences.Editor zzg;
    private boolean zzh = true;
    private String zzi;
    private String zzj;
    private boolean zzk = true;
    private String zzl = "-1";
    private int zzm = -1;
    private zzbzt zzn = new zzbzt("", 0);
    private long zzo = 0;
    private long zzp = 0;
    private int zzq = -1;
    private int zzr = 0;
    private Set zzs = Collections.emptySet();
    private JSONObject zzt = new JSONObject();
    private boolean zzu = true;
    private boolean zzv = true;
    private String zzw = null;
    private String zzx = "";
    private boolean zzy = false;
    private String zzz = "";

    private final void zzR() {
        ListenableFuture listenableFuture = this.zzd;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            try {
                this.zzd.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzm.zzk("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzm.zzh("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final void zzS() {
        zzcaj.zza.execute(new zzh(this));
    }

    public final void zzA(int i) {
        zzR();
        synchronized (this.zza) {
            this.zzm = i;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                if (i == -1) {
                    editor.remove("gad_has_consent_for_cookies");
                } else {
                    editor.putInt("gad_has_consent_for_cookies", i);
                }
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzB(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzx.equals(str)) {
                    this.zzx = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzC(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjb)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzA.equals(str)) {
                    this.zzA = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_ui_storage", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzD(boolean z) {
        zzR();
        synchronized (this.zza) {
            if (z != this.zzk) {
                this.zzk = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzE(boolean z) {
        zzR();
        synchronized (this.zza) {
            long currentTimeMillis = System.currentTimeMillis() + ((Long) zzbe.zzc().zza(zzbcn.zzke)).longValue();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("is_topics_ad_personalization_allowed", z);
                this.zzg.putLong("topics_consent_expiry_time_ms", currentTimeMillis);
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzF(String str, String str2, boolean z) {
        zzR();
        synchronized (this.zza) {
            JSONArray optJSONArray = this.zzt.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzv.zzC().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzt.put(str, optJSONArray);
            } catch (JSONException e) {
                zzm.zzk("Could not update native advanced settings", e);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzt.toString());
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzG(int i) {
        zzR();
        synchronized (this.zza) {
            if (this.zzq != i) {
                this.zzq = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzH(int i) {
        zzR();
        synchronized (this.zza) {
            if (this.zzC != i) {
                this.zzC = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzI(long j) {
        zzR();
        synchronized (this.zza) {
            if (this.zzD != j) {
                this.zzD = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzJ(String str) {
        zzR();
        synchronized (this.zza) {
            this.zzl = str;
            if (this.zzg != null) {
                if (str.equals("-1")) {
                    this.zzg.remove("IABTCF_TCString");
                } else {
                    this.zzg.putString("IABTCF_TCString", str);
                }
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final boolean zzK() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzL() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzv;
        }
        return z;
    }

    public final boolean zzM() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzy;
        }
        return z;
    }

    public final boolean zzN() {
        boolean z;
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzaE)).booleanValue()) {
            return false;
        }
        zzR();
        synchronized (this.zza) {
            z = this.zzk;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzO() {
        /*
            r7 = this;
            r7.zzR()
            java.lang.Object r0 = r7.zza
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r7.zzf     // Catch:{ all -> 0x0030 }
            r2 = 0
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r2
        L_0x000d:
            java.lang.String r3 = "topics_consent_expiry_time_ms"
            r4 = 0
            long r3 = r1.getLong(r3, r4)     // Catch:{ all -> 0x0030 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r2
        L_0x001f:
            android.content.SharedPreferences r1 = r7.zzf     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = "is_topics_ad_personalization_allowed"
            boolean r1 = r1.getBoolean(r3, r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            boolean r1 = r7.zzk     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            r2 = 1
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r2
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.zzO():boolean");
    }

    public final zzazl zzP() {
        if (!this.zzb) {
            return null;
        }
        if ((zzK() && zzL()) || !((Boolean) zzbee.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzazl();
            }
            this.zze.zzd();
            zzm.zzi("start fetching content...");
            zzazl zzazl = this.zze;
            return zzazl;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        try {
            synchronized (this.zza) {
                this.zzf = sharedPreferences;
                this.zzg = edit;
                if (PlatformVersion.isAtLeastM()) {
                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                }
                this.zzh = this.zzf.getBoolean("use_https", this.zzh);
                this.zzu = this.zzf.getBoolean("content_url_opted_out", this.zzu);
                this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
                this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
                this.zzv = this.zzf.getBoolean("content_vertical_opted_out", this.zzv);
                this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
                this.zzr = this.zzf.getInt("version_code", this.zzr);
                if (!((Boolean) zzbef.zzg.zze()).booleanValue() || !zzbe.zzc().zze()) {
                    this.zzn = new zzbzt(this.zzf.getString("app_settings_json", this.zzn.zzc()), this.zzf.getLong("app_settings_last_update_ms", this.zzn.zza()));
                } else {
                    this.zzn = new zzbzt("", 0);
                }
                this.zzo = this.zzf.getLong("app_last_background_time_ms", this.zzo);
                this.zzq = this.zzf.getInt("request_in_session_count", this.zzq);
                this.zzp = this.zzf.getLong("first_ad_req_time_ms", this.zzp);
                this.zzs = this.zzf.getStringSet("never_pool_slots", this.zzs);
                this.zzw = this.zzf.getString("display_cutout", this.zzw);
                this.zzB = this.zzf.getInt("app_measurement_npa", this.zzB);
                this.zzC = this.zzf.getInt("sd_app_measure_npa", this.zzC);
                this.zzD = this.zzf.getLong("sd_app_measure_npa_ts", this.zzD);
                this.zzx = this.zzf.getString("inspector_info", this.zzx);
                this.zzy = this.zzf.getBoolean("linked_device", this.zzy);
                this.zzz = this.zzf.getString("linked_ad_unit", this.zzz);
                this.zzA = this.zzf.getString("inspector_ui_storage", this.zzA);
                this.zzl = this.zzf.getString("IABTCF_TCString", this.zzl);
                this.zzm = this.zzf.getInt("gad_has_consent_for_cookies", this.zzm);
                try {
                    this.zzt = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
                } catch (JSONException e) {
                    zzm.zzk("Could not convert native advanced settings to json object", e);
                }
                zzS();
            }
        } catch (Throwable th) {
            zzv.zzp().zzw(th, "AdSharedPreferenceManagerImpl.initializeOnBackgroundThread");
            zze.zzb("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread, errorMessage = ", th);
        }
    }

    public final int zza() {
        int i;
        zzR();
        synchronized (this.zza) {
            i = this.zzr;
        }
        return i;
    }

    public final int zzb() {
        zzR();
        return this.zzm;
    }

    public final int zzc() {
        int i;
        zzR();
        synchronized (this.zza) {
            i = this.zzq;
        }
        return i;
    }

    public final long zzd() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzo;
        }
        return j;
    }

    public final long zze() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzp;
        }
        return j;
    }

    public final long zzf() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzD;
        }
        return j;
    }

    public final zzbzt zzg() {
        zzbzt zzbzt;
        zzR();
        synchronized (this.zza) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzlq)).booleanValue() && this.zzn.zzj()) {
                for (Runnable run : this.zzc) {
                    run.run();
                }
            }
            zzbzt = this.zzn;
        }
        return zzbzt;
    }

    public final zzbzt zzh() {
        zzbzt zzbzt;
        synchronized (this.zza) {
            zzbzt = this.zzn;
        }
        return zzbzt;
    }

    public final String zzi() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzz;
        }
        return str;
    }

    public final String zzj() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzw;
        }
        return str;
    }

    public final String zzk() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzx;
        }
        return str;
    }

    public final String zzl() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzA;
        }
        return str;
    }

    public final String zzm() {
        zzR();
        return this.zzl;
    }

    public final JSONObject zzn() {
        JSONObject jSONObject;
        zzR();
        synchronized (this.zza) {
            jSONObject = this.zzt;
        }
        return jSONObject;
    }

    public final void zzo(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzp(Context context) {
        synchronized (this.zza) {
            if (this.zzf == null) {
                this.zzd = zzcaj.zza.zza(new zzi(this, context, "admob"));
                this.zzb = true;
            }
        }
    }

    public final void zzq() {
        zzR();
        synchronized (this.zza) {
            this.zzt = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzr(long j) {
        zzR();
        synchronized (this.zza) {
            if (this.zzo != j) {
                this.zzo = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzs(String str) {
        zzR();
        synchronized (this.zza) {
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzn.zzc())) {
                    this.zzn = new zzbzt(str, currentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzg.apply();
                    }
                    zzS();
                    for (Runnable run : this.zzc) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzn.zzg(currentTimeMillis);
        }
    }

    public final void zzt(int i) {
        zzR();
        synchronized (this.zza) {
            if (this.zzr != i) {
                this.zzr = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzu(boolean z) {
        zzR();
        synchronized (this.zza) {
            if (this.zzu != z) {
                this.zzu = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzv(boolean z) {
        zzR();
        synchronized (this.zza) {
            if (this.zzv != z) {
                this.zzv = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzw(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziO)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzz.equals(str)) {
                    this.zzz = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzx(boolean z) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziO)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (this.zzy != z) {
                    this.zzy = z;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzy(String str) {
        zzR();
        synchronized (this.zza) {
            if (!TextUtils.equals(this.zzw, str)) {
                this.zzw = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzz(long j) {
        zzR();
        synchronized (this.zza) {
            if (this.zzp != j) {
                this.zzp = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }
}
