package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzgnn implements zzgno {
    public final zzgfw zza(zzggj zzggj, Integer num) {
        int i = zzgnp.zza;
        zzgue zzc = ((zzgna) zzggj).zzb().zzc();
        zzgfx zzb = zzgmo.zzc().zzb(zzc.zzi());
        if (zzgmo.zzc().zze(zzc.zzi())) {
            zzgua zza = zzb.zza(zzc.zzh());
            return new zzgmz(zzgow.zza(zza.zzg(), zza.zzf(), zza.zzb(), zzc.zzg(), num), zzgfv.zza());
        }
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }
}
