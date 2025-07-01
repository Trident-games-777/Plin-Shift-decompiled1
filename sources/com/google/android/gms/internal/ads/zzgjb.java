package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzgjb implements zzgok {
    public final Object zza(zzgfw zzgfw) {
        zzgjl zzgjl = (zzgjl) zzgfw;
        int i = zzgjc.zza;
        String zzd = zzgjl.zzb().zzd();
        zzggt zzb = zzgjl.zzb().zzb();
        zzgfm zzb2 = zzggh.zza(zzd).zzb();
        int i2 = zzgiz.zza;
        try {
            return zzglx.zzc(new zzgiz(zzgue.zzf(zzggp.zzb(zzb), zzgyh.zza()), zzb2), zzgjl.zzc());
        } catch (zzgzm e) {
            throw new GeneralSecurityException(e);
        }
    }
}
