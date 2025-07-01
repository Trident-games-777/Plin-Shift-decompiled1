package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfqq extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzfqq zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfqm zzg;

    static {
        zzfqq zzfqq = new zzfqq();
        zza = zzfqq;
        zzgyx.zzcb(zzfqq.class, zzfqq);
    }

    private zzfqq() {
    }

    public static zzfqn zza() {
        return (zzfqn) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfqq zzfqq, String str) {
        str.getClass();
        zzfqq.zzc |= 2;
        zzfqq.zze = str;
    }

    static /* synthetic */ void zzd(zzfqq zzfqq, zzfqm zzfqm) {
        zzfqm.getClass();
        zzfqq.zzg = zzfqm;
        zzfqq.zzc |= 8;
    }

    static /* synthetic */ void zzf(zzfqq zzfqq, int i) {
        zzfqq.zzd = 1;
        zzfqq.zzc = 1 | zzfqq.zzc;
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
                return zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzfqo.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzfqq();
            case 4:
                return new zzfqn((zzfqp) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzfqq.class) {
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
