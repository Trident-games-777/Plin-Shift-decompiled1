package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzftd;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzf extends zzftd {
    public zzf(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzv.zzp().zzw(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th) {
            zzv.zzq();
            zzs.zzM(zzv.zzp().zzd(), th);
            throw th;
        }
    }
}
