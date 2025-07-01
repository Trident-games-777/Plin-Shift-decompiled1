package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzfxv implements Iterator {
    final Iterator zza;
    @CheckForNull
    Collection zzb = null;
    Iterator zzc = zzfzw.INSTANCE;
    final /* synthetic */ zzfyh zzd;

    zzfxv(zzfyh zzfyh) {
        this.zzd = zzfyh;
        this.zza = zzfyh.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzc.hasNext();
    }

    public final Object next() {
        if (!this.zzc.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzb = collection;
            this.zzc = collection.iterator();
        }
        return this.zzc.next();
    }

    public final void remove() {
        this.zzc.remove();
        if (((Collection) Objects.requireNonNull(this.zzb)).isEmpty()) {
            this.zza.remove();
        }
        zzfyh zzfyh = this.zzd;
        zzfyh.zzb = zzfyh.zzb - 1;
    }
}
