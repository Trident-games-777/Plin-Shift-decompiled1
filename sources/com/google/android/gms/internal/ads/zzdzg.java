package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzg implements zzgdp {
    public final /* synthetic */ zzdzj zza;
    public final /* synthetic */ zzdzi zzb;
    public final /* synthetic */ zzbvx zzc;
    public final /* synthetic */ zzgdp zzd;

    public /* synthetic */ zzdzg(zzdzj zzdzj, zzdzi zzdzi, zzbvx zzbvx, zzgdp zzgdp) {
        this.zza = zzdzj;
        this.zzb = zzdzi;
        this.zzc = zzbvx;
        this.zzd = zzgdp;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, (zzdyw) obj);
    }
}
