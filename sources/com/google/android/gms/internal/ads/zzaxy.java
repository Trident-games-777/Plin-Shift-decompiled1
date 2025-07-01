package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxy extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzaxy zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzayb zzd;
    private zzgxp zze = zzgxp.zzb;
    private zzgxp zzf = zzgxp.zzb;

    static {
        zzaxy zzaxy = new zzaxy();
        zza = zzaxy;
        zzgyx.zzcb(zzaxy.class, zzaxy);
    }

    private zzaxy() {
    }

    public static zzaxy zzb(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzaxy) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public final zzayb zzc() {
        zzayb zzayb = this.zzd;
        return zzayb == null ? zzayb.zzg() : zzayb;
    }

    public final zzgxp zzd() {
        return this.zzf;
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
                return zzbS(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzaxy();
            case 4:
                return new zzaxw((zzaxx) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzaxy.class) {
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
        return this.zze;
    }
}
