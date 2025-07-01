package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgup extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgup zza;
    private static volatile zzhaq zzb;
    private String zzc = "";
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgup zzgup = new zzgup();
        zza = zzgup;
        zzgyx.zzcb(zzgup.class, zzgup);
    }

    private zzgup() {
    }

    public static zzguo zza() {
        return (zzguo) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzgup zzgup, String str) {
        str.getClass();
        zzgup.zzc = str;
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
                return zzbS(zza, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgup();
            case 4:
                return new zzguo((zzguq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgup.class) {
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
