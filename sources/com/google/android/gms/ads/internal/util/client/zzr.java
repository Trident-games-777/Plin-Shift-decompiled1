package com.google.android.gms.ads.internal.util.client;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzr implements zze {
    private final String zza;

    public zzr() {
        throw null;
    }

    public zzr(String str) {
        this.zza = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d9, code lost:
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() == false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ". "
            java.lang.String r1 = "Received non-success response code "
            java.lang.String r2 = "Error while pinging URL: "
            java.lang.String r3 = "Error while parsing ping URL: "
            java.lang.String r4 = "Pinging URL: "
            r5 = 0
            boolean r6 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            if (r6 == 0) goto L_0x0016
            r6 = 263(0x107, float:3.69E-43)
            android.net.TrafficStats.setThreadStatsTag(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
        L_0x0016:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            r6.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            r6.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.lang.String r4 = r6.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.URI r4 = new java.net.URI     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            r4.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.URL r4 = r4.toURL()     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ all -> 0x0095 }
            java.lang.String r6 = r9.zza     // Catch:{ all -> 0x0095 }
            r7 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r7)     // Catch:{ all -> 0x0095 }
            r8 = 1
            r4.setInstanceFollowRedirects(r8)     // Catch:{ all -> 0x0095 }
            r4.setReadTimeout(r7)     // Catch:{ all -> 0x0095 }
            if (r6 == 0) goto L_0x004d
            java.lang.String r7 = "User-Agent"
            r4.setRequestProperty(r7, r6)     // Catch:{ all -> 0x0095 }
        L_0x004d:
            r4.setUseCaches(r5)     // Catch:{ all -> 0x0095 }
            com.google.android.gms.ads.internal.util.client.zzl r6 = new com.google.android.gms.ads.internal.util.client.zzl     // Catch:{ all -> 0x0095 }
            r7 = 0
            r6.<init>(r7)     // Catch:{ all -> 0x0095 }
            r6.zzc(r4, r7)     // Catch:{ all -> 0x0095 }
            int r7 = r4.getResponseCode()     // Catch:{ all -> 0x0095 }
            r6.zze(r4, r7)     // Catch:{ all -> 0x0095 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r7 < r6) goto L_0x006b
            r6 = 300(0x12c, float:4.2E-43)
            if (r7 < r6) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r5 = r8
            goto L_0x0082
        L_0x006b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r6.<init>(r1)     // Catch:{ all -> 0x0095 }
            r6.append(r7)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = " from pinging URL: "
            r6.append(r1)     // Catch:{ all -> 0x0095 }
            r6.append(r10)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0095 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r1)     // Catch:{ all -> 0x0095 }
        L_0x0082:
            r4.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto L_0x008c
            goto L_0x00db
        L_0x008c:
            return r5
        L_0x008d:
            r1 = move-exception
            goto L_0x009c
        L_0x008f:
            r1 = move-exception
            goto L_0x009c
        L_0x0091:
            r1 = move-exception
            goto L_0x00bc
        L_0x0093:
            r1 = move-exception
            goto L_0x00bc
        L_0x0095:
            r1 = move-exception
            r4.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            throw r1     // Catch:{ IndexOutOfBoundsException -> 0x0093, URISyntaxException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
        L_0x009a:
            r10 = move-exception
            goto L_0x00df
        L_0x009c:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r3.<init>(r2)     // Catch:{ all -> 0x009a }
            r3.append(r10)     // Catch:{ all -> 0x009a }
            r3.append(r0)     // Catch:{ all -> 0x009a }
            r3.append(r1)     // Catch:{ all -> 0x009a }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x009a }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)     // Catch:{ all -> 0x009a }
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto L_0x00de
            goto L_0x00db
        L_0x00bc:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r2.<init>(r3)     // Catch:{ all -> 0x009a }
            r2.append(r10)     // Catch:{ all -> 0x009a }
            r2.append(r0)     // Catch:{ all -> 0x009a }
            r2.append(r1)     // Catch:{ all -> 0x009a }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x009a }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)     // Catch:{ all -> 0x009a }
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto L_0x00de
        L_0x00db:
            android.net.TrafficStats.clearThreadStatsTag()
        L_0x00de:
            return r5
        L_0x00df:
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x00e8
            android.net.TrafficStats.clearThreadStatsTag()
        L_0x00e8:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.zzr.zza(java.lang.String):boolean");
    }
}
