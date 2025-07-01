package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfqm extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzfqm zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgzf zzd = zzbG();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzfqm zzfqm = new zzfqm();
        zza = zzfqm;
        zzgyx.zzcb(zzfqm.class, zzfqm);
    }

    private zzfqm() {
    }

    public static zzfqk zza() {
        return (zzfqk) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfqm zzfqm, String str) {
        str.getClass();
        zzfqm.zzc |= 1;
        zzfqm.zze = str;
    }

    static /* synthetic */ void zzd(zzfqm zzfqm, int i) {
        zzgzf zzgzf = zzfqm.zzd;
        if (!zzgzf.zzc()) {
            zzfqm.zzd = zzgyx.zzbH(zzgzf);
        }
        zzfqm.zzd.zzi(2);
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
                return zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzc", "zzd", zzfqj.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzfqm();
            case 4:
                return new zzfqk((zzfql) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzfqm.class) {
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
