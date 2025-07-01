package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzl implements zzgdo {
    public final /* synthetic */ zzdzo zza;
    public final /* synthetic */ zzbvb zzb;

    public /* synthetic */ zzdzl(zzdzo zzdzo, zzbvb zzbvb) {
        this.zza = zzdzo;
        this.zzb = zzbvb;
    }

    public final ListenableFuture zza() {
        return this.zza.zza(this.zzb);
    }
}
