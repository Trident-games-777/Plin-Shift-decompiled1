package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzat;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzh extends RelativeLayout {
    final zzat zza;
    boolean zzb;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        zzat zzat = new zzat(context, str);
        this.zza = zzat;
        zzat.zzo(str2);
        zzat.zzn(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zzm(motionEvent);
        return false;
    }
}
