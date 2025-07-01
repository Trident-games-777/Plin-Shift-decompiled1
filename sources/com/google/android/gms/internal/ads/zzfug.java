package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfug extends zzfvj {
    private String zza;
    private String zzb;

    zzfug() {
    }

    public final zzfvj zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfvj zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzfvk zzc() {
        return new zzfui(this.zza, this.zzb, (zzfuh) null);
    }
}
