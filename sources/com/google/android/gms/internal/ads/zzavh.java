package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzavh extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzavi zza;

    zzavh(zzavi zzavi) {
        this.zza = zzavi;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzavi.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzavi.class) {
            this.zza.zza = null;
        }
    }
}
