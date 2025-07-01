package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzgds extends zzgdi {
    @CheckForNull
    private List zza;

    zzgds(zzfzj zzfzj, boolean z) {
        super(zzfzj, z, true);
        List list;
        if (zzfzj.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzgae.zza(zzfzj.size());
        }
        for (int i = 0; i < zzfzj.size(); i++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzG(List list);

    /* access modifiers changed from: package-private */
    public final void zzf(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzgdr(obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) {
        super.zzy(i);
        this.zza = null;
    }
}
