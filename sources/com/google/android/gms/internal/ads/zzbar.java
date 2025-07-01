package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbar implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbat zza;

    zzbar(zzbat zzbat) {
        this.zza = zzbat;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbat zzbat = this.zza;
                if (zzbat.zzd != null) {
                    zzbat.zzf = zzbat.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zzm.zzh("Unable to obtain a cache service instance.", e);
                zzbat.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
