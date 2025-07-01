package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgua extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgua zza;
    private static volatile zzhaq zzb;
    private String zzc = "";
    private zzgxp zzd = zzgxp.zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgua zzgua = new zzgua();
        zza = zzgua;
        zzgyx.zzcb(zzgua.class, zzgua);
    }

    private zzgua() {
    }

    public static zzgtx zza() {
        return (zzgtx) zza.zzaZ();
    }

    public static zzgua zzd() {
        return zza;
    }

    static /* synthetic */ void zzi(zzgua zzgua, String str) {
        str.getClass();
        zzgua.zzc = str;
    }

    static /* synthetic */ void zzj(zzgua zzgua, zzgxp zzgxp) {
        zzgxp.getClass();
        zzgua.zzd = zzgxp;
    }

    public final zzgty zzb() {
        int i = this.zze;
        zzgty zzgty = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : zzgty.REMOTE : zzgty.ASYMMETRIC_PUBLIC : zzgty.ASYMMETRIC_PRIVATE : zzgty.SYMMETRIC : zzgty.UNKNOWN_KEYMATERIAL;
        return zzgty == null ? zzgty.UNRECOGNIZED : zzgty;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgua();
            case 4:
                return new zzgtx((zzgtz) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgua.class) {
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

    public final String zzg() {
        return this.zzc;
    }
}
