package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzatl extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzatl zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private long zzd;
    private String zze = "";
    private zzgxp zzf = zzgxp.zzb;

    static {
        zzatl zzatl = new zzatl();
        zza = zzatl;
        zzgyx.zzcb(zzatl.class, zzatl);
    }

    private zzatl() {
    }

    public static zzatl zzc() {
        return zza;
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzgxp zzd() {
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
                return zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzatl();
            case 4:
                return new zzatk((zzatq) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzatl.class) {
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
        return this.zze;
    }

    public final boolean zzg() {
        return (this.zzc & 1) != 0;
    }
}
