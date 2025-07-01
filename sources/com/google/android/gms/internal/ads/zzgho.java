package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzgho implements zzgno {
    public final zzgfw zza(zzggj zzggj, Integer num) {
        zzght zzght = (zzght) zzggj;
        int i = zzghp.zza;
        if (zzght.zzc() != 24) {
            zzghk zzghk = new zzghk((zzghl) null);
            zzghk.zzc(zzght);
            zzghk.zza(num);
            zzghk.zzb(zzgwv.zzc(zzght.zzc()));
            return zzghk.zzd();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }
}
