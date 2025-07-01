package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaww extends zzaxt {
    private final long zzh;

    public zzaww(zzawf zzawf, String str, String str2, zzasf zzasf, long j, int i, int i2) {
        super(zzawf, "TJ62ujRRBjJb9/NqrT2Pn0c6KFZY0SF6EjGcQMXtIVccZGktu9G9qu0AxWBd9HPE", "SO84xWj1xZpVST0NHeOw+QMypPAPo6e/MVLMJbQH2M4=", zzasf, i, 25);
        this.zzh = j;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zze.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzd) {
            this.zzd.zzt(longValue);
            long j = this.zzh;
            if (j != 0) {
                this.zzd.zzT(longValue - j);
                this.zzd.zzU(this.zzh);
            }
        }
    }
}
