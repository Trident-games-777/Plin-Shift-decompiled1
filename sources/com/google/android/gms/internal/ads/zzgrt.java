package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrt extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgrt zza;
    private static volatile zzhaq zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgrw zze;

    static {
        zzgrt zzgrt = new zzgrt();
        zza = zzgrt;
        zzgyx.zzcb(zzgrt.class, zzgrt);
    }

    private zzgrt() {
    }

    public static zzgrr zzb() {
        return (zzgrr) zza.zzaZ();
    }

    public static zzgrt zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgrt) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzh(zzgrt zzgrt, zzgrw zzgrw) {
        zzgrw.getClass();
        zzgrt.zze = zzgrw;
        zzgrt.zzc |= 1;
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
                return new zzgrt();
            case 4:
                return new zzgrr((zzgrs) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgrt.class) {
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

    public final zzgrw zzf() {
        zzgrw zzgrw = this.zze;
        return zzgrw == null ? zzgrw.zzd() : zzgrw;
    }
}
