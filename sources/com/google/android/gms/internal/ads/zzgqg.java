package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgqg {
    private static final zzgom zza = zzgom.zzb(new zzgqc(), zzgqb.class, zzgpv.class);
    private static final zzgom zzb = zzgom.zzb(new zzgqd(), zzgqb.class, zzggi.class);
    private static final zzgfx zzc = zzgmx.zzd("type.googleapis.com/google.crypto.tink.HmacKey", zzggi.class, zzgty.SYMMETRIC, zzgtq.zzi());
    private static final zzgnq zzd = new zzgqe();
    private static final zzgno zze = new zzgqf();
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgmh.zza(i)) {
            int i2 = zzgrl.zza;
            zzgrl.zze(zzgnz.zzc());
            zzgnw.zza().zze(zza);
            zzgnw.zza().zze(zzb);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("HMAC_SHA256_128BITTAG", zzgqy.zza);
            zzgqh zzgqh = new zzgqh((zzgqk) null);
            zzgqh.zzb(32);
            zzgqh.zzc(16);
            zzgqh.zzd(zzgqj.zzd);
            zzgqh.zza(zzgqi.zzc);
            hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzgqh.zze());
            zzgqh zzgqh2 = new zzgqh((zzgqk) null);
            zzgqh2.zzb(32);
            zzgqh2.zzc(32);
            zzgqh2.zzd(zzgqj.zza);
            zzgqh2.zza(zzgqi.zzc);
            hashMap.put("HMAC_SHA256_256BITTAG", zzgqh2.zze());
            zzgqh zzgqh3 = new zzgqh((zzgqk) null);
            zzgqh3.zzb(32);
            zzgqh3.zzc(32);
            zzgqh3.zzd(zzgqj.zzd);
            zzgqh3.zza(zzgqi.zzc);
            hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzgqh3.zze());
            zzgqh zzgqh4 = new zzgqh((zzgqk) null);
            zzgqh4.zzb(64);
            zzgqh4.zzc(16);
            zzgqh4.zzd(zzgqj.zza);
            zzgqh4.zza(zzgqi.zze);
            hashMap.put("HMAC_SHA512_128BITTAG", zzgqh4.zze());
            zzgqh zzgqh5 = new zzgqh((zzgqk) null);
            zzgqh5.zzb(64);
            zzgqh5.zzc(16);
            zzgqh5.zzd(zzgqj.zzd);
            zzgqh5.zza(zzgqi.zze);
            hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzgqh5.zze());
            zzgqh zzgqh6 = new zzgqh((zzgqk) null);
            zzgqh6.zzb(64);
            zzgqh6.zzc(32);
            zzgqh6.zzd(zzgqj.zza);
            zzgqh6.zza(zzgqi.zze);
            hashMap.put("HMAC_SHA512_256BITTAG", zzgqh6.zze());
            zzgqh zzgqh7 = new zzgqh((zzgqk) null);
            zzgqh7.zzb(64);
            zzgqh7.zzc(32);
            zzgqh7.zzd(zzgqj.zzd);
            zzgqh7.zza(zzgqi.zze);
            hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzgqh7.zze());
            hashMap.put("HMAC_SHA512_512BITTAG", zzgqy.zzb);
            zzgqh zzgqh8 = new zzgqh((zzgqk) null);
            zzgqh8.zzb(64);
            zzgqh8.zzc(64);
            zzgqh8.zzd(zzgqj.zzd);
            zzgqh8.zza(zzgqi.zze);
            hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzgqh8.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnp.zzb().zzc(zze, zzgql.class);
            zzgnr.zza().zzb(zzd, zzgql.class);
            zzgmo.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
