package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeuq implements zzevz {
    private final Bundle zza;

    zzeuq(Bundle bundle) {
        this.zza = bundle;
    }

    public final int zza() {
        return 30;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzh(new zzeur(this.zza));
    }
}
