package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcqp implements zzhfx {
    private final zzhgp zza;

    public zzcqp(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    /* renamed from: zza */
    public final Boolean zzb() {
        zzffo zza2 = ((zzcwd) this.zza).zza();
        zzffo zzffo = zza2;
        boolean z = true;
        if (zza2.zza() == null) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfy)).booleanValue()) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
