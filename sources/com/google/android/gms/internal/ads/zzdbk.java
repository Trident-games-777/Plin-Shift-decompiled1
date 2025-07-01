package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdbk implements zzczj {
    private int zza = ((Integer) zzbe.zzc().zza(zzbcn.zzbn)).intValue();
    private int zzb = ((Integer) zzbe.zzc().zza(zzbcn.zzmz)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    public final void zzdn(zzbvx zzbvx) {
    }

    public final synchronized void zzdo(zzfff zzfff) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbo)).booleanValue()) {
            try {
                zzfew zzfew = zzfff.zzb.zzb;
                this.zza = zzfew.zzc;
                this.zzb = zzfew.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}
