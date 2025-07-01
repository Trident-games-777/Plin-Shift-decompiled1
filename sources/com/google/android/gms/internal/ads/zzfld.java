package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfld extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzfld zza;
    private static volatile zzhaq zzb;
    private String zzc = "";

    static {
        zzfld zzfld = new zzfld();
        zza = zzfld;
        zzgyx.zzcb(zzfld.class, zzfld);
    }

    private zzfld() {
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
                return zzbS(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case 3:
                return new zzfld();
            case 4:
                return new zzflb((zzflc) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzfld.class) {
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
