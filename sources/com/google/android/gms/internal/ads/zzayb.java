package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzayb extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzayb zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzayb zzayb = new zzayb();
        zza = zzayb;
        zzgyx.zzcb(zzayb.class, zzayb);
    }

    private zzayb() {
    }

    public static zzaxz zzd() {
        return (zzaxz) zza.zzaZ();
    }

    public static zzayb zzg() {
        return zza;
    }

    public static zzayb zzh(zzgxp zzgxp) throws zzgzm {
        return (zzayb) zzgyx.zzbm(zza, zzgxp);
    }

    public static zzayb zzi(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzayb) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzl(zzayb zzayb, String str) {
        str.getClass();
        zzayb.zzc |= 2;
        zzayb.zze = str;
    }

    static /* synthetic */ void zzm(zzayb zzayb, long j) {
        zzayb.zzc |= 8;
        zzayb.zzg = j;
    }

    static /* synthetic */ void zzn(zzayb zzayb, long j) {
        zzayb.zzc |= 4;
        zzayb.zzf = j;
    }

    static /* synthetic */ void zzo(zzayb zzayb, long j) {
        zzayb.zzc |= 16;
        zzayb.zzh = j;
    }

    static /* synthetic */ void zzp(zzayb zzayb, String str) {
        str.getClass();
        zzayb.zzc |= 1;
        zzayb.zzd = str;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final long zzc() {
        return this.zzh;
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
                return zzbS(zza, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzayb();
            case 4:
                return new zzaxz((zzaya) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzayb.class) {
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

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
