package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaoj {
    public final int zza;
    public final long zzb;

    private zzaoj(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaoj zza(zzacs zzacs, zzed zzed) throws IOException {
        zzacs.zzh(zzed.zzN(), 0, 8);
        zzed.zzL(0);
        return new zzaoj(zzed.zzg(), zzed.zzs());
    }
}
