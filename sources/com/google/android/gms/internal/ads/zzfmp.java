package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmp {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ScheduledExecutorService zzc;
    private final ClientApi zzd = new ClientApi();
    private zzbpg zze;
    private final Clock zzf;

    zzfmp(Context context, VersionInfoParcel versionInfoParcel, ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = scheduledExecutorService;
        this.zzf = clock;
    }

    private static zzflx zzc() {
        return new zzflx(((Long) zzbe.zzc().zza(zzbcn.zzu)).longValue(), 2.0d, ((Long) zzbe.zzc().zza(zzbcn.zzv)).longValue(), 0.2d);
    }

    public final zzfmo zza(zzft zzft, zzcf zzcf) {
        AdFormat adFormat = AdFormat.getAdFormat(zzft.zzb);
        if (adFormat == null) {
            return null;
        }
        int ordinal = adFormat.ordinal();
        if (ordinal == 1) {
            return new zzflz(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzft, zzcf, this.zzc, zzc(), this.zzf);
        } else if (ordinal == 2) {
            return new zzfms(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzft, zzcf, this.zzc, zzc(), this.zzf);
        } else if (ordinal != 5) {
            return null;
        } else {
            return new zzflw(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzft, zzcf, this.zzc, zzc(), this.zzf);
        }
    }

    public final void zzb(zzbpg zzbpg) {
        this.zze = zzbpg;
    }
}
