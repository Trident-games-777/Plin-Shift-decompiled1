package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhed extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhed zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgxp zzf = zzgxp.zzb;
    private zzgxp zzg = zzgxp.zzb;

    static {
        zzhed zzhed = new zzhed();
        zza = zzhed;
        zzgyx.zzcb(zzhed.class, zzhed);
    }

    private zzhed() {
    }

    public static zzheb zzc() {
        return (zzheb) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhed zzhed, zzgxp zzgxp) {
        zzgxp.getClass();
        zzhed.zzc |= 4;
        zzhed.zzf = zzgxp;
    }

    static /* synthetic */ void zzg(zzhed zzhed, String str) {
        zzhed.zzc |= 2;
        zzhed.zze = "image/png";
    }

    static /* synthetic */ void zzh(zzhed zzhed, int i) {
        zzhed.zzd = 1;
        zzhed.zzc = 1 | zzhed.zzc;
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
                return zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhec.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzhed();
            case 4:
                return new zzheb((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhed.class) {
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
