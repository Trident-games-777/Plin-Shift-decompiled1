package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzase extends zzgyx implements zzhaj {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzase zzb;
    private static volatile zzhaq zzc;
    private int zzd;
    private long zze = 100;
    private boolean zzf;
    private boolean zzg;
    private long zzh = 300;

    static {
        zzase zzase = new zzase();
        zzb = zzase;
        zzgyx.zzcb(zzase.class, zzase);
    }

    private zzase() {
    }

    public static zzase zzb() {
        return zzb;
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
                return zzbS(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzase();
            case 4:
                return new zzasc((zzasd) null);
            case 5:
                return zzb;
            case 6:
                zzhaq zzhaq2 = zzc;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzase.class) {
                    zzhaq = zzc;
                    if (zzhaq == null) {
                        zzhaq = new zzgys(zzb);
                        zzc = zzhaq;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
