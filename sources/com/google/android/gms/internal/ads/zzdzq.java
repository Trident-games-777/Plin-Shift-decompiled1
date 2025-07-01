package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzq implements zzgdo {
    public final /* synthetic */ zzdzu zza;
    public final /* synthetic */ zzbuv zzb;

    public /* synthetic */ zzdzq(zzdzu zzdzu, zzbuv zzbuv) {
        this.zza = zzdzu;
        this.zzb = zzbuv;
    }

    public final ListenableFuture zza() {
        return this.zza.zza(this.zzb);
    }
}
