package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbg {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze = 0;

    /* synthetic */ zzbg(zzbe zzbe, zzbf zzbf) {
        int size = zzbe.zzb.size();
        this.zza = (String[]) zzbe.zza.toArray(new String[size]);
        this.zzb = zzc(zzbe.zzb);
        this.zzc = zzc(zzbe.zzc);
        this.zzd = new int[size];
    }

    private static final double[] zzc(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList(this.zza.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zza;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double[] dArr = this.zzc;
            double[] dArr2 = this.zzb;
            int[] iArr = this.zzd;
            double d = dArr[i];
            double d2 = dArr2[i];
            int i2 = iArr[i];
            arrayList.add(new zzbd(str, d, d2, ((double) i2) / ((double) this.zze), i2));
            i++;
        }
    }

    public final void zzb(double d) {
        this.zze++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i < dArr.length) {
                double d2 = dArr[i];
                if (d2 <= d && d < this.zzb[i]) {
                    int[] iArr = this.zzd;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= d2) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
