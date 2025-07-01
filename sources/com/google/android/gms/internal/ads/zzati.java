package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzati extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzati zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private String zzg = "D";
    private long zzh;

    static {
        zzati zzati = new zzati();
        zza = zzati;
        zzgyx.zzcb(zzati.class, zzati);
    }

    private zzati() {
    }

    public static zzath zza() {
        return (zzath) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzati zzati, String str) {
        zzati.zzc |= 1;
        zzati.zzd = "1.671910402";
    }

    static /* synthetic */ void zzd(zzati zzati, String str) {
        str.getClass();
        zzati.zzc |= 2;
        zzati.zze = str;
    }

    static /* synthetic */ void zzf(zzati zzati, String str) {
        str.getClass();
        zzati.zzc |= 8;
        zzati.zzg = str;
    }

    static /* synthetic */ void zzg(zzati zzati, long j) {
        zzati.zzc |= 4;
        zzati.zzf = j;
    }

    static /* synthetic */ void zzh(zzati zzati, long j) {
        zzati.zzc |= 16;
        zzati.zzh = j;
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
                return zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzati();
            case 4:
                return new zzath((zzatq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzati.class) {
                    try {
                        zzhaq = zzb;
                        if (zzhaq == null) {
                            zzhaq = new zzgys(zza);
                            zzb = zzhaq;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
