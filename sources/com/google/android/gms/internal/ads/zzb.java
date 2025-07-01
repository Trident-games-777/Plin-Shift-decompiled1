package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzb {
    public static final zzb zza = new zzb((Object) null, new zza[0], 0, -9223372036854775807L, 0);
    private static final zza zze = new zza(0).zzb(0);
    public final int zzb = 0;
    public final long zzc = 0;
    public final int zzd;
    private final zza[] zzf;

    static {
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    private zzb(Object obj, zza[] zzaArr, long j, long j2, int i) {
        this.zzf = zzaArr;
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals((Object) null, (Object) null) && Arrays.equals(this.zzf, ((zzb) obj).zzf);
        }
    }

    public final int hashCode() {
        return (((int) -9223372036854775807L) * 961) + Arrays.hashCode(this.zzf);
    }

    public final String toString() {
        return "AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[" + "])";
    }

    public final zza zza(int i) {
        return i < 0 ? zze : this.zzf[i];
    }

    public final boolean zzb(int i) {
        zza(-1);
        int i2 = zza.zzi;
        return false;
    }
}
