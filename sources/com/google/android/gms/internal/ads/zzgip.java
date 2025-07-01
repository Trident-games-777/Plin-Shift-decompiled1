package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgip extends zzggt {
    private final int zza;
    private final zzgin zzb;

    /* synthetic */ zzgip(int i, zzgin zzgin, zzgio zzgio) {
        this.zza = i;
        this.zzb = zzgin;
    }

    public static zzgim zzc() {
        return new zzgim((zzgio) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgip)) {
            return false;
        }
        zzgip zzgip = (zzgip) obj;
        return zzgip.zza == this.zza && zzgip.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgip.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzb != zzgin.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgin zzd() {
        return this.zzb;
    }
}
