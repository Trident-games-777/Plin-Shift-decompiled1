package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhdf extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhdf zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgxp zzd = zzgxp.zzb;
    private zzgxp zze = zzgxp.zzb;
    private byte zzf = 2;

    static {
        zzhdf zzhdf = new zzhdf();
        zza = zzhdf;
        zzgyx.zzcb(zzhdf.class, zzhdf);
    }

    private zzhdf() {
    }

    public static zzhde zzc() {
        return (zzhde) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhdf zzhdf, zzgxp zzgxp) {
        zzhdf.zzc |= 1;
        zzhdf.zzd = zzgxp;
    }

    static /* synthetic */ void zzg(zzhdf zzhdf, zzgxp zzgxp) {
        zzhdf.zzc |= 2;
        zzhdf.zze = zzgxp;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzf);
            case 1:
                this.zzf = obj == null ? (byte) 0 : 1;
                return null;
            case 2:
                return zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzhdf();
            case 4:
                return new zzhde((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhdf.class) {
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
}
