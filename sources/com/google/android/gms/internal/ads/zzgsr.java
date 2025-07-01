package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgsr extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgsr zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgsu zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgsr zzgsr = new zzgsr();
        zza = zzgsr;
        zzgyx.zzcb(zzgsr.class, zzgsr);
    }

    private zzgsr() {
    }

    public static zzgsp zzb() {
        return (zzgsp) zza.zzaZ();
    }

    public static zzgsr zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgsr) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzh(zzgsr zzgsr, zzgsu zzgsu) {
        zzgsu.getClass();
        zzgsr.zzd = zzgsu;
        zzgsr.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgsr();
            case 4:
                return new zzgsp((zzgsq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgsr.class) {
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
        zzgsu zzgsu = this.zzd;
        return zzgsu == null ? zzgsu.zzd() : zzgsu;
    }
}
