package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbf {
    public final int zza;

    public zzbf(int i, int i2) {
        this.zza = i2;
    }

    public final int zza() {
        int i = this.zza;
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i != 22) {
            return i != 23 ? 0 : 15;
        }
        return 1073741824;
    }
}
