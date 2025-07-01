package com.google.android.gms.internal.ads;

import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbj {
    public static final zzbj zza = new zzbj(1.0f, 1.0f);
    public final float zzb;
    public final float zzc;
    private final int zzd;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbj(float f, float f2) {
        boolean z = true;
        zzdb.zzd(f > 0.0f);
        zzdb.zzd(f2 <= 0.0f ? false : z);
        this.zzb = f;
        this.zzc = f2;
        this.zzd = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbj zzbj = (zzbj) obj;
            return this.zzb == zzbj.zzb && this.zzc == zzbj.zzc;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzb) + 527) * 31) + Float.floatToRawIntBits(this.zzc);
    }

    public final String toString() {
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", new Object[]{Float.valueOf(this.zzb), Float.valueOf(this.zzc)});
    }

    public final long zza(long j) {
        return j * ((long) this.zzd);
    }
}
