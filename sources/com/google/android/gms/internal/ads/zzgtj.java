package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgtj extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgtj zza;
    private static volatile zzhaq zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public zzgxp zzd = zzgxp.zzb;

    static {
        zzgtj zzgtj = new zzgtj();
        zza = zzgtj;
        zzgyx.zzcb(zzgtj.class, zzgtj);
    }

    private zzgtj() {
    }

    public static zzgth zzb() {
        return (zzgth) zza.zzaZ();
    }

    public static zzgtj zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgtj) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzg() {
        return zza.zzbN();
    }

    public final int zza() {
        return this.zzc;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgtj();
            case 4:
                return new zzgth((zzgti) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgtj.class) {
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

    public final zzgxp zzf() {
        return this.zzd;
    }
}
