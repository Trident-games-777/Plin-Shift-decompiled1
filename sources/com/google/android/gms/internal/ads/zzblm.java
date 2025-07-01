package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzblm implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcao zza;
    final /* synthetic */ zzblo zzb;

    zzblm(zzblo zzblo, zzcao zzcao) {
        this.zza = zzcao;
        this.zzb = zzblo;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException("onConnectionSuspended: " + i));
    }
}
