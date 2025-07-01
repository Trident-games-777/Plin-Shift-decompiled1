package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzp implements View.OnTouchListener {
    final /* synthetic */ zzu zza;

    zzp(zzu zzu) {
        this.zza = zzu;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzu zzu = this.zza;
        if (zzu.zzh == null) {
            return false;
        }
        zzu.zzh.zzd(motionEvent);
        return false;
    }
}
