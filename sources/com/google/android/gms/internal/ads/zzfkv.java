package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfkv extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzfkv zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzfks zzd;

    static {
        zzfkv zzfkv = new zzfkv();
        zza = zzfkv;
        zzgyx.zzcb(zzfkv.class, zzfkv);
    }

    private zzfkv() {
    }

    public static zzfku zza() {
        return (zzfku) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfkv zzfkv, zzfks zzfks) {
        zzfks.getClass();
        zzfkv.zzd = zzfks;
        zzfkv.zzc |= 1;
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
                return zzbS(zza, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzfkv();
            case 4:
                return new zzfku((zzfkw) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzfkv.class) {
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
