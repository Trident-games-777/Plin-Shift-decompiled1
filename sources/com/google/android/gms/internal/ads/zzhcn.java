package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhcn extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhcn zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private long zze;
    private zzgxp zzf = zzgxp.zzb;

    static {
        zzhcn zzhcn = new zzhcn();
        zza = zzhcn;
        zzgyx.zzcb(zzhcn.class, zzhcn);
    }

    private zzhcn() {
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
                return zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", zzhcm.zza, "zze", "zzf"});
            case 3:
                return new zzhcn();
            case 4:
                return new zzhcl((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhcn.class) {
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
