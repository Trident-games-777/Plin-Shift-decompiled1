package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgkm extends zzggt {
    private final zzgkl zza;

    private zzgkm(zzgkl zzgkl) {
        this.zza = zzgkl;
    }

    public static zzgkm zzc(zzgkl zzgkl) {
        return new zzgkm(zzgkl);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgkm) && ((zzgkm) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgkm.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zza != zzgkl.zzc;
    }

    public final zzgkl zzb() {
        return this.zza;
    }
}
