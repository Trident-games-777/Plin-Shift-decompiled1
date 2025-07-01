package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzedl implements Callable {
    public final /* synthetic */ zzedp zza;

    public /* synthetic */ zzedl(zzedp zzedp) {
        this.zza = zzedp;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
