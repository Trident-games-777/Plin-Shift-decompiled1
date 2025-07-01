package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgta extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgta zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private int zzd;

    static {
        zzgta zzgta = new zzgta();
        zza = zzgta;
        zzgyx.zzcb(zzgta.class, zzgta);
    }

    private zzgta() {
    }

    public static zzgsy zzc() {
        return (zzgsy) zza.zzaZ();
    }

    public static zzgta zzf(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgta) zzgyx.zzbr(zza, zzgxp, zzgyh);
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
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgta();
            case 4:
                return new zzgsy((zzgsz) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgta.class) {
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
