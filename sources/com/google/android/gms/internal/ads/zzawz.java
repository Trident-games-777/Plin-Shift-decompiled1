package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawz extends zzaxt {
    private final zzawg zzh;

    public zzawz(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, zzawg zzawg) {
        super(zzawf, "F3b/A5v6wf4vIgkFPpHbBE4QF+7kAwNXBYNdW+58EM84yoPYR42ji8mEXh7tsTu8", "0hPI01hyl9gRqyFiGkD5f6txe9kPcrO1Amh2RTTvv44=", zzasf, i, 85);
        this.zzh = zzawg;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = (long[]) this.zze.invoke((Object) null, new Object[]{Long.valueOf(this.zzh.zzd()), Long.valueOf(this.zzh.zzh()), Long.valueOf(this.zzh.zzb()), Long.valueOf(this.zzh.zzf())});
        synchronized (this.zzd) {
            this.zzd.zzv(jArr[0]);
            this.zzd.zzu(jArr[1]);
        }
    }
}
