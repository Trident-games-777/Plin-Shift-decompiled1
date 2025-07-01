package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzae {
    private final zzm zza;
    private final int zzb;
    private final int zzc;
    private float zzd = 1.0f;

    public zzae(zzm zzm, int i, int i2) {
        this.zza = zzm;
        this.zzb = i;
        this.zzc = i2;
    }

    public final zzae zza(float f) {
        this.zzd = f;
        return this;
    }

    public final zzag zzb() {
        return new zzag(this.zza, this.zzb, this.zzc, this.zzd, 0, (zzaf) null);
    }
}
