package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxd extends zzaxt {
    private final zzavx zzh;

    public zzaxd(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, zzavx zzavx) {
        super(zzawf, "InzZioUCViOMoBpQHwvu/pIx3gXrXGOaM2JpzEjvxDIhnjzi/kaCZRYG9Kg1JwVe", "n5HdSerkTAgTJwRh00NQA14abEqPXtGNhLU/oVUfpWQ=", zzasf, i, 94);
        this.zzh = zzavx;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zze.invoke((Object) null, new Object[]{this.zzh.zza()})).intValue();
        synchronized (this.zzd) {
            this.zzd.zzae(zzasr.zza(intValue));
        }
    }
}
