package com.google.android.gms.ads.internal.client;

import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzej implements Runnable {
    public final /* synthetic */ zzel zza;
    public final /* synthetic */ IObjectWrapper zzb;

    public /* synthetic */ zzej(zzel zzel, IObjectWrapper iObjectWrapper) {
        this.zza = zzel;
        this.zzb = iObjectWrapper;
    }

    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
