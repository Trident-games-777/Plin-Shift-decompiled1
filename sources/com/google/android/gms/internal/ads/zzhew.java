package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhew extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhew zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgzf zzf = zzbG();
    private int zzg;
    private zzgzj zzh = zzbK();
    private zzgxp zzi = zzgxp.zzb;

    static {
        zzhew zzhew = new zzhew();
        zza = zzhew;
        zzgyx.zzcb(zzhew.class, zzhew);
    }

    private zzhew() {
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
                return zzbS(zza, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzheu.class, "zzi"});
            case 3:
                return new zzhew();
            case 4:
                return new zzhev((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhew.class) {
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
