package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzwy extends zzxa {
    protected zzwy(zzbw zzbw, int[] iArr, int i, zzyr zzyr, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzdc zzdc) {
        super(zzbw, iArr, 0);
        zzfzo.zzl(list);
    }

    static /* bridge */ /* synthetic */ zzfzo zzf(zzyc[] zzycArr) {
        int i;
        double d;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = 1;
            if (i3 >= 2) {
                break;
            }
            zzyc zzyc = zzycArr[i3];
            if (zzyc == null || zzyc.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfzl zzfzl = new zzfzl();
                zzfzl.zzf(new zzww(0, 0));
                arrayList.add(zzfzl);
            }
            i3++;
        }
        long[][] jArr = new long[2][];
        for (int i4 = 0; i4 < 2; i4++) {
            zzyc zzyc2 = zzycArr[i4];
            if (zzyc2 == null) {
                jArr[i4] = new long[0];
            } else {
                jArr[i4] = new long[zzyc2.zzb.length];
                int i5 = 0;
                while (true) {
                    int[] iArr = zzyc2.zzb;
                    if (i5 >= iArr.length) {
                        break;
                    }
                    long j = (long) zzyc2.zza.zzb(iArr[i5]).zzj;
                    long[] jArr2 = jArr[i4];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i5] = j;
                    i5++;
                }
                Arrays.sort(jArr[i4]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i6 = 0; i6 < 2; i6++) {
            long[] jArr4 = jArr[i6];
            jArr3[i6] = jArr4.length == 0 ? 0 : jArr4[0];
        }
        zzg(arrayList, jArr3);
        zzfzz zza = zzgau.zzc(zzgaz.zzc()).zzb(2).zza();
        int i7 = 0;
        while (i7 < 2) {
            int length = jArr[i7].length;
            if (length > i) {
                double[] dArr = new double[length];
                int i8 = i2;
                while (true) {
                    long[] jArr5 = jArr[i7];
                    double d2 = 0.0d;
                    if (i8 >= jArr5.length) {
                        break;
                    }
                    long j2 = jArr5[i8];
                    if (j2 != -1) {
                        d2 = Math.log((double) j2);
                    }
                    dArr[i8] = d2;
                    i8++;
                }
                int i9 = length - 1;
                double d3 = dArr[i9] - dArr[i2];
                int i10 = i2;
                while (i10 < i9) {
                    double d4 = dArr[i10];
                    i10++;
                    double d5 = d4 + dArr[i10];
                    if (d3 == 0.0d) {
                        d = 1.0d;
                    } else {
                        d = ((d5 * 0.5d) - dArr[i2]) / d3;
                    }
                    zza.zzq(Double.valueOf(d), Integer.valueOf(i7));
                    i = i;
                    i2 = 0;
                }
            }
            i7++;
            i = i;
            i2 = 0;
        }
        int i11 = i;
        zzfzo zzl = zzfzo.zzl(zza.zzr());
        for (int i12 = 0; i12 < zzl.size(); i12++) {
            int intValue = ((Integer) zzl.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j3 = jArr3[i14];
                jArr3[i14] = j3 + j3;
            }
        }
        zzg(arrayList, jArr3);
        zzfzl zzfzl2 = new zzfzl();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfzl zzfzl3 = (zzfzl) arrayList.get(i15);
            zzfzl2.zzf(zzfzl3 == null ? zzfzo.zzn() : zzfzl3.zzi());
        }
        return zzfzl2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfzl zzfzl = (zzfzl) list.get(i2);
            if (zzfzl != null) {
                zzfzl.zzf(new zzww(j, jArr[i2]));
            }
        }
    }
}
