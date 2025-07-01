package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzvg extends zztz {
    private static final zzaw zza;
    private final zzut[] zzb;
    private final zzbv[] zzc;
    private final ArrayList zzd;
    private int zze = -1;
    private long[][] zzf;
    private zzvf zzg;
    private final zzuc zzh;

    static {
        zzak zzak = new zzak();
        zzak.zza("MergingMediaSource");
        zza = zzak.zzc();
    }

    public zzvg(boolean z, boolean z2, zzuc zzuc, zzut... zzutArr) {
        this.zzb = zzutArr;
        this.zzh = zzuc;
        this.zzd = new ArrayList(Arrays.asList(zzutArr));
        this.zzc = new zzbv[zzutArr.length];
        this.zzf = new long[0][];
        new HashMap();
        zzgau.zzb(8).zzb(2).zza();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzut zzut, zzbv zzbv) {
        int i;
        Integer num = (Integer) obj;
        if (this.zzg == null) {
            if (this.zze == -1) {
                i = zzbv.zzb();
                this.zze = i;
            } else {
                int zzb2 = zzbv.zzb();
                int i2 = this.zze;
                if (zzb2 != i2) {
                    this.zzg = new zzvf(0);
                    return;
                }
                i = i2;
            }
            if (this.zzf.length == 0) {
                int[] iArr = new int[2];
                iArr[1] = this.zzc.length;
                iArr[0] = i;
                this.zzf = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.zzd.remove(zzut);
            this.zzc[num.intValue()] = zzbv;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }

    public final void zzG(zzup zzup) {
        zzve zzve = (zzve) zzup;
        int i = 0;
        while (true) {
            zzut[] zzutArr = this.zzb;
            if (i < zzutArr.length) {
                zzutArr[i].zzG(zzve.zzn(i));
                i++;
            } else {
                return;
            }
        }
    }

    public final zzup zzI(zzur zzur, zzys zzys, long j) {
        zzbv[] zzbvArr = this.zzc;
        int length = this.zzb.length;
        zzup[] zzupArr = new zzup[length];
        int zza2 = zzbvArr[0].zza(zzur.zza);
        for (int i = 0; i < length; i++) {
            zzupArr[i] = this.zzb[i].zzI(zzur.zza(this.zzc[i].zzf(zza2)), zzys, j - this.zzf[zza2][i]);
        }
        return new zzve(this.zzh, this.zzf[zza2], zzupArr);
    }

    public final zzaw zzJ() {
        zzut[] zzutArr = this.zzb;
        return zzutArr.length > 0 ? zzutArr[0].zzJ() : zza;
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzhd zzhd) {
        super.zzn(zzhd);
        int i = 0;
        while (true) {
            zzut[] zzutArr = this.zzb;
            if (i < zzutArr.length) {
                zzB(Integer.valueOf(i), zzutArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zze = -1;
        this.zzg = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    public final void zzt(zzaw zzaw) {
        this.zzb[0].zzt(zzaw);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzur zzy(Object obj, zzur zzur) {
        if (((Integer) obj).intValue() == 0) {
            return zzur;
        }
        return null;
    }

    public final void zzz() throws IOException {
        zzvf zzvf = this.zzg;
        if (zzvf == null) {
            super.zzz();
            return;
        }
        throw zzvf;
    }
}
