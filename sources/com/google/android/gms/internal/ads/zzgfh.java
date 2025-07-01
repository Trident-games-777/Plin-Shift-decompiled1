package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgfh extends zzgdy implements RunnableFuture {
    @CheckForNull
    private volatile zzgeq zza;

    zzgfh(zzgdo zzgdo) {
        this.zza = new zzgff(this, zzgdo);
    }

    static zzgfh zze(Runnable runnable, Object obj) {
        return new zzgfh(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzgeq zzgeq = this.zza;
        if (zzgeq != null) {
            zzgeq.run();
        }
        this.zza = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzgeq zzgeq = this.zza;
        if (zzgeq == null) {
            return super.zza();
        }
        String obj = zzgeq.toString();
        return "task=[" + obj + "]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzgeq zzgeq;
        if (zzt() && (zzgeq = this.zza) != null) {
            zzgeq.zzh();
        }
        this.zza = null;
    }

    zzgfh(Callable callable) {
        this.zza = new zzgfg(this, callable);
    }
}
