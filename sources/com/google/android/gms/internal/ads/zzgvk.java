package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgvk extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgvk zza;
    private static volatile zzhaq zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public zzgxp zzd = zzgxp.zzb;

    static {
        zzgvk zzgvk = new zzgvk();
        zza = zzgvk;
        zzgyx.zzcb(zzgvk.class, zzgvk);
    }

    private zzgvk() {
    }

    public static zzgvi zzb() {
        return (zzgvi) zza.zzaZ();
    }

    public static zzgvk zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgvk) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzg() {
        return zza.zzbN();
    }

    public final int zza() {
        return this.zzc;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgvk();
            case 4:
                return new zzgvi((zzgvj) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgvk.class) {
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
        return this.zzd;
    }
}
