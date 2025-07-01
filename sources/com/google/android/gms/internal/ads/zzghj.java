package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzghj extends zzggt {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzghh zze;
    private final zzghg zzf;

    /* synthetic */ zzghj(int i, int i2, int i3, int i4, zzghh zzghh, zzghg zzghg, zzghi zzghi) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzghh;
        this.zzf = zzghg;
    }

    public static zzghf zzf() {
        return new zzghf((zzghi) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghj)) {
            return false;
        }
        zzghj zzghj = (zzghj) obj;
        return zzghj.zza == this.zza && zzghj.zzb == this.zzb && zzghj.zzc == this.zzc && zzghj.zzd == this.zzd && zzghj.zze == this.zze && zzghj.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzghj.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        zzghg zzghg = this.zzf;
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(zzghg);
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    public final boolean zza() {
        return this.zze != zzghh.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzghg zzg() {
        return this.zzf;
    }

    public final zzghh zzh() {
        return this.zze;
    }
}
