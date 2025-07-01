package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpq {
    private static final zzgno zza = new zzgpn();
    private static final zzgom zzb = zzgom.zzb(new zzgpo(), zzgpm.class, zzgpv.class);
    private static final zzgom zzc = zzgom.zzb(new zzgpp(), zzgpm.class, zzggi.class);
    private static final zzgfx zzd = zzgmx.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", zzggi.class, zzgty.SYMMETRIC, zzgrq.zzh());

    public static /* synthetic */ zzgpm zzb(zzgpu zzgpu, Integer num) {
        zze(zzgpu);
        zzgpk zzgpk = new zzgpk((zzgpl) null);
        zzgpk.zzc(zzgpu);
        zzgpk.zza(zzgwv.zzc(zzgpu.zzc()));
        zzgpk.zzb(num);
        return zzgpk.zzd();
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzgrd.zza;
            zzgrd.zze(zzgnz.zzc());
            zzgnp.zzb().zzc(zza, zzgpu.class);
            zzgnw.zza().zze(zzb);
            zzgnw.zza().zze(zzc);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES_CMAC", zzgqy.zzc);
            hashMap.put("AES256_CMAC", zzgqy.zzc);
            zzgpr zzgpr = new zzgpr((zzgpt) null);
            zzgpr.zza(32);
            zzgpr.zzb(16);
            zzgpr.zzc(zzgps.zzd);
            hashMap.put("AES256_CMAC_RAW", zzgpr.zzd());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgmo.zzc().zzd(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zze(zzgpu zzgpu) throws GeneralSecurityException {
        if (zzgpu.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
