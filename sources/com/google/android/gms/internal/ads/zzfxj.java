package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzfxj implements zzfxg {
    private static final zzfxg zza = new zzfxi();
    private final zzfxn zzb = new zzfxn();
    private volatile zzfxg zzc;
    @CheckForNull
    private Object zzd;

    zzfxj(zzfxg zzfxg) {
        zzfxg zzfxg2 = zzfxg;
        this.zzc = zzfxg;
    }

    public final String toString() {
        Object obj = this.zzc;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzd) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    public final Object zza() {
        zzfxg zzfxg = this.zzc;
        zzfxg zzfxg2 = zza;
        if (zzfxg != zzfxg2) {
            synchronized (this.zzb) {
                if (this.zzc != zzfxg2) {
                    Object zza2 = this.zzc.zza();
                    this.zzd = zza2;
                    this.zzc = zzfxg2;
                    return zza2;
                }
            }
        }
        return this.zzd;
    }
}
