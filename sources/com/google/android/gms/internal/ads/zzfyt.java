package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfyt extends AbstractSet {
    final /* synthetic */ zzfyx zza;

    zzfyt(zzfyx zzfyx) {
        this.zza = zzfyx;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzfyx zzfyx = this.zza;
        Map zzl = zzfyx.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzfyo(zzfyx);
    }

    public final boolean remove(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        return this.zza.zzy(obj) != zzfyx.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
