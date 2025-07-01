package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzehq implements Callable {
    public final /* synthetic */ zzehv zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzfff zzd;
    public final /* synthetic */ zzfet zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzehq(zzehv zzehv, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfff zzfff, zzfet zzfet, JSONObject jSONObject) {
        this.zza = zzehv;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzfff;
        this.zze = zzfet;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
