package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdk implements Iterable {
    private final List zza = new ArrayList();

    public final Iterator iterator() {
        return this.zza.iterator();
    }

    /* access modifiers changed from: package-private */
    public final zzcdj zza(zzccf zzccf) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcdj zzcdj = (zzcdj) it.next();
            if (zzcdj.zza == zzccf) {
                return zzcdj;
            }
        }
        return null;
    }

    public final void zzb(zzcdj zzcdj) {
        this.zza.add(zzcdj);
    }

    public final void zzc(zzcdj zzcdj) {
        this.zza.remove(zzcdj);
    }

    public final boolean zzd(zzccf zzccf) {
        ArrayList<zzcdj> arrayList = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcdj zzcdj = (zzcdj) it.next();
            if (zzcdj.zza == zzccf) {
                arrayList.add(zzcdj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzcdj zzcdj2 : arrayList) {
            zzcdj2.zzb.zzf();
        }
        return true;
    }
}
