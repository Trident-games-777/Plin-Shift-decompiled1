package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzauz;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzavc;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzq implements Callable {
    final /* synthetic */ zzu zza;

    zzq(zzu zzu) {
        this.zza = zzu;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzu zzu = this.zza;
        return new zzavc(zzavb.zzu(zzu.zzd, new zzauz(zzu.zza.afmaVersion, false)));
    }
}
