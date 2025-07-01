package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzflw extends zzfmo {
    public zzflw(ClientApi clientApi, Context context, int i, zzbpg zzbpg, zzft zzft, zzcf zzcf, ScheduledExecutorService scheduledExecutorService, zzflx zzflx, Clock clock) {
        super(clientApi, context, i, zzbpg, zzft, zzcf, scheduledExecutorService, zzflx, clock);
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zza() {
        ClientApi clientApi = this.zza;
        zzgfa zze = zzgfa.zze();
        zzby zzc = clientApi.zzc(ObjectWrapper.wrap(this.zzb), zzs.zzb(), this.zze.zza, this.zzd, this.zzc);
        if (zzc != null) {
            try {
                zzc.zzH(new zzflv(this, zze, this.zze));
                zzc.zzab(this.zze.zzc);
                return zze;
            } catch (RemoteException e) {
                zzm.zzk("Failed to load app open ad.", e);
                zze.zzd(new zzflt(1, "remote exception"));
                return zze;
            }
        } else {
            zze.zzd(new zzflt(1, "Failed to create an app open ad manager."));
            return zze;
        }
    }
}
