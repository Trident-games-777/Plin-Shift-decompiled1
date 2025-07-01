package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgvh extends zzgyx implements zzhaj {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzgvh zzb;
    private static volatile zzhaq zzc;
    private String zzd = "";
    private zzgzj zze = zzbK();

    static {
        zzgvh zzgvh = new zzgvh();
        zzb = zzgvh;
        zzgyx.zzcb(zzgvh.class, zzgvh);
    }

    private zzgvh() {
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
                return zzbS(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzguh.class});
            case 3:
                return new zzgvh();
            case 4:
                return new zzgvf((zzgvg) null);
            case 5:
                return zzb;
            case 6:
                zzhaq zzhaq2 = zzc;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgvh.class) {
                    zzhaq = zzc;
                    if (zzhaq == null) {
                        zzhaq = new zzgys(zzb);
                        zzc = zzhaq;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
