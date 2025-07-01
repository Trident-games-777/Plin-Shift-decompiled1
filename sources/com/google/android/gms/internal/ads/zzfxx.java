package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzfxx extends zzgai {
    final /* synthetic */ zzfyh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfxx(zzfyh zzfyh, Map map) {
        super(map);
        this.zza = zzfyh;
    }

    public final void clear() {
        zzfzy.zzb(iterator());
    }

    public final boolean containsAll(Collection collection) {
        return this.zzd.keySet().containsAll(collection);
    }

    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zzd.keySet().equals(obj);
    }

    public final int hashCode() {
        return this.zzd.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new zzfxw(this, this.zzd.entrySet().iterator());
    }

    public final boolean remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zzd.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzfyh zzfyh = this.zza;
        zzfyh.zzb = zzfyh.zzb - size;
        return size > 0;
    }
}
