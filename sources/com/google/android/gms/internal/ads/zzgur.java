package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgur extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgur zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private zzgzj zzd = zzbK();

    static {
        zzgur zzgur = new zzgur();
        zza = zzgur;
        zzgyx.zzcb(zzgur.class, zzgur);
    }

    private zzgur() {
    }

    public static zzgun zza() {
        return (zzgun) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzgur zzgur, zzgup zzgup) {
        zzgup.getClass();
        zzgzj zzgzj = zzgur.zzd;
        if (!zzgzj.zzc()) {
            zzgur.zzd = zzgyx.zzbL(zzgzj);
        }
        zzgur.zzd.add(zzgup);
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
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgup.class});
            case 3:
                return new zzgur();
            case 4:
                return new zzgun((zzguq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgur.class) {
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
