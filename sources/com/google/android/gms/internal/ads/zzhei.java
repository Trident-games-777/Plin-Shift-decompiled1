package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhei extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhei zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzhdj zzf;
    private zzhdn zzg;
    private int zzh;
    private zzgzf zzi = zzbG();
    private String zzj = "";
    private int zzk;
    private zzgzj zzl = zzgyx.zzbK();
    private byte zzm = 2;

    static {
        zzhei zzhei = new zzhei();
        zza = zzhei;
        zzgyx.zzcb(zzhei.class, zzhei);
    }

    private zzhei() {
    }

    public static zzheh zzd() {
        return (zzheh) zza.zzaZ();
    }

    static /* synthetic */ void zzh(zzhei zzhei, String str) {
        str.getClass();
        zzgzj zzgzj = zzhei.zzl;
        if (!zzgzj.zzc()) {
            zzhei.zzl = zzgyx.zzbL(zzgzj);
        }
        zzhei.zzl.add(str);
    }

    static /* synthetic */ void zzi(zzhei zzhei, int i) {
        zzhei.zzc |= 1;
        zzhei.zzd = i;
    }

    static /* synthetic */ void zzj(zzhei zzhei, zzhdj zzhdj) {
        zzhdj.getClass();
        zzhei.zzf = zzhdj;
        zzhei.zzc |= 4;
    }

    static /* synthetic */ void zzk(zzhei zzhei, String str) {
        str.getClass();
        zzhei.zzc |= 2;
        zzhei.zze = str;
    }

    static /* synthetic */ void zzl(zzhei zzhei, int i) {
        zzhei.zzk = i - 1;
        zzhei.zzc |= 64;
    }

    public final int zzc() {
        return this.zzl.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzm);
            case 1:
                this.zzm = obj == null ? (byte) 0 : 1;
                return null;
            case 2:
                return zzbS(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzhef.zza, "zzl"});
            case 3:
                return new zzhei();
            case 4:
                return new zzheh((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhei.class) {
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

    public final String zzg() {
        return this.zze;
    }
}
