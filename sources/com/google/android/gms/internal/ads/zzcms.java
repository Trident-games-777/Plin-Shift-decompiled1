package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcms implements zzgdp {
    public final /* synthetic */ zzcnb zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcms(zzcnb zzcnb, String str) {
        this.zza = zzcnb;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (Throwable) obj);
    }
}
