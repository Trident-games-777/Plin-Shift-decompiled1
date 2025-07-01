package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzehg implements zzdgv {
    private final zzfet zza;
    private final zzbrf zzb;
    private final AdFormat zzc;
    private zzcxe zzd = null;

    zzehg(zzfet zzfet, zzbrf zzbrf, AdFormat adFormat) {
        this.zza = zzfet;
        this.zzb = zzbrf;
        this.zzc = adFormat;
    }

    public final void zza(boolean z, Context context, zzcwz zzcwz) throws zzdgu {
        boolean z2;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal == 1) {
                z2 = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else if (ordinal != 2) {
                if (ordinal == 5) {
                    z2 = this.zzb.zzr(ObjectWrapper.wrap(context));
                }
                throw new zzdgu("Adapter failed to show.");
            } else {
                z2 = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (z2) {
                if (this.zzd != null) {
                    if (!((Boolean) zzbe.zzc().zza(zzbcn.zzbC)).booleanValue() && this.zza.zzY == 2) {
                        this.zzd.zza();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new zzdgu("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdgu(th);
        }
    }

    public final void zzb(zzcxe zzcxe) {
        this.zzd = zzcxe;
    }
}
