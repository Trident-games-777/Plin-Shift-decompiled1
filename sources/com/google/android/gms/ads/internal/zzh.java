package com.google.android.gms.ads.internal;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzh implements Callable {
    public final /* synthetic */ zzk zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzh(zzk zzk, Context context) {
        this.zza = zzk;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzb(this.zzb, (byte[]) null);
    }
}
