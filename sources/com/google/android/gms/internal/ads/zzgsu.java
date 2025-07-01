package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgsu extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgsu zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;

    static {
        zzgsu zzgsu = new zzgsu();
        zza = zzgsu;
        zzgyx.zzcb(zzgsu.class, zzgsu);
    }

    private zzgsu() {
    }

    public static zzgss zzb() {
        return (zzgss) zza.zzaZ();
    }

    public static zzgsu zzd() {
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
                return new zzgsu();
            case 4:
                return new zzgss((zzgst) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgsu.class) {
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
