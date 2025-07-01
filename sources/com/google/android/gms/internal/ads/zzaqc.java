package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaqc implements zzapo {
    private final Map zza = new HashMap();
    private final zzapb zzb;
    private final BlockingQueue zzc;
    private final zzapg zzd;

    zzaqc(zzapb zzapb, BlockingQueue blockingQueue, zzapg zzapg) {
        this.zzd = zzapg;
        this.zzb = zzapb;
        this.zzc = blockingQueue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzapp r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r4.zzj()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.remove(r4)     // Catch:{ all -> 0x005e }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x005c
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x005c
            boolean r1 = com.google.android.gms.internal.ads.zzaqb.zzb     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x002a
            int r1 = r0.size()     // Catch:{ all -> 0x005e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x005e }
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r4}     // Catch:{ all -> 0x005e }
            java.lang.String r2 = "%d waiting requests for cacheKey=%s; resend to network"
            com.google.android.gms.internal.ads.zzaqb.zzd(r2, r1)     // Catch:{ all -> 0x005e }
        L_0x002a:
            r1 = 0
            java.lang.Object r1 = r0.remove(r1)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzapp r1 = (com.google.android.gms.internal.ads.zzapp) r1     // Catch:{ all -> 0x005e }
            java.util.Map r2 = r3.zza     // Catch:{ all -> 0x005e }
            r2.put(r4, r0)     // Catch:{ all -> 0x005e }
            r1.zzu(r3)     // Catch:{ all -> 0x005e }
            java.util.concurrent.BlockingQueue r4 = r3.zzc     // Catch:{ InterruptedException -> 0x0040 }
            r4.put(r1)     // Catch:{ InterruptedException -> 0x0040 }
            monitor-exit(r3)
            return
        L_0x0040:
            r4 = move-exception
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005e }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x005e }
            java.lang.String r0 = "Couldn't add request to queue. %s"
            com.google.android.gms.internal.ads.zzaqb.zzb(r0, r4)     // Catch:{ all -> 0x005e }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005e }
            r4.interrupt()     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzapb r4 = r3.zzb     // Catch:{ all -> 0x005e }
            r4.zzb()     // Catch:{ all -> 0x005e }
            monitor-exit(r3)
            return
        L_0x005c:
            monitor-exit(r3)
            return
        L_0x005e:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqc.zza(com.google.android.gms.internal.ads.zzapp):void");
    }

    public final void zzb(zzapp zzapp, zzapv zzapv) {
        List<zzapp> list;
        zzaoy zzaoy = zzapv.zzb;
        if (zzaoy == null || zzaoy.zza(System.currentTimeMillis())) {
            zza(zzapp);
            return;
        }
        String zzj = zzapp.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(zzj);
        }
        if (list != null) {
            if (zzaqb.zzb) {
                zzaqb.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), zzj);
            }
            for (zzapp zzb2 : list) {
                this.zzd.zzb(zzb2, zzapv, (Runnable) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzc(com.google.android.gms.internal.ads.zzapp r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = r4.zzj()     // Catch:{ all -> 0x0052 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0039
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0052 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x001c
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r0.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001c:
            java.lang.String r2 = "waiting-for-response"
            r4.zzm(r2)     // Catch:{ all -> 0x0052 }
            r0.add(r4)     // Catch:{ all -> 0x0052 }
            java.util.Map r4 = r3.zza     // Catch:{ all -> 0x0052 }
            r4.put(r1, r0)     // Catch:{ all -> 0x0052 }
            boolean r4 = com.google.android.gms.internal.ads.zzaqb.zzb     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0036
            java.lang.Object[] r4 = new java.lang.Object[]{r1}     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "Request for cacheKey=%s is in flight, putting on hold."
            com.google.android.gms.internal.ads.zzaqb.zza(r0, r4)     // Catch:{ all -> 0x0052 }
        L_0x0036:
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0039:
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0052 }
            r2 = 0
            r0.put(r1, r2)     // Catch:{ all -> 0x0052 }
            r4.zzu(r3)     // Catch:{ all -> 0x0052 }
            boolean r4 = com.google.android.gms.internal.ads.zzaqb.zzb     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x004f
            java.lang.Object[] r4 = new java.lang.Object[]{r1}     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "new request, sending to network %s"
            com.google.android.gms.internal.ads.zzaqb.zza(r0, r4)     // Catch:{ all -> 0x0052 }
        L_0x004f:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x0052:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqc.zzc(com.google.android.gms.internal.ads.zzapp):boolean");
    }
}
