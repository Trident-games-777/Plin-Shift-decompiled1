package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbk extends zzgbo {
    final /* synthetic */ Set zza;
    final /* synthetic */ Set zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgbk(Set set, Set set2) {
        super((zzgbp) null);
        this.zza = set;
        this.zzb = set2;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj) && this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        return this.zza.containsAll(collection) && this.zzb.containsAll(collection);
    }

    public final boolean isEmpty() {
        return Collections.disjoint(this.zzb, this.zza);
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzgbj(this);
    }

    public final int size() {
        int i = 0;
        for (Object contains : this.zza) {
            if (this.zzb.contains(contains)) {
                i++;
            }
        }
        return i;
    }

    public final zzgbu zza() {
        return new zzgbj(this);
    }
}
