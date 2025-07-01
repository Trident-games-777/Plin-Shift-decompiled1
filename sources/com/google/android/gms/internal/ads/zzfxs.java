package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfxs extends zzgah {
    final /* synthetic */ zzfxu zza;

    zzfxs(zzfxu zzfxu) {
        this.zza = zzfxu;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return zzfyn.zza(this.zza.zza.entrySet(), obj);
    }

    public final Iterator iterator() {
        return new zzfxt(this.zza);
    }

    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        zzfxu zzfxu = this.zza;
        zzfyh.zzo(zzfxu.zzb, ((Map.Entry) Objects.requireNonNull((Map.Entry) obj)).getKey());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Map zza() {
        return this.zza;
    }
}
