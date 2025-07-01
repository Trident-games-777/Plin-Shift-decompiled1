package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzatv implements Callable {
    public final /* synthetic */ zzatx zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzatv(zzatx zzatx, Context context) {
        this.zza = zzatx;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzb(this.zzb);
    }
}
