package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbw {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzad[] zzd;
    private int zze;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbw(String str, zzad... zzadArr) {
        int length = zzadArr.length;
        int i = 1;
        zzdb.zzd(length > 0);
        this.zzb = str;
        this.zzd = zzadArr;
        this.zza = length;
        int zzb2 = zzbg.zzb(zzadArr[0].zzo);
        this.zzc = zzb2 == -1 ? zzbg.zzb(zzadArr[0].zzn) : zzb2;
        String zzc2 = zzc(zzadArr[0].zzd);
        int i2 = zzadArr[0].zzf | 16384;
        while (true) {
            zzad[] zzadArr2 = this.zzd;
            if (i >= zzadArr2.length) {
                return;
            }
            if (!zzc2.equals(zzc(zzadArr2[i].zzd))) {
                zzad[] zzadArr3 = this.zzd;
                zzd("languages", zzadArr3[0].zzd, zzadArr3[i].zzd, i);
                return;
            }
            zzad[] zzadArr4 = this.zzd;
            if (i2 != (zzadArr4[i].zzf | 16384)) {
                zzd("role flags", Integer.toBinaryString(zzadArr4[0].zzf), Integer.toBinaryString(this.zzd[i].zzf), i);
                return;
            }
            i++;
        }
    }

    private static String zzc(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void zzd(String str, String str2, String str3, int i) {
        zzdt.zzd("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbw zzbw = (zzbw) obj;
            return this.zzb.equals(zzbw.zzb) && Arrays.equals(this.zzd, zzbw.zzd);
        }
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int hashCode = ((this.zzb.hashCode() + 527) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode;
        return hashCode;
    }

    public final int zza(zzad zzad) {
        int i = 0;
        while (true) {
            zzad[] zzadArr = this.zzd;
            if (i >= zzadArr.length) {
                return -1;
            }
            if (zzad == zzadArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final zzad zzb(int i) {
        return this.zzd[i];
    }
}
