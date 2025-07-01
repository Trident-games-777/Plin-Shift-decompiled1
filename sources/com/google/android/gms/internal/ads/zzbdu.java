package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbdu {
    private MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    private final ScheduledExecutorService zzc;

    public zzbdu(Context context, ScheduledExecutorService scheduledExecutorService, zzbdw zzbdw, zzfkl zzfkl) {
        this.zzc = scheduledExecutorService;
    }

    public final ListenableFuture zza() {
        return (zzgdz) zzgei.zzo(zzgdz.zzu(zzgei.zzh((Object) null)), ((Long) zzbem.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
    }

    public final void zzb(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzb.getEventTime()) {
            this.zzb = MotionEvent.obtain(motionEvent);
        }
    }
}
