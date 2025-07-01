package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhfw implements zzhgg, zzhfr {
    private static final Object zza = new Object();
    private volatile zzhgg zzb;
    private volatile Object zzc = zza;

    private zzhfw(zzhgg zzhgg) {
        this.zzb = zzhgg;
    }

    public static zzhfr zza(zzhgg zzhgg) {
        if (zzhgg instanceof zzhfr) {
            return (zzhfr) zzhgg;
        }
        zzhgg zzhgg2 = zzhgg;
        return new zzhfw(zzhgg);
    }

    public static zzhgg zzc(zzhgg zzhgg) {
        return zzhgg instanceof zzhfw ? zzhgg : new zzhfw(zzhgg);
    }

    private final synchronized Object zzd() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj != obj2) {
            return obj;
        }
        Object zzb2 = this.zzb.zzb();
        Object obj3 = this.zzc;
        if (obj3 != obj2) {
            if (obj3 != zzb2) {
                throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + zzb2 + ". This is likely due to a circular dependency.");
            }
        }
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }

    public final Object zzb() {
        Object obj = this.zzc;
        return obj == zza ? zzd() : obj;
    }
}
