package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhdj extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhdj zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzhdi zzd;
    private zzgzj zze = zzbK();
    private zzgxp zzf = zzgxp.zzb;
    private zzgxp zzg = zzgxp.zzb;
    private int zzh;
    private byte zzi = 2;

    static {
        zzhdj zzhdj = new zzhdj();
        zza = zzhdj;
        zzgyx.zzcb(zzhdj.class, zzhdj);
    }

    private zzhdj() {
    }

    public static zzhdg zzc() {
        return (zzhdg) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhdj zzhdj, zzhdf zzhdf) {
        zzhdf.getClass();
        zzgzj zzgzj = zzhdj.zze;
        if (!zzgzj.zzc()) {
            zzhdj.zze = zzgyx.zzbL(zzgzj);
        }
        zzhdj.zze.add(zzhdf);
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzi);
            case 1:
                this.zzi = obj == null ? (byte) 0 : 1;
                return null;
            case 2:
                return zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzhdf.class, "zzf", "zzg", "zzh"});
            case 3:
                return new zzhdj();
            case 4:
                return new zzhdg((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhdj.class) {
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
