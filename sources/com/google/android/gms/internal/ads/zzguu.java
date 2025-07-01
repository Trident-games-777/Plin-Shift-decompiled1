package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzguu extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzguu zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgux zze;

    static {
        zzguu zzguu = new zzguu();
        zza = zzguu;
        zzgyx.zzcb(zzguu.class, zzguu);
    }

    private zzguu() {
    }

    public static zzgus zzb() {
        return (zzgus) zza.zzaZ();
    }

    public static zzguu zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzguu) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzg() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzh(zzguu zzguu, zzgux zzgux) {
        zzgux.getClass();
        zzguu.zze = zzgux;
        zzguu.zzc |= 1;
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
                return new zzguu();
            case 4:
                return new zzgus((zzgut) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzguu.class) {
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

    public final zzgux zzf() {
        zzgux zzgux = this.zze;
        return zzgux == null ? zzgux.zzc() : zzgux;
    }
}
