package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeae implements zzgdp {
    public final /* synthetic */ zzeag zza;
    public final /* synthetic */ zzbvx zzb;

    public /* synthetic */ zzeae(zzeag zzeag, zzbvx zzbvx) {
        this.zza = zzeag;
        this.zzb = zzbvx;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (InputStream) obj);
    }
}
