package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlt implements zzgdp {
    public final /* synthetic */ zzdmg zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdlt(zzdmg zzdmg, String str) {
        this.zza = zzdmg;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, obj);
    }
}
