package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzer implements Consumer {
    public final /* synthetic */ zzes zza;

    public /* synthetic */ zzer(zzes zzes) {
        this.zza = zzes;
    }

    public final void accept(Object obj) {
        this.zza.zza.onAdsExhausted((PreloadConfiguration) obj);
    }
}
