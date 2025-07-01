package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfux implements Consumer {
    public final /* synthetic */ Bundle zza;

    public /* synthetic */ zzfux(Bundle bundle) {
        this.zza = bundle;
    }

    public final void accept(Object obj) {
        int i = zzfvd.zzb;
        this.zza.putString("appId", (String) obj);
    }
}
