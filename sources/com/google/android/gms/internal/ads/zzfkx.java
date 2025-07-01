package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfkx extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzfkx zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public zzgzj zzc = zzbK();

    static {
        zzfkx zzfkx = new zzfkx();
        zza = zzfkx;
        zzgyx.zzcb(zzfkx.class, zzfkx);
    }

    private zzfkx() {
    }

    public static zzfkt zzb() {
        return (zzfkt) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzfkx zzfkx, zzfkv zzfkv) {
        zzfkv.getClass();
        zzgzj zzgzj = zzfkx.zzc;
        if (!zzgzj.zzc()) {
            zzfkx.zzc = zzgyx.zzbL(zzgzj);
        }
        zzfkx.zzc.add(zzfkv);
    }

    public final int zza() {
        return this.zzc.size();
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
                return zzbS(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfkv.class});
            case 3:
                return new zzfkx();
            case 4:
                return new zzfkt((zzfkw) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzfkx.class) {
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
