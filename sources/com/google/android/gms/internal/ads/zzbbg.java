package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbbg implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcao zza;
    final /* synthetic */ zzbbh zzb;

    zzbbg(zzbbh zzbbh, zzcao zzcao) {
        this.zza = zzcao;
        this.zzb = zzbbh;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
