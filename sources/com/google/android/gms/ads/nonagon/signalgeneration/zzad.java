package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzgdp;
import com.google.android.gms.internal.ads.zzgei;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzad implements zzgdp {
    public final /* synthetic */ zzap zza;

    public /* synthetic */ zzad(zzap zzap) {
        this.zza = zzap;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgei.zzm(this.zza.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzae(this.zza, (Uri) obj), this.zza.zzk);
    }
}
