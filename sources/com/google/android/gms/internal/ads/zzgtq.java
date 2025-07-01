package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgtq extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgtq zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private zzgtw zze;
    /* access modifiers changed from: private */
    public zzgxp zzf = zzgxp.zzb;

    static {
        zzgtq zzgtq = new zzgtq();
        zza = zzgtq;
        zzgyx.zzcb(zzgtq.class, zzgtq);
    }

    private zzgtq() {
    }

    public static zzgto zzb() {
        return (zzgto) zza.zzaZ();
    }

    public static zzgtq zzd() {
        return zza;
    }

    public static zzgtq zzf(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgtq) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzi() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzk(zzgtq zzgtq, zzgtw zzgtw) {
        zzgtw.getClass();
        zzgtq.zze = zzgtw;
        zzgtq.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgtq();
            case 4:
                return new zzgto((zzgtp) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgtq.class) {
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

    public final zzgtw zzg() {
        zzgtw zzgtw = this.zze;
        return zzgtw == null ? zzgtw.zzf() : zzgtw;
    }

    public final zzgxp zzh() {
        return this.zzf;
    }
}
