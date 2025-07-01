package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhdn extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhdn zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzhdm zzd;
    private zzgzj zze = zzbK();
    private zzgxp zzf = zzgxp.zzb;
    private zzgxp zzg;
    private int zzh;
    private zzgxp zzi;
    private byte zzj = 2;

    static {
        zzhdn zzhdn = new zzhdn();
        zza = zzhdn;
        zzgyx.zzcb(zzhdn.class, zzhdn);
    }

    private zzhdn() {
        zzgxp zzgxp = zzgxp.zzb;
        this.zzg = zzgxp;
        this.zzi = zzgxp;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzj);
            case 1:
                this.zzj = obj == null ? (byte) 0 : 1;
                return null;
            case 2:
                return zzbS(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", "zzd", "zze", zzhdf.class, "zzf", "zzg", "zzh", "zzi"});
            case 3:
                return new zzhdn();
            case 4:
                return new zzhdk((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhdn.class) {
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
