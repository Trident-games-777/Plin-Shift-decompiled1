package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzguk extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzguk zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgua zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzguk zzguk = new zzguk();
        zza = zzguk;
        zzgyx.zzcb(zzguk.class, zzguk);
    }

    private zzguk() {
    }

    public static zzguj zzc() {
        return (zzguj) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzguk zzguk, zzgua zzgua) {
        zzgua.getClass();
        zzguk.zzd = zzgua;
        zzguk.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgua zzb() {
        zzgua zzgua = this.zzd;
        return zzgua == null ? zzgua.zzd() : zzgua;
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
                return zzbS(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzguk();
            case 4:
                return new zzguj((zzgul) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzguk.class) {
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

    public final zzgve zzf() {
        zzgve zzb2 = zzgve.zzb(this.zzg);
        return zzb2 == null ? zzgve.UNRECOGNIZED : zzb2;
    }

    public final boolean zzj() {
        return (this.zzc & 1) != 0;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            i2 = i != 1 ? i != 2 ? i != 3 ? 0 : 5 : 4 : 3;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
