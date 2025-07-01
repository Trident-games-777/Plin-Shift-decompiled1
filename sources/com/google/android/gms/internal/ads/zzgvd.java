package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgvd extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgvd zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";
    private zzgue zze;

    static {
        zzgvd zzgvd = new zzgvd();
        zza = zzgvd;
        zzgyx.zzcb(zzgvd.class, zzgvd);
    }

    private zzgvd() {
    }

    public static zzgvb zzb() {
        return (zzgvb) zza.zzaZ();
    }

    public static zzgvd zzd() {
        return zza;
    }

    public static zzgvd zzf(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgvd) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzh(zzgvd zzgvd, zzgue zzgue) {
        zzgue.getClass();
        zzgvd.zze = zzgue;
        zzgvd.zzc |= 1;
    }

    static /* synthetic */ void zzi(zzgvd zzgvd, String str) {
        str.getClass();
        zzgvd.zzd = str;
    }

    public final zzgue zza() {
        zzgue zzgue = this.zze;
        return zzgue == null ? zzgue.zzd() : zzgue;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgvd();
            case 4:
                return new zzgvb((zzgvc) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgvd.class) {
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

    public final String zzg() {
        return this.zzd;
    }
}
