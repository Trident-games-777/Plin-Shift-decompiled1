package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzht implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzhv zza;
    private final Handler zzb;

    public zzht(zzhv zzhv, Handler handler) {
        this.zza = zzhv;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.zzb.post(new zzhs(this, i));
    }
}
