package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzedz extends TimerTask {
    final /* synthetic */ AlertDialog zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ zzm zzc;

    zzedz(zzeea zzeea, AlertDialog alertDialog, Timer timer, zzm zzm) {
        this.zza = alertDialog;
        this.zzb = timer;
        this.zzc = zzm;
    }

    public final void run() {
        this.zza.dismiss();
        this.zzb.cancel();
        zzm zzm = this.zzc;
        if (zzm != null) {
            zzm.zzb();
        }
    }
}
