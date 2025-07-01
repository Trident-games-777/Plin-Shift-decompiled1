package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgdv extends zzgdi {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzgdu zza;

    zzgdv(zzfzj zzfzj, boolean z, Executor executor, Callable callable) {
        super(zzfzj, z, false);
        this.zza = new zzgdt(this, callable, executor);
        zzv();
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i, @CheckForNull Object obj) {
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        zzgdu zzgdu = this.zza;
        if (zzgdu != null) {
            zzgdu.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu() {
        zzgdu zzgdu = this.zza;
        if (zzgdu != null) {
            zzgdu.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) {
        super.zzy(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
