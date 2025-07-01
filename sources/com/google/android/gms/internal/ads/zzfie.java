package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfie {
    private final zzfhx zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfie(zzfhc zzfhc, zzfhw zzfhw, zzfhx zzfhx) {
        this.zza = zzfhx;
        this.zzb = zzgei.zzf(zzgei.zzn(zzfhw.zza(zzfhx), new zzfic(this, zzfhw, zzfhc, zzfhx), zzfhx.zzb()), Exception.class, new zzfid(this, zzfhw), zzfhx.zzb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.common.util.concurrent.ListenableFuture zza(com.google.android.gms.internal.ads.zzfhx r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzd     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x002f
            boolean r0 = r1.zzc     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000a
            goto L_0x002f
        L_0x000a:
            com.google.android.gms.internal.ads.zzfhx r0 = r1.zza     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfhm r0 = r0.zza()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzfhm r0 = r2.zza()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzfhx r0 = r1.zza     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfhm r0 = r0.zza()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfhm r2 = r2.zza()     // Catch:{ all -> 0x0032 }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x002f
            r2 = 1
            r1.zzc = r2     // Catch:{ all -> 0x0032 }
            com.google.common.util.concurrent.ListenableFuture r2 = r1.zzb     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)
            return r2
        L_0x002f:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0032:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfie.zza(com.google.android.gms.internal.ads.zzfhx):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzfhw zzfhw, zzfhc zzfhc, zzfhx zzfhx, zzfhl zzfhl) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfhw.zzb(zzfhl);
            if (!this.zzc) {
                zzfhc.zzd(zzfhx.zza(), zzfhl);
                ListenableFuture zzh = zzgei.zzh((Object) null);
                return zzh;
            }
            ListenableFuture zzh2 = zzgei.zzh(new zzfhv(zzfhl, zzfhx));
            return zzh2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfhw zzfhw, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzgee zzgee) {
        zzgei.zzr(zzgei.zzn(this.zzb, new zzfib(), this.zza.zzb()), zzgee, this.zza.zzb());
    }
}
