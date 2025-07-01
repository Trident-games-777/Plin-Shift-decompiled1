package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzyg extends zzyj {
    /* access modifiers changed from: protected */
    public abstract Pair zzd(zzyf zzyf, int[][][] iArr, int[] iArr2, zzur zzur, zzbv zzbv) throws zzig;

    public final zzyk zzo(zzlq[] zzlqArr, zzwr zzwr, zzur zzur, zzbv zzbv) throws zzig {
        boolean z;
        int[] iArr;
        zzwr zzwr2 = zzwr;
        int[] iArr2 = new int[3];
        zzbw[][] zzbwArr = new zzbw[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzwr2.zzb;
            zzbwArr[i] = new zzbw[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzlqArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzwr2.zzb) {
            zzbw zzb = zzwr2.zzb(i5);
            int i6 = zzb.zzc;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzlq zzlq = zzlqArr[i8];
                int i10 = 0;
                for (int i11 = 0; i11 < zzb.zza; i11++) {
                    i10 = Math.max(i10, zzlq.zzY(zzb.zzb(i11)) & 7);
                }
                boolean z3 = iArr2[i8] == 0;
                if (i10 > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = i10;
                } else if (i10 == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = i10;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzb.zza];
            } else {
                zzlq zzlq2 = zzlqArr[i7];
                int[] iArr5 = new int[zzb.zza];
                for (int i12 = 0; i12 < zzb.zza; i12++) {
                    iArr5[i12] = zzlq2.zzY(zzb.zzb(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i7];
            zzbwArr[i7][i13] = zzb;
            iArr3[i7][i13] = iArr;
            iArr2[i7] = i13 + 1;
            i5++;
            i3 = 2;
        }
        zzwr[] zzwrArr = new zzwr[i3];
        String[] strArr = new String[i3];
        int[][][] iArr6 = iArr3;
        int[] iArr7 = new int[i3];
        int i14 = 0;
        while (i14 < i3) {
            int i15 = iArr2[i14];
            zzwrArr[i14] = new zzwr((zzbw[]) zzen.zzO(zzbwArr[i14], i15));
            iArr6[i14] = (int[][]) zzen.zzO(iArr6[i14], i15);
            strArr[i14] = zzlqArr[i14].zzU();
            iArr7[i14] = zzlqArr[i14].zzb();
            i14++;
            i3 = 2;
        }
        int i16 = i3;
        int[] iArr8 = iArr4;
        zzyf zzyf = new zzyf(strArr, iArr7, zzwrArr, iArr8, iArr6, new zzwr((zzbw[]) zzen.zzO(zzbwArr[i16], iArr2[i16])));
        Pair zzd = zzd(zzyf, iArr6, iArr8, zzur, zzbv);
        zzyf zzyf2 = zzyf;
        zzyh[] zzyhArr = (zzyh[]) zzd.second;
        List[] listArr = new List[zzyhArr.length];
        for (int i17 = 0; i17 < zzyhArr.length; i17++) {
            zzyh zzyh = zzyhArr[i17];
            listArr[i17] = zzyh != null ? zzfzo.zzo(zzyh) : zzfzo.zzn();
        }
        zzfzl zzfzl = new zzfzl();
        for (int i18 = 0; i18 < 2; i18++) {
            zzwr zzd2 = zzyf2.zzd(i18);
            List list = listArr[i18];
            for (int i19 = 0; i19 < zzd2.zzb; i19++) {
                zzbw zzb2 = zzd2.zzb(i19);
                boolean z4 = zzyf2.zza(i18, i19, false) != 0;
                int i20 = zzb2.zza;
                int[] iArr9 = new int[i20];
                boolean[] zArr = new boolean[i20];
                for (int i21 = 0; i21 < zzb2.zza; i21++) {
                    iArr9[i21] = zzyf2.zzb(i18, i19, i21) & 7;
                    int i22 = 0;
                    while (true) {
                        if (i22 >= list.size()) {
                            z = false;
                            break;
                        }
                        zzyh zzyh2 = (zzyh) list.get(i22);
                        if (zzyh2.zze().equals(zzb2) && zzyh2.zzb(i21) != -1) {
                            z = true;
                            break;
                        }
                        i22++;
                    }
                    zArr[i21] = z;
                }
                zzfzl.zzf(new zzcc(zzb2, z4, iArr9, zArr));
            }
        }
        zzwr zze = zzyf2.zze();
        for (int i23 = 0; i23 < zze.zzb; i23++) {
            zzbw zzb3 = zze.zzb(i23);
            int[] iArr10 = new int[zzb3.zza];
            Arrays.fill(iArr10, 0);
            zzfzl.zzf(new zzcc(zzb3, false, iArr10, new boolean[zzb3.zza]));
        }
        return new zzyk((zzlr[]) zzd.first, (zzyd[]) zzd.second, new zzcd(zzfzl.zzi()), zzyf2);
    }

    public final void zzp(Object obj) {
        zzyf zzyf = (zzyf) obj;
    }
}
