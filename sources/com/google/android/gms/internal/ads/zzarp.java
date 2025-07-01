package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzarp extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzarp zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private long zzj;
    private String zzk = "";
    private long zzl;
    private String zzm = "";
    private String zzn = "";
    private zzgzj zzo = zzbK();
    private int zzp;

    static {
        zzarp zzarp = new zzarp();
        zza = zzarp;
        zzgyx.zzcb(zzarp.class, zzarp);
    }

    private zzarp() {
    }

    public static zzarl zza() {
        return (zzarl) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzarp zzarp, String str) {
        str.getClass();
        zzarp.zzc |= 1;
        zzarp.zzd = str;
    }

    static /* synthetic */ void zzd(zzarp zzarp, String str) {
        zzarp.zzc |= 16;
        zzarp.zzh = str;
    }

    static /* synthetic */ void zzf(zzarp zzarp, String str) {
        zzarp.zzc |= 1024;
        zzarp.zzn = str;
    }

    static /* synthetic */ void zzg(zzarp zzarp, String str) {
        str.getClass();
        zzarp.zzc |= 8;
        zzarp.zzg = str;
    }

    static /* synthetic */ void zzh(zzarp zzarp, long j) {
        zzarp.zzc |= 2;
        zzarp.zze = j;
    }

    static /* synthetic */ void zzi(zzarp zzarp, String str) {
        str.getClass();
        zzarp.zzc |= 4;
        zzarp.zzf = str;
    }

    static /* synthetic */ void zzj(zzarp zzarp, int i) {
        zzarp.zzp = i - 1;
        zzarp.zzc |= 2048;
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
                return zzbS(zza, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzarn.class, "zzp", zzaro.zza});
            case 3:
                return new zzarp();
            case 4:
                return new zzarl((zzarq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzarp.class) {
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
