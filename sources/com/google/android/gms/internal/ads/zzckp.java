package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzcy;
import com.google.android.gms.ads.internal.client.zzdl;
import com.google.android.gms.ads.internal.client.zzfv;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzat;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzckp extends zzcy {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdqd zzc;
    private final zzefd zzd;
    private final zzelo zze;
    private final zzdup zzf;
    private final zzbyv zzg;
    private final zzdqi zzh;
    private final zzdvk zzi;
    private final zzbfg zzj;
    private final zzfko zzk;
    private final zzfgk zzl;
    private final zzcue zzm;
    private final zzdsm zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(zzv.zzC().elapsedRealtime());

    zzckp(Context context, VersionInfoParcel versionInfoParcel, zzdqd zzdqd, zzefd zzefd, zzelo zzelo, zzdup zzdup, zzbyv zzbyv, zzdqi zzdqi, zzdvk zzdvk, zzbfg zzbfg, zzfko zzfko, zzfgk zzfgk, zzcue zzcue, zzdsm zzdsm) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdqd;
        this.zzd = zzefd;
        this.zze = zzelo;
        this.zzf = zzdup;
        this.zzg = zzbyv;
        this.zzh = zzdqi;
        this.zzi = zzdvk;
        this.zzj = zzbfg;
        this.zzk = zzfko;
        this.zzl = zzfgk;
        this.zzm = zzcue;
        this.zzn = zzdsm;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (zzv.zzp().zzi().zzM()) {
            String zzi2 = zzv.zzp().zzi().zzi();
            if (!zzv.zzt().zzj(this.zza, zzi2, this.zzb.afmaVersion)) {
                zzv.zzp().zzi().zzx(false);
                zzv.zzp().zzi().zzw("");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zze2 = zzv.zzp().zzi().zzg().zze();
        if (!zze2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzm.zzk("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbpa zzbpa : zze2.values()) {
                    for (zzboz zzboz : zzbpa.zza) {
                        String str = zzboz.zzb;
                        for (String str2 : zzboz.zza) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((List) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzefe zza2 = this.zzd.zza(str3, jSONObject);
                        if (zza2 != null) {
                            zzfgm zzfgm = (zzfgm) zza2.zzb;
                            if (!zzfgm.zzC() && zzfgm.zzB()) {
                                zzfgm.zzj(this.zza, (zzegy) zza2.zzc, (List) entry.getValue());
                                zzm.zze("Initialized rewarded video mediation adapter " + str3);
                            }
                        }
                    } catch (zzffv e) {
                        zzm.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzfgt.zzb(this.zza, true);
    }

    public final synchronized float zze() {
        return zzv.zzs().zza();
    }

    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    public final void zzi() {
        this.zzf.zzl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzo     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x00d9 }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcn.zza(r0)     // Catch:{ all -> 0x00d9 }
            android.content.Context r0 = r3.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r1 = r3.zzb     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ all -> 0x00d9 }
            r2.zzu(r0, r1)     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzcue r0 = r3.zzm     // Catch:{ all -> 0x00d9 }
            r0.zzd()     // Catch:{ all -> 0x00d9 }
            android.content.Context r0 = r3.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbat r1 = com.google.android.gms.ads.internal.zzv.zzc()     // Catch:{ all -> 0x00d9 }
            r1.zzi(r0)     // Catch:{ all -> 0x00d9 }
            r0 = 1
            r3.zzo = r0     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzdup r0 = r3.zzf     // Catch:{ all -> 0x00d9 }
            r0.zzr()     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzelo r0 = r3.zze     // Catch:{ all -> 0x00d9 }
            r0.zze()     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzec     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzdqi r0 = r3.zzh     // Catch:{ all -> 0x00d9 }
            r0.zzd()     // Catch:{ all -> 0x00d9 }
        L_0x004e:
            com.google.android.gms.internal.ads.zzdvk r0 = r3.zzi     // Catch:{ all -> 0x00d9 }
            r0.zzg()     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zziO     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzges r0 = com.google.android.gms.internal.ads.zzcaj.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzckj r1 = new com.google.android.gms.internal.ads.zzckj     // Catch:{ all -> 0x00d9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00d9 }
            r0.execute(r1)     // Catch:{ all -> 0x00d9 }
        L_0x006f:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkD     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzges r0 = com.google.android.gms.internal.ads.zzcaj.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzckn r1 = new com.google.android.gms.internal.ads.zzckn     // Catch:{ all -> 0x00d9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00d9 }
            r0.execute(r1)     // Catch:{ all -> 0x00d9 }
        L_0x008b:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzda     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzges r0 = com.google.android.gms.internal.ads.zzcaj.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzckk r1 = new com.google.android.gms.internal.ads.zzckk     // Catch:{ all -> 0x00d9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00d9 }
            r0.execute(r1)     // Catch:{ all -> 0x00d9 }
        L_0x00a7:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzeF     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzeG     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzges r0 = com.google.android.gms.internal.ads.zzcaj.zza     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzckl r1 = new com.google.android.gms.internal.ads.zzckl     // Catch:{ all -> 0x00d9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00d9 }
            r0.execute(r1)     // Catch:{ all -> 0x00d9 }
            monitor-exit(r3)
            return
        L_0x00d7:
            monitor-exit(r3)
            return
        L_0x00d9:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d9 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckp.zzk():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(java.lang.String r12, com.google.android.gms.dynamic.IObjectWrapper r13) {
        /*
            r11 = this;
            android.content.Context r0 = r11.zza
            com.google.android.gms.internal.ads.zzbcn.zza(r0)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzeh
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ RuntimeException -> 0x0023, RemoteException -> 0x0021 }
            android.content.Context r0 = r11.zza     // Catch:{ RuntimeException -> 0x0023, RemoteException -> 0x0021 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzs.zzp(r0)     // Catch:{ RuntimeException -> 0x0023, RemoteException -> 0x0021 }
            goto L_0x002f
        L_0x0021:
            r0 = move-exception
            goto L_0x0024
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            java.lang.String r1 = "NonagonMobileAdsSettingManager_AppId"
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()
            r2.zzw(r0, r1)
        L_0x002d:
            java.lang.String r0 = ""
        L_0x002f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r2 != r1) goto L_0x0038
            r6 = r12
            goto L_0x0039
        L_0x0038:
            r6 = r0
        L_0x0039:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x0040
            goto L_0x0095
        L_0x0040:
            com.google.android.gms.internal.ads.zzbce r12 = com.google.android.gms.internal.ads.zzbcn.zzea
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r12 = r0.zza(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzaX
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r12 = r12 | r0
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzaX
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007f
            java.lang.Object r12 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r13)
            java.lang.Runnable r12 = (java.lang.Runnable) r12
            com.google.android.gms.internal.ads.zzcko r13 = new com.google.android.gms.internal.ads.zzcko
            r13.<init>(r11, r12)
            goto L_0x0081
        L_0x007f:
            r13 = 0
            r2 = r12
        L_0x0081:
            r7 = r13
            if (r2 == 0) goto L_0x0095
            android.content.Context r4 = r11.zza
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r11.zzb
            com.google.android.gms.internal.ads.zzfko r8 = r11.zzk
            com.google.android.gms.internal.ads.zzdsm r9 = r11.zzn
            java.lang.Long r10 = r11.zzp
            com.google.android.gms.ads.internal.zzf r3 = com.google.android.gms.ads.internal.zzv.zza()
            r3.zza(r4, r5, r6, r7, r8, r9, r10)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckp.zzl(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void zzm(zzdl zzdl) throws RemoteException {
        this.zzi.zzh(zzdl, zzdvj.API);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzm.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzm.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        zzat zzat = new zzat(context);
        zzat.zzn(str);
        zzat.zzo(this.zzb.afmaVersion);
        zzat.zzr();
    }

    public final void zzo(zzbpg zzbpg) throws RemoteException {
        this.zzl.zzf(zzbpg);
    }

    public final synchronized void zzp(boolean z) {
        zzv.zzs().zzc(z);
    }

    public final synchronized void zzq(float f) {
        zzv.zzs().zzd(f);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            android.content.Context r0 = r9.zza     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbcn.zza(r0)     // Catch:{ all -> 0x0033 }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzea     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            android.content.Context r2 = r9.zza     // Catch:{ all -> 0x0033 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r9.zzb     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzfko r6 = r9.zzk     // Catch:{ all -> 0x0033 }
            com.google.android.gms.ads.internal.zzf r1 = com.google.android.gms.ads.internal.zzv.zza()     // Catch:{ all -> 0x0033 }
            r7 = 0
            r8 = 0
            r5 = 0
            r4 = r10
            r1.zza(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0033 }
            monitor-exit(r9)
            return
        L_0x0031:
            monitor-exit(r9)
            return
        L_0x0033:
            r0 = move-exception
            r10 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x0033 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckp.zzr(java.lang.String):void");
    }

    public final void zzs(zzblw zzblw) throws RemoteException {
        this.zzf.zzs(zzblw);
    }

    public final void zzt(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziZ)).booleanValue()) {
            zzv.zzp().zzz(str);
        }
    }

    public final void zzu(zzfv zzfv) throws RemoteException {
        this.zzg.zzn(this.zza, zzfv);
    }

    public final synchronized boolean zzv() {
        return zzv.zzs().zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw() {
        zzv.zzf().zzb(this.zza, this.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx() {
        this.zzj.zza(new zzbuo());
    }

    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfti.zza(this.zza).zzc(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }
}
