package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhek extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhek zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private boolean zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private boolean zzk;

    static {
        zzhek zzhek = new zzhek();
        zza = zzhek;
        zzgyx.zzcb(zzhek.class, zzhek);
    }

    private zzhek() {
    }

    public static zzhej zzc() {
        return (zzhej) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhek zzhek, String str) {
        zzhek.zzc |= 1;
        zzhek.zzd = str;
    }

    static /* synthetic */ void zzg(zzhek zzhek, long j) {
        zzhek.zzc |= 2;
        zzhek.zze = j;
    }

    static /* synthetic */ void zzh(zzhek zzhek, boolean z) {
        zzhek.zzc |= 4;
        zzhek.zzf = z;
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
                return zzbS(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhel.zza, "zzh", "zzi", "zzj", "zzk"});
            case 3:
                return new zzhek();
            case 4:
                return new zzhej((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhek.class) {
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
