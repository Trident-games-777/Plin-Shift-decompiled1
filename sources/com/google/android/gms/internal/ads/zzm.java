package com.google.android.gms.internal.ads;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzm {
    public static final zzm zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final byte[] zze;
    public final int zzf;
    public final int zzg;
    private int zzh;

    static {
        zzk zzk = new zzk();
        zzk.zzc(1);
        zzk.zzb(2);
        zzk.zzd(3);
        zza = zzk.zzg();
        zzk zzk2 = new zzk();
        zzk2.zzc(1);
        zzk2.zzb(1);
        zzk2.zzd(2);
        zzk2.zzg();
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    /* synthetic */ zzm(int i, int i2, int i3, byte[] bArr, int i4, int i5, zzl zzl) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = bArr;
        this.zzf = i4;
        this.zzg = i5;
    }

    @Pure
    public static int zza(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzb(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 4) {
            return 10;
        }
        if (i == 13) {
            return 2;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean zzg(zzm zzm) {
        if (zzm == null) {
            return true;
        }
        int i = zzm.zzb;
        if (i != -1 && i != 1 && i != 2) {
            return false;
        }
        int i2 = zzm.zzc;
        if (i2 != -1 && i2 != 2) {
            return false;
        }
        int i3 = zzm.zzd;
        if ((i3 != -1 && i3 != 3) || zzm.zze != null) {
            return false;
        }
        int i4 = zzm.zzg;
        if (i4 != -1 && i4 != 8) {
            return false;
        }
        int i5 = zzm.zzf;
        return i5 == -1 || i5 == 8;
    }

    private static String zzh(int i) {
        if (i == -1) {
            return "Unset color range";
        }
        if (i == 1) {
            return "Full range";
        }
        if (i == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i;
    }

    private static String zzi(int i) {
        if (i == -1) {
            return "Unset color space";
        }
        if (i == 6) {
            return "BT2020";
        }
        if (i == 1) {
            return "BT709";
        }
        if (i == 2) {
            return "BT601";
        }
        return "Undefined color space " + i;
    }

    private static String zzj(int i) {
        if (i == -1) {
            return "Unset color transfer";
        }
        if (i == 10) {
            return "Gamma 2.2";
        }
        if (i == 1) {
            return "Linear";
        }
        if (i == 2) {
            return "sRGB";
        }
        if (i == 3) {
            return "SDR SMPTE 170M";
        }
        if (i == 6) {
            return "ST2084 PQ";
        }
        if (i == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzm zzm = (zzm) obj;
            return this.zzb == zzm.zzb && this.zzc == zzm.zzc && this.zzd == zzm.zzd && Arrays.equals(this.zze, zzm.zze) && this.zzf == zzm.zzf && this.zzg == zzm.zzg;
        }
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((((((this.zzb + 527) * 31) + this.zzc) * 31) + this.zzd) * 31) + Arrays.hashCode(this.zze)) * 31) + this.zzf) * 31) + this.zzg;
        this.zzh = hashCode;
        return hashCode;
    }

    public final String toString() {
        String str;
        int i = this.zzf;
        int i2 = this.zzd;
        int i3 = this.zzc;
        String zzi = zzi(this.zzb);
        String zzh2 = zzh(i3);
        String zzj = zzj(i2);
        String str2 = "NA";
        if (i != -1) {
            str = i + "bit Luma";
        } else {
            str = str2;
        }
        int i4 = this.zzg;
        if (i4 != -1) {
            str2 = i4 + "bit Chroma";
        }
        return "ColorInfo(" + zzi + ", " + zzh2 + ", " + zzj + ", " + (this.zze != null) + ", " + str + ", " + str2 + ")";
    }

    public final zzk zzc() {
        return new zzk(this, (zzl) null);
    }

    public final String zzd() {
        String str;
        String str2;
        if (zzf()) {
            str = String.format(Locale.US, "%s/%s/%s", new Object[]{zzi(this.zzb), zzh(this.zzc), zzj(this.zzd)});
        } else {
            str = "NA/NA/NA";
        }
        if (zze()) {
            str2 = this.zzf + RemoteSettings.FORWARD_SLASH_STRING + this.zzg;
        } else {
            str2 = "NA/NA";
        }
        return str + RemoteSettings.FORWARD_SLASH_STRING + str2;
    }

    public final boolean zze() {
        return (this.zzf == -1 || this.zzg == -1) ? false : true;
    }

    public final boolean zzf() {
        return (this.zzb == -1 || this.zzc == -1 || this.zzd == -1) ? false : true;
    }
}
