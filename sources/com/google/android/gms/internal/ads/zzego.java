package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzego implements zzgdp {
    public final /* synthetic */ zzegq zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ zzfff zzc;
    public final /* synthetic */ zzfet zzd;

    public /* synthetic */ zzego(zzegq zzegq, Uri uri, zzfff zzfff, zzfet zzfet) {
        this.zza = zzegq;
        this.zzb = uri;
        this.zzc = zzfff;
        this.zzd = zzfet;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
