package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgyq implements zzhag {
    private static final zzgyq zza = new zzgyq();

    private zzgyq() {
    }

    public static zzgyq zza() {
        return zza;
    }

    public final zzhaf zzb(Class cls) {
        if (zzgyx.class.isAssignableFrom(cls)) {
            try {
                return (zzhaf) zzgyx.zzbh(cls.asSubclass(zzgyx.class)).zzbO();
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzgyx.class.isAssignableFrom(cls);
    }
}
