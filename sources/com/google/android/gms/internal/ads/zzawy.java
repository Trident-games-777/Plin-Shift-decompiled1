package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawy implements Callable {
    private final zzawf zza;
    private final zzasf zzb;

    public zzawy(zzawf zzawf, zzasf zzasf) {
        this.zza = zzawf;
        this.zzb = zzasf;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzata zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                this.zzb.zzaY(zzc.zzaV(), zzgyh.zza());
            }
            return null;
        } catch (zzgzm | NullPointerException unused) {
            return null;
        }
    }
}
