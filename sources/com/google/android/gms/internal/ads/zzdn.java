package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdn implements Handler.Callback {
    public final /* synthetic */ zzds zza;

    public /* synthetic */ zzdn(zzds zzds) {
        this.zza = zzds;
    }

    public final boolean handleMessage(Message message) {
        zzds.zzg(this.zza, message);
        return true;
    }
}
