package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzarj extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzarj zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private boolean zze = true;
    private String zzf = "unknown_host";
    private boolean zzg;
    private boolean zzh = true;
    private zzasb zzi;
    private zzase zzj;
    private boolean zzk;

    static {
        zzarj zzarj = new zzarj();
        zza = zzarj;
        zzgyx.zzcb(zzarj.class, zzarj);
    }

    private zzarj() {
    }

    public static zzarh zza() {
        return (zzarh) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzarj zzarj, boolean z) {
        zzarj.zzc |= 8;
        zzarj.zzg = z;
    }

    static /* synthetic */ void zzh(zzarj zzarj, String str) {
        str.getClass();
        zzarj.zzc |= 4;
        zzarj.zzf = str;
    }

    public final zzasb zzc() {
        zzasb zzasb = this.zzi;
        return zzasb == null ? zzasb.zzc() : zzasb;
    }

    public final zzase zzd() {
        zzase zzase = this.zzj;
        return zzase == null ? zzase.zzb() : zzase;
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
                return zzbS(zza, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", zzark.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 3:
                return new zzarj();
            case 4:
                return new zzarh((zzari) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzarj.class) {
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

    public final String zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
        return this.zzg;
    }
}
