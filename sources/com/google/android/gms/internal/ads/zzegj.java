package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzegj implements zzgdp {
    public final /* synthetic */ zzegm zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzfet zzc;

    public /* synthetic */ zzegj(zzegm zzegm, View view, zzfet zzfet) {
        this.zza = zzegm;
        this.zzb = view;
        this.zzc = zzfet;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
