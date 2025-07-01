package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdRequest;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzq implements Consumer {
    public final /* synthetic */ AdRequest.Builder zza;

    public /* synthetic */ zzq(AdRequest.Builder builder) {
        this.zza = builder;
    }

    public final void accept(Object obj) {
        this.zza.setContentUrl((String) obj);
    }
}
