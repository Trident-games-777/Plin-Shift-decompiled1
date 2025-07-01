package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhds extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhds zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzhdr zze;
    private zzhdr zzf;

    static {
        zzhds zzhds = new zzhds();
        zza = zzhds;
        zzgyx.zzcb(zzhds.class, zzhds);
    }

    private zzhds() {
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
                return zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzhdp.zza, "zze", "zzf"});
            case 3:
                return new zzhds();
            case 4:
                return new zzhdo((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhds.class) {
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
