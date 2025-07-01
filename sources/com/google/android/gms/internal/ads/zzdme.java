package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdme implements Consumer {
    public final /* synthetic */ zzdmf zza;

    public /* synthetic */ zzdme(zzdmf zzdmf) {
        this.zza = zzdmf;
    }

    public final void accept(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString("mediaUrl", (String) obj);
        this.zza.zza.zzc(bundle);
    }
}
