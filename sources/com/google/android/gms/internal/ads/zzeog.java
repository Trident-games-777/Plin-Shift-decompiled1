package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeog implements zzgdp {
    public final ListenableFuture zza(Object obj) {
        if (((Throwable) obj) instanceof TimeoutException) {
            return zzgei.zzh(new zzeoh());
        }
        return zzgei.zzh(new zzeoi());
    }
}
