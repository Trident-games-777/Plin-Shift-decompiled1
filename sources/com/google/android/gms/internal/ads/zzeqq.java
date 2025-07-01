package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeqq implements Callable {
    public /* synthetic */ zzeqq(zzeqr zzeqr) {
    }

    public final Object call() {
        return new zzeqs(Long.valueOf(zzv.zzC().currentTimeMillis() - zzv.zzp().zzi().zzg().zza()).longValue());
    }
}
