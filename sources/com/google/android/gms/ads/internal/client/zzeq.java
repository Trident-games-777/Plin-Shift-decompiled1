package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzeq implements Consumer {
    public final /* synthetic */ zzes zza;

    public /* synthetic */ zzeq(zzes zzes) {
        this.zza = zzes;
    }

    public final void accept(Object obj) {
        this.zza.zza.onAdsAvailable((PreloadConfiguration) obj);
    }
}
