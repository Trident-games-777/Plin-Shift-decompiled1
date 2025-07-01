package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzear implements zzgdp {
    public final /* synthetic */ zzexc zza;
    public final /* synthetic */ zzbvx zzb;

    public /* synthetic */ zzear(zzexc zzexc, zzbvx zzbvx) {
        this.zza = zzexc;
        this.zzb = zzbvx;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb().zza(zzbc.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
