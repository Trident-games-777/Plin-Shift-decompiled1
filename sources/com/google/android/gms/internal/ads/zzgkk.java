package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgkk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgom zzb = zzgom.zzb(new zzgkh(), zzgkg.class, zzgfm.class);
    private static final zzgfx zzc = zzgmx.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzgfm.class, zzgty.SYMMETRIC, zzgvk.zzg());
    private static final zzgnq zzd = new zzgki();
    private static final zzgno zze = new zzgkj();

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzgme.zza;
            zzgme.zze(zzgnz.zzc());
            zzgnw.zza().zze(zzb);
            zzgnv zzb2 = zzgnv.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("XCHACHA20_POLY1305", zzgkm.zzc(zzgkl.zza));
            hashMap.put("XCHACHA20_POLY1305_RAW", zzgkm.zzc(zzgkl.zzc));
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnp.zzb().zzc(zze, zzgkm.class);
            zzgnr.zza().zzb(zzd, zzgkm.class);
            zzgmo.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
    }
}
