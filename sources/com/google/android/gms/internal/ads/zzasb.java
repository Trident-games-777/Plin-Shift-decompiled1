package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzasb extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzasb zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private boolean zzd;
    private int zze = 5000;
    private boolean zzf;
    private boolean zzg;

    static {
        zzasb zzasb = new zzasb();
        zza = zzasb;
        zzgyx.zzcb(zzasb.class, zzasb);
    }

    private zzasb() {
    }

    public static zzasb zzc() {
        return zza;
    }

    public final int zza() {
        return this.zze;
    }

    public final boolean zzd() {
        return this.zzd;
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
                return zzbS(zza, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzasb();
            case 4:
                return new zzarz((zzasa) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzasb.class) {
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

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
