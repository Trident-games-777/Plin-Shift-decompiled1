package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzfxh implements Serializable, zzfxg {
    final zzfxg zza;
    volatile transient boolean zzb;
    @CheckForNull
    transient Object zzc;
    private final transient zzfxn zzd = new zzfxn();

    zzfxh(zzfxg zzfxg) {
        zzfxg zzfxg2 = zzfxg;
        this.zza = zzfxg;
    }

    public final String toString() {
        Object obj;
        if (this.zzb) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        } else {
            obj = this.zza;
        }
        return "Suppliers.memoize(" + obj.toString() + ")";
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this.zzd) {
                if (!this.zzb) {
                    Object zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
