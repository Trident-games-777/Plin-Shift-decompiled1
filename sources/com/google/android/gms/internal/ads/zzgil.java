package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgil {
    private static final zzgom zza = zzgom.zzb(new zzgii(), zzgih.class, zzgfm.class);
    private static final zzgno zzb = new zzgij();
    private static final zzgnq zzc = new zzgik();
    private static final zzgfx zzd = zzgmx.zzd("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzgfm.class, zzgty.SYMMETRIC, zzgtd.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzgli.zza;
            zzgli.zze(zzgnz.zzc());
            if (zzb()) {
                zzgnw.zza().zze(zza);
                zzgnv zzb2 = zzgnv.zzb();
                HashMap hashMap = new HashMap();
                zzgim zzgim = new zzgim((zzgio) null);
                zzgim.zza(16);
                zzgim.zzb(zzgin.zza);
                hashMap.put("AES128_GCM_SIV", zzgim.zzc());
                zzgim zzgim2 = new zzgim((zzgio) null);
                zzgim2.zza(16);
                zzgim2.zzb(zzgin.zzc);
                hashMap.put("AES128_GCM_SIV_RAW", zzgim2.zzc());
                zzgim zzgim3 = new zzgim((zzgio) null);
                zzgim3.zza(32);
                zzgim3.zzb(zzgin.zza);
                hashMap.put("AES256_GCM_SIV", zzgim3.zzc());
                zzgim zzgim4 = new zzgim((zzgio) null);
                zzgim4.zza(32);
                zzgim4.zzb(zzgin.zzc);
                hashMap.put("AES256_GCM_SIV_RAW", zzgim4.zzc());
                zzb2.zzd(Collections.unmodifiableMap(hashMap));
                zzgnr.zza().zzb(zzc, zzgip.class);
                zzgnp.zzb().zzc(zzb, zzgip.class);
                zzgmo.zzc().zzd(zzd, true);
                return;
            }
            return;
        }
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }

    private static boolean zzb() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
