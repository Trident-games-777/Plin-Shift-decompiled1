package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhdr extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhdr zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzhdr zzhdr = new zzhdr();
        zza = zzhdr;
        zzgyx.zzcb(zzhdr.class, zzhdr);
    }

    private zzhdr() {
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                zzgzd zzgzd = zzhdp.zza;
                return zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zzc", "zzd", zzgzd, "zze", "zzf", zzgzd});
            case 3:
                return new zzhdr();
            case 4:
                return new zzhdq((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhdr.class) {
                    try {
                        zzhaq = zzb;
                        if (zzhaq == null) {
                            zzhaq = new zzgys(zza);
                            zzb = zzhaq;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
