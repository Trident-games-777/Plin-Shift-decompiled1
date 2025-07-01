package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzud {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzgc zzc;

    public zzud(zzacw zzacw, zzakg zzakg) {
    }

    public final void zza(zzgc zzgc) {
        if (zzgc != this.zzc) {
            this.zzc = zzgc;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
