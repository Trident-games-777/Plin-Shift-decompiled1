package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgdl extends zzgdj {
    private zzgdl() {
        throw null;
    }

    /* synthetic */ zzgdl(zzgdm zzgdm) {
        super((zzgdm) null);
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzgdn zzgdn) {
        int zzz;
        synchronized (zzgdn) {
            zzz = zzgdn.remaining - 1;
            zzgdn.remaining = zzz;
        }
        return zzz;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzgdn zzgdn, @CheckForNull Set set, Set set2) {
        synchronized (zzgdn) {
            if (zzgdn.seenExceptions == null) {
                zzgdn.seenExceptions = set2;
            }
        }
    }
}
