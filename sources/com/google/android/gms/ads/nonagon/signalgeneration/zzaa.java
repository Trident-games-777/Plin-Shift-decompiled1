package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdoc;
import com.google.android.gms.internal.ads.zzgdp;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaa implements zzgdp {
    public final /* synthetic */ zzap zza;
    public final /* synthetic */ zzdoc[] zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzaa(zzap zzap, zzdoc[] zzdocArr, String str) {
        this.zza = zzap;
        this.zzb = zzdocArr;
        this.zzc = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzv(this.zzb, this.zzc, (zzdoc) obj);
    }
}
