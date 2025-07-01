package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzghz implements zzgno {
    public final zzgfw zza(zzggj zzggj, Integer num) {
        zzgie zzgie = (zzgie) zzggj;
        int i = zzgia.zza;
        if (zzgie.zzb() != 24) {
            zzghu zzghu = new zzghu((zzghv) null);
            zzghu.zzc(zzgie);
            zzghu.zza(num);
            zzghu.zzb(zzgwv.zzc(zzgie.zzb()));
            return zzghu.zzd();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }
}
