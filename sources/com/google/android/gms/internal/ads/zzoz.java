package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzoz {
    public static final zzoz zza = new zzox().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzoz(zzox zzox, zzoy zzoy) {
        this.zzb = zzox.zza;
        this.zzc = zzox.zzb;
        this.zzd = zzox.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzoz zzoz = (zzoz) obj;
            return this.zzb == zzoz.zzb && this.zzc == zzoz.zzc && this.zzd == zzoz.zzd;
        }
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return ((z ? 1 : 0) << true) + (z2 ? 1 : 0) + z2 + (this.zzd ? 1 : 0);
    }
}
