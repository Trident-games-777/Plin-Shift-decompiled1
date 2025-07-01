package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgux extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgux zza;
    private static volatile zzhaq zzb;
    private String zzc = "";

    static {
        zzgux zzgux = new zzgux();
        zza = zzgux;
        zzgyx.zzcb(zzgux.class, zzgux);
    }

    private zzgux() {
    }

    public static zzguv zza() {
        return (zzguv) zza.zzaZ();
    }

    public static zzgux zzc() {
        return zza;
    }

    public static zzgux zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgux) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    static /* synthetic */ void zzg(zzgux zzgux, String str) {
        str.getClass();
        zzgux.zzc = str;
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
                return zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case 3:
                return new zzgux();
            case 4:
                return new zzguv((zzguw) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgux.class) {
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

    public final String zzf() {
        return this.zzc;
    }
}
