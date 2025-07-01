package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgsc extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgsc zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgsi zzd;
    private zzgtt zze;

    static {
        zzgsc zzgsc = new zzgsc();
        zza = zzgsc;
        zzgyx.zzcb(zzgsc.class, zzgsc);
    }

    private zzgsc() {
    }

    public static zzgsa zza() {
        return (zzgsa) zza.zzaZ();
    }

    public static zzgsc zzc(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgsc) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzg(zzgsc zzgsc, zzgsi zzgsi) {
        zzgsi.getClass();
        zzgsc.zzd = zzgsi;
        zzgsc.zzc |= 1;
    }

    static /* synthetic */ void zzh(zzgsc zzgsc, zzgtt zzgtt) {
        zzgtt.getClass();
        zzgsc.zze = zzgtt;
        zzgsc.zzc |= 2;
    }

    public final zzgsi zzd() {
        zzgsi zzgsi = this.zzd;
        return zzgsi == null ? zzgsi.zzd() : zzgsi;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgsc();
            case 4:
                return new zzgsa((zzgsb) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgsc.class) {
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

    public final zzgtt zzf() {
        zzgtt zzgtt = this.zze;
        return zzgtt == null ? zzgtt.zzf() : zzgtt;
    }
}
