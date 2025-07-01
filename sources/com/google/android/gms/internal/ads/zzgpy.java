package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpy implements zzgov {
    private static final zzgpy zza = new zzgpy();

    private zzgpy() {
    }

    static void zzd() throws GeneralSecurityException {
        zzgnw.zza().zzf(zza);
    }

    public final Class zza() {
        return zzgpv.class;
    }

    public final Class zzb() {
        return zzgpv.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzgou zzgou) throws GeneralSecurityException {
        if (zzgou.zzc() != null) {
            for (List<zzgos> it : zzgou.zze()) {
                for (zzgos zzd : it) {
                    zzgpv zzgpv = (zzgpv) zzd.zzd();
                }
            }
            return new zzgpw(zzgou, (zzgpx) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
