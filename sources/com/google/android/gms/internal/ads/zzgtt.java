package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgtt extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgtt zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgtw zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgtt zzgtt = new zzgtt();
        zza = zzgtt;
        zzgyx.zzcb(zzgtt.class, zzgtt);
    }

    private zzgtt() {
    }

    public static zzgtr zzc() {
        return (zzgtr) zza.zzaZ();
    }

    public static zzgtt zzf() {
        return zza;
    }

    public static zzgtt zzg(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgtt) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzj(zzgtt zzgtt, zzgtw zzgtw) {
        zzgtw.getClass();
        zzgtt.zzd = zzgtw;
        zzgtt.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgtt();
            case 4:
                return new zzgtr((zzgts) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgtt.class) {
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

    public final zzgtw zzh() {
        zzgtw zzgtw = this.zzd;
        return zzgtw == null ? zzgtw.zzf() : zzgtw;
    }
}
