package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzasz extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzasz zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzasz zzasz = new zzasz();
        zza = zzasz;
        zzgyx.zzcb(zzasz.class, zzasz);
    }

    private zzasz() {
    }

    public static zzasy zza() {
        return (zzasy) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzasz zzasz, long j) {
        zzasz.zzc |= 32;
        zzasz.zzi = j;
    }

    static /* synthetic */ void zzd(zzasz zzasz, long j) {
        zzasz.zzc |= 4;
        zzasz.zzf = j;
    }

    static /* synthetic */ void zzf(zzasz zzasz, long j) {
        zzasz.zzc |= 1;
        zzasz.zzd = j;
    }

    static /* synthetic */ void zzg(zzasz zzasz, long j) {
        zzasz.zzc |= 8;
        zzasz.zzg = j;
    }

    static /* synthetic */ void zzh(zzasz zzasz, long j) {
        zzasz.zzc |= 16;
        zzasz.zzh = j;
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
                return zzbS(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 3:
                return new zzasz();
            case 4:
                return new zzasy((zzatq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzasz.class) {
                    try {
                        zzhaq = zzb;
                        if (zzhaq == null) {
                            zzhaq = new zzgys(zza);
                            zzb = zzhaq;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
