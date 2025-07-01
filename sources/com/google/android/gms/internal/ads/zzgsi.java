package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgsi extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgsi zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private zzgsl zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgsi zzgsi = new zzgsi();
        zza = zzgsi;
        zzgyx.zzcb(zzgsi.class, zzgsi);
    }

    private zzgsi() {
    }

    public static zzgsg zzb() {
        return (zzgsg) zza.zzaZ();
    }

    public static zzgsi zzd() {
        return zza;
    }

    static /* synthetic */ void zzh(zzgsi zzgsi, zzgsl zzgsl) {
        zzgsl.getClass();
        zzgsi.zzd = zzgsl;
        zzgsi.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
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
                return zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgsi();
            case 4:
                return new zzgsg((zzgsh) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgsi.class) {
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

    public final zzgsl zzf() {
        zzgsl zzgsl = this.zzd;
        return zzgsl == null ? zzgsl.zzd() : zzgsl;
    }
}
