package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrw extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgrw zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;

    static {
        zzgrw zzgrw = new zzgrw();
        zza = zzgrw;
        zzgyx.zzcb(zzgrw.class, zzgrw);
    }

    private zzgrw() {
    }

    public static zzgru zzb() {
        return (zzgru) zza.zzaZ();
    }

    public static zzgrw zzd() {
        return zza;
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
                return zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case 3:
                return new zzgrw();
            case 4:
                return new zzgru((zzgrv) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgrw.class) {
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
