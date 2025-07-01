package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeaz implements zzgdp {
    public final /* synthetic */ zzewc zza;
    public final /* synthetic */ zzbvx zzb;

    public /* synthetic */ zzeaz(zzewc zzewc, zzbvx zzbvx) {
        this.zza = zzewc;
        this.zzb = zzbvx;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(zzbc.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
