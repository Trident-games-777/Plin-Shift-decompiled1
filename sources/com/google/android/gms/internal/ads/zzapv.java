package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzapv {
    public final Object zza;
    public final zzaoy zzb;
    public final zzapy zzc;
    public boolean zzd;

    private zzapv(zzapy zzapy) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzapy;
    }

    private zzapv(Object obj, zzaoy zzaoy) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaoy;
        this.zzc = null;
    }

    public static zzapv zza(zzapy zzapy) {
        return new zzapv(zzapy);
    }

    public static zzapv zzb(Object obj, zzaoy zzaoy) {
        return new zzapv(obj, zzaoy);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
