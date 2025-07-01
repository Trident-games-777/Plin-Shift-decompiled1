package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgyd implements zzhcc {
    private final zzgyc zza;

    private zzgyd(zzgyc zzgyc) {
        zzgzk.zzc(zzgyc, "output");
        zzgyc zzgyc2 = zzgyc;
        this.zza = zzgyc;
        zzgyc.zze = this;
    }

    public static zzgyd zza(zzgyc zzgyc) {
        zzgyd zzgyd = zzgyc.zze;
        if (zzgyd != null) {
            return zzgyd;
        }
        return new zzgyd(zzgyc);
    }

    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzD(int i, long j) throws IOException {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    public final void zzG(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    public final void zzK(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzM(i, z);
    }

    public final void zzd(int i, zzgxp zzgxp) throws IOException {
        this.zza.zzN(i, zzgxp);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzN(i, (zzgxp) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zzq(int i, Object obj, zzhbb zzhbb) throws IOException {
        zzgyc zzgyc = this.zza;
        zzgyc.zzs(i, 3);
        zzhbb.zzj((zzhai) obj, zzgyc.zze);
        zzgyc.zzs(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    public final void zzv(int i, Object obj, zzhbb zzhbb) throws IOException {
        this.zza.zzn(i, (zzhai) obj, zzhbb);
    }

    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzgxp) {
            this.zza.zzp(i, (zzgxp) obj);
        } else {
            this.zza.zzo(i, (zzhai) obj);
        }
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzz(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgzu) {
            zzgzu zzgzu = (zzgzu) list;
            while (i2 < list.size()) {
                Object zzc = zzgzu.zzc();
                if (zzc instanceof String) {
                    this.zza.zzq(i, (String) zzc);
                } else {
                    this.zza.zzN(i, (zzgxp) zzc);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzq(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    i3 += zzgyc.zzD(zzgyy.zzd(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzu(zzgyy.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzt(i, zzgyy.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgyc.zzD(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgzx.size(); i4++) {
                    i3 += zzgyc.zzE(zzgzx.zza(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgzx.size()) {
                    this.zza.zzw(zzgzx.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgzx.size()) {
                this.zza.zzv(i, zzgzx.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgyc.zzE(((Long) list.get(i6)).longValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    zzgyy.zzd(i4);
                    i3 += 4;
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzi(zzgyy.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzh(i, zzgyy.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgzx.size(); i4++) {
                    zzgzx.zza(i4);
                    i3 += 8;
                }
                this.zza.zzu(i3);
                while (i2 < zzgzx.size()) {
                    this.zza.zzk(zzgzx.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgzx.size()) {
                this.zza.zzj(i, zzgzx.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxf) {
            zzgxf zzgxf = (zzgxf) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxf.size(); i4++) {
                    zzgxf.zzh(i4);
                    i3++;
                }
                this.zza.zzu(i3);
                while (i2 < zzgxf.size()) {
                    this.zza.zzL(zzgxf.zzh(i2) ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < zzgxf.size()) {
                this.zza.zzM(i, zzgxf.zzh(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).booleanValue();
                i5++;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzL(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzM(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    i3 += zzgyc.zzE((long) zzgyy.zzd(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzm(zzgyy.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzl(i, zzgyy.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgyc.zzE((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgzx.size(); i4++) {
                    zzgzx.zza(i4);
                    i3 += 8;
                }
                this.zza.zzu(i3);
                while (i2 < zzgzx.size()) {
                    this.zza.zzk(zzgzx.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgzx.size()) {
                this.zza.zzj(i, zzgzx.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgye) {
            zzgye zzgye = (zzgye) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgye.size(); i4++) {
                    zzgye.zzd(i4);
                    i3 += 8;
                }
                this.zza.zzu(i3);
                while (i2 < zzgye.size()) {
                    this.zza.zzk(Double.doubleToRawLongBits(zzgye.zzd(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzgye.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzgye.zzd(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).doubleValue();
                i5 += 8;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyo) {
            zzgyo zzgyo = (zzgyo) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyo.size(); i4++) {
                    zzgyo.zzd(i4);
                    i3 += 4;
                }
                this.zza.zzu(i3);
                while (i2 < zzgyo.size()) {
                    this.zza.zzi(Float.floatToRawIntBits(zzgyo.zzd(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyo.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgyo.zzd(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).floatValue();
                i5 += 4;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    zzgyy.zzd(i4);
                    i3 += 4;
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzi(zzgyy.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzh(i, zzgyy.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    int zzd = zzgyy.zzd(i4);
                    i3 += zzgyc.zzD((zzd >> 31) ^ (zzd + zzd));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    zzgyc zzgyc = this.zza;
                    int zzd2 = zzgyy.zzd(i2);
                    zzgyc.zzu((zzd2 >> 31) ^ (zzd2 + zzd2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                zzgyc zzgyc2 = this.zza;
                int zzd3 = zzgyy.zzd(i2);
                zzgyc2.zzt(i, (zzd3 >> 31) ^ (zzd3 + zzd3));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzgyc.zzD((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                zzgyc zzgyc3 = this.zza;
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzgyc3.zzu((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzgyc zzgyc4 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzgyc4.zzt(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgzx.size(); i4++) {
                    long zza2 = zzgzx.zza(i4);
                    i3 += zzgyc.zzE((zza2 >> 63) ^ (zza2 + zza2));
                }
                this.zza.zzu(i3);
                while (i2 < zzgzx.size()) {
                    zzgyc zzgyc = this.zza;
                    long zza3 = zzgzx.zza(i2);
                    zzgyc.zzw((zza3 >> 63) ^ (zza3 + zza3));
                    i2++;
                }
                return;
            }
            while (i2 < zzgzx.size()) {
                zzgyc zzgyc2 = this.zza;
                long zza4 = zzgzx.zza(i2);
                zzgyc2.zzv(i, (zza4 >> 63) ^ (zza4 + zza4));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzgyc.zzE((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                zzgyc zzgyc3 = this.zza;
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzgyc3.zzw((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzgyc zzgyc4 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzgyc4.zzv(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    i3 += zzgyc.zzE((long) zzgyy.zzd(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzm(zzgyy.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzl(i, zzgyy.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgyc.zzE((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgzx.size(); i4++) {
                    i3 += zzgyc.zzE(zzgzx.zza(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgzx.size()) {
                    this.zza.zzw(zzgzx.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgzx.size()) {
                this.zza.zzv(i, zzgzx.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgyc.zzE(((Long) list.get(i6)).longValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }
}
