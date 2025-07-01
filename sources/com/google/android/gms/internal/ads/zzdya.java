package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdya {
    private final zzchk zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final zzffo zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfkl zzg;
    private final zzdsh zzh;
    private final Object zzi = new Object();

    public zzdya(zzchk zzchk, Context context, VersionInfoParcel versionInfoParcel, zzffo zzffo, Executor executor, String str, zzfkl zzfkl, zzdsh zzdsh) {
        this.zza = zzchk;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = zzffo;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfkl;
        zzchk.zzx();
        this.zzh = zzdsh;
    }

    private final ListenableFuture zzc(String str, String str2) {
        zzfka zza2 = zzfjz.zza(this.zzb, 11);
        zza2.zzi();
        ListenableFuture zzn = zzgei.zzn(zzgei.zzn(zzgei.zzn(zzgei.zzh(""), new zzdxx(this, str, str2), this.zze), new zzdxy(zzv.zzg().zza(this.zzb, this.zzc, this.zza.zzz()).zza("google.afma.response.normalize", zzbof.zza, zzbof.zza)), this.zze), new zzdxz(this), this.zze);
        zzfkk.zza(zzn, this.zzg, zza2);
        return zzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && EnvironmentCompat.MEDIA_UNKNOWN.equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzm.zzj("Failed to update the ad types for rendering. ".concat(e.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String zzf(java.lang.String r4, java.lang.String r5, java.lang.String r6, com.google.android.gms.internal.ads.zzdsh r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x008c
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0020 }
            r1.<init>(r6)     // Catch:{ JSONException -> 0x0020 }
            java.lang.String r2 = "is_gbid"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x0020 }
            java.lang.String r2 = "true"
            boolean r1 = r1.equals(r2)     // Catch:{ JSONException -> 0x0020 }
            if (r1 == 0) goto L_0x0020
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ JSONException -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        L_0x0024:
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x002b
            goto L_0x008c
        L_0x002b:
            java.lang.String r1 = "&"
            int r1 = r4.lastIndexOf(r1)
            r2 = -1
            r3 = 0
            if (r1 == r2) goto L_0x003a
            java.lang.String r0 = r4.substring(r0, r1)
            goto L_0x003b
        L_0x003a:
            r0 = r3
        L_0x003b:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x008c
            r1 = 11
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            java.lang.String r1 = "UTF-8"
            byte[] r5 = r5.getBytes(r1)     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0059 }
            r1.<init>(r6)     // Catch:{ JSONException -> 0x0059 }
            java.lang.String r6 = "arek"
            java.lang.String r3 = r1.getString(r6)     // Catch:{ JSONException -> 0x0059 }
            goto L_0x0070
        L_0x0059:
            r6 = move-exception
            java.lang.String r1 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            java.lang.String r2 = "Failed to get key from QueryJSONMap"
            java.lang.String r1 = r2.concat(r1)     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            com.google.android.gms.ads.internal.util.zze.zza(r1)     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            com.google.android.gms.internal.ads.zzbzz r1 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            java.lang.String r2 = "CryptoUtils.getKeyFromQueryJsonMap"
            r1.zzw(r6, r2)     // Catch:{ UnsupportedEncodingException -> 0x0075 }
        L_0x0070:
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfgd.zzb(r0, r5, r3, r7)     // Catch:{ UnsupportedEncodingException -> 0x0075 }
            return r4
        L_0x0075:
            r5 = move-exception
            java.lang.String r6 = "Failed to decode the adResponse. "
            java.lang.String r7 = r5.toString()
            java.lang.String r6 = r6.concat(r7)
            com.google.android.gms.ads.internal.util.zze.zza(r6)
            java.lang.String r6 = "PreloadedLoader.decryptAdResponseIfNecessary"
            com.google.android.gms.internal.ads.zzbzz r7 = com.google.android.gms.ads.internal.zzv.zzp()
            r7.zzw(r5, r6)
        L_0x008c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zzf(java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzdsh):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0130, code lost:
        if (r3.zzg(r1, r6, r5) == false) goto L_0x0132;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzffo r0 = r12.zzd
            com.google.android.gms.ads.internal.client.zzm r0 = r0.zzd
            java.lang.String r0 = r0.zzx
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x016e
            java.lang.String r1 = zze(r0)
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzgT
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x003a
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x003a
            java.lang.String r1 = "&request_id="
            int r1 = r0.lastIndexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0038
            int r1 = r1 + 12
            java.lang.String r1 = r0.substring(r1)
            goto L_0x003a
        L_0x0038:
            java.lang.String r1 = ""
        L_0x003a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzeiz r0 = new com.google.android.gms.internal.ads.zzeiz
            r1 = 15
            java.lang.String r2 = "Invalid ad string."
            r0.<init>(r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgei.zzg(r0)
            return r0
        L_0x004e:
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzhj
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x013a
            java.lang.Object r2 = r12.zzi
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzchk r3 = r12.zza     // Catch:{ all -> 0x0137 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r3 = r3.zzo()     // Catch:{ all -> 0x0137 }
            com.google.android.gms.internal.ads.zzdsh r4 = r12.zzh     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = r3.zzb(r1, r4)     // Catch:{ all -> 0x0137 }
            com.google.android.gms.internal.ads.zzbce r5 = com.google.android.gms.internal.ads.zzbcn.zzgT     // Catch:{ all -> 0x0137 }
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0137 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ all -> 0x0137 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0137 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0137 }
            if (r5 == 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzdsh r5 = r12.zzh     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = zzf(r0, r1, r4, r5)     // Catch:{ all -> 0x0137 }
        L_0x0087:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0095 }
            r5.<init>(r0)     // Catch:{ JSONException -> 0x0095 }
            java.lang.String r6 = "render_id"
            java.lang.String r7 = ""
            java.lang.String r5 = r5.optString(r6, r7)     // Catch:{ all -> 0x0137 }
            goto L_0x0097
        L_0x0095:
            java.lang.String r5 = ""
        L_0x0097:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0137 }
            r7 = 0
            r8 = 0
            if (r6 != 0) goto L_0x00fa
            java.lang.String r6 = ""
            java.lang.String r9 = new java.lang.String     // Catch:{ IllegalArgumentException -> 0x00ae }
            byte[] r10 = android.util.Base64.decode(r5, r8)     // Catch:{ IllegalArgumentException -> 0x00ae }
            java.nio.charset.Charset r11 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IllegalArgumentException -> 0x00ae }
            r9.<init>(r10, r11)     // Catch:{ IllegalArgumentException -> 0x00ae }
            r6 = r9
            goto L_0x00c5
        L_0x00ae:
            r9 = move-exception
            java.lang.String r10 = "Ad grouping: Has render_id, but not base64 encoded: "
            java.lang.String r11 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0137 }
            java.lang.String r10 = r10.concat(r11)     // Catch:{ all -> 0x0137 }
            com.google.android.gms.ads.internal.util.zze.zza(r10)     // Catch:{ all -> 0x0137 }
            com.google.android.gms.internal.ads.zzbzz r10 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ all -> 0x0137 }
            java.lang.String r11 = "PreloadedLoader.decodeRenderId"
            r10.zzw(r9, r11)     // Catch:{ all -> 0x0137 }
        L_0x00c5:
            r9 = 58
            com.google.android.gms.internal.ads.zzfwf r9 = com.google.android.gms.internal.ads.zzfwf.zzc(r9)     // Catch:{ all -> 0x0137 }
            com.google.android.gms.internal.ads.zzfxd r9 = com.google.android.gms.internal.ads.zzfxd.zzb(r9)     // Catch:{ all -> 0x0137 }
            java.util.List r6 = r9.zze(r6)     // Catch:{ all -> 0x0137 }
            int r9 = r6.size()     // Catch:{ all -> 0x0137 }
            r10 = 2
            if (r9 != r10) goto L_0x00ed
            java.lang.Object r5 = r6.get(r8)     // Catch:{ all -> 0x0137 }
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0137 }
            r5 = 1
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x0137 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0137 }
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ all -> 0x0137 }
            goto L_0x00fa
        L_0x00ed:
            java.lang.String r6 = "Ad grouping: Has render_id, but invalid format: "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0137 }
            java.lang.String r5 = r6.concat(r5)     // Catch:{ all -> 0x0137 }
            com.google.android.gms.ads.internal.util.zze.zza(r5)     // Catch:{ all -> 0x0137 }
        L_0x00fa:
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x0137 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0137 }
            r5.<init>(r7, r6)     // Catch:{ all -> 0x0137 }
            java.lang.Object r6 = r5.first     // Catch:{ all -> 0x0137 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0137 }
            java.lang.Object r5 = r5.second     // Catch:{ all -> 0x0137 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0137 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0137 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0137 }
            if (r7 != 0) goto L_0x0132
            if (r5 <= 0) goto L_0x0132
            boolean r7 = r3.zzh(r1, r6)     // Catch:{ all -> 0x0137 }
            if (r7 == 0) goto L_0x012c
            com.google.android.gms.internal.ads.zzeiz r0 = new com.google.android.gms.internal.ads.zzeiz     // Catch:{ all -> 0x0137 }
            java.lang.String r1 = "The ad has already been shown."
            r3 = 10
            r0.<init>(r3, r1)     // Catch:{ all -> 0x0137 }
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgei.zzg(r0)     // Catch:{ all -> 0x0137 }
            monitor-exit(r2)     // Catch:{ all -> 0x0137 }
            return r0
        L_0x012c:
            boolean r5 = r3.zzg(r1, r6, r5)     // Catch:{ all -> 0x0137 }
            if (r5 != 0) goto L_0x0135
        L_0x0132:
            r3.zzf(r1)     // Catch:{ all -> 0x0137 }
        L_0x0135:
            monitor-exit(r2)     // Catch:{ all -> 0x0137 }
            goto L_0x015e
        L_0x0137:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0137 }
            throw r0
        L_0x013a:
            com.google.android.gms.internal.ads.zzchk r2 = r12.zza
            com.google.android.gms.internal.ads.zzdsh r3 = r12.zzh
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r2 = r2.zzo()
            java.lang.String r4 = r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzgT
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzdsh r2 = r12.zzh
            java.lang.String r0 = zzf(r0, r1, r4, r2)
        L_0x015e:
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x0165
            goto L_0x016e
        L_0x0165:
            java.lang.String r1 = r12.zzd(r4)
            com.google.common.util.concurrent.ListenableFuture r0 = r12.zzc(r0, r1)
            return r0
        L_0x016e:
            com.google.android.gms.internal.ads.zzffo r0 = r12.zzd
            com.google.android.gms.ads.internal.client.zzm r0 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r0 = r0.zzs
            if (r0 == 0) goto L_0x01cf
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzgL
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0189
            goto L_0x01b5
        L_0x0189:
            java.lang.String r1 = r0.zza
            java.lang.String r2 = r0.zzb
            java.lang.String r1 = zze(r1)
            java.lang.String r2 = zze(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x01c2
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c2
            com.google.android.gms.internal.ads.zzchk r2 = r12.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r2 = r2.zzo()
            r2.zzf(r1)
            com.google.android.gms.internal.ads.zzdsh r2 = r12.zzh
            java.util.Map r2 = r2.zzb()
            java.lang.String r3 = "request_id"
            r2.put(r3, r1)
        L_0x01b5:
            java.lang.String r1 = r0.zza
            java.lang.String r0 = r0.zzb
            java.lang.String r0 = r12.zzd(r0)
            com.google.common.util.concurrent.ListenableFuture r0 = r12.zzc(r1, r0)
            return r0
        L_0x01c2:
            com.google.android.gms.internal.ads.zzdsh r0 = r12.zzh
            java.util.Map r0 = r0.zzb()
            java.lang.String r1 = "ridmm"
            java.lang.String r2 = "true"
            r0.put(r1, r2)
        L_0x01cf:
            com.google.android.gms.internal.ads.zzeiz r0 = new com.google.android.gms.internal.ads.zzeiz
            r1 = 14
            java.lang.String r2 = "Mismatch request IDs."
            r0.<init>(r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgei.zzg(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(JSONObject jSONObject) throws Exception {
        return zzgei.zzh(new zzfff(new zzffc(this.zzd), zzffe.zza(new StringReader(jSONObject.toString()), (zzbvx) null)));
    }
}
