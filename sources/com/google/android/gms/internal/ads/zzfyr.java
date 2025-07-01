package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfyr extends AbstractSet {
    final /* synthetic */ zzfyx zza;

    zzfyr(zzfyx zzfyx) {
        this.zza = zzfyx;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzd = this.zza.zzw(entry.getKey());
            if (zzd == -1 || !zzfwn.zza(zzfyx.zzj(this.zza, zzd), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        zzfyx zzfyx = this.zza;
        Map zzl = zzfyx.zzl();
        if (zzl != null) {
            return zzl.entrySet().iterator();
        }
        return new zzfyp(zzfyx);
    }

    public final boolean remove(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfyx zzfyx = this.zza;
        if (zzfyx.zzr()) {
            return false;
        }
        int zzc = zzfyx.zzv();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzfyx zzfyx2 = this.zza;
        int zzb = zzfyy.zzb(key, value, zzc, Objects.requireNonNull(zzfyx2.zze), zzfyx2.zzA(), zzfyx2.zzB(), zzfyx2.zzC());
        if (zzb == -1) {
            return false;
        }
        this.zza.zzq(zzb, zzc);
        zzfyx zzfyx3 = this.zza;
        zzfyx3.zzg = zzfyx3.zzg - 1;
        this.zza.zzo();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
