package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.webkit.WebViewFeature;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrt implements zzczj, zzcya, zzcwp, zzdex {
    private final zzdsh zza;
    private final zzdsr zzb;

    public zzdrt(zzdsh zzdsh, zzdsr zzdsr) {
        this.zza = zzdsh;
        this.zzb = zzdsr;
    }

    private final void zzc(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                long j = bundle.getLong(str);
                if (j >= 0) {
                    this.zza.zzc(str, String.valueOf(j));
                }
            }
        }
    }

    private final void zzd(Bundle bundle, zzfzo zzfzo) {
        String str;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() && bundle != null) {
            bundle.putLong(zzdrv.PUBLIC_API_CALLBACK.zza(), zzv.zzC().currentTimeMillis());
            zzdsh zzdsh = this.zza;
            if (true != bundle.getBoolean("ls")) {
                str = "0";
            } else {
                str = DiskLruCache.VERSION;
            }
            zzdsh.zzc("ls", str);
            int size = zzfzo.size();
            for (int i = 0; i < size; i++) {
                zzdrw zzdrw = (zzdrw) zzfzo.get(i);
                long j = bundle.getLong(zzdrw.zza().zza(), -1);
                long j2 = bundle.getLong(zzdrw.zzb().zza(), -1);
                if (j > 0 && j2 > 0) {
                    this.zza.zzc(zzdrw.zzc(), String.valueOf(j2 - j));
                }
            }
            zzc(bundle.getBundle("client_sig_latency_key"));
            zzc(bundle.getBundle("gms_sig_latency_key"));
        }
    }

    public final void zzdB(zze zze) {
        this.zza.zzb().put("action", "ftl");
        this.zza.zzc("ftl", String.valueOf(zze.zza));
        this.zza.zzc("ed", zze.zzc);
        this.zzb.zzf(this.zza.zzb());
    }

    public final void zzdn(zzbvx zzbvx) {
        this.zza.zze(zzbvx.zza);
    }

    public final void zzdo(zzfff zzfff) {
        this.zza.zzd(zzfff);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbd r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzgO
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = "sgs"
            java.lang.String r1 = "action"
            if (r5 != 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzdsh r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            r5.put(r1, r0)
            com.google.android.gms.internal.ads.zzdsh r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            java.lang.String r0 = "request_id"
            java.lang.String r1 = "-1"
            r5.put(r0, r1)
            com.google.android.gms.internal.ads.zzdsr r5 = r4.zzb
            com.google.android.gms.internal.ads.zzdsh r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            r5.zzf(r0)
            return
        L_0x003b:
            com.google.android.gms.internal.ads.zzbvx r2 = r5.zzc
            if (r2 == 0) goto L_0x0046
            android.os.Bundle r2 = r2.zzm
            com.google.android.gms.internal.ads.zzfzo r3 = com.google.android.gms.internal.ads.zzdrw.zza
            r4.zzd(r2, r3)
        L_0x0046:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r3 = r5.zzb     // Catch:{ JSONException -> 0x00a7 }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x00a7 }
            com.google.android.gms.internal.ads.zzdsh r3 = r4.zza
            java.util.Map r3 = r3.zzb()
            r3.put(r1, r0)
            com.google.android.gms.internal.ads.zzdsh r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzjl
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x006f
            goto L_0x0089
        L_0x006f:
            java.lang.String r1 = "extras"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = "accept_3p_cookie"
            boolean r1 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r1 == 0) goto L_0x0080
            java.lang.String r1 = "1"
            goto L_0x008b
        L_0x0080:
            java.lang.String r1 = "0"
            goto L_0x008b
        L_0x0083:
            r1 = move-exception
            java.lang.String r2 = "Error retrieving JSONObject from the requestJson, "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r1)
        L_0x0089:
            java.lang.String r1 = "na"
        L_0x008b:
            java.lang.String r2 = "tpc"
            r0.put(r2, r1)
            com.google.android.gms.internal.ads.zzbvx r5 = r5.zzc
            if (r5 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzdsh r0 = r4.zza
            android.os.Bundle r5 = r5.zza
            r0.zze(r5)
        L_0x009b:
            com.google.android.gms.internal.ads.zzdsr r5 = r4.zzb
            com.google.android.gms.internal.ads.zzdsh r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            r5.zzf(r0)
            return
        L_0x00a7:
            com.google.android.gms.internal.ads.zzdsh r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            java.lang.String r0 = "sgf"
            r5.put(r1, r0)
            com.google.android.gms.internal.ads.zzdsh r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            java.lang.String r0 = "sgf_reason"
            java.lang.String r1 = "request_invalid"
            r5.put(r0, r1)
            com.google.android.gms.internal.ads.zzdsr r5 = r4.zzb
            com.google.android.gms.internal.ads.zzdsh r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            r5.zzf(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrt.zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbd):void");
    }

    public final void zzf(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgO)).booleanValue()) {
            this.zza.zzb().put("action", "sgf");
            this.zza.zzc("sgf_reason", str);
            this.zzb.zzf(this.zza.zzb());
        }
    }

    public final void zzs() {
        String str;
        this.zza.zzb().put("action", "loaded");
        zzd(this.zza.zza(), zzdrw.zzb);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmn)).booleanValue()) {
            zzdsh zzdsh = this.zza;
            if (true != WebViewFeature.isFeatureSupported("MUTE_AUDIO")) {
                str = "0";
            } else {
                str = DiskLruCache.VERSION;
            }
            zzdsh.zzb().put("mafe", str);
        }
        this.zzb.zzf(this.zza.zzb());
    }
}
