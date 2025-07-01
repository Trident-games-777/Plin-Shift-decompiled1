package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcry implements zzeiw {
    public final List zza;

    public zzcry(zzcrq zzcrq) {
        this.zza = Collections.singletonList(zzgei.zzh(zzcrq));
    }

    public zzcry(List list) {
        this.zza = list;
    }

    public final void zzr() {
        for (ListenableFuture zzr : this.zza) {
            zzgei.zzr(zzr, new zzcrx(this), zzgey.zzb());
        }
    }
}
