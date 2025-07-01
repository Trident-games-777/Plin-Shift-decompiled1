package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzghe {
    public static final /* synthetic */ int zza = 0;
    private static final zzgom zzb = zzgom.zzb(new zzghb(), zzgha.class, zzgfm.class);
    private static final zzgfx zzc = zzgmx.zzd("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzgfm.class, zzgty.SYMMETRIC, zzgrz.zzh());
    private static final zzgnq zzd = new zzghc();
    private static final zzgno zze = new zzghd();
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgmh.zza(i)) {
            int i2 = zzgkr.zza;
            zzgkr.zze(zzgnz.zzc());
            zzgnw.zza().zze(zzb);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_CTR_HMAC_SHA256", zzgkd.zze);
            zzghf zzghf = new zzghf((zzghi) null);
            zzghf.zza(16);
            zzghf.zzc(32);
            zzghf.zze(16);
            zzghf.zzd(16);
            zzghf.zzb(zzghg.zzc);
            zzghf.zzf(zzghh.zzc);
            hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzghf.zzg());
            hashMap.put("AES256_CTR_HMAC_SHA256", zzgkd.zzf);
            zzghf zzghf2 = new zzghf((zzghi) null);
            zzghf2.zza(32);
            zzghf2.zzc(32);
            zzghf2.zze(32);
            zzghf2.zzd(16);
            zzghf2.zzb(zzghg.zzc);
            zzghf2.zzf(zzghh.zzc);
            hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzghf2.zzg());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnr.zza().zzb(zzd, zzghj.class);
            zzgnp.zzb().zzc(zze, zzghj.class);
            zzgmo.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
