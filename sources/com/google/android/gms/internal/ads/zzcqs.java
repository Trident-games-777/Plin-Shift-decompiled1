package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcqs implements zzaym {
    private final zzcfk zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    zzcqs(zzcfk zzcfk, Executor executor) {
        this.zza = zzcfk;
        this.zzb = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdp(com.google.android.gms.internal.ads.zzayl r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzcfk r0 = r3.zza     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzmm     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x006b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0018
            goto L_0x0069
        L_0x0018:
            boolean r0 = r4.zzj     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzc     // Catch:{ all -> 0x006b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x006b }
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x006b }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            java.util.concurrent.Executor r4 = r3.zzb     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzcfk r0 = r3.zza     // Catch:{ all -> 0x006b }
            java.util.Objects.requireNonNull(r0)     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzcqq r1 = new com.google.android.gms.internal.ads.zzcqq     // Catch:{ all -> 0x006b }
            r1.<init>(r0)     // Catch:{ all -> 0x006b }
            r4.execute(r1)     // Catch:{ all -> 0x006b }
            monitor-exit(r3)
            return
        L_0x0041:
            boolean r4 = r4.zzj     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.atomic.AtomicReference r4 = r3.zzc     // Catch:{ all -> 0x006b }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x006b }
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x006b }
            java.lang.Object r4 = r4.getAndSet(r1)     // Catch:{ all -> 0x006b }
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.Executor r4 = r3.zzb     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzcfk r0 = r3.zza     // Catch:{ all -> 0x006b }
            java.util.Objects.requireNonNull(r0)     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzcqr r1 = new com.google.android.gms.internal.ads.zzcqr     // Catch:{ all -> 0x006b }
            r1.<init>(r0)     // Catch:{ all -> 0x006b }
            r4.execute(r1)     // Catch:{ all -> 0x006b }
            monitor-exit(r3)
            return
        L_0x0069:
            monitor-exit(r3)
            return
        L_0x006b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x006b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqs.zzdp(com.google.android.gms.internal.ads.zzayl):void");
    }
}
