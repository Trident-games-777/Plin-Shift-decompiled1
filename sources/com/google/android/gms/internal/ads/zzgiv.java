package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgiv extends zzggt {
    private final zzgiu zza;

    private zzgiv(zzgiu zzgiu) {
        this.zza = zzgiu;
    }

    public static zzgiv zzc(zzgiu zzgiu) {
        return new zzgiv(zzgiu);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgiv) && ((zzgiv) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgiv.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zza != zzgiu.zzc;
    }

    public final zzgiu zzb() {
        return this.zza;
    }
}
