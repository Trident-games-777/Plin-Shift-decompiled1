package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzclz implements zzgdp {
    public final ListenableFuture zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkc)).booleanValue()) {
            zzv.zzp().zzx(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
        } else {
            zzv.zzp().zzv(th, "GetTopicsApiWithRecordObservationActionHandler");
        }
        return zzgei.zzh(new GetTopicsResponse(zzfzo.zzn()));
    }
}
