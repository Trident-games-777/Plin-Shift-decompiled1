package com.google.android.gms.internal.ads;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfnf extends TimerTask {
    final /* synthetic */ Timer zza;
    final /* synthetic */ zzfnh zzb;
    final /* synthetic */ zzcfz zzc;

    zzfnf(zzfnh zzfnh, zzcfz zzcfz, Timer timer) {
        this.zzc = zzcfz;
        this.zza = timer;
        this.zzb = zzfnh;
    }

    public final void run() {
        this.zzb.zzg();
        this.zzc.zza(true);
        this.zza.cancel();
    }
}
