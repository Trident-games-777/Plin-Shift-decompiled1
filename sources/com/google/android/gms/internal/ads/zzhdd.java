package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhdd extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhdd zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;

    static {
        zzhdd zzhdd = new zzhdd();
        zza = zzhdd;
        zzgyx.zzcb(zzhdd.class, zzhdd);
    }

    private zzhdd() {
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
                return zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဂ\u0003", new Object[]{"zzc", "zzd", zzhdc.zza, "zze", zzhda.zza, "zzf", "zzg"});
            case 3:
                return new zzhdd();
            case 4:
                return new zzhdb((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhdd.class) {
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
