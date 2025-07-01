package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgfz {
    public static final zzggj zza(zzggj zzggj) throws GeneralSecurityException {
        return zzggj != null ? zzggj : zzggp.zza(zzb((zzggj) null).zzaV());
    }

    static final zzgue zzb(zzggj zzggj) {
        try {
            return ((zzgox) zzgnz.zzc().zze((zzggj) null, zzgox.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgpi("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
