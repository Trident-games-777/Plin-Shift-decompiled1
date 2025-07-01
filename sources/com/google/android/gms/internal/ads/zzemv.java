package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzemv implements zzcyx {
    private final AtomicReference zza = new AtomicReference();

    public final void zza(zzdr zzdr) {
        this.zza.set(zzdr);
    }

    public final void zzh(zzu zzu) {
        zzfby.zza(this.zza, new zzemu(zzu));
    }
}
