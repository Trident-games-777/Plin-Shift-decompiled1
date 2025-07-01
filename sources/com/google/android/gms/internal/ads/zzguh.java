package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzguh extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzguh zza;
    private static volatile zzhaq zzb;
    private String zzc = "";
    private String zzd = "";
    private int zze;
    private boolean zzf;
    private String zzg = "";

    static {
        zzguh zzguh = new zzguh();
        zza = zzguh;
        zzgyx.zzcb(zzguh.class, zzguh);
    }

    private zzguh() {
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
                return zzbS(zza, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzguh();
            case 4:
                return new zzguf((zzgug) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzguh.class) {
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
