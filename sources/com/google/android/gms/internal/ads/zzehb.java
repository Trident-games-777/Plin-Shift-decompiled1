package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzehb implements zzgdp {
    public final /* synthetic */ zzehe zza;
    public final /* synthetic */ zzfet zzb;
    public final /* synthetic */ zzfff zzc;
    public final /* synthetic */ zzdpr zzd;

    public /* synthetic */ zzehb(zzehe zzehe, zzfet zzfet, zzfff zzfff, zzdpr zzdpr) {
        this.zza = zzehe;
        this.zzb = zzfet;
        this.zzc = zzfff;
        this.zzd = zzdpr;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
