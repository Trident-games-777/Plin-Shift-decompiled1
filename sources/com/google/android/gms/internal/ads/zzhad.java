package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhad {
    zzhad() {
    }

    public static final boolean zza(Object obj) {
        return !((zzhac) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzhac zzhac = (zzhac) obj;
        zzhac zzhac2 = (zzhac) obj2;
        if (!zzhac2.isEmpty()) {
            if (!zzhac.zze()) {
                zzhac = zzhac.zzb();
            }
            zzhac.zzd(zzhac2);
        }
        return zzhac;
    }
}
