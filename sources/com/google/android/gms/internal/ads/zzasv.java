package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzasv extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzasv zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private long zzd = -1;
    private int zze = 1000;

    static {
        zzasv zzasv = new zzasv();
        zza = zzasv;
        zzgyx.zzcb(zzasv.class, zzasv);
    }

    private zzasv() {
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
                return zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", "zze", zzatg.zza});
            case 3:
                return new zzasv();
            case 4:
                return new zzasu((zzatq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzasv.class) {
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
