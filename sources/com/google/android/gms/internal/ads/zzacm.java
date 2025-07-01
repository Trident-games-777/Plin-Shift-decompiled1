package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacm implements zzadx {
    private final byte[] zza = new byte[4096];

    public final /* synthetic */ int zzf(zzn zzn, int i, boolean z) {
        return zzadv.zza(this, zzn, i, z);
    }

    public final int zzg(zzn zzn, int i, boolean z, int i2) throws IOException {
        int zza2 = zzn.zza(this.zza, 0, Math.min(4096, i));
        if (zza2 != -1) {
            return zza2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzl(zzad zzad) {
    }

    public final /* synthetic */ void zzq(zzed zzed, int i) {
        zzadv.zzb(this, zzed, i);
    }

    public final void zzr(zzed zzed, int i, int i2) {
        zzed.zzM(i);
    }

    public final void zzs(long j, int i, int i2, int i3, zzadw zzadw) {
    }
}
