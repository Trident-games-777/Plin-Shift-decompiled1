package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeau implements Callable {
    public final /* synthetic */ zzbvx zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;

    public /* synthetic */ zzeau(zzbvx zzbvx, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) {
        this.zza = zzbvx;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
    }

    public final Object call() {
        Bundle bundle;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() && (bundle = this.zza.zzm) != null) {
            bundle.putLong(zzdrv.HTTP_RESPONSE_READY.zza(), zzv.zzC().currentTimeMillis());
        }
        ListenableFuture listenableFuture = this.zzd;
        return new zzebf((zzebt) this.zzb.get(), (JSONObject) this.zzc.get(), (zzbvz) listenableFuture.get());
    }
}
