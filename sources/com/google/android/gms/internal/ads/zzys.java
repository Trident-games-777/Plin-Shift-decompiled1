package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzys {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyl[] zzd = new zzyl[100];

    public zzys(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzyl zzb() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.zzb     // Catch:{ all -> 0x003b }
            int r0 = r0 + 1
            r5.zzb = r0     // Catch:{ all -> 0x003b }
            int r0 = r5.zzc     // Catch:{ all -> 0x003b }
            if (r0 <= 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzyl[] r1 = r5.zzd     // Catch:{ all -> 0x003b }
            int r0 = r0 + -1
            r5.zzc = r0     // Catch:{ all -> 0x003b }
            r2 = r1[r0]     // Catch:{ all -> 0x003b }
            r3 = 0
            if (r2 == 0) goto L_0x001c
            r4 = r2
            com.google.android.gms.internal.ads.zzyl r4 = (com.google.android.gms.internal.ads.zzyl) r4     // Catch:{ all -> 0x003b }
            r1[r0] = r3     // Catch:{ all -> 0x003b }
            goto L_0x002e
        L_0x001c:
            throw r3     // Catch:{ all -> 0x003b }
        L_0x001d:
            com.google.android.gms.internal.ads.zzyl r2 = new com.google.android.gms.internal.ads.zzyl     // Catch:{ all -> 0x003b }
            r0 = 65536(0x10000, float:9.18355E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x003b }
            r1 = 0
            r2.<init>(r0, r1)     // Catch:{ all -> 0x003b }
            int r0 = r5.zzb     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.ads.zzyl[] r1 = r5.zzd     // Catch:{ all -> 0x003b }
            int r3 = r1.length     // Catch:{ all -> 0x003b }
            if (r0 > r3) goto L_0x0030
        L_0x002e:
            monitor-exit(r5)
            return r2
        L_0x0030:
            int r3 = r3 + r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r3)     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.ads.zzyl[] r0 = (com.google.android.gms.internal.ads.zzyl[]) r0     // Catch:{ all -> 0x003b }
            r5.zzd = r0     // Catch:{ all -> 0x003b }
            monitor-exit(r5)
            return r2
        L_0x003b:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzys.zzb():com.google.android.gms.internal.ads.zzyl");
    }

    public final synchronized void zzc(zzyl zzyl) {
        zzyl[] zzylArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzylArr[i] = zzyl;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzym zzym) {
        while (zzym != null) {
            zzyl[] zzylArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzylArr[i] = zzym.zzc();
            this.zzb--;
            zzym = zzym.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i = this.zza;
        int i2 = zzen.zza;
        int max = Math.max(0, ((i + 65535) / 65536) - this.zzb);
        int i3 = this.zzc;
        if (max < i3) {
            Arrays.fill(this.zzd, max, i3, (Object) null);
            this.zzc = max;
        }
    }
}
