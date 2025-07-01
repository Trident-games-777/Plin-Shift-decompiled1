package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgzz implements zzhag {
    private final zzhag[] zza;

    zzgzz(zzhag... zzhagArr) {
        this.zza = zzhagArr;
    }

    public final zzhaf zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzhag zzhag = this.zza[i];
            if (zzhag.zzc(cls)) {
                return zzhag.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
