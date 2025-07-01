package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrq extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgrq zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    /* access modifiers changed from: private */
    public zzgxp zze = zzgxp.zzb;
    private zzgrw zzf;

    static {
        zzgrq zzgrq = new zzgrq();
        zza = zzgrq;
        zzgyx.zzcb(zzgrq.class, zzgrq);
    }

    private zzgrq() {
    }

    public static zzgro zzb() {
        return (zzgro) zza.zzaZ();
    }

    public static zzgrq zzd(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        return (zzgrq) zzgyx.zzbr(zza, zzgxp, zzgyh);
    }

    public static zzhaq zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgrq zzgrq, zzgrw zzgrw) {
        zzgrw.getClass();
        zzgrq.zzf = zzgrw;
        zzgrq.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
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
                return zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgrq();
            case 4:
                return new zzgro((zzgrp) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgrq.class) {
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

    public final zzgrw zzf() {
        zzgrw zzgrw = this.zzf;
        return zzgrw == null ? zzgrw.zzd() : zzgrw;
    }

    public final zzgxp zzg() {
        return this.zze;
    }
}
