package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public class zzgzt {
    protected volatile zzhai zza;
    private volatile zzgxp zzb;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgzt)) {
            return false;
        }
        zzgzt zzgzt = (zzgzt) obj;
        zzhai zzhai = this.zza;
        zzhai zzhai2 = zzgzt.zza;
        if (zzhai == null && zzhai2 == null) {
            return zzb().equals(zzgzt.zzb());
        }
        if (zzhai != null && zzhai2 != null) {
            return zzhai.equals(zzhai2);
        }
        if (zzhai != null) {
            zzgzt.zzd(zzhai.zzbt());
            return zzhai.equals(zzgzt.zza);
        }
        zzd(zzhai2.zzbt());
        return this.zza.equals(zzhai2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzgxm) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaY();
        }
        return 0;
    }

    public final zzgxp zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                zzgxp zzgxp = this.zzb;
                return zzgxp;
            }
            if (this.zza == null) {
                this.zzb = zzgxp.zzb;
            } else {
                this.zzb = this.zza.zzaN();
            }
            zzgxp zzgxp2 = this.zzb;
            return zzgxp2;
        }
    }

    public final zzhai zzc(zzhai zzhai) {
        zzhai zzhai2 = this.zza;
        this.zzb = null;
        this.zza = zzhai;
        return zzhai2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzhai r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzhai r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            goto L_0x001a
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzhai r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x000c:
            r1.zza = r2     // Catch:{ zzgzm -> 0x0013 }
            com.google.android.gms.internal.ads.zzgxp r0 = com.google.android.gms.internal.ads.zzgxp.zzb     // Catch:{ zzgzm -> 0x0013 }
            r1.zzb = r0     // Catch:{ zzgzm -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgxp r2 = com.google.android.gms.internal.ads.zzgxp.zzb     // Catch:{ all -> 0x001b }
            r1.zzb = r2     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x001a:
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzt.zzd(com.google.android.gms.internal.ads.zzhai):void");
    }
}
