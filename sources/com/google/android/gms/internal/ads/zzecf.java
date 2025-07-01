package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzecf implements Callable {
    public final /* synthetic */ zzecd zza;

    public /* synthetic */ zzecf(zzecd zzecd) {
        this.zza = zzecd;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
