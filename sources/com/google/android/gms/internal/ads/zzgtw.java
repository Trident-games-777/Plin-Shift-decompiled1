package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgtw extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgtw zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzgtw zzgtw = new zzgtw();
        zza = zzgtw;
        zzgyx.zzcb(zzgtw.class, zzgtw);
    }

    private zzgtw() {
    }

    public static zzgtu zzc() {
        return (zzgtu) zza.zzaZ();
    }

    public static zzgtw zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgtn zzb() {
        int i = this.zzc;
        zzgtn zzgtn = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? null : zzgtn.SHA224 : zzgtn.SHA512 : zzgtn.SHA256 : zzgtn.SHA384 : zzgtn.SHA1 : zzgtn.UNKNOWN_HASH;
        return zzgtn == null ? zzgtn.UNRECOGNIZED : zzgtn;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgtw();
            case 4:
                return new zzgtu((zzgtv) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgtw.class) {
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
