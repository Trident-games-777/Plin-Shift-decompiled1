package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfew {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final long zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfev zzj;
    public final Bundle zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;
    public final JSONObject zzo;
    public final JSONObject zzp;
    public final String zzq;
    public final int zzr;
    public long zzs;
    public long zzt;

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0144, code lost:
        r35.skipValue();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[ExcHandler: IOException | JSONException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:51:0x0138] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzfew(android.util.JsonReader r35) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r34 = this;
            r0 = r34
            r0.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r35.beginObject()
            java.lang.String r8 = ""
            r9 = 0
            r10 = 0
            r5 = r8
            r6 = r5
            r14 = r6
            r15 = r14
            r11 = r9
            r12 = r11
            r20 = r12
            r21 = r10
            r16 = -1
            r18 = 0
            r22 = -1
            r24 = -1
            r26 = 0
            r28 = -1
            r29 = 1
            r9 = r15
            r10 = r9
        L_0x0039:
            boolean r30 = r35.hasNext()
            if (r30 == 0) goto L_0x0251
            java.lang.String r13 = r35.nextName()
            java.lang.String r7 = "nofill_urls"
            boolean r7 = java.util.Objects.equals(r13, r7)
            if (r7 == 0) goto L_0x0050
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbr.zzd(r35)
            goto L_0x0039
        L_0x0050:
            java.lang.String r7 = "refresh_interval"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x005e
            int r7 = r35.nextInt()
            r11 = r7
            goto L_0x0039
        L_0x005e:
            java.lang.String r7 = "refresh_load_delay_time_interval"
            boolean r7 = java.util.Objects.equals(r13, r7)
            if (r7 == 0) goto L_0x006b
            int r28 = r35.nextInt()
            goto L_0x0039
        L_0x006b:
            java.lang.String r7 = "gws_query_id"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0079
            java.lang.String r7 = r35.nextString()
            r8 = r7
            goto L_0x0039
        L_0x0079:
            java.lang.String r7 = "analytics_query_ad_event_id"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0087
            java.lang.String r7 = r35.nextString()
            r9 = r7
            goto L_0x0039
        L_0x0087:
            java.lang.String r7 = "is_idless"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0096
            boolean r7 = r35.nextBoolean()
            r20 = r7
            goto L_0x0039
        L_0x0096:
            java.lang.String r7 = "response_code"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x00a4
            int r7 = r35.nextInt()
            r12 = r7
            goto L_0x0039
        L_0x00a4:
            java.lang.String r7 = "latency"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x00b1
            long r26 = r35.nextLong()
            goto L_0x0039
        L_0x00b1:
            com.google.android.gms.internal.ads.zzbce r7 = com.google.android.gms.internal.ads.zzbcn.zzhV
            r31 = r6
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r6.zza(r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00df
            java.lang.String r6 = "public_error"
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x00df
            android.util.JsonToken r6 = r35.peek()
            android.util.JsonToken r7 = android.util.JsonToken.BEGIN_OBJECT
            if (r6 != r7) goto L_0x00df
            com.google.android.gms.internal.ads.zzfev r6 = new com.google.android.gms.internal.ads.zzfev
            r7 = r35
            r6.<init>(r7)
            r21 = r6
            goto L_0x00ee
        L_0x00df:
            r7 = r35
            java.lang.String r6 = "bidding_data"
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x00f2
            java.lang.String r6 = r7.nextString()
            r10 = r6
        L_0x00ee:
            r6 = r31
            goto L_0x0039
        L_0x00f2:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzkb
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0110
            java.lang.String r6 = "topics_should_record_observation"
            boolean r6 = java.util.Objects.equals(r13, r6)
            if (r6 == 0) goto L_0x0110
            r35.nextBoolean()
            goto L_0x00ee
        L_0x0110:
            java.lang.String r6 = "adapter_response_replacement_key"
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x011e
            java.lang.String r6 = r35.nextString()
            goto L_0x0039
        L_0x011e:
            java.lang.String r6 = "response_info_extras"
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x014c
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzgG
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0148
            org.json.JSONObject r6 = com.google.android.gms.ads.internal.util.zzbr.zzi(r35)     // Catch:{ IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0144 }
            android.os.Bundle r6 = com.google.android.gms.ads.internal.util.zzbr.zza(r6)     // Catch:{ IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0144 }
            if (r6 == 0) goto L_0x00ee
            r2 = r6
            goto L_0x00ee
        L_0x0144:
            r35.skipValue()
            goto L_0x00ee
        L_0x0148:
            r35.skipValue()
            goto L_0x00ee
        L_0x014c:
            java.lang.String r6 = "adRequestPostBody"
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x0171
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zziS
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x016c
            java.lang.String r6 = r35.nextString()
            r15 = r6
            goto L_0x00ee
        L_0x016c:
            r35.skipValue()
            goto L_0x00ee
        L_0x0171:
            java.lang.String r6 = "adRequestUrl"
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x0197
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zziS
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0192
            java.lang.String r6 = r35.nextString()
            r14 = r6
            goto L_0x00ee
        L_0x0192:
            r35.skipValue()
            goto L_0x00ee
        L_0x0197:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zziT
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x01b7
            java.lang.String r6 = "adResponseBody"
            boolean r6 = java.util.Objects.equals(r13, r6)
            if (r6 == 0) goto L_0x01b7
            java.lang.String r5 = r35.nextString()
            goto L_0x00ee
        L_0x01b7:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zziT
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x01d7
            java.lang.String r6 = "adResponseHeaders"
            boolean r6 = java.util.Objects.equals(r13, r6)
            if (r6 == 0) goto L_0x01d7
            org.json.JSONObject r3 = com.google.android.gms.ads.internal.util.zzbr.zzi(r35)
            goto L_0x00ee
        L_0x01d7:
            java.lang.String r6 = "max_parallel_renderers"
            boolean r6 = java.util.Objects.equals(r13, r6)
            if (r6 == 0) goto L_0x01ea
            int r6 = r35.nextInt()
            r7 = 1
            int r29 = java.lang.Math.max(r7, r6)
            goto L_0x00ee
        L_0x01ea:
            r7 = 1
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzja
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x020b
            java.lang.String r6 = "inspector_ad_transaction_extras"
            boolean r6 = java.util.Objects.equals(r13, r6)
            if (r6 == 0) goto L_0x020b
            org.json.JSONObject r4 = com.google.android.gms.ads.internal.util.zzbr.zzi(r35)
            goto L_0x00ee
        L_0x020b:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzcj
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x024c
            java.lang.String r6 = "latency_extras"
            boolean r6 = java.util.Objects.equals(r13, r6)
            if (r6 == 0) goto L_0x024c
            org.json.JSONObject r6 = com.google.android.gms.ads.internal.util.zzbr.zzi(r35)     // Catch:{ IOException | JSONException -> 0x00ee, IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0247 }
            android.os.Bundle r6 = com.google.android.gms.ads.internal.util.zzbr.zza(r6)     // Catch:{ IOException | JSONException -> 0x00ee, IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0247 }
            if (r6 == 0) goto L_0x00ee
            java.lang.String r7 = "start_time"
            double r32 = r6.getDouble(r7)     // Catch:{ IOException | JSONException -> 0x00ee, IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0247 }
            long r24 = zza(r32)     // Catch:{ IOException | JSONException -> 0x00ee, IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0247 }
            java.lang.String r7 = "end_time"
            double r6 = r6.getDouble(r7)     // Catch:{ IOException | JSONException -> 0x00ee, IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0247 }
            long r6 = zza(r6)     // Catch:{ IOException | JSONException -> 0x00ee, IOException | JSONException -> 0x00ee, IllegalStateException -> 0x0247 }
            r22 = r6
            goto L_0x00ee
        L_0x0247:
            r35.skipValue()
            goto L_0x00ee
        L_0x024c:
            r35.skipValue()
            goto L_0x00ee
        L_0x0251:
            r31 = r6
            r35.endObject()
            r0.zza = r1
            r0.zzc = r11
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.internal.ads.zzbet.zzd
            java.lang.Object r1 = r1.zze()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x026c
            r1 = -1
            r0.zzd = r1
            goto L_0x028f
        L_0x026c:
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.internal.ads.zzbeb.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            long r6 = r1.longValue()
            int r1 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x028b
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.internal.ads.zzbeb.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            int r1 = r1.intValue()
            r0.zzd = r1
            goto L_0x028f
        L_0x028b:
            r13 = r28
            r0.zzd = r13
        L_0x028f:
            r0.zzb = r8
            r0.zze = r9
            r0.zzf = r12
            r11 = r26
            r0.zzg = r11
            r1 = r21
            r0.zzj = r1
            r9 = r20
            r0.zzh = r9
            r0.zzi = r10
            r0.zzk = r2
            r0.zzl = r14
            r0.zzm = r15
            r0.zzn = r5
            r0.zzo = r3
            r0.zzp = r4
            r6 = r31
            r0.zzq = r6
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.internal.ads.zzber.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 <= 0) goto L_0x02cf
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.internal.ads.zzber.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            int r29 = r1.intValue()
        L_0x02cf:
            r1 = r29
            r0.zzr = r1
            r5 = r24
            r0.zzs = r5
            r5 = r22
            r0.zzt = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfew.<init>(android.util.JsonReader):void");
    }

    private static final long zza(double d) {
        if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
            return -1;
        }
        return (long) d;
    }
}
