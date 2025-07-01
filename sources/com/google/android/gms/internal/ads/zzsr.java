package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzsr {
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (zzb(r7, new android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60)) == 1) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.media.MediaCodecInfo.VideoCapabilities r3, int r4, int r5, double r6) {
        /*
            java.util.List r3 = r3.getSupportedPerformancePoints()
            r0 = 0
            if (r3 == 0) goto L_0x00a1
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x000f
            goto L_0x00a1
        L_0x000f:
            int r6 = (int) r6
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r7 = new android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint
            r7.<init>(r4, r5, r6)
            int r3 = zzb(r3, r7)
            r4 = 1
            if (r3 != r4) goto L_0x00a0
            java.lang.Boolean r5 = com.google.android.gms.internal.ads.zzss.zza
            if (r5 != 0) goto L_0x00a0
            int r5 = com.google.android.gms.internal.ads.zzen.zza
            r6 = 35
            if (r5 < r6) goto L_0x002a
        L_0x0028:
            r4 = r0
            goto L_0x008e
        L_0x002a:
            com.google.android.gms.internal.ads.zzab r5 = new com.google.android.gms.internal.ads.zzab     // Catch:{ zztf -> 0x008e }
            r5.<init>()     // Catch:{ zztf -> 0x008e }
            java.lang.String r6 = "video/avc"
            r5.zzZ(r6)     // Catch:{ zztf -> 0x008e }
            com.google.android.gms.internal.ads.zzad r5 = r5.zzaf()     // Catch:{ zztf -> 0x008e }
            java.lang.String r6 = r5.zzo     // Catch:{ zztf -> 0x008e }
            if (r6 == 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzta r6 = com.google.android.gms.internal.ads.zzta.zza     // Catch:{ zztf -> 0x008e }
            java.util.List r5 = com.google.android.gms.internal.ads.zztl.zze(r6, r5, r0, r0)     // Catch:{ zztf -> 0x008e }
            r6 = r0
        L_0x0043:
            int r7 = r5.size()     // Catch:{ zztf -> 0x008e }
            if (r6 >= r7) goto L_0x008e
            java.lang.Object r7 = r5.get(r6)     // Catch:{ zztf -> 0x008e }
            com.google.android.gms.internal.ads.zzsq r7 = (com.google.android.gms.internal.ads.zzsq) r7     // Catch:{ zztf -> 0x008e }
            android.media.MediaCodecInfo$CodecCapabilities r7 = r7.zzd     // Catch:{ zztf -> 0x008e }
            if (r7 == 0) goto L_0x008b
            java.lang.Object r7 = r5.get(r6)     // Catch:{ zztf -> 0x008e }
            com.google.android.gms.internal.ads.zzsq r7 = (com.google.android.gms.internal.ads.zzsq) r7     // Catch:{ zztf -> 0x008e }
            android.media.MediaCodecInfo$CodecCapabilities r7 = r7.zzd     // Catch:{ zztf -> 0x008e }
            android.media.MediaCodecInfo$VideoCapabilities r7 = r7.getVideoCapabilities()     // Catch:{ zztf -> 0x008e }
            if (r7 == 0) goto L_0x008b
            java.lang.Object r7 = r5.get(r6)     // Catch:{ zztf -> 0x008e }
            com.google.android.gms.internal.ads.zzsq r7 = (com.google.android.gms.internal.ads.zzsq) r7     // Catch:{ zztf -> 0x008e }
            android.media.MediaCodecInfo$CodecCapabilities r7 = r7.zzd     // Catch:{ zztf -> 0x008e }
            android.media.MediaCodecInfo$VideoCapabilities r7 = r7.getVideoCapabilities()     // Catch:{ zztf -> 0x008e }
            java.util.List r7 = r7.getSupportedPerformancePoints()     // Catch:{ zztf -> 0x008e }
            if (r7 == 0) goto L_0x008b
            boolean r1 = r7.isEmpty()     // Catch:{ zztf -> 0x008e }
            if (r1 != 0) goto L_0x008b
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r5 = new android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint     // Catch:{ zztf -> 0x008e }
            r6 = 720(0x2d0, float:1.009E-42)
            r1 = 60
            r2 = 1280(0x500, float:1.794E-42)
            r5.<init>(r2, r6, r1)     // Catch:{ zztf -> 0x008e }
            int r5 = zzb(r7, r5)     // Catch:{ zztf -> 0x008e }
            if (r5 != r4) goto L_0x0028
            goto L_0x008e
        L_0x008b:
            int r6 = r6 + 1
            goto L_0x0043
        L_0x008e:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.internal.ads.zzss.zza = r4
            java.lang.Boolean r4 = com.google.android.gms.internal.ads.zzss.zza
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00a0
            return r0
        L_0x00a0:
            return r3
        L_0x00a1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsr.zza(android.media.MediaCodecInfo$VideoCapabilities, int, int, double):int");
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
