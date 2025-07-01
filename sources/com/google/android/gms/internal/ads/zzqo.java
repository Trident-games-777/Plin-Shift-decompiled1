package com.google.android.gms.internal.ads;

import android.media.AudioRouting;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzqo implements AudioRouting.OnRoutingChangedListener {
    public final /* synthetic */ zzqp zza;

    public /* synthetic */ zzqo(zzqp zzqp) {
        this.zza = zzqp;
    }

    public final void onRoutingChanged(AudioRouting audioRouting) {
        this.zza.zzc(audioRouting);
    }
}
