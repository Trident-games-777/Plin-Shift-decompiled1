package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjc {
    public static final /* synthetic */ int zza = 0;
    private static final zzgfx zzb = zzgmx.zzd("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzgfm.class, zzgty.SYMMETRIC, zzgva.zzg());
    private static final zzgno zzc = new zzgja();
    private static final zzgom zzd = zzgom.zzb(new zzgjb(), zzgjl.class, zzgfm.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            int i = zzgjv.zza;
            zzgjv.zze(zzgnz.zzc());
            zzgnp.zzb().zzc(zzc, zzgjq.class);
            zzgnw.zza().zze(zzd);
            zzgmo.zzc().zzd(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }
}
