package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.messaging.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdup {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzcao zze = new zzcao();
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdqd zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdsw zzl;
    private final VersionInfoParcel zzm;
    private final Map zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzddk zzo;
    /* access modifiers changed from: private */
    public final zzfko zzp;
    private boolean zzq = true;

    public zzdup(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdqd zzdqd, ScheduledExecutorService scheduledExecutorService, zzdsw zzdsw, VersionInfoParcel versionInfoParcel, zzddk zzddk, zzfko zzfko) {
        this.zzh = zzdqd;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsw;
        this.zzm = versionInfoParcel;
        this.zzo = zzddk;
        this.zzp = zzfko;
        this.zzd = zzv.zzC().elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(zzdup zzdup, String str) {
        zzcao zzcao;
        Object obj;
        zzdup zzdup2;
        zzdup zzdup3 = zzdup;
        int i = 5;
        zzfka zza2 = zzfjz.zza(zzdup3.zzf, 5);
        zza2.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzfka zza3 = zzfjz.zza(zzdup3.zzf, i);
                zza3.zzi();
                zza3.zzd(next);
                Object obj2 = new Object();
                zzcao zzcao2 = new zzcao();
                ListenableFuture zzo2 = zzgei.zzo(zzcao2, ((Long) zzbe.zzc().zza(zzbcn.zzbU)).longValue(), TimeUnit.SECONDS, zzdup3.zzk);
                zzdup3.zzl.zzc(next);
                zzdup3.zzo.zzc(next);
                long elapsedRealtime = zzv.zzC().elapsedRealtime();
                zzo2.addListener(new zzdug(zzdup3, obj2, zzcao2, next, elapsedRealtime, zza3), zzdup3.zzi);
                arrayList.add(zzo2);
                try {
                    zzcao = zzcao2;
                    obj = obj2;
                    zzdup2 = zzdup;
                } catch (JSONException e) {
                    e = e;
                    zzdup3 = zzdup;
                    zze.zzb("Malformed CLD response", e);
                    zzdup3.zzo.zza("MalformedJson");
                    zzdup3.zzl.zza("MalformedJson");
                    zzdup3.zze.zzd(e);
                    zzv.zzp().zzw(e, "AdapterInitializer.updateAdapterStatus");
                    zzfko zzfko = zzdup3.zzp;
                    zza2.zzh(e);
                    zza2.zzg(false);
                    zzfko.zzb(zza2.zzm());
                }
                try {
                    zzduo zzduo = new zzduo(zzdup2, obj, next, elapsedRealtime, zza3, zzcao);
                    zzdup3 = zzdup2;
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONObject != null) {
                        try {
                            JSONArray jSONArray = optJSONObject.getJSONArray(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                            int i2 = 0;
                            while (i2 < jSONArray.length()) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                String optString = jSONObject2.optString("format", "");
                                JSONObject optJSONObject2 = jSONObject2.optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                                Bundle bundle = new Bundle();
                                if (optJSONObject2 != null) {
                                    Iterator<String> keys2 = optJSONObject2.keys();
                                    while (keys2.hasNext()) {
                                        String next2 = keys2.next();
                                        bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                        jSONArray = jSONArray;
                                    }
                                }
                                JSONArray jSONArray2 = jSONArray;
                                arrayList2.add(new zzblz(optString, bundle));
                                i2++;
                                jSONArray = jSONArray2;
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    zzdup3.zzv(next, false, "", 0);
                    try {
                        zzdup3.zzj.execute(new zzduk(zzdup3, next, zzduo, zzdup3.zzh.zzc(next, new JSONObject()), arrayList2));
                    } catch (zzffv e2) {
                        String str2 = "Failed to create Adapter.";
                        try {
                            if (((Boolean) zzbe.zzc().zza(zzbcn.zzmG)).booleanValue()) {
                                str2 = str2 + " " + e2.getMessage();
                            }
                            zzduo.zze(str2);
                        } catch (RemoteException e3) {
                            zzm.zzh("", e3);
                        }
                    }
                    i = 5;
                } catch (JSONException e4) {
                    e = e4;
                    zzdup3 = zzdup2;
                    zze.zzb("Malformed CLD response", e);
                    zzdup3.zzo.zza("MalformedJson");
                    zzdup3.zzl.zza("MalformedJson");
                    zzdup3.zze.zzd(e);
                    zzv.zzp().zzw(e, "AdapterInitializer.updateAdapterStatus");
                    zzfko zzfko2 = zzdup3.zzp;
                    zza2.zzh(e);
                    zza2.zzg(false);
                    zzfko2.zzb(zza2.zzm());
                }
            }
            zzgei.zza(arrayList).zza(new zzduh(zzdup3, zza2), zzdup3.zzi);
        } catch (JSONException e5) {
            e = e5;
            zze.zzb("Malformed CLD response", e);
            zzdup3.zzo.zza("MalformedJson");
            zzdup3.zzl.zza("MalformedJson");
            zzdup3.zze.zzd(e);
            zzv.zzp().zzw(e, "AdapterInitializer.updateAdapterStatus");
            zzfko zzfko22 = zzdup3.zzp;
            zza2.zzh(e);
            zza2.zzg(false);
            zzfko22.zzb(zza2.zzm());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String zzc2 = zzv.zzp().zzi().zzg().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzgei.zzh(zzc2);
        }
        zzcao zzcao = new zzcao();
        zzv.zzp().zzi().zzo(new zzdui(this, zzcao));
        return zzcao;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzblp(str, z, i, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzfka zzfka) throws Exception {
        this.zze.zzc(true);
        zzfka.zzg(true);
        this.zzp.zzb(zzfka.zzm());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzblp zzblp = (zzblp) this.zzn.get(str);
            arrayList.add(new zzblp(str, zzblp.zzb, zzblp.zzc, zzblp.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (!this.zzc) {
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzv.zzC().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzn(java.lang.String r3, com.google.android.gms.internal.ads.zzblt r4, com.google.android.gms.internal.ads.zzfgm r5, java.util.List r6) {
        /*
            r2 = this;
            java.lang.String r0 = "Failed to initialize adapter. "
            java.lang.String r1 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r1 = java.util.Objects.equals(r3, r1)     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
            if (r1 == 0) goto L_0x000e
            r4.zzf()     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
            return
        L_0x000e:
            java.lang.ref.WeakReference r1 = r2.zzg     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
            java.lang.Object r1 = r1.get()     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
            if (r1 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            android.content.Context r1 = r2.zzf     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
        L_0x001b:
            r5.zzi(r1, r4, r6)     // Catch:{ zzffv -> 0x0026, RemoteException -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfxm r4 = new com.google.android.gms.internal.ads.zzfxm
            r4.<init>(r3)
            throw r4
        L_0x0026:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x003b }
            r5.<init>(r0)     // Catch:{ RemoteException -> 0x003b }
            r5.append(r3)     // Catch:{ RemoteException -> 0x003b }
            java.lang.String r3 = " does not implement the initialize() method."
            r5.append(r3)     // Catch:{ RemoteException -> 0x003b }
            java.lang.String r3 = r5.toString()     // Catch:{ RemoteException -> 0x003b }
            r4.zze(r3)     // Catch:{ RemoteException -> 0x003b }
            return
        L_0x003b:
            r3 = move-exception
            java.lang.String r4 = ""
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdup.zzn(java.lang.String, com.google.android.gms.internal.ads.zzblt, com.google.android.gms.internal.ads.zzfgm, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzcao zzcao) {
        this.zzi.execute(new zzduf(this, zzcao));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzcao zzcao, String str, long j, zzfka zzfka) {
        synchronized (obj) {
            if (!zzcao.isDone()) {
                zzv(str, false, "Timeout.", (int) (zzv.zzC().elapsedRealtime() - j));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfko zzfko = this.zzp;
                zzfka.zzc("Timeout");
                zzfka.zzg(false);
                zzfko.zzb(zzfka.zzm());
                zzcao.zzc(false);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbet.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) zzbe.zzc().zza(zzbcn.zzbT)).intValue() && this.zzq) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzf();
                            this.zzo.zzf();
                            this.zze.addListener(new zzdul(this), this.zzi);
                            this.zza = true;
                            ListenableFuture zzu = zzu();
                            this.zzk.schedule(new zzdue(this), ((Long) zzbe.zzc().zza(zzbcn.zzbV)).longValue(), TimeUnit.SECONDS);
                            zzgei.zzr(zzu, new zzdun(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzc(false);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(zzblw zzblw) {
        this.zze.addListener(new zzduj(this, zzblw), this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
