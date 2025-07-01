package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbyc implements zzbyh {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzhct zzd;
    private final LinkedHashMap zze;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Context zzh;
    private final zzbye zzi;
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbyc(Context context, VersionInfoParcel versionInfoParcel, zzbye zzbye, String str, zzbyd zzbyd) {
        Preconditions.checkNotNull(zzbye, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzbye;
        for (String lowerCase : zzbye.zze) {
            this.zzk.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhct zzc2 = zzhes.zzc();
        zzc2.zzn(9);
        zzc2.zzj(str);
        zzc2.zzh(str);
        zzhcu zzc3 = zzhcv.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzc3.zza(str2);
        }
        zzc2.zzg((zzhcv) zzc3.zzbr());
        zzhej zzc4 = zzhek.zzc();
        zzc4.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzc4.zza(str3);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzc4.zzb(apkVersion);
        }
        zzc2.zzf((zzhek) zzc4.zzbr());
        this.zzd = zzc2;
    }

    public final zzbye zza() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(Map map) throws Exception {
        ListenableFuture zzm2;
        zzheh zzheh;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = optJSONArray.length();
                            synchronized (this.zzj) {
                                zzheh = (zzheh) this.zze.get(str);
                            }
                            if (zzheh == null) {
                                zzbyg.zza("Cannot find the corresponding resource object for " + str);
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzheh.zza(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zza;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zza = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbev.zza.zze()).booleanValue()) {
                    zzm.zzf("Failed to get SafeBrowsing metadata", e);
                }
                return zzgei.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z3 = this.zza;
        if ((!z3 || !this.zzi.zzg) && ((!this.zzm || !this.zzi.zzf) && (z3 || !this.zzi.zzd))) {
            return zzgei.zzh((Object) null);
        }
        synchronized (this.zzj) {
            for (zzheh zzbn : this.zze.values()) {
                this.zzd.zzc((zzhei) zzbn.zzbr());
            }
            this.zzd.zza(this.zzf);
            this.zzd.zzb(this.zzg);
            if (zzbyg.zzb()) {
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + this.zzd.zzl() + "\n  clickUrl: " + this.zzd.zzk() + "\n  resources: \n");
                for (zzhei zzhei : this.zzd.zzm()) {
                    sb.append("    [");
                    sb.append(zzhei.zzc());
                    sb.append("] ");
                    sb.append(zzhei.zzg());
                }
                zzbyg.zza(sb.toString());
            }
            ListenableFuture zzb2 = new zzbn(this.zzh).zzb(1, this.zzi.zzb, (Map) null, ((zzhes) this.zzd.zzbr()).zzaV());
            if (zzbyg.zzb()) {
                zzb2.addListener(new zzbxz(), zzcaj.zza);
            }
            zzm2 = zzgei.zzm(zzb2, new zzbya(), zzcaj.zzf);
        }
        return zzm2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.lang.String r7, java.util.Map r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzj
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzm = r2     // Catch:{ all -> 0x00b4 }
        L_0x0009:
            java.util.LinkedHashMap r2 = r6.zze     // Catch:{ all -> 0x00b4 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x0021
            if (r9 != r1) goto L_0x001f
            java.util.LinkedHashMap r8 = r6.zze     // Catch:{ all -> 0x00b4 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzheh r7 = (com.google.android.gms.internal.ads.zzheh) r7     // Catch:{ all -> 0x00b4 }
            r8 = 4
            r7.zze(r8)     // Catch:{ all -> 0x00b4 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzheh r1 = com.google.android.gms.internal.ads.zzhei.zzd()     // Catch:{ all -> 0x00b4 }
            int r9 = com.google.android.gms.internal.ads.zzheg.zza(r9)     // Catch:{ all -> 0x00b4 }
            if (r9 == 0) goto L_0x002e
            r1.zze(r9)     // Catch:{ all -> 0x00b4 }
        L_0x002e:
            java.util.LinkedHashMap r9 = r6.zze     // Catch:{ all -> 0x00b4 }
            int r9 = r9.size()     // Catch:{ all -> 0x00b4 }
            r1.zzb(r9)     // Catch:{ all -> 0x00b4 }
            r1.zzd(r7)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzhdg r9 = com.google.android.gms.internal.ads.zzhdj.zzc()     // Catch:{ all -> 0x00b4 }
            java.util.HashSet r2 = r6.zzk     // Catch:{ all -> 0x00b4 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00b4 }
            if (r2 != 0) goto L_0x00a4
            if (r8 == 0) goto L_0x00a4
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00b4 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00b4 }
        L_0x0050:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x00a4
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00b4 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00b4 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00b4 }
            goto L_0x006b
        L_0x0069:
            java.lang.String r3 = ""
        L_0x006b:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0078
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b4 }
            goto L_0x007a
        L_0x0078:
            java.lang.String r2 = ""
        L_0x007a:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00b4 }
            java.util.HashSet r5 = r6.zzk     // Catch:{ all -> 0x00b4 }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzhde r4 = com.google.android.gms.internal.ads.zzhdf.zzc()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgxp r3 = com.google.android.gms.internal.ads.zzgxp.zzw(r3)     // Catch:{ all -> 0x00b4 }
            r4.zza(r3)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgxp r2 = com.google.android.gms.internal.ads.zzgxp.zzw(r2)     // Catch:{ all -> 0x00b4 }
            r4.zzb(r2)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgyx r2 = r4.zzbr()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzhdf r2 = (com.google.android.gms.internal.ads.zzhdf) r2     // Catch:{ all -> 0x00b4 }
            r9.zza(r2)     // Catch:{ all -> 0x00b4 }
            goto L_0x0050
        L_0x00a4:
            com.google.android.gms.internal.ads.zzgyx r8 = r9.zzbr()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzhdj r8 = (com.google.android.gms.internal.ads.zzhdj) r8     // Catch:{ all -> 0x00b4 }
            r1.zzc(r8)     // Catch:{ all -> 0x00b4 }
            java.util.LinkedHashMap r8 = r6.zze     // Catch:{ all -> 0x00b4 }
            r8.put(r7, r1)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x00b4:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyc.zzd(java.lang.String, java.util.Map, int):void");
    }

    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture zzn = zzgei.zzn(zzgei.zzh(Collections.emptyMap()), new zzbxx(this), zzcaj.zzf);
            ListenableFuture zzo = zzgei.zzo(zzn, 10, TimeUnit.SECONDS, zzcaj.zzd);
            zzgei.zzr(zzn, new zzbyb(this, zzo), zzcaj.zzf);
            zzc.add(zzo);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgxn zzt = zzgxp.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzt);
        synchronized (this.zzj) {
            zzhct zzhct = this.zzd;
            zzheb zzc2 = zzhed.zzc();
            zzc2.zza(zzt.zzb());
            zzc2.zzb("image/png");
            zzc2.zzc(2);
            zzhct.zzi((zzhed) zzc2.zzbr());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(android.view.View r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbye r0 = r7.zzi
            boolean r0 = r0.zzc
            if (r0 != 0) goto L_0x0008
            goto L_0x0093
        L_0x0008:
            boolean r0 = r7.zzl
            if (r0 != 0) goto L_0x0093
            com.google.android.gms.ads.internal.zzv.zzq()
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L_0x0014
            goto L_0x006d
        L_0x0014:
            boolean r2 = r8.isDrawingCacheEnabled()     // Catch:{ RuntimeException -> 0x002d }
            r8.setDrawingCacheEnabled(r0)     // Catch:{ RuntimeException -> 0x002d }
            android.graphics.Bitmap r3 = r8.getDrawingCache()     // Catch:{ RuntimeException -> 0x002d }
            if (r3 == 0) goto L_0x0026
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3)     // Catch:{ RuntimeException -> 0x002d }
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            r8.setDrawingCacheEnabled(r2)     // Catch:{ RuntimeException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r3 = r1
        L_0x002f:
            java.lang.String r4 = "Fail to capture the web view"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r4, r2)
        L_0x0034:
            if (r3 != 0) goto L_0x006c
            int r2 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r3 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            if (r2 == 0) goto L_0x005f
            if (r3 != 0) goto L_0x0043
            goto L_0x005f
        L_0x0043:
            int r4 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r5 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch:{ RuntimeException -> 0x0065 }
            r5.<init>(r4)     // Catch:{ RuntimeException -> 0x0065 }
            r6 = 0
            r8.layout(r6, r6, r2, r3)     // Catch:{ RuntimeException -> 0x0065 }
            r8.draw(r5)     // Catch:{ RuntimeException -> 0x0065 }
            r1 = r4
            goto L_0x006d
        L_0x005f:
            java.lang.String r8 = "Width or height of view is zero"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r8)     // Catch:{ RuntimeException -> 0x0065 }
            goto L_0x006d
        L_0x0065:
            r8 = move-exception
            java.lang.String r2 = "Fail to capture the webview"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r8)
            goto L_0x006d
        L_0x006c:
            r1 = r3
        L_0x006d:
            if (r1 != 0) goto L_0x0075
            java.lang.String r8 = "Failed to capture the webview bitmap."
            com.google.android.gms.internal.ads.zzbyg.zza(r8)
            return
        L_0x0075:
            r7.zzl = r0
            com.google.android.gms.internal.ads.zzbxy r8 = new com.google.android.gms.internal.ads.zzbxy
            r8.<init>(r7, r1)
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            if (r0 == r1) goto L_0x008e
            r8.run()
            return
        L_0x008e:
            com.google.android.gms.internal.ads.zzges r0 = com.google.android.gms.internal.ads.zzcaj.zza
            r0.execute(r8)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyc.zzg(android.view.View):void");
    }

    public final void zzh(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzd();
            } else {
                this.zzd.zze(str);
            }
        }
    }

    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
