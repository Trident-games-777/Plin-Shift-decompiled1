package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgsf extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgsf zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgsl zze;
    /* access modifiers changed from: private */
    public zzgxp zzf = zzgxp.zzb;

    static {
        zzgsf zzgsf = new zzgsf();
        zza = zzgsf;
        zzgyx.zzcb(zzgsf.class, zzgsf);
    }

    private zzgsf() {
    }

    public static zzgsd zzb() {
        return (zzgsd) zza.zzaZ();
    }

    public static zzgsf zzd() {
        return zza;
    }

    static /* synthetic */ void zzi(zzgsf zzgsf, zzgsl zzgsl) {
        zzgsl.getClass();
        zzgsf.zze = zzgsl;
        zzgsf.zzc |= 1;
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
                return new zzgsf();
            case 4:
                return new zzgsd((zzgse) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgsf.class) {
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

    public final zzgsl zzf() {
        zzgsl zzgsl = this.zze;
        return zzgsl == null ? zzgsl.zzd() : zzgsl;
    }

    public final zzgxp zzg() {
        return this.zzf;
    }
}
