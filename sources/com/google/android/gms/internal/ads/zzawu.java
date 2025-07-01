package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawu extends zzaxt {
    public zzawu(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "GvR+eAwGnG9v3CGqMDhazUVumHdJLt60TSBx5Df5j9bg+ZMppmesgixP833S80RN", "cPmD560wQtvtgfdpMZNJUfXZwJNhRKcjeHNf5LBrqDo=", zzasf, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzm(-1);
        this.zzd.zzl(-1);
        int[] iArr = (int[]) this.zze.invoke((Object) null, new Object[]{this.zza.zzb()});
        synchronized (this.zzd) {
            this.zzd.zzm((long) iArr[0]);
            this.zzd.zzl((long) iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                this.zzd.zzk((long) i);
            }
        }
    }
}
