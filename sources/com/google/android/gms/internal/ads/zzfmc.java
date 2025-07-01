package com.google.android.gms.internal.ads;

import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfmc implements Consumer {
    public final /* synthetic */ zzdsl zza;

    public /* synthetic */ zzfmc(zzdsl zzdsl) {
        this.zza = zzdsl;
    }

    public final void accept(Object obj) {
        this.zza.zzb("plaay_ts", Long.toString(((Long) obj).longValue()));
    }
}
