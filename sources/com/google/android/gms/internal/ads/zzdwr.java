package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdwr implements zzgdp {
    public final /* synthetic */ zzbvx zza;

    public /* synthetic */ zzdwr(zzbvx zzbvx) {
        this.zza = zzbvx;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgei.zzh(new zzdyx((InputStream) obj, this.zza));
    }
}
