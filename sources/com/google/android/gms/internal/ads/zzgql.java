package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgql extends zzgqo {
    private final int zza;
    private final int zzb;
    private final zzgqj zzc;
    private final zzgqi zzd;

    /* synthetic */ zzgql(int i, int i2, zzgqj zzgqj, zzgqi zzgqi, zzgqk zzgqk) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgqj;
        this.zzd = zzgqi;
    }

    public static zzgqh zze() {
        return new zzgqh((zzgqk) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgql)) {
            return false;
        }
        zzgql zzgql = (zzgql) obj;
        if (zzgql.zza == this.zza && zzgql.zzd() == zzd() && zzgql.zzc == this.zzc && zzgql.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgql.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        zzgqi zzgqi = this.zzd;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(zzgqi);
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzc != zzgqj.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgqj zzgqj = this.zzc;
        if (zzgqj == zzgqj.zzd) {
            return this.zzb;
        }
        if (zzgqj == zzgqj.zza || zzgqj == zzgqj.zzb || zzgqj == zzgqj.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgqi zzf() {
        return this.zzd;
    }

    public final zzgqj zzg() {
        return this.zzc;
    }
}
