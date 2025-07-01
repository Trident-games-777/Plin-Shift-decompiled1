package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeja implements zzgdp {
    public final /* synthetic */ zzejc zza;
    public final /* synthetic */ zzfet zzb;
    public final /* synthetic */ zzfff zzc;
    public final /* synthetic */ zzefb zzd;

    public /* synthetic */ zzeja(zzejc zzejc, zzfet zzfet, zzfff zzfff, zzefb zzefb) {
        this.zza = zzejc;
        this.zzb = zzfet;
        this.zzc = zzfff;
        this.zzd = zzefb;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, (Throwable) obj);
    }
}
