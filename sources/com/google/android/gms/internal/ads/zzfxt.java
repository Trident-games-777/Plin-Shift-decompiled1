package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfxt implements Iterator {
    final Iterator zza;
    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzfxu zzc;

    zzfxt(zzfxu zzfxu) {
        this.zzc = zzfxu;
        this.zza = zzfxu.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    public final void remove() {
        zzfwq.zzl(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfyh zzfyh = this.zzc.zzb;
        zzfyh.zzb = zzfyh.zzb - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
