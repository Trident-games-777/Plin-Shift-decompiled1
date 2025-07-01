package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgiy {
    public static final /* synthetic */ int zza = 0;
    private static final zzgom zzb = zzgom.zzb(new zzgiw(), zzgjd.class, zzgfm.class);
    private static final zzgfx zzc = zzgmx.zzd("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzgfm.class, zzgty.REMOTE, zzguu.zzg());
    private static final zzgno zzd = new zzgix();

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzgjk.zza;
            zzgjk.zze(zzgnz.zzc());
            zzgnw.zza().zze(zzb);
            zzgnp.zzb().zzc(zzd, zzgjf.class);
            zzgmo.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
    }
}
