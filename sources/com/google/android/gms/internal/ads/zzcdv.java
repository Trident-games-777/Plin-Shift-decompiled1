package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdv extends zzcdr {
    public zzcdv(zzccf zzccf) {
        super(zzccf);
    }

    public final void zzf() {
    }

    public final boolean zzt(String str) {
        String zzf = zzf.zzf(str);
        zzccf zzccf = (zzccf) this.zzc.get();
        if (!(zzccf == null || zzf == null)) {
            zzccf.zzt(zzf, this);
        }
        zzm.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zzf, "noop", "Noop cache is a noop.");
        return false;
    }
}
