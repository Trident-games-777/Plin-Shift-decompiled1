package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjq extends zzggt {
    private final zzgjo zza;
    private final String zzb;
    private final zzgjn zzc;
    private final zzggt zzd;

    /* synthetic */ zzgjq(zzgjo zzgjo, String str, zzgjn zzgjn, zzggt zzggt, zzgjp zzgjp) {
        this.zza = zzgjo;
        this.zzb = str;
        this.zzc = zzgjn;
        this.zzd = zzggt;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjq)) {
            return false;
        }
        zzgjq zzgjq = (zzgjq) obj;
        if (!zzgjq.zzc.equals(this.zzc) || !zzgjq.zzd.equals(this.zzd) || !zzgjq.zzb.equals(this.zzb) || !zzgjq.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgjq.class, this.zzb, this.zzc, this.zzd, this.zza});
    }

    public final String toString() {
        zzgjo zzgjo = this.zza;
        zzggt zzggt = this.zzd;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(zzggt);
        String valueOf3 = String.valueOf(zzgjo);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zzb + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ", variant: " + valueOf3 + ")";
    }

    public final boolean zza() {
        return this.zza != zzgjo.zzb;
    }

    public final zzggt zzb() {
        return this.zzd;
    }

    public final zzgjo zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }
}
