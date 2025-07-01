package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzabw implements zzadq {
    private final zzabz zza;
    private final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final long zze;
    /* access modifiers changed from: private */
    public final long zzf;

    public zzabw(zzabz zzabz, long j, long j2, long j3, long j4, long j5, long j6) {
        this.zza = zzabz;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = j6;
    }

    public final long zza() {
        return this.zzb;
    }

    public final long zzf(long j) {
        return this.zza.zza(j);
    }

    public final zzado zzg(long j) {
        zzadr zzadr = new zzadr(j, zzaby.zzf(this.zza.zza(j), 0, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzado(zzadr, zzadr);
    }

    public final boolean zzh() {
        return true;
    }
}
