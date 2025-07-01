package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdph implements View.OnTouchListener {
    public final /* synthetic */ zzdpm zza;

    public /* synthetic */ zzdph(zzdpm zzdpm) {
        this.zza = zzdpm;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
