package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdwt implements zzgdp {
    public final ListenableFuture zza(Object obj) {
        return zzgei.zzg(((ExecutionException) obj).getCause());
    }
}
