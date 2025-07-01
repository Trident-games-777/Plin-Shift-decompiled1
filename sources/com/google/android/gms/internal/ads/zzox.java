package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzox {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;

    public final zzox zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzox zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzox zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzoz zzd() {
        if (this.zza || (!this.zzb && !this.zzc)) {
            return new zzoz(this, (zzoy) null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
