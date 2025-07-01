package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbzw extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzbzz zza;

    zzbzw(zzbzz zzbzz) {
        this.zza = zzbzz;
    }

    public final void onAvailable(Network network) {
        this.zza.zzo.set(true);
    }

    public final void onLost(Network network) {
        this.zza.zzo.set(false);
    }
}
