package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgtm extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgtm zza;
    private static volatile zzhaq zzb;

    static {
        zzgtm zzgtm = new zzgtm();
        zza = zzgtm;
        zzgyx.zzcb(zzgtm.class, zzgtm);
    }

    private zzgtm() {
    }

    public static zzgtm zzb() {
        return zza;
    }

    public static zzgtm zzc(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgtm) zzgyx.zzbr(zza, zzgxp, zzgyh);
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
                return zzbS(zza, "\u0000\u0000", (Object[]) null);
            case 3:
                return new zzgtm();
            case 4:
                return new zzgtk((zzgtl) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgtm.class) {
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
