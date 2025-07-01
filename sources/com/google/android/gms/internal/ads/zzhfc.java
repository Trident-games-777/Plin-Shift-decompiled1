package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhfc extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhfc zza;
    private static volatile zzhaq zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private int zzf = 4;
    private zzgzj zzg = zzgyx.zzbK();
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;
    private zzgzj zzl = zzbK();
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzu;

    static {
        zzhfc zzhfc = new zzhfc();
        zza = zzhfc;
        zzgyx.zzcb(zzhfc.class, zzhfc);
    }

    private zzhfc() {
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
                return zzbS(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zzc", "zzd", "zzf", zzhfb.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzhfa.class, "zze", "zzm", zzhey.zza, "zzn", "zzo", "zzp", "zzu"});
            case 3:
                return new zzhfc();
            case 4:
                return new zzhex((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhfc.class) {
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
