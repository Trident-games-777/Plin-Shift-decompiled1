package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacn {
    public final String zza;

    private zzacn(int i, int i2, String str) {
        this.zza = str;
    }

    public static zzacn zza(zzed zzed) {
        String str;
        zzed.zzM(2);
        int zzm = zzed.zzm();
        int i = zzm >> 1;
        int i2 = zzm & 1;
        int zzm2 = zzed.zzm() >> 3;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else if (i != 9) {
            return null;
        } else {
            str = "avc3";
        }
        int i3 = zzm2 | (i2 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ".0";
        sb.append(str2);
        sb.append(i);
        if (i3 >= 10) {
            str2 = ".";
        }
        sb.append(str2);
        sb.append(i3);
        return new zzacn(i, i3, sb.toString());
    }
}
