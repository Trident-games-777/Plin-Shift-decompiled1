package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzggv implements zzgfm {
    private final zzgou zza;

    /* synthetic */ zzggv(zzgou zzgou, zzggw zzggw) {
        this.zza = zzgou;
        if (zzgou.zzg()) {
            zzgnf zza2 = zzgnu.zzb().zza();
            zzgnj zza3 = zzgnm.zza(zzgou);
            zza2.zza(zza3, "aead", "encrypt");
            zza2.zza(zza3, "aead", "decrypt");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzgos zzgos : this.zza.zzf(Arrays.copyOf(bArr, 5))) {
                try {
                    byte[] zza2 = ((zzgfm) zzgos.zzd()).zza(bArr, bArr2);
                    zzgos.zza();
                    int length = bArr.length;
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzgos zzgos2 : this.zza.zzf(zzgfr.zza)) {
            try {
                byte[] zza3 = ((zzgfm) zzgos2.zzd()).zza(bArr, bArr2);
                zzgos2.zza();
                int length2 = bArr.length;
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
