package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzft {
    private final zzfr zza;
    private final AtomicLong zzb = new AtomicLong();
    private final ArrayDeque zzc;
    private final PriorityQueue zzd;
    private int zze;

    public zzft(zzfr zzfr) {
        this.zza = zzfr;
        this.zzc = new ArrayDeque();
        this.zzd = new PriorityQueue();
        this.zze = -1;
    }

    private final void zze(int i) {
        while (this.zzd.size() > i) {
            zzfs zzfs = (zzfs) this.zzd.poll();
            int i2 = zzen.zza;
            zzfs zzfs2 = zzfs;
            this.zza.zza(zzfs.zzb, zzfs.zza);
            this.zzc.push(zzfs);
        }
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r9 < com.google.android.gms.internal.ads.zzfs.zza(r0)) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(long r9, com.google.android.gms.internal.ads.zzed r11) {
        /*
            r8 = this;
            int r0 = r8.zze
            if (r0 == 0) goto L_0x0056
            r1 = -1
            if (r0 == r1) goto L_0x0027
            java.util.PriorityQueue r0 = r8.zzd
            int r0 = r0.size()
            int r2 = r8.zze
            if (r0 < r2) goto L_0x0027
            java.util.PriorityQueue r0 = r8.zzd
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzfs r0 = (com.google.android.gms.internal.ads.zzfs) r0
            int r2 = com.google.android.gms.internal.ads.zzen.zza
            r2 = r0
            com.google.android.gms.internal.ads.zzfs r2 = (com.google.android.gms.internal.ads.zzfs) r2
            long r2 = r0.zzb
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0027
            goto L_0x0056
        L_0x0027:
            java.util.ArrayDeque r0 = r8.zzc
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzfs r0 = new com.google.android.gms.internal.ads.zzfs
            r0.<init>()
            goto L_0x003d
        L_0x0035:
            java.util.ArrayDeque r0 = r8.zzc
            java.lang.Object r0 = r0.poll()
            com.google.android.gms.internal.ads.zzfs r0 = (com.google.android.gms.internal.ads.zzfs) r0
        L_0x003d:
            r2 = r0
            java.util.concurrent.atomic.AtomicLong r0 = r8.zzb
            long r5 = r0.getAndIncrement()
            r3 = r9
            r7 = r11
            r2.zzc(r3, r5, r7)
            java.util.PriorityQueue r9 = r8.zzd
            r9.add(r2)
            int r9 = r8.zze
            if (r9 == r1) goto L_0x0055
            r8.zze(r9)
        L_0x0055:
            return
        L_0x0056:
            r3 = r9
            r7 = r11
            com.google.android.gms.internal.ads.zzfr r9 = r8.zza
            r9.zza(r3, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzft.zzb(long, com.google.android.gms.internal.ads.zzed):void");
    }

    public final void zzc() {
        zze(0);
    }

    public final void zzd(int i) {
        zzdb.zzf(i >= 0);
        this.zze = i;
        zze(i);
    }
}
