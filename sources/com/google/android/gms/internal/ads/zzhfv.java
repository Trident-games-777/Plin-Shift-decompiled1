package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhfv implements zzhfx {
    private zzhgg zza;

    public static void zza(zzhgg zzhgg, zzhgg zzhgg2) {
        zzhfv zzhfv = (zzhfv) zzhgg;
        if (zzhfv.zza == null) {
            zzhfv.zza = zzhgg2;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object zzb() {
        zzhgg zzhgg = this.zza;
        if (zzhgg != null) {
            return zzhgg.zzb();
        }
        throw new IllegalStateException();
    }
}
