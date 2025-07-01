package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgia {
    public static final /* synthetic */ int zza = 0;
    private static final zzgom zzb = zzgom.zzb(new zzghx(), zzghw.class, zzgfm.class);
    private static final zzgfx zzc = zzgmx.zzd("type.googleapis.com/google.crypto.tink.AesGcmKey", zzgfm.class, zzgty.SYMMETRIC, zzgsx.zzg());
    private static final zzgnq zzd = new zzghy();
    private static final zzgno zze = new zzghz();
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgmh.zza(i)) {
            int i2 = zzgld.zza;
            zzgld.zze(zzgnz.zzc());
            zzgnw.zza().zze(zzb);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_GCM", zzgkd.zza);
            zzgib zzgib = new zzgib((zzgid) null);
            zzgib.zza(12);
            zzgib.zzb(16);
            zzgib.zzc(16);
            zzgib.zzd(zzgic.zzc);
            hashMap.put("AES128_GCM_RAW", zzgib.zze());
            hashMap.put("AES256_GCM", zzgkd.zzb);
            zzgib zzgib2 = new zzgib((zzgid) null);
            zzgib2.zza(12);
            zzgib2.zzb(32);
            zzgib2.zzc(16);
            zzgib2.zzd(zzgic.zzc);
            hashMap.put("AES256_GCM_RAW", zzgib2.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnr.zza().zzb(zzd, zzgie.class);
            zzgnp.zzb().zzc(zze, zzgie.class);
            zzgmo.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }
}
