package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhcr extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhcr zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private zzgzj zzg = zzgyx.zzbK();
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private String zzl = "";
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private zzgzj zzu = zzbK();
    private boolean zzv;
    private long zzw;
    private zzgzf zzx = zzbG();
    private boolean zzy;
    private zzgzf zzz = zzbG();

    static {
        zzhcr zzhcr = new zzhcr();
        zza = zzhcr;
        zzgyx.zzcb(zzhcr.class, zzhcr);
    }

    private zzhcr() {
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
                return zzbS(zza, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zzc", "zzd", zzhcq.zza, "zze", "zzf", "zzg", "zzh", zzhco.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", zzhcn.class, "zzv", "zzw", "zzx", zzhce.zza(), "zzy", "zzz", zzhcp.zza});
            case 3:
                return new zzhcr();
            case 4:
                return new zzhck((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhcr.class) {
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
