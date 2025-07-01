package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcds implements zzbjr {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzm.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r17, java.util.Map r18) {
        /*
            r16 = this;
            r0 = r18
            r1 = r17
            com.google.android.gms.internal.ads.zzccf r1 = (com.google.android.gms.internal.ads.zzccf) r1
            r2 = 3
            boolean r2 = com.google.android.gms.ads.internal.util.zze.zzm(r2)
            if (r2 == 0) goto L_0x0024
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r0)
            java.lang.String r3 = "google.afma.Notify_dt"
            r2.remove(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Precache GMSG: "
            java.lang.String r2 = r3.concat(r2)
            com.google.android.gms.ads.internal.util.client.zzm.zze(r2)
        L_0x0024:
            com.google.android.gms.internal.ads.zzcdk r2 = com.google.android.gms.ads.internal.zzv.zzz()
            java.lang.String r3 = "abort"
            boolean r3 = r0.containsKey(r3)
            if (r3 == 0) goto L_0x003c
            boolean r0 = r2.zzd(r1)
            if (r0 != 0) goto L_0x01a0
            java.lang.String r0 = "Precache abort but no precache task running."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        L_0x003c:
            java.lang.String r3 = "src"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "periodicReportIntervalMs"
            java.lang.Integer r4 = zzb(r0, r4)
            java.lang.String r5 = "exoPlayerRenderingIntervalMs"
            java.lang.Integer r5 = zzb(r0, r5)
            java.lang.String r6 = "exoPlayerIdleIntervalMs"
            java.lang.Integer r6 = zzb(r0, r6)
            com.google.android.gms.internal.ads.zzcce r7 = new com.google.android.gms.internal.ads.zzcce
            java.lang.String r8 = "flags"
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r7.<init>(r8)
            boolean r8 = r7.zzk
            if (r3 == 0) goto L_0x015c
            r9 = 1
            java.lang.String[] r10 = new java.lang.String[r9]
            r11 = 0
            r10[r11] = r3
            java.lang.String r12 = "demuxed"
            java.lang.Object r12 = r0.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            r13 = 0
            if (r12 == 0) goto L_0x00a5
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0098 }
            r10.<init>(r12)     // Catch:{ JSONException -> 0x0098 }
            int r14 = r10.length()     // Catch:{ JSONException -> 0x0098 }
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ JSONException -> 0x0098 }
            r17 = r11
            r15 = r17
        L_0x0087:
            int r11 = r10.length()     // Catch:{ JSONException -> 0x009a }
            if (r15 >= r11) goto L_0x0096
            java.lang.String r11 = r10.getString(r15)     // Catch:{ JSONException -> 0x009a }
            r14[r15] = r11     // Catch:{ JSONException -> 0x009a }
            int r15 = r15 + 1
            goto L_0x0087
        L_0x0096:
            r10 = r14
            goto L_0x00a7
        L_0x0098:
            r17 = r11
        L_0x009a:
            java.lang.String r10 = "Malformed demuxed URL list for precache: "
            java.lang.String r10 = r10.concat(r12)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)
            r10 = r13
            goto L_0x00a7
        L_0x00a5:
            r17 = r11
        L_0x00a7:
            if (r10 != 0) goto L_0x00ad
            java.lang.String[] r10 = new java.lang.String[r9]
            r10[r17] = r3
        L_0x00ad:
            if (r8 == 0) goto L_0x00cf
            java.util.Iterator r2 = r2.iterator()
        L_0x00b3:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x00d3
            java.lang.Object r8 = r2.next()
            com.google.android.gms.internal.ads.zzcdj r8 = (com.google.android.gms.internal.ads.zzcdj) r8
            com.google.android.gms.internal.ads.zzccf r9 = r8.zza
            if (r9 != r1) goto L_0x00b3
            java.lang.String r9 = r8.zze()
            boolean r9 = r3.equals(r9)
            if (r9 == 0) goto L_0x00b3
            r13 = r8
            goto L_0x00d3
        L_0x00cf:
            com.google.android.gms.internal.ads.zzcdj r13 = r2.zza(r1)
        L_0x00d3:
            if (r13 == 0) goto L_0x00db
            java.lang.String r0 = "Precache task is already running."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        L_0x00db:
            com.google.android.gms.ads.internal.zza r2 = r1.zzj()
            if (r2 != 0) goto L_0x00e7
            java.lang.String r0 = "Precache requires a dependency provider."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        L_0x00e7:
            java.lang.String r2 = "player"
            java.lang.Integer r2 = zzb(r0, r2)
            if (r2 != 0) goto L_0x00f3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
        L_0x00f3:
            if (r4 == 0) goto L_0x00fc
            int r4 = r4.intValue()
            r1.zzA(r4)
        L_0x00fc:
            if (r5 == 0) goto L_0x0105
            int r4 = r5.intValue()
            r1.zzy(r4)
        L_0x0105:
            if (r6 == 0) goto L_0x010e
            int r4 = r6.intValue()
            r1.zzx(r4)
        L_0x010e:
            int r2 = r2.intValue()
            com.google.android.gms.ads.internal.zza r4 = r1.zzj()
            com.google.android.gms.internal.ads.zzcdc r4 = r4.zzb
            if (r2 <= 0) goto L_0x014e
            int r2 = r7.zzg
            int r4 = com.google.android.gms.internal.ads.zzcbw.zzu()
            if (r4 >= r2) goto L_0x0128
            com.google.android.gms.internal.ads.zzcea r2 = new com.google.android.gms.internal.ads.zzcea
            r2.<init>(r1, r7)
            goto L_0x0153
        L_0x0128:
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzn
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r5.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x013e
            int r4 = com.google.android.gms.internal.ads.zzcdx.zzi()
        L_0x013e:
            int r2 = r7.zzb
            if (r4 >= r2) goto L_0x0148
            com.google.android.gms.internal.ads.zzcdx r2 = new com.google.android.gms.internal.ads.zzcdx
            r2.<init>(r1, r7)
            goto L_0x0153
        L_0x0148:
            com.google.android.gms.internal.ads.zzcdv r2 = new com.google.android.gms.internal.ads.zzcdv
            r2.<init>(r1)
            goto L_0x0153
        L_0x014e:
            com.google.android.gms.internal.ads.zzcdu r2 = new com.google.android.gms.internal.ads.zzcdu
            r2.<init>(r1)
        L_0x0153:
            com.google.android.gms.internal.ads.zzcdj r4 = new com.google.android.gms.internal.ads.zzcdj
            r4.<init>(r1, r2, r3, r10)
            r4.zzb()
            goto L_0x0164
        L_0x015c:
            com.google.android.gms.internal.ads.zzcdj r1 = r2.zza(r1)
            if (r1 == 0) goto L_0x01a1
            com.google.android.gms.internal.ads.zzcdr r2 = r1.zzb
        L_0x0164:
            java.lang.String r1 = "minBufferMs"
            java.lang.Integer r1 = zzb(r0, r1)
            if (r1 == 0) goto L_0x0173
            int r1 = r1.intValue()
            r2.zzs(r1)
        L_0x0173:
            java.lang.String r1 = "maxBufferMs"
            java.lang.Integer r1 = zzb(r0, r1)
            if (r1 == 0) goto L_0x0182
            int r1 = r1.intValue()
            r2.zzr(r1)
        L_0x0182:
            java.lang.String r1 = "bufferForPlaybackMs"
            java.lang.Integer r1 = zzb(r0, r1)
            if (r1 == 0) goto L_0x0191
            int r1 = r1.intValue()
            r2.zzp(r1)
        L_0x0191:
            java.lang.String r1 = "bufferForPlaybackAfterRebufferMs"
            java.lang.Integer r0 = zzb(r0, r1)
            if (r0 == 0) goto L_0x01a0
            int r0 = r0.intValue()
            r2.zzq(r0)
        L_0x01a0:
            return
        L_0x01a1:
            java.lang.String r0 = "Precache must specify a source."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcds.zza(java.lang.Object, java.util.Map):void");
    }
}
