package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbzp implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcao zzb;

    zzbzp(zzbzq zzbzq, Context context, zzcao zzcao) {
        this.zza = context;
        this.zzb = zzcao;
    }

    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            zzm.zzh("Exception while getting advertising Id info", e);
        }
    }
}
