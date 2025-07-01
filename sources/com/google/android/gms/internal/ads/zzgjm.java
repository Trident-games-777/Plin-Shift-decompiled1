package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjm {
    @Nullable
    private zzgjo zza;
    @Nullable
    private String zzb;
    @Nullable
    private zzgjn zzc;
    @Nullable
    private zzggt zzd;

    private zzgjm() {
        throw null;
    }

    /* synthetic */ zzgjm(zzgjp zzgjp) {
    }

    public final zzgjm zza(zzggt zzggt) {
        this.zzd = zzggt;
        return this;
    }

    public final zzgjm zzb(zzgjn zzgjn) {
        this.zzc = zzgjn;
        return this;
    }

    public final zzgjm zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzgjm zzd(zzgjo zzgjo) {
        this.zza = zzgjo;
        return this;
    }

    public final zzgjq zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzgjo.zzb;
        }
        if (this.zzb != null) {
            zzgjn zzgjn = this.zzc;
            if (zzgjn != null) {
                zzggt zzggt = this.zzd;
                if (zzggt == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (zzggt.zza()) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
                } else if ((zzgjn.equals(zzgjn.zza) && (zzggt instanceof zzgie)) || ((zzgjn.equals(zzgjn.zzc) && (zzggt instanceof zzgiv)) || ((zzgjn.equals(zzgjn.zzb) && (zzggt instanceof zzgkm)) || ((zzgjn.equals(zzgjn.zzd) && (zzggt instanceof zzghj)) || ((zzgjn.equals(zzgjn.zze) && (zzggt instanceof zzght)) || (zzgjn.equals(zzgjn.zzf) && (zzggt instanceof zzgip))))))) {
                    return new zzgjq(this.zza, this.zzb, this.zzc, this.zzd, (zzgjp) null);
                } else {
                    String zzgjn2 = this.zzc.toString();
                    String valueOf = String.valueOf(this.zzd);
                    throw new GeneralSecurityException("Cannot use parsing strategy " + zzgjn2 + " when new keys are picked according to " + valueOf + ".");
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        } else {
            throw new GeneralSecurityException("kekUri must be set");
        }
    }
}
