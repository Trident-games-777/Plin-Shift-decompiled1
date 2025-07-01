package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzadp implements zzadq {
    private final long zza;
    private final zzado zzb;

    public final long zza() {
        return this.zza;
    }

    public final zzado zzg(long j) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }

    public zzadp(long j, long j2) {
        zzadr zzadr;
        this.zza = j;
        if (j2 == 0) {
            zzadr = zzadr.zza;
        } else {
            zzadr = new zzadr(0, j2);
        }
        this.zzb = new zzado(zzadr, zzadr);
    }
}
