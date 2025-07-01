package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcmx implements zzgdp {
    public final /* synthetic */ Uri.Builder zza;

    public /* synthetic */ zzcmx(Uri.Builder builder) {
        this.zza = builder;
    }

    public final ListenableFuture zza(Object obj) {
        zzbce zzbce = zzbcn.zzjR;
        Uri.Builder builder = this.zza;
        builder.appendQueryParameter((String) zzbe.zzc().zza(zzbce), "12");
        return zzgei.zzh(builder.toString());
    }
}
