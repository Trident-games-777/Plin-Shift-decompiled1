package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzghd implements zzgno {
    public final zzgfw zza(zzggj zzggj, Integer num) {
        zzghj zzghj = (zzghj) zzggj;
        int i = zzghe.zza;
        if (zzghj.zzb() == 16 || zzghj.zzb() == 32) {
            zzggy zzggy = new zzggy((zzggz) null);
            zzggy.zzd(zzghj);
            zzggy.zzc(num);
            zzggy.zza(zzgwv.zzc(zzghj.zzb()));
            zzggy.zzb(zzgwv.zzc(zzghj.zzc()));
            return zzggy.zze();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }
}
