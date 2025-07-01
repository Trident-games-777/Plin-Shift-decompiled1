package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfvm implements IBinder.DeathRecipient {
    public final /* synthetic */ zzfvu zza;

    public /* synthetic */ zzfvm(zzfvu zzfvu) {
        this.zza = zzfvu;
    }

    public final void binderDied() {
        this.zza.zzk();
    }
}
