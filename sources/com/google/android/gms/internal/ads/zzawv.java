package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawv extends zzaxt {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzawv(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "vHxl3/k7agNEaOAb+kiexrLMKd/tl26b7leOgQmEqvHEdvK4RjfXtH7j4TmF8OsM", "1y55K+UUiCchaHGitlZ/bNKURNzH22lnMjmt1W+XJdc=", zzasf, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (Long) this.zze.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzd) {
            this.zzd.zzo(zzh.longValue());
        }
    }
}
