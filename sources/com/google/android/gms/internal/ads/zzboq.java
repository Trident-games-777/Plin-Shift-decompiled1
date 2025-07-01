package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzboq implements zzgdp {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbjr zzb;

    public /* synthetic */ zzboq(String str, zzbjr zzbjr) {
        this.zza = str;
        this.zzb = zzbjr;
    }

    public final ListenableFuture zza(Object obj) {
        zzbnv zzbnv = (zzbnv) obj;
        zzbnv.zzq(this.zza, this.zzb);
        return zzgei.zzh(zzbnv);
    }
}
