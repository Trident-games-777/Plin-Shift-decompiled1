package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdwy implements Callable {
    public final /* synthetic */ zzavc zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzdwy(zzavc zzavc, Context context) {
        this.zza = zzavc;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzc().zzf(this.zzb);
    }
}
