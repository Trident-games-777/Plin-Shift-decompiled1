package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbyt implements Callable {
    public final /* synthetic */ zzbyv zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbyt(zzbyv zzbyv, Context context) {
        this.zza = zzbyv;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zze(this.zzb);
    }
}
