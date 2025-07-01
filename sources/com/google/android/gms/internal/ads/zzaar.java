package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaar implements DisplayManager.DisplayListener {
    final /* synthetic */ zzaat zza;
    private final DisplayManager zzb;

    public zzaar(zzaat zzaat, DisplayManager displayManager) {
        this.zza = zzaat;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        if (i == 0) {
            zzaat.zzb(this.zza, zzc());
        }
    }

    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzen.zzy((Handler.Callback) null));
        zzaat.zzb(this.zza, zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
