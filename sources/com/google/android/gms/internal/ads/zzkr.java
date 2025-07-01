package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzkr {
    public final zzur zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    zzkr(zzur zzur, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        zzdb.zzd(!z4 || z2);
        if (z3 && !z2) {
            z5 = false;
        }
        zzdb.zzd(z5);
        this.zza = zzur;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = false;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkr zzkr = (zzkr) obj;
            return this.zzb == zzkr.zzb && this.zzc == zzkr.zzc && this.zzd == zzkr.zzd && this.zze == zzkr.zze && this.zzg == zzkr.zzg && this.zzh == zzkr.zzh && this.zzi == zzkr.zzi && Objects.equals(this.zza, zzkr.zza);
        }
    }

    public final int hashCode() {
        long j = this.zze;
        long j2 = this.zzd;
        return ((((((((((((((this.zza.hashCode() + 527) * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) j2)) * 31) + ((int) j)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzkr zza(long j) {
        if (j == this.zzc) {
            return this;
        }
        return new zzkr(this.zza, this.zzb, j, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzkr zzb(long j) {
        if (j == this.zzb) {
            return this;
        }
        return new zzkr(this.zza, j, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
