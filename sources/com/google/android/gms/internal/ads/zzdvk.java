package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzdl;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdvk implements zzdwl, zzduv {
    private final zzdvv zza;
    private final zzdwm zzb;
    private final zzduw zzc;
    private final zzdvf zzd;
    private final zzduu zze;
    private final zzdwh zzf;
    private final zzdvr zzg;
    private final zzdvr zzh;
    private final String zzi;
    private final Context zzj;
    @Nullable
    private final String zzk;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = "{}";
    private JSONObject zzp;
    private long zzq = Long.MAX_VALUE;
    private zzdvg zzr = zzdvg.NONE;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private zzdvj zzv = zzdvj.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    zzdvk(zzdvv zzdvv, zzdwm zzdwm, zzduw zzduw, Context context, VersionInfoParcel versionInfoParcel, zzdvf zzdvf, zzdwh zzdwh, zzdvr zzdvr, zzdvr zzdvr2, @Nullable String str) {
        this.zza = zzdvv;
        this.zzb = zzdwm;
        this.zzc = zzduw;
        this.zze = new zzduu(context);
        this.zzi = versionInfoParcel.afmaVersion;
        this.zzk = str;
        this.zzd = zzdvf;
        this.zzf = zzdwh;
        this.zzg = zzdvr;
        this.zzh = zzdvr2;
        this.zzj = context;
        zzv.zzt().zzg(this);
    }

    private final synchronized void zzA(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                zzx(jSONObject.optBoolean("isTestMode", false), false);
                zzw((zzdvg) Enum.valueOf(zzdvg.class, jSONObject.optString("gesture", "NONE")), false);
                this.zzo = jSONObject.optString("networkExtras", "{}");
                this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
            } catch (JSONException unused) {
            }
        }
    }

    private final synchronized JSONObject zzt() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzl.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzduy zzduy : (List) entry.getValue()) {
                if (zzduy.zzg()) {
                    jSONArray.put(zzduy.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzu() {
        this.zzu = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        if (!TextUtils.isEmpty((CharSequence) zzbe.zzc().zza(zzbcn.zzjc))) {
            this.zzg.zzb(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzjc)).split(",")));
        }
        if (!TextUtils.isEmpty((CharSequence) zzbe.zzc().zza(zzbcn.zzjd))) {
            this.zzh.zzb(this.zzj.getSharedPreferences("admob", 0), Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzjd)).split(",")));
        }
        zzA(zzv.zzp().zzi().zzk());
        this.zzx = zzv.zzp().zzi().zzl();
    }

    private final void zzv() {
        zzv.zzp().zzi().zzB(zzd());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzw(com.google.android.gms.internal.ads.zzdvg r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdvg r0 = r1.zzr     // Catch:{ all -> 0x0023 }
            if (r0 != r2) goto L_0x0006
            goto L_0x0021
        L_0x0006:
            boolean r0 = r1.zzq()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000f
            r1.zzy()     // Catch:{ all -> 0x0023 }
        L_0x000f:
            r1.zzr = r2     // Catch:{ all -> 0x0023 }
            boolean r2 = r1.zzq()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x001a
            r1.zzz()     // Catch:{ all -> 0x0023 }
        L_0x001a:
            if (r3 == 0) goto L_0x0021
            r1.zzv()     // Catch:{ all -> 0x0023 }
            monitor-exit(r1)
            return
        L_0x0021:
            monitor-exit(r1)
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvk.zzw(com.google.android.gms.internal.ads.zzdvg, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzx(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzs     // Catch:{ all -> 0x003c }
            if (r0 != r2) goto L_0x0006
            goto L_0x003a
        L_0x0006:
            r1.zzs = r2     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zziO     // Catch:{ all -> 0x003c }
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r0.zza(r2)     // Catch:{ all -> 0x003c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x003c }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.util.zzax r2 = com.google.android.gms.ads.internal.zzv.zzt()     // Catch:{ all -> 0x003c }
            boolean r2 = r2.zzl()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x002a
        L_0x0026:
            r1.zzz()     // Catch:{ all -> 0x003c }
            goto L_0x0033
        L_0x002a:
            boolean r2 = r1.zzq()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0033
            r1.zzy()     // Catch:{ all -> 0x003c }
        L_0x0033:
            if (r3 == 0) goto L_0x003a
            r1.zzv()     // Catch:{ all -> 0x003c }
            monitor-exit(r1)
            return
        L_0x003a:
            monitor-exit(r1)
            return
        L_0x003c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvk.zzx(boolean, boolean):void");
    }

    private final synchronized void zzy() {
        int ordinal = this.zzr.ordinal();
        if (ordinal == 1) {
            this.zzb.zzb();
        } else if (ordinal == 2) {
            this.zzc.zzb();
        }
    }

    private final synchronized void zzz() {
        int ordinal = this.zzr.ordinal();
        if (ordinal == 1) {
            this.zzb.zzc();
        } else if (ordinal == 2) {
            this.zzc.zzc();
        }
    }

    public final zzdvg zza() {
        return this.zzr;
    }

    public final synchronized ListenableFuture zzb(String str) {
        zzcao zzcao;
        zzcao = new zzcao();
        if (this.zzm.containsKey(str)) {
            zzcao.zzc((zzduy) this.zzm.get(str));
        } else {
            if (!this.zzn.containsKey(str)) {
                this.zzn.put(str, new ArrayList());
            }
            ((List) this.zzn.get(str)).add(zzcao);
        }
        return zzcao;
    }

    public final synchronized String zzc() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue()) {
            if (zzq()) {
                if (this.zzq < zzv.zzC().currentTimeMillis() / 1000) {
                    this.zzo = "{}";
                    this.zzq = Long.MAX_VALUE;
                    return "";
                } else if (!this.zzo.equals("{}")) {
                    return this.zzo;
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|(1:7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzd() {
        /*
            r7 = this;
            monitor-enter(r7)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r0.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "isTestMode"
            boolean r2 = r7.zzs     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "gesture"
            com.google.android.gms.internal.ads.zzdvg r2 = r7.zzr     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            long r1 = r7.zzq     // Catch:{ JSONException -> 0x0033 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ JSONException -> 0x0033 }
            long r3 = r3.currentTimeMillis()     // Catch:{ JSONException -> 0x0033 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0033
            java.lang.String r1 = "networkExtras"
            java.lang.String r2 = r7.zzo     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "networkExtrasExpirationSecs"
            long r2 = r7.zzq     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
        L_0x0033:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0039 }
            monitor-exit(r7)
            return r0
        L_0x0039:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0039 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvk.zzd():java.lang.String");
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            if (!TextUtils.isEmpty(this.zzk)) {
                String str = this.zzk;
                jSONObject.put("sdkVersion", "afma-sdk-a-v" + str);
            }
            jSONObject.put("internalSdkVersion", this.zzi);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziZ)).booleanValue()) {
                String zzn2 = zzv.zzp().zzn();
                if (!TextUtils.isEmpty(zzn2)) {
                    jSONObject.put("plugin", zzn2);
                }
            }
            if (this.zzq < zzv.zzC().currentTimeMillis() / 1000) {
                this.zzo = "{}";
            }
            jSONObject.put("networkExtras", this.zzo);
            jSONObject.put("adSlots", zzt());
            jSONObject.put("appInfo", this.zze.zza());
            String zzc2 = zzv.zzp().zzi().zzg().zzc();
            if (!TextUtils.isEmpty(zzc2)) {
                jSONObject.put("cld", new JSONObject(zzc2));
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziP)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                String obj = jSONObject2.toString();
                zzm.zze("Server data: " + obj);
                jSONObject.put("serverData", this.zzp);
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziO)).booleanValue()) {
                jSONObject.put("openAction", this.zzv);
                jSONObject.put("gesture", this.zzr);
            }
            jSONObject.put("isGamRegisteredTestDevice", zzv.zzt().zzl());
            zzv.zzq();
            zzbc.zzb();
            jSONObject.put("isSimulator", zzf.zzs());
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzjb)).booleanValue()) {
                jSONObject.put("uiStorage", new JSONObject(this.zzx));
            }
            if (!TextUtils.isEmpty((CharSequence) zzbe.zzc().zza(zzbcn.zzjd))) {
                jSONObject.put("gmaDisk", this.zzh.zza());
            }
            if (!TextUtils.isEmpty((CharSequence) zzbe.zzc().zza(zzbcn.zzjc))) {
                jSONObject.put("userDisk", this.zzg.zza());
            }
        } catch (JSONException e) {
            zzv.zzp().zzv(e, "Inspector.toJson");
            zzm.zzk("Ad inspector encountered an error", e);
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(java.lang.String r4, com.google.android.gms.internal.ads.zzduy r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zziz     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x009f }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x009f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x009d
            boolean r0 = r3.zzq()     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x001b
            goto L_0x009d
        L_0x001b:
            int r0 = r3.zzt     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zziB     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x009f }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ all -> 0x009f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x009f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x009f }
            if (r0 < r1) goto L_0x0036
            java.lang.String r4 = "Maximum number of ad requests stored reached. Dropping the current request."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x009f }
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.Map r0 = r3.zzl     // Catch:{ all -> 0x009f }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0048
            java.util.Map r0 = r3.zzl     // Catch:{ all -> 0x009f }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x009f }
            r1.<init>()     // Catch:{ all -> 0x009f }
            r0.put(r4, r1)     // Catch:{ all -> 0x009f }
        L_0x0048:
            int r0 = r3.zzt     // Catch:{ all -> 0x009f }
            int r0 = r0 + 1
            r3.zzt = r0     // Catch:{ all -> 0x009f }
            java.util.Map r0 = r3.zzl     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x009f }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x009f }
            r4.add(r5)     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zziX     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r0.zza(r4)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x009f }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x009d
            java.lang.String r4 = r5.zzc()     // Catch:{ all -> 0x009f }
            java.util.Map r0 = r3.zzm     // Catch:{ all -> 0x009f }
            r0.put(r4, r5)     // Catch:{ all -> 0x009f }
            java.util.Map r0 = r3.zzn     // Catch:{ all -> 0x009f }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x009d
            java.util.Map r0 = r3.zzn     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x009f }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x009f }
            java.util.Iterator r0 = r4.iterator()     // Catch:{ all -> 0x009f }
        L_0x0088:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzcao r1 = (com.google.android.gms.internal.ads.zzcao) r1     // Catch:{ all -> 0x009f }
            r1.zzc(r5)     // Catch:{ all -> 0x009f }
            goto L_0x0088
        L_0x0098:
            r4.clear()     // Catch:{ all -> 0x009f }
            monitor-exit(r3)
            return
        L_0x009d:
            monitor-exit(r3)
            return
        L_0x009f:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x009f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvk.zzf(java.lang.String, com.google.android.gms.internal.ads.zzduy):void");
    }

    public final void zzg() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue()) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zziO)).booleanValue() || !zzv.zzp().zzi().zzM()) {
                String zzk2 = zzv.zzp().zzi().zzk();
                if (!TextUtils.isEmpty(zzk2)) {
                    try {
                        if (new JSONObject(zzk2).optBoolean("isTestMode", false)) {
                            zzu();
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else {
                zzu();
            }
        }
    }

    public final synchronized void zzh(zzdl zzdl, zzdvj zzdvj) {
        if (!zzq()) {
            try {
                zzdl.zze(zzfgq.zzd(18, (String) null, (zze) null));
            } catch (RemoteException unused) {
                zzm.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
            }
        } else {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue()) {
                try {
                    zzdl.zze(zzfgq.zzd(1, (String) null, (zze) null));
                } catch (RemoteException unused2) {
                    zzm.zzj("Ad inspector had an internal error.");
                }
            } else {
                this.zzv = zzdvj;
                this.zza.zzj(zzdl, new zzbkl(this), new zzbke(this.zzf), new zzbjs(this));
            }
        }
    }

    public final synchronized void zzi(String str, long j) {
        this.zzo = str;
        this.zzq = j;
        zzv();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        zzv.zzp().zzi().zzC(this.zzx);
    }

    public final synchronized void zzk(long j) {
        this.zzw += j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r2 != false) goto L_0x000c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzu
            if (r0 != 0) goto L_0x000a
            if (r2 == 0) goto L_0x0015
            r1.zzu()
            goto L_0x000c
        L_0x000a:
            if (r2 == 0) goto L_0x0015
        L_0x000c:
            boolean r2 = r1.zzs
            if (r2 == 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            r1.zzz()
            return
        L_0x0015:
            boolean r2 = r1.zzq()
            if (r2 != 0) goto L_0x001e
            r1.zzy()
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvk.zzl(boolean):void");
    }

    public final void zzm(zzdvg zzdvg) {
        zzw(zzdvg, true);
    }

    public final synchronized void zzn(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final void zzo(boolean z) {
        if (!this.zzu && z) {
            zzu();
        }
        zzx(z, true);
    }

    public final boolean zzp() {
        return this.zzp != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zziO     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x002c }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0028
            boolean r0 = r2.zzs     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0025
            com.google.android.gms.ads.internal.util.zzax r0 = com.google.android.gms.ads.internal.zzv.zzt()     // Catch:{ all -> 0x002c }
            boolean r0 = r0.zzl()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0025:
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0028:
            boolean r0 = r2.zzs     // Catch:{ all -> 0x002c }
            monitor-exit(r2)
            return r0
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvk.zzq():boolean");
    }

    public final synchronized boolean zzr() {
        return this.zzs;
    }

    public final boolean zzs() {
        return this.zzw < ((Long) zzbe.zzc().zza(zzbcn.zziU)).longValue();
    }
}
