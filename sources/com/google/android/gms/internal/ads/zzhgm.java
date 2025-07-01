package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhgm implements zzhgg {
    private static final Object zza = new Object();
    private volatile zzhgg zzb;
    private volatile Object zzc = zza;

    private zzhgm(zzhgg zzhgg) {
        this.zzb = zzhgg;
    }

    public static zzhgg zza(zzhgg zzhgg) {
        if ((zzhgg instanceof zzhgm) || (zzhgg instanceof zzhfw)) {
            return zzhgg;
        }
        zzhgg zzhgg2 = zzhgg;
        return new zzhgm(zzhgg);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhgg zzhgg = this.zzb;
        if (zzhgg == null) {
            return this.zzc;
        }
        Object zzb2 = zzhgg.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
