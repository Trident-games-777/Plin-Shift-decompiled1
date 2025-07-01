package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzecx implements zzfjs {
    private final zzecl zza;
    private final zzecp zzb;

    zzecx(zzecl zzecl, zzecp zzecp) {
        this.zza = zzecl;
        this.zzb = zzecp;
    }

    public final void zzd(zzfjl zzfjl, String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue() && zzfjl.RENDERER == zzfjl && this.zza.zzc() != 0) {
            this.zza.zzf(zzv.zzC().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdC(zzfjl zzfjl, String str) {
    }

    public final void zzdD(zzfjl zzfjl, String str, Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue() && zzfjl.RENDERER == zzfjl && this.zza.zzc() != 0) {
            this.zza.zzf(zzv.zzC().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdE(zzfjl zzfjl, String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue()) {
            if (zzfjl.RENDERER == zzfjl) {
                this.zza.zzg(zzv.zzC().elapsedRealtime());
            } else if (zzfjl.PRELOADED_LOADER == zzfjl || zzfjl.SERVER_TRANSACTION == zzfjl) {
                this.zza.zzh(zzv.zzC().elapsedRealtime());
                zzecp zzecp = this.zzb;
                zzecp.zza.zza(new zzeco(zzecp, this.zza.zzd()));
            }
        }
    }
}
