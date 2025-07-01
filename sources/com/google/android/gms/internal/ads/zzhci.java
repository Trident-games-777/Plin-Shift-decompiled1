package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhci extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhci zza;
    private static volatile zzhaq zzb;
    private zzgzj zzc = zzbK();

    static {
        zzhci zzhci = new zzhci();
        zza = zzhci;
        zzgyx.zzcb(zzhci.class, zzhci);
    }

    private zzhci() {
    }

    public static zzhch zzc() {
        return (zzhch) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhci zzhci, zzhcg zzhcg) {
        zzhcg.getClass();
        zzgzj zzgzj = zzhci.zzc;
        if (!zzgzj.zzc()) {
            zzhci.zzc = zzgyx.zzbL(zzgzj);
        }
        zzhci.zzc.add(zzhcg);
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
                return zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhcg.class});
            case 3:
                return new zzhci();
            case 4:
                return new zzhch((zzhcj) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhci.class) {
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
