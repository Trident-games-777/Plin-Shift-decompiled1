package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzauv implements Runnable {
    final /* synthetic */ zzauw zza;

    zzauv(zzauw zzauw) {
        this.zza = zzauw;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:9|(2:10|11)|(2:15|16)|17|18|19|20|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzauw r0 = r6.zza
            java.lang.Boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0007
            goto L_0x0047
        L_0x0007:
            android.os.ConditionVariable r0 = com.google.android.gms.internal.ads.zzauw.zzc
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzauw r1 = r6.zza     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r1 = r1.zzb     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0014:
            r1 = 0
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.internal.ads.zzbcn.zzcE     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.Object r2 = r2.zze()     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ IllegalStateException -> 0x0022 }
            boolean r2 = r2.booleanValue()     // Catch:{ IllegalStateException -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            if (r2 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzauw r3 = r6.zza     // Catch:{ all -> 0x0037 }
            com.google.android.gms.internal.ads.zzawf r3 = r3.zze     // Catch:{ all -> 0x0037 }
            android.content.Context r3 = r3.zza     // Catch:{ all -> 0x0037 }
            java.lang.String r4 = "ADSHIELD"
            r5 = 0
            com.google.android.gms.internal.ads.zzfrr r3 = com.google.android.gms.internal.ads.zzfrr.zzb(r3, r4, r5)     // Catch:{ all -> 0x0037 }
            com.google.android.gms.internal.ads.zzauw.zza = r3     // Catch:{ all -> 0x0037 }
        L_0x0036:
            r1 = r2
        L_0x0037:
            com.google.android.gms.internal.ads.zzauw r2 = r6.zza     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0048 }
            r2.zzb = r1     // Catch:{ all -> 0x0048 }
            android.os.ConditionVariable r1 = com.google.android.gms.internal.ads.zzauw.zzc     // Catch:{ all -> 0x0048 }
            r1.open()     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
        L_0x0047:
            return
        L_0x0048:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauv.run():void");
    }
}
