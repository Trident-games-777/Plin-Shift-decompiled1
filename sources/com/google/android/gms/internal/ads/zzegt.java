package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzegt implements Callable {
    public final /* synthetic */ zzegv zza;
    public final /* synthetic */ zzfff zzb;
    public final /* synthetic */ zzfet zzc;

    public /* synthetic */ zzegt(zzegv zzegv, zzfff zzfff, zzfet zzfet) {
        this.zza = zzegv;
        this.zzb = zzfff;
        this.zzc = zzfet;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
