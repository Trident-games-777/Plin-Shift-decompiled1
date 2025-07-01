package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhes extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzhes zza;
    private static volatile zzhaq zzb;
    private zzgzj zzA = zzgyx.zzbK();
    private zzgzj zzB = zzgyx.zzbK();
    private zzheo zzC;
    private zzgzj zzD = zzbK();
    private zzhcz zzE;
    private String zzF = "";
    private zzhcr zzG;
    private zzgzj zzH = zzbK();
    private zzhds zzI;
    private int zzJ;
    private zzgzj zzK = zzbK();
    private zzgzj zzL = zzbK();
    private long zzM;
    private zzher zzN;
    private zzhdx zzO;
    private String zzP = "";
    private byte zzQ = 2;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private zzhcv zzi;
    private zzgzj zzj = zzbK();
    private zzgzj zzk = zzbK();
    private String zzl = "";
    private zzhed zzm;
    private boolean zzn;
    private zzgzj zzo = zzgyx.zzbK();
    private String zzp = "";
    private boolean zzu;
    private boolean zzv;
    private zzgxp zzw = zzgxp.zzb;
    private zzhek zzx;
    private boolean zzy;
    private String zzz = "";

    static {
        zzhes zzhes = new zzhes();
        zza = zzhes;
        zzgyx.zzcb(zzhes.class, zzhes);
    }

    private zzhes() {
    }

    public static zzhct zzc() {
        return (zzhct) zza.zzaZ();
    }

    static /* synthetic */ void zzi(zzhes zzhes, Iterable iterable) {
        zzgzj zzgzj = zzhes.zzA;
        if (!zzgzj.zzc()) {
            zzhes.zzA = zzgyx.zzbL(zzgzj);
        }
        zzgwy.zzaQ(iterable, zzhes.zzA);
    }

    static /* synthetic */ void zzj(zzhes zzhes, Iterable iterable) {
        zzgzj zzgzj = zzhes.zzB;
        if (!zzgzj.zzc()) {
            zzhes.zzB = zzgyx.zzbL(zzgzj);
        }
        zzgwy.zzaQ(iterable, zzhes.zzB);
    }

    static /* synthetic */ void zzk(zzhes zzhes, zzhei zzhei) {
        zzhei.getClass();
        zzgzj zzgzj = zzhes.zzj;
        if (!zzgzj.zzc()) {
            zzhes.zzj = zzgyx.zzbL(zzgzj);
        }
        zzhes.zzj.add(zzhei);
    }

    static /* synthetic */ void zzl(zzhes zzhes) {
        zzhes.zzc &= -65;
        zzhes.zzl = zza.zzl;
    }

    static /* synthetic */ void zzm(zzhes zzhes, String str) {
        zzhes.zzc |= 64;
        zzhes.zzl = str;
    }

    static /* synthetic */ void zzn(zzhes zzhes, zzhek zzhek) {
        zzhek.getClass();
        zzhes.zzx = zzhek;
        zzhes.zzc |= 8192;
    }

    static /* synthetic */ void zzo(zzhes zzhes, zzhcv zzhcv) {
        zzhcv.getClass();
        zzhes.zzi = zzhcv;
        zzhes.zzc |= 32;
    }

    static /* synthetic */ void zzp(zzhes zzhes, String str) {
        str.getClass();
        zzhes.zzc |= 8;
        zzhes.zzg = str;
    }

    static /* synthetic */ void zzq(zzhes zzhes, zzhed zzhed) {
        zzhed.getClass();
        zzhes.zzm = zzhed;
        zzhes.zzc |= 128;
    }

    static /* synthetic */ void zzr(zzhes zzhes, String str) {
        str.getClass();
        zzhes.zzc |= 4;
        zzhes.zzf = str;
    }

    static /* synthetic */ void zzs(zzhes zzhes, int i) {
        zzhes.zzd = i - 1;
        zzhes.zzc |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzQ);
            case 1:
                this.zzQ = obj == null ? (byte) 0 : 1;
                return null;
            case 2:
                return zzbS(zza, "\u0001#\u0000\u0001\u0001##\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018#ဈ\u0019", new Object[]{"zzc", "zzf", "zzg", "zzh", "zzj", zzhei.class, "zzn", "zzo", "zzp", "zzu", "zzv", "zzd", zzhee.zza, "zze", zzhcs.zza, "zzi", "zzl", "zzm", "zzw", "zzk", zzhew.class, "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", zzhfc.class, "zzE", "zzF", "zzG", "zzH", zzhdd.class, "zzI", "zzJ", zzhem.zza, "zzK", zzhdv.class, "zzL", zzhea.class, "zzM", "zzN", "zzO", "zzP"});
            case 3:
                return new zzhes();
            case 4:
                return new zzhct((zzhfd) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzhes.class) {
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
        return this.zzl;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzj;
    }
}
