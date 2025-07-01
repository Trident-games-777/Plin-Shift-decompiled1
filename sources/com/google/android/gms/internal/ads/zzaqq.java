package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaqq extends zzaqd {
    public zzaqq() {
        throw null;
    }

    public zzaqq(zzaqp zzaqp, SSLSocketFactory sSLSocketFactory) {
    }

    static List zzb(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzaph : (List) entry.getValue()) {
                    arrayList.add(new zzaph((String) entry.getKey(), zzaph));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaqn zza(com.google.android.gms.internal.ads.zzapp r9, java.util.Map r10) throws java.io.IOException, com.google.android.gms.internal.ads.zzaox {
        /*
            r8 = this;
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = r9.zzk()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r2.putAll(r10)
            java.util.Map r10 = r9.zzl()
            r2.putAll(r10)
            java.net.URL r10 = new java.net.URL
            r10.<init>(r1)
            java.net.URLConnection r1 = r10.openConnection()
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            boolean r3 = java.net.HttpURLConnection.getFollowRedirects()
            r1.setInstanceFollowRedirects(r3)
            int r3 = r9.zzb()
            r1.setConnectTimeout(r3)
            r1.setReadTimeout(r3)
            r3 = 0
            r1.setUseCaches(r3)
            r4 = 1
            r1.setDoInput(r4)
            java.lang.String r10 = r10.getProtocol()
            java.lang.String r5 = "https"
            r5.equals(r10)
            java.lang.String r10 = "application/x-www-form-urlencoded; charset=UTF-8"
            java.util.Set r5 = r2.keySet()     // Catch:{ all -> 0x00e6 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00e6 }
        L_0x004c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00e6 }
            if (r6 == 0) goto L_0x0062
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00e6 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00e6 }
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x00e6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00e6 }
            r1.setRequestProperty(r6, r7)     // Catch:{ all -> 0x00e6 }
            goto L_0x004c
        L_0x0062:
            int r2 = r9.zza()     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x0093
            java.lang.String r2 = "POST"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x00e6 }
            byte[] r2 = r9.zzx()     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x0098
            r1.setDoOutput(r4)     // Catch:{ all -> 0x00e6 }
            java.util.Map r5 = r1.getRequestProperties()     // Catch:{ all -> 0x00e6 }
            boolean r5 = r5.containsKey(r0)     // Catch:{ all -> 0x00e6 }
            if (r5 != 0) goto L_0x0083
            r1.setRequestProperty(r0, r10)     // Catch:{ all -> 0x00e6 }
        L_0x0083:
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x00e6 }
            java.io.OutputStream r0 = r1.getOutputStream()     // Catch:{ all -> 0x00e6 }
            r10.<init>(r0)     // Catch:{ all -> 0x00e6 }
            r10.write(r2)     // Catch:{ all -> 0x00e6 }
            r10.close()     // Catch:{ all -> 0x00e6 }
            goto L_0x0098
        L_0x0093:
            java.lang.String r10 = "GET"
            r1.setRequestMethod(r10)     // Catch:{ all -> 0x00e6 }
        L_0x0098:
            int r10 = r1.getResponseCode()     // Catch:{ all -> 0x00e6 }
            r0 = -1
            if (r10 == r0) goto L_0x00de
            r9.zza()     // Catch:{ all -> 0x00e6 }
            r9 = 100
            if (r10 < r9) goto L_0x00aa
            r9 = 200(0xc8, float:2.8E-43)
            if (r10 < r9) goto L_0x00cc
        L_0x00aa:
            r9 = 204(0xcc, float:2.86E-43)
            if (r10 == r9) goto L_0x00cc
            r9 = 304(0x130, float:4.26E-43)
            if (r10 == r9) goto L_0x00cc
            com.google.android.gms.internal.ads.zzaqn r9 = new com.google.android.gms.internal.ads.zzaqn     // Catch:{ all -> 0x00c9 }
            java.util.Map r0 = r1.getHeaderFields()     // Catch:{ all -> 0x00c9 }
            java.util.List r0 = zzb(r0)     // Catch:{ all -> 0x00c9 }
            int r2 = r1.getContentLength()     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzaqo r3 = new com.google.android.gms.internal.ads.zzaqo     // Catch:{ all -> 0x00c9 }
            r3.<init>(r1)     // Catch:{ all -> 0x00c9 }
            r9.<init>(r10, r0, r2, r3)     // Catch:{ all -> 0x00c9 }
            return r9
        L_0x00c9:
            r9 = move-exception
            r3 = r4
            goto L_0x00e7
        L_0x00cc:
            com.google.android.gms.internal.ads.zzaqn r9 = new com.google.android.gms.internal.ads.zzaqn     // Catch:{ all -> 0x00e6 }
            java.util.Map r2 = r1.getHeaderFields()     // Catch:{ all -> 0x00e6 }
            java.util.List r2 = zzb(r2)     // Catch:{ all -> 0x00e6 }
            r4 = 0
            r9.<init>(r10, r2, r0, r4)     // Catch:{ all -> 0x00e6 }
            r1.disconnect()
            return r9
        L_0x00de:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x00e6 }
            java.lang.String r10 = "Could not retrieve response code from HttpUrlConnection."
            r9.<init>(r10)     // Catch:{ all -> 0x00e6 }
            throw r9     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r9 = move-exception
        L_0x00e7:
            if (r3 != 0) goto L_0x00ec
            r1.disconnect()
        L_0x00ec:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqq.zza(com.google.android.gms.internal.ads.zzapp, java.util.Map):com.google.android.gms.internal.ads.zzaqn");
    }
}
