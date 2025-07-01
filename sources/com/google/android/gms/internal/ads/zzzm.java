package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzzm implements Executor {
    public final /* synthetic */ zzdm zza;

    public /* synthetic */ zzzm(zzdm zzdm) {
        this.zza = zzdm;
    }

    public final void execute(Runnable runnable) {
        this.zza.zzh(runnable);
    }
}
