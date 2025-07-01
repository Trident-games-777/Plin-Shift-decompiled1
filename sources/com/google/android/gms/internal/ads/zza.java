package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zza {
    public static final /* synthetic */ int zzi = 0;
    public final long zza;
    public final int zzb;
    @Deprecated
    public final Uri[] zzc;
    public final zzaw[] zzd;
    public final int[] zze;
    public final long[] zzf;
    public final long zzg;
    public final boolean zzh;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
    }

    public zza(long j) {
        this(0, -1, -1, new int[0], new zzaw[0], new long[0], 0, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zza zza2 = (zza) obj;
            return this.zzb == zza2.zzb && Arrays.equals(this.zzd, zza2.zzd) && Arrays.equals(this.zze, zza2.zze) && Arrays.equals(this.zzf, zza2.zzf);
        }
    }

    public final int hashCode() {
        return ((((((((this.zzb * 31) - 1) * 961) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze)) * 31) + Arrays.hashCode(this.zzf)) * 961;
    }

    public final int zza(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.zze;
            if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public final zza zzb(int i) {
        int[] iArr = this.zze;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.zzf;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        return new zza(0, 0, -1, copyOf, (zzaw[]) Arrays.copyOf(this.zzd, 0), copyOf2, 0, false);
    }

    private zza(long j, int i, int i2, int[] iArr, zzaw[] zzawArr, long[] jArr, long j2, boolean z) {
        Uri uri;
        int length = iArr.length;
        int length2 = zzawArr.length;
        int i3 = 0;
        zzdb.zzd(length == length2);
        this.zza = 0;
        this.zzb = i;
        this.zze = iArr;
        this.zzd = zzawArr;
        this.zzf = jArr;
        this.zzg = 0;
        this.zzh = false;
        this.zzc = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.zzc;
            if (i3 < uriArr.length) {
                zzaw zzaw = zzawArr[i3];
                if (zzaw == null) {
                    uri = null;
                } else {
                    zzar zzar = zzaw.zzb;
                    zzar.getClass();
                    zzar zzar2 = zzar;
                    uri = zzar.zza;
                }
                uriArr[i3] = uri;
                i3++;
            } else {
                return;
            }
        }
    }
}
