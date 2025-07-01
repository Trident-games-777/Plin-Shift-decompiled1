package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzefc implements zzefb {
    public final zzefb zza;
    private final zzfwh zzb;

    public zzefc(zzefb zzefb, zzfwh zzfwh) {
        this.zza = zzefb;
        this.zzb = zzfwh;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        return zzgei.zzm(this.zza.zza(zzfff, zzfet), this.zzb, zzcaj.zza);
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        return this.zza.zzb(zzfff, zzfet);
    }
}
