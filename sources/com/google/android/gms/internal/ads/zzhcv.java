package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhcv extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhcv zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhcv zzhcv = new zzhcv();
        zza = zzhcv;
        zzgyx.zzcb(zzhcv.class, zzhcv);
    }

    private zzhcv() {
    }

    public static zzhcu zzc() {
        return (zzhcu) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhcv zzhcv, String str) {
        zzhcv.zzc |= 1;
        zzhcv.zzd = str;
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
                return zzbS(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzhcv();
            case 4:
                return new zzhcu((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhcv.class) {
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
