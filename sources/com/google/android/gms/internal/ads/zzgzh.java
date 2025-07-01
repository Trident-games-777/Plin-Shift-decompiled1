package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzgzh extends AbstractList {
    private final zzgzf zza;
    private final zzgzg zzb;

    public zzgzh(zzgzf zzgzf, zzgzg zzgzg) {
        this.zza = zzgzf;
        this.zzb = zzgzg;
    }

    public final Object get(int i) {
        return this.zzb.zzb(this.zza.zzd(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
