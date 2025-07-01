package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbas implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbat zza;

    zzbas(zzbat zzbat) {
        this.zza = zzbat;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbat zzbat = this.zza;
            if (zzbat.zzd != null) {
                zzbat.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
