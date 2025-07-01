package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzche {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzche(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzche zza() {
        return new zzche(0, 0, 0);
    }

    public static zzche zzb(int i, int i2) {
        return new zzche(1, i, i2);
    }

    public static zzche zzc(zzs zzs) {
        if (zzs.zzd) {
            return new zzche(3, 0, 0);
        }
        if (zzs.zzi) {
            return new zzche(2, 0, 0);
        }
        if (zzs.zzh) {
            return new zzche(0, 0, 0);
        }
        return new zzche(1, zzs.zzf, zzs.zzc);
    }

    public static zzche zzd() {
        return new zzche(5, 0, 0);
    }

    public static zzche zze() {
        return new zzche(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
