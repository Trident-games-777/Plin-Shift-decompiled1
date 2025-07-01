package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzx {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzx zza(int i) {
        zzdb.zzf(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzz zzb() {
        zzdb.zzf(!this.zzb);
        this.zzb = true;
        return new zzz(this.zza, (zzy) null);
    }
}
