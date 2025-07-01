package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgie extends zzggt {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgic zzd;

    /* synthetic */ zzgie(int i, int i2, int i3, zzgic zzgic, zzgid zzgid) {
        this.zza = i;
        this.zzd = zzgic;
    }

    public static zzgib zzc() {
        return new zzgib((zzgid) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgie)) {
            return false;
        }
        zzgie zzgie = (zzgie) obj;
        if (zzgie.zza == this.zza) {
            int i = zzgie.zzb;
            int i2 = zzgie.zzc;
            if (zzgie.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgie.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AesGcm Parameters (variant: " + valueOf + ", 12-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzgic.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgic zzd() {
        return this.zzd;
    }
}
