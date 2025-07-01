package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzate extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzate zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgxp zzd = zzgxp.zzb;
    private zzgxp zze;
    private zzgxp zzf;
    private zzgxp zzg;

    static {
        zzate zzate = new zzate();
        zza = zzate;
        zzgyx.zzcb(zzate.class, zzate);
    }

    private zzate() {
        zzgxp zzgxp = zzgxp.zzb;
        this.zze = zzgxp;
        this.zzf = zzgxp;
        this.zzg = zzgxp;
    }

    public static zzatd zza() {
        return (zzatd) zza.zzaZ();
    }

    public static zzate zzc(byte[] bArr, zzgyh zzgyh) throws zzgzm {
        return (zzate) zzgyx.zzbx(zza, bArr, zzgyh);
    }

    static /* synthetic */ void zzi(zzate zzate, zzgxp zzgxp) {
        zzate.zzc |= 1;
        zzate.zzd = zzgxp;
    }

    static /* synthetic */ void zzj(zzate zzate, zzgxp zzgxp) {
        zzate.zzc |= 2;
        zzate.zze = zzgxp;
    }

    static /* synthetic */ void zzk(zzate zzate, zzgxp zzgxp) {
        zzate.zzc |= 8;
        zzate.zzg = zzgxp;
    }

    static /* synthetic */ void zzl(zzate zzate, zzgxp zzgxp) {
        zzate.zzc |= 4;
        zzate.zzf = zzgxp;
    }

    public final zzgxp zzd() {
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
                return zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzate();
            case 4:
                return new zzatd((zzatq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzate.class) {
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

    public final zzgxp zzg() {
        return this.zzg;
    }

    public final zzgxp zzh() {
        return this.zzf;
    }
}
