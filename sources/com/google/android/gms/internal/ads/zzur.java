package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzur {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzur(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private zzur(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public zzur(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzur)) {
            return false;
        }
        zzur zzur = (zzur) obj;
        return this.zza.equals(zzur.zza) && this.zzb == zzur.zzb && this.zzc == zzur.zzc && this.zzd == zzur.zzd && this.zze == zzur.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzur zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzur(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzur(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
