package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzzl {
    private static final Comparator zza = new zzzh();
    private static final Comparator zzb = new zzzi();
    private final ArrayList zzc = new ArrayList();
    private final zzzj[] zzd = new zzzj[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzzl(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = (float) this.zzg;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzzj zzzj = (zzzj) this.zzc.get(i2);
            i += zzzj.zzb;
            if (((float) i) >= 0.5f * f2) {
                return zzzj.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzzj) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzzj zzzj;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzzj[] zzzjArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzzj = zzzjArr[i3];
        } else {
            zzzj = new zzzj((zzzk) null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzzj.zza = i4;
        zzzj.zzb = i;
        zzzj.zzc = f;
        this.zzc.add(zzzj);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 > 2000) {
                int i6 = i5 - 2000;
                zzzj zzzj2 = (zzzj) this.zzc.get(0);
                int i7 = zzzj2.zzb;
                if (i7 <= i6) {
                    this.zzg -= i7;
                    this.zzc.remove(0);
                    int i8 = this.zzh;
                    if (i8 < 5) {
                        zzzj[] zzzjArr2 = this.zzd;
                        this.zzh = i8 + 1;
                        zzzjArr2[i8] = zzzj2;
                    }
                } else {
                    zzzj2.zzb = i7 - i6;
                    this.zzg -= i6;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
