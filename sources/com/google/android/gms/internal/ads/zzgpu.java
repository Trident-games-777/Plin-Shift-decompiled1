package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpu extends zzgqo {
    private final int zza;
    private final int zzb;
    private final zzgps zzc;

    /* synthetic */ zzgpu(int i, int i2, zzgps zzgps, zzgpt zzgpt) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgps;
    }

    public static zzgpr zze() {
        return new zzgpr((zzgpt) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpu)) {
            return false;
        }
        zzgpu zzgpu = (zzgpu) obj;
        if (zzgpu.zza == this.zza && zzgpu.zzd() == zzd() && zzgpu.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgpu.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzc != zzgps.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgps zzgps = this.zzc;
        if (zzgps == zzgps.zzd) {
            return this.zzb;
        }
        if (zzgps == zzgps.zza || zzgps == zzgps.zzb || zzgps == zzgps.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgps zzf() {
        return this.zzc;
    }
}
