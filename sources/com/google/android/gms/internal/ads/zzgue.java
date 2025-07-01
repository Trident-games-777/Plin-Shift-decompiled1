package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgue extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgue zza;
    private static volatile zzhaq zzb;
    private String zzc = "";
    private zzgxp zzd = zzgxp.zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgue zzgue = new zzgue();
        zza = zzgue;
        zzgyx.zzcb(zzgue.class, zzgue);
    }

    private zzgue() {
    }

    public static zzguc zza() {
        return (zzguc) zza.zzaZ();
    }

    public static zzguc zzb(zzgue zzgue) {
        return (zzguc) zza.zzba(zzgue);
    }

    public static zzgue zzd() {
        return zza;
    }

    public static zzgue zzf(byte[] bArr, zzgyh zzgyh) throws zzgzm {
        return (zzgue) zzgyx.zzbx(zza, bArr, zzgyh);
    }

    static /* synthetic */ void zzk(zzgue zzgue, String str) {
        str.getClass();
        zzgue.zzc = str;
    }

    static /* synthetic */ void zzl(zzgue zzgue, zzgxp zzgxp) {
        zzgxp.getClass();
        zzgue.zzd = zzgxp;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgue();
            case 4:
                return new zzguc((zzgud) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgue.class) {
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

    public final zzgve zzg() {
        zzgve zzb2 = zzgve.zzb(this.zze);
        return zzb2 == null ? zzgve.UNRECOGNIZED : zzb2;
    }

    public final zzgxp zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
