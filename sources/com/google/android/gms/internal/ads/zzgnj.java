package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnj {
    private final zzgnd zza;
    private final List zzb;
    @Nullable
    private final Integer zzc;

    /* synthetic */ zzgnj(zzgnd zzgnd, List list, Integer num, zzgni zzgni) {
        this.zza = zzgnd;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnj)) {
            return false;
        }
        zzgnj zzgnj = (zzgnj) obj;
        if (!this.zza.equals(zzgnj.zza) || !this.zzb.equals(zzgnj.zzb) || !Objects.equals(this.zzc, zzgnj.zzc)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
