package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcbz {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzbe.zzc().zza(zzbcn.zzN)).longValue());
    private long zzb;
    private boolean zzc = true;

    zzcbz() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzcbk zzcbk) {
        if (zzcbk != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (!this.zzc) {
                if (Math.abs(timestamp - this.zzb) < this.zza) {
                    return;
                }
            }
            this.zzc = false;
            this.zzb = timestamp;
            zzftd zzftd = zzs.zza;
            Objects.requireNonNull(zzcbk);
            zzftd.post(new zzcby(zzcbk));
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
