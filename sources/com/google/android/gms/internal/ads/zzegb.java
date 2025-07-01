package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzegb implements zzgdp {
    public final /* synthetic */ zzegc zza;
    public final /* synthetic */ zzfff zzb;
    public final /* synthetic */ zzfet zzc;

    public /* synthetic */ zzegb(zzegc zzegc, zzfff zzfff, zzfet zzfet) {
        this.zza = zzegc;
        this.zzb = zzfff;
        this.zzc = zzfet;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
