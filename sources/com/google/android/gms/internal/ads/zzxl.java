package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzxl extends zzxw implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxp zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzxl(int i, zzbw zzbw, int i2, zzxp zzxp, int i3, boolean z, zzfwr zzfwr, int i4) {
        super(i, zzbw, i2);
        int i5;
        int i6;
        int i7;
        boolean z2;
        this.zzh = zzxp;
        int i8 = 1;
        int i9 = true != zzxp.zzL ? 16 : 24;
        boolean z3 = zzxp.zzH;
        this.zzg = zzyb.zzh(this.zzd.zzd);
        this.zzi = zzlo.zza(i3, false);
        int i10 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i10 >= zzxp.zzn.size()) {
                i6 = 0;
                i10 = Integer.MAX_VALUE;
                break;
            }
            i6 = zzyb.zzc(this.zzd, (String) zzxp.zzn.get(i10), false);
            if (i6 > 0) {
                break;
            }
            i10++;
        }
        this.zzk = i10;
        this.zzj = i6;
        int i11 = this.zzd.zzf;
        int i12 = zzxp.zzo;
        this.zzl = zzyb.zzb(i11, 0);
        zzad zzad = this.zzd;
        int i13 = zzad.zzf;
        this.zzm = i13 == 0 || (i13 & 1) != 0;
        this.zzp = 1 == (zzad.zze & 1);
        this.zzq = zzad.zzC;
        this.zzr = zzad.zzD;
        this.zzs = zzad.zzj;
        if (zzad.zzj != -1) {
            int i14 = zzxp.zzq;
        }
        if (zzad.zzC != -1) {
            int i15 = zzxp.zzp;
        }
        this.zzf = zzfwr.zza(zzad);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] split = zzen.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i16 = 0; i16 < split.length; i16++) {
            split[i16] = zzen.zzE(split[i16]);
        }
        int i17 = 0;
        while (true) {
            if (i17 >= split.length) {
                i7 = 0;
                i17 = Integer.MAX_VALUE;
                break;
            }
            i7 = zzyb.zzc(this.zzd, split[i17], false);
            if (i7 > 0) {
                break;
            }
            i17++;
        }
        this.zzn = i17;
        this.zzo = i7;
        int i18 = 0;
        while (true) {
            if (i18 < zzxp.zzr.size()) {
                String str = this.zzd.zzo;
                if (str != null && str.equals(zzxp.zzr.get(i18))) {
                    i5 = i18;
                    break;
                }
                i18++;
            } else {
                break;
            }
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzxp zzxp2 = this.zzh;
        if (zzlo.zza(i3, zzxp2.zzN) && ((z2 = this.zzf) || zzxp2.zzG)) {
            zzbz zzbz = zzxp2.zzs;
            if (zzlo.zza(i3, false) && z2 && this.zzd.zzj != -1) {
                boolean z4 = zzxp2.zzz;
                boolean z5 = zzxp2.zzy;
                if ((zzxp2.zzP || !z) && (i9 & i3) != 0) {
                    i8 = 2;
                }
            }
        } else {
            i8 = 0;
        }
        this.zze = i8;
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxw zzxw) {
        String str;
        zzxl zzxl = (zzxl) zzxw;
        boolean z = this.zzh.zzJ;
        zzad zzad = this.zzd;
        int i = zzad.zzC;
        if (i == -1) {
            return false;
        }
        zzad zzad2 = zzxl.zzd;
        if (i != zzad2.zzC || (str = zzad.zzo) == null || !TextUtils.equals(str, zzad2.zzo)) {
            return false;
        }
        zzxp zzxp = this.zzh;
        boolean z2 = zzxp.zzI;
        int i2 = this.zzd.zzD;
        if (i2 == -1 || i2 != zzxl.zzd.zzD) {
            return false;
        }
        boolean z3 = zzxp.zzK;
        return this.zzu == zzxl.zzu && this.zzv == zzxl.zzv;
    }

    /* renamed from: zza */
    public final int compareTo(zzxl zzxl) {
        zzgaz zzgaz;
        if (!this.zzf || !this.zzi) {
            zzgaz = zzyb.zzc.zza();
        } else {
            zzgaz = zzyb.zzc;
        }
        zzfzd zzc = zzfzd.zzj().zzd(this.zzi, zzxl.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzxl.zzk), zzgaz.zzc().zza()).zzb(this.zzj, zzxl.zzj).zzb(this.zzl, zzxl.zzl).zzd(this.zzp, zzxl.zzp).zzd(this.zzm, zzxl.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzxl.zzn), zzgaz.zzc().zza()).zzb(this.zzo, zzxl.zzo).zzd(this.zzf, zzxl.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzxl.zzt), zzgaz.zzc().zza());
        boolean z = this.zzh.zzy;
        zzfzd zzc2 = zzc.zzd(this.zzu, zzxl.zzu).zzd(this.zzv, zzxl.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzxl.zzq), zzgaz).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzxl.zzr), zzgaz);
        if (Objects.equals(this.zzg, zzxl.zzg)) {
            zzc2 = zzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzxl.zzs), zzgaz);
        }
        return zzc2.zza();
    }
}
