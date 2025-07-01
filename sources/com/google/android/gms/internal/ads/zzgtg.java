package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgtg extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgtg zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private int zzd;

    static {
        zzgtg zzgtg = new zzgtg();
        zza = zzgtg;
        zzgyx.zzcb(zzgtg.class, zzgtg);
    }

    private zzgtg() {
    }

    public static zzgte zzc() {
        return (zzgte) zza.zzaZ();
    }

    public static zzgtg zzf(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgtg) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
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
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zzc"});
            case 3:
                return new zzgtg();
            case 4:
                return new zzgte((zzgtf) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgtg.class) {
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
