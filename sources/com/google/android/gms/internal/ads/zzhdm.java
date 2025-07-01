package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhdm extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhdm zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgxp zze = zzgxp.zzb;
    private zzgxp zzf = zzgxp.zzb;

    static {
        zzhdm zzhdm = new zzhdm();
        zza = zzhdm;
        zzgyx.zzcb(zzhdm.class, zzhdm);
    }

    private zzhdm() {
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
                return zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzhdm();
            case 4:
                return new zzhdl((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhdm.class) {
                    zzhaq = zzb;
                    if (zzhaq == null) {
                        zzhaq = new zzgys(zza);
                        zzb = zzhaq;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
