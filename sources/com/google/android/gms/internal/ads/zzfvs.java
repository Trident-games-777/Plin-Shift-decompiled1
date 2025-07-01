package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfvs implements ServiceConnection {
    final /* synthetic */ zzfvu zza;

    /* synthetic */ zzfvs(zzfvu zzfvu, zzfvt zzfvt) {
        this.zza = zzfvu;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zza.zzc.zzc("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        this.zza.zzo(new zzfvq(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zzc.zzc("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        this.zza.zzo(new zzfvr(this));
    }
}
