package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzatp extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzatp zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgzj zzd = zzbK();
    private zzgxp zze = zzgxp.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzatp zzatp = new zzatp();
        zza = zzatp;
        zzgyx.zzcb(zzatp.class, zzatp);
    }

    private zzatp() {
    }

    public static zzato zza() {
        return (zzato) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzatp zzatp, zzgxp zzgxp) {
        zzgzj zzgzj = zzatp.zzd;
        if (!zzgzj.zzc()) {
            zzatp.zzd = zzgyx.zzbL(zzgzj);
        }
        zzatp.zzd.add(zzgxp);
    }

    static /* synthetic */ void zzd(zzatp zzatp, zzgxp zzgxp) {
        zzatp.zzc |= 1;
        zzatp.zze = zzgxp;
    }

    static /* synthetic */ void zzf(zzatp zzatp, int i) {
        zzatp.zzg = i - 1;
        zzatp.zzc |= 4;
    }

    static /* synthetic */ void zzg(zzatp zzatp, int i) {
        zzatp.zzf = 4;
        zzatp.zzc |= 2;
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
                return zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzatj.zza, "zzg", zzatf.zza});
            case 3:
                return new zzatp();
            case 4:
                return new zzato((zzatq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzatp.class) {
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
