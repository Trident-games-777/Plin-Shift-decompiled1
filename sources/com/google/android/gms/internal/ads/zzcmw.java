package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcmw implements zzgdp {
    public final /* synthetic */ zzcnb zza;
    public final /* synthetic */ Uri.Builder zzb;

    public /* synthetic */ zzcmw(zzcnb zzcnb, Uri.Builder builder) {
        this.zza = zzcnb;
        this.zzb = builder;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zze(this.zzb, (Throwable) obj);
    }
}
