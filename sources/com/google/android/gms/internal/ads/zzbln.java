package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbln implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcao zza;

    zzbln(zzblo zzblo, zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zzd(new RuntimeException("Connection failed."));
    }
}
