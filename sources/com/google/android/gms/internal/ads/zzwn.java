package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzwn implements zzwg {
    private final zzwg zza;
    private final long zzb;

    public zzwn(zzwg zzwg, long j) {
        this.zza = zzwg;
        this.zzb = j;
    }

    public final int zza(zzkj zzkj, zzhm zzhm, int i) {
        int zza2 = this.zza.zza(zzkj, zzhm, i);
        if (zza2 != -4) {
            return zza2;
        }
        zzhm.zze += this.zzb;
        return -4;
    }

    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzwg zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
