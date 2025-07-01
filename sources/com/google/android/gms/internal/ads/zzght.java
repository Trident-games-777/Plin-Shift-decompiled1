package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzght extends zzggt {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzghr zzd;

    /* synthetic */ zzght(int i, int i2, int i3, zzghr zzghr, zzghs zzghs) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzghr;
    }

    public static zzghq zzd() {
        return new zzghq((zzghs) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzght)) {
            return false;
        }
        zzght zzght = (zzght) obj;
        if (zzght.zza == this.zza && zzght.zzb == this.zzb) {
            int i = zzght.zzc;
            if (zzght.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzght.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AesEax Parameters (variant: " + valueOf + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzghr.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzghr zze() {
        return this.zzd;
    }
}
