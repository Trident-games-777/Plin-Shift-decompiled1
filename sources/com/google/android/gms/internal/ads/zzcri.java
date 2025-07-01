package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcri {
    private final zzcze zza;
    private final zzdbk zzb;

    public zzcri(zzcze zzcze, zzdbk zzdbk) {
        this.zza = zzcze;
        this.zzb = zzdbk;
    }

    public final zzcze zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzdbk zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzded zzc() {
        zzdbk zzdbk = this.zzb;
        if (zzdbk != null) {
            return new zzded(zzdbk, zzcaj.zzf);
        }
        return new zzded(new zzcrh(this), zzcaj.zzf);
    }
}
