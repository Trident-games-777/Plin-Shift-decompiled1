package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjf extends zzggt {
    private final String zza;
    private final zzgje zzb;

    private zzgjf(String str, zzgje zzgje) {
        this.zza = str;
        this.zzb = zzgje;
    }

    public static zzgjf zzc(String str, zzgje zzgje) {
        return new zzgjf(str, zzgje);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjf)) {
            return false;
        }
        zzgjf zzgjf = (zzgjf) obj;
        if (!zzgjf.zza.equals(this.zza) || !zzgjf.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgjf.class, this.zza, this.zzb});
    }

    public final String toString() {
        String obj = this.zzb.toString();
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ", variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zzb != zzgje.zzb;
    }

    public final zzgje zzb() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zza;
    }
}
