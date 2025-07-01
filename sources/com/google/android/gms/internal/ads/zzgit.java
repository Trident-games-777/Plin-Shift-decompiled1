package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgit {
    public static final /* synthetic */ int zza = 0;
    private static final zzgom zzb = zzgom.zzb(new zzgir(), zzgiq.class, zzgfm.class);
    private static final zzgno zzc = new zzgis();
    private static final zzgfx zzd = zzgmx.zzd("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzgfm.class, zzgty.SYMMETRIC, zzgtj.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzglp.zza;
            zzglp.zze(zzgnz.zzc());
            zzgnw.zza().zze(zzb);
            zzgnp.zzb().zzc(zzc, zzgiv.class);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("CHACHA20_POLY1305", zzgiv.zzc(zzgiu.zza));
            hashMap.put("CHACHA20_POLY1305_RAW", zzgiv.zzc(zzgiu.zzc));
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgmo.zzc().zzd(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
    }
}
