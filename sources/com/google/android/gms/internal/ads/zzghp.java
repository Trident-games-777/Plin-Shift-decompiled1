package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzghp {
    public static final /* synthetic */ int zza = 0;
    private static final zzgom zzb = zzgom.zzb(new zzghn(), zzghm.class, zzgfm.class);
    private static final zzgfx zzc = zzgmx.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgfm.class, zzgty.SYMMETRIC, zzgso.zzh());
    private static final zzgno zzd = new zzgho();

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzgkw.zza;
            zzgkw.zze(zzgnz.zzc());
            zzgnw.zza().zze(zzb);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_EAX", zzgkd.zzc);
            zzghq zzghq = new zzghq((zzghs) null);
            zzghq.zza(16);
            zzghq.zzb(16);
            zzghq.zzc(16);
            zzghq.zzd(zzghr.zzc);
            hashMap.put("AES128_EAX_RAW", zzghq.zze());
            hashMap.put("AES256_EAX", zzgkd.zzd);
            zzghq zzghq2 = new zzghq((zzghs) null);
            zzghq2.zza(16);
            zzghq2.zzb(32);
            zzghq2.zzc(16);
            zzghq2.zzd(zzghr.zzc);
            hashMap.put("AES256_EAX_RAW", zzghq2.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnp.zzb().zzc(zzd, zzght.class);
            zzgmo.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }
}
