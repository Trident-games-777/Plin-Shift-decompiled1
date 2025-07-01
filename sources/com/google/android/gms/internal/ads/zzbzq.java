package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbzq {
    public final ListenableFuture zza(Context context, int i) {
        zzcao zzcao = new zzcao();
        zzbc.zzb();
        if (zzf.zzu(context)) {
            zzcaj.zza.execute(new zzbzp(this, context, zzcao));
        }
        return zzcao;
    }
}
