package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzege implements zzgdp {
    public final /* synthetic */ zzegg zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzfet zzc;

    public /* synthetic */ zzege(zzegg zzegg, View view, zzfet zzfet) {
        this.zza = zzegg;
        this.zzb = view;
        this.zzc = zzfet;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
