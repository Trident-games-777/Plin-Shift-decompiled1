package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgva extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgva zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgvd zze;

    static {
        zzgva zzgva = new zzgva();
        zza = zzgva;
        zzgyx.zzcb(zzgva.class, zzgva);
    }

    private zzgva() {
    }

    public static zzguy zzb() {
        return (zzguy) zza.zzaZ();
    }

    public static zzgva zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgva) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzg() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzh(zzgva zzgva, zzgvd zzgvd) {
        zzgvd.getClass();
        zzgva.zze = zzgvd;
        zzgva.zzc |= 1;
    }

    public final int zza() {
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
                return zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgva();
            case 4:
                return new zzguy((zzguz) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgva.class) {
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

    public final zzgvd zzf() {
        zzgvd zzgvd = this.zze;
        return zzgvd == null ? zzgvd.zzd() : zzgvd;
    }
}
