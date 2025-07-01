package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzclv implements zzclr {
    private final zzg zza;

    public zzclv(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzv(Boolean.parseBoolean((String) map.get("content_vertical_opted_out")));
    }
}
