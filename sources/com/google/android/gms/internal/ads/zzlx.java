package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzlx {
    public final long zza;
    public final zzbv zzb;
    public final int zzc;
    public final zzur zzd;
    public final long zze;
    public final zzbv zzf;
    public final int zzg;
    public final zzur zzh;
    public final long zzi;
    public final long zzj;

    public zzlx(long j, zzbv zzbv, int i, zzur zzur, long j2, zzbv zzbv2, int i2, zzur zzur2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzbv;
        this.zzc = i;
        this.zzd = zzur;
        this.zze = j2;
        this.zzf = zzbv2;
        this.zzg = i2;
        this.zzh = zzur2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzlx zzlx = (zzlx) obj;
            return this.zza == zzlx.zza && this.zzc == zzlx.zzc && this.zze == zzlx.zze && this.zzg == zzlx.zzg && this.zzi == zzlx.zzi && this.zzj == zzlx.zzj && zzfwn.zza(this.zzb, zzlx.zzb) && zzfwn.zza(this.zzd, zzlx.zzd) && zzfwn.zza(this.zzf, zzlx.zzf) && zzfwn.zza(this.zzh, zzlx.zzh);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
