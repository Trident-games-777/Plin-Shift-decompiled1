package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzflk extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzflk zza;
    private static volatile zzhaq zzb;
    private zzgzj zzc = zzbK();

    static {
        zzflk zzflk = new zzflk();
        zza = zzflk;
        zzgyx.zzcb(zzflk.class, zzflk);
    }

    private zzflk() {
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
                return zzbS(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzflh.class});
            case 3:
                return new zzflk();
            case 4:
                return new zzfli((zzflj) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzflk.class) {
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
