package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzfv;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbym {
    private final Clock zza;
    private final zzbyk zzb;

    zzbym(Clock clock, zzbyk zzbyk) {
        this.zza = clock;
        this.zzb = zzbyk;
    }

    public static zzbym zza(Context context) {
        return zzbyw.zzd(context).zzb();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(zzfv zzfv) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
