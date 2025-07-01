package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzflx {
    private final long zza;
    private final long zzb;
    private long zzc;
    private long zzd;
    private final Random zze = new Random();

    public zzflx(long j, double d, long j2, double d2) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = 0;
        zzc();
    }

    public final long zza() {
        double d = (double) this.zzd;
        double d2 = 0.2d * d;
        long j = (long) (d - d2);
        return j + ((long) (this.zze.nextDouble() * ((double) ((((long) (d + d2)) - j) + 1))));
    }

    public final void zzb() {
        double d = (double) this.zzd;
        this.zzd = Math.min((long) (d + d), this.zzb);
        this.zzc++;
    }

    public final void zzc() {
        this.zzd = this.zza;
        this.zzc = 0;
    }

    public final boolean zzd() {
        return this.zzc > ((long) ((Integer) zzbe.zzc().zza(zzbcn.zzw)).intValue()) && this.zzd >= this.zzb;
    }
}
