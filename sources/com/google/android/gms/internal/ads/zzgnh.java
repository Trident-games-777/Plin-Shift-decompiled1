package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnh {
    private final zzgfy zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzgnh(zzgfy zzgfy, int i, String str, String str2, zzgni zzgni) {
        this.zza = zzgfy;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnh)) {
            return false;
        }
        zzgnh zzgnh = (zzgnh) obj;
        if (this.zza != zzgnh.zza || this.zzb != zzgnh.zzb || !this.zzc.equals(zzgnh.zzc) || !this.zzd.equals(zzgnh.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final int zza() {
        return this.zzb;
    }
}
