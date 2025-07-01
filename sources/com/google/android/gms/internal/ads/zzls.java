package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzls {
    public static final zzls zza;
    public static final zzls zzb;
    public final long zzc;
    public final long zzd;

    static {
        zzls zzls = new zzls(0, 0);
        zza = zzls;
        new zzls(Long.MAX_VALUE, Long.MAX_VALUE);
        new zzls(Long.MAX_VALUE, 0);
        new zzls(0, Long.MAX_VALUE);
        zzb = zzls;
    }

    public zzls(long j, long j2) {
        boolean z = true;
        zzdb.zzd(j >= 0);
        zzdb.zzd(j2 < 0 ? false : z);
        this.zzc = j;
        this.zzd = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzls zzls = (zzls) obj;
            return this.zzc == zzls.zzc && this.zzd == zzls.zzd;
        }
    }

    public final int hashCode() {
        return (((int) this.zzc) * 31) + ((int) this.zzd);
    }
}
