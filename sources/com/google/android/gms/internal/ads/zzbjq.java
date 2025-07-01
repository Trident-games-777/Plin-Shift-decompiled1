package com.google.android.gms.internal.ads;

import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbjq {
    public static final zzbjr zzA = new zzbje();
    public static final zzbjr zzB = new zzbjg();
    public static final zzbjr zzC = new zzbjh();
    public static final zzbjr zza = new zzbio();
    public static final zzbjr zzb = new zzbiq();
    public static final zzbjr zzc = new zzbit();
    public static final zzbjr zzd = new zzbji();
    public static final zzbjr zze = new zzbjj();
    public static final zzbjr zzf = new zzbiu();
    public static final zzbjr zzg = new zzbjk();
    public static final zzbjr zzh = new zzbjl();
    public static final zzbjr zzi = new zzbis();
    public static final zzbjr zzj = new zzbjm();
    public static final zzbjr zzk = new zzbjn();
    public static final zzbjr zzl = new zzcdf();
    public static final zzbjr zzm = new zzcdg();
    public static final zzbjr zzn = new zzbik();
    public static final zzbkh zzo = new zzbkh();
    public static final zzbjr zzp = new zzbjo();
    public static final zzbjr zzq = new zzbjp();
    public static final zzbjr zzr = new zzbiv();
    public static final zzbjr zzs = new zzbiw();
    public static final zzbjr zzt = new zzbix();
    public static final zzbjr zzu = new zzbiy();
    public static final zzbjr zzv = new zzbiz();
    public static final zzbjr zzw = new zzbja();
    public static final zzbjr zzx = new zzbjb();
    public static final zzbjr zzy = new zzbjc();
    public static final zzbjr zzz = new zzbjd();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture zza(com.google.android.gms.internal.ads.zzcfk r5, java.lang.String r6) {
        /*
            android.net.Uri r0 = android.net.Uri.parse(r6)
            com.google.android.gms.internal.ads.zzavc r1 = r5.zzI()     // Catch:{ zzavd -> 0x0052 }
            com.google.android.gms.internal.ads.zzffs r2 = r5.zzS()     // Catch:{ zzavd -> 0x0052 }
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzlI     // Catch:{ zzavd -> 0x0052 }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzavd -> 0x0052 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ zzavd -> 0x0052 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzavd -> 0x0052 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzavd -> 0x0052 }
            if (r3 == 0) goto L_0x0039
            if (r2 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x005b
            boolean r1 = r1.zzf(r0)     // Catch:{ zzavd -> 0x0052 }
            if (r1 == 0) goto L_0x005b
            android.content.Context r1 = r5.getContext()     // Catch:{ zzavd -> 0x0052 }
            android.view.View r3 = r5.zzF()     // Catch:{ zzavd -> 0x0052 }
            android.app.Activity r4 = r5.zzi()     // Catch:{ zzavd -> 0x0052 }
            android.net.Uri r0 = r2.zza(r0, r1, r3, r4)     // Catch:{ zzavd -> 0x0052 }
            goto L_0x005b
        L_0x0039:
            if (r1 == 0) goto L_0x005b
            boolean r2 = r1.zzf(r0)     // Catch:{ zzavd -> 0x0052 }
            if (r2 == 0) goto L_0x005b
            android.content.Context r2 = r5.getContext()     // Catch:{ zzavd -> 0x0052 }
            android.view.View r3 = r5.zzF()     // Catch:{ zzavd -> 0x0052 }
            android.app.Activity r4 = r5.zzi()     // Catch:{ zzavd -> 0x0052 }
            android.net.Uri r0 = r1.zza(r0, r2, r3, r4)     // Catch:{ zzavd -> 0x0052 }
            goto L_0x005b
        L_0x0052:
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.String r6 = r1.concat(r6)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r6)
        L_0x005b:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.google.android.gms.internal.ads.zzfet r1 = r5.zzD()
            if (r1 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzfet r6 = r5.zzD()
            java.util.Map r6 = r6.zzaw
        L_0x006c:
            android.content.Context r1 = r5.getContext()
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbyx.zzb(r0, r1, r6)
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbem.zze
            java.lang.Object r0 = r0.zze()
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00c1
            r2 = 243799202(0xe8814a2, double:1.2045281E-315)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x00c1
            com.google.common.util.concurrent.ListenableFuture r5 = r5.zzT()
            com.google.android.gms.internal.ads.zzgdz r5 = com.google.android.gms.internal.ads.zzgdz.zzu(r5)
            com.google.android.gms.internal.ads.zzbil r0 = new com.google.android.gms.internal.ads.zzbil
            r0.<init>()
            com.google.android.gms.internal.ads.zzges r1 = com.google.android.gms.internal.ads.zzcaj.zzf
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgei.zze(r5, r2, r0, r1)
            com.google.android.gms.internal.ads.zzgdz r5 = (com.google.android.gms.internal.ads.zzgdz) r5
            com.google.android.gms.internal.ads.zzbim r0 = new com.google.android.gms.internal.ads.zzbim
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzges r1 = com.google.android.gms.internal.ads.zzcaj.zzf
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgei.zzm(r5, r0, r1)
            com.google.android.gms.internal.ads.zzgdz r5 = (com.google.android.gms.internal.ads.zzgdz) r5
            com.google.android.gms.internal.ads.zzbin r0 = new com.google.android.gms.internal.ads.zzbin
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzges r6 = com.google.android.gms.internal.ads.zzcaj.zzf
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgei.zze(r5, r1, r0, r6)
            com.google.android.gms.internal.ads.zzgdz r5 = (com.google.android.gms.internal.ads.zzgdz) r5
            return r5
        L_0x00c1:
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgei.zzh(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjq.zza(com.google.android.gms.internal.ads.zzcfk, java.lang.String):com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzcgr r16, java.util.Map r17) {
        /*
            java.lang.String r1 = "openableIntents"
            android.content.Context r0 = r16.getContext()
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            java.lang.String r0 = "data"
            r3 = r17
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0103 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0103 }
            java.lang.String r0 = "intents"
            org.json.JSONArray r3 = r3.getJSONArray(r0)     // Catch:{ JSONException -> 0x00f6 }
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r5 = 0
            r6 = r5
        L_0x0026:
            int r0 = r3.length()
            if (r6 >= r0) goto L_0x00ee
            org.json.JSONObject r0 = r3.getJSONObject(r6)     // Catch:{ JSONException -> 0x00e4 }
            java.lang.String r7 = "id"
            java.lang.String r7 = r0.optString(r7)
            java.lang.String r8 = "u"
            java.lang.String r8 = r0.optString(r8)
            java.lang.String r9 = "i"
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r10 = "m"
            java.lang.String r10 = r0.optString(r10)
            java.lang.String r11 = "p"
            java.lang.String r11 = r0.optString(r11)
            java.lang.String r12 = "c"
            java.lang.String r12 = r0.optString(r12)
            java.lang.String r13 = "intent_url"
            java.lang.String r13 = r0.optString(r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r14 = 0
            if (r0 != 0) goto L_0x0074
            android.content.Intent r0 = android.content.Intent.parseUri(r13, r5)     // Catch:{ URISyntaxException -> 0x0066 }
            goto L_0x0075
        L_0x0066:
            r0 = move-exception
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r15 = "Error parsing the url: "
            java.lang.String r13 = r15.concat(r13)
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r13, r0)
        L_0x0074:
            r0 = r14
        L_0x0075:
            r13 = 1
            if (r0 != 0) goto L_0x00c1
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r15 = android.text.TextUtils.isEmpty(r8)
            if (r15 != 0) goto L_0x008a
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r0.setData(r8)
        L_0x008a:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x0093
            r0.setAction(r9)
        L_0x0093:
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto L_0x009c
            r0.setType(r10)
        L_0x009c:
            boolean r8 = android.text.TextUtils.isEmpty(r11)
            if (r8 != 0) goto L_0x00a5
            r0.setPackage(r11)
        L_0x00a5:
            boolean r8 = android.text.TextUtils.isEmpty(r12)
            if (r8 != 0) goto L_0x00c1
            java.lang.String r8 = "/"
            r9 = 2
            java.lang.String[] r8 = r12.split(r8, r9)
            int r10 = r8.length
            if (r10 != r9) goto L_0x00c1
            android.content.ComponentName r9 = new android.content.ComponentName
            r10 = r8[r5]
            r8 = r8[r13]
            r9.<init>(r10, r8)
            r0.setComponent(r9)
        L_0x00c1:
            r8 = r0
            r0 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r14 = r2.resolveActivity(r8, r0)     // Catch:{ NullPointerException -> 0x00c9 }
            goto L_0x00d5
        L_0x00c9:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbzz r9 = com.google.android.gms.ads.internal.zzv.zzp()
            java.lang.String r8 = r8.toString()
            r9.zzw(r0, r8)
        L_0x00d5:
            if (r14 == 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r13 = r5
        L_0x00d9:
            r4.put(r7, r13)     // Catch:{ JSONException -> 0x00dd }
            goto L_0x00ea
        L_0x00dd:
            r0 = move-exception
            java.lang.String r7 = "Error constructing openable urls response."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r7, r0)
            goto L_0x00ea
        L_0x00e4:
            r0 = move-exception
            java.lang.String r7 = "Error parsing the intent data."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r7, r0)
        L_0x00ea:
            int r6 = r6 + 1
            goto L_0x0026
        L_0x00ee:
            r0 = r16
            com.google.android.gms.internal.ads.zzbmm r0 = (com.google.android.gms.internal.ads.zzbmm) r0
            r0.zze(r1, r4)
            return
        L_0x00f6:
            r0 = r16
            com.google.android.gms.internal.ads.zzbmm r0 = (com.google.android.gms.internal.ads.zzbmm) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        L_0x0103:
            r0 = r16
            com.google.android.gms.internal.ads.zzbmm r0 = (com.google.android.gms.internal.ads.zzbmm) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjq.zzb(com.google.android.gms.internal.ads.zzcgr, java.util.Map):void");
    }

    public static void zzc(Map map, zzdel zzdel) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzks)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals(DiskLruCache.VERSION) && zzdel != null) {
            zzdel.zzdG();
        }
    }
}
