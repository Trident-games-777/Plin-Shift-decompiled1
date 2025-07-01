package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxb extends zzaxt {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzaxb(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "pqNjV8dx1XFj9T4LMPQEa0a19I+nsD8Qxz2fQuehDPd98Kfq+TQkVREvoUEgFPtf", "v02B7neKpYyNwQtluXNrII6UZlY2WS0o0AnaqwUmhpo=", zzasf, i, 22);
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
            this.zzd.zzy(zzh.longValue());
        }
    }
}
