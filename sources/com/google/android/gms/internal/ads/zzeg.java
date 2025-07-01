package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeg implements zzdl {
    private Message zza;

    private zzeg() {
        throw null;
    }

    /* synthetic */ zzeg(zzeh zzeh) {
    }

    public final zzeg zzb(Message message, zzei zzei) {
        this.zza = message;
        return this;
    }

    public final void zza() {
        Message message = this.zza;
        message.getClass();
        Message message2 = message;
        message.sendToTarget();
        this.zza = null;
        zzei.zzl(this);
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        Message message2 = message;
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzei.zzl(this);
        return sendMessageAtFrontOfQueue;
    }
}
