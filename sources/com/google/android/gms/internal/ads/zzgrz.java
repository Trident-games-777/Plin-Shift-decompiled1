package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrz extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgrz zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgsf zze;
    private zzgtq zzf;

    static {
        zzgrz zzgrz = new zzgrz();
        zza = zzgrz;
        zzgyx.zzcb(zzgrz.class, zzgrz);
    }

    private zzgrz() {
    }

    public static zzgrx zzb() {
        return (zzgrx) zza.zzaZ();
    }

    public static zzgrz zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgrz) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzi(zzgrz zzgrz, zzgsf zzgsf) {
        zzgsf.getClass();
        zzgrz.zze = zzgsf;
        zzgrz.zzc |= 1;
    }

    static /* synthetic */ void zzj(zzgrz zzgrz, zzgtq zzgtq) {
        zzgtq.getClass();
        zzgrz.zzf = zzgtq;
        zzgrz.zzc |= 2;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgrz();
            case 4:
                return new zzgrx((zzgry) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgrz.class) {
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

    public final zzgsf zzf() {
        zzgsf zzgsf = this.zze;
        return zzgsf == null ? zzgsf.zzd() : zzgsf;
    }

    public final zzgtq zzg() {
        zzgtq zzgtq = this.zzf;
        return zzgtq == null ? zzgtq.zzd() : zzgtq;
    }
}
