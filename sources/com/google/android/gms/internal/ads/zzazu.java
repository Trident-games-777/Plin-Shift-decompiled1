package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzazu {
    final long zza;
    final String zzb;
    final int zzc;

    zzazu(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzazu)) {
            zzazu zzazu = (zzazu) obj;
            return zzazu.zza == this.zza && zzazu.zzc == this.zzc;
        }
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
