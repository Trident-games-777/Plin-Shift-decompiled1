package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfms extends zzfmo {
    public zzfms(ClientApi clientApi, Context context, int i, zzbpg zzbpg, zzft zzft, zzcf zzcf, ScheduledExecutorService scheduledExecutorService, zzflx zzflx, Clock clock) {
        super(clientApi, context, i, zzbpg, zzft, zzcf, scheduledExecutorService, zzflx, clock);
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zza() {
        ClientApi clientApi = this.zza;
        zzgfa zze = zzgfa.zze();
        zzbxc zzp = clientApi.zzp(ObjectWrapper.wrap(this.zzb), this.zze.zza, this.zzd, this.zzc);
        zzfmr zzfmr = new zzfmr(this, zze, zzp);
        if (zzp != null) {
            try {
                zzp.zzf(this.zze.zzc, zzfmr);
                return zze;
            } catch (RemoteException unused) {
                zzm.zzj("Failed to load rewarded ad.");
                zze.zzd(new zzflt(1, "remote exception"));
                return zze;
            }
        } else {
            zze.zzd(new zzflt(1, "Failed to create a rewarded ad."));
            return zze;
        }
    }
}
