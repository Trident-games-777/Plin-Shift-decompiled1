package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbzl;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaf implements Callable {
    public final /* synthetic */ zzap zza;
    public final /* synthetic */ zzbzl zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzaf(zzap zzap, zzbzl zzbzl, Bundle bundle) {
        this.zza = zzap;
        this.zzb = zzbzl;
        this.zzc = bundle;
    }

    public final Object call() {
        return this.zza.zzq(this.zzb, this.zzc);
    }
}
