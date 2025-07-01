package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfhy {
    private final zzfhc zza;
    private final zzfhw zzb;
    private final zzfgy zzc;
    /* access modifiers changed from: private */
    public final ArrayDeque zzd;
    /* access modifiers changed from: private */
    public zzfie zze;
    /* access modifiers changed from: private */
    public int zzf = 1;

    public zzfhy(zzfhc zzfhc, zzfgy zzfgy, zzfhw zzfhw) {
        this.zza = zzfhc;
        this.zzc = zzfgy;
        this.zzb = zzfhw;
        this.zzd = new ArrayDeque();
        zzfgy.zzb(new zzfht(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzgf     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x006e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x006e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzbzz r0 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ all -> 0x006e }
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzi()     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzbzt r0 = r0.zzg()     // Catch:{ all -> 0x006e }
            boolean r0 = r0.zzh()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0026
            goto L_0x002d
        L_0x0026:
            java.util.ArrayDeque r0 = r4.zzd     // Catch:{ all -> 0x006e }
            r0.clear()     // Catch:{ all -> 0x006e }
            monitor-exit(r4)
            return
        L_0x002d:
            boolean r0 = r4.zzi()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x006c
        L_0x0033:
            java.util.ArrayDeque r0 = r4.zzd     // Catch:{ all -> 0x006e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x006c
            java.util.ArrayDeque r0 = r4.zzd     // Catch:{ all -> 0x006e }
            java.lang.Object r0 = r0.pollFirst()     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhx r0 = (com.google.android.gms.internal.ads.zzfhx) r0     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0057
            com.google.android.gms.internal.ads.zzfhm r1 = r0.zza()     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzfhc r1 = r4.zza     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhm r2 = r0.zza()     // Catch:{ all -> 0x006e }
            boolean r1 = r1.zze(r2)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0033
        L_0x0057:
            com.google.android.gms.internal.ads.zzfhc r1 = r4.zza     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhw r2 = r4.zzb     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfie r3 = new com.google.android.gms.internal.ads.zzfie     // Catch:{ all -> 0x006e }
            r3.<init>(r1, r2, r0)     // Catch:{ all -> 0x006e }
            r4.zze = r3     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhu r1 = new com.google.android.gms.internal.ads.zzfhu     // Catch:{ all -> 0x006e }
            r1.<init>(r4, r0)     // Catch:{ all -> 0x006e }
            r3.zzd(r1)     // Catch:{ all -> 0x006e }
            monitor-exit(r4)
            return
        L_0x006c:
            monitor-exit(r4)
            return
        L_0x006e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhy.zzh():void");
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized ListenableFuture zza(zzfhx zzfhx) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzfhx);
    }

    public final synchronized void zze(zzfhx zzfhx) {
        this.zzd.add(zzfhx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
