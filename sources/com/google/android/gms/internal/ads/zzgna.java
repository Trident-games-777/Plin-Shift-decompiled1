package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgna extends zzggj {
    private final zzgox zza;

    public zzgna(zzgox zzgox) {
        this.zza = zzgox;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgna)) {
            return false;
        }
        zzgox zzgox = ((zzgna) obj).zza;
        if (!this.zza.zzc().zzg().equals(zzgox.zzc().zzg()) || !this.zza.zzc().zzi().equals(zzgox.zzc().zzi()) || !this.zza.zzc().zzh().equals(zzgox.zzc().zzh())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzgox zzgox = this.zza;
        return Objects.hash(new Object[]{zzgox.zzc(), zzgox.zzd()});
    }

    public final String toString() {
        String str;
        String zzi = this.zza.zzc().zzi();
        int ordinal = this.zza.zzc().zzg().ordinal();
        if (ordinal != 1) {
            str = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY";
        } else {
            str = "TINK";
        }
        return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{zzi, str});
    }

    public final boolean zza() {
        return this.zza.zzc().zzg() != zzgve.RAW;
    }

    public final zzgox zzb() {
        return this.zza;
    }
}
