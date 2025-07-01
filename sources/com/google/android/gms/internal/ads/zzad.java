package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzad {
    public static final /* synthetic */ int zzK = 0;
    public final int zzA;
    public final zzm zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    private int zzL;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzbd zzl;
    public final Object zzm;
    public final String zzn;
    public final String zzo;
    public final int zzp;
    public final int zzq;
    public final List zzr;
    public final zzw zzs;
    public final long zzt;
    public final int zzu;
    public final int zzv;
    public final float zzw;
    public final int zzx;
    public final float zzy;
    public final byte[] zzz;

    static {
        new zzad(new zzab());
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
    }

    private zzad(zzab zzab) {
        boolean z;
        String str;
        this.zza = zzab.zza;
        String zzE2 = zzen.zzE(zzab.zzd);
        this.zzd = zzE2;
        int i = 0;
        if (zzab.zzc.isEmpty() && zzab.zzb != null) {
            this.zzc = zzfzo.zzo(new zzai(zzE2, zzab.zzb));
            this.zzb = zzab.zzb;
        } else if (zzab.zzc.isEmpty() || zzab.zzb != null) {
            if (!zzab.zzc.isEmpty() || zzab.zzb != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= zzab.zzc.size()) {
                        z = false;
                        break;
                    } else if (((zzai) zzab.zzc.get(i2)).zzb.equals(zzab.zzb)) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = true;
            zzdb.zzf(z);
            this.zzc = zzab.zzc;
            this.zzb = zzab.zzb;
        } else {
            this.zzc = zzab.zzc;
            List zzao = zzab.zzc;
            Iterator it = zzao.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzai) zzao.get(0)).zzb;
                    break;
                }
                zzai zzai = (zzai) it.next();
                if (TextUtils.equals(zzai.zza, zzE2)) {
                    str = zzai.zzb;
                    break;
                }
            }
            this.zzb = str;
        }
        this.zze = zzab.zze;
        zzdb.zzg(true, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.zzf = zzab.zzf;
        this.zzg = 0;
        int zzd2 = zzab.zzh;
        this.zzh = zzd2;
        int zzn2 = zzab.zzi;
        this.zzi = zzn2;
        this.zzj = zzn2 != -1 ? zzn2 : zzd2;
        this.zzk = zzab.zzj;
        this.zzl = zzab.zzk;
        this.zzm = null;
        this.zzn = zzab.zzl;
        this.zzo = zzab.zzm;
        this.zzp = zzab.zzn;
        this.zzq = zzab.zzo;
        this.zzr = zzab.zzp == null ? Collections.emptyList() : zzab.zzp;
        zzw zzw2 = zzab.zzq;
        this.zzs = zzw2;
        this.zzt = zzab.zzr;
        this.zzu = zzab.zzs;
        this.zzv = zzab.zzt;
        this.zzw = zzab.zzu;
        this.zzx = zzab.zzv == -1 ? 0 : zzab.zzv;
        this.zzy = zzab.zzw == -1.0f ? 1.0f : zzab.zzw;
        this.zzz = zzab.zzx;
        this.zzA = zzab.zzy;
        this.zzB = zzab.zzz;
        this.zzC = zzab.zzA;
        this.zzD = zzab.zzB;
        this.zzE = zzab.zzC;
        this.zzF = zzab.zzD == -1 ? 0 : zzab.zzD;
        this.zzG = zzab.zzE != -1 ? zzab.zzE : i;
        this.zzH = zzab.zzF;
        this.zzI = zzab.zzG;
        if (zzab.zzH != 0 || zzw2 == null) {
            this.zzJ = zzab.zzH;
        } else {
            this.zzJ = 1;
        }
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzad zzad = (zzad) obj;
            int i2 = this.zzL;
            if ((i2 == 0 || (i = zzad.zzL) == 0 || i2 == i) && this.zze == zzad.zze && this.zzf == zzad.zzf && this.zzh == zzad.zzh && this.zzi == zzad.zzi && this.zzp == zzad.zzp && this.zzt == zzad.zzt && this.zzu == zzad.zzu && this.zzv == zzad.zzv && this.zzx == zzad.zzx && this.zzA == zzad.zzA && this.zzC == zzad.zzC && this.zzD == zzad.zzD && this.zzE == zzad.zzE && this.zzF == zzad.zzF && this.zzG == zzad.zzG && this.zzH == zzad.zzH && this.zzJ == zzad.zzJ && Float.compare(this.zzw, zzad.zzw) == 0 && Float.compare(this.zzy, zzad.zzy) == 0 && Objects.equals(this.zza, zzad.zza) && Objects.equals(this.zzb, zzad.zzb) && this.zzc.equals(zzad.zzc) && Objects.equals(this.zzk, zzad.zzk) && Objects.equals(this.zzn, zzad.zzn) && Objects.equals(this.zzo, zzad.zzo) && Objects.equals(this.zzd, zzad.zzd) && Arrays.equals(this.zzz, zzad.zzz) && Objects.equals(this.zzl, zzad.zzl) && Objects.equals(this.zzB, zzad.zzB) && Objects.equals(this.zzs, zzad.zzs) && zzd(zzad) && Objects.equals((Object) null, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzB);
        return "Format(" + this.zza + ", " + this.zzb + ", " + this.zzn + ", " + this.zzo + ", " + this.zzk + ", " + this.zzj + ", " + this.zzd + ", [" + this.zzu + ", " + this.zzv + ", " + this.zzw + ", " + valueOf + "], [" + this.zzC + ", " + this.zzD + "])";
    }

    public final int zza() {
        int i;
        int i2 = this.zzu;
        if (i2 == -1 || (i = this.zzv) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzab zzb() {
        return new zzab(this, (zzac) null);
    }

    public final zzad zzc(int i) {
        zzab zzab = new zzab(this, (zzac) null);
        zzab.zzD(i);
        return new zzad(zzab);
    }

    public final boolean zzd(zzad zzad) {
        if (this.zzr.size() != zzad.zzr.size()) {
            return false;
        }
        for (int i = 0; i < this.zzr.size(); i++) {
            if (!Arrays.equals((byte[]) this.zzr.get(i), (byte[]) zzad.zzr.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzL;
        if (i7 != 0) {
            return i7;
        }
        String str = this.zza;
        int i8 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int hashCode = ((((i + 527) * 31) + i2) * 31) + this.zzc.hashCode();
        String str3 = this.zzd;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.hashCode();
        }
        int i9 = ((((((((((hashCode * 31) + i3) * 31) + this.zze) * 31) + this.zzf) * 961) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        if (str4 == null) {
            i4 = 0;
        } else {
            i4 = str4.hashCode();
        }
        int i10 = (i9 + i4) * 31;
        zzbd zzbd = this.zzl;
        if (zzbd == null) {
            i5 = 0;
        } else {
            i5 = zzbd.hashCode();
        }
        int i11 = (i10 + i5) * 961;
        String str5 = this.zzn;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.hashCode();
        }
        int i12 = (i11 + i6) * 31;
        String str6 = this.zzo;
        if (str6 != null) {
            i8 = str6.hashCode();
        }
        int floatToIntBits = ((((((((((((((((((((((((((((((((((i12 + i8) * 31) + this.zzp) * 31) + ((int) this.zzt)) * 31) + this.zzu) * 31) + this.zzv) * 31) + Float.floatToIntBits(this.zzw)) * 31) + this.zzx) * 31) + Float.floatToIntBits(this.zzy)) * 31) + this.zzA) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) + this.zzF) * 31) + this.zzG) * 31) + this.zzH) * 31) - 1) * 31) - 1) * 31) + this.zzJ;
        this.zzL = floatToIntBits;
        return floatToIntBits;
    }
}
