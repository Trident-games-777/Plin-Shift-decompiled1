package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfyv extends AbstractCollection {
    final /* synthetic */ zzfyx zza;

    zzfyv(zzfyx zzfyx) {
        this.zza = zzfyx;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzfyx zzfyx = this.zza;
        Map zzl = zzfyx.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzfyq(zzfyx);
    }

    public final int size() {
        return this.zza.size();
    }
}
