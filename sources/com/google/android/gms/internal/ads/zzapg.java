package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzapg {
    private final Executor zza;

    public zzapg(Handler handler) {
        this.zza = new zzape(this, handler);
    }

    public final void zza(zzapp zzapp, zzapy zzapy) {
        zzapp.zzm("post-error");
        ((zzape) this.zza).zza.post(new zzapf(zzapp, zzapv.zza(zzapy), (Runnable) null));
    }

    public final void zzb(zzapp zzapp, zzapv zzapv, Runnable runnable) {
        zzapp.zzq();
        zzapp.zzm("post-response");
        ((zzape) this.zza).zza.post(new zzapf(zzapp, zzapv, runnable));
    }
}
