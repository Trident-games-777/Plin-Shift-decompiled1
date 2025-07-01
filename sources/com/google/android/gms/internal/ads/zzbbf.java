package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbbf implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbax zza;
    final /* synthetic */ zzcao zzb;
    final /* synthetic */ zzbbh zzc;

    zzbbf(zzbbh zzbbh, zzbax zzbax, zzcao zzcao) {
        this.zza = zzbax;
        this.zzb = zzcao;
        this.zzc = zzbbh;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbbh zzbbh = this.zzc;
            if (!zzbbh.zzb) {
                zzbbh.zzb = true;
                zzbaw zza2 = this.zzc.zza;
                if (zza2 != null) {
                    this.zzb.addListener(new zzbbd(this, zzcaj.zza.zza(new zzbbc(this, zza2))), zzcaj.zzf);
                }
            }
        }
    }
}
