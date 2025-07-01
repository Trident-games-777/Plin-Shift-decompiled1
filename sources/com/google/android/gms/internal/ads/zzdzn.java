package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzn implements zzgdp {
    public final /* synthetic */ zzdzo zza;
    public final /* synthetic */ zzbvb zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdzn(zzdzo zzdzo, zzbvb zzbvb, int i) {
        this.zza = zzdzo;
        this.zzb = zzbvb;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (zzdyw) obj);
    }
}
