package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzecj implements zzcya, zzcwp {
    private static final Object zza = new Object();
    private static int zzb;
    private final zzg zzc;
    private final zzect zzd;

    public zzecj(zzect zzect, zzg zzg) {
        this.zzd = zzect;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue() && !this.zzc.zzN()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                intValue = ((Integer) zzbe.zzc().zza(zzbcn.zzgd)).intValue();
            }
            if (i < intValue) {
                this.zzd.zzd(z);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    public final void zzdB(zze zze) {
        zzb(false);
    }

    public final void zzs() {
        zzb(true);
    }
}
