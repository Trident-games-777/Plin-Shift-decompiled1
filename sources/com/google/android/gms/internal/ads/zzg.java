package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzg {
    public static final zzg zza = new zzg(0, 0, 1, 1, 0, (zzf) null);
    private zze zzb;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    /* synthetic */ zzg(int i, int i2, int i3, int i4, int i5, zzf zzf) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzg zzg = (zzg) obj;
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    public final zze zza() {
        if (this.zzb == null) {
            this.zzb = new zze(this, (zzf) null);
        }
        return this.zzb;
    }
}
