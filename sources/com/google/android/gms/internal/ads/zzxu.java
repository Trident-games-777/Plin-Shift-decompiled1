package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzxu extends zzxw implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzxu(int i, zzbw zzbw, int i2, zzxp zzxp, int i3, String str) {
        super(i, zzbw, i2);
        zzfzo zzfzo;
        int i4;
        int i5 = 0;
        this.zzf = zzlo.zza(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzxp.zzv;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        if (zzxp.zzt.isEmpty()) {
            zzfzo = zzfzo.zzo("");
        } else {
            zzfzo = zzxp.zzt;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= zzfzo.size()) {
                i8 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            boolean z = zzxp.zzw;
            i4 = zzyb.zzc(this.zzd, (String) zzfzo.get(i8), false);
            if (i4 > 0) {
                break;
            }
            i8++;
        }
        this.zzi = i8;
        this.zzj = i4;
        int zzb = zzyb.zzb(this.zzd.zzf, zzxp.zzu);
        this.zzk = zzb;
        this.zzm = (this.zzd.zzf & 1088) != 0;
        int zzc = zzyb.zzc(this.zzd, str, zzyb.zzh(str) == null);
        this.zzl = zzc;
        boolean z2 = i4 > 0 || (zzxp.zzt.isEmpty() && zzb > 0) || this.zzg || (this.zzh && zzc > 0);
        if (zzlo.zza(i3, zzxp.zzN) && z2) {
            i5 = 1;
        }
        this.zze = i5;
    }

    /* renamed from: zza */
    public final int compareTo(zzxu zzxu) {
        zzgaz zzgaz;
        zzfzd zzd = zzfzd.zzj().zzd(this.zzf, zzxu.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzxu.zzi), zzgaz.zzc().zza()).zzb(this.zzj, zzxu.zzj).zzb(this.zzk, zzxu.zzk).zzd(this.zzg, zzxu.zzg);
        Boolean valueOf = Boolean.valueOf(this.zzh);
        Boolean valueOf2 = Boolean.valueOf(zzxu.zzh);
        if (this.zzj == 0) {
            zzgaz = zzgaz.zzc();
        } else {
            zzgaz = zzgaz.zzc().zza();
        }
        zzfzd zzb = zzd.zzc(valueOf, valueOf2, zzgaz).zzb(this.zzl, zzxu.zzl);
        if (this.zzk == 0) {
            zzb = zzb.zze(this.zzm, zzxu.zzm);
        }
        return zzb.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxw zzxw) {
        zzxu zzxu = (zzxu) zzxw;
        return false;
    }
}
