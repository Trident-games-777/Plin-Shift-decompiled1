package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgso extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgso zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgsu zze;
    /* access modifiers changed from: private */
    public zzgxp zzf = zzgxp.zzb;

    static {
        zzgso zzgso = new zzgso();
        zza = zzgso;
        zzgyx.zzcb(zzgso.class, zzgso);
    }

    private zzgso() {
    }

    public static zzgsm zzb() {
        return (zzgsm) zza.zzaZ();
    }

    public static zzgso zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgso) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgso zzgso, zzgsu zzgsu) {
        zzgsu.getClass();
        zzgso.zze = zzgsu;
        zzgso.zzc |= 1;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgso();
            case 4:
                return new zzgsm((zzgsn) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgso.class) {
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

    public final zzgsu zzf() {
        zzgsu zzgsu = this.zze;
        return zzgsu == null ? zzgsu.zzd() : zzgsu;
    }

    public final zzgxp zzg() {
        return this.zzf;
    }
}
