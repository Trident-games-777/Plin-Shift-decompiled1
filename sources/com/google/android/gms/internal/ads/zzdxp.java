package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdxp implements zzgdp {
    public final /* synthetic */ zzdxq zza;
    public final /* synthetic */ zzbvx zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdxp(zzdxq zzdxq, zzbvx zzbvx, int i) {
        this.zza = zzdxq;
        this.zzb = zzbvx;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (Throwable) obj);
    }
}
