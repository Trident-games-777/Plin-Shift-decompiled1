package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajj implements zzadq {
    final /* synthetic */ zzajl zza;

    /* synthetic */ zzajj(zzajl zzajl, zzajk zzajk) {
        this.zza = zzajl;
    }

    public final long zza() {
        zzajl zzajl = this.zza;
        return zzajl.zzd.zzf(zzajl.zzf);
    }

    public final zzado zzg(long j) {
        zzajl zzajl = this.zza;
        long zzg = zzajl.zzd.zzg(j);
        long zzb = zzajl.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzajl zzajl2 = this.zza;
        long longValue = zzb + valueOf.multiply(BigInteger.valueOf(zzajl2.zzc - zzajl2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzajl zzajl3 = this.zza;
        zzadr zzadr = new zzadr(j, Math.max(zzajl3.zzb, Math.min(longValue - 30000, zzajl3.zzc - 1)));
        return new zzado(zzadr, zzadr);
    }

    public final boolean zzh() {
        return true;
    }
}
