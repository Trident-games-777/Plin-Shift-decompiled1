package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzo extends LinkedHashMap {
    final /* synthetic */ zzq zza;

    zzo(zzq zzq) {
        this.zza = zzq;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean removeEldestEntry(java.util.Map.Entry r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r0 = r5.zza
            monitor-enter(r0)
            int r1 = r5.size()     // Catch:{ all -> 0x003b }
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r2 = r5.zza     // Catch:{ all -> 0x003b }
            int r3 = r2.zza     // Catch:{ all -> 0x003b }
            r4 = 0
            if (r1 > r3) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r4
        L_0x0012:
            java.util.ArrayDeque r1 = r2.zzf     // Catch:{ all -> 0x003b }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x003b }
            java.lang.Object r3 = r6.getKey()     // Catch:{ all -> 0x003b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x003b }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x003b }
            com.google.android.gms.ads.nonagon.signalgeneration.zzp r6 = (com.google.android.gms.ads.nonagon.signalgeneration.zzp) r6     // Catch:{ all -> 0x003b }
            java.lang.String r6 = r6.zzb     // Catch:{ all -> 0x003b }
            r2.<init>(r3, r6)     // Catch:{ all -> 0x003b }
            r1.add(r2)     // Catch:{ all -> 0x003b }
            int r6 = r5.size()     // Catch:{ all -> 0x003b }
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r1 = r5.zza     // Catch:{ all -> 0x003b }
            int r1 = r1.zza     // Catch:{ all -> 0x003b }
            if (r6 <= r1) goto L_0x0039
            r4 = 1
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r4
        L_0x003b:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzo.removeEldestEntry(java.util.Map$Entry):boolean");
    }
}
