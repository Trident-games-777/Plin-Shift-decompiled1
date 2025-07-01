package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzduh implements Callable {
    public final /* synthetic */ zzdup zza;
    public final /* synthetic */ zzfka zzb;

    public /* synthetic */ zzduh(zzdup zzdup, zzfka zzfka) {
        this.zza = zzdup;
        this.zzb = zzfka;
    }

    public final Object call() {
        this.zza.zzf(this.zzb);
        return null;
    }
}
